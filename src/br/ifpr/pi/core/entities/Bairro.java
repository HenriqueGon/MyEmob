package br.ifpr.pi.core.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "bairro")
public class Bairro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	@OneToMany
	private Cidade cidade;
	
	@Column(name = "status_ativo", length = 1)
	private char statusAtivo;
	
	@Column(name = "data_hora_cadastro", columnDefinition = "TIMESTAMP")
	@CreationTimestamp
	private LocalDateTime dataHoraCadastro;
	
	@Column(name = "data_hora_alteracao", columnDefinition = "TIMESTAMP")
	@CreationTimestamp
	private LocalDateTime dataHoraAlteracao;
	
	@Deprecated
	public Bairro() {}
	
	public Bairro(String nome, Cidade cidade) {
		this.nome = nome;
		this.cidade = cidade;
		this.statusAtivo = 'A';
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public char getStatusAtivo() {
		return statusAtivo;
	}

	public void setStatusAtivo(char statusAtivo) {
		this.statusAtivo = statusAtivo;
	}

	public Long getId() {
		return id;
	}

	public LocalDateTime getDataHoraCadastro() {
		return dataHoraCadastro;
	}

	public LocalDateTime getDataHoraAlteracao() {
		return dataHoraAlteracao;
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bairro other = (Bairro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}	
}





















