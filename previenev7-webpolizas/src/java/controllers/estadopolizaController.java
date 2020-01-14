/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import models.EstadoPoliza;
import servicios.EstadoPolizaFacadeLocal;

/**
 *
 * @author AllanRamiro
 */
@Named
@ViewScoped
public class estadopolizaController implements Serializable {
    
    @EJB
    private EstadoPolizaFacadeLocal estadoPolizaFacade;

    /**
     * Creates a new instance of estadopolizaController
     */
    private String msg = "";
    
    public estadopolizaController() {
        this.msg = "Mantenimiento de Estado poliza";
    }
    
    public List<EstadoPoliza> listaEstados() 
    {
      return estadoPolizaFacade.findAll();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    
    
}
