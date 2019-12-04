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
@Table(name = "zpo_cuest_salud_infantil", catalog = "zika_zpo_v2")
public class ZpoV2CuestSaludInfantil extends BaseMetaData implements Auditable {

    private String recordId;
    private String eventName;
    private Date fechaHoyNino;
    private String pesoNacerNino;
    private String tallaNacerNino;
    private String circunferenciaNacerNino;
    private Integer edadGestacionalNino;
    private String partoMultipleNino;
    private String probEmbarazoNino;
    private String probEmbarazoOtroNino;
    private String ocurrioEmbarazoNino;
    private String problemasBebeNino;
    private String problemasExtremNino;
    private String problemasLactanciaNino;
    private String visionProbNino;
    private String visionDescribaNino;
    private String audicionProbNino;
    private String audicionDescribaNino;
    private String neuroProbNino;
    private String medicamentoNino;
    private String medicamentoListaNino;
    private String amamantandoNino;
    private Date fechaAmamantarNino;
    private String tiempoFueraNino;
    private String parteDiaAfueraNino;
    private String quienCuidaNino;
    private String mayoriaTiempoNino;
    private String picadurasNino;
    private String mosquiteroDormirNino;
    private String mosquiteroFrecuenciaNino;
    private String repelenteInsectosNino;
    private String repelenteFrecuenciaNino;
    private String ministerioFueraNino;
    private String ultimaVezFueraNino;
    private String ministerioDentroNino;
    private String ultimaVezDentroNino;
    private String aplicaAbateNino;
    private String ultimaVezAbateNino;
    private String insecticidaAmbientalNino;
    private String ultimaVezInsecticidaNino;
    private String fiebreAmarillaNino;
    private Date fechaFiebreAmarillaNino;
    private String transfusionSangreNino;
    private Date fechaTransfusionNino;
    private String paisesFueraNino;
    private String dondePaisAfueraNino;
    private String fueraManaguaNino;
    private String adondeFueraManaguaNino;
    private String vistoMedicoNino;
    private String motivoMedicoNino;
    private String visitaEnfermedadNino;
    private String problemasNino;
    private String problemasOtroNino;
    private String diagnosticadoZikaNino;
    private Date fechaZikaNino;
    private String diagnosChikungunyaNino;
    private Date fechaChikungunyaNino;
    private String diagnosticadoDengueNino;
    private Date fechaDengueNino;
    private String nombreEncuestadorNino;

    //variables utilizadas solo en update
    private String descripcionProbNeuroNinoUpd;
    private String problemaComerNinoUpd;

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

    @Column(name = "fecha_hoy_nino", nullable = false)
    public Date getFechaHoyNino() {
        return fechaHoyNino;
    }

    public void setFechaHoyNino(Date fechaHoyNino) {
        this.fechaHoyNino = fechaHoyNino;
    }

    @Column(name = "peso_nacer_nino", length = 10)
    public String getPesoNacerNino() {
        return pesoNacerNino;
    }

    public void setPesoNacerNino(String pesoNacerNino) {
        this.pesoNacerNino = pesoNacerNino;
    }

    @Column(name = "talla_nacer_nino", length = 10)
    public String getTallaNacerNino() {
        return tallaNacerNino;
    }

    public void setTallaNacerNino(String tallaNacerNino) {
        this.tallaNacerNino = tallaNacerNino;
    }

    @Column(name = "circunferencia_nacer_nino", length = 20)
    public String getCircunferenciaNacerNino() {
        return circunferenciaNacerNino;
    }

    public void setCircunferenciaNacerNino(String circunferenciaNacerNino) {
        this.circunferenciaNacerNino = circunferenciaNacerNino;
    }

    @Column(name = "edad_gestacional_nino")
    public Integer getEdadGestacionalNino() {
        return edadGestacionalNino;
    }

    public void setEdadGestacionalNino(Integer edadGestacionalNino) {
        this.edadGestacionalNino = edadGestacionalNino;
    }

    @Column(name = "parto_multiple_nino", length = 1)
    public String getPartoMultipleNino() {
        return partoMultipleNino;
    }

