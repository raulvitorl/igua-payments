package br.com.igua.payments.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * The type Resource not found exception.
 *
 * @author Givantha Kalansuriya
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CieloPaymentException extends Exception {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

/**
   * Instantiates a new Resource not found exception.
   *
   * @param message the message
   */
  public CieloPaymentException(String message) {
    super(message);
  }
}
