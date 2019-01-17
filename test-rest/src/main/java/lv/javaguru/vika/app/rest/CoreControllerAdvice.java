package lv.javaguru.vika.app.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = EventRestController.class)
public class CoreControllerAdvice {

	private static final Logger log = LoggerFactory.getLogger(CoreControllerAdvice.class);

	/*
	  @ExceptionHandler(CoreValidationError.class) public ResponseEntity<ErrorDTO>
	  handleValidationError(CoreValidationError error, HttpServletRequest request)
	  { log.error("Validation error", error);
	  
	  ErrorDTO errorDTO = new ErrorDTO();
	  errorDTO.setErrorCode(error.getErrorCode());
	  errorDTO.setDescription(error.getDescription());
	  errorDTO.setErrorEmitter(error.getErrorEmitter()); return
	  ResponseEntity.status(error.getErrorCode().getHttpCode()).body(errorDTO); }
	  
	  @ExceptionHandler(Throwable.class) public ResponseEntity<ErrorDTO>
	  handleValidationError(Throwable error, HttpServletRequest request) {
	  log.error("Internal error", error);
	  
	  ErrorDTO errorDTO = new ErrorDTO();
	  errorDTO.setErrorCode(ErrorCode.INTERNAL);
	  errorDTO.setDescription("Unexpected server error");
	 errorDTO.setErrorEmitter(ErrorEmitter.CORE_APP); return
	  ResponseEntity.status(ErrorCode.INTERNAL.getHttpCode()).body(errorDTO); }
	 */

}
