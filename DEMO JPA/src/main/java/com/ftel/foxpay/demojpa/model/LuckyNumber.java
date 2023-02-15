package com.ftel.foxpay.demojpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class LuckyNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dateOfPrize;
    private String specialPrize;
    private String firstPrize;
    private String secondPrize;
    private String thirdPrize;
    private String fourthPrize;
    private String fifthPrize;
    private String sixthPrize;
    private String seventhPrize;
}
