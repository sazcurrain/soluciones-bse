package uy.com.bse.soluciones.ejbs;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import uy.com.bse.soluciones.domain.BaseEntity;

/**
 * Servicio base utilizado desde el BaseEntityConverter
 * @see uy.org.curso.converters.BaseEntityConverter
 * expone un unico metodo que se utiliza desde el converter
 * @author juan
 *
 */
@Stateless
public class BaseService {

	@PersistenceContext(unitName = "soluciones_bse")
    private EntityManager em;

    public BaseEntity<? extends Number> find(Class<BaseEntity<? extends Number>> type, Number id) {
        return em.find(type, id);
    }
}