package br.ifpr.pi.pessoa.entities;

import br.ifpr.pi.core.entities.Endereco;

public class Imobiliaria extends Pessoa {
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
