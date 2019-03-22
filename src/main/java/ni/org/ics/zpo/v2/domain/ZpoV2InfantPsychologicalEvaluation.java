package ni.org.ics.zpo.v2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by FIRSTICT on 22/03/2019
 * V1.0
 */
@Entity
@Table(name = "zpo_infant_psychologic_eval", catalog = "zika_zpo_v2")
public class ZpoV2InfantPsychologicalEvaluation extends BaseMetaData{

    private static final long serialVersionUID = 1L;
    private String recordId;
    private String eventName;
    private Date infantVisitDate;
    private String infantStatus;
    private Date infantDeathDt;
    private String infantVisit;
    private String infantEvaluation;
    private String infantNeuroAsq;
    private Float infantAsqCommuni;
    private Float infantAsqGross;
    private Float infantAsqFine;
    private Float infantAsqProblem;
    private Float infantAsqPersonal;
    private String infantNeuroBisd;
    private Float infantCgScore;
    private String infantCgRisk;
    private Float infantRpScore;
    private String infantRpRisk;
    private Float infantEpScore;
    private String infantEpRisk;
    private Float infantFmScore;
    private String infantFmRisk;
    private Float infantGmScore;
    private String infantGmRisk;
    private String infantNeuroOther;
    private String infantOtherName;
    private Float infantOtherScore;
    private String infantResultScreening;
    private String infantReferTesting;
    private String infantCommentsYn;
    private String infantComments;

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

    @Column(name = "infant_visit_date3", length = 1)
    public Date getInfantVisitDate() {
        return infantVisitDate;
    }

    public void setInfantVisitDate(Date infantVisitDate3) {
        this.infantVisitDate = infantVisitDate3;
    }

    @Column(name = "infant_status3", length = 1)
    public String getInfantStatus() {
        return infantStatus;
    }

    public void setInfantStatus(String infantStatus3) {
        this.infantStatus = infantStatus3;
    }

    @Column(name = "infant_death_dt3")
    public Date getInfantDeathDt() {
        return infantDeathDt;
    }

    public void setInfantDeathDt(Date infantDeathDt3) {
        this.infantDeathDt = infantDeathDt3;
    }

    @Column(name = "infant_visit3", length = 1)
    public String getInfantVisit() {
        return infantVisit;
    }

    public void setInfantVisit(String infantVisit3) {
        this.infantVisit = infantVisit3;
    }
    @Column(name = "infant_evaluation", length = 2)
    public String getInfantEvaluation() {
        return infantEvaluation;
    }

    public void setInfantEvaluation(String infantEvaluation) {
        this.infantEvaluation = infantEvaluation;
    }

    @Column(name = "infant_neuro_asq", nullable = true, length = 2)
    public String getInfantNeuroAsq() {
        return infantNeuroAsq;
    }

    public void setInfantNeuroAsq(String infantNeuroAsq) {
        this.infantNeuroAsq = infantNeuroAsq;
    }

    @Column(name = "infant_asq_communi", nullable = true)
    public Float getInfantAsqCommuni() {
        return infantAsqCommuni;
    }

    public void setInfantAsqCommuni(Float infantAsqCommuni) {
        this.infantAsqCommuni = infantAsqCommuni;
    }

    @Column(name = "infant_asq_gross", nullable = true)
    public Float getInfantAsqGross() {
        return infantAsqGross;
    }

    public void setInfantAsqGross(Float infantAsqGross) {
        this.infantAsqGross = infantAsqGross;
    }

    @Column(name = "infant_asq_fine", nullable = true)
    public Float getInfantAsqFine() {
        return infantAsqFine;
    }

    public void setInfantAsqFine(Float infantAsqFine) {
        this.infantAsqFine = infantAsqFine;
    }

    @Column(name = "infant_asq_problem", nullable = true)
    public Float getInfantAsqProblem() {
        return infantAsqProblem;
    }

    public void setInfantAsqProblem(Float infantAsqProblem) {
        this.infantAsqProblem = infantAsqProblem;
    }

    @Column(name = "infant_asq_personal", nullable = true)
    public Float getInfantAsqPersonal() {
        return infantAsqPersonal;
    }

    public void setInfantAsqPersonal(Float infantAsqPersonal) {
        this.infantAsqPersonal = infantAsqPersonal;
    }

    @Column(name = "infant_neuro_bisd", nullable = true, length = 2)
    public String getInfantNeuroBisd() {
        return infantNeuroBisd;
    }

    public void setInfantNeuroBisd(String infantNeuroBisd) {
        this.infantNeuroBisd = infantNeuroBisd;
    }

    @Column(name = "infant_cg_score", nullable = true)
    public Float getInfantCgScore() {
        return infantCgScore;
    }

