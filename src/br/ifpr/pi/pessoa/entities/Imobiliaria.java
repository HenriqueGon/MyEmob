package br.ifpr.pi.pessoa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.ifpr.pi.core.entities.Endereco;

@Entity
@Table (name = "imobiliaria")
public class Imobiliaria extends Pessoa {
	@Column (name = "razao_social")
	private String razaoSocial;

	@Deprecated
	public Imobiliaria() {}
	
	public Imobiliaria(String nome, String documentoFederal, String telefone1,
			String telefone2, String email, Endereco endereco, String razaoSocial) {
		super(nome, documentoFederal, telefone1, telefone2, email, endereco);
		
		this.razaoSocial = razaoSocial;
	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
}
