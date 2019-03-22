package ni.org.ics.zpo.v2.service;

import ni.org.ics.zpo.v2.domain.ZpoMullen;
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
@Service("zpoMullenService")
@Transactional
public class ZpoMullenService {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * Retorna todos los formularios ZpoMullen
     * @return una lista de ZpoMullen
     */
    @SuppressWarnings("unchecked")
    public List<ZpoMullen> getZpoMullen(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ZpoMullen ");
        return query.list();
    }

    /**
     * Retorna todos los formularios ZpoMullen
     * @return una lista de ZpoMullen
     */
    @SuppressWarnings("unchecked")
    public List<ZpoMullen> getZpoMullenByUser(String username){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ZpoMullen zpoM where zpoM.pasive = '0' and zpoM.recordId in (select zpo00.recordId from Zpo00Screening zpo00 where zpo00.pasive = '0')");
        //query.setParameter("usuarioactual",username);
        return query.list();
    }

    /**
     * Retorna un formulario ZpoMullen
     * @param recordId del ZpoMullen a retornar
     * @return un ZpoMullen
     */
    public ZpoMullen getZpoMullen(String recordId){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ZpoMullen where recordId = :recordId");
        query.setParameter("recordId",recordId);
        return (ZpoMullen)query.uniqueResult();
    }

    /**
     * Guardar un formulario ZpoMullen
     * @param zpoMullen a guardar
     */
    public void saveZpoMullen(ZpoMullen zpoMullen){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(zpoMullen);
    }
}
