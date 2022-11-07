package com.projectIncremental.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.projectincremental.ProjectIncrementalApplication;
import com.projectincremental.controllers.ZoneController;
import com.projectincremental.entities.Zone;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

@SpringBootTest(classes = ProjectIncrementalApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ZoneControllerTest {

    @LocalServerPort
    private int port;

    private MockMvc mockMvc;
    private ObjectMapper mapper;

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private ZoneController zoneController;

    @BeforeEach
    public void setUp() {
        mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        mockMvc = MockMvcBuilders.standaloneSetup(zoneController)
                .build();
    }

    @Test
    void getAllTest() throws Exception {
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/zones")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        Assertions.assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
        List<Zone> zones =mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {});
        Assertions.assertThat(zones).isNotNull();
    }

    @Test
    void getByIdTest() throws Exception {
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/zones/1")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        Assertions.assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
        Zone zone =mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {});
        Assertions.assertThat(zone).isNotNull();
        Assertions.assertThat(zone.getId()).isEqualTo(1L);
    }

    @Test
    void getByIdFailTest() throws Exception {
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/zones/6000")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        Assertions.assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
    }
}
