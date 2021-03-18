package br.ifpr.pi.core.daos;

import java.util.List;

import javax.persistence.EntityManager;

import br.ifpr.pi.core.entities.Rua;

public class RuaDAO {
	
	private final EntityManager em;
	
	public RuaDAO(EntityManager em) {
		this.em = em;
	}
	
	private EntityManager getEm() {
		return this.em;
	}
	
	public void cadastrar(Rua rua) {
		getEm().persist(rua);
	}
	
	public void alterar(Rua rua) {
		getEm().merge(rua);
	}
	
	public void inativar(Rua rua) {
		rua.setStatusAtivo('I');
		getEm().merge(rua);
	}
	
	public Rua getRuaPorId(Long id) {
		return getEm().find(Rua.class, id);
	}
	
	public List<Rua> getTodasRuasAtivas(){
		String query = "from rua WHERE status_ativo = 'A'";
		
		return getEm().createQuery(query, Rua.class).getResultList();
	}
}





















