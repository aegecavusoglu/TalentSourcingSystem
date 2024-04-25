package com.example.talentsourcingsystem.exception;

public class CandidateNotFoundException extends RuntimeException{
    public CandidateNotFoundException(String message){
        super(message);
    }
}
