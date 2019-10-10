package ni.org.ics.zpo.v2.domain;

import ni.org.ics.zpo.v2.domain.audit.Auditable;

import javax.persistence.*;
import java.util.Date;

/**
 * @author ics
 */
@Entity
@Table(name = "zpo_eval_visual", catalog = "zika_zpo_v2")
public class ZpoV2EvaluacionVisual extends BaseMetaData implements Auditable {

    private String recordId;
    private String eventName;
    private Date fechaNacimientoOptho;
    private Integer edadOptho;
    private Date fechaExamenOpto;
    private String examinadorOptho;
    private String nombreOptho;
    private String codigoIdentiOptho;
    private String nombreMadreOptho;
    private String sexoOptho;
    private Integer edadGestacionalOptho;
    private Integer edadAjustadaOptho;
    private String historiaOcularOptho;
    private String microencefaliaOptho;
    private String microencefaliaQuienOptho;
    private String catarataCongenitaOptho;
    private String catarataQuienOptho;
    private String glaucomaCongenitaOptho;
    private String glaucomaQuienOptho;
    private String cegueraOptho;
    private String cegueraQuienOptho;
    private String myopiaOptho;
    private String myopiaQuienOptho;
    private String otrosAntecedentesOptho;
    private String cambioMiradaOptho;
    private String intentoAgarrarOptho;
    private String reaccionPalaOptho;
    private String contrasteHeidiOptho;
    private String distanciaContrasteOptho;
    private String otraDistanciaOptho;
    private String pioPalpacionOptho;
    private String motilidadOptho;
    private String alineacionOptho;
    private String pdOptho;
    private String metodoPdOptho;
    private String nistagmoOptho;
    private String tipoNystagmoOptho;
    private String ouOptho;
    private String odOptho;
    private String osOptho;
    private String incapazNivelJovenOptho;
    private String semanasOptho;
    private String meses3Optho;
    private String meses5Optho;
    private String meses7Optho;
    private String meses12Optho;
    private String leaGratingOptho;
    private String otraLeaDistanciaOptho;
    private String odCpcmOptho;
    private String osCpcmOptho;
    private String ouCpcmOptho;
    private String odCpdOptho;
    private String osCpdOptho;
    private String ouCpdOptho;
    private String reparaYSigueOptho;
    private String reaccionaLuzOptho;
    private String reflejoAcomodativoOptho;
    private String convergenciaOptho;
    private String miosisOptho;
    private String retinoscopiaOptho;
    private String examenOjosExtOptho;
    private String describaAnormalExtOptho;
    private String microftalmiaAnoftOptho;
    private String pupilasOptho;
    private String describaAnormlPupilOptho;
    private String examSegmentoAntOptho;
    private String describaSegmAntAnormOptho;
    private String pstosisOptho;
    private String irisColobomaOptho;
    private String lenteCatarataSubluOptho;
    private String otroLenteOptho;
    private String otroCualOjoOptho;
    private String dilatacionTiempoOptho;
    private String reflejoRojoOptho;
    private String crxOdOpthoSphere;
    private String opthoOdCyl;
    private String opthoOdAxis;
    private String crxOsOpthoSphere;
    private String opthoOsCyl;
    private String opthoOsAxis;
    private String vitreoOptho;
    private String describaAnormalOptho;
    private String nervioOpticoOptho;
    private String copaOpticoOptho;
    private String cDRatioOdOsOptho;
    private String atrofiaDelNervioOptho;
    private String nervioHipoplasiaOptho;
    private String colobomaNervioOptho;
    private String retinaOptho;
    private String moteadoPigmenFocalOptho;
    private String atrofiaCoriorretinalOptho;
    private String lesionColobomaOptho;
    private String lesionHipopigmentOptho;
    private String reflejoNovelaOptho;
    private String calcificIntracularOptho;
    private String vasosSanguineosOdOptho;
    private String vasosSanguineosOsOptho;
    private String cambiosPerivascOptho;
    private String funcionVisualOptho;
    private String refraccionApropiadoOptho;
    private String hallazgosOcularesOptho;
    private String hallazgosZikaOptho;
    private String seguimientoDoctorOptho;
    private String gafasOptho;
    private String intervencionOptho;
    private String seguimientoOftalOptho;
    private String entreComentariosOptho;

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

