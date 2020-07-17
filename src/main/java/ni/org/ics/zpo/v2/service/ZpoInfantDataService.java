package ni.org.ics.zpo.v2.service;

import ni.org.ics.zpo.v2.domain.ZpoInfantData;
import ni.org.ics.zpo.v2.domain.ZpoInfantDataDTO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.*;
import java.util.List;

/**
 * Created by FIRSTICT on 24/10/2017.
 * V1.0
 */
@Service("zpoInfantService")
@Transactional
public class ZpoInfantDataService {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * Retorna todos los formularios ZpoInfantData
     * @return una lista de ZpoInfantData
     */
    @SuppressWarnings("unchecked")
    public List<ZpoInfantData> getZpoInfantData(){

            Session session = sessionFactory.getCurrentSession();
            Query query = session.createSQLQuery("select record_id as recordId, pregnant_id as pregnantId, DATE_FORMAT(infant_delivery_date, '%d/%m/%Y') as infantBirthDate, infant_mode as infantMode, infant_delivery_who as infantDeliveryWho, infant_delivery_occur as infantDeliveryOccur, infant_hospital_id as infantHospitalId, infant_clinic_id as infantClinicId, infant_delivery_other as infantDeliveryOther, infant_num_birth as infantNumBirth, infant_fetal_outcome as infantFetalOutcome, infant_cause_death as infantCauseDeath, infant_sex_baby as infantSexBaby, infant_consent_infant as infantConsentInfant, infant_reason_noconsent as infantReasonNoconsent, infant_noconsent_other as infantNoconsentOther, estado as estado FROM zika_zpo.zpo_datos_infante");
            query.setResultTransformer(Transformers.aliasToBean(ZpoInfantDataDTO.class));
            return query.list();
        }


    /**
     * Retorna todos los formularios ZpEstadoInfante
     * @return una lista de ZpEstadoInfante
     */
    @SuppressWarnings("unchecked")
    public List<ZpoInfantData> getZpoInfantsDataByUser(String username){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select zpEstInfa.recordId, DATE_FORMAT(zpEstInfa.infantBirthDate, '%d %m %Y') AS infantBirthDate  FROM ZpoInfantData zpEstInfa where zpEstInfa.recordId not in (select zpo08.recordId from ZpoV2StudyExit zpo08 where zpo08.pasive = '0')");
        //query.setParameter("usuarioactual",username);


        return query.list();
    }
    /**
     * Retorna un formulario ZpoInfantData
     * @param recordId del ZpoInfantData a retornar
     * @return un ZpoInfantData
     */
    public ZpoInfantData getZpoInfantData(String recordId){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM ZpoInfantData where recordId = :recordId");
        query.setParameter("recordId",recordId);
        return (ZpoInfantData)query.uniqueResult();
    }

    /**
     * Guardar un formulario ZpoInfantData
     * @param zpoInfantData a guardar
     */
    public void saveZpoInfantData(ZpoInfantData zpoInfantData){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(zpoInfantData);
    }
}
