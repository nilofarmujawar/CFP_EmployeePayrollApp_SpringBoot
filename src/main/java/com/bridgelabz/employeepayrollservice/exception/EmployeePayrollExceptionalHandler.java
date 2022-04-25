package com.bridgelabz.employeepayrollservice.exception;

import com.bridgelabz.employeepayrollservice.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @@ControllerAdvice :-
 *                @ControllerAdvice is a specialization of the @Component annotation which allows to handle exceptions across the whole application in one global handling component.
 *                It can be viewed as an interceptor of exceptions thrown by methods annotated with @RequestMapping and similar.
 *
 * - Created to handle controller class exception
 */
@ControllerAdvice
public class EmployeePayrollExceptionalHandler {
    /**
     * @ExceptionHandler :-
     *        is an annotation used to handle the specific exceptions and sending the custom responses to the client.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception) {

        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errMesg = errorList.stream().map(objErr -> objErr.getDefaultMessage()).collect(Collectors.toList());

        ResponseDTO responseDTO = new ResponseDTO("Exception while processing REST requests", errMesg);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(EmployeePayrollException.class)
    public ResponseEntity<ResponseDTO> handleEmployeeNotFound(EmployeePayrollException exception) {
        ResponseDTO response = new ResponseDTO("Invalid id input", exception.getMessage());
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.BAD_REQUEST);
    }
}