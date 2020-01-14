/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import models.Asegurado;
import org.primefaces.event.SelectEvent;


import servicios.AseguradoFacadeLocal;

/**
 *
 * @author AllanRamiro
 */
@Named
@ViewScoped
public class aseguradosController implements Serializable {

    // Declaramos una variable de tipo fecha para los campos de fecha
    private Date dthoy = new Date();
    
     // Declaramos la variable de trabajo que vamos a usar en el formulario
    private Asegurado var_asegurado;
    private Asegurado seleccionaItem;
  
    
    // Declaramos una variable para los mensajes de pantalla
    private String msg = "";
    private String rotulo = "";
    
    // Declaramos una varaible para consumir los servicios de los EJB
    @EJB
    private AseguradoFacadeLocal aseguradoFacade;

   
    // Inicializamos las variables antes que se cargue el formulario web
    @PostConstruct
    public void inicializar() {
        this.rotulo = "Mantenimiento de asegurados";
        this.var_asegurado = new Asegurado();
       
    }

    /**
     * Creates a new instance of aseguradosController
     */

    
    
    public aseguradosController() {
    }

    public void limpiarRegistro() 
    {
        this.dthoy = new Date();
        this.var_asegurado = new Asegurado();
        this.var_asegurado.setFecAlta(dthoy);
        this.var_asegurado.setFecNacimiento(dthoy);
        this.var_asegurado.setFecBaja(dthoy);
    }
  
    public List<Asegurado> lstAsegurados() {
        return aseguradoFacade.findAll();
    }

    public String getRotulo() {
        return rotulo;
    }

    public void setRotulo(String rotulo) {
        this.rotulo = rotulo;
    }

    
    
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Asegurado getVar_asegurado() {
        return var_asegurado;
    }

    public void setVar_asegurado(Asegurado var_asegurado) {
        this.var_asegurado = var_asegurado;
    }

    
  
  
      public Asegurado getSeleccionaItem() {
        return seleccionaItem;
    }

    public void setSeleccionaItem(Asegurado seleccionaItem) {
        this.var_asegurado = new Asegurado();
        this.var_asegurado = seleccionaItem;
        this.seleccionaItem = seleccionaItem;
    }

    //Guardamos un nuevo asegurado
    public void cmdGuardar() 
    {

       /* 
        this.asegurado = new Asegurado();
        this.asegurado.setFecAlta(this.dthoy);
        this.asegurado.setFecBaja(null);
        this.asegurado.setFecNacimiento(null);
        this.asegurado.setNombreCompleto("PRUEBA PARA EEFETOS MANUALES");
        this.asegurado.setNroDocumento("123456");
        this.asegurado.setTipo_asegurado('J');
        this.asegurado.setTipo_documento('R');
        this.asegurado.setTipo_sexo('F');
      */  
        //Vamos a guardar el asegurado sino es un cagadal
        this.aseguradoFacade.create(this.var_asegurado);
        this.mensaje("Guardado", "Registro guardado");
        lstAsegurados();
        limpiarRegistro();
        
    }
  
      
    public void onRowSelect(SelectEvent event) {
        // Limpiamos el registro antes de volver a llenarlo
       this.var_asegurado = new Asegurado();
       this.var_asegurado = this.seleccionaItem;
      
    }
    
    
    // Mandamos a modificar los datos del asegurado
    public void cmdmodificar() 
    {
     this.aseguradoFacade.edit(this.var_asegurado);
     this.mensaje("Modificado", "Registro modificado");
     limpiarRegistro();
    }
    
    //Borramos el registro del asegurado
    public void cmdeliminar() 
    {
        
        this.aseguradoFacade.remove(this.var_asegurado);
        this.mensaje("Eliminado", "Registro eliminado");
        limpiarRegistro();
    }
    
    
    public void mensaje(String titulo, String contenido) {
        FacesMessage msg = new FacesMessage(titulo, contenido);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
