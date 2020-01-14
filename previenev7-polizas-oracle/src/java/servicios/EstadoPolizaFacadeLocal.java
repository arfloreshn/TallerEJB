/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servicios;

import java.util.List;
import javax.ejb.Local;
import models.EstadoPoliza;

/**
 *
 * @author AllanRamiro
 */
@Local
public interface EstadoPolizaFacadeLocal {

    void create(EstadoPoliza estadoPoliza);

    void edit(EstadoPoliza estadoPoliza);

    void remove(EstadoPoliza estadoPoliza);

    EstadoPoliza find(Object id);

    List<EstadoPoliza> findAll();

    List<EstadoPoliza> findRange(int[] range);

    int count();
    
}
