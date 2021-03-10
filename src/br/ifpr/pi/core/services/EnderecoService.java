package br.ifpr.pi.core.services;

import java.io.PrintStream;
import java.util.List;

import javax.persistence.EntityManager;

import br.ifpr.pi.core.entities.Endereco;
import br.ifpr.pi.infra.EntityManagerFactoryProducer;

public class EnderecoService {
	
	private final EntityManager entityManager; 
	private final PrintStream print;
	
	public EnderecoService() {
		this.entityManager = EntityManagerFactoryProducer.createEntityManager();
		this.print = System.out;
	}
	
	public EnderecoService(EntityManager entityManager) {
		this.entityManager = entityManager;
		this.print = System.out;
	}
	
	private EntityManager getEntityManager() {
		return this.entityManager;
	}
	
	public void cadastrar(Endereco endereco) {
		try {
			getEntityManager().getTransaction().begin();
			getEntityManager().persist(endereco);
			getEntityManager().getTransaction().commit();
			
			this.print.println("Endereço cadastrado com sucesso!");
		} catch (Exception ex) {
			getEntityManager().getTransaction().rollback();
			
			this.print.println("Um erro ocorreu durante o cadastro do endereço");
			this.print.println("Erro: " + ex.getMessage());
		}
	}
	
	public void alterar(Endereco endereco) {
		try {
			getEntityManager().getTransaction().begin();
			getEntityManager().merge(endereco);
			getEntityManager().getTransaction().commit();
			
			this.print.println("Endereço alterado com sucesso!");
		} catch (Exception ex) {
			getEntityManager().getTransaction().rollback();
			
			this.print.println("Um erro ocorreu durante a alteração do endereço");
			this.print.println("Erro:" + ex.getMessage());
		}
	}
	
	public void inativar(Endereco endereco) {
		endereco.setStatusAtivo('I');
		
		try {
			getEntityManager().getTransaction().begin();
			getEntityManager().merge(endereco);
			getEntityManager().getTransaction().commit();
		} catch (Exception ex) {
			getEntityManager().getTransaction().rollback();
			
			this.print.println("Um erro ocorreu durante a inativação do endereço");
			this.print.println("Erro:" + ex.getMessage());
		}
	}
	
	public Endereco getEnderecoPorId(Long id) {
		return getEntityManager().find(Endereco.class, id);
	}
	
	public List<Endereco> getTodosEnderecosAtivos() {
		String query = "from Endereco WHERE statusAtivo = 'A'";
				
		return getEntityManager().createQuery(query, Endereco.class).getResultList();
	}
	
	public void finalizar() {
		if (getEntityManager().isOpen()) {
			getEntityManager().close();
		}
	}
}
