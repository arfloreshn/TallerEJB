/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servicios;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import models.Ramos;

/**
 *
 * @author AllanRamiro
 */
@Stateless
public class RamosFacade extends AbstractFacade<Ramos> implements RamosFacadeLocal {
    @PersistenceContext(unitName = "previenev6PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RamosFacade() {
        super(Ramos.class);
    }
    
}
