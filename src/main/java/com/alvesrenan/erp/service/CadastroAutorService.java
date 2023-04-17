package com.alvesrenan.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.alvesrenan.erp.model.Autor;
import com.alvesrenan.erp.repository.Autores;
import com.alvesrenan.erp.util.Transacional;

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