package ni.org.ics.zpo.v2.service;

import ni.org.ics.zpo.v2.domain.ZpoEstadoInfante;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by FIRSTICT on 2/10/2017.
 * V1.0
 */
@Service("zpoEstadoInfanteService")
@Transactional
public class ZpoEstadoInfanteService {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * Retorna todos los formularios ZpoEstadoInfante
     * @return una lista de ZpoEstadoInfante
     */
    @SuppressWarnings("unchecked")
    public List<ZpoEstadoInfante> getZpoEstadoInfantes(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ZpoEstadoInfante");
        return query.list();
    }


    /**
     * Retorna todos los formularios ZpoEstadoInfante
     * @return una lista de ZpoEstadoInfante
     */
    @SuppressWarnings("unchecked")
    public List<ZpoEstadoInfante> getZpoEstadoInfantesByUser(String username){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ZpoEstadoInfante zpEstInfa where zpEstInfa.recordId in (select zpInDat.recordId from Zpo00Screening zpo00, ZpoInfantData zpInDat where zpo00.recordId = zpInDat.pregnantId and zpInDat.pasive = '0' and zpo00.pasive = '0')");
        //query.setParameter("usuarioactual",username);


        return query.list();
    }

    /**
     * Retorna un formulario ZpoEstadoInfante
     * @param recordId del ZpoEstadoInfante a retornar
     * @return un ZpoEstadoInfante
     */
    public ZpoEstadoInfante getZpoEstadoInfante(String recordId){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ZpoEstadoInfante where recordId = :recordId");
        query.setParameter("recordId",recordId);
        return (ZpoEstadoInfante)query.uniqueResult();
    }

    /**
     * Guardar un formulario ZpoEstadoInfante
     * @param zpoEstadoInfante a guardar
     */
    public void saveZpoEstadoInfante(ZpoEstadoInfante zpoEstadoInfante){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(zpoEstadoInfante);
    }
}
