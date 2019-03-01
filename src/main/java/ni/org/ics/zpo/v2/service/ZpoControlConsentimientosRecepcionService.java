package ni.org.ics.zpo.v2.service;

import ni.org.ics.zpo.v2.domain.ZpoControlConsentimientosRecepcion;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by FIRSTICT on 12/2/2016.
 * V1.0
 */
@Service("zpoControlConsentimientosRecepcionService")
@Transactional
public class ZpoControlConsentimientosRecepcionService {
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * Retorna todos los formularios ZpoControlConsentimientosRecepcion
     * @return una lista de ZpoControlConsentimientosRecepcion
     */
    @SuppressWarnings("unchecked")
    public List<ZpoControlConsentimientosRecepcion> getZpoControlConsentimientosRecepcion(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ZpoControlConsentimientosRecepcion ");
        return query.list();
    }

    /**
     * Guardar un formulario ZpoControlConsentimientosRecepcion
     * @param zpoControlConsentimientosRecepcion a guardar
     */
    public void saveZpoControlConsentimientosRecepcion(ZpoControlConsentimientosRecepcion zpoControlConsentimientosRecepcion){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(zpoControlConsentimientosRecepcion);
    }
}
