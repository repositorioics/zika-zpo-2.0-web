package ni.org.ics.zpo.v2.service;

import ni.org.ics.zpo.v2.domain.ZpoV2StudyExit;
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
@Service("zpoV2StudyExitService")
@Transactional
public class ZpoV2StudyExitService {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * Retorna todos los formularios ZpoV2StudyExit
     * @return una lista de ZpoV2StudyExit
     */
    public List<ZpoV2StudyExit> getStudyExits(){
        Session session = sessionFactory.getCurrentSession();
        Query q = session.createQuery("from ZpoV2StudyExit  where pasive = '0'");
        return q.list();
    }

    /**
     * Guardar un formulario ZpoV2StudyExit
     * @param exit a guardar
     */
    public void saveOrUpdateStudyExit(ZpoV2StudyExit exit){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(exit);
    }


}
