package softuni.bg.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import softuni.bg.model.entity.AddressEntity;
import softuni.bg.model.entity.RoleEntity;
import softuni.bg.model.entity.UserEntity;
import softuni.bg.model.enums.*;
import softuni.bg.model.user.ShareRideUserDetails;
import softuni.bg.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ShareRideUserDetailsServiceTest {
    @Mock
    private UserRepository mockUserRepo;

    private ShareRideUserDetailsService toTest;

    @BeforeEach
    void setUp() {
        toTest = new ShareRideUserDetailsService(mockUserRepo);
    }

    @Test
    void testLoadUserByUsername_UserExists() {
        //arrange
        UserEntity testUserEntity =
                new UserEntity()
                        .setEmail("test@email.com")                           //done
                        .setFirstName("")                                     //done
                        .setLastName("Petrov")                                //done
                        .setPassword("12345")                                 //done
                        .setBirthdate(LocalDate.parse("2021-08-05"))
                        .setGender(GenderEnum.MALE)
                        .setGender(GenderEnum.FEMALE)
                        .setPhoneNumber("+359111111")
                        .setLanguage(LanguageEnum.BULGARIAN)
                        .setLanguage(LanguageEnum.ENGLISH)
                        .setCommunication(CommunicationEnum.HIGH)
                        .setCommunication(CommunicationEnum.MEDIUM)
                        .setCommunication(CommunicationEnum.LOW)
                        .setMusic(MusicEnum.YES)
                        .setMusic(MusicEnum.NO)
                        .setPet(PetEnum.YES)
                        .setPet(PetEnum.NO)
                        .setSmoking(SmokingEnum.SMOKER)
                        .setSmoking(SmokingEnum.NONSMOKER)
                        .setAddress(new AddressEntity()
                                .setCountry("Bulgaria")
                                .setCity("Plovdiv")
                                .setPostalCode("1000")
                                .setStreet("Magic Street")
                        )
                        .setRoles(
                                List.of(new RoleEntity().setUserRole(RoleEnum.ADMIN),
                                        new RoleEntity().setUserRole(RoleEnum.USER))
                        );

        when(mockUserRepo.findByEmail(testUserEntity.getEmail())).thenReturn(Optional.of(testUserEntity));

        // act
        ShareRideUserDetails userDetails = (ShareRideUserDetails)
                toTest.loadUserByUsername(testUserEntity.getEmail());

        // assert
        Assertions.assertEquals(testUserEntity.getEmail(), userDetails.getUsername());
        Assertions.assertEquals(testUserEntity.getFirstName(), userDetails.getFirstName());
        Assertions.assertEquals(testUserEntity.getLastName(), userDetails.getLastName());
        Assertions.assertEquals(testUserEntity.getPassword(), userDetails.getPassword());

        var authorities = userDetails.getAuthorities();

        Assertions.assertEquals(2, authorities.size());

        var authoritiesIter = authorities.iterator();

        Assertions.assertEquals("ROLE_" + RoleEnum.ADMIN.name(), authoritiesIter.next().getAuthority());
        Assertions.assertEquals("ROLE_" + RoleEnum.USER.name(), authoritiesIter.next().getAuthority());

    }

    @Test
    void testLoadUserByUsername_UserDoesNotExist() {

        Assertions.assertThrows(
                UsernameNotFoundException.class,
                () -> toTest.loadUserByUsername("user@fake.com")
        );

    }
}
