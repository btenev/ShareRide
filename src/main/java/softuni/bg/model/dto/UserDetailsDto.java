package softuni.bg.model.dto;

import softuni.bg.model.enums.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class UserDetailsDto {
    private String email;

    private String firstName;

    private String lastName;

    private LocalDate birthdate;

    private GenderEnum gender;

    private String password;

    private LanguageEnum language;

    private String phoneNumber;

    private CommunicationEnum communication;

    private MusicEnum music;

    private PetEnum pet;

    private SmokingEnum smoking;

    private AddressDto address;

    public UserDetailsDto() {
    }

    public String getEmail() {
        return email;
    }

    public UserDetailsDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserDetailsDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDetailsDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public UserDetailsDto setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public UserDetailsDto setGender(GenderEnum gender) {
        this.gender = gender;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDetailsDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public LanguageEnum getLanguage() {
        return language;
    }

    public UserDetailsDto setLanguage(LanguageEnum language) {
        this.language = language;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserDetailsDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public CommunicationEnum getCommunication() {
        return communication;
    }

    public UserDetailsDto setCommunication(CommunicationEnum communication) {
        this.communication = communication;
        return this;
    }

    public MusicEnum getMusic() {
        return music;
    }

    public UserDetailsDto setMusic(MusicEnum music) {
        this.music = music;
        return this;
    }

    public PetEnum getPet() {
        return pet;
    }

    public UserDetailsDto setPet(PetEnum pet) {
        this.pet = pet;
        return this;
    }

    public SmokingEnum getSmoking() {
        return smoking;
    }

    public UserDetailsDto setSmoking(SmokingEnum smoking) {
        this.smoking = smoking;
        return this;
    }

    public AddressDto getAddress() {
        return address;
    }

    public UserDetailsDto setAddress(AddressDto address) {
        this.address = address;
        return this;
    }

    public long calculateAge() {
        return ChronoUnit.YEARS.between(this.birthdate, LocalDate.now());
    }
}
