package ni.org.ics.zpo.v2.domain;

import ni.org.ics.zpo.v2.domain.audit.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "zpo_cuest_visita_terreno", catalog = "zika_zpo_v2")
public class ZpoV2CuestVisitaTerreno extends BaseMetaData implements Auditable {

    private String recordId;
    private String eventName;
    private Date fechaVisita;
    private String areaCS;
    private String resultadoVisita;
    private String otroResultadoVisita;
    private Date fechaCita;
    private String horaCita;
    private String persCitaEntregada;
    private String persCompletaForm;

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

    @Id
    @Column(name = "fecha_visita", nullable = false)
    public Date getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    @Column(name = "area_centro_salud", length = 2)
    public String getAreaCS() {
        return areaCS;
    }

    public void setAreaCS(String areaCS) {
        this.areaCS = areaCS;
    }

    @Column(name = "resultado_visita", length = 2)
    public String getResultadoVisita() {
        return resultadoVisita;
    }

    public void setResultadoVisita(String resultadoVisita) {
        this.resultadoVisita = resultadoVisita;
    }

    @Column(name = "otro_resultado_visita", length = 25)
    public String getOtroResultadoVisita() {
        return otroResultadoVisita;
    }

    public void setOtroResultadoVisita(String otroResultadoVisita) {
        this.otroResultadoVisita = otroResultadoVisita;
    }

    @Column(name = "fecha_cita")
    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    @Column(name = "hora_cita", length = 2)
    public String getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(String horaVisita) {
        this.horaCita = horaVisita;
    }

    @Column(name = "pers_cita_entregada", length = 2)
    public String getPersCitaEntregada() {
        return persCitaEntregada;
    }

    public void setPersCitaEntregada(String persCitaEntregada) {
        this.persCitaEntregada = persCitaEntregada;
    }

    @Column(name = "pers_completa_form", length = 100)
    public String getPersCompletaForm() {
        return persCompletaForm;
    }

    public void setPersCompletaForm(String persCompletaForm) {
        this.persCompletaForm = persCompletaForm;
    }

    @Override
    public boolean isFieldAuditable(String fieldname) {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZpoV2CuestVisitaTerreno that = (ZpoV2CuestVisitaTerreno) o;
        return recordId.equals(that.recordId) &&
                eventName.equals(that.eventName) && fechaVisita.equals(that.fechaVisita);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recordId, eventName, fechaVisita);
    }
}
