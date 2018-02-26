package Turtle;

import GUIBoxes.ScreenBox;
import Pen.Pen;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;


public class Turtle implements TurtleInterface{
    
	private final static double fixedImageHeight = 50;
    
	private ScreenBox screen;
	private Image image;
	private ImageView turtle = new ImageView();
	private boolean turtleShowing;
	private Pen pen;
	private boolean penShowing;
	
	public Turtle(ScreenBox turtle_screen, Image turtle_image) {
		screen = turtle_screen;
		image = turtle_image;
		initalizeTurtle();

	}

	private void initalizeTurtle() {
		turtle.setImage(image);
		turtle.setX(650/2);
		turtle.setY(425/2);
		scaleTurtle();
		cropTurtle();
		pane.getChildren().add(turtle);
		turtleShowing = true;
		pen = new Pen();
        penShowing = true;
	}

	private void scaleTurtle() {
		double imageRatio = image.getWidth()/image.getHeight();
		turtle.setFitHeight(fixedImageHeight);
		turtle.setFitWidth(fixedImageHeight * imageRatio);
		turtle.setPreserveRatio(true);

	}

	@Override
	public void move(double diffX, double diffY) {
		turtle.setX(getX() + diffX);
		turtle.setY(getY() + diffY);
		cropTurtle();
	}

	@Override
	public void turn(double degrees) {
		turtle.setRotate(turtle.getRotate() + degrees);
		cropTurtle();
	}

	@Override
	public double getX() {
		return turtle.getX();
	}

	@Override
	public double getY() {
		return turtle.getY();
	}

	@Override
	public double getOrientation() {
		return turtle.getRotate();
	}

	@Override
	public void setPenDown(boolean penDown) {

		if (penShowing && !penDown)
			screen.removeFromPane(pen.getPen());
		if (!penShowing && penDown)
			screen.addToPane(pen.getPen());
	}

	@Override
	public boolean getPenDown() {
		return penShowing;
	}

	@Override
	public void setTurtleShowing(boolean should_be_showing) {
		if (turtleShowing && !should_be_showing)
			screen.removeFromPane(turtle);
		if (!turtleShowing && should_be_showing)
			screen.addToPane(turtle);
	}

	@Override
	public boolean getTurtleShowing() {
		return turtleShowing;
	}

	public void cropTurtle() {
		Rectangle crop = new Rectangle(turtle.getX(), turtle.getY(), image.getWidth(), image.getHeight());

		if (turtle.getX() < pane.getLayoutX()) {
			crop.setX(pane.getLayoutX());
			crop.setWidth(image.getWidth() - pane.getLayoutX());
		}

		if (turtle.getX() + image.getWidth() > pane.getLayoutX() + 650) {
			crop.setX(turtle.getX());
			crop.setWidth(pane.getLayoutX() + 625 - (turtle.getX()));
		}

		if (turtle.getY() < pane.getLayoutY()) {
			crop.setY(pane.getLayoutY());
			crop.setHeight(image.getHeight() - pane.getLayoutY());
		}

		if (turtle.getY() + image.getHeight() > pane.getLayoutY() + 425) {
			crop.setY(turtle.getY());
			crop.setHeight(pane.getLayoutY() + 400 - (turtle.getY()));
		}
		turtle.setClip(crop);
	}
	
	public ImageView getImage() {
		return turtle;
	}

}
