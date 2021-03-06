package commands;
import java.util.List;

import Turtle.Turtle;

/**
 * Implements functionality for Backward Command
 *
 */
public class Backward extends Command{
     private final int numberOfParameters = 1;
     double step=0;

   /* (non-Javadoc)
 * @see commands.Command#execute(java.util.List, Turtle.Turtle)
 */
@Override
   double execute(List<CommandNode> children, Turtle t){
	if(t.isActive()) {
	   CommandNode child = children.get(0);
	   step = -1 * child.execute(t);
	   t.move(step);
	}
	   return -1*step;
   }

   /* (non-Javadoc)
 * @see commands.Command#getNumberOfParameters()
 */
@Override
	int getNumberOfParameters() {
		return numberOfParameters;
	}

}
