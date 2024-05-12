package edu.java.studentorder.domain;
import java.time.LocalDate;

public abstract class Person
{
    private String surName;
    private String givenName;
    private String patronymicName;
    private LocalDate dataOfBirth;

    public Person(String surName, LocalDate dataOfBirth, String patronymicName, String givenName) {
        this.surName = surName;
        this.dataOfBirth = dataOfBirth;
        this.patronymicName = patronymicName;
        this.givenName = givenName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public void setPatronymicName(String patronymicName) {
        this.patronymicName = patronymicName;
    }

    public LocalDate getDataOfBirth() {
        return dataOfBirth;
    }

    public void setDataOfBirth(LocalDate dataOfBirth) {
        this.dataOfBirth = dataOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    private Address address;
}
