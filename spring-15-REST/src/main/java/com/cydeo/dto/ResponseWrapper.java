package com.cydeo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class ResponseWrapper {

    private boolean success;
    private String message;
    private Integer code;
    private Object data; //why Object? because it covers everything, it can be CourseDTO, or any DTO.

    public ResponseWrapper(String message,Object data){
        this.message = message;
        this.data=data;
        this.code= HttpStatus.OK.value();
        this.success=true;
    }

    public ResponseWrapper(String message){
        this.message=message;
        this.code=HttpStatus.OK.value();
        this.success=true;
    }

    /*Why we use different constructors? Because of the separation.
     When we delete object, we won't be able to display body, we'll use second constructor to find deleted object.
     */

}
