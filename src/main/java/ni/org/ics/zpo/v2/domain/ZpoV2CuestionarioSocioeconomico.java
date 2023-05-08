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
@Table(name = "zpo_cuest_socioeconomico", catalog = "zika_zpo_v2")
public class ZpoV2CuestionarioSocioeconomico extends BaseMetaData implements Auditable {

    private String recordId;
    private String eventName;
    private Date fechaHoySes;
    private String paredesCasaSes;
    private String paredesCasaOtraSes;
    private String fuenteAguaSes;
    private String fuenteAguaOtraSes;
    private String aguaIntermitenteSes;
    private String guardadoAguaSes;
    private String tipoBanoSes;
    private String pisoSes;
    private String pisoOtroSes;
    private String electricidadSes;
    private String aireAcondicionadoSes;
    private String abanicoSes;
    private String mosquiterosSes;
    private String animalesSes;
    private String dormitoriosSes;
    private String cuantosDuermenSes;
    private String cuantosAdultosSes;
    private String cuantosNinosSes;
    private String persona1NombreSes;
    private String persona1EdadSes;
    private String persona1GradoSes;
    private String persona1OcupacionSes;
    private String persona2NombreSes;
    private String persona2EdadSes;
    private String persona2GradoSes;
    private String persona2OcupacionSes;
    private String persona3NombreSes;
    private String persona3EdadSes;
    private String persona3GradoSes;
    private String persona3OcupacionSes;
    private String persona4NombreSes;
    private String persona4EdadSes;
    private String persona4GradoSes;
    private String persona4OcupacionSes;
    private String persona5NombreSes;
    private String persona5EdadSes;
    private String persona5GradoSes;
    private String persona5OcupacionSes;
    private String persona6NombreSes;
    private String persona6EdadSes;
    private String persona6GradoSes;
    private String persona6OcupacionSes;
    private String persona7NombreSes;
    private String persona7EdadSes;
    private String persona7GradoSes;
    private String persona7OcupacionSes;
    private String persona8NombreSes;
    private String persona8EdadSes;
    private String persona8GradoSes;
    private String persona8OcupacionSes;
    private String nombreEncuestadorSes;
    private String preescolarSes;
    private String cuandoPreescolarSes;
    private String ambosPadresSes;

    private String pri;
    private String sec;
    private String third;
    private String schCovid;
    private String primarySch;


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

    @Column(name = "fecha_hoy_ses", nullable = false)
    public Date getFechaHoySes() {
        return fechaHoySes;
    }

    public void setFechaHoySes(Date fechaHoySes) {
        this.fechaHoySes = fechaHoySes;
    }

    @Column(name = "paredes_casa_ses", length = 40)
    public String getParedesCasaSes() {
        return paredesCasaSes;
    }

    public void setParedesCasaSes(String paredesCasaSes) {
        this.paredesCasaSes = paredesCasaSes;
    }

    @Column(name = "paredes_casa_otra_ses", length = 100)
    public String getParedesCasaOtraSes() {
        return paredesCasaOtraSes;
    }

    public void setParedesCasaOtraSes(String paredesCasaOtraSes) {
        this.paredesCasaOtraSes = paredesCasaOtraSes;
    }

    @Column(name = "fuente_agua_ses", length = 1)
    public String getFuenteAguaSes() {
        return fuenteAguaSes;
    }

    public void setFuenteAguaSes(String fuenteAguaSes) {
        this.fuenteAguaSes = fuenteAguaSes;
    }

    @Column(name = "fuente_agua_otra_ses", length = 100)
    public String getFuenteAguaOtraSes() {
        return fuenteAguaOtraSes;
    }

    public void setFuenteAguaOtraSes(String fuenteAguaOtraSes) {
        this.fuenteAguaOtraSes = fuenteAguaOtraSes;
    }

    @Column(name = "agua_intermitente_ses", length = 1)
    public String getAguaIntermitenteSes() {
        return aguaIntermitenteSes;
    }

    public void setAguaIntermitenteSes(String aguaIntermitenteSes) {
        this.aguaIntermitenteSes = aguaIntermitenteSes;
    }

    @Column(name = "guardado_agua_ses", length = 1)
    public String getGuardadoAguaSes() {
        return guardadoAguaSes;
    }

    public void setGuardadoAguaSes(String guardadoAguaSes) {
        this.guardadoAguaSes = guardadoAguaSes;
    }

    @Column(name = "tipo_bano_ses", length = 10)
    public String getTipoBanoSes() {
        return tipoBanoSes;
    }

    public void setTipoBanoSes(String tipoBanoSes) {
        this.tipoBanoSes = tipoBanoSes;
    }

