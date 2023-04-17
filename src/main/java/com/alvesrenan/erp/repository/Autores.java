package com.alvesrenan.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.alvesrenan.erp.model.Autor;

public class Autores implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Autores() {

	}

	public Autores(EntityManager manager) {
		this.manager = manager;
	}

	public Autor porId(String string) {
		return manager.find(Autor.class, string);
	}

	public List<Autor> pesquisar(String nome) {
		String jpql = "from Autor where cpf like :cpf";
		
		TypedQuery<Autor> query = manager
				.createQuery(jpql, Autor.class);
		
		query.setParameter("cpf", nome + "%");
		
		return query.getResultList();
	}
	
	public List<Autor> todas() {
         return manager.createQuery("from Autor", Autor.class).getResultList();
    }

	public Autor guardar(Autor autor) {
		return manager.merge(autor);
	}

	public void remover(Autor autor) {
		autor = porId(autor.getCpf());
		manager.remove(autor);
	}
}