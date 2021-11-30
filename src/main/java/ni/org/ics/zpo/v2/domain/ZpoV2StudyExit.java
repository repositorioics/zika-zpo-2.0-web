package ni.org.ics.zpo.v2.domain;

import ni.org.ics.zpo.v2.domain.audit.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by FIRSTICT on 10/11/2016.
 * V1.0
 */
@Entity
@Table(name = "zpo_study_exit", catalog = "zika_zpo_v2")
public class ZpoV2StudyExit extends BaseMetaData implements Auditable {

    private static final long serialVersionUID = 1L;
    private String recordId;
    private String eventName;
    private Date fechaHoyDiscont;
    private String razonPorDiscont;
    private String otraRazonDiscontin;
    private String encuestadorDiscont;

    @Id
    @Column(name = "record_id", nullable = false, length = 25)
    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    @Column(name = "event_name", nullable = false, length = 100)
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @Column(name = "fecha_hoy_discont", nullable = false)
    public Date getFechaHoyDiscont() {
        return fechaHoyDiscont;
    }

    public void setFechaHoyDiscont(Date fechaHoyDiscont) {
        this.fechaHoyDiscont = fechaHoyDiscont;
    }

    @Column(name = "razon_por_discont", nullable = false, length = 2)
    public String getRazonPorDiscont() {
        return razonPorDiscont;
    }

    public void setRazonPorDiscont(String razonPorDiscont) {
        this.razonPorDiscont = razonPorDiscont;
    }

    @Column(name = "otra_razon_discontin", length = 500)
    public String getOtraRazonDiscontin() {
        return otraRazonDiscontin;
    }

    public void setOtraRazonDiscontin(String otraRazonDiscontin) {
        this.otraRazonDiscontin = otraRazonDiscontin;
    }

    @Column(name = "encuestador_discont", length = 100)
    public String getEncuestadorDiscont() {
        return encuestadorDiscont;
    }

    public void setEncuestadorDiscont(String encuestadorDiscont) {
        this.encuestadorDiscont = encuestadorDiscont;
    }

    @Override
    public boolean isFieldAuditable(String fieldname) {
        return true;
    }

    @Override
    public String toString() {
        return this.recordId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof ZpoV2StudyExit)) return false;

        ZpoV2StudyExit that = (ZpoV2StudyExit) o;

        return (recordId.equals(that.recordId));
    }
}
