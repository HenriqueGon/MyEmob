package br.ifpr.pi.pessoa.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.ifpr.pi.core.entities.Endereco;

@Entity
@Table (name = "usuario")
public class Usuario extends Pessoa {
	private String login;
	private String senha;
	private char tipo;
	private Imobiliaria imobiliaria;
	
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
		
		Usuario other = (Usuario) obj;
		if (getId() == null) {
			if (other.getId() != null) {
				return false;
			}
		} 
		
		else if (!getId().equals(other.getId())) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		return this.getNome();
	}
}
