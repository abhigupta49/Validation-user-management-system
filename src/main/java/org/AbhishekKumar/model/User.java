package org.AbhishekKumar.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @NotNull
    private Integer userId;
    @NotBlank(message = "should not be blank")
    private String userName;
    @Past
    private LocalDate userDOB;
    @Email
    private String userEmail;
    @Pattern(regexp = "^(?=.*[!@#$%^&*()\\[\\]{};':\"\\\\|,.<>/?])(?=.*\\d)(?=.*[A-Z]).{6,}$")
    private String userPassword;
    @Size(min = 12,max = 12,message = "ContactNumber should not be less than size 12")
    @Pattern(regexp = "^[0-9]+$")
    private String userPhoneNumber;
    private LocalDate date;
    private LocalTime time;
    private Type userType;
    @Min(value = 21)
    @Max(value = 30)
    private Integer userAge;
}
