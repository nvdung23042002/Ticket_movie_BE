package com.webmovieticket.controller;

import com.webmovieticket.dto.AgentDTO;
import com.webmovieticket.models.Agent;
import com.webmovieticket.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class AgentController {

    @Autowired
    private AgentService agentService;

    @GetMapping("agent")
    public List<AgentDTO> findAll() {
        return agentService.findAll();
    }

    @GetMapping("agent/{id}")
    public AgentDTO findById(@PathVariable Long id) {
        return agentService.findByID(id);
    }

    @PostMapping("agent")
    public void addAgent(@RequestBody Agent agent) {
        agentService.addAgent(agent);
    }

    @PutMapping("agent/{id}")
    public void updateAgent(@PathVariable Long id ,@RequestBody Agent agent) {
        agentService.updateAgent(id, agent);
    }

    @DeleteMapping("agent/{id}")
    public void deleteAgent(@PathVariable Long id) {
        agentService.deleteAgent(id);
    }
}
