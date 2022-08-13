package softuni.bg.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;
import softuni.bg.model.enums.BaggageEnum;
import softuni.bg.model.enums.SeatEnum;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class RideControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    void testRideCreationPageShown() throws Exception {
        this.mockMvc.perform(get("/rides/publish"))
                .andExpect(status().isOk())
                .andExpect(view().name("publish-ride"));
    }

    @Test
    @WithUserDetails(value = "user@example.com", userDetailsServiceBeanName = "testUserDataService")
    void testRideCreationConfirm() throws Exception {
        this.mockMvc.perform(post("/rides/publish")
                        .param("departure", "Sofia")
                        .param("arrival", "Plovdiv")
                        .param("departureDate", "2022-12-05")
                        .param("departureTime", "18:00")
                        .param("numberOfSeats", SeatEnum.Three.toString())
                        .param("baggageQuantity", BaggageEnum.SMALL.toString())
                        .param("price", "20.05")
                        .param("car.brand", "VW")
                        .param("car.model", "Polo")
                        .param("car.color", "blue")
                        .param("car.licensePlate", "CA1078C")
                        .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }
//        @Valid
//        private CarDto car;
}
