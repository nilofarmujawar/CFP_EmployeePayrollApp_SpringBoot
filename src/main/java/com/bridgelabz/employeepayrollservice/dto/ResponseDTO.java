package com.bridgelabz.employeepayrollservice.dto;

/**
 * create a class name as ResponseDTO
 */
public class ResponseDTO {
    private final String message;
    /**
     * vriables
     */
    private String messsage;
    private Object data;

    /**
     * create a paramteized constructor
     * @param message - msgs
     * @param data - employee data
     */
    public ResponseDTO(String message, Object data) {
        super();
        /**
         *  The this keyword is used to refer to the current object.
         */
        this.message = message;
        this.data = data;
    }

    /**
     * crete a get method name as getMessage
     * The get method returns the value of the variable
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * The set method takes a parameter (message) and assigns it to the message variable
     * @param message
     */
    public void setMessage(String message) {
        this.messsage = message;
    }

    /**
     * crete a get method name as getData
     * The get method returns the value of the variable
     * @return data
     */
    public Object getData() {
        return data;
    }

    /**
     * The set method takes a parameter (data) and assigns it to the data variable
     * @param data
     */
    public void setData(Object data) {
        this.data = data;
    }
}
