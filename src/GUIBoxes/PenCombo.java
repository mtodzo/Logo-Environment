package GUIBoxes;


import java.util.ArrayList;
import java.util.HashMap;

import Turtle.Turtle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public class PenCombo extends GUIComboBox {

	public PenCombo(Group root, double[] properties, String text) {
		super(root, properties, text);
		// TODO Auto-generated constructor stub
	}
	
	private ScreenBox mainTurtleScreen;
	private static ArrayList<Turtle> thisTurtleList;

	private final static ObservableList<String> options = FXCollections.observableArrayList("White", "Black", "Red",
			"Dark Green", "Blue", "Yellow", "Purple", "Orange");
	
	private static final HashMap<String, Color> colorMap = createColorMap();

	private static HashMap<String, Color> createColorMap() {
		HashMap<String, Color> colorMap = new HashMap<>();
		// first index = xPos, second = yPos, third = width, fourth = length
		colorMap.put("White", Color.WHITE);
		colorMap.put("Black", Color.BLACK);
		colorMap.put("Red", Color.RED);
		colorMap.put("Dark Green", Color.DARKGREEN);
		colorMap.put("Blue", Color.BLUE);
		colorMap.put("Yellow", Color.YELLOW);
		colorMap.put("Purple", Color.PURPLE);
		colorMap.put("Orange", Color.ORANGE);
		
		return colorMap;
	}

	public PenCombo(Group root, ArrayList<Turtle> turtleList, double[] properties, String title) {
		super(root, properties, title);
		thisTurtleList = turtleList;
		getCombobox().setItems(options);
		setupAction();
	}

	private void setupAction() {
		getCombobox().valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue ov, String t, String t1) {
				for (Turtle turt : thisTurtleList) {
		        	turt.changePenColor(colorMap.get(t1));
				}

			}
		});
	}
}
