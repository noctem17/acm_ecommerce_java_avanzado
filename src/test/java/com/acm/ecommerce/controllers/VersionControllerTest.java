package com.acm.ecommerce.controllers;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VersionControllerTest {

    @Test
    void retornaVersionYCommit() {
        VersionController controller = new VersionController("1.0.0", "abc123");

        Map<String, String> info = controller.getVersion();

        assertEquals("ACM Ecommerce", info.get("app"));
        assertEquals("1.0.0", info.get("version"));
        assertEquals("abc123", info.get("commit"));
    }
}
