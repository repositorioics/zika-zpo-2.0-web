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
@Table(name = "zpo_ind_cuidado_fam", catalog = "zika_zpo_v2")
public class ZpoV2IndCuidadoFamilia extends BaseMetaData implements Auditable {

    private String recordId;
    private String eventName;
    private Date fechaHoyFci;
    private String cuantosLibrosFci;
    private String cuantasRevistasFui;
    private String materialesJugarMonth;
    private String materialesJugarFci;
    private String variedadJugarFci;
    private String nombreEncuestadorFci;

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

    @Column(name = "fecha_de_hoy_fci")
    public Date getFechaHoyFci() {
        return fechaHoyFci;
    }

    public void setFechaHoyFci(Date fechaHoyFci) {
        this.fechaHoyFci = fechaHoyFci;
    }


    @Column(name ="cuantos_libros_fci", length = 1)
    public String getCuantosLibrosFci() {
        return cuantosLibrosFci;
    }

    public void setCuantosLibrosFci(String cuantosLibrosFci) {
        this.cuantosLibrosFci = cuantosLibrosFci;
    }

    @Column(name = "cuantas_revistas_fui", length = 1)
    public String getCuantasRevistasFui() {
        return cuantasRevistasFui;
    }

    public void setCuantasRevistasFui(String cuantasRevistasFui) {
        this.cuantasRevistasFui = cuantasRevistasFui;
    }

    @Column(name = "materiales_jugar_month", length = 10)
    public String getMaterialesJugarMonth() {
        return materialesJugarMonth;
    }

    public void setMaterialesJugarMonth(String materialesJugarMonth) {
        this.materialesJugarMonth = materialesJugarMonth;
    }

    @Column(name = "materiales_jugar_fci", length = 15)
    public String getMaterialesJugarFci() {
        return materialesJugarFci;
    }

    public void setMaterialesJugarFci(String materialesJugarFci) {
        this.materialesJugarFci = materialesJugarFci;
    }

    @Column(name = "variedad_jugar_fci", length = 12)
    public String getVariedadJugarFci() {
        return variedadJugarFci;
    }

    public void setVariedadJugarFci(String variedadJugarFci) {
        this.variedadJugarFci = variedadJugarFci;
    }

    @Column(name = "nombre_encuestador_fci", length = 100)
    public String getNombreEncuestadorFci() {
        return nombreEncuestadorFci;
    }

    public void setNombreEncuestadorFci(String nombreEncuestadorFci) {
        this.nombreEncuestadorFci = nombreEncuestadorFci;
    }

    @Override
    public boolean isFieldAuditable(String fieldname) {
        return false;
    }

    @Override
    public String toString() {
        return "ZpoV2IndCuidadoFamilia{" +
                "recordId='" + recordId + '\'' +
                ", eventName='" + eventName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZpoV2IndCuidadoFamilia that = (ZpoV2IndCuidadoFamilia) o;

        if (recordId != null ? !recordId.equals( that.recordId ) : that.recordId != null) return false;
        return eventName != null ? eventName.equals( that.eventName ) : that.eventName == null;
    }

    @Override
    public int hashCode() {
        int result = recordId != null ? recordId.hashCode() : 0;
        result = 31 * result + (eventName != null ? eventName.hashCode() : 0);
        return result;
    }
}
