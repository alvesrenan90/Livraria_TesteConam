package com.algaworks.erp.controller;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.algaworks.erp.model.Autor;

public class AutorConverter implements Converter {
    
    private List<Autor> listaAutores;

    public AutorConverter(List<Autor> listaAutores) {
        this.listaAutores = listaAutores;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        }
        
        Long id = Long.valueOf(value);
        
        for (Autor autor: listaAutores) {
            if (id.equals(autor.getCpf())) {
                return autor;
            }
        }
        
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        
        Autor autor = (Autor) value;
        
        return autor.getCpf().toString();
    }
}