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
@Table(name = "zpo_cuest_salud_materna", catalog = "zika_zpo_v2")
public class ZpoV2CuestionarioSaludMaterna extends BaseMetaData implements Auditable {

    private String recordId;
    private String eventName;
    private Date fechaHoyMaternal;
    private String probFueraEmbarMaternal;
    private String otroProblemaMaternal;
    private String medicamActualMaternal;
    private String otroMedicamMaternal;
    private String fumaCigarrosMaternal;
    private String fumoEmbaraMaternal;
    private String tomaAlcoholMaternal;
    private String alcoholEmbarMaternal;
    private String frecuenciaAlcoholMaternal;
    private String vecesEmbarazadaMaternal;
    private String hijosVivosMaternal;
    private String defectosGeneticosMaternal;
    private String defectoGenetico1Maternal;
    private String quienDefecto1Maternal;
    private String otroDefectoMaternal;
    private String defectoGenetico2Maternal;
    private String quienDefecto2Maternal;
    private String nombreEncuestadorMaternal;

    //variables update
    private String embarazadaVisitaMaternalUpd;
    private String dadoLuzMaternalUpd;


    @Id
    @Column(name = "record_id", nullable = false, length = 25)
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

    @Column(name = "fecha_hoy_maternal", nullable = false)
    public Date getFechaHoyMaternal() {
        return fechaHoyMaternal;
    }

    public void setFechaHoyMaternal(Date fechaHoyMaternal) {
        this.fechaHoyMaternal = fechaHoyMaternal;
    }

    @Column(name = "prob_fuera_embar_maternal", length = 1)
    public String getProbFueraEmbarMaternal() {
        return probFueraEmbarMaternal;
    }

    public void setProbFueraEmbarMaternal(String probFueraEmbarMaternal) {
        this.probFueraEmbarMaternal = probFueraEmbarMaternal;
    }

    @Column(name = "otro_problema_maternal", length = 100)
    public String getOtroProblemaMaternal() {
        return otroProblemaMaternal;
    }

    public void setOtroProblemaMaternal(String otroProblemaMaternal) {
        this.otroProblemaMaternal = otroProblemaMaternal;
    }

    @Column(name = "medicam_actual_maternal", length = 1)
    public String getMedicamActualMaternal() {
        return medicamActualMaternal;
    }

    public void setMedicamActualMaternal(String medicamActualMaternal) {
        this.medicamActualMaternal = medicamActualMaternal;
    }

    @Column(name = "otro_medicam_maternal", length = 100)
    public String getOtroMedicamMaternal() {
        return otroMedicamMaternal;
    }

    public void setOtroMedicamMaternal(String otroMedicamMaternal) {
        this.otroMedicamMaternal = otroMedicamMaternal;
    }

    @Column(name = "fuma_cigarros_maternal", length = 1)
    public String getFumaCigarrosMaternal() {
        return fumaCigarrosMaternal;
    }

    public void setFumaCigarrosMaternal(String fumaCigarrosMaternal) {
        this.fumaCigarrosMaternal = fumaCigarrosMaternal;
    }

    @Column(name = "fumo_embara_maternal", length = 1)
    public String getFumoEmbaraMaternal() {
        return fumoEmbaraMaternal;
    }

    public void setFumoEmbaraMaternal(String fumoEmbaraMaternal) {
        this.fumoEmbaraMaternal = fumoEmbaraMaternal;
    }

    @Column(name = "toma_alcohol_maternal", length = 1)
    public String getTomaAlcoholMaternal() {
        return tomaAlcoholMaternal;
    }

    public void setTomaAlcoholMaternal(String tomaAlcoholMaternal) {
        this.tomaAlcoholMaternal = tomaAlcoholMaternal;
    }

    @Column(name = "alcohol_embar_maternal", length = 1)
    public String getAlcoholEmbarMaternal() {
        return alcoholEmbarMaternal;
    }

    public void setAlcoholEmbarMaternal(String alcoholEmbarMaternal) {
        this.alcoholEmbarMaternal = alcoholEmbarMaternal;
    }

    @Column(name = "frecuencia_alcohol_maternal", length = 1)
    public String getFrecuenciaAlcoholMaternal() {
        return frecuenciaAlcoholMaternal;
    }

