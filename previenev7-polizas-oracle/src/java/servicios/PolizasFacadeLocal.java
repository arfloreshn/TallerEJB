/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servicios;

import java.util.List;
import javax.ejb.Local;
import models.Polizas;

/**
 *
 * @author AllanRamiro
 */
@Local
public interface PolizasFacadeLocal {

    void create(Polizas polizas);

    void edit(Polizas polizas);

    void remove(Polizas polizas);

    Polizas find(Object id);

    List<Polizas> findAll();

    List<Polizas> findRange(int[] range);

    int count();
    
}
