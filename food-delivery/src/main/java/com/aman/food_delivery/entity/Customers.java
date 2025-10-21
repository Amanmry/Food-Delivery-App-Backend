package com.aman.food_delivery.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "customers")
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    @Column(name = "customer_name")
    private String customerName;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Invalid Email!")
    @Column(name = "customer_email")
    private String customerEmail;

    @NotBlank(message = "Phone Number cannot be empty")
    @Column(name = "customer_phone")
    @Pattern(regexp = "^\\d{10}$", message = "Mobile number must have exactly 10 digits")
    private String customerPhone;

    @OneToMany(mappedBy = "customer")
    private List<DeliveryAddress> address;
}
