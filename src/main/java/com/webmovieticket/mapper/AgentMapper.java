package com.webmovieticket.mapper;

import com.webmovieticket.dto.AgentDTO;
import com.webmovieticket.models.Agent;
import org.springframework.stereotype.Component;

@Component
public class AgentMapper {

    public AgentDTO returnDTO(Agent agent) {
        AgentDTO agentDTO = new AgentDTO();

        agentDTO.setId(agent.getId());
        agentDTO.setUsername(agent.getUsername());
        agentDTO.setPassword(agent.getPassword());
        agentDTO.setEmail(agent.getEmail());
        agentDTO.setMobile(agent.getMobile());
        return agentDTO;
    }

    public Agent returnEntity(AgentDTO agentDTO) {
        Agent agent = new Agent();

        agent.setId(agentDTO.getId());
        agent.setUsername(agentDTO.getUsername());
        agent.setPassword(agentDTO.getPassword());
        agent.setEmail(agentDTO.getEmail());
        agent.setMobile(agentDTO.getMobile());
        return agent;
    }
}
