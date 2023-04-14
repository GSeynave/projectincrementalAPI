package com.projectIncremental.controllers;

import java.util.List;

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

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.projectincremental.ProjectIncrementalApplication;
import com.projectincremental.models.dtos.MonstreDto;

@SpringBootTest(classes = ProjectIncrementalApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MonstreControllerTest {

    @LocalServerPort
    private int port;

    private MockMvc mockMvc;

    private ObjectMapper mapper;

    @Autowired
    private TestRestTemplate restTemplate;


    @BeforeEach
    public void setUp() {
        mapper = new ObjectMapper().registerModule(new JavaTimeModule());
		mockMvc = MockMvcBuilders.standaloneSetup(monstreController).build();
    }

    @Test
    void getMonstresByZoneIdTest() throws Exception {
        // GIVEN
        Long zoneId = 1L;

        // WHEN
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/monstres/"+zoneId)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        // THEN
        Assertions.assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
        List<MonstreDto> monstres = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<MonstreDto>>() {});
        Assertions.assertThat(monstres).isNotNull();
    }

    @Test
    void getMonstresByZoneIdFailTest() throws Exception {
        // GIVEN
        Long zoneId = 6000L;

        // WHEN
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/monstres/"+zoneId)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        // THEN
        Assertions.assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
    }
}
