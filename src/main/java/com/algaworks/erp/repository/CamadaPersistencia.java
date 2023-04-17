package com.algaworks.erp.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.erp.model.Autor;
import com.algaworks.erp.model.Obra;
import com.algaworks.erp.model.PaisOrigem;

public class CamadaPersistencia {
	
	public static void main(String[] args) {		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AlvesRenan90");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		//Declarando os repositórios
		Obras obras = new Obras(em);
		Autores autores = new Autores(em);
		
		//Buscando as informações do banco
		List<Obra> listaDeObras = obras.pesquisar("");
		List<Autor> listaDeAutores = autores.pesquisar("");
		System.out.println(listaDeAutores);
		
		//Criando um autor
		Autor autor = new Autor();		
		autor.setNome("João da Silva");
		autor.setSexo("Masculino");
		autor.setDataNascimento(new Date());
		autor.setPaisOrigem(PaisOrigem.Brasil);
		autor.setCpf("484.107.100-80");
		autor.setObra(listaDeObras.get(0));		
		
		//Salvando a empresa
		autores.guardar(autor);
		
		em.getTransaction().commit();
		
		//Verificando se a inserção funcionou
		List<Autor> listaDeAutores2 = autores.pesquisar("");
		System.out.println(listaDeAutores2);
		
		
		em.close();
		emf.close();
	}

}