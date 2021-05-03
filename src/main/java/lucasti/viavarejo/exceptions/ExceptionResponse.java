package lucasti.viavarejo.exceptions;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ExceptionResponse {

	private LocalDate data;
	  private String mensagem;
	  private String detalhes;
	  private String httpCodeMessage;
	  
	  public ExceptionResponse(LocalDate data, String message, String details,String httpCodeMessage) {
	    super();
	    this.data = data;
	    this.mensagem = message;
	    this.detalhes = details;
	    this.httpCodeMessage=httpCodeMessage;
	  }
	  
	  public String getHttpCodeMessage() {
	    return httpCodeMessage;
	  }
	  
	  public LocalDate getTimestamp() {
	    return data;
	  }
	  
	  public String getMensagem() {
	    return mensagem;
	  }
	  
	  public String getDetalhes() {
	    return detalhes;
	  }
}
