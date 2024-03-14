package com.lab.exercise.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="User")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private Long passcode;
    private Boolean active;
    private Boolean cgScore;
    private Double dfCertificate;

    // Constructors
    public Post() {
    }

    public Post(String email, Long passcode, Boolean active, Boolean cgScore, Double dfCertificate) {
        this.email = email;
        this.passcode = passcode;
        this.active = active;
        this.cgScore = cgScore;
        this.dfCertificate = dfCertificate;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPasscode() {
        return passcode;
    }

    public void setPasscode(Long passcode) {
        this.passcode = passcode;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getCgScore() {
        return cgScore;
    }

    public void setCgScore(Boolean cgScore) {
        this.cgScore = cgScore;
    }

    public Double getDfCertificate() {
        return dfCertificate;
    }

    public void setDfCertificate(Double dfCertificate) {
        this.dfCertificate = dfCertificate;
    }
}
