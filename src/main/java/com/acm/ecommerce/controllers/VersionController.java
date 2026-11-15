package com.acm.ecommerce.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@Tag(name = "Version", description = "Versión desplegada de la aplicación")
@RestController
@RequestMapping("/api/v1/version")
public class VersionController {

    private final String version;
    private final String commit;

    public VersionController(@Value("${app.version}") String version,
                             @Value("${app.commit:local}") String commit) {
        this.version = version;
        this.commit = commit;
    }

    @Operation(summary = "Obtener versión", description = "Retorna la versión y el commit desplegado.")
    @GetMapping
    public Map<String, String> getVersion() {
        Map<String, String> info = new LinkedHashMap<>();
        info.put("app", "ACM Ecommerce");
        info.put("version", version);
        info.put("commit", commit);
        return info;
    }
}
