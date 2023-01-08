package com.gd.trackshows.api.trakt.auth;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class TraktAuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TraktAuthService traktAuthService;

    @Test
    public void authRequestReturns200() throws Exception {
        this.mockMvc
                .perform(get("/api/v1/trakt/auth/"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}