package softuni.bg.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import softuni.bg.model.enums.*;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserRegistrationControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testRegistrationPageShown() throws Exception {
        this.mockMvc
                .perform(get("/users/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("register"));
    }

    @Test
    void testUserRegistration() throws Exception {
        this.mockMvc.perform(post("/users/register")
                        .param("email", "user@email.com")
                        .param("firstName", "Bobi")
                        .param("lastName", "Dobrev")
                        .param("password", "12345")
                        .param("confirmPassword", "12345")
                        .param("birthdate", "2018-05-10")
                        .param("gender", GenderEnum.MALE.toString())
                        .param("language", LanguageEnum.BULGARIAN.toString())
                        .param("phoneNumber", "+359111111")
                        .param("communication", CommunicationEnum.LOW.toString())
                        .param("music", MusicEnum.NO.toString())
                        .param("pet", PetEnum.NO.toString())
                        .param("smoking", SmokingEnum.NONSMOKER.toString())
                        .param("address.country", "Bulgaria")
                        .param("address.city", "Sofia")
                        .param("address.postalCode", "1000")
                        .param("address.street", "Magic Street")
                        .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/users/login"));
    }

}
