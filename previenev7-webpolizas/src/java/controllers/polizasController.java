/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import models.Asegurado;
import models.EstadoPoliza;
import models.Polizas;
import models.Ramos;
import org.primefaces.event.SelectEvent;
import servicios.AseguradoFacadeLocal;
import servicios.EstadoPolizaFacadeLocal;
import servicios.PolizasFacadeLocal;
import servicios.RamosFacadeLocal;

/**
 *
 * @author AllanRamiro
 */
@Named
@ViewScoped
public class polizasController implements Serializable {

    private Date dthoy = new Date();
    /*
     Instanciamos las referencias de mantenimiento de los estado de la poliza
     , es decir instaciamos toda la programacion de la clase ramosFacade
     */
    @EJB
    private RamosFacadeLocal ramosFacade;

    /*
     Instanciamos las referencias de mantenimiento de los estado de la poliza
     , es decir instaciamos toda la programacion de la clase estadoPolizaFacade
     */
    @EJB
    private EstadoPolizaFacadeLocal estadoPolizaFacade;

    /*
     Instanciamos las referencias de mantenimiento de los asegurados que se van a relacionar
     , con la poliza, es decir instaciamos toda la programacion del asegurado
     */
    @EJB
    private AseguradoFacadeLocal aseguradoFacade;

    /*
     Instanciamos las referencias de mantenimiento de la poliza al instanciar
     esta referencia podremos agregar y modificar los registro de la polizas.
     */
    @EJB
    private PolizasFacadeLocal polizasFacade;

    // Variables para llenar las listas de datos, solo la lista de poliza se va mostrar
    private List<Polizas> listarPolizas;

    // Variables para llenar los combos del front-end
    private List<SelectItem> cboEstadoPoliza;
    private List<SelectItem> cboAsegurados;
    private List<SelectItem> cboRamos;

    // Estos objetos son los que  usaremos para ser llenadoso y mandarlos como parametros
    // este objeto debe ir llenos con datos, antes de enviar por le metodos EJB   
    private Polizas var_poliza;
    private EstadoPoliza var_estadopoliza;
    private Ramos var_ramos;
    private Asegurado var_asegurado;
    private Polizas seleccionaItem;

     private List<Polizas> tmp_lst;
     
    /**
     * Creates a new instance of polizas
     */
    @PostConstruct
    public void inicializar() {

        // Instanciamos la variable de trabajo de la poliza para el llenado de información
        // y sera el objeto que enviaremos a registrar o a realizar el insert.
        this.var_poliza = new Polizas();
        this.seleccionaItem = new Polizas();

        this.listarPolizas = polizasFacade.findAll();

        this.cboRamos = new ArrayList<>();
        this.cboRamos.clear();
        for (Ramos obj : this.ramosFacade.findAll()) {
            SelectItem item = new SelectItem(obj.getId(), obj.getNomRamo());
            this.cboRamos.add(item);
        }

        this.cboAsegurados = new ArrayList<>();
        this.cboAsegurados.clear();
        for (Asegurado obj : this.aseguradoFacade.findAll()) {
            SelectItem item = new SelectItem(obj.getIdAsegurado(), obj.getNombreCompleto());
            this.cboAsegurados.add(item);
        }

        this.cboEstadoPoliza = new ArrayList<>();
        this.cboEstadoPoliza.clear();
        for (EstadoPoliza obj : this.estadoPolizaFacade.findAll()) {
            SelectItem item = new SelectItem(obj.getIdEstado(), obj.getNomEstado());
            this.cboEstadoPoliza.add(item);
        }

        this.var_ramos = new Ramos();
        this.var_asegurado = new Asegurado();
        this.var_estadopoliza = new EstadoPoliza();
        this.var_poliza.setFecVigDesde(this.dthoy);
        this.var_poliza.setFecVigHasta(this.dthoy);
    }

    
    public void limpiarRegistro() {
        this.var_ramos = new Ramos();
        this.var_asegurado = new Asegurado();
        this.var_estadopoliza = new EstadoPoliza();
        this.var_poliza = new Polizas();
    }

