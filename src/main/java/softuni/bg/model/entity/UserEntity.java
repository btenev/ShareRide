package softuni.bg.model.entity;

import softuni.bg.model.enums.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private LocalDate birthdate;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LanguageEnum language;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CommunicationEnum communication;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MusicEnum music;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PetEnum pet;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SmokingEnum smoking;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressEntity address;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<RoleEntity> roles = new ArrayList<>();

    public UserEntity() {
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public UserEntity setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public UserEntity setGender(GenderEnum gender) {
        this.gender = gender;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserEntity setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public LanguageEnum getLanguage() {
        return language;
    }

    public UserEntity setLanguage(LanguageEnum language) {
        this.language = language;
        return this;
    }

    public CommunicationEnum getCommunication() {
        return communication;
    }

    public UserEntity setCommunication(CommunicationEnum communication) {
        this.communication = communication;
        return this;
    }

    public MusicEnum getMusic() {
        return music;
    }

    public UserEntity setMusic(MusicEnum music) {
        this.music = music;
        return this;
    }

    public PetEnum getPet() {
        return pet;
    }

    public UserEntity setPet(PetEnum pet) {
        this.pet = pet;
        return this;
    }

    public SmokingEnum getSmoking() {
        return smoking;
    }

    public UserEntity setSmoking(SmokingEnum smoking) {
        this.smoking = smoking;
        return this;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public UserEntity setAddress(AddressEntity address) {
        this.address = address;
        return this;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public UserEntity setRoles(List<RoleEntity> roles) {
        this.roles = roles;
        return this;
    }

    public UserEntity addRole (RoleEntity role) {
        this.roles.add(role);
        return this;
    }
}
