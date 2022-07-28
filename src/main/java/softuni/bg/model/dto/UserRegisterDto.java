package softuni.bg.model.dto;

import org.springframework.format.annotation.DateTimeFormat;
import softuni.bg.model.entity.AddressEntity;
import softuni.bg.model.entity.RideEntity;
import softuni.bg.model.entity.RoleEntity;
import softuni.bg.model.enums.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserRegisterDto {
    @NotBlank(message = "Please, enter your email!")
    @Email(message = "User email should be valid!")
    private String email;

    @NotBlank(message = "Please enter your first name!")
    @Size(min = 2, max = 30, message = "First name must be between 2 and 30 characters!" )
    private String firstName;

    @NotBlank(message = "Please enter your last name!")
    @Size(min = 2, max = 30, message = "Last name must be between 2 and 30 characters!")
    private String lastName;

    @NotNull(message = "Please enter your birthdate!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @NotNull(message = "Please, select your gender!")
    private GenderEnum gender;

    //custom password annotation
    private String password;

    //custom password annotation
    private String confirmPassword;

    @NotNull(message = "Please select your language!")
    private LanguageEnum userLanguage;

    @NotBlank
    private String phoneNumber; //todo: better validation of phone number!
    @NotNull
    private CommunicationEnum communication;

    @NotNull
    private MusicEnum music;

    @NotNull
    private PetEnum pet;

    @NotNull
    private SmokingEnum smoking;

    @NotNull
    private AddressDto address;
    @NotNull
    private Set<RoleEntity> roles;
    private List<RideEntity> rides = new ArrayList<>();

    public UserRegisterDto() {
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public UserRegisterDto setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public UserRegisterDto setGender(GenderEnum gender) {
        this.gender = gender;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterDto setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public LanguageEnum getUserLanguage() {
        return userLanguage;
    }

    public UserRegisterDto setUserLanguage(LanguageEnum userLanguage) {
        this.userLanguage = userLanguage;
        return this;
    }

    public CommunicationEnum getCommunication() {
        return communication;
    }

    public UserRegisterDto setCommunication(CommunicationEnum communication) {
        this.communication = communication;
        return this;
    }

    public MusicEnum getMusic() {
        return music;
    }

    public UserRegisterDto setMusic(MusicEnum music) {
        this.music = music;
        return this;
    }

    public PetEnum getPet() {
        return pet;
    }

    public UserRegisterDto setPet(PetEnum pet) {
        this.pet = pet;
        return this;
    }

    public SmokingEnum getSmoking() {
        return smoking;
    }

    public UserRegisterDto setSmoking(SmokingEnum smoking) {
        this.smoking = smoking;
        return this;
    }

    public AddressDto getAddress() {
        return address;
    }

    public UserRegisterDto setAddress(AddressDto address) {
        this.address = address;
        return this;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public UserRegisterDto setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
        return this;
    }

    public List<RideEntity> getRides() {
        return rides;
    }

    public UserRegisterDto setRides(List<RideEntity> rides) {
        this.rides = rides;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserRegisterDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
