package br.ifpr.pi.pessoa.entities;

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

@Entity
@Table(name = "pessoa")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	@Column(name = "documento_federal", length = 18)
	private String documentoFederal;
	
	@Column(length = 16)
	private String telefone1;
	
	@Column(length = 16)
	private String telefone2;
	
	private String email;
	
	@Column(name = "status_ativo")
	private char statusAtivo;
	
	private Endereco endereco;
	
	@Column(name = "data_hora_cadastro", columnDefinition = "TIMESTAMP")
	@CreationTimestamp
	private LocalDateTime dataHoraCadastro;
	
	@Column(name = "data_hora_alteracao", columnDefinition = "TIMESTAMP")
	@UpdateTimestamp
	private LocalDateTime dataHoraAlteracao;
	
	@Deprecated
	public Pessoa() {}
	
	public Pessoa(String nome, String documentoFederal, String telefone1, 
			String telefone2, String email, Endereco endereco) {
		
		this.nome = nome;
		this.documentoFederal = documentoFederal;
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
		this.email = email;
		this.endereco = endereco;
		this.statusAtivo = 'A';
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumentoFederal() {
		return documentoFederal;
	}

	public void setDocumentoFederal(String documentoFederal) {
		this.documentoFederal = documentoFederal;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getStatusAtivo() {
		return statusAtivo;
	}

	public void setStatusAtivo(char statusAtivo) {
		this.statusAtivo = statusAtivo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public LocalDateTime getDataHoraCadastro() {
		return dataHoraCadastro;
	}

	public LocalDateTime getDataHoraAlteracao() {
		return dataHoraAlteracao;
	}
}
