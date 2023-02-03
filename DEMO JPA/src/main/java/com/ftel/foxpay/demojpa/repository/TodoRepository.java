package com.ftel.foxpay.demojpa.repository;

import com.ftel.foxpay.demojpa.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
