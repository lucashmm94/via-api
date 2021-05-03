package lucasti.viavarejo.models.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.annotation.JsonFormat;

import lucasti.viavarejo.models.entities.Cliente;

public class ApoliceDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String numero;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate vigenciaInicio;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate vigenciaFim;

	private String placaVeiculo;
	
	private Double valor;

	private Cliente cliente;

	private Boolean isVenceu;

	private String quantosDiasVencerVencido;
		

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDate getVigenciaInicio() {
		return vigenciaInicio;
	}

	public void setVigenciaInicio(LocalDate vigenciaInicio) {
		this.vigenciaInicio = vigenciaInicio;
	}

	public LocalDate getVigenciaFim() {
		return vigenciaFim;
	}

	public void setVigenciaFim(LocalDate vigenciaFim) {
		this.vigenciaFim = vigenciaFim;
	}

	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Boolean getIsVenceu() {
		return isVenceu;
	}

	public void setIsVenceu(Boolean isVenceu) {
		this.isVenceu = isVenceu;
	}

	public String getQuantosDiasVencerVencido() {
		return quantosDiasVencerVencido;
	}

	public void setQuantosDiasVencerVencido(String quantosDiasVencerVencido) {
		this.quantosDiasVencerVencido = quantosDiasVencerVencido;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	@Override
	public String toString() {
		return "ApoliceDTO [numero=" + numero + ", vigenciaInicio=" + vigenciaInicio + ", vigenciaFim=" + vigenciaFim
				+ ", placaVeiculo=" + placaVeiculo + ", valor=" + valor + ", cliente=" + cliente + ", isVenceu="
				+ isVenceu + ", quantosDiasVencerVencido=" + quantosDiasVencerVencido + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApoliceDTO other = (ApoliceDTO) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	
}