    public void setPartoMultipleNino(String partoMultipleNino) {
        this.partoMultipleNino = partoMultipleNino;
    }

    @Column(name = "prob_embarazo_nino", length = 15)
    public String getProbEmbarazoNino() {
        return probEmbarazoNino;
    }

    public void setProbEmbarazoNino(String probEmbarazoNino) {
        this.probEmbarazoNino = probEmbarazoNino;
    }

    @Column(name = "prob_embarazo_otro_nino", length = 100)
    public String getProbEmbarazoOtroNino() {
        return probEmbarazoOtroNino;
    }

    public void setProbEmbarazoOtroNino(String probEmbarazoOtroNino) {
        this.probEmbarazoOtroNino = probEmbarazoOtroNino;
    }

    @Column(name = "ocurrio_embarazo_nino", length = 1)
    public String getOcurrioEmbarazoNino() {
        return ocurrioEmbarazoNino;
    }

    public void setOcurrioEmbarazoNino(String ocurrioEmbarazoNino) {
        this.ocurrioEmbarazoNino = ocurrioEmbarazoNino;
    }

    @Column(name = "problemas_bebe_nino", length = 40)
    public String getProblemasBebeNino() {
        return problemasBebeNino;
    }

    public void setProblemasBebeNino(String problemasBebeNino) {
        this.problemasBebeNino = problemasBebeNino;
    }

    @Column(name = "problemas_extrem_nino", length = 100)
    public String getProblemasExtremNino() {
        return problemasExtremNino;
    }

    public void setProblemasExtremNino(String problemasExtremNino) {
        this.problemasExtremNino = problemasExtremNino;
    }

    @Column(name = "problemas_lactancia_nino", length = 100)
    public String getProblemasLactanciaNino() {
        return problemasLactanciaNino;
    }

    public void setProblemasLactanciaNino(String problemasLactanciaNino) {
        this.problemasLactanciaNino = problemasLactanciaNino;
    }

    @Column(name = "vision_prob_nino", length = 1)
    public String getVisionProbNino() {
        return visionProbNino;
    }

    public void setVisionProbNino(String visionProbNino) {
        this.visionProbNino = visionProbNino;
    }

    @Column(name = "vision_describa_nino", length = 100)
    public String getVisionDescribaNino() {
        return visionDescribaNino;
    }

    public void setVisionDescribaNino(String visionDescribaNino) {
        this.visionDescribaNino = visionDescribaNino;
    }

    @Column(name = "audicion_prob_nino", length = 1)
    public String getAudicionProbNino() {
        return audicionProbNino;
    }

    public void setAudicionProbNino(String audicionProbNino) {
        this.audicionProbNino = audicionProbNino;
    }

    @Column(name = "audicion_describa_nino", length = 100)
    public String getAudicionDescribaNino() {
        return audicionDescribaNino;
    }

    public void setAudicionDescribaNino(String audicionDescribaNino) {
        this.audicionDescribaNino = audicionDescribaNino;
    }

    @Column(name = "neuro_prob_nino", length = 1)
    public String getNeuroProbNino() {
        return neuroProbNino;
    }

    public void setNeuroProbNino(String neuroProbNino) {
        this.neuroProbNino = neuroProbNino;
    }

    @Column(name = "medicamento_nino", length = 1)
    public String getMedicamentoNino() {
        return medicamentoNino;
    }

    public void setMedicamentoNino(String medicamentoNino) {
        this.medicamentoNino = medicamentoNino;
    }

    @Column(name = "medicamento_lista_nino", length = 100)
    public String getMedicamentoListaNino() {
        return medicamentoListaNino;
    }

    public void setMedicamentoListaNino(String medicamentoListaNino) {
        this.medicamentoListaNino = medicamentoListaNino;
    }

    @Column(name = "amamantando_nino", length = 1)
    public String getAmamantandoNino() {
        return amamantandoNino;
    }

    public void setAmamantandoNino(String amamantandoNino) {
        this.amamantandoNino = amamantandoNino;
    }

    @Column(name = "fecha_amamantar_nino")
    public Date getFechaAmamantarNino() {
        return fechaAmamantarNino;
    }

    public void setFechaAmamantarNino(Date fechaAmamantarNino) {
        this.fechaAmamantarNino = fechaAmamantarNino;
    }

    @Column(name = "tiempo_fuera_nino", length = 1)
    public String getTiempoFueraNino() {
        return tiempoFueraNino;
    }

    public void setTiempoFueraNino(String tiempoFueraNino) {
        this.tiempoFueraNino = tiempoFueraNino;
    }

    @Column(name = "parte_dia_afuera_nino", length = 5)
    public String getParteDiaAfueraNino() {
        return parteDiaAfueraNino;
    }

    public void setParteDiaAfueraNino(String parteDiaAfueraNino) {
        this.parteDiaAfueraNino = parteDiaAfueraNino;
    }

    @Column(name = "quien_cuida_nino", length = 1)
    public String getQuienCuidaNino() {
        return quienCuidaNino;
    }

    public void setQuienCuidaNino(String quienCuidaNino) {
        this.quienCuidaNino = quienCuidaNino;
    }

    @Column(name = "mayoria_tiempo_nino", length = 1)
    public String getMayoriaTiempoNino() {
        return mayoriaTiempoNino;
    }

    public void setMayoriaTiempoNino(String mayoriaTiempoNino) {
        this.mayoriaTiempoNino = mayoriaTiempoNino;
    }

    @Column(name = "picaduras_nino", length = 1)
    public String getPicadurasNino() {
        return picadurasNino;
    }

    public void setPicadurasNino(String picadurasNino) {
        this.picadurasNino = picadurasNino;
    }

    @Column(name = "mosquitero_dormir_nino", length = 1)
    public String getMosquiteroDormirNino() {
        return mosquiteroDormirNino;
    }

    public void setMosquiteroDormirNino(String mosquiteroDormirNino) {
        this.mosquiteroDormirNino = mosquiteroDormirNino;
    }

    @Column(name = "mosquitero_frecuencia_nino", length = 1)
    public String getMosquiteroFrecuenciaNino() {
        return mosquiteroFrecuenciaNino;
    }

    public void setMosquiteroFrecuenciaNino(String mosquiteroFrecuenciaNino) {
        this.mosquiteroFrecuenciaNino = mosquiteroFrecuenciaNino;
    }

    @Column(name = "repelente_insectos_nino", length = 1)
    public String getRepelenteInsectosNino() {
        return repelenteInsectosNino;
    }

    public void setRepelenteInsectosNino(String repelenteInsectosNino) {
        this.repelenteInsectosNino = repelenteInsectosNino;
    }

    @Column(name = "repelente_frecuencia_nino", length = 1)
    public String getRepelenteFrecuenciaNino() {
        return repelenteFrecuenciaNino;
    }

    public void setRepelenteFrecuenciaNino(String repelenteFrecuenciaNino) {
        this.repelenteFrecuenciaNino = repelenteFrecuenciaNino;
    }

    @Column(name = "ministerio_fuera_nino", length = 1)
    public String getMinisterioFueraNino() {
        return ministerioFueraNino;
    }

    public void setMinisterioFueraNino(String ministerioFueraNino) {
        this.ministerioFueraNino = ministerioFueraNino;
    }

    @Column(name = "ultima_vez_fuera_nino", length = 1)
    public String getUltimaVezFueraNino() {
        return ultimaVezFueraNino;
    }

    public void setUltimaVezFueraNino(String ultimaVezFueraNino) {
        this.ultimaVezFueraNino = ultimaVezFueraNino;
    }

    @Column(name = "ministerio_dentro_nino", length = 1)
    public String getMinisterioDentroNino() {
        return ministerioDentroNino;
    }

    public void setMinisterioDentroNino(String ministerioDentroNino) {
        this.ministerioDentroNino = ministerioDentroNino;
    }

    @Column(name = "ultima_vez_dentro_nino", length = 1)
    public String getUltimaVezDentroNino() {
        return ultimaVezDentroNino;
    }

    public void setUltimaVezDentroNino(String ultimaVezDentroNino) {
        this.ultimaVezDentroNino = ultimaVezDentroNino;
    }

    @Column(name = "aplica_abate_nino", length = 1)
    public String getAplicaAbateNino() {
        return aplicaAbateNino;
    }

    public void setAplicaAbateNino(String aplicaAbateNino) {
        this.aplicaAbateNino = aplicaAbateNino;
    }

    @Column(name = "ultima_vez_abate_nino", length = 1)
    public String getUltimaVezAbateNino() {
        return ultimaVezAbateNino;
    }

    public void setUltimaVezAbateNino(String ultimaVezAbateNino) {
        this.ultimaVezAbateNino = ultimaVezAbateNino;
    }

    @Column(name = "insecticida_ambiental_nino", length = 1)
    public String getInsecticidaAmbientalNino() {
        return insecticidaAmbientalNino;
    }

    public void setInsecticidaAmbientalNino(String insecticidaAmbientalNino) {
        this.insecticidaAmbientalNino = insecticidaAmbientalNino;
    }

    @Column(name = "ultima_vez_insecticida_nino", length = 1)
    public String getUltimaVezInsecticidaNino() {
        return ultimaVezInsecticidaNino;
    }

    public void setUltimaVezInsecticidaNino(String ultimaVezInsecticidaNino) {
        this.ultimaVezInsecticidaNino = ultimaVezInsecticidaNino;
    }

    @Column(name = "fiebre_amarilla_nino", length = 1)
    public String getFiebreAmarillaNino() {
        return fiebreAmarillaNino;
    }

    public void setFiebreAmarillaNino(String fiebreAmarillaNino) {
        this.fiebreAmarillaNino = fiebreAmarillaNino;
    }

    @Column(name = "fecha_fiebre_amarilla_nino")
    public Date getFechaFiebreAmarillaNino() {
        return fechaFiebreAmarillaNino;
    }

    public void setFechaFiebreAmarillaNino(Date fechaFiebreAmarillaNino) {
        this.fechaFiebreAmarillaNino = fechaFiebreAmarillaNino;
    }

    @Column(name = "transfusion_sangre_nino", length = 1)
    public String getTransfusionSangreNino() {
        return transfusionSangreNino;
    }

    public void setTransfusionSangreNino(String transfusionSangreNino) {
        this.transfusionSangreNino = transfusionSangreNino;
    }

    @Column(name = "fecha_transfusion_nino")
    public Date getFechaTransfusionNino() {
        return fechaTransfusionNino;
    }

    public void setFechaTransfusionNino(Date fechaTransfusionNino) {
        this.fechaTransfusionNino = fechaTransfusionNino;
    }

    @Column(name = "paises_fuera_nino", length = 1)
    public String getPaisesFueraNino() {
        return paisesFueraNino;
    }

    public void setPaisesFueraNino(String paisesFueraNino) {
        this.paisesFueraNino = paisesFueraNino;
    }

    @Column(name = "donde_pais_afuera_nino", length = 50)
    public String getDondePaisAfueraNino() {
        return dondePaisAfueraNino;
    }

    public void setDondePaisAfueraNino(String dondePaisAfueraNino) {
        this.dondePaisAfueraNino = dondePaisAfueraNino;
    }

    @Column(name = "fuera_managua_nino", length = 1)
    public String getFueraManaguaNino() {
        return fueraManaguaNino;
    }

    public void setFueraManaguaNino(String fueraManaguaNino) {
        this.fueraManaguaNino = fueraManaguaNino;
    }

    @Column(name = "adonde_fuera_managua_nino", length = 100)
    public String getAdondeFueraManaguaNino() {
        return adondeFueraManaguaNino;
    }

    public void setAdondeFueraManaguaNino(String adondeFueraManaguaNino) {
        this.adondeFueraManaguaNino = adondeFueraManaguaNino;
    }

    @Column(name = "visto_medico_nino", length = 1)
    public String getVistoMedicoNino() {
        return vistoMedicoNino;
    }

    public void setVistoMedicoNino(String vistoMedicoNino) {
        this.vistoMedicoNino = vistoMedicoNino;
    }

