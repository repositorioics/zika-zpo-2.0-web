package ni.org.ics.zpo.v2.service;

import ni.org.ics.zpo.v2.domain.ZpoV2ExamenFisicoInfante;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ics
 */

@Service("zpoExamFisicoInfanteService")
@Transactional
public class ZpoV2ExamenFisicoInfanteService {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * Retorna todos los formularios ZpoV2ExamFisicoInfante
     * @return una lista de ZpoV2ExamenFisicoInfante
     */
    @SuppressWarnings("unchecked")
    public List<ZpoV2ExamenFisicoInfante> getZpoExamFisicoInfantes(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ZpoV2ExamenFisicoInfante where pasive = '0' ");
        return query.list();
    }


    /**
     * Retorna un formulario ZpoV2ExamenFisicoInfante
     * @param recordId del ZpoV2ExamenFisicoInfante a retornar
     * @return un ZpoV2ExamenFisicoInfante
     */
    public ZpoV2ExamenFisicoInfante getZpoExamFisicoInfante(String recordId){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ZpoV2ExamenFisicoInfante where recordId = :recordId");
        query.setParameter("recordId",recordId);
        return (ZpoV2ExamenFisicoInfante) query.uniqueResult();
    }

    /**
     * Guardar un formulario ZpoV2ExamenFisicoInfante
     * @param zpoV2ExamFisicoInfante a guardar
     */
    public void saveZpoExamFisicoInfante(ZpoV2ExamenFisicoInfante zpoV2ExamFisicoInfante){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(zpoV2ExamFisicoInfante);
    }

}
