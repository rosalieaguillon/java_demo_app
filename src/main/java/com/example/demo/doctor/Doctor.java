package com.example.demo.doctor;

import com.example.demo.patient.Patient;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table
public class Doctor {
    @Id
    @SequenceGenerator(
            name = "doctor_sequence",
            sequenceName = "doctor_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "doctor_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private String profession;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor")
    private Set<Patient> patients;

    public Doctor(String name, Long id, String email, String profession) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.profession = profession;
    }

    public Doctor(String name, String email, String profession) {
        this.name = name;
        this.profession = profession;
        this.email = email;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
