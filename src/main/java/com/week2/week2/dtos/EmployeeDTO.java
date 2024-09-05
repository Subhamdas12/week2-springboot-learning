package com.week2.week2.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.week2.week2.annotations.EmployeeRoleValidation;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;

    @NotBlank(message = "Name of employee cannot be blank")
    @Size(min = 2, max = 50, message = "Name of employee must be between 3 and 50")
    private String name;

    @NotBlank(message = "Email of employee cannot be blank")
    @Email(message = "Email of employee must be valid")
    private String email;

    @NotNull(message = "Age of employee cannot be null")
    @Max(value = 80, message = "Age of employee cannot be more then 80")
    @Min(value = 18, message = "Age of employee cannot be less then 18")
    private Integer age;

    @NotBlank(message = "Role of employee cannot be blank")
    // @Pattern(regexp = "^(ADMIN|USER)$", message = "Role of employee must be Admin
    // or User")
    @EmployeeRoleValidation
    private String role;

    @NotNull(message = "Salary of employee should not be null")
    @Positive(message = "Salary of employee should be positive")
    @Digits(message = "The salary should be in the form of XXXXX.YY", fraction = 2, integer = 6)
    @DecimalMax(value = "100000.00")
    @DecimalMin(value = "100.00")
    private Double salary;

    @PastOrPresent(message = "Date of joining of employee cannot be in the future")
    private LocalDate dateOfJoining;

    @AssertTrue(message = "Employee should be active")
    private Boolean isActive;
}
