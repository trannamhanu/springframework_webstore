package com.trann.webstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No products found for given category")
public class NoProductsFoundUnderCategoryException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1554251630974234515L;
	
}
