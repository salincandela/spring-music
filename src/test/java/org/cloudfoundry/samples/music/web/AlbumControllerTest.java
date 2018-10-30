package org.cloudfoundry.samples.music.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AlbumControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void listAlbumShouldBeNotEmpty() throws Exception {
        mockMvc.perform(get("/albums").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", equalTo(29)))
                .andExpect(jsonPath("$[?(@.id == '1')].title", hasItem(equalToIgnoringCase("Nirvana"))));
    }

    @Test
    public void getAlbumById() throws Exception {
        mockMvc.perform(get("/albums/{id}", 1).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", equalToIgnoringCase("Nirvana")));
    }


    @Test
    public void getNotExistentAlbumById() throws Exception {
        mockMvc.perform(get("/albums/{id}", 30).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