    @Basic
    @Column (name = "fecha_nacimiento_optho", nullable = false)
    public Date getFechaNacimientoOptho() {
        return fechaNacimientoOptho;
    }

    public void setFechaNacimientoOptho(Date fechaNacimientoOptho) {
        this.fechaNacimientoOptho = fechaNacimientoOptho;
    }

    @Column (name = "edad_optho", nullable = false)
    public Integer getEdadOptho() {
        return edadOptho;
    }

    public void setEdadOptho(Integer edadOptho) {
        this.edadOptho = edadOptho;
    }

    @Column (name = "fecha_examen_opto", nullable = false)
    public Date getFechaExamenOpto() {
        return fechaExamenOpto;
    }

    public void setFechaExamenOpto(Date fechaExamenOpto) {
        this.fechaExamenOpto = fechaExamenOpto;
    }

    @Column(name = "examinador_optho", length = 100)
    public String getExaminadorOptho() {
        return examinadorOptho;
    }

    public void setExaminadorOptho(String examinadorOptho) {
        this.examinadorOptho = examinadorOptho;
    }

    @Column(name = "nombre_optho", length = 100)
    public String getNombreOptho() {
        return nombreOptho;
    }

    public void setNombreOptho(String nombreOptho) {
        this.nombreOptho = nombreOptho;
    }

    @Column(name = "codigo_identi_optho", length = 50)
    public String getCodigoIdentiOptho() {
        return codigoIdentiOptho;
    }

    public void setCodigoIdentiOptho(String codigoIdentiOptho) {
        this.codigoIdentiOptho = codigoIdentiOptho;
    }

    @Column(name = "nombre_madre_optho", length = 100)
    public String getNombreMadreOptho() {
        return nombreMadreOptho;
    }

    public void setNombreMadreOptho(String nombreMadreOptho) {
        this.nombreMadreOptho = nombreMadreOptho;
    }

    @Column(name = "sexo_optho", length = 1)
    public String getSexoOptho() {
        return sexoOptho;
    }

    public void setSexoOptho(String sexoOptho) {
        this.sexoOptho = sexoOptho;
    }

    @Column(name = "edad_gestacional_optho")
    public Integer getEdadGestacionalOptho() {
        return edadGestacionalOptho;
    }

    public void setEdadGestacionalOptho(Integer edadGestacionalOptho) {
        this.edadGestacionalOptho = edadGestacionalOptho;
    }

    @Column(name = "edad_ajustada_optho")
    public Integer getEdadAjustadaOptho() {
        return edadAjustadaOptho;
    }

    public void setEdadAjustadaOptho(Integer edadAjustadaOptho) {
        this.edadAjustadaOptho = edadAjustadaOptho;
    }

    @Column(name = "historia_ocular_optho", length = 100)
    public String getHistoriaOcularOptho() {
        return historiaOcularOptho;
    }

    public void setHistoriaOcularOptho(String historiaOcularOptho) {
        this.historiaOcularOptho = historiaOcularOptho;
    }

    @Column(name = "microencefalia_optho", length = 1)
    public String getMicroencefaliaOptho() {
        return microencefaliaOptho;
    }

    public void setMicroencefaliaOptho(String microencefaliaOptho) {
        this.microencefaliaOptho = microencefaliaOptho;
    }

    @Column(name = "microencefalia_quien_optho", length = 100)
    public String getMicroencefaliaQuienOptho() {
        return microencefaliaQuienOptho;
    }

    public void setMicroencefaliaQuienOptho(String microencefaliaQuienOptho) {
        this.microencefaliaQuienOptho = microencefaliaQuienOptho;
    }

    @Column(name = "catarata_congenita_optho", length = 1)
    public String getCatarataCongenitaOptho() {
        return catarataCongenitaOptho;
    }

    public void setCatarataCongenitaOptho(String catarataCongenitaOptho) {
        this.catarataCongenitaOptho = catarataCongenitaOptho;
    }

    @Column(name = "catarata_quien_optho", length = 100)
    public String getCatarataQuienOptho() {
        return catarataQuienOptho;
    }

    public void setCatarataQuienOptho(String catarataQuienOptho) {
        this.catarataQuienOptho = catarataQuienOptho;
    }

    @Column(name = "glaucoma_congenita_optho", length = 1)
    public String getGlaucomaCongenitaOptho() {
        return glaucomaCongenitaOptho;
    }

