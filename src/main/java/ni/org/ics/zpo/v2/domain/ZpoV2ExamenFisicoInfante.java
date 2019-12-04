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
@Table(name = "zpo_examen_fisico_infante", catalog = "zika_zpo_v2")
public class ZpoV2ExamenFisicoInfante extends BaseMetaData implements Auditable {

    private String recordId;
    private String eventName;
    private Date childExamFecha;
    private Integer childExamAge;
    private Float childExamPeso;
    private Float childExamHeight;
    private Float childExamCircumference;
    private String childExamScarring;
    private String childExamAbdominalDist;
    private String childExamAbnormalExam;
    private String childExamDescribeAnomaly;
    private String childExamBloodSample;
    private Float childExamVolume;
    private String childExamIrritability;
    private String childExamLethary;
    private String childExamSeizures;
    private String childExamApnea;
    private String childExamLowTone;
    private String childExamAssymetry;
    private String childExamProbEyeMovt;
    private String childExamPromMovement;
    private String childExamDysphagia;
    private String childExamContCrying;
    private String childExamArthrogryposis;
    private String childExamHypertonia;
    private String childExamHypotonia;
    private String childExamOae;
    private String childExamCircumFailed;
    private String childExamCircumstanceDes;
    private String childExamCircumstances;
    private String childExamOphthalmology;
    private String childExamOpthoFiding;
    private String childExamLeftEyeFinds;
    private String childExamRightEyeFinds;
    private String childExamReferral;
    private String childExamReferralType;
    private String childExamPersonal;

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

    @Column(name = "child_exam_fecha", nullable = false)
    public Date getChildExamFecha() {
        return childExamFecha;
    }

    public void setChildExamFecha(Date childExamFecha) {
        this.childExamFecha = childExamFecha;
    }

    @Column(name = "child_exam_age", nullable = false)
    public Integer getChildExamAge() {
        return childExamAge;
    }

    public void setChildExamAge(Integer childExamAge) {
        this.childExamAge = childExamAge;
    }

    @Column(name = "child_exam_peso")
    public Float getChildExamPeso() {
        return childExamPeso;
    }

    public void setChildExamPeso(Float childExamPeso) {
        this.childExamPeso = childExamPeso;
    }

    @Column(name = "child_exam_height")
    public Float getChildExamHeight() {
        return childExamHeight;
    }

    public void setChildExamHeight(Float childExamHeight) {
        this.childExamHeight = childExamHeight;
    }

    @Column(name = "child_exam_circumference")
    public Float getChildExamCircumference() {
        return childExamCircumference;
    }

    public void setChildExamCircumference(Float childExamCircumference) {
        this.childExamCircumference = childExamCircumference;
    }

    @Column(name = "child_exam_scarring", length = 1)
    public String getChildExamScarring() {
        return childExamScarring;
    }

    public void setChildExamScarring(String childExamScarring) {
        this.childExamScarring = childExamScarring;
    }

    @Column(name = "child_exam_abdominal_dist", length = 1)
    public String getChildExamAbdominalDist() {
        return childExamAbdominalDist;
    }

    public void setChildExamAbdominalDist(String childExamAbdominalDist) {
        this.childExamAbdominalDist = childExamAbdominalDist;
    }

    @Column(name = "child_exam_abnormal_exam", length = 1)
    public String getChildExamAbnormalExam() {
        return childExamAbnormalExam;
    }

    public void setChildExamAbnormalExam(String childExamAbnormalExam) {
        this.childExamAbnormalExam = childExamAbnormalExam;
    }

    @Column(name = "child_exam_describe_anomaly", length = 100)
    public String getChildExamDescribeAnomaly() {
        return childExamDescribeAnomaly;
    }

    public void setChildExamDescribeAnomaly(String childExamDescribeAnomaly) {
        this.childExamDescribeAnomaly = childExamDescribeAnomaly;
    }

    @Column(name = "child_exam_blood_sample", length = 1)
    public String getChildExamBloodSample() {
        return childExamBloodSample;
    }

    public void setChildExamBloodSample(String childExamBloodSample) {
        this.childExamBloodSample = childExamBloodSample;
    }

    @Column(name = "child_exam_volume")
    public Float getChildExamVolume() {
        return childExamVolume;
    }

    public void setChildExamVolume(Float childExamVolume) {
        this.childExamVolume = childExamVolume;
    }

    @Column(name = "child_exam_irritability", length = 1)
    public String getChildExamIrritability() {
        return childExamIrritability;
    }

    public void setChildExamIrritability(String childExamIrritability) {
        this.childExamIrritability = childExamIrritability;
    }

    @Column(name = "child_exam_lethary", length = 1)
    public String getChildExamLethary() {
        return childExamLethary;
    }

    public void setChildExamLethary(String childExamLethary) {
        this.childExamLethary = childExamLethary;
    }

    @Column(name = "child_exam_seizures", length = 1)
    public String getChildExamSeizures() {
        return childExamSeizures;
    }

    public void setChildExamSeizures(String childExamSeizures) {
        this.childExamSeizures = childExamSeizures;
    }

    @Column(name = "child_exam_apnea", length = 1)
    public String getChildExamApnea() {
        return childExamApnea;
    }

    public void setChildExamApnea(String childExamApnea) {
        this.childExamApnea = childExamApnea;
    }

    @Column(name = "child_exam_low_tone", length = 1)
    public String getChildExamLowTone() {
        return childExamLowTone;
    }

    public void setChildExamLowTone(String childExamLowTone) {
        this.childExamLowTone = childExamLowTone;
    }

    @Column(name = "child_exam_assymetry", length = 1)
    public String getChildExamAssymetry() {
        return childExamAssymetry;
    }

    public void setChildExamAssymetry(String childExamAssymetry) {
        this.childExamAssymetry = childExamAssymetry;
    }

    @Column(name = "child_exam_prob_eye_movt", length = 1)
    public String getChildExamProbEyeMovt() {
        return childExamProbEyeMovt;
    }

    public void setChildExamProbEyeMovt(String childExamProbEyeMovt) {
        this.childExamProbEyeMovt = childExamProbEyeMovt;
    }

    @Column(name = "child_exam_prom_movement", length = 1)
    public String getChildExamPromMovement() {
        return childExamPromMovement;
    }

    public void setChildExamPromMovement(String childExamPromMovement) {
        this.childExamPromMovement = childExamPromMovement;
    }

    @Column(name = "child_exam_dysphagia", length = 1)
    public String getChildExamDysphagia() {
        return childExamDysphagia;
    }

    public void setChildExamDysphagia(String childExamDysphagia) {
        this.childExamDysphagia = childExamDysphagia;
    }

    @Column(name = "child_exam_cont_crying", length = 1)
    public String getChildExamContCrying() {
        return childExamContCrying;
    }

    public void setChildExamContCrying(String childExamContCrying) {
        this.childExamContCrying = childExamContCrying;
    }

    @Column(name = "child_exam_arthrogryposis", length = 1)
    public String getChildExamArthrogryposis() {
        return childExamArthrogryposis;
    }

    public void setChildExamArthrogryposis(String childExamArthrogryposis) {
        this.childExamArthrogryposis = childExamArthrogryposis;
    }

    @Column(name = "child_exam_hypertonia", length = 1)
    public String getChildExamHypertonia() {
        return childExamHypertonia;
    }

    public void setChildExamHypertonia(String childExamHypertonia) {
        this.childExamHypertonia = childExamHypertonia;
    }

    @Column(name = "child_exam_hypotonia", length = 1)
    public String getChildExamHypotonia() {
        return childExamHypotonia;
    }

    public void setChildExamHypotonia(String childExamHypotonia) {
        this.childExamHypotonia = childExamHypotonia;
    }

    @Column(name = "child_exam_oae", length = 1)
    public String getChildExamOae() {
        return childExamOae;
    }

    public void setChildExamOae(String childExamOae) {
        this.childExamOae = childExamOae;
    }

    @Column(name = "child_exam_circum_failed", length = 1)
    public String getChildExamCircumFailed() {
        return childExamCircumFailed;
    }

    public void setChildExamCircumFailed(String childExamCircumFailed) {
        this.childExamCircumFailed = childExamCircumFailed;
    }

    @Column(name = "child_exam_circumstance_des", length = 100)
    public String getChildExamCircumstanceDes() {
        return childExamCircumstanceDes;
    }

    public void setChildExamCircumstanceDes(String childExamCircumstanceDes) {
        this.childExamCircumstanceDes = childExamCircumstanceDes;
    }

    @Column(name = "child_exam_circumstances", length = 1)
    public String getChildExamCircumstances() {
        return childExamCircumstances;
    }

    public void setChildExamCircumstances(String childExamCircumstances) {
        this.childExamCircumstances = childExamCircumstances;
    }

    @Column(name = "child_exam_ophthalmology", length = 1)
    public String getChildExamOphthalmology() {
        return childExamOphthalmology;
    }

    public void setChildExamOphthalmology(String childExamOphthalmology) {
        this.childExamOphthalmology = childExamOphthalmology;
    }

    @Column(name = "child_exam_optho_fiding", length = 1)
    public String getChildExamOpthoFiding() {
        return childExamOpthoFiding;
    }

    public void setChildExamOpthoFiding(String childExamOpthoFiding) {
        this.childExamOpthoFiding = childExamOpthoFiding;
    }

    @Column(name = "child_exam_left_eye_finds", length = 100)
    public String getChildExamLeftEyeFinds() {
        return childExamLeftEyeFinds;
    }

    public void setChildExamLeftEyeFinds(String childExamLeftEyeFinds) {
        this.childExamLeftEyeFinds = childExamLeftEyeFinds;
    }

    @Column(name = "child_exam_right_eye_finds", length = 100)
    public String getChildExamRightEyeFinds() {
        return childExamRightEyeFinds;
    }

    public void setChildExamRightEyeFinds(String childExamRightEyeFinds) {
        this.childExamRightEyeFinds = childExamRightEyeFinds;
    }

    @Column(name = "child_exam_referral", length = 2)
    public String getChildExamReferral() {
        return childExamReferral;
    }

    public void setChildExamReferral(String childExamReferral) {
        this.childExamReferral = childExamReferral;
    }

    @Column(name = "child_exam_referral_type", length = 100)
    public String getChildExamReferralType() {
        return childExamReferralType;
    }

    public void setChildExamReferralType(String childExamReferralType) {
        this.childExamReferralType = childExamReferralType;
    }

    @Column(name = "child_exam_personal", length = 100)
    public String getChildExamPersonal() {
        return childExamPersonal;
    }

    public void setChildExamPersonal(String childExamPersonal) {
        this.childExamPersonal = childExamPersonal;
    }

    @Override
    public boolean isFieldAuditable(String fieldname) {
        return false;
    }

    @Override
    public String toString() {
        return "ZpoV2ExamenFisicoInfante{" +
                "recordId='" + recordId + '\'' +
                ", eventName='" + eventName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZpoV2ExamenFisicoInfante that = (ZpoV2ExamenFisicoInfante) o;

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
