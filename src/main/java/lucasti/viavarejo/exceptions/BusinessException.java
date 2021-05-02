package lucasti.viavarejo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class BusinessException  extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public BusinessException(String msg) {
		super(msg);
	}

}
