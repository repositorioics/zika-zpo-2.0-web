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
@Table(name = "zpo_eval_pscicologica", catalog = "zika_zpo_v2")
public class ZpoV2EvaluacionPsicologica extends BaseMetaData implements Auditable {

    private String recordId;
    private String eventName;
    private Date fechaPsych;
    private String trabajarPsych;
    private String cocinarPsych;
    private String mercadoPsych;
    private String banarHijoPsych;
    private String vestirHijoPsych;
    private String limpiarPsych;
    private String lavarRopaPsych;
    private String banarsePsych;
    private String cuidarCabelloPsych;
    private String atenderVisitaPsych;
    private String lavarDientesPsych;
    private String usarRopaLimpiaPsych;
    private String juntarMujeresPsych;
    private String ayudarAmigasPsych;
    private String compartirInfoPsych;
    private String tareasSaludPsych;
    private Integer funcionamientoPuntajePsych;
    private String sinEnergiaPsych;
    private String culparseMismaPsych;
    private String llorarPsych;
    private String probConcentPsych;
    private String faltaApetitoPsych;
    private String difficulDormirPsych;
    private String sinEsperanzaPsych;
    private String tristePsych;
    private String solaPsych;
    private String acabarVidaPsych;
    private String preocuparsePsych;
    private String noInteresPsych;
    private String todoEsfuerzoPsych;
    private String sienteNoValePsych;
    private String noInteresSexoPsych;
    private String asustaPsych;
    private String sienteMiedoPsych;
    private String debilidadPsych;
    private String nerviosPsych;
    private String palpitacionesPsych;
    private String tiemblaPsych;
    private String sienteTensaPsych;
    private String dolorCabezaPsych;
    private String panicoPsych;
    private String inquietudPsych;
    private Integer sintomasPuntajePsych;
    private Integer scoreDepressionPsych;
    private String examinadorPsych;


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

    @Column(name = "fecha_psych", nullable = false)
    public Date getFechaPsych() {
        return fechaPsych;
    }

    public void setFechaPsych(Date fechaPsych) {
        this.fechaPsych = fechaPsych;
    }

    @Column(name = "trabajar_psych", nullable = false, length = 1)
    public String getTrabajarPsych() {
        return trabajarPsych;
    }

    public void setTrabajarPsych(String trabajarPsych) {
        this.trabajarPsych = trabajarPsych;
    }

    @Column(name = "cocinar_psych", nullable = false, length = 1)
    public String getCocinarPsych() {
        return cocinarPsych;
    }

    public void setCocinarPsych(String cocinarPsych) {
        this.cocinarPsych = cocinarPsych;
    }

    @Column(name = "mercado_psych", nullable = false, length = 1)
    public String getMercadoPsych() {
        return mercadoPsych;
    }

    public void setMercadoPsych(String mercadoPsych) {
        this.mercadoPsych = mercadoPsych;
    }

    @Column(name = "banar_hijo_psych", nullable = false, length = 1)
    public String getBanarHijoPsych() {
        return banarHijoPsych;
    }

    public void setBanarHijoPsych(String banarHijoPsych) {
        this.banarHijoPsych = banarHijoPsych;
    }

    @Column(name = "vestir_hijo_psych", nullable = false, length = 1)
    public String getVestirHijoPsych() {
        return vestirHijoPsych;
    }

    public void setVestirHijoPsych(String vestirHijoPsych) {
        this.vestirHijoPsych = vestirHijoPsych;
    }

    @Column(name = "limpiar_psych", nullable = false, length = 1)
    public String getLimpiarPsych() {
        return limpiarPsych;
    }

    public void setLimpiarPsych(String limpiarPsych) {
        this.limpiarPsych = limpiarPsych;
    }

    @Column(name = "lavar_ropa_psych", nullable = false, length = 1)
    public String getLavarRopaPsych() {
        return lavarRopaPsych;
    }

    public void setLavarRopaPsych(String lavarRopaPsych) {
        this.lavarRopaPsych = lavarRopaPsych;
    }

    @Column(name = "banarse_psych", nullable = false, length = 1)
    public String getBanarsePsych() {
        return banarsePsych;
    }

    public void setBanarsePsych(String banarsePsych) {
        this.banarsePsych = banarsePsych;
    }

    @Column(name = "cuidar_cabello_psych", nullable = false, length = 1)
    public String getCuidarCabelloPsych() {
        return cuidarCabelloPsych;
    }

    public void setCuidarCabelloPsych(String cuidarCabelloPsych) {
        this.cuidarCabelloPsych = cuidarCabelloPsych;
    }

    @Column(name = "atender_visita_psych", nullable = false, length = 1)
    public String getAtenderVisitaPsych() {
        return atenderVisitaPsych;
    }

    public void setAtenderVisitaPsych(String atenderVisitaPsych) {
        this.atenderVisitaPsych = atenderVisitaPsych;
    }

    @Column(name = "lavar_dientes_psych", nullable = false, length = 1)
    public String getLavarDientesPsych() {
        return lavarDientesPsych;
    }

    public void setLavarDientesPsych(String lavarDientesPsych) {
        this.lavarDientesPsych = lavarDientesPsych;
    }

    @Column(name = "usar_ropa_limpia_psych", nullable = false, length = 1)
    public String getUsarRopaLimpiaPsych() {
        return usarRopaLimpiaPsych;
    }

    public void setUsarRopaLimpiaPsych(String usarRopaLimpiaPsych) {
        this.usarRopaLimpiaPsych = usarRopaLimpiaPsych;
    }

    @Column(name = "juntar_mujeres_psych", nullable = false, length = 1)
    public String getJuntarMujeresPsych() {
        return juntarMujeresPsych;
    }

    public void setJuntarMujeresPsych(String juntarMujeresPsych) {
        this.juntarMujeresPsych = juntarMujeresPsych;
    }

    @Column(name = "ayudar_amigas_psych", nullable = false, length = 1)
    public String getAyudarAmigasPsych() {
        return ayudarAmigasPsych;
    }

    public void setAyudarAmigasPsych(String ayudarAmigasPsych) {
        this.ayudarAmigasPsych = ayudarAmigasPsych;
    }

    @Column(name = "compartir_info_psych", nullable = false, length = 1)
    public String getCompartirInfoPsych() {
        return compartirInfoPsych;
    }

    public void setCompartirInfoPsych(String compartirInfoPsych) {
        this.compartirInfoPsych = compartirInfoPsych;
    }

    @Column(name = "tareas_salud_psych", nullable = false)
    public String getTareasSaludPsych() {
        return tareasSaludPsych;
    }

    public void setTareasSaludPsych(String tareasSaludPsych) {
        this.tareasSaludPsych = tareasSaludPsych;
    }

    @Column(name = "funcionamiento_puntaje_psych", nullable = false)
    public Integer getFuncionamientoPuntajePsych() {
        return funcionamientoPuntajePsych;
    }

    public void setFuncionamientoPuntajePsych(Integer funcionamientoPuntajePsych) {
        this.funcionamientoPuntajePsych = funcionamientoPuntajePsych;
    }

    @Column(name = "sin_energia_psych", nullable = false, length = 1)
    public String getSinEnergiaPsych() {
        return sinEnergiaPsych;
    }

    public void setSinEnergiaPsych(String sinEnergiaPsych) {
        this.sinEnergiaPsych = sinEnergiaPsych;
    }

    @Column(name = "culparse_misma_psych", nullable = false, length = 1)
    public String getCulparseMismaPsych() {
        return culparseMismaPsych;
    }

    public void setCulparseMismaPsych(String culparseMismaPsych) {
        this.culparseMismaPsych = culparseMismaPsych;
    }

    @Column(name = "llorar_psych", nullable = false, length = 1)
    public String getLlorarPsych() {
        return llorarPsych;
    }

    public void setLlorarPsych(String llorarPsych) {
        this.llorarPsych = llorarPsych;
    }

    @Column(name = "prob_concent_psych", nullable = false, length = 1)
    public String getProbConcentPsych() {
        return probConcentPsych;
    }

    public void setProbConcentPsych(String probConcentPsych) {
        this.probConcentPsych = probConcentPsych;
    }

    @Column(name = "falta_apetito_psych", nullable = false, length = 1)
    public String getFaltaApetitoPsych() {
        return faltaApetitoPsych;
    }

    public void setFaltaApetitoPsych(String faltaApetitoPsych) {
        this.faltaApetitoPsych = faltaApetitoPsych;
    }

    @Column(name = "difficul_dormir_psych", nullable = false, length = 1)
    public String getDifficulDormirPsych() {
        return difficulDormirPsych;
    }

    public void setDifficulDormirPsych(String difficulDormirPsych) {
        this.difficulDormirPsych = difficulDormirPsych;
    }

    @Column(name = "sin_esperanza_psych", nullable = false, length = 1)
    public String getSinEsperanzaPsych() {
        return sinEsperanzaPsych;
    }

    public void setSinEsperanzaPsych(String sinEsperanzaPsych) {
        this.sinEsperanzaPsych = sinEsperanzaPsych;
    }

    @Column(name = "triste_psych", nullable = false, length = 1)
    public String getTristePsych() {
        return tristePsych;
    }

    public void setTristePsych(String tristePsych) {
        this.tristePsych = tristePsych;
    }

    @Column(name = "sola_psych", nullable = false, length = 1)
    public String getSolaPsych() {
        return solaPsych;
    }

    public void setSolaPsych(String solaPsych) {
        this.solaPsych = solaPsych;
    }

    @Column(name = "acabar_vida_psych", nullable = false, length = 1)
    public String getAcabarVidaPsych() {
        return acabarVidaPsych;
    }

    public void setAcabarVidaPsych(String acabarVidaPsych) {
        this.acabarVidaPsych = acabarVidaPsych;
    }

    @Column(name = "preocuparse_psych", nullable = false, length = 1)
    public String getPreocuparsePsych() {
        return preocuparsePsych;
    }

    public void setPreocuparsePsych(String preocuparsePsych) {
        this.preocuparsePsych = preocuparsePsych;
    }

    @Column(name = "no_interes_psych", nullable = false, length = 1)
    public String getNoInteresPsych() {
        return noInteresPsych;
    }

    public void setNoInteresPsych(String noInteresPsych) {
        this.noInteresPsych = noInteresPsych;
    }

    @Column(name = "todo_esfuerzo_psych", nullable = false, length = 1)
    public String getTodoEsfuerzoPsych() {
        return todoEsfuerzoPsych;
    }

    public void setTodoEsfuerzoPsych(String todoEsfuerzoPsych) {
        this.todoEsfuerzoPsych = todoEsfuerzoPsych;
    }

    @Column(name = "siente_no_vale_psych", nullable = false, length = 1)
    public String getSienteNoValePsych() {
        return sienteNoValePsych;
    }

    public void setSienteNoValePsych(String sienteNoValePsych) {
        this.sienteNoValePsych = sienteNoValePsych;
    }

    @Column(name = "no_interes_sexo_psych", nullable = false, length = 1)
    public String getNoInteresSexoPsych() {
        return noInteresSexoPsych;
    }

    public void setNoInteresSexoPsych(String noInteresSexoPsych) {
        this.noInteresSexoPsych = noInteresSexoPsych;
    }

    @Column(name = "asusta_psych", nullable = false, length = 1)
    public String getAsustaPsych() {
        return asustaPsych;
    }

    public void setAsustaPsych(String asustaPsych) {
        this.asustaPsych = asustaPsych;
    }

    @Column(name = "siente_miedo_psych", nullable = false, length = 1)
    public String getSienteMiedoPsych() {
        return sienteMiedoPsych;
    }

    public void setSienteMiedoPsych(String sienteMiedoPsych) {
        this.sienteMiedoPsych = sienteMiedoPsych;
    }

    @Column(name = "debilidad_psych", nullable = false, length = 1)
    public String getDebilidadPsych() {
        return debilidadPsych;
    }

    public void setDebilidadPsych(String debilidadPsych) {
        this.debilidadPsych = debilidadPsych;
    }

    @Column(name = "nervios_psych", nullable = false, length = 1)
    public String getNerviosPsych() {
        return nerviosPsych;
    }

    public void setNerviosPsych(String nerviosPsych) {
        this.nerviosPsych = nerviosPsych;
    }

    @Column(name = "palpitaciones_psych", nullable = false, length = 1)
    public String getPalpitacionesPsych() {
        return palpitacionesPsych;
    }

    public void setPalpitacionesPsych(String palpitacionesPsych) {
        this.palpitacionesPsych = palpitacionesPsych;
    }

    @Column(name = "tiembla_psych", nullable = false, length = 1)
    public String getTiemblaPsych() {
        return tiemblaPsych;
    }

    public void setTiemblaPsych(String tiemblaPsych) {
        this.tiemblaPsych = tiemblaPsych;
    }

    @Column(name = "siente_tensa_psych", nullable = false, length = 1)
    public String getSienteTensaPsych() {
        return sienteTensaPsych;
    }

    public void setSienteTensaPsych(String sienteTensaPsych) {
        this.sienteTensaPsych = sienteTensaPsych;
    }

    @Column(name = "dolor_cabeza_psych", nullable = false, length = 1)
    public String getDolorCabezaPsych() {
        return dolorCabezaPsych;
    }

    public void setDolorCabezaPsych(String dolorCabezaPsych) {
        this.dolorCabezaPsych = dolorCabezaPsych;
    }

    @Column(name = "panico_psych", nullable = false, length = 1)
    public String getPanicoPsych() {
        return panicoPsych;
    }

    public void setPanicoPsych(String panicoPsych) {
        this.panicoPsych = panicoPsych;
    }

    @Column(name = "inquietud_psych", nullable = false, length = 1)
    public String getInquietudPsych() {
        return inquietudPsych;
    }

    public void setInquietudPsych(String inquietudPsych) {
        this.inquietudPsych = inquietudPsych;
    }

    @Column(name = "sintomas_puntaje_psych", nullable = false)
    public Integer getSintomasPuntajePsych() {
        return sintomasPuntajePsych;
    }

    public void setSintomasPuntajePsych(Integer sintomasPuntajePsych) {
        this.sintomasPuntajePsych = sintomasPuntajePsych;
    }

    @Column(name = "score_depression_psych", nullable = false)
    public Integer getScoreDepressionPsych() {
        return scoreDepressionPsych;
    }

    public void setScoreDepressionPsych(Integer scoreDepressionPsych) {
        this.scoreDepressionPsych = scoreDepressionPsych;
    }

    @Column(name = "examinador_psych", nullable = false, length = 100)
    public String getExaminadorPsych() {
        return examinadorPsych;
    }

    public void setExaminadorPsych(String examinadorPsych) {
        this.examinadorPsych = examinadorPsych;
    }

    @Override
    public boolean isFieldAuditable(String fieldname) {
        return false;
    }

    @Override
    public String toString() {
        return "ZpoV2EvaluacionPsicologica{" +
                "recordId='" + recordId + '\'' +
                ", eventName='" + eventName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZpoV2EvaluacionPsicologica that = (ZpoV2EvaluacionPsicologica) o;

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
