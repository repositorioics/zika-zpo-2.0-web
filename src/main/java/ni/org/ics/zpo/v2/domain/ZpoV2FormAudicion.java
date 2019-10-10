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
@Table(name = "zpo_eval_auditiva", catalog = "zika_zpo_v2")
public class ZpoV2FormAudicion extends BaseMetaData implements Auditable {

    private String recordId;
    private String eventName;
    private Date fechaDeRealizacionDePr;
    private String haPadecidoDe;
    private String supuracionDeCualOido;
    private String sangradoDeCualOido;
    private String infeccionDeCualOido;
    private String haPadecidoDeAlgunaDeL;
    private String especifiqueOtra;
    private String haRecibidoTratamientoCo;
    private Integer paraTbEspecifiqueSemana;
    private String antecedentesFamiliaresDe;
    private String tipoDeSordera;
    private String haRecibidoTratamNino;
    private Integer paraTbNinoSemana;
    private String consideraQueSuNinoEscu;
    private String desdeHaceCuandoNotaQue;
    private String conductoAuditivoExterno;
    private String integridad;
    private String coloracion;
    private String contorno;
    private String movilidad;
    private String conductoAuditivoExtIzqu;
    private String integridadMembranaTimp;
    private String coloracionMembranaTimp;
    private String contornoMembranaTimp;
    private String movilidadMembranaTimp;
    private String odOas;
    private String oiOas;
    private String odPasa;
    private String oiPasa;
    private String resultadoDeOea;
    private String nombreDelMedicoEvaluado;

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

    @Column(name = "fecha_de_realizacion_de_pr", nullable = false)
    public Date getFechaDeRealizacionDePr() {
        return fechaDeRealizacionDePr;
    }

    public void setFechaDeRealizacionDePr(Date fechaDeRealizacionDePr) {
        this.fechaDeRealizacionDePr = fechaDeRealizacionDePr;
    }

    @Column(name = "ha_padecido_de", length = 1)
    public String getHaPadecidoDe() {
        return haPadecidoDe;
    }

    public void setHaPadecidoDe(String haPadecidoDe) {
        this.haPadecidoDe = haPadecidoDe;
    }

    @Column(name = "supuracion_de_cual_oido", length = 1)
    public String getSupuracionDeCualOido() {
        return supuracionDeCualOido;
    }

    public void setSupuracionDeCualOido(String supuracionDeCualOido) {
        this.supuracionDeCualOido = supuracionDeCualOido;
    }

    @Column(name = "sangrado_de_cual_oido", length = 1)
    public String getSangradoDeCualOido() {
        return sangradoDeCualOido;
    }

    public void setSangradoDeCualOido(String sangradoDeCualOido) {
        this.sangradoDeCualOido = sangradoDeCualOido;
    }

    @Column(name = "infeccion_de_cual_oido", length = 1)
    public String getInfeccionDeCualOido() {
        return infeccionDeCualOido;
    }

    public void setInfeccionDeCualOido(String infeccionDeCualOido) {
        this.infeccionDeCualOido = infeccionDeCualOido;
    }

    @Column(name = "ha_padecido_de_alguna_de_l", length = 1)
    public String getHaPadecidoDeAlgunaDeL() {
        return haPadecidoDeAlgunaDeL;
    }

    public void setHaPadecidoDeAlgunaDeL(String haPadecidoDeAlgunaDeL) {
        this.haPadecidoDeAlgunaDeL = haPadecidoDeAlgunaDeL;
    }

    @Column(name = "especifique_otra", length = 100)
    public String getEspecifiqueOtra() {
        return especifiqueOtra;
    }

    public void setEspecifiqueOtra(String especifiqueOtra) {
        this.especifiqueOtra = especifiqueOtra;
    }

    @Column(name = "ha_recibido_tratamiento_co", length = 1)
    public String getHaRecibidoTratamientoCo() {
        return haRecibidoTratamientoCo;
    }

    public void setHaRecibidoTratamientoCo(String haRecibidoTratamientoCo) {
        this.haRecibidoTratamientoCo = haRecibidoTratamientoCo;
    }

    @Column(name = "para_tb_especifique_semana")
    public Integer getParaTbEspecifiqueSemana() {
        return paraTbEspecifiqueSemana;
    }

    public void setParaTbEspecifiqueSemana(Integer paraTbEspecifiqueSemana) {
        this.paraTbEspecifiqueSemana = paraTbEspecifiqueSemana;
    }

    @Column(name = "antecedentes_familiares_de", length = 1)
    public String getAntecedentesFamiliaresDe() {
        return antecedentesFamiliaresDe;
    }

    public void setAntecedentesFamiliaresDe(String antecedentesFamiliaresDe) {
        this.antecedentesFamiliaresDe = antecedentesFamiliaresDe;
    }

    @Column(name = "tipo_de_sordera", length = 1)
    public String getTipoDeSordera() {
        return tipoDeSordera;
    }

    public void setTipoDeSordera(String tipoDeSordera) {
        this.tipoDeSordera = tipoDeSordera;
    }

    @Column(name = "ha_recibido_tratam_nino", length = 1)
    public String getHaRecibidoTratamNino() {
        return haRecibidoTratamNino;
    }

    public void setHaRecibidoTratamNino(String haRecibidoTratamNino) {
        this.haRecibidoTratamNino = haRecibidoTratamNino;
    }

    @Column(name = "para_tb_nino_semana")
    public Integer getParaTbNinoSemana() {
        return paraTbNinoSemana;
    }

