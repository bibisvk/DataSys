package com.example.demo.borrowings;

import com.example.demo.cars.CarDto;
import com.example.demo.customers.CustomerDto;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Date;

public class BorrowingDto {
    private Long borrowingId;
    private Long carId;
    private Long customerId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate borrowingStartDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate borrowingEndDate;
    private String rodneCislo;

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getRodneCislo() {
        return rodneCislo;
    }

    public void setRodneCislo(String rodneCislo) {
        this.rodneCislo = rodneCislo;
    }

    public CustomerDto getCustomerDto() {
        return customerDto;
    }

    public void setCustomerDto(CustomerDto customerDto) {
        this.customerDto = customerDto;
    }

    private CustomerDto customerDto;


    public Long getBorrowingId() {
        return borrowingId;
    }

    public void setBorrowingId(Long borrowingId) {
        this.borrowingId = borrowingId;
    }


    public LocalDate getBorrowingStartDate() {
        return borrowingStartDate;
    }

    public void setBorrowingStartDate(LocalDate borrowingStartDate) {
        this.borrowingStartDate = borrowingStartDate;
    }

    public LocalDate getBorrowingEndDate() {
        return borrowingEndDate;
    }

    public void setBorrowingEndDate(LocalDate borrowingEndDate) {
        this.borrowingEndDate = borrowingEndDate;
    }


}
