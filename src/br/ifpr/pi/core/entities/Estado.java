package br.ifpr.pi.core.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "estado")
public class Estado {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(unique = true)
	private String nome;
	
	@Column(length = 2)
	private String sigla;
	
	@Column(name = "status_ativo", length = 1)
	private char statusAtivo;
	
	@Column(name = "data_hora_cadastro", columnDefinition = "TIMESTAMP")
	@UpdateTimestamp
	private LocalDateTime dataHoraCadastro;
	
	@Column(name = "data_hora_alteracao", columnDefinition = "TIMESTAMP")
	@UpdateTimestamp
	private LocalDateTime dataHoraAlteracao;
	
	@Deprecated
	public Estado() {}
	
	public Estado(String nome, String sigla) {
		this.nome = nome;
		this.sigla = sigla;
		this.statusAtivo = 'A';
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public char getStatusAtivo() {
		return statusAtivo;
	}

	public void setStatusAtivo(char statusAtivo) {
		this.statusAtivo = statusAtivo;
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
		
		Estado other = (Estado) obj;
		
		if (id == null) {
			if (other.id != null)
				return false;
			
		} else if (!id.equals(other.id))
			return false;
		
		return true;
	}
	
	@Override
	public String toString() {
		return this.nome + this.sigla;
	}
}




















