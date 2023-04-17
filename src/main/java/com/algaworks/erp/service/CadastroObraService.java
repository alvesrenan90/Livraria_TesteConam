package com.algaworks.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.erp.model.Obra;
import com.algaworks.erp.repository.Obras;
import com.algaworks.erp.util.Transacional;

public class CadastroObraService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Obras obras;

    @Transacional
    public void salvar(Obra obra) {
        obras.guardar(obra);
    }

    @Transacional
    public void excluir(Obra obra) {
        obras.remover(obra);
    }

}