package br.ifpr.pi.core.daos;

import java.util.List;

import javax.persistence.EntityManager;

import br.ifpr.pi.core.entities.Estado;

public class EstadoDAO {
	
	private final EntityManager em;
	
	public EstadoDAO(EntityManager em) {
		this.em = em;
	}
	
	private EntityManager getEm() {
		return this.em;
	}
	
	public void cadastrar (Estado estado) {
		getEm().persist(estado);
	}
	
	public void alterar(Estado estado) {
		getEm().merge(estado);
	}
	
	public void inativar(Estado estado) {
		estado.setStatusAtivo('I');
		getEm().merge(estado);
	}
	
	public Estado getEstadoPorId(Long id) {
		return getEm().find(Estado.class, id);
	}
	
	public List<Estado> getTodosEstadosAtivos(){
		String query = "from estado WHERE status_ativo = 'A'";
		
		return getEm().createQuery(query, Estado.class).getResultList();
	}
	
	public void finalizar() {
		if (getEm().isOpen()) {
			getEm().close();
		}
	}

}
