/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import models.Ramos;
import servicios.RamosFacadeLocal;

/**
 *
 * @author AllanRamiro
 */

@Named
@ViewScoped
public class ramosController implements Serializable {
    
    @EJB
    private RamosFacadeLocal ramosFacade;
    
    private List<Ramos> objListar;
   
    /**
     * Creates a new instance of ramosBean
     */
    
    private String msg = "";
    
    
    @PostConstruct
    public void init() 
    {
        this.msg = "Mantenimiento de ramos";
        this.objListar = ramosFacade.findAll();
    }
    
    public ramosController() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Ramos> getObjListar() {
        return objListar;
    }
    
    
}