    public void setGlaucomaCongenitaOptho(String glaucomaCongenitaOptho) {
        this.glaucomaCongenitaOptho = glaucomaCongenitaOptho;
    }

    @Column(name = "glaucoma_quien_optho", length = 100)
    public String getGlaucomaQuienOptho() {
        return glaucomaQuienOptho;
    }

    public void setGlaucomaQuienOptho(String glaucomaQuienOptho) {
        this.glaucomaQuienOptho = glaucomaQuienOptho;
    }

    @Column(name = "ceguera_optho", length = 1)
    public String getCegueraOptho() {
        return cegueraOptho;
    }

    public void setCegueraOptho(String cegueraOptho) {
        this.cegueraOptho = cegueraOptho;
    }

    @Column(name = "ceguera_quien_optho", length = 100)
    public String getCegueraQuienOptho() {
        return cegueraQuienOptho;
    }

    public void setCegueraQuienOptho(String cegueraQuienOptho) {
        this.cegueraQuienOptho = cegueraQuienOptho;
    }

    @Column(name = "myopia_optho", length = 1)
    public String getMyopiaOptho() {
        return myopiaOptho;
    }

    public void setMyopiaOptho(String myopiaOptho) {
        this.myopiaOptho = myopiaOptho;
    }

    @Column(name = "myopia_quien_optho", length = 100)
    public String getMyopiaQuienOptho() {
        return myopiaQuienOptho;
    }

    public void setMyopiaQuienOptho(String myopiaQuienOptho) {
        this.myopiaQuienOptho = myopiaQuienOptho;
    }

    @Column(name = "otros_antecedentes_optho", length = 100)
    public String getOtrosAntecedentesOptho() {
        return otrosAntecedentesOptho;
    }

    public void setOtrosAntecedentesOptho(String otrosAntecedentesOptho) {
        this.otrosAntecedentesOptho = otrosAntecedentesOptho;
    }

    @Column(name = "cambio_mirada_optho", length = 1)
    public String getCambioMiradaOptho() {
        return cambioMiradaOptho;
    }

    public void setCambioMiradaOptho(String cambioMiradaOptho) {
        this.cambioMiradaOptho = cambioMiradaOptho;
    }

    @Column(name = "intento_agarrar_optho", length = 1)
    public String getIntentoAgarrarOptho() {
        return intentoAgarrarOptho;
    }

    public void setIntentoAgarrarOptho(String intentoAgarrarOptho) {
        this.intentoAgarrarOptho = intentoAgarrarOptho;
    }

    @Column(name = "reaccion_pala_optho", length = 100)
    public String getReaccionPalaOptho() {
        return reaccionPalaOptho;
    }

    public void setReaccionPalaOptho(String reaccionPalaOptho) {
        this.reaccionPalaOptho = reaccionPalaOptho;
    }

    @Column(name = "contraste_heidi_optho", length = 1)
    public String getContrasteHeidiOptho() {
        return contrasteHeidiOptho;
    }

    public void setContrasteHeidiOptho(String contrasteHeidiOptho) {
        this.contrasteHeidiOptho = contrasteHeidiOptho;
    }

    @Column(name = "distancia_contraste_optho", length = 1)
    public String getDistanciaContrasteOptho() {
        return distanciaContrasteOptho;
    }

    public void setDistanciaContrasteOptho(String distanciaContrasteOptho) {
        this.distanciaContrasteOptho = distanciaContrasteOptho;
    }

    @Column(name = "otra_distancia_optho", length = 100)
    public String getOtraDistanciaOptho() {
        return otraDistanciaOptho;
    }

    public void setOtraDistanciaOptho(String otraDistanciaOptho) {
        this.otraDistanciaOptho = otraDistanciaOptho;
    }

    @Column(name = "pio_palpacion_optho", length = 1)
    public String getPioPalpacionOptho() {
        return pioPalpacionOptho;
    }

    public void setPioPalpacionOptho(String pioPalpacionOptho) {
        this.pioPalpacionOptho = pioPalpacionOptho;
    }

    @Column(name = "motilidad_optho", length = 1)
    public String getMotilidadOptho() {
        return motilidadOptho;
    }

    public void setMotilidadOptho(String motilidadOptho) {
        this.motilidadOptho = motilidadOptho;
    }

    @Column(name = "alineacion_optho", length = 1)
    public String getAlineacionOptho() {
        return alineacionOptho;
    }

