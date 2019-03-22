package ni.org.ics.zpo.v2.service;

import ni.org.ics.zpo.v2.domain.ZpoV2InfantOtoacousticEmissions;
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
@Service("zpoInfantOtoacousticEmissionsService")
@Transactional
public class ZpoInfantOtoacousticEmissionsService {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    public List<ZpoV2InfantOtoacousticEmissions> getZpoInfantOtoacousticEmissionses(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from ZpoV2InfantOtoacousticEmissions where pasive = '0'");
        return query.list();
    }

    public void saveOrUpdateZpoInfantOtoEm(ZpoV2InfantOtoacousticEmissions emissionses){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(emissionses);
    }
}
