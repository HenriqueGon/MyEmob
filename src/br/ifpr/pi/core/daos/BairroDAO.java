package br.ifpr.pi.core.daos;

import java.util.List;

import javax.persistence.EntityManager;

import br.ifpr.pi.core.entities.Bairro;

public class BairroDAO {
	
	private final EntityManager em;
	
	public BairroDAO(EntityManager em) {
		this.em = em;
	}
	
	private EntityManager getEm() {
		return this.em;
	}
	
	public void cadastrar(Bairro bairro) {
		getEm().persist(bairro);
	}
	
	public void alterar(Bairro bairro) {
		getEm().merge(bairro);
	}
	
	public void inativar(Bairro bairro) {
		bairro.setStatusAtivo('I');
		getEm().merge(bairro);
	}
	
	public Bairro getBairroPorId(Long id) {
		return getEm().find(Bairro.class, id);
	}
	
	public List<Bairro> getTodosBairrosAtivos(){
		String query = "from bairro WHERE status_ativo = 'A'";
		
		return getEm().createQuery(query, Bairro.class).getResultList();
	}

}








