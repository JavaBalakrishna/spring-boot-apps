package com.code.validation.exception.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {

    @NotNull(message = "user shouldn't be null")
    @Size(min = 2, max = 100, message = "The length of full name must be between 2 and 100 characters.")
    private String name;
    @NotEmpty(message = "The email address is required.")
    @Email(message = "The email address is invalid.", flags = { Pattern.Flag.CASE_INSENSITIVE })
    private String email;
    @Pattern(regexp = "^\\d{10}$",message = "invalid mobile number entered ")
    private String mobile;
    @NotEmpty(message = "The gender is required.")
    private String gender;
    private int age;
    private String nationality;

    public @NotNull(message = "user shouldn't be null") String getName() {
        return name;
    }

    public void setName(@NotNull(message = "user shouldn't be null") String name) {
        this.name = name;
    }

    public @Email(message = "invalid email address") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "invalid email address") String email) {
        this.email = email;
    }

    public @Pattern(regexp = "^\\d{10}$", message = "invalid mobile number entered ") String getMobile() {
        return mobile;
    }

    public void setMobile(@Pattern(regexp = "^\\d{10}$", message = "invalid mobile number entered ") String mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
