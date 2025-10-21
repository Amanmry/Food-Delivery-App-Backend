package com.aman.food_delivery.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "deliveryaddresses")
public class DeliveryAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Please add address")
    @Size(min = 10, max = 255, message = "Address must be 10 to 255 Characters")
    private String addressLine1;

    private String addressLine2;

    @NotBlank(message = "Please fill city")
    private String city;

    @NotBlank(message = "Please fill state")
    private String state;

    @NotBlank(message = "Please postal code")
    @Pattern(regexp = "\\d{5}(-\\d{4})?", message = "Invalid postal code format")
    private Long postalCode;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customers customer;

}
