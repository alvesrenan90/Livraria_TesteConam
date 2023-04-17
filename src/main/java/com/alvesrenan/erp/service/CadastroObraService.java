package com.alvesrenan.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.alvesrenan.erp.model.Obra;
import com.alvesrenan.erp.repository.Obras;
import com.alvesrenan.erp.util.Transacional;

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