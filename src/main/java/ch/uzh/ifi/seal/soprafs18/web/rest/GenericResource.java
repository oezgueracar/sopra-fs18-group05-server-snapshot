package ch.uzh.ifi.seal.soprafs18.web.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpServerErrorException;

import java.io.IOException;

public abstract class GenericResource {

	Logger logger = LoggerFactory.getLogger(GenericResource.class);

	@ExceptionHandler(TransactionSystemException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public void handleTransactionSystemException(Exception exception, HttpServletRequest request) {
		logger.error("", exception);
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public void handleException(Exception exception, HttpServletRequest request) {
		logger.error("", exception);
	}

	@ExceptionHandler
	private void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.BAD_REQUEST.value());
	}

	@ExceptionHandler
	private void handleRuntimeException(RuntimeException e, HttpServletResponse response) throws IOException{
		response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
	}
}