    public polizasController() {
    }

    public List<Polizas> getListarPolizas() {
        return listarPolizas;
    }

    public Polizas getVar_poliza() {
        return var_poliza;
    }

    public void setVar_poliza(Polizas var_poliza) {
        this.var_poliza = var_poliza;
    }

    public EstadoPoliza getVar_estadopoliza() {
        return var_estadopoliza;
    }

    public void setVar_estadopoliza(EstadoPoliza var_estadopoliza) {
        this.var_estadopoliza = var_estadopoliza;
    }

    public Ramos getVar_ramos() {
        return var_ramos;
    }

    public void setVar_ramos(Ramos var_ramos) {
        this.var_ramos = var_ramos;
    }

    public Asegurado getVar_asegurado() {
        return var_asegurado;
    }

    public void setVar_asegurado(Asegurado var_asegurado) {
        this.var_asegurado = var_asegurado;
    }

    public Polizas getSeleccionaItem() {
        return seleccionaItem;
    }

    public void setSeleccionaItem(Polizas seleccionaItem) {
        this.seleccionaItem = seleccionaItem;
    }

    // Lleno el control SelectItem de los Ramos
    public List<SelectItem> getCboRamos() {
        return cboRamos;
    }

    // Lleno el control SelectItem de lo asegurados
    public List<SelectItem> getCboAsegurados() {
        return cboAsegurados;
    }

    public void onChangeCboRamo(ValueChangeEvent e) {
        this.var_ramos.setId((Short) e.getNewValue());
    }

    public void onChangeCboAsegurado(ValueChangeEvent e) {
        this.var_asegurado.setIdAsegurado((Long) e.getNewValue());
    }

    public void cmdnuevo() {
        //Limpio los registro de la pantalla
        limpiarRegistro();
        mensaje("Nuevo","Preparando nuevo registro");
    }

    public void cmdGuardar() {

        this.var_poliza.setSnEnPagos('N');

        if (this.var_poliza.getNroCoutas() > 1) {
            this.var_poliza.setSnEnPagos('S');
        }

        this.var_poliza.setRamos(this.var_ramos);
        this.var_poliza.setAsegurado(this.var_asegurado);
        this.var_estadopoliza.setIdEstado(1);

        //Establezco la relacion del estado con la tabla de estados
        this.var_poliza.setEstadoPoliza(this.var_estadopoliza);

        //Ejecuto el metodo guardar para crear un nuevo registro
        this.polizasFacade.create(this.var_poliza);

        // Instancio la variable de la poliza.
        this.var_poliza = new Polizas();

        //Cargo nuevamente todo el listado de polizas
        this.listarPolizas = new ArrayList<>();
        this.listarPolizas = polizasFacade.findAll();

        getListarPolizas();

    }

    
    public void cmdborrar() 
    {
       //Borramos el registro de la poliza 
       this.polizasFacade.remove(this.var_poliza);
       mensaje("Confirmado", "Poliza borrada");
    
    }
    
    public void onRowSelect(SelectEvent event) {
        // Limpiamos el registro antes de volver a llenarlo
        limpiarRegistro();
        this.var_poliza = (Polizas) event.getObject();
        
        //Llenando los registro despues de haberlos limpiado
        this.var_ramos.setId(this.var_poliza.getRamos().getId());
        this.var_asegurado.setIdAsegurado(this.var_poliza.getAsegurado().getIdAsegurado());
        this.var_estadopoliza.setIdEstado(this.var_poliza.getEstadoPoliza().getIdEstado());
   
      
    }

    public void mensaje(String titulo, String contenido) {
        FacesMessage msg = new FacesMessage(titulo, contenido);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

     
    
    public String index() {
        return "index.xhtml?faces-redirect=true";
    }
}