    public void setAlineacionOptho(String alineacionOptho) {
        this.alineacionOptho = alineacionOptho;
    }

    @Column(name = "pd_optho", length = 100)
    public String getPdOptho() {
        return pdOptho;
    }

    public void setPdOptho(String pdOptho) {
        this.pdOptho = pdOptho;
    }

    @Column(name = "metodo_pd_optho", length = 1)
    public String getMetodoPdOptho() {
        return metodoPdOptho;
    }

    public void setMetodoPdOptho(String metodoPdOptho) {
        this.metodoPdOptho = metodoPdOptho;
    }

    @Column(name = "nistagmo_optho", length = 1)
    public String getNistagmoOptho() {
        return nistagmoOptho;
    }

    public void setNistagmoOptho(String nistagmoOptho) {
        this.nistagmoOptho = nistagmoOptho;
    }

    @Column(name = "tipo_nystagmo_optho", length = 100)
    public String getTipoNystagmoOptho() {
        return tipoNystagmoOptho;
    }

    public void setTipoNystagmoOptho(String tipoNystagmoOptho) {
        this.tipoNystagmoOptho = tipoNystagmoOptho;
    }

    @Column(name = "ou_optho", length = 1)
    public String getOuOptho() {
        return ouOptho;
    }

    public void setOuOptho(String ouOptho) {
        this.ouOptho = ouOptho;
    }

    @Column(name = "od_optho", length = 1)
    public String getOdOptho() {
        return odOptho;
    }

    public void setOdOptho(String odOptho) {
        this.odOptho = odOptho;
    }

    @Column(name = "os_optho", length = 1)
    public String getOsOptho() {
        return osOptho;
    }

    public void setOsOptho(String osOptho) {
        this.osOptho = osOptho;
    }

    @Column(name = "incapaz_nivel_joven_optho", length = 1)
    public String getIncapazNivelJovenOptho() {
        return incapazNivelJovenOptho;
    }

    public void setIncapazNivelJovenOptho(String incapazNivelJovenOptho) {
        this.incapazNivelJovenOptho = incapazNivelJovenOptho;
    }

    @Column(name = "semanas_optho", length = 1)
    public String getSemanasOptho() {
        return semanasOptho;
    }

    public void setSemanasOptho(String semanasOptho) {
        this.semanasOptho = semanasOptho;
    }

    @Column(name = "meses_3_optho", length = 1)
    public String getMeses3Optho() {
        return meses3Optho;
    }

    public void setMeses3Optho(String meses3Optho) {
        this.meses3Optho = meses3Optho;
    }

    @Column(name = "meses_5_optho", length = 1)
    public String getMeses5Optho() {
        return meses5Optho;
    }

    public void setMeses5Optho(String meses5Optho) {
        this.meses5Optho = meses5Optho;
    }

    @Column(name = "meses_7_optho", length = 1)
    public String getMeses7Optho() {
        return meses7Optho;
    }

    public void setMeses7Optho(String meses7Optho) {
        this.meses7Optho = meses7Optho;
    }

    @Column(name = "meses_12_optho", length = 1)
    public String getMeses12Optho() {
        return meses12Optho;
    }

    public void setMeses12Optho(String meses12Optho) {
        this.meses12Optho = meses12Optho;
    }

    @Column(name = "lea_grating_optho", length = 1)
    public String getLeaGratingOptho() {
        return leaGratingOptho;
    }

    public void setLeaGratingOptho(String leaGratingOptho) {
        this.leaGratingOptho = leaGratingOptho;
    }

    @Column(name = "otra_lea_distancia_optho", length = 10)
    public String getOtraLeaDistanciaOptho() {
        return otraLeaDistanciaOptho;
    }

    public void setOtraLeaDistanciaOptho(String otraLeaDistanciaOptho) {
        this.otraLeaDistanciaOptho = otraLeaDistanciaOptho;
    }

    @Column(name = "od_cpcm_optho", length = 50)
    public String getOdCpcmOptho() {
        return odCpcmOptho;
    }

    public void setOdCpcmOptho(String odCpcmOptho) {
        this.odCpcmOptho = odCpcmOptho;
    }

    @Column(name = "os_cpcm_optho", length = 50)
    public String getOsCpcmOptho() {
        return osCpcmOptho;
    }

    public void setOsCpcmOptho(String osCpcmOptho) {
        this.osCpcmOptho = osCpcmOptho;
    }

