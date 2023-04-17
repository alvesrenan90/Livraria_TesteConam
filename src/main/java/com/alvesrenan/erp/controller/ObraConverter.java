package com.alvesrenan.erp.controller;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.alvesrenan.erp.model.Obra;

public class ObraConverter implements Converter {
    
    private List<Obra> listaObras;

    public ObraConverter(List<Obra> listaObras) {
        this.listaObras = listaObras;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        }
        
        Long id = Long.valueOf(value);
        
        for (Obra obra: listaObras) {
            if (id.equals(obra.getId())) {
                return obra;
            }
        }
        
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        
        Obra obra = (Obra) value;
        
        return obra.getId().toString();
    }
}