package hello;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

import Pojo.Agent;
import Pojo.Task;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskDistributionController {


    //List<String> agents = new ArrayList<>(Arrays.asList("agent1","agent2","agent3","agent4","agent5","agent6"));


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Task createTask(@RequestBody Task task) {
         for(Map.Entry<String, LinkedHashSet<Object>> agentData: getAgentsData().entrySet()) {
            if(agentData.getValue().containsAll(task.getSkills())) {
               for(Agent agent : getAgents()) {
                   if(!agent.isAssigned() && agent.getAgent().equalsIgnoreCase(agentData.getKey()) && agent.getPriority().isEmpty()) {
                       task.setAgentAssigned(agentData.getKey());
                   }

               }
            }
        }

        return task;
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public Task updateTask(@RequestBody Task task) {

        Task taskUpdated = getTask(task, task.getIdentifier(), task.getTaskcompleted());

        return taskUpdated;



    }

    /*this should be a Database call*/
    private List<Agent> getAgents() {
       Agent agent1 = new Agent();

       agent1.setAgent("agent1");
       agent1.setPriority("");
       agent1.setAssigned(false);

        Agent agent2 = new Agent();

        agent2.setAgent("agent2");
        agent2.setPriority("high");
        agent2.setAssigned(true);

        Agent agent3 = new Agent();

        agent3.setAgent("agent3");
        agent3.setPriority("low");
        agent3.setAssigned(true);

        List<Agent> agents = new ArrayList<>();

        agents.add(agent1);
        agents.add(agent2);
        agents.add(agent3);

        return agents;
    }


    /*this should be a Database call*/
    private Map<String, LinkedHashSet<Object>> getAgentsData() {

        LinkedHashSet<Object> skillsSet1 = new LinkedHashSet<>();

        skillsSet1.add("skill1");
        skillsSet1.add("skill2");
        skillsSet1.add("skill3");

        LinkedHashSet<Object> skillsSet2 = new LinkedHashSet<>();

        skillsSet2.add("skill4");
        skillsSet2.add("skill5");
        skillsSet2.add("skill6");

        LinkedHashSet<Object> skillsSet3 = new LinkedHashSet<>();

        skillsSet3.add("skill7");
        skillsSet3.add("skill8");
        skillsSet3.add("skill9");


        Map<String, LinkedHashSet<Object>> agents = new HashMap<>();

        agents.put("agent1", skillsSet1);
        agents.put("agent2",skillsSet2);
        agents.put("agent3",skillsSet3);

        return agents;
    }

    /*this should be a Database call*/
    private Task getTask(Task task, String identifier, String taskCompleted) {

        if(task.getIdentifier().equalsIgnoreCase(identifier)) {
            task.setTaskcompleted(taskCompleted);
        }
      return task;
    }
}
