package Pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;
import java.util.LinkedHashSet;

public class Task {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String identifier;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String priority;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LinkedHashSet<Object> skills;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String agentAssigned;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String taskcompleted;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public LinkedHashSet<Object> getSkills() {
        return skills;
    }

    public void setSkills(LinkedHashSet<Object> skills) {
        this.skills = skills;
    }

    public String getAgentAssigned() {
        return agentAssigned;
    }

    public void setAgentAssigned(String agentAssigned) {
        this.agentAssigned = agentAssigned;
    }

    public String getTaskcompleted() {
        return taskcompleted;
    }

    public void setTaskcompleted(String taskcompleted) {
        this.taskcompleted = taskcompleted;
    }
}
