package br.ifpr.pi.core.daos;

import java.util.List;

import javax.persistence.EntityManager;

import br.ifpr.pi.core.entities.Endereco;

public class EnderecoDao {
	
	private final EntityManager em; 
	
	public EnderecoDao(EntityManager em) {
		this.em = em;
	}
	
	private EntityManager getEm() {
		return this.em;
	}
	
	public void cadastrar(Endereco endereco) {
		getEm().persist(endereco);
	}
	
	public void alterar(Endereco endereco) {
		getEm().merge(endereco);
	}
	
	public void inativar(Endereco endereco) {
		endereco.setStatusAtivo('I');
		
		getEm().merge(endereco);
	}
	
	public Endereco getEnderecoPorId(Long id) {
		return getEm().find(Endereco.class, id);
	}
	
	public List<Endereco> getTodosEnderecosAtivos() {
		String query = "from endereco WHERE status_ativo = 'A'";
				
		return getEm().createQuery(query, Endereco.class).getResultList();
	}
	
	public void finalizar() {
		if (getEm().isOpen()) {
			getEm().close();
		}
	}
}
