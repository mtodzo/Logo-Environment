package commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ImportData {
	Map<String, Double> myVariables = new HashMap<>();
	
	public ArrayList<Map> importFile(String fileName) {
		ArrayList<Map> maps = new ArrayList<>();
		Map<String, String> commands = new HashMap<>();
		try {
			File f = new File(fileName);
			BufferedReader b = new BufferedReader(new FileReader(f));
			String readLine = "";
			while ((readLine = b.readLine()) != null) {
				String[] list = readLine.split(" = ");
				if(list[0].substring(0,1).equals(":")) {
					double value = Double.parseDouble(list[1]);
					myVariables.put(list[0], value);
				}
				else {
					commands.put(list[0], list[1]);	
				}
			}
		}
		catch(Exception e) {
			
		}
		maps.add(myVariables);
		maps.add(commands);
		return maps;
	}
}
