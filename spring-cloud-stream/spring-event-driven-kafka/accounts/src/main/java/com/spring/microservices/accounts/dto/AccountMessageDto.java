package com.spring.microservices.accounts.dto;


public class AccountMessageDto {

    public Long accountNumber;
    public String name;
    public String email;
    public String mobileNumber;

    public AccountMessageDto(Long accountNumber, String name, String email, String mobileNumber) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public AccountMessageDto() {
    }

    @Override
    public String toString() {
        return "AccountMessageDto{" +
                "accountNumber=" + accountNumber +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }


}

