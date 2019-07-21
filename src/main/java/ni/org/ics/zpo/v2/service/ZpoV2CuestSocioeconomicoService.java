package ni.org.ics.zpo.v2.service;

import ni.org.ics.zpo.v2.domain.ZpoV2CuestionarioSocioeconomico;
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

@Service("zpoCuestSocieconomicoService")
@Transactional
public class ZpoV2CuestSocioeconomicoService {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * Retorna todos los formularios ZpoV2CuestionarioSocioeconomico
     * @return una lista de ZpoV2CuestionarioSocioeconomico
     */
    @SuppressWarnings("unchecked")
    public List<ZpoV2CuestionarioSocioeconomico> getZpoCuestSocieconomicos(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ZpoV2CuestionarioSocioeconomico where pasive = '0' ");
        return query.list();
    }


    /**
     * Retorna un formulario ZpoV2CuestionarioSocioeconomico
     * @param recordId del ZpoV2CuestionarioSocioeconomico a retornar
     * @return un ZpoV2CuestionarioSocioeconomico
     */
    public ZpoV2CuestionarioSocioeconomico getZpoCuestSocioeconomico(String recordId){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ZpoV2CuestionarioSocioeconomico where recordId = :recordId");
        query.setParameter("recordId",recordId);
        return (ZpoV2CuestionarioSocioeconomico) query.uniqueResult();
    }

    /**
     * Guardar un formulario ZpoV2CuestionarioSocioeconomico
     * @param zpoCuestSocio a guardar
     */
    public void saveZpoCuestSocioeconomico(ZpoV2CuestionarioSocioeconomico zpoCuestSocio){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(zpoCuestSocio);
    }

}