    @Column(name = "motivo_medico_nino", length = 1)
    public String getMotivoMedicoNino() {
        return motivoMedicoNino;
    }

    public void setMotivoMedicoNino(String motivoMedicoNino) {
        this.motivoMedicoNino = motivoMedicoNino;
    }

    @Column(name = "visita_enfermedad_nino", length = 100)
    public String getVisitaEnfermedadNino() {
        return visitaEnfermedadNino;
    }

    public void setVisitaEnfermedadNino(String visitaEnfermedadNino) {
        this.visitaEnfermedadNino = visitaEnfermedadNino;
    }

    @Column(name = "problemas_nino", length = 40)
    public String getProblemasNino() {
        return problemasNino;
    }

    public void setProblemasNino(String problemasNino) {
        this.problemasNino = problemasNino;
    }


    @Column(name = "problemas_otro_nino", length = 100)
    public String getProblemasOtroNino() {
        return problemasOtroNino;
    }

    public void setProblemasOtroNino(String problemasOtroNino) {
        this.problemasOtroNino = problemasOtroNino;
    }

    @Column(name = "diagnosticado_zika_nino", length = 1)
    public String getDiagnosticadoZikaNino() {
        return diagnosticadoZikaNino;
    }

    public void setDiagnosticadoZikaNino(String diagnosticadoZikaNino) {
        this.diagnosticadoZikaNino = diagnosticadoZikaNino;
    }

    @Column(name = "fecha_zika_nino")
    public Date getFechaZikaNino() {
        return fechaZikaNino;
    }

    public void setFechaZikaNino(Date fechaZikaNino) {
        this.fechaZikaNino = fechaZikaNino;
    }

    @Column(name = "diagnos_chikungunya_nino", length = 1)
    public String getDiagnosChikungunyaNino() {
        return diagnosChikungunyaNino;
    }

    public void setDiagnosChikungunyaNino(String diagnosChikungunyaNino) {
        this.diagnosChikungunyaNino = diagnosChikungunyaNino;
    }

    @Column(name = "fecha_chikungunya_nino")
    public Date getFechaChikungunyaNino() {
        return fechaChikungunyaNino;
    }

    public void setFechaChikungunyaNino(Date fechaChikungunyaNino) {
        this.fechaChikungunyaNino = fechaChikungunyaNino;
    }

    @Column(name = "diagnosticado_dengue_nino", length = 1)
    public String getDiagnosticadoDengueNino() {
        return diagnosticadoDengueNino;
    }

    public void setDiagnosticadoDengueNino(String diagnosticadoDengueNino) {
        this.diagnosticadoDengueNino = diagnosticadoDengueNino;
    }

    @Column(name = "fecha_dengue_nino")
    public Date getFechaDengueNino() {
        return fechaDengueNino;
    }

    public void setFechaDengueNino(Date fechaDengueNino) {
        this.fechaDengueNino = fechaDengueNino;
    }

    @Column(name = "nombre_encuestador_nino", length = 100)
    public String getNombreEncuestadorNino() {
        return nombreEncuestadorNino;
    }

    public void setNombreEncuestadorNino(String nombreEncuestadorNino) {
        this.nombreEncuestadorNino = nombreEncuestadorNino;
    }

    @Column(name = "descripcion_prob_neuro_nino_upd", length = 100)
    public String getDescripcionProbNeuroNinoUpd() {
        return descripcionProbNeuroNinoUpd;
    }

    public void setDescripcionProbNeuroNinoUpd(String descripcionProbNeuroNinoUpd) {
        this.descripcionProbNeuroNinoUpd = descripcionProbNeuroNinoUpd;
    }

    @Column(name = "problema_comer_nino_upd", length = 1)
    public String getProblemaComerNinoUpd() {
        return problemaComerNinoUpd;
    }

    public void setProblemaComerNinoUpd(String problemaComerNinoUpd) {
        this.problemaComerNinoUpd = problemaComerNinoUpd;
    }

    @Override
    public boolean isFieldAuditable(String fieldname) {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZpoV2CuestSaludInfantil that = (ZpoV2CuestSaludInfantil) o;

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