    public void setFrecuenciaAlcoholMaternal(String frecuenciaAlcoholMaternal) {
        this.frecuenciaAlcoholMaternal = frecuenciaAlcoholMaternal;
    }

    @Column(name = "veces_embarazada_maternal", length = 1)
    public String getVecesEmbarazadaMaternal() {
        return vecesEmbarazadaMaternal;
    }

    public void setVecesEmbarazadaMaternal(String vecesEmbarazadaMaternal) {
        this.vecesEmbarazadaMaternal = vecesEmbarazadaMaternal;
    }

    @Column(name = "hijos_vivos_maternal", length = 1)
    public String getHijosVivosMaternal() {
        return hijosVivosMaternal;
    }

    public void setHijosVivosMaternal(String hijosVivosMaternal) {
        this.hijosVivosMaternal = hijosVivosMaternal;
    }

    @Column(name = "defectos_geneticos_maternal", length = 1)
    public String getDefectosGeneticosMaternal() {
        return defectosGeneticosMaternal;
    }

    public void setDefectosGeneticosMaternal(String defectosGeneticosMaternal) {
        this.defectosGeneticosMaternal = defectosGeneticosMaternal;
    }

    @Column(name = "defecto_genetico1_maternal", length = 100)
    public String getDefectoGenetico1Maternal() {
        return defectoGenetico1Maternal;
    }

    public void setDefectoGenetico1Maternal(String defectoGenetico1Maternal) {
        this.defectoGenetico1Maternal = defectoGenetico1Maternal;
    }

    @Column(name = "quien_defecto1_maternal", length = 1)
    public String getQuienDefecto1Maternal() {
        return quienDefecto1Maternal;
    }

    public void setQuienDefecto1Maternal(String quienDefecto1Maternal) {
        this.quienDefecto1Maternal = quienDefecto1Maternal;
    }

    @Column(name = "otro_defecto_maternal", length = 1)
    public String getOtroDefectoMaternal() {
        return otroDefectoMaternal;
    }

    public void setOtroDefectoMaternal(String otroDefectoMaternal) {
        this.otroDefectoMaternal = otroDefectoMaternal;
    }

    @Column(name = "defecto_genetico2_maternal", length = 100)
    public String getDefectoGenetico2Maternal() {
        return defectoGenetico2Maternal;
    }

    public void setDefectoGenetico2Maternal(String defectoGenetico2Maternal) {
        this.defectoGenetico2Maternal = defectoGenetico2Maternal;
    }

    @Column(name = "quien_defecto2_maternal", length = 1)
    public String getQuienDefecto2Maternal() {
        return quienDefecto2Maternal;
    }

    public void setQuienDefecto2Maternal(String quienDefecto2Maternal) {
        this.quienDefecto2Maternal = quienDefecto2Maternal;
    }

    @Column(name = "nombre_encuestador_maternal", length = 100)
    public String getNombreEncuestadorMaternal() {
        return nombreEncuestadorMaternal;
    }

    public void setNombreEncuestadorMaternal(String nombreEncuestadorMaternal) {
        this.nombreEncuestadorMaternal = nombreEncuestadorMaternal;
    }

    @Column(name = "embarazada_visita_maternal_upd", length = 1)
    public String getEmbarazadaVisitaMaternalUpd() {
        return embarazadaVisitaMaternalUpd;
    }

    public void setEmbarazadaVisitaMaternalUpd(String embarazadaVisitaMaternalUpd) {
        this.embarazadaVisitaMaternalUpd = embarazadaVisitaMaternalUpd;
    }

    @Column(name = "dado_luz_maternal_upd", length = 1)
    public String getDadoLuzMaternalUpd() {
        return dadoLuzMaternalUpd;
    }

    public void setDadoLuzMaternalUpd(String dadoLuzMaternalUpd) {
        this.dadoLuzMaternalUpd = dadoLuzMaternalUpd;
    }

    @Override
    public boolean isFieldAuditable(String fieldname) {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZpoV2CuestionarioSaludMaterna that = (ZpoV2CuestionarioSaludMaterna) o;

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
