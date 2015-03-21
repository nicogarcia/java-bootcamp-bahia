package com.globant.app.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Order already paid")
public class OrderAlreadyPaidException extends RuntimeException {
}
