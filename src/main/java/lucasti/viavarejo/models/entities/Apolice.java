package lucasti.viavarejo.models.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lucasti.viavarejo.exceptions.BusinessException;

@Document(collection = "apolices")
public class Apolice implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String numero ;
	
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate vigenciaInicio;
	
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate vigenciaFim;
	
	@NotEmpty(message="Placa de veículo não pode ser nulo")
	private String placaVeiculo;
	
	@NotNull
	private Double valor;
	
	@NotNull
	@DBRef
	private Cliente cliente;
	
	public Apolice () {}
	

	public Apolice(LocalDate vigenciaInicio, LocalDate vigenciaFim, String placaVeiculo, Double valor,
			Cliente cliente) {
		if (vigenciaFim.isBefore(vigenciaInicio)) {
			throw new BusinessException("Data de inicio não pode ser maior que data fim");
		}
		this.vigenciaInicio = vigenciaInicio;
		this.vigenciaFim = vigenciaFim;
		this.placaVeiculo = placaVeiculo;
		this.valor = valor;
		this.cliente = cliente;
	}




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




	@Override
	public String toString() {
		return "Apolice [numero=" + numero + ", vigenciaInicio=" + vigenciaInicio + ", vigenciaFim=" + vigenciaFim
				+ ", placaVeiculo=" + placaVeiculo + ", valor=" + valor + ", cliente=" + cliente + "]";
	}
}
