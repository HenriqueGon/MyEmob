package br.ifpr.pi.pessoa.daos;

import java.util.List;

import javax.persistence.EntityManager;

import br.ifpr.pi.pessoa.entities.Imobiliaria;

public class ImobiliariaDao {
	
	private final EntityManager em;
	
	public ImobiliariaDao(EntityManager em) {
		this.em = em;
	}
	
	private EntityManager getEm() {
		return this.em;
	}
	
	public void cadastrar(Imobiliaria imobiliaria) {
		this.getEm().persist(imobiliaria);
	}
	
	public void alterar(Imobiliaria imobiliaria) {
		this.getEm().merge(imobiliaria);
	}
	
	public void inativar(Imobiliaria imobiliaria) {
		imobiliaria.setStatusAtivo('I');
		
		this.getEm().merge(imobiliaria);
	}
	
	public Imobiliaria getImobiliariaPorId(Long id) {
		return this.getEm().find(Imobiliaria.class, id);
	}
	
	public List<Imobiliaria> getTodasImobiliariasAtivas() {
		String query = "FROM imobiliaria WHERE status_ativo = 'A'";
		
		return this.getEm().createQuery(query, Imobiliaria.class).getResultList();
	}
}