    @Column(name = "ou_cpcm_optho", length = 50)
    public String getOuCpcmOptho() {
        return ouCpcmOptho;
    }

    public void setOuCpcmOptho(String ouCpcmOptho) {
        this.ouCpcmOptho = ouCpcmOptho;
    }

    @Column(name = "od_cpd_optho", length = 50)
    public String getOdCpdOptho() {
        return odCpdOptho;
    }

    public void setOdCpdOptho(String odCpdOptho) {
        this.odCpdOptho = odCpdOptho;
    }

    @Column(name = "os_cpd_optho", length = 50)
    public String getOsCpdOptho() {
        return osCpdOptho;
    }

    public void setOsCpdOptho(String osCpdOptho) {
        this.osCpdOptho = osCpdOptho;
    }

    @Column(name = "ou_cpd_optho", length = 50)
    public String getOuCpdOptho() {
        return ouCpdOptho;
    }

    public void setOuCpdOptho(String ouCpdOptho) {
        this.ouCpdOptho = ouCpdOptho;
    }

    @Column(name = "repara_y_sigue_optho", length = 1)
    public String getReparaYSigueOptho() {
        return reparaYSigueOptho;
    }

    public void setReparaYSigueOptho(String reparaYSigueOptho) {
        this.reparaYSigueOptho = reparaYSigueOptho;
    }

    @Column(name = "reacciona_luz_optho", length = 1)
    public String getReaccionaLuzOptho() {
        return reaccionaLuzOptho;
    }

    public void setReaccionaLuzOptho(String reaccionaLuzOptho) {
        this.reaccionaLuzOptho = reaccionaLuzOptho;
    }

    @Column(name = "reflejo_acomodativo_optho", length = 1)
    public String getReflejoAcomodativoOptho() {
        return reflejoAcomodativoOptho;
    }

    public void setReflejoAcomodativoOptho(String reflejoAcomodativoOptho) {
        this.reflejoAcomodativoOptho = reflejoAcomodativoOptho;
    }

    @Column(name = "convergencia_optho", length = 1)
    public String getConvergenciaOptho() {
        return convergenciaOptho;
    }

    public void setConvergenciaOptho(String convergenciaOptho) {
        this.convergenciaOptho = convergenciaOptho;
    }

    @Column(name = "miosis_optho", length = 1)
    public String getMiosisOptho() {
        return miosisOptho;
    }

    public void setMiosisOptho(String miosisOptho) {
        this.miosisOptho = miosisOptho;
    }

    @Column(name = "retinoscopia_optho", length = 1)
    public String getRetinoscopiaOptho() {
        return retinoscopiaOptho;
    }

    public void setRetinoscopiaOptho(String retinoscopiaOptho) {
        this.retinoscopiaOptho = retinoscopiaOptho;
    }

    @Column(name = "examen_ojos_ext_optho", length = 1)
    public String getExamenOjosExtOptho() {
        return examenOjosExtOptho;
    }

    public void setExamenOjosExtOptho(String examenOjosExtOptho) {
        this.examenOjosExtOptho = examenOjosExtOptho;
    }

    @Column(name = "describa_anormal_ext_optho", length = 100)
    public String getDescribaAnormalExtOptho() {
        return describaAnormalExtOptho;
    }

    public void setDescribaAnormalExtOptho(String describaAnormalExtOptho) {
        this.describaAnormalExtOptho = describaAnormalExtOptho;
    }

    @Column(name = "microftalmia_anoft_optho", length = 1)
    public String getMicroftalmiaAnoftOptho() {
        return microftalmiaAnoftOptho;
    }

    public void setMicroftalmiaAnoftOptho(String microftalmiaAnoftOptho) {
        this.microftalmiaAnoftOptho = microftalmiaAnoftOptho;
    }

    @Column(name = "pupilas_optho", length = 1)
    public String getPupilasOptho() {
        return pupilasOptho;
    }

    public void setPupilasOptho(String pupilasOptho) {
        this.pupilasOptho = pupilasOptho;
    }

    @Column(name = "describa_anorml_pupil_optho", length = 100)
    public String getDescribaAnormlPupilOptho() {
        return describaAnormlPupilOptho;
    }

    public void setDescribaAnormlPupilOptho(String describaAnormlPupilOptho) {
        this.describaAnormlPupilOptho = describaAnormlPupilOptho;
    }

