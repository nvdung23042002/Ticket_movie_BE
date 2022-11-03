package com.webmovieticket.service;

import com.webmovieticket.dto.AgentRechargeDTO;
import com.webmovieticket.mapper.AgentRechargeMapper;
import com.webmovieticket.models.AgentRecharge;
import com.webmovieticket.repository.AgentRechargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class AgentRechargeService {

    @Autowired
    private AgentRechargeMapper agentRechargeMapper;

    @Autowired
    private AgentRechargeRepository agentRechargeRepository;

    public List<AgentRechargeDTO> findAll() {
        return agentRechargeRepository.findAll().stream().map(
                agentRecharge -> agentRechargeMapper.returnDTO(agentRecharge)).collect(Collectors.toList());
    }

    public AgentRechargeDTO findByID(Long id) {
        return agentRechargeMapper.returnDTO(agentRechargeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException()));
    }

    public void addAgentRecharge(AgentRecharge agentRecharge) {
        agentRechargeRepository.save(agentRecharge);
    }

    public void updateAgentRecharge(Long id, AgentRecharge agentRecharge) {
        AgentRecharge oldAgentRecharge = agentRechargeRepository.findById(id).orElseGet(() -> null);

        if (oldAgentRecharge != null) {
            oldAgentRecharge.setAmount(agentRecharge.getAmount());
        }

        agentRechargeRepository.save(oldAgentRecharge);
    }

    public void DeleteAgentRecharge(Long id) {
        agentRechargeRepository.deleteById(id);
    }
}
