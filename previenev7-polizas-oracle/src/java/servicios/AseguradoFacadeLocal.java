/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servicios;

import java.util.List;
import javax.ejb.Local;
import models.Asegurado;

/**
 *
 * @author AllanRamiro
 */
@Local
public interface AseguradoFacadeLocal {

    void create(Asegurado asegurado);

    void edit(Asegurado asegurado);

    void remove(Asegurado asegurado);

    Asegurado find(Object id);

    List<Asegurado> findAll();

    List<Asegurado> findRange(int[] range);

    int count();
    
}
