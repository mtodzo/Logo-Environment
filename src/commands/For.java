package commands;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Turtle.Turtle;

public class For extends Command{
  private Map<String, Double> myMap;
  private static int numParams = 2;
  
 public For(Map<String, Double>variableMap){
	 myMap=variableMap;
 }
		@Override
		public double execute(List<CommandNode> children, Turtle t){
			
			double retVal=0;
			CommandNode bracketNode1 = children.get(0);
			List<CommandNode> bracket1children = bracketNode1.getChildren();
			CommandNode variable = bracket1children.get(0);
			
			double start = bracket1children.get(1).execute(t);
			double end = bracket1children.get(2).execute(t);
			double increment = bracket1children.get(3).execute(t);
			CommandNode bracketNode2 = children.get(1);
			variable.getCommand().setValue(start);
			
			for(int i =(int) start; i<end; i=i+ (int) increment) {	
			retVal =bracketNode2.execute(t);
			variable.getCommand().setValue(i+1);
			}
		return retVal;	
		}
		
		@Override
		public int getNumberOfParameters() {
			return numParams;
		}
        
		

	

}
