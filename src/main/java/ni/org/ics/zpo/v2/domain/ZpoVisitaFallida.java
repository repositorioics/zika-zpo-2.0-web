package ni.org.ics.zpo.v2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Miguel Salinas on 11/29/2017.
 * V1.0
 */
@Entity
@Table(name = "zpo_visita_fallida", catalog = "zika_zpo_v2")
public class ZpoVisitaFallida  extends BaseMetaData {

    private static final long serialVersionUID = 1L;
    private String id;
    private String razon;
    private String otraRazon;
    private String persona;
    private Date fechaVisita;

    @Id
    @Column(name = "ID", nullable = false, length = 50)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "RAZON", nullable = false, length = 50)
    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    @Column(name = "OTRA_RAZON", nullable = false, length = 100)
    public String getOtraRazon() {
        return otraRazon;
    }

    public void setOtraRazon(String otraRazon) {
        this.otraRazon = otraRazon;
    }

    @Column(name = "PERSONA", nullable = false, length = 50)
    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    @Column(name = "FECHA_HORA_VISITA", nullable = false)
    public Date getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }
}
