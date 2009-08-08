package ch.idsia.scenarios;

import ch.idsia.ai.agents.Agent;
import ch.idsia.ai.agents.RegisterableAgent;
import ch.idsia.ai.agents.ai.*;
import ch.idsia.ai.tasks.ProgressTask;
import ch.idsia.ai.tasks.Task;
import ch.idsia.tools.CmdLineOptions;
import ch.idsia.tools.EvaluationOptions;
import ch.idsia.utils.ArrayUtils;

/**
 * Created by IntelliJ IDEA.
 * User: julian
 * Date: May 5, 2009
 * Time: 12:46:43 PM
 */
public class Play {

    public static void main(String[] args) {
        Agent controller = new HardcodedAgent();
        if (args.length > 0) {
            controller = RegisterableAgent.load (args[0]);
            RegisterableAgent.registerAgent (controller);
        }
        EvaluationOptions options = new CmdLineOptions(new String[0]);
        options.setAgent(controller);
        Task task = new ProgressTask(options);
        options.setMaxFPS(false);
        options.setVisualization(true);
        options.setMaxAttempts(1);
        options.setMatlabFileName("");
        options.setLevelRandSeed(1);//(int) (Math.random () * Integer.MAX_VALUE));
        options.setLevelDifficulty(0);
        task.setOptions(options);

        System.out.println ("Score: " + ArrayUtils.toString(task.evaluate(controller)));
    }
}