    @Column(name = "exam_segmento_ant_optho", length = 1)
    public String getExamSegmentoAntOptho() {
        return examSegmentoAntOptho;
    }

    public void setExamSegmentoAntOptho(String examSegmentoAntOptho) {
        this.examSegmentoAntOptho = examSegmentoAntOptho;
    }

    @Column(name = "describa_segm_ant_anorm_optho", length = 1)
    public String getDescribaSegmAntAnormOptho() {
        return describaSegmAntAnormOptho;
    }

    public void setDescribaSegmAntAnormOptho(String describaSegmAntAnormOptho) {
        this.describaSegmAntAnormOptho = describaSegmAntAnormOptho;
    }

    @Column(name = "pstosis_optho", length = 1)
    public String getPstosisOptho() {
        return pstosisOptho;
    }

    public void setPstosisOptho(String pstosisOptho) {
        this.pstosisOptho = pstosisOptho;
    }

    @Column(name = "iris_coloboma_optho", length = 1)
    public String getIrisColobomaOptho() {
        return irisColobomaOptho;
    }

    public void setIrisColobomaOptho(String irisColobomaOptho) {
        this.irisColobomaOptho = irisColobomaOptho;
    }

    @Column(name = "lente_catarata_sublu_optho", length = 1)
    public String getLenteCatarataSubluOptho() {
        return lenteCatarataSubluOptho;
    }

    public void setLenteCatarataSubluOptho(String lenteCatarataSubluOptho) {
        this.lenteCatarataSubluOptho = lenteCatarataSubluOptho;
    }

    @Column(name = "otro_lente_optho", length = 100)
    public String getOtroLenteOptho() {
        return otroLenteOptho;
    }

    public void setOtroLenteOptho(String otroLenteOptho) {
        this.otroLenteOptho = otroLenteOptho;
    }

    @Column(name = "otro_cual_ojo_optho", length = 1)
    public String getOtroCualOjoOptho() {
        return otroCualOjoOptho;
    }

    public void setOtroCualOjoOptho(String otroCualOjoOptho) {
        this.otroCualOjoOptho = otroCualOjoOptho;
    }

    @Column(name = "dilatacion_tiempo_optho", length = 50)
    public String getDilatacionTiempoOptho() {
        return dilatacionTiempoOptho;
    }

    public void setDilatacionTiempoOptho(String dilatacionTiempoOptho) {
        this.dilatacionTiempoOptho = dilatacionTiempoOptho;
    }

    @Column(name = "reflejo_rojo_optho", length = 1)
    public String getReflejoRojoOptho() {
        return reflejoRojoOptho;
    }

    public void setReflejoRojoOptho(String reflejoRojoOptho) {
        this.reflejoRojoOptho = reflejoRojoOptho;
    }

    @Column(name = "crx_od_optho_sphere", length = 100)
    public String getCrxOdOpthoSphere() {
        return crxOdOpthoSphere;
    }

    public void setCrxOdOpthoSphere(String crxOdOpthoSphere) {
        this.crxOdOpthoSphere = crxOdOpthoSphere;
    }

    @Column(name = "optho_od_cyl", length = 100)
    public String getOpthoOdCyl() {
        return opthoOdCyl;
    }

    public void setOpthoOdCyl(String opthoOdCyl) {
        this.opthoOdCyl = opthoOdCyl;
    }

    @Column(name = "optho_od_axis", length = 100)
    public String getOpthoOdAxis() {
        return opthoOdAxis;
    }

    public void setOpthoOdAxis(String opthoOdAxis) {
        this.opthoOdAxis = opthoOdAxis;
    }

    @Column(name = "crx_os_optho_sphere", length = 100)
    public String getCrxOsOpthoSphere() {
        return crxOsOpthoSphere;
    }

    public void setCrxOsOpthoSphere(String crxOsOpthoSphere) {
        this.crxOsOpthoSphere = crxOsOpthoSphere;
    }

    @Column(name = "optho_os_cyl", length = 100)
    public String getOpthoOsCyl() {
        return opthoOsCyl;
    }

    public void setOpthoOsCyl(String opthoOsCyl) {
        this.opthoOsCyl = opthoOsCyl;
    }

    @Column(name = "optho_os_axis", length = 100)
    public String getOpthoOsAxis() {
        return opthoOsAxis;
    }

    public void setOpthoOsAxis(String opthoOsAxis) {
        this.opthoOsAxis = opthoOsAxis;
    }

