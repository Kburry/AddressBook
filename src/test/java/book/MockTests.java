package book;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MockTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("buddyInfo")));
    }

    @Test
    public void shouldReturnBuddiesJonMessage() throws Exception {
        this.mockMvc.perform(get("/BuddyInfo")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("\"name\" : \"Jon\",")));
    }

    @Test
    public void shouldReturnBuddiesAddressMessage() throws Exception {
        this.mockMvc.perform(get("/BuddyInfo")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("\"address\" : \"Hamm\",")));
    }

    @Test
    public void shouldReturnBuddiesPhoneNumber() throws Exception {
        this.mockMvc.perform(get("/BuddyInfo")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("\"phoneNumber\" : \"1\",")));
    }

    @Test
    public void shouldReturnAddressBook() throws Exception {
        this.mockMvc.perform(get("/addressBook")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("addressBook/1")));
    }

    @Test
    public void shouldPostBuddy() throws Exception {
        this.mockMvc.perform(post("/BuddyInfo").contentType(MediaType.APPLICATION_JSON).content(
                "{" +
                "\"name\" : \"post\"," +
                "\"address\" : \"postAddress\"," +
                "\"phoneNumber\" : \"phone\"" +
                "}")).andDo(print()).andExpect(status().isCreated());
        this.mockMvc.perform(get("/BuddyInfo")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("postAddress")));
    }
}
