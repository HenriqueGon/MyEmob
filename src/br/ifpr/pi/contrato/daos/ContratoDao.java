package br.ifpr.pi.contrato.daos;

import java.util.List;

import javax.persistence.EntityManager;

import br.ifpr.pi.contrato.entities.Contrato;

public class ContratoDao {

	private final EntityManager em;
	
	public ContratoDao(EntityManager em) {
		this.em = em;
	}
	
	public EntityManager getEm() {
		return em;
	}
	
	public void cadastrar(Contrato contrato) {
		getEm().persist(contrato);
	}
	
	public void alterar(Contrato contrato) {
		getEm().merge(contrato);
	}
	
	public void inativar(Contrato contrato) {
		contrato.setStatusAtivo('I');
		
		getEm().merge(contrato);
	}
	
	public Contrato getContratoPorId(Long id) {
		return getEm().find(Contrato.class, id);
	}
	
	public List<Contrato> getTodosContratosAtivos(){
		String query = "from contrato WHERE status_ativo = 'A'";
		
		return getEm().createQuery(query, Contrato.class).getResultList();
	}
	
	public void finalizar() {
		if (getEm().isOpen()) {
			getEm().close();
		}
	}
}
