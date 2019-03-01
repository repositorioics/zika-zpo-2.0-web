package ni.org.ics.zpo.v2.service;

import ni.org.ics.zpo.v2.domain.ZpoDatosEmbarazada;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by FIRSTICT on 11/7/2016.
 * V1.0
 */
@Service("zpoDatosEmbarazadaService")
@Transactional
public class ZpoDatosEmbarazadaService {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * Retorna todos los formularios ZpoDatosEmbarazada
     * @return una lista de ZpoDatosEmbarazada
     */
    @SuppressWarnings("unchecked")
    public List<ZpoDatosEmbarazada> getZpoDatosEmbarazadas(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ZpoDatosEmbarazada");
        return query.list();
    }

    /**
     * Retorna un formulario ZpoDatosEmbarazada
     * @param recordId del ZpoDatosEmbarazada a retornar
     * @return un ZpoDatosEmbarazada
     */
    public ZpoDatosEmbarazada getZpoDatosEmbarazada(String recordId){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ZpoDatosEmbarazada where recordId = :recordId");
        query.setParameter("recordId",recordId);
        return (ZpoDatosEmbarazada)query.uniqueResult();
    }

    /**
     * Guardar un formulario ZpoDatosEmbarazada
     * @param zpoDatosEmbarazada a guardar
     */
    public void saveZpoDatosEmbarazada(ZpoDatosEmbarazada zpoDatosEmbarazada){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(zpoDatosEmbarazada);
    }
}
