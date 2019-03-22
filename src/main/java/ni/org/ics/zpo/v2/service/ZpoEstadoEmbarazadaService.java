package ni.org.ics.zpo.v2.service;

import ni.org.ics.zpo.v2.domain.ZpoEstadoEmbarazada;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Servicio para el objeto ZpoEstadoEmbarazada
 * Created by FIRSTICT on 10/11/2016.
 * V1.0
 */
@Service("zpoEstadoEmbarazadaService")
@Transactional
public class ZpoEstadoEmbarazadaService {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * Retorna todos los formularios ZpoEstadoEmbarazada
     * @return una lista de ZpoEstadoEmbarazada
     */
    @SuppressWarnings("unchecked")
    public List<ZpoEstadoEmbarazada> getZpoEstadoEmbarazada(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ZpoEstadoEmbarazada");
        return query.list();
    }
    
    
    /**
     * Retorna todos los formularios ZpoEstadoEmbarazada
     * @return una lista de ZpoEstadoEmbarazada
     */
    @SuppressWarnings("unchecked")
    public List<ZpoEstadoEmbarazada> getZpEstadoEmbarazadByUser(String username){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ZpoEstadoEmbarazada zpEstado where zpEstado.pasive = '0' and zpEstado.recordId in (select zpo00.recordId from ZpoScreening zpo00 where zpo00.pasive = '0')");
        //query.setParameter("usuarioactual",username);
        return query.list();
    }

    /**
     * Retorna un formulario ZpoEstadoEmbarazada
     * @param recordId del ZpoEstadoEmbarazada a retornar
     * @return un ZpoEstadoEmbarazada
     */
    public ZpoEstadoEmbarazada getZpoEstadoEmbarazada(String recordId){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ZpoEstadoEmbarazada where recordId = :recordId");
        query.setParameter("recordId",recordId);
        return (ZpoEstadoEmbarazada)query.uniqueResult();
    }

    /**
     * Guardar un formulario ZpoEstadoEmbarazada
     * @param zpoEstadoEmbarazada a guardar
     */
    public void saveZpoEstadoEmbarazada(ZpoEstadoEmbarazada zpoEstadoEmbarazada){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(zpoEstadoEmbarazada);
    }
}