    @Column(name = "piso_ses", length = 12)
    public String getPisoSes() {
        return pisoSes;
    }

    public void setPisoSes(String pisoSes) {
        this.pisoSes = pisoSes;
    }

    @Column(name = "piso_otro_ses", length = 100)
    public String getPisoOtroSes() {
        return pisoOtroSes;
    }

    public void setPisoOtroSes(String pisoOtroSes) {
        this.pisoOtroSes = pisoOtroSes;
    }

    @Column(name = "electricidad_ses", length = 1)
    public String getElectricidadSes() {
        return electricidadSes;
    }

    public void setElectricidadSes(String electricidadSes) {
        this.electricidadSes = electricidadSes;
    }

    @Column(name = "aire_acondicionado_ses", length = 1)
    public String getAireAcondicionadoSes() {
        return aireAcondicionadoSes;
    }

    public void setAireAcondicionadoSes(String aireAcondicionadoSes) {
        this.aireAcondicionadoSes = aireAcondicionadoSes;
    }

    @Column(name = "abanico_ses", length = 1)
    public String getAbanicoSes() {
        return abanicoSes;
    }

    public void setAbanicoSes(String abanicoSes) {
        this.abanicoSes = abanicoSes;
    }

    @Column(name = "mosquiteros_ses", length = 1)
    public String getMosquiterosSes() {
        return mosquiterosSes;
    }

    public void setMosquiterosSes(String mosquiterosSes) {
        this.mosquiterosSes = mosquiterosSes;
    }

    @Column(name = "animales_ses", length = 22)
    public String getAnimalesSes() {
        return animalesSes;
    }

    public void setAnimalesSes(String animalesSes) {
        this.animalesSes = animalesSes;
    }

    @Column(name = "dormitorios_ses", length = 1)
    public String getDormitoriosSes() {
        return dormitoriosSes;
    }

    public void setDormitoriosSes(String dormitoriosSes) {
        this.dormitoriosSes = dormitoriosSes;
    }

    @Column(name = "cuantos_duermen_ses", length = 1)
    public String getCuantosDuermenSes() {
        return cuantosDuermenSes;
    }

    public void setCuantosDuermenSes(String cuantosDuermenSes) {
        this.cuantosDuermenSes = cuantosDuermenSes;
    }

    @Column(name = "cuantos_adultos_ses", length = 1)
    public String getCuantosAdultosSes() {
        return cuantosAdultosSes;
    }

    public void setCuantosAdultosSes(String cuantosAdultosSes) {
        this.cuantosAdultosSes = cuantosAdultosSes;
    }

    @Column(name = "cuantos_ninos_ses", length = 1)
    public String getCuantosNinosSes() {
        return cuantosNinosSes;
    }

    public void setCuantosNinosSes(String cuantosNinosSes) {
        this.cuantosNinosSes = cuantosNinosSes;
    }

    @Column(name = "persona_1_nombre_ses", length = 100)
    public String getPersona1NombreSes() {
        return persona1NombreSes;
    }

    public void setPersona1NombreSes(String persona1NombreSes) {
        this.persona1NombreSes = persona1NombreSes;
    }

    @Column(name = "persona_1_edad_ses", length = 25)
    public String getPersona1EdadSes() {
        return persona1EdadSes;
    }

    public void setPersona1EdadSes(String persona1EdadSes) {
        this.persona1EdadSes = persona1EdadSes;
    }

    @Column(name = "persona_1_grado_ses", length = 2)
    public String getPersona1GradoSes() {
        return persona1GradoSes;
    }

    public void setPersona1GradoSes(String persona1GradoSes) {
        this.persona1GradoSes = persona1GradoSes;
    }

    @Column(name = "persona_1_ocupacion_ses", length = 2)
    public String getPersona1OcupacionSes() {
        return persona1OcupacionSes;
    }

    public void setPersona1OcupacionSes(String persona1OcupacionSes) {
        this.persona1OcupacionSes = persona1OcupacionSes;
    }

    @Column(name = "persona_2_nombre_ses", length = 100)
    public String getPersona2NombreSes() {
        return persona2NombreSes;
    }

    public void setPersona2NombreSes(String persona2NombreSes) {
        this.persona2NombreSes = persona2NombreSes;
    }

    @Column(name = "persona_2_edad_ses", length = 25)
    public String getPersona2EdadSes() {
        return persona2EdadSes;
    }

    public void setPersona2EdadSes(String persona2EdadSes) {
        this.persona2EdadSes = persona2EdadSes;
    }

    @Column(name = "persona_2_grado_ses", length = 2)
    public String getPersona2GradoSes() {
        return persona2GradoSes;
    }

    public void setPersona2GradoSes(String persona2GradoSes) {
        this.persona2GradoSes = persona2GradoSes;
    }

    @Column(name = "persona_2_ocupacion_ses", length = 2)
    public String getPersona2OcupacionSes() {
        return persona2OcupacionSes;
    }

    public void setPersona2OcupacionSes(String persona2OcupacionSes) {
        this.persona2OcupacionSes = persona2OcupacionSes;
    }

    @Column(name = "persona_3_nombre_ses", length = 100)
    public String getPersona3NombreSes() {
        return persona3NombreSes;
    }

    public void setPersona3NombreSes(String persona3NombreSes) {
        this.persona3NombreSes = persona3NombreSes;
    }

    @Column(name = "persona_3_edad_ses", length = 25)
    public String getPersona3EdadSes() {
        return persona3EdadSes;
    }

    public void setPersona3EdadSes(String persona3EdadSes) {
        this.persona3EdadSes = persona3EdadSes;
    }

    @Column(name = "persona_3_grado_ses", length = 2)
    public String getPersona3GradoSes() {
        return persona3GradoSes;
    }

    public void setPersona3GradoSes(String persona3GradoSes) {
        this.persona3GradoSes = persona3GradoSes;
    }

    @Column(name = "persona_3_ocupacion_ses", length = 2)
    public String getPersona3OcupacionSes() {
        return persona3OcupacionSes;
    }

    public void setPersona3OcupacionSes(String persona3OcupacionSes) {
        this.persona3OcupacionSes = persona3OcupacionSes;
    }

    @Column(name = "persona_4_nombre_ses", length = 100)
    public String getPersona4NombreSes() {
        return persona4NombreSes;
    }

    public void setPersona4NombreSes(String persona4NombreSes) {
        this.persona4NombreSes = persona4NombreSes;
    }

    @Column(name = "persona_4_edad_ses", length = 25)
    public String getPersona4EdadSes() {
        return persona4EdadSes;
    }

    public void setPersona4EdadSes(String persona4EdadSes) {
        this.persona4EdadSes = persona4EdadSes;
    }

    @Column(name = "persona_4_grado_ses", length = 2)
    public String getPersona4GradoSes() {
        return persona4GradoSes;
    }

    public void setPersona4GradoSes(String persona4GradoSes) {
        this.persona4GradoSes = persona4GradoSes;
    }

    @Column(name = "persona_4_ocupacion_ses", length = 2)
    public String getPersona4OcupacionSes() {
        return persona4OcupacionSes;
    }

    public void setPersona4OcupacionSes(String persona4OcupacionSes) {
        this.persona4OcupacionSes = persona4OcupacionSes;
    }

    @Column(name = "persona_5_nombre_ses", length = 100)
    public String getPersona5NombreSes() {
        return persona5NombreSes;
    }

    public void setPersona5NombreSes(String persona5NombreSes) {
        this.persona5NombreSes = persona5NombreSes;
    }

    @Column(name = "persona_5_edad_ses", length = 25)
    public String getPersona5EdadSes() {
        return persona5EdadSes;
    }

    public void setPersona5EdadSes(String persona5EdadSes) {
        this.persona5EdadSes = persona5EdadSes;
    }

    @Column(name = "persona_5_grado_ses", length = 2)
    public String getPersona5GradoSes() {
        return persona5GradoSes;
    }

    public void setPersona5GradoSes(String persona5GradoSes) {
        this.persona5GradoSes = persona5GradoSes;
    }

    @Column(name = "persona_5_ocupacion_ses", length = 2)
    public String getPersona5OcupacionSes() {
        return persona5OcupacionSes;
    }

    public void setPersona5OcupacionSes(String persona5OcupacionSes) {
        this.persona5OcupacionSes = persona5OcupacionSes;
    }

    @Column(name = "persona_6_nombre_ses", length = 100)
    public String getPersona6NombreSes() {
        return persona6NombreSes;
    }

    public void setPersona6NombreSes(String persona6NombreSes) {
        this.persona6NombreSes = persona6NombreSes;
    }

    @Column(name = "persona_6_edad_ses", length = 25)
    public String getPersona6EdadSes() {
        return persona6EdadSes;
    }

    public void setPersona6EdadSes(String persona6EdadSes) {
        this.persona6EdadSes = persona6EdadSes;
    }

    @Column(name = "persona_6_grado_ses", length = 2)
    public String getPersona6GradoSes() {
        return persona6GradoSes;
    }

    public void setPersona6GradoSes(String persona6GradoSes) {
        this.persona6GradoSes = persona6GradoSes;
    }