    public void setParaTbNinoSemana(Integer paraTbNinoSemana) {
        this.paraTbNinoSemana = paraTbNinoSemana;
    }

    @Column(name = "considera_que_su_nino_escu", length = 1)
    public String getConsideraQueSuNinoEscu() {
        return consideraQueSuNinoEscu;
    }

    public void setConsideraQueSuNinoEscu(String consideraQueSuNinoEscu) {
        this.consideraQueSuNinoEscu = consideraQueSuNinoEscu;
    }

    @Column(name = "desde_hace_cuando_nota_que", length = 10)
    public String getDesdeHaceCuandoNotaQue() {
        return desdeHaceCuandoNotaQue;
    }

    public void setDesdeHaceCuandoNotaQue(String desdeHaceCuandoNotaQue) {
        this.desdeHaceCuandoNotaQue = desdeHaceCuandoNotaQue;
    }

    @Column(name = "conducto_auditivo_externo", length = 1)
    public String getConductoAuditivoExterno() {
        return conductoAuditivoExterno;
    }

    public void setConductoAuditivoExterno(String conductoAuditivoExterno) {
        this.conductoAuditivoExterno = conductoAuditivoExterno;
    }

    @Column(name = "integridad", length = 1)
    public String getIntegridad() {
        return integridad;
    }

    public void setIntegridad(String integridad) {
        this.integridad = integridad;
    }

    @Column(name = "coloracion", length = 1)
    public String getColoracion() {
        return coloracion;
    }

    public void setColoracion(String coloracion) {
        this.coloracion = coloracion;
    }

    @Column(name = "contorno", length = 1)
    public String getContorno() {
        return contorno;
    }

    public void setContorno(String contorno) {
        this.contorno = contorno;
    }

    @Column(name = "movilidad", length = 1)
    public String getMovilidad() {
        return movilidad;
    }

    public void setMovilidad(String movilidad) {
        this.movilidad = movilidad;
    }

    @Column(name = "conducto_auditivo_ext_izqu", length = 1)
    public String getConductoAuditivoExtIzqu() {
        return conductoAuditivoExtIzqu;
    }

    public void setConductoAuditivoExtIzqu(String conductoAuditivoExtIzqu) {
        this.conductoAuditivoExtIzqu = conductoAuditivoExtIzqu;
    }

    @Column(name = "integridad_membrana_timp", length = 1)
    public String getIntegridadMembranaTimp() {
        return integridadMembranaTimp;
    }

    public void setIntegridadMembranaTimp(String integridadMembranaTimp) {
        this.integridadMembranaTimp = integridadMembranaTimp;
    }

    @Column(name = "coloracion_membrana_timp", length = 1)
    public String getColoracionMembranaTimp() {
        return coloracionMembranaTimp;
    }

    public void setColoracionMembranaTimp(String coloracionMembranaTimp) {
        this.coloracionMembranaTimp = coloracionMembranaTimp;
    }

    @Column(name = "contorno_membrana_timp", length = 1)
    public String getContornoMembranaTimp() {
        return contornoMembranaTimp;
    }

    public void setContornoMembranaTimp(String contornoMembranaTimp) {
        this.contornoMembranaTimp = contornoMembranaTimp;
    }

    @Column(name = "movilidad_membrana_timp", length = 1)
    public String getMovilidadMembranaTimp() {
        return movilidadMembranaTimp;
    }

    public void setMovilidadMembranaTimp(String movilidadMembranaTimp) {
        this.movilidadMembranaTimp = movilidadMembranaTimp;
    }

    @Column(name = "od_oas", length = 1)
    public String getOdOas() {
        return odOas;
    }

    public void setOdOas(String odOas) {
        this.odOas = odOas;
    }

    @Column(name = "oi_oas", length = 1)
    public String getOiOas() {
        return oiOas;
    }

    public void setOiOas(String oiOas) {
        this.oiOas = oiOas;
    }

    @Column(name = "od_pasa", length = 1)
    public String getOdPasa() {
        return odPasa;
    }

    public void setOdPasa(String odPasa) {
        this.odPasa = odPasa;
    }

    @Column(name = "oi_pasa", length = 1)
    public String getOiPasa() {
        return oiPasa;
    }

    public void setOiPasa(String oiPasa) {
        this.oiPasa = oiPasa;
    }

    @Column(name = "resultado_de_oea", length = 1)
    public String getResultadoDeOea() {
        return resultadoDeOea;
    }

    public void setResultadoDeOea(String resultadoDeOea) {
        this.resultadoDeOea = resultadoDeOea;
    }

    @Column(name = "nombre_del_medico_evaluado", length = 100)
    public String getNombreDelMedicoEvaluado() {
        return nombreDelMedicoEvaluado;
    }

    public void setNombreDelMedicoEvaluado(String nombreDelMedicoEvaluado) {
        this.nombreDelMedicoEvaluado = nombreDelMedicoEvaluado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZpoV2FormAudicion that = (ZpoV2FormAudicion) o;

        if (!recordId.equals( that.recordId )) return false;
        return eventName.equals( that.eventName );
    }

    @Override
    public int hashCode() {
        int result = recordId.hashCode();
        result = 31 * result + eventName.hashCode();
        return result;
    }

    @Override
    public boolean isFieldAuditable(String fieldname) {
        return false;
    }

    @Override
    public String toString() {
        return "ZpoV2FormAudicion{" +
                "recordId='" + recordId + '\'' +
                ", eventName='" + eventName + '\'' +
                '}';
    }
}
