package br.ifpr.pi.pessoa.daos;

import java.util.List;

import javax.persistence.EntityManager;

import br.ifpr.pi.pessoa.entities.Usuario;

public class UsuarioDao {
	
	private final EntityManager em;
	
	public UsuarioDao(EntityManager em) {
		this.em = em;
	}
	
	private EntityManager getEm() {
		return this.em;
	}
	
	public void cadastrar(Usuario usuario) {
		this.getEm().persist(usuario);
	}
	
	public void alterar(Usuario usuario) {
		this.getEm().merge(usuario);
	}
	
	public void inativar(Usuario usuario) {
		usuario.setStatusAtivo('I');
		
		this.getEm().merge(usuario);
	}
	
	public Usuario getUsuarioPorId(Long id) {
		return this.getEm().find(Usuario.class, id);
	}
	
	public List<Usuario> getTodosUsuarioAtivos() {
		String query = "FROM usuario WHERE status_ativo = 'A'";
		
		return this.getEm().createQuery(query, Usuario.class).getResultList();
	}
}
