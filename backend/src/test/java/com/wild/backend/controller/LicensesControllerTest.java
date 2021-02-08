package com.wild.backend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class LicensesControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void allLicenses() throws Exception {
        mvc.perform(get("/licenses/all"))
                .andExpect(status().isOk());
    }

    @Test
    void registerFakeKey() throws Exception {
        mvc.perform(patch("/licenses").param("licenseKey", "1541511"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getRegisteredKeyStatus() {
    }

    @Test
    void getUsersLicenses() {
    }
}