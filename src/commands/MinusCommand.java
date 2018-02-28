package commands;

import java.util.List;

import Turtle.Turtle;

public class MinusCommand extends Command {
	private int numberOfParameters = 1;

	@Override
	public double execute(List<CommandNode> children, Turtle t){
		CommandNode child1 = children.get(0);
		
		double x=-1*child1.execute(t);
		
		return x;
	}

	@Override
	public int getNumberOfParameters() {
		return numberOfParameters;
	}
}