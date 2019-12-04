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
@Table(name = "zpo_cuest_demografico", catalog = "zika_zpo_v2")
public class ZpoV2CuestionarioDemografico extends BaseMetaData implements Auditable {

    private String recordId;
    private String eventName;
    private Date fechaHoy;
    private String nombreMadreDemogr;
    private String codigoMadreDemogr;
    private String nombreNinoDemogr;
    private String nombrePadreDemogr;
    private Date fechaNacMadreDemogr;
    private Date fechaNacNinoDemogr;
    private Date fechaNacPadreDemogr;
    private String sexoDemogr;
    private String direcBarrioDemogr;
    private String direcExactaDemogr;
    private String direcColorCasaDemogr;
    private String ubicCasaDemogr;
    private String nrosTelefonicosDemogr;
    private Integer nroCelularDemogr;
    private String etnicidadDemogr;
    private String razaDemogr;
    private String estadoCivilDemogr;
    private Integer escolaridadMadreDemogr;
    private Integer escolaridadPadreDemogr;
    private String nombreEncuestadorDemogr;

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

    @Column(name = "fecha_de_hoy_demogr", nullable = false)
    public Date getFechaHoy() {
        return fechaHoy;
    }

    public void setFechaHoy(Date fechaHoy) {
        this.fechaHoy = fechaHoy;
    }

    @Column(name = "nombre_madre_demogr", length = 100)
    public String getNombreMadreDemogr() {
        return nombreMadreDemogr;
    }

    public void setNombreMadreDemogr(String nombreMadreDemogr) {
        this.nombreMadreDemogr = nombreMadreDemogr;
    }

    @Column(name = "codigo_madre_demogr", length = 25)
    public String getCodigoMadreDemogr() {
        return codigoMadreDemogr;
    }

    public void setCodigoMadreDemogr(String codigoMadreDemogr) {
        this.codigoMadreDemogr = codigoMadreDemogr;
    }

    @Column(name = "nombre_nino_demogr", length = 100)
    public String getNombreNinoDemogr() {
        return nombreNinoDemogr;
    }

    public void setNombreNinoDemogr(String nombreNinoDemogr) {
        this.nombreNinoDemogr = nombreNinoDemogr;
    }


    @Column(name = "nombre_padre_demogr", length = 100)
    public String getNombrePadreDemogr() {
        return nombrePadreDemogr;
    }

    public void setNombrePadreDemogr(String nombrePadreDemogr) {
        this.nombrePadreDemogr = nombrePadreDemogr;
    }

    @Column(name = "fecha_nacimiento_madre_demogr")
    public Date getFechaNacMadreDemogr() {
        return fechaNacMadreDemogr;
    }

    public void setFechaNacMadreDemogr(Date fechaNacMadreDemogr) {
        this.fechaNacMadreDemogr = fechaNacMadreDemogr;
    }

    @Column(name = "fecha_nacimiento_nino_demogr")
    public Date getFechaNacNinoDemogr() {
        return fechaNacNinoDemogr;
    }

    public void setFechaNacNinoDemogr(Date fechaNacNinoDemogr) {
        this.fechaNacNinoDemogr = fechaNacNinoDemogr;
    }



    @Column(name = "fecha_nacimiento_padre_demogr")
    public Date getFechaNacPadreDemogr() {
        return fechaNacPadreDemogr;
    }

    public void setFechaNacPadreDemogr(Date fechaNacPadreDemogr) {
        this.fechaNacPadreDemogr = fechaNacPadreDemogr;
    }

    @Column(name = "sexo_demogr", length = 2)
    public String getSexoDemogr() {
        return sexoDemogr;
    }

    public void setSexoDemogr(String sexoDemogr) {
        this.sexoDemogr = sexoDemogr;
    }

    @Column(name = "direccion_barrio_demogr", nullable = false, length = 100)
    public String getDirecBarrioDemogr() {
        return direcBarrioDemogr;
    }

    public void setDirecBarrioDemogr(String direcBarrioDemogr) {
        this.direcBarrioDemogr = direcBarrioDemogr;
    }

    @Column(name = "direccion_exacta_demogr", nullable = false, length = 500)
    public String getDirecExactaDemogr() {
        return direcExactaDemogr;
    }

    public void setDirecExactaDemogr(String direcExactaDemogr) {
        this.direcExactaDemogr = direcExactaDemogr;
    }

    @Column(name = "direccion_color_casa_demogr", length = 100)
    public String getDirecColorCasaDemogr() {
        return direcColorCasaDemogr;
    }

    public void setDirecColorCasaDemogr(String direcColorCasaDemogr) {
        this.direcColorCasaDemogr = direcColorCasaDemogr;
    }

    @Column(name = "ubicacion_casa_demogr", length = 100)
    public String getUbicCasaDemogr() {
        return ubicCasaDemogr;
    }

    public void setUbicCasaDemogr(String ubicCasaDemogr) {
        this.ubicCasaDemogr = ubicCasaDemogr;
    }


    @Column(name = "numeros_telefonicos_demogr", nullable = false, length = 2)
    public String getNrosTelefonicosDemogr() {
        return nrosTelefonicosDemogr;
    }

    public void setNrosTelefonicosDemogr(String nrosTelefonicosDemogr) {
        this.nrosTelefonicosDemogr = nrosTelefonicosDemogr;
    }

    @Column(name = "numero_celular_demogr")
    public Integer getNroCelularDemogr() {
        return nroCelularDemogr;
    }

    public void setNroCelularDemogr(Integer nroCelularDemogr) {
        this.nroCelularDemogr = nroCelularDemogr;
    }

    @Column(name = "etnicidad_demogr", length = 2)
    public String getEtnicidadDemogr() {
        return etnicidadDemogr;
    }

    public void setEtnicidadDemogr(String etnicidadDemogr) {
        this.etnicidadDemogr = etnicidadDemogr;
    }

    @Column(name = "raza_demogr", length = 2)
    public String getRazaDemogr() {
        return razaDemogr;
    }

    public void setRazaDemogr(String razaDemogr) {
        this.razaDemogr = razaDemogr;
    }

    @Column(name = "estado_civil_demogr", length = 2)
    public String getEstadoCivilDemogr() {
        return estadoCivilDemogr;
    }

    public void setEstadoCivilDemogr(String estadoCivilDemogr) {
        this.estadoCivilDemogr = estadoCivilDemogr;
    }

    @Column(name = "escolaridad_madre_demogr")
    public Integer getEscolaridadMadreDemogr() {
        return escolaridadMadreDemogr;
    }

    public void setEscolaridadMadreDemogr(Integer escolaridadMadreDemogr) {
        this.escolaridadMadreDemogr = escolaridadMadreDemogr;
    }

    @Column(name = "escolaridad_padre_demogr")
    public Integer getEscolaridadPadreDemogr() {
        return escolaridadPadreDemogr;
    }

    public void setEscolaridadPadreDemogr(Integer escolaridadPadreDemogr) {
        this.escolaridadPadreDemogr = escolaridadPadreDemogr;
    }


    @Column(name = "nombre_encuestador_demogr", nullable = false, length = 100)
    public String getNombreEncuestadorDemogr() {
        return nombreEncuestadorDemogr;
    }

    public void setNombreEncuestadorDemogr(String nombreEncuestadorDemogr) {
        this.nombreEncuestadorDemogr = nombreEncuestadorDemogr;
    }


    @Override
    public boolean isFieldAuditable(String fieldname) {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZpoV2CuestionarioDemografico that = (ZpoV2CuestionarioDemografico) o;

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