    public void setInfantCgScore(Float infantCgScore) {
        this.infantCgScore = infantCgScore;
    }

    @Column(name = "infant_cg_risk", nullable = true, length = 2)
    public String getInfantCgRisk() {
        return infantCgRisk;
    }

    public void setInfantCgRisk(String infantCgRisk) {
        this.infantCgRisk = infantCgRisk;
    }

    @Column(name = "infant_rp_score", nullable = true)
    public Float getInfantRpScore() {
        return infantRpScore;
    }

    public void setInfantRpScore(Float infantRpScore) {
        this.infantRpScore = infantRpScore;
    }

    @Column(name = "infant_rp_risk", nullable = true, length = 2)
    public String getInfantRpRisk() {
        return infantRpRisk;
    }

    public void setInfantRpRisk(String infantRpRisk) {
        this.infantRpRisk = infantRpRisk;
    }

    @Column(name = "infant_ep_score", nullable = true)
    public Float getInfantEpScore() {
        return infantEpScore;
    }

    public void setInfantEpScore(Float infantEpScore) {
        this.infantEpScore = infantEpScore;
    }

    @Column(name = "infant_ep_risk", nullable = true, length = 2)
    public String getInfantEpRisk() {
        return infantEpRisk;
    }

    public void setInfantEpRisk(String infantEpRisk) {
        this.infantEpRisk = infantEpRisk;
    }

    @Column(name = "infant_fm_score", nullable = true)
    public Float getInfantFmScore() {
        return infantFmScore;
    }

    public void setInfantFmScore(Float infantFmScore) {
        this.infantFmScore = infantFmScore;
    }

    @Column(name = "infant_fm_risk", nullable = true, length = 2)
    public String getInfantFmRisk() {
        return infantFmRisk;
    }

    public void setInfantFmRisk(String infantFmRisk) {
        this.infantFmRisk = infantFmRisk;
    }

    @Column(name = "infant_gm_score", nullable = true)
    public Float getInfantGmScore() {
        return infantGmScore;
    }

    public void setInfantGmScore(Float infantGmScore) {
        this.infantGmScore = infantGmScore;
    }

    @Column(name = "infant_gm_risk", nullable = true, length = 2)
    public String getInfantGmRisk() {
        return infantGmRisk;
    }

    public void setInfantGmRisk(String infantGmRisk) {
        this.infantGmRisk = infantGmRisk;
    }

    @Column(name = "infant_neuro_other", nullable = true, length = 2)
    public String getInfantNeuroOther() {
        return infantNeuroOther;
    }

    public void setInfantNeuroOther(String infantNeuroOther) {
        this.infantNeuroOther = infantNeuroOther;
    }

    @Column(name = "infant_other_name", nullable = true, length = 50)
    public String getInfantOtherName() {
        return infantOtherName;
    }

    public void setInfantOtherName(String infantOtherName) {
        this.infantOtherName = infantOtherName;
    }

    @Column(name = "infant_other_score", nullable = true)
    public Float getInfantOtherScore() {
        return infantOtherScore;
    }

    public void setInfantOtherScore(Float infantOtherScore) {
        this.infantOtherScore = infantOtherScore;
    }

    @Column(name = "infant_result_screening", length = 2)
    public String getInfantResultScreening() {
        return infantResultScreening;
    }

    public void setInfantResultScreening(String infantResultScreening) {
        this.infantResultScreening = infantResultScreening;
    }

    @Column(name = "infant_refer_testing", length = 2)
    public String getInfantReferTesting() {
        return infantReferTesting;
    }

    public void setInfantReferTesting(String infantReferTesting) {
        this.infantReferTesting = infantReferTesting;
    }

    @Column(name = "infant_comments_yn3", length = 2)
    public String getInfantCommentsYn() {
        return infantCommentsYn;
    }

    public void setInfantCommentsYn(String infantCommentsYn3) {
        this.infantCommentsYn = infantCommentsYn3;
    }

    @Column(name = "infant_comments_yn2_3", length = 100)
    public String getInfantComments() {
        return infantComments;
    }

    public void setInfantComments(String infantComments2_3) {
        this.infantComments = infantComments2_3;
    }

    @Override
    public String toString() {
        return "ZPOv2PsyEval{" + recordId + ", " + eventName + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ZpoV2InfantPsychologicalEvaluation)) return false;

        ZpoV2InfantPsychologicalEvaluation that = (ZpoV2InfantPsychologicalEvaluation) o;

        if (!recordId.equals(that.recordId)) return false;
        if (!eventName.equals(that.eventName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recordId.hashCode();
        result = 31 * result + eventName.hashCode();
        return result;
    }
}
