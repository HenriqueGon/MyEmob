package br.ifpr.pi.pessoa.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.ifpr.pi.core.entities.Endereco;

@Entity
@Table(name = "proprietario")
public class Proprietario extends Pessoa {
	
	@OneToMany
	private Imobiliaria imobiliaria;
	
	@Deprecated
	public Proprietario() {}
	
	public Proprietario(String nome, String documentoFederal, String telefone1,
			String telefone2, String email, Endereco endereco, Imobiliaria imobiliaria) {
		super(nome, documentoFederal, telefone1, telefone2, email, endereco);
		
		this.imobiliaria = imobiliaria;
	}
	
	public Imobiliaria getImobiliaria() {
		return imobiliaria;
	}
	
	public void setImobiliaria(Imobiliaria imobiliaria) {
		this.imobiliaria = imobiliaria;
	}
}
