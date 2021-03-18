package br.ifpr.pi.contrato.daos;

import java.util.List;

import javax.persistence.EntityManager;

import br.ifpr.pi.contrato.entities.Imovel;

public class ImovelDao {
	
	private final EntityManager em;
	
	public ImovelDao(EntityManager em) {
		this.em = em;
	}
	
	private EntityManager getEm() {
		return this.em;
	}
	
	public void cadastrar(Imovel imovel) {
		this.getEm().persist(imovel);
	}
	
	public void alterar(Imovel imovel) {
		this.getEm().merge(imovel);
	}
	
	public void inativar(Imovel imovel) {
		imovel.setStatusAtivo('I');
		
		this.getEm().merge(imovel);
	}
	
	public Imovel getImovelPorId(Long id) {
		return this.getEm().find(Imovel.class, id);
	}
	
	public List<Imovel> getTodosImoveisAtivos() {
		String query = "FROM imovel WHERE status_ativo = 'A'";
		
		return this.getEm().createQuery(query, Imovel.class).getResultList();
	}
}
