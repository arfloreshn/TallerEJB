/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servicios;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import models.Asegurado;

/**
 *
 * @author AllanRamiro
 */
@Stateless
public class AseguradoFacade extends AbstractFacade<Asegurado> implements AseguradoFacadeLocal {
    @PersistenceContext(unitName = "ORACLE11G_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AseguradoFacade() {
        super(Asegurado.class);
    }
    
}
