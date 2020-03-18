package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TestandoEstados {

	public static void main(String[] args) {

		// transient objeto que existe na memoria mas nao tem ligacao com o bando de
		// dados
		Conta conta = new Conta();
		conta.setTitular("Almiro");
		conta.setAgencia(12312);
		conta.setNumero(312312312);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		// Transient -> Managed
		em.persist(conta);
		
		// Managed -> Removed
		em.remove(conta);
		
		em.getTransaction().commit();
		em.close();

	}
}
