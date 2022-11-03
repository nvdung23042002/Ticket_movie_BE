package com.webmovieticket.mapper;

import com.webmovieticket.dto.AgentRechargeDTO;
import com.webmovieticket.models.AgentRecharge;
import org.springframework.stereotype.Component;

@Component
public class AgentRechargeMapper {

    public AgentRechargeDTO returnDTO(AgentRecharge agentRecharge) {
        AgentRechargeDTO agentRechargeDTO = new AgentRechargeDTO();

        agentRechargeDTO.setId(agentRecharge.getId());
        agentRechargeDTO.setAmount(agentRecharge.getAmount());
        return agentRechargeDTO;
    }

    public AgentRecharge returnEntity(AgentRechargeDTO agentRechargeDTO) {
        AgentRecharge agentRecharge = new AgentRecharge();

        agentRecharge.setId(agentRechargeDTO.getId());
        agentRecharge.setAmount(agentRechargeDTO.getAmount());
        return agentRecharge;
    }
}
