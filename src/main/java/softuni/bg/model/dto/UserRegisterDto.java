package softuni.bg.model.dto;

import org.springframework.format.annotation.DateTimeFormat;
import softuni.bg.model.enums.*;
import softuni.bg.model.validation.FieldMatch;
import softuni.bg.model.validation.UniqueUserEmail;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@FieldMatch(
        first = "password",
        second = "confirmPassword",
        message = "Passwords do no match!"
)
public class UserRegisterDto {
    @NotBlank(message = "Please, enter your email!")
    @Email(message = "User email should be valid!")
    @UniqueUserEmail(message = "User email should be unique!")
    private String email;

    @NotBlank(message = "Please enter your first name!")
    @Size(min = 2, max = 30, message = "First name must be between 2 and 30 characters!")
    private String firstName;

    @NotBlank(message = "Please enter your last name!")
    @Size(min = 2, max = 30, message = "Last name must be between 2 and 30 characters!")
    private String lastName;

    @NotNull(message = "Please enter your birthdate!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;

    @NotNull(message = "Please, select your gender!")
    private GenderEnum gender;

    @NotBlank(message = "Password field cannot be empty!")
    @Size(min = 5, max = 20, message = "Password must be between 5 and 20 characters!")
    private String password;

    private String confirmPassword;

    @NotNull(message = "Please select your language!")
    private LanguageEnum language;

    @NotBlank(message = "Please, enter your phone number!")
    private String phoneNumber; //todo: better validation of phone number!
    @NotNull(message = "Please, select how talkative are you!")
    private CommunicationEnum communication;

    @NotNull(message = "Please, select do you listen music while driving!")
    private MusicEnum music;

    @NotNull(message = "Please, select do you like pets!")
    private PetEnum pet;

    @NotNull(message = "Please, select do you tolerate smoking!")
    private SmokingEnum smoking;

    @Valid
    private AddressDto address;

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

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public UserRegisterDto setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
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

    public LanguageEnum getLanguage() {
        return language;
    }

    public UserRegisterDto setLanguage(LanguageEnum language) {
        this.language = language;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserRegisterDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }


}
