package br.ifpr.pi.pessoa.daos;

import java.util.List;

import javax.persistence.EntityManager;

import br.ifpr.pi.pessoa.entities.Proprietario;

public class ProprietarioDao {
	
	private final EntityManager em;
	
	public ProprietarioDao(EntityManager em) {
		this.em = em;
	}
	
	private EntityManager getEm() {
		return em;
	}
	
	public void cadastrar(Proprietario proprietario) {
		getEm().persist(proprietario);
	}
	
	public void alterar(Proprietario proprietario) {
		getEm().merge(proprietario);
	}
	
	public void inativar(Proprietario proprietario) {
		proprietario.setStatusAtivo('I');
		
		getEm().merge(proprietario);
	}
	
	public Proprietario getProprietarioPorId(Long id) {
		return getEm().find(Proprietario.class, id);
	}
	
	public List<Proprietario> getTodosProprietariosAtivos(){
		String query = "from proprietario WHERE status_ativo = 'A'";
		
		return getEm().createQuery(query, Proprietario.class).getResultList();
	}
	
	public void finalizar() {
		if (getEm().isOpen()) {
			getEm().close();
		}
	}
}
