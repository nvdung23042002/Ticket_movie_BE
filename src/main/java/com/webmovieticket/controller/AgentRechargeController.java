package com.webmovieticket.controller;

import com.webmovieticket.dto.AgentRechargeDTO;
import com.webmovieticket.models.AgentRecharge;
import com.webmovieticket.service.AgentRechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class AgentRechargeController {

    @Autowired
    private AgentRechargeService agentRechargeService;

    @GetMapping("agentRecharge")
    public List<AgentRechargeDTO> findAll() {
        return agentRechargeService.findAll();
    }

    @GetMapping("agentRecharge/{id}")
    public AgentRechargeDTO findById(@PathVariable Long id) {
        return agentRechargeService.findByID(id);
    }

    @PostMapping("agentRecharge")
    public void addAgentRecharge(@RequestBody AgentRecharge agentRecharge) {
        agentRechargeService.addAgentRecharge(agentRecharge);
    }

    @PutMapping("agentRecharge/{id}")
    public void updateAgentRecharge(@PathVariable Long id, @RequestBody AgentRecharge agentRecharge) {
        agentRechargeService.updateAgentRecharge(id, agentRecharge);
    }

    @DeleteMapping("agentRecharge/{id}")
    public void deleteAgentRecharge(@PathVariable Long id) {
        agentRechargeService.DeleteAgentRecharge(id);
    }

}
