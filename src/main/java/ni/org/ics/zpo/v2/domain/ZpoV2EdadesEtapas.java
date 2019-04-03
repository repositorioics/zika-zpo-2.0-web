package ni.org.ics.zpo.v2.domain;

import ni.org.ics.zpo.v2.domain.audit.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author ics
 */

@Entity
@Table(name = "zpo_edades_etapas", catalog = "zika_zpo_v2")
public class ZpoV2EdadesEtapas extends BaseMetaData implements Auditable {

    private String recordId;
    private String eventName;
    private Date visitDate;
    private float comunicacion4Meses;
    private float motoraGruesa4Meses;
    private float motoraFina4Meses;
    private float resProb4Meses;
    private float socioInd4Meses;
    private String abnormalResults;
    private String areaComunicacion;
    private String areaMotoraGruesa;
    private String areaMotoraFina;
    private String areaSolucionProblemas;
    private String areaSocioIndividual;
    private String comGenObs4Meses;
    private String idCompleted;

    @Id
    @Column(name = "cod_nino_4_meses", nullable = false, length = 25)
    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    @Id
    @Column(name = "event_name", nullable = false, length = 100)
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @Column(name = "visit_date", nullable = false)
    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    @Column(name = "comunicacion_4_meses")
    public float getComunicacion4Meses() {
        return comunicacion4Meses;
    }

    public void setComunicacion4Meses(float comunicacion4Meses) {
        this.comunicacion4Meses = comunicacion4Meses;
    }

    @Column(name = "motora_gruesa_4_meses")
    public float getMotoraGruesa4Meses() {
        return motoraGruesa4Meses;
    }

    public void setMotoraGruesa4Meses(float motoraGruesa4Meses) {
        this.motoraGruesa4Meses = motoraGruesa4Meses;
    }

    @Column(name = "motora_fina_4_meses")
    public float getMotoraFina4Meses() {
        return motoraFina4Meses;
    }

    public void setMotoraFina4Meses(float motoraFina4Meses) {
        this.motoraFina4Meses = motoraFina4Meses;
    }

    @Column(name = "res_prob_4_meses")
    public float getResProb4Meses() {
        return resProb4Meses;
    }

    public void setResProb4Meses(float resProb4Meses) {
        this.resProb4Meses = resProb4Meses;
    }

    @Column(name = "socio_ind_4_meses")
    public float getSocioInd4Meses() {
        return socioInd4Meses;
    }

    public void setSocioInd4Meses(float socioInd4Meses) {
        this.socioInd4Meses = socioInd4Meses;
    }

    @Column(name = "abnormal_results", length = 1)
    public String getAbnormalResults() {
        return abnormalResults;
    }

    public void setAbnormalResults(String abnormalResults) {
        this.abnormalResults = abnormalResults;
    }

    @Column(name = "area_comunicacion", length = 1)
    public String getAreaComunicacion() {
        return areaComunicacion;
    }

    public void setAreaComunicacion(String areaComunicacion) {
        this.areaComunicacion = areaComunicacion;
    }

    @Column(name = "area_motoragruesa", length = 1)
    public String getAreaMotoraGruesa() {
        return areaMotoraGruesa;
    }

    public void setAreaMotoraGruesa(String areaMotoraGruesa) {
        this.areaMotoraGruesa = areaMotoraGruesa;
    }

    @Column(name = "area_motorafina", length = 1)
    public String getAreaMotoraFina() {
        return areaMotoraFina;
    }

    public void setAreaMotoraFina(String areaMotoraFina) {
        this.areaMotoraFina = areaMotoraFina;
    }

    @Column(name = "area_solucionproblemas ", length = 1)
    public String getAreaSolucionProblemas() {
        return areaSolucionProblemas;
    }

    public void setAreaSolucionProblemas(String areaSolucionProblemas) {
        this.areaSolucionProblemas = areaSolucionProblemas;
    }

    @Column(name = "area_socioindividual ", length = 1)
    public String getAreaSocioIndividual() {
        return areaSocioIndividual;
    }

    public void setAreaSocioIndividual(String areaSocioIndividual) {
        this.areaSocioIndividual = areaSocioIndividual;
    }

    @Column(name = "com_gen_obs_4_meses")
    public String getComGenObs4Meses() {
        return comGenObs4Meses;
    }

    public void setComGenObs4Meses(String comGenObs4Meses) {
        this.comGenObs4Meses = comGenObs4Meses;
    }

    @Column(name = "idCompleted", length = 100)
    public String getIdCompleted() {
        return idCompleted;
    }

    public void setIdCompleted(String idCompleted) {
        this.idCompleted = idCompleted;
    }

    @Override
    public boolean isFieldAuditable(String fieldname) {
        return false;
    }

    @Override
    public String toString() {
        return "ZpoV2EdadesEtapas{" +
                "recordId='" + recordId + '\'' +
                ", eventName='" + eventName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZpoV2EdadesEtapas that = (ZpoV2EdadesEtapas) o;

        if (!recordId.equals( that.recordId )) return false;
        return eventName.equals( that.eventName );
    }

    @Override
    public int hashCode() {
        int result = recordId.hashCode();
        result = 31 * result + eventName.hashCode();
        return result;
    }
}
