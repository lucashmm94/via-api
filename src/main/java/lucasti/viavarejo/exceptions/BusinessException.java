package lucasti.viavarejo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class BusinessException  extends RuntimeException {
	
	
	public BusinessException() {
		super();
	}

	public BusinessException(String msg) {
		super(msg);
	}

	
}
