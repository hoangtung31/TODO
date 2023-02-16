package com.ftel.foxpay.demojpa.service;

import com.ftel.foxpay.demojpa.model.LuckyNumber;
import com.ftel.foxpay.demojpa.repository.LuckyNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LuckyNumberService {
    @Autowired
    LuckyNumberRepository luckyNumberRepository;

    public LuckyNumber addLuckyNumber(LuckyNumber ln) {
        System.out.println(ln);
        System.out.println("ADDED!");
        return luckyNumberRepository.save(ln);
    }

    public List<LuckyNumber> findAll(Integer limit) {
        return Optional.ofNullable(limit)
                .map(value -> luckyNumberRepository.findAll(PageRequest.of(0, value)).getContent())
                .orElseGet(() -> luckyNumberRepository.findAll());
    }
}
