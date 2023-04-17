package com.algaworks.erp.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.convert.Converter;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.algaworks.erp.model.Obra;
import com.algaworks.erp.model.Autor;
import com.algaworks.erp.repository.Obras;
import com.algaworks.erp.repository.Autores;
import com.algaworks.erp.service.CadastroObraService;
import com.algaworks.erp.util.FacesMessages;

@Named
@ViewScoped
public class GestaoObrasBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private Obras obras;
    
    @Inject
    private FacesMessages messages;
    
    @Inject
    private Autores autores;
    
    @Inject
    private CadastroObraService cadastroObraService;
    
    private List<Obra> listaObras;
    
    private String termoPesquisa;
    
    private Converter autorConverter;
    
    private Obra obra;
    
    public void prepararNovaObra() {
        obra = new Obra();
    }
    
    public void salvar() {
        cadastroObraService.salvar(obra);
        
        if (jaHouvePesquisa()) {
            pesquisar();
        } else {
            todasObras();
        }
        
        messages.info("Obra salva com sucesso!");
        
        RequestContext.getCurrentInstance().update(Arrays.asList(
                "frm:obrasDataTable", "frm:messages"));
    }
    
    public void pesquisar() {
        listaObras = obras.pesquisar(termoPesquisa);
        
        if (listaObras.isEmpty()) {
            messages.info("Sua consulta não retornou registros.");
        }
    }
    
    public void todasObras() {
        listaObras = obras.todas();
    }
    
    public List<Autor> completarAutor(String termo) {
        List<Autor> listaAutores = autores.pesquisar(termo);
        
        autorConverter = new AutorConverter(listaAutores);
        
        return listaAutores;
    }
    
    private boolean jaHouvePesquisa() {
        return termoPesquisa != null && !"".equals(termoPesquisa);
    }
    
    public List<Obra> getListaEmpresas() {
        return listaObras;
    }
    
    public String getTermoPesquisa() {
        return termoPesquisa;
    }
    
    public void setTermoPesquisa(String termoPesquisa) {
        this.termoPesquisa = termoPesquisa;
    }
    
        
    public Converter getAutorConverter() {
        return autorConverter;
    }
    
    public Obra getObra() {
        return obra;
    }
}