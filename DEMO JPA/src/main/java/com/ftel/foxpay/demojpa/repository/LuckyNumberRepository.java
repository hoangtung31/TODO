package com.ftel.foxpay.demojpa.repository;

import com.ftel.foxpay.demojpa.model.LuckyNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LuckyNumberRepository extends JpaRepository<LuckyNumber, Long> {

}
