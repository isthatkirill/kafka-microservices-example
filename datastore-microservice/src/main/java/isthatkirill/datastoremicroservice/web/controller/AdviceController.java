package isthatkirill.datastoremicroservice.web.controller;

import isthatkirill.datastoremicroservice.model.exception.BankNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Kirill Emelyanov
 */

@Slf4j
@RestControllerAdvice
public class AdviceController {

    @ExceptionHandler(BankNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String bankNotFound(final BankNotFoundException e) {
        log.error(e.getMessage());
        return "Bank not found";
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String internalServerError(final Exception e) {
        log.error(e.getMessage());
        return "Something went wrong";
    }


}
