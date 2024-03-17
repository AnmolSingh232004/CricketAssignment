package com.example.Cricket.Cricket;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Player {
    @Id
    @SequenceGenerator(
            name = "account_sequence",
            sequenceName = "account_sequence",
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "account_sequence"
    )
    private Long id;
    private String name;
    private LocalDate dob;
    private String country;
    private Long currentMatchId;
    private Long totalScore;
    private Long matchesPlayed;

    public Long getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(Long matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public Player(String name, String country, Long currentMatchId, Long totalScore, String currentStadium, Long matchesPlayed) {
        this.name = name;
        this.country = country;
        this.currentMatchId = currentMatchId;
        this.totalScore = totalScore;
        this.currentStadium = currentStadium;
        this.matchesPlayed = matchesPlayed;
    }

    public void setCurrentMatchId(Long currentMatchId) {
        this.currentMatchId = currentMatchId;
    }

    public Long getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Long totalScore) {
        this.totalScore = totalScore;
    }

    public String getCurrentStadium() {
        return currentStadium;
    }

    public void setCurrentStadium(String currentStadium) {
        this.currentStadium = currentStadium;
    }

    private String currentStadium;

    public Player() {

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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getCurrentMatchId() {
        return currentMatchId;
    }

    public void setMatchId(Long currentMatchId) {
        this.currentMatchId = currentMatchId;
    }
}
