package com.algaworks.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.algaworks.erp.model.Obra;

public class Obras implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Obras() {

	}

	public Obras(EntityManager manager) {
		this.manager = manager;
	}

	public Obra porId(String string) {
		return manager.find(Obra.class, string);
	}

	public List<Obra> pesquisar(String nome) {
		String jpql = "from Autor where nome like :nome";
		
		TypedQuery<Obra> query = manager
				.createQuery(jpql, Obra.class);
		
		query.setParameter("cpf", nome + "%");
		
		return query.getResultList();
	}
	
	public List<Obra> todas() {
         return manager.createQuery("from Obra", Obra.class).getResultList();
    }

	public Obra guardar(Obra obra) {
		return manager.merge(obra);
	}

	public void remover(Obra obra) {
		obra = porId(obra.getNome());
		manager.remove(obra);
	}
}