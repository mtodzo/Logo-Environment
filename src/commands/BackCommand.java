package commands;
import java.util.List;

import Turtle.Turtle;

public class BackCommand extends Command{
     private int numberOfParameters = 1;
     double step;

   @Override
   public double execute(List<CommandNode> children, Turtle t){
	   CommandNode child = children.get(0);
	   step=-1*child.execute(t);
		return t.move(step);
   }

   @Override
	public int getNumberOfParameters() {
		return numberOfParameters;
	}

}