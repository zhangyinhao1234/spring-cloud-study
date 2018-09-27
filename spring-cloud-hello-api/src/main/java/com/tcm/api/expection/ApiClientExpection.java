package com.tcm.api.expection;

public class ApiClientExpection extends RuntimeException{

    /**
     * TODO 字段的作用/说明
     */
    private static final long serialVersionUID = 1L;
    
    
    public ApiClientExpection(String message) {
        super(message);
    }

}
