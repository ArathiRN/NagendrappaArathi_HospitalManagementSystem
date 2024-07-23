package com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;
    @NotEmpty(message = "Password should not be empty")
    private String password;
    @NotEmpty
    private String phoneNumber;
    @NotEmpty
    private LocalDate dob;
    @NotEmpty
    private String gender;
    @NotEmpty
    private String address;

    public boolean isAdminRegistration(){

        return email.endsWith(("@admin.com"));
    }
}
