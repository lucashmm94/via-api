package lucasti.viavarejo.models.entities;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clientes")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	@NotEmpty(message = "Nome não pode nulo ou branco")
	private String nome;
	
	@CPF(message="CPF inválido")
	@NotEmpty(message = "CPF não pode nulo ou branco")
	private String cpf;
	
	@NotEmpty(message = "Cidade não pode nulo ou branco")
	private String cidade;
	
	@NotEmpty(message = "UF não pode nulo ou branco")
	private String uf;
	
	public Cliente() {}
	
	
	
	public Cliente(String id, String nome, String cpf,String cidade, String uf) {
		this.nome = nome;
		this.cpf = cpf;
		this.cidade = cidade;
		this.uf = uf;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCidade() {
		return cidade;
	}



	public void setCidade(String cidade) {
		this.cidade = cidade;
	}



	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}



	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", uf=" + uf + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

	
	
}
