package ni.org.ics.zpo.v2.service;

import ni.org.ics.zpo.v2.domain.ZpoV2InfantOphthalmologicEvaluation;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Miguel Salinas on 22/03/2019.
 * V1.0
 */
@Service("zpoV2InfantOphthalmologicEvalService")
@Transactional
public class ZpoV2InfantOphthalmologicEvalService {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * Retorna todos los formularios ZpoV2InfantOphthalmologicEvaluation
     * @return una lista de ZpoV2InfantOphthalmologicEvaluation
     */
    public List<ZpoV2InfantOphthalmologicEvaluation> getZpoV2InfantOphthalmologicEvaluations(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from ZpoV2InfantOphthalmologicEvaluation where pasive = '0'");
        return query.list();
    }

    /**
     * Guardar un formulario ZpoV2InfantOphthalmologicEvaluation
     * @param evaluation a guardar
     */
    public void saverOrUpdateZpoV2InfantOphthalmologicEval(ZpoV2InfantOphthalmologicEvaluation evaluation){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(evaluation);
    }
}
