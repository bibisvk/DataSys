package com.example.demo.borrowings;

import com.example.demo.cars.CarEntity;
import com.example.demo.customers.CustomerEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "borrowings")
public class BorrowingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="borrowing_id",updatable = false, nullable = false)
    private Long borrowingId;

    @JoinColumn(name = "customerId")
    @ManyToOne(fetch = FetchType.LAZY)
    private CustomerEntity borrower;

    @JoinColumn(name = "carId")
    @ManyToOne(fetch = FetchType.LAZY)
    private CarEntity borrowedCar;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate borrowingStartDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate borrowingEndDate;


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

    public void setBorrowingId(long borrowingId) {
        this.borrowingId = borrowingId;
    }
    public Long getBorrowingId() {
        return borrowingId;
    }

    public void setBorrowingId(Long borrowingId) {
        this.borrowingId = borrowingId;
    }
    public void setBorrower(CustomerEntity borrower){this.borrower = borrower;}
    public CustomerEntity getBorrower(){
        return borrower;
    }

    public void setBorrowedCar(CarEntity car){
        this.borrowedCar = car;
    }

    public CarEntity getBorrowedCar(){
        return borrowedCar;
    }

}
