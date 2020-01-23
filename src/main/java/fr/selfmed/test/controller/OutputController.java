package fr.selfmed.test.controller;

import fr.selfmed.test.services.ExternalApiSimulatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OutputController {
    private final ExternalApiSimulatorService externalApiSimulatorService;

    @Autowired
    public OutputController(ExternalApiSimulatorService externalApiSimulatorService) {
        this.externalApiSimulatorService = externalApiSimulatorService;
    }

    @GetMapping("/api/output/json")
    public String getAsJsonFormat() {
        String xmlInput = externalApiSimulatorService.callApi("");
        String output = "";

        // TODO

        return output;
    }

    @GetMapping("/api/output/selfmed")
    public String getAsSelfmedFormat() {
        String xmlInput = externalApiSimulatorService.callApi("");
        String output = "";

        // TODO

        return output;
    }
}