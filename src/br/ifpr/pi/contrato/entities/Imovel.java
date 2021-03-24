package br.ifpr.pi.contrato.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import br.ifpr.pi.core.entities.Endereco;
import br.ifpr.pi.pessoa.entities.Proprietario;

@Entity
@Table(name = "imovel")
public class Imovel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String descricao;
	
	@Column (name = "status_ativo", length = 1)
	private char statusAtivo;
	
	@Column(name = "data_hora_cadastro", columnDefinition = "TIMESTAMP")
	@CreationTimestamp
	private LocalDateTime dataHoraCadastro;
	
	@Column(name = "data_hora_alteracao", columnDefinition = "TIMESTAMP")
	@UpdateTimestamp
	private LocalDateTime dataHoraAlteracao;
	
	private Endereco endereco;
	private Proprietario proprietario;
	
	@Deprecated
	public Imovel() {}
	
	public Imovel (String descricao, Endereco endereco, Proprietario proprietario) {
		this.descricao = descricao;
		this.endereco = endereco;
		this.proprietario = proprietario;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public Proprietario getProprietario() {
		return proprietario;
	}
	
	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
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
		
		Imovel other = (Imovel) obj;
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
		return this.descricao;
	}
}
