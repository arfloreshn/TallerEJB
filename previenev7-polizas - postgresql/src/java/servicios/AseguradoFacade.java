/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servicios;

//import javax.ejb.Stateful;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import models.Asegurado;

/**
 *
 * @author AllanRamiro
 */
@Stateful
public class AseguradoFacade extends AbstractFacade<Asegurado> implements AseguradoFacadeLocal {
    
   // @PersistenceContext(unitName = "previenev6PU", type = PersistenceContextType.EXTENDED)
    @PersistenceContext(unitName = "previenev6PU",type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AseguradoFacade() {
        super(Asegurado.class);
    }
    
}
