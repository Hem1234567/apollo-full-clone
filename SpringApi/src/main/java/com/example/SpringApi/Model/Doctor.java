package com.example.SpringApi.Model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DOCTOR")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DOCTOR_ID")
    private int doctorId;

    @Column(name = "DOCTOR_NAME", nullable = false)
    private String name;

    @Column(name = "ROLE", nullable = false)
    private String role;

    @Column(name = "GENDER", nullable = false)
    private String gender;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "EXPERIENCE", nullable = false)
    private double experience;  // Changed from float to double

    @Column(name = "PRICE", precision = 10, scale = 2, nullable = false)
    private BigDecimal price;  // Changed from float to BigDecimal for better precision

    @Column(name = "IMAGE_URL")
    private String imageURL;
}
