package br.ifpr.pi.pessoa.daos;

import java.util.List;

import javax.persistence.EntityManager;

import br.ifpr.pi.pessoa.entities.Contratante;

public class ContratanteDao {
	
	private final EntityManager em;
	
	public ContratanteDao(EntityManager em) {
		this.em = em;
	}
	
	private EntityManager getEm() {
		return this.em;
	}
	
	public void cadastrar(Contratante contratante) {
		getEm().persist(contratante);
	}
	
	public void alterar(Contratante contratante) {
		getEm().merge(contratante);
	}
	
	public void inativar(Contratante contratante) {
		contratante.setStatusAtivo('I');
		
		getEm().merge(contratante);
	}
	
	public Contratante getContratantePorId(Long id) {
		return getEm().find(Contratante.class, id);
	}
	
	public List<Contratante> getTodosContratantesAtivos(){
		String query = "from contratante WHERE status_ativo = 'A'";
		
		return getEm().createQuery(query, Contratante.class).getResultList();
	}
	
	public void finalizar() {
		if (getEm().isOpen()) {
			getEm().close();
		}
	}
	
}