    @Column(name = "vitreo_optho", length = 1)
    public String getVitreoOptho() {
        return vitreoOptho;
    }

    public void setVitreoOptho(String vitreoOptho) {
        this.vitreoOptho = vitreoOptho;
    }

    @Column(name = "describa_anormal_optho", length = 100)
    public String getDescribaAnormalOptho() {
        return describaAnormalOptho;
    }

    public void setDescribaAnormalOptho(String describaAnormalOptho) {
        this.describaAnormalOptho = describaAnormalOptho;
    }

    @Column(name = "nervio_optico_optho", length = 1)
    public String getNervioOpticoOptho() {
        return nervioOpticoOptho;
    }

    public void setNervioOpticoOptho(String nervioOpticoOptho) {
        this.nervioOpticoOptho = nervioOpticoOptho;
    }

    @Column(name = "copa_optico_optho", length = 1)
    public String getCopaOpticoOptho() {
        return copaOpticoOptho;
    }

    public void setCopaOpticoOptho(String copaOpticoOptho) {
        this.copaOpticoOptho = copaOpticoOptho;
    }

    @Column(name = "c_d_ratio_od_os_optho", length = 50)
    public String getcDRatioOdOsOptho() {
        return cDRatioOdOsOptho;
    }

    public void setcDRatioOdOsOptho(String cDRatioOdOsOptho) {
        this.cDRatioOdOsOptho = cDRatioOdOsOptho;
    }

    @Column(name = "atrofia_del_nervio_optho", length = 1)
    public String getAtrofiaDelNervioOptho() {
        return atrofiaDelNervioOptho;
    }

    public void setAtrofiaDelNervioOptho(String atrofiaDelNervioOptho) {
        this.atrofiaDelNervioOptho = atrofiaDelNervioOptho;
    }

    @Column(name = "nervio_hipoplasia_optho", length = 1)
    public String getNervioHipoplasiaOptho() {
        return nervioHipoplasiaOptho;
    }

    public void setNervioHipoplasiaOptho(String nervioHipoplasiaOptho) {
        this.nervioHipoplasiaOptho = nervioHipoplasiaOptho;
    }

    @Column(name = "coloboma_nervio_optho", length = 1)
    public String getColobomaNervioOptho() {
        return colobomaNervioOptho;
    }

    public void setColobomaNervioOptho(String colobomaNervioOptho) {
        this.colobomaNervioOptho = colobomaNervioOptho;
    }

    @Column(name = "retina_optho", length = 1)
    public String getRetinaOptho() {
        return retinaOptho;
    }

    public void setRetinaOptho(String retinaOptho) {
        this.retinaOptho = retinaOptho;
    }

    @Column(name = "moteado_pigmen_focal_optho", length = 1)
    public String getMoteadoPigmenFocalOptho() {
        return moteadoPigmenFocalOptho;
    }

    public void setMoteadoPigmenFocalOptho(String moteadoPigmenFocalOptho) {
        this.moteadoPigmenFocalOptho = moteadoPigmenFocalOptho;
    }

    @Column(name = "atrofia_coriorretinal_optho", length = 1)
    public String getAtrofiaCoriorretinalOptho() {
        return atrofiaCoriorretinalOptho;
    }

    public void setAtrofiaCoriorretinalOptho(String atrofiaCoriorretinalOptho) {
        this.atrofiaCoriorretinalOptho = atrofiaCoriorretinalOptho;
    }

    @Column(name = "lesion_coloboma_optho", length = 1)
    public String getLesionColobomaOptho() {
        return lesionColobomaOptho;
    }

    public void setLesionColobomaOptho(String lesionColobomaOptho) {
        this.lesionColobomaOptho = lesionColobomaOptho;
    }

    @Column(name = "lesion_hipopigment_optho", length = 1)
    public String getLesionHipopigmentOptho() {
        return lesionHipopigmentOptho;
    }

    public void setLesionHipopigmentOptho(String lesionHipopigmentOptho) {
        this.lesionHipopigmentOptho = lesionHipopigmentOptho;
    }

    @Column(name = "reflejo_novela_optho", length = 1)
    public String getReflejoNovelaOptho() {
        return reflejoNovelaOptho;
    }

    public void setReflejoNovelaOptho(String reflejoNovelaOptho) {
        this.reflejoNovelaOptho = reflejoNovelaOptho;
    }

