package br.ifpr.pi.pessoa.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.ifpr.pi.core.entities.Endereco;

@Entity
@Table (name = "usuario")
public class Usuario extends Pessoa {
	private Imobiliaria imobiliaria;
	private String login;
	private String senha;
	private char tipo;
	
	@Deprecated
	public Usuario() {}
	
	public Usuario(String nome, String documentoFederal, String telefone1,
			String telefone2, String email, Endereco endereco, Imobiliaria imobiliaria,
			String login, String senha, char tipo) {
		super(nome, documentoFederal, telefone1, telefone2, email, endereco);
		
		this.imobiliaria = imobiliaria;
		this.login = login;
		this.senha = senha;
		this.tipo = tipo;
	}

	public Imobiliaria getImobiliaria() {
		return imobiliaria;
	}
	
	public void setImobiliaria(Imobiliaria imobiliaria) {
		this.imobiliaria = imobiliaria;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
}
