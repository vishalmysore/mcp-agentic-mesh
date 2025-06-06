package org.example.client;

import io.github.vishalmysore.mesh.AgentCatalog;
import lombok.extern.java.Log;
import org.checkerframework.checker.units.qual.A;
@Log
public class MeshClient {
    public static void main(String[] args) {
        AgentCatalog agentCatalog = new AgentCatalog();
        agentCatalog.addAgent("http://localhost:7862/");
        agentCatalog.addAgent("http://localhost:7863/");
        String answer = agentCatalog.processQuery("what is the receipe for Gulab Jamun").getTextResult();
        log.info("Answer: " + answer);
    }
}