    @Column(name = "calcific_intracular_optho", length = 1)
    public String getCalcificIntracularOptho() {
        return calcificIntracularOptho;
    }

    public void setCalcificIntracularOptho(String calcificIntracularOptho) {
        this.calcificIntracularOptho = calcificIntracularOptho;
    }

    @Column(name = "vasos_sanguineos_od_optho", length = 1)
    public String getVasosSanguineosOdOptho() {
        return vasosSanguineosOdOptho;
    }

    public void setVasosSanguineosOdOptho(String vasosSanguineosOdOptho) {
        this.vasosSanguineosOdOptho = vasosSanguineosOdOptho;
    }

    @Column(name = "vasos_sanguineos_os_optho", length = 1)
    public String getVasosSanguineosOsOptho() {
        return vasosSanguineosOsOptho;
    }

    public void setVasosSanguineosOsOptho(String vasosSanguineosOsOptho) {
        this.vasosSanguineosOsOptho = vasosSanguineosOsOptho;
    }

    @Column(name = "cambios_perivasc_optho", length = 1)
    public String getCambiosPerivascOptho() {
        return cambiosPerivascOptho;
    }

    public void setCambiosPerivascOptho(String cambiosPerivascOptho) {
        this.cambiosPerivascOptho = cambiosPerivascOptho;
    }

    @Column(name = "funcion_visual_optho", length = 1)
    public String getFuncionVisualOptho() {
        return funcionVisualOptho;
    }

    public void setFuncionVisualOptho(String funcionVisualOptho) {
        this.funcionVisualOptho = funcionVisualOptho;
    }

    @Column(name = "refraccion_apropiado_optho", length = 1)
    public String getRefraccionApropiadoOptho() {
        return refraccionApropiadoOptho;
    }

    public void setRefraccionApropiadoOptho(String refraccionApropiadoOptho) {
        this.refraccionApropiadoOptho = refraccionApropiadoOptho;
    }

    @Column(name = "hallazgos_oculares_optho", length = 1)
    public String getHallazgosOcularesOptho() {
        return hallazgosOcularesOptho;
    }

    public void setHallazgosOcularesOptho(String hallazgosOcularesOptho) {
        this.hallazgosOcularesOptho = hallazgosOcularesOptho;
    }

    @Column(name = "hallazgos_zika_optho", length = 1)
    public String getHallazgosZikaOptho() {
        return hallazgosZikaOptho;
    }

    public void setHallazgosZikaOptho(String hallazgosZikaOptho) {
        this.hallazgosZikaOptho = hallazgosZikaOptho;
    }

    @Column(name = "seguimiento_doctor_optho", length = 1)
    public String getSeguimientoDoctorOptho() {
        return seguimientoDoctorOptho;
    }

    public void setSeguimientoDoctorOptho(String seguimientoDoctorOptho) {
        this.seguimientoDoctorOptho = seguimientoDoctorOptho;
    }

    @Column(name = "gafas_optho", length = 1)
    public String getGafasOptho() {
        return gafasOptho;
    }

    public void setGafasOptho(String gafasOptho) {
        this.gafasOptho = gafasOptho;
    }

    @Column(name = "intervencion_optho", length = 1)
    public String getIntervencionOptho() {
        return intervencionOptho;
    }

    public void setIntervencionOptho(String intervencionOptho) {
        this.intervencionOptho = intervencionOptho;
    }

    @Column(name = "seguimiento_oftal_optho", length = 1)
    public String getSeguimientoOftalOptho() {
        return seguimientoOftalOptho;
    }

    public void setSeguimientoOftalOptho(String seguimientoOftalOptho) {
        this.seguimientoOftalOptho = seguimientoOftalOptho;
    }

    @Column(name = "entre_comentarios_optho", length = 100)
    public String getEntreComentariosOptho() {
        return entreComentariosOptho;
    }

    public void setEntreComentariosOptho(String entreComentariosOptho) {
        this.entreComentariosOptho = entreComentariosOptho;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZpoV2EvaluacionVisual that = (ZpoV2EvaluacionVisual) o;

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
    public String toString() {
        return "ZpoV2EvaluacionVisual{" +
                "recordId='" + recordId + '\'' +
                ", eventName='" + eventName + '\'' +
                '}';
    }

    @Override
    public boolean isFieldAuditable(String fieldname) {
        return false;
    }
}
