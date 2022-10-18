package com.pixiesarg.back.exception;

public class ParamNotFound extends RuntimeException{
    public ParamNotFound(String error){
        super(error);
    }
}
