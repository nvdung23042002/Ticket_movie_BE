package com.webmovieticket.service;

import com.webmovieticket.dto.AgentDTO;
import com.webmovieticket.mapper.AgentMapper;
import com.webmovieticket.models.Agent;
import com.webmovieticket.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgentService {

    @Autowired
    private AgentMapper agentMapper;

    @Autowired
    private AgentRepository agentRepository;

    public List<AgentDTO> findAll() {
        return agentRepository.findAll().stream().map(
                agent -> agentMapper.returnDTO(agent)).collect(Collectors.toList());
    }

    public AgentDTO findByID(Long id) {
        return agentMapper.returnDTO(agentRepository.findById(id).orElseThrow(() -> new RuntimeException()));
    }
    public void addAgent(Agent agent) {
        agentRepository.save(agent);
    }

    public void updateAgent(Long id, Agent agent) {
        Agent oldAgent = agentRepository.findById(id).orElseGet(() -> null);

        if (oldAgent != null) {
            oldAgent.setUsername(agent.getUsername());
            oldAgent.setPassword(agent.getPassword());
            oldAgent.setEmail(agent.getEmail());
            oldAgent.setMobile(agent.getMobile());

            agentRepository.save(oldAgent);
        }
    }

    public void deleteAgent(Long id) {
        agentRepository.deleteById(id);
    }
}
