package br.ifpr.pi.pessoa.daos;

import java.util.List;

import javax.persistence.EntityManager;

import br.ifpr.pi.pessoa.entities.Fiador;

public class FiadorDao {
	
	private final EntityManager em;
	
	public FiadorDao(EntityManager em) {
		this.em = em;
	}
	
	private EntityManager getEm() {
		return this.em;
	}
	
	public void cadastrar(Fiador fiador) {
		getEm().persist(fiador);
	}
	
	public void alterar(Fiador fiador) {
		getEm().merge(fiador);
	}
	
	public void inativar(Fiador fiador) {
		fiador.setStatusAtivo('I');
		
		getEm().merge(fiador);
	}
	
	public Fiador getFiadorPorId(Long id) {
		return getEm().find(Fiador.class, id);
	}
	
	public List<Fiador> getTodosFiadoresAtivos(){
		String query = "from fiador WHERE status_ativo = 'A'";
		
		return getEm().createQuery(query, Fiador.class).getResultList();
	}
	
	public void finalizar() {
		if (getEm().isOpen()) {
			getEm().close();
		}
	}
}
