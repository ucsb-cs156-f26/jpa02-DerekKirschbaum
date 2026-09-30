package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getHello_has_expectedHeader() throws Exception {
        MvcResult response = mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        String actualContent = response.getResponse().getContentAsString();
        String expectedContent =  """
            <h1>Greetings from Spring Boot!</h1>
            <p>This is a simple example of a Spring Boot application.</p>
            <p><a href="/info">Developer Info</a></p>
            """;
        assertEquals(expectedContent, actualContent);
    }

    @Test
    public void getInfo_has_expected_developer_info() throws Exception {
         MvcResult response = mvc.perform(MockMvcRequestBuilders.get("/info").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        String actualContent = response.getResponse().getContentAsString();
        String expectedContent = """
                <h1>Developer Info</h1>
                <ul>
                  <li>Name: Derek</li>
                  <li>Github ID: <a href="https://github.com/DerekKirschbaum">DerekKirschbaum</a></li>
                  <li>Team: <a href="/team">staff</a></li>
                </ul>
                """;
        assertEquals(expectedContent, actualContent);
    }


    @Test
    public void get_team_returns_team_object() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/team").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json("""
                        {"name":"staff","members":["Daniel","Derek","Keigo","Phill","Wendy","Victor"]}
                        """, org.springframework.test.json.JsonCompareMode.STRICT));
    }


}
