package com.ftel.foxpay.demojpa.controller;

import com.ftel.foxpay.demojpa.model.ErrorMessage;
import com.ftel.foxpay.demojpa.model.LuckyNumber;
import com.ftel.foxpay.demojpa.service.LuckyNumberService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("api/v1")
public class LuckyNumberController {
    @Autowired
    LuckyNumberService luckyNumberService;
    List<LuckyNumber> luckyNumbers = new CopyOnWriteArrayList<>();

    @PostConstruct
    public void init() {

    }

    @GetMapping("/lucky_number")
    public ResponseEntity getListLuckyNumber() {
        luckyNumbers = luckyNumberService.findAll(10);
        return ResponseEntity.ok().body(new ErrorMessage(1, "Success", luckyNumbers));
    }

    @GetMapping("/lucky_number/{luckyNumberId}")
    public ResponseEntity getLuckyNumber(@PathVariable(name = "luckyNumberId") Integer luckyNumberId) {
        return ResponseEntity.ok().body(new ErrorMessage(1, "Success", luckyNumbers.get(luckyNumberId)));
    }

    @RestControllerAdvice
    public static class APIExceptionHandler {
        // All undeclared exceptions will be handled here
        @ExceptionHandler(Exception.class)
        @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
        public ErrorMessage handleAllException(Exception ex, WebRequest request) {
            // Handle error process
            return new ErrorMessage(-1, ex.getLocalizedMessage(), null);
        }

        @ExceptionHandler(IndexOutOfBoundsException.class)
        @ResponseStatus(value = HttpStatus.BAD_REQUEST)
        public ErrorMessage modelNotExist(Exception ex, WebRequest request) {
            return new ErrorMessage(10100, "Model not exists", null);
        }
    }
}
