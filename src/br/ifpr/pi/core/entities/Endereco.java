package br.ifpr.pi.core.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.print.attribute.standard.MediaSize.Other;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private int numero;
	
	private String complemento;
	
	private String referencia;
	
	private Rua rua;
	
	private char statusAtivo;
	
	@Column(columnDefinition = "TIMESTAMP")
	@CreationTimestamp
	private LocalDateTime dataHoraCadastro;
	
	@Column(columnDefinition = "TIMESTAMP")
	@UpdateTimestamp
	private LocalDateTime dataHoraAlteracao;
	
	@Deprecated
	public Endereco() {}
	
	public Endereco(int numero, String complemento, String referencia, Rua rua) {
		this.numero = numero;
		this.complemento = complemento;
		this.referencia = referencia;
		this.rua = rua;
		this.statusAtivo = 'A';
	}

	public long getId() {
		return id;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Rua getRua() {
		return rua;
	}

	public void setRua(Rua rua) {
		this.rua = rua;
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
	public boolean equals (Object obj) {
		if (this == obj) {
			return true;
		}
			
		if (obj == null) {
			return false;
		}

		if (getClass() != obj.getClass()) {
			return false;
		}
		
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} 
		
		else if (!id.equals(other.id)) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		return this.complemento + this.referencia;
	}
}
