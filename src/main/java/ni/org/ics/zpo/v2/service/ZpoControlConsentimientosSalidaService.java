package ni.org.ics.zpo.v2.service;

import ni.org.ics.zpo.v2.domain.ZpoControlConsentimientosSalida;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by FIRSTICT on 11/11/2016.
 * V1.0
 */
@Service("zpoControlConsentimientosSalidaService")
@Transactional
public class ZpoControlConsentimientosSalidaService {
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * Retorna todos los formularios ZpoControlConsentimientosSalida
     * @return una lista de ZpoControlConsentimientosSalida
     */
    @SuppressWarnings("unchecked")
    public List<ZpoControlConsentimientosSalida> getZpoControlConsentimientosSalida(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ZpoControlConsentimientosSalida");
        return query.list();
    }

    /**
     * Guardar un formulario ZpoControlConsentimientosSalida
     * @param zpoControlConsentimientosSalida a guardar
     */
    public void saveZpoControlConsentimientosSalida(ZpoControlConsentimientosSalida zpoControlConsentimientosSalida){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(zpoControlConsentimientosSalida);
    }
}
