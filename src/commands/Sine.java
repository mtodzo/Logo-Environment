package commands;

import java.util.List;

import Turtle.Turtle;

/**
 * Implements functionality for Sine Command
 *
 */
public class Sine extends Command{
	private final int numberOfParameters = 1;
	
	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List, Turtle.Turtle)
	 */
	@Override
	double execute(List<CommandNode> children, Turtle t){
		CommandNode child = children.get(0);
		return Math.toDegrees(Math.sin(Math.toRadians(child.execute(t))));
	}

	/* (non-Javadoc)
	 * @see commands.Command#getNumberOfParameters()
	 */
	@Override
	int getNumberOfParameters() {
		return numberOfParameters;
	}
}
