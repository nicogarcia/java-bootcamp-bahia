package com.globant.app.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Customer does not have a saved cart")
public class CustomerDoesNotHaveACartException extends RuntimeException {
}