    @Column(name = "persona_6_ocupacion_ses", length = 2)
    public String getPersona6OcupacionSes() {
        return persona6OcupacionSes;
    }

    public void setPersona6OcupacionSes(String persona6OcupacionSes) {
        this.persona6OcupacionSes = persona6OcupacionSes;
    }

    @Column(name = "persona_7_nombre_ses", length = 100)
    public String getPersona7NombreSes() {
        return persona7NombreSes;
    }

    public void setPersona7NombreSes(String persona7NombreSes) {
        this.persona7NombreSes = persona7NombreSes;
    }

    @Column(name = "persona_7_edad_ses", length = 25)
    public String getPersona7EdadSes() {
        return persona7EdadSes;
    }

    public void setPersona7EdadSes(String persona7EdadSes) {
        this.persona7EdadSes = persona7EdadSes;
    }

    @Column(name = "persona_7_grado_ses", length = 2)
    public String getPersona7GradoSes() {
        return persona7GradoSes;
    }

    public void setPersona7GradoSes(String persona7GradoSes) {
        this.persona7GradoSes = persona7GradoSes;
    }

    @Column(name = "persona_7_ocupacion_ses", length = 2)
    public String getPersona7OcupacionSes() {
        return persona7OcupacionSes;
    }

    public void setPersona7OcupacionSes(String persona7OcupacionSes) {
        this.persona7OcupacionSes = persona7OcupacionSes;
    }

    @Column(name = "persona_8_nombre_ses", length = 100)
    public String getPersona8NombreSes() {
        return persona8NombreSes;
    }

    public void setPersona8NombreSes(String persona8NombreSes) {
        this.persona8NombreSes = persona8NombreSes;
    }

    @Column(name = "persona_8_edad_ses", length = 25)
    public String getPersona8EdadSes() {
        return persona8EdadSes;
    }

    public void setPersona8EdadSes(String persona8EdadSes) {
        this.persona8EdadSes = persona8EdadSes;
    }

    @Column(name = "persona_8_grado_ses", length = 2)
    public String getPersona8GradoSes() {
        return persona8GradoSes;
    }

    public void setPersona8GradoSes(String persona8GradoSes) {
        this.persona8GradoSes = persona8GradoSes;
    }

    @Column(name = "persona_8_ocupacion_ses", length = 2)
    public String getPersona8OcupacionSes() {
        return persona8OcupacionSes;
    }

    public void setPersona8OcupacionSes(String persona8OcupacionSes) {
        this.persona8OcupacionSes = persona8OcupacionSes;
    }

    @Column(name = "nombre_encuestador_ses", length = 100)
    public String getNombreEncuestadorSes() {
        return nombreEncuestadorSes;
    }

    public void setNombreEncuestadorSes(String nombreEncuestadorSes) {
        this.nombreEncuestadorSes = nombreEncuestadorSes;
    }

    @Column(name = "preescolar_ses", nullable = false, length = 4)
    public String getPreescolarSes() {
        return preescolarSes;
    }

    public void setPreescolarSes(String preescolarSes) {
        this.preescolarSes = preescolarSes;
    }

    @Column(name = "cuando_preescolar_ses", length = 30)
    public String getCuandoPreescolarSes() {
        return cuandoPreescolarSes;
    }

    public void setCuandoPreescolarSes(String cuandoPreescolarSes) {
        this.cuandoPreescolarSes = cuandoPreescolarSes;
    }

    @Column(name = "ambos_padres_ses", nullable = false, length = 4)
    public String getAmbosPadresSes() {
        return ambosPadresSes;
    }

    public void setAmbosPadresSes(String ambosPadresSes) {
        this.ambosPadresSes = ambosPadresSes;
    }

    @Column(name = "pri", length = 2)
    public String getPri() {
        return pri;
    }

    public void setPri(String pri) {
        this.pri = pri;
    }

    @Column(name = "sec", length = 2)
    public String getSec() {
        return sec;
    }

    public void setSec(String sec) {
        this.sec = sec;
    }

    @Column(name = "third", length = 2)
    public String getThird() {
        return third;
    }

    public void setThird(String third) {
        this.third = third;
    }

    @Column(name = "sch_covid", length = 2)
    public String getSchCovid() {
        return schCovid;
    }

    public void setSchCovid(String schCovid) {
        this.schCovid = schCovid;
    }

    @Column(name = "primary_sch", length = 2)
    public String getPrimarySch() {
        return primarySch;
    }

    public void setPrimarySch(String primarySch) {
        this.primarySch = primarySch;
    }

    @Override
    public boolean isFieldAuditable(String fieldname) {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZpoV2CuestionarioSocioeconomico that = (ZpoV2CuestionarioSocioeconomico) o;

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
