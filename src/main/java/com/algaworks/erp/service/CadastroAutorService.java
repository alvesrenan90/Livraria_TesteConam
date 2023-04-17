package com.algaworks.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.erp.model.Autor;
import com.algaworks.erp.repository.Autores;
import com.algaworks.erp.util.Transacional;

public class CadastroAutorService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Autores autores;

    @Transacional
    public void salvar(Autor autor) {
        autores.guardar(autor);
    }

    @Transacional
    public void excluir(Autor autor) {
        autores.remover(autor);
    }

}