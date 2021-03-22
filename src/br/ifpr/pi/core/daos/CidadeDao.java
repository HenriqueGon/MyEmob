package br.ifpr.pi.core.daos;

import java.util.List;

import javax.persistence.EntityManager;

import br.ifpr.pi.core.entities.Cidade;

public class CidadeDao {

	private final EntityManager em;
	
	public CidadeDao(EntityManager em) {
		this.em = em;
	}
	
	private EntityManager getEm() {
		return this.em;
	}
	
	public void cadastrar(Cidade cidade) {
		getEm().persist(cidade);
	}
	
	public void alterar(Cidade cidade) {
		getEm().merge(cidade);
	}
	
	public void inativar(Cidade cidade) {
		cidade.setStatusAtivo('I');
		getEm().merge(cidade);
	}
	
	public Cidade getCidadePorId(Long id) {
		return getEm().find(Cidade.class, id);
	}
	
	public List<Cidade> getTodasCidadesAtivas(){
		String query = "from cidade WHERE status_ativo = 'A'";
		
		return getEm().createQuery(query, Cidade.class).getResultList();
	}
}



















