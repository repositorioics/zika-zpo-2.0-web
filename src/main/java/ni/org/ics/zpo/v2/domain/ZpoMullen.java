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
@Table(name = "zpo_mullen", catalog = "zika_zpo_v2")
public class ZpoMullen extends BaseMetaData implements Auditable {

    private String recordId;
    private String eventName;
    private String sexMsel;
    private String raNameMsel;
    private String visitMonthsMsel;
    private String visProbMsel;
    private String desVisProbMsel;
    private String hearProbMsel;
    private String desHearProbMsel;
    private Date testingDateMsel;
    private Date eddMsel;
    private String adjAgeMsel;
    private Date actDobMsel;
    private String gmRaw;
    private String gmTScore;
    private String gmBoe;
    private String gmPerRank;
    private String gmDesCat;
    private String gmAgeEqu;
    private String vrRaw;
    private String vrTScore;
    private String vrBoe;
    private String vrPerRank;
    private String vrDesCat;
    private String vrAgeEqu;
    private String fmRaw;
    private String fmTScore;
    private String fmBoe;
    private String fmPerRank;
    private String fmDesCat;
    private String fmAgeEqu;
    private String rlRaw;
    private String rlTScore;
    private String rlBoe;
    private String rlPerRank;
    private String rlDesCat;
    private String rlAgeEqu;
    private String elRaw;
    private String elTScore;
    private String elBoe;
    private String elPerRank;
    private String elDesCat;
    private String elAgeEqu;
    private String cognTScoreSum;
    private String elcStandScore;
    private String elcBoe;
    private String elcPerRank;
    private String elcDesCat;
    private String mselComment;

    @Id
    @Column(name = "cod_nino_msel_3m", nullable = false, length = 25)
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

    @Column(name = "sex_msel", length = 1)
    public String getSexMsel() {
        return sexMsel;
    }

    public void setSexMsel(String sexMsel) {
        this.sexMsel = sexMsel;
    }

    @Column(name = "ra_name_msel", length = 100)
    public String getRaNameMsel() {
        return raNameMsel;
    }

    public void setRaNameMsel(String raNameMsel) {
        this.raNameMsel = raNameMsel;
    }

    @Column(name = "visit_months_msel", length = 1)
    public String getVisitMonthsMsel() {
        return visitMonthsMsel;
    }

    public void setVisitMonthsMsel(String visitMonthsMsel) {
        this.visitMonthsMsel = visitMonthsMsel;
    }

    @Column(name = "vis_prob_msel", length = 1)
    public String getVisProbMsel() {
        return visProbMsel;
    }

    public void setVisProbMsel(String visProbMsel) {
        this.visProbMsel = visProbMsel;
    }

    @Column(name = "des_vis_prob_msel", length = 100)
    public String getDesVisProbMsel() {
        return desVisProbMsel;
    }

    public void setDesVisProbMsel(String desVisProbMsel) {
        this.desVisProbMsel = desVisProbMsel;
    }

    @Column(name = "hear_prob_msel", length = 1)
    public String getHearProbMsel() {
        return hearProbMsel;
    }

    public void setHearProbMsel(String hearProbMsel) {
        this.hearProbMsel = hearProbMsel;
    }

    @Column(name = "des_hear_prob_msel", length = 100)
    public String getDesHearProbMsel() {
        return desHearProbMsel;
    }

    public void setDesHearProbMsel(String desHearProbMsel) {
        this.desHearProbMsel = desHearProbMsel;
    }

    @Column(name = "testing_date_msel")
    public Date getTestingDateMsel() {
        return testingDateMsel;
    }

    public void setTestingDateMsel(Date testingDateMsel) {
        this.testingDateMsel = testingDateMsel;
    }

    @Column(name = "edd_msel")
    public Date getEddMsel() {
        return eddMsel;
    }

    public void setEddMsel(Date eddMsel) {
        this.eddMsel = eddMsel;
    }

    @Column(name = "adj_age_msel", length = 2)
    public String getAdjAgeMsel() {
        return adjAgeMsel;
    }

    public void setAdjAgeMsel(String adjAgeMsel) {
        this.adjAgeMsel = adjAgeMsel;
    }

    @Column(name = "act_dob_msel")
    public Date getActDobMsel() {
        return actDobMsel;
    }

    public void setActDobMsel(Date actDobMsel) {
        this.actDobMsel = actDobMsel;
    }

    @Column(name = "gm_raw", length = 4)
    public String getGmRaw() {
        return gmRaw;
    }

    public void setGmRaw(String gmRaw) {
        this.gmRaw = gmRaw;
    }

    @Column(name = "gm_t_score", length = 4)
    public String getGmTScore() {
        return gmTScore;
    }

    public void setGmTScore(String gmTScore) {
        this.gmTScore = gmTScore;
    }

    @Column(name = "gm_boe", length = 4)
    public String getGmBoe() {
        return gmBoe;
    }

    public void setGmBoe(String gmBoe) {
        this.gmBoe = gmBoe;
    }

    @Column(name = "gm_per_rank", length = 4)
    public String getGmPerRank() {
        return gmPerRank;
    }

    public void setGmPerRank(String gmPerRank) {
        this.gmPerRank = gmPerRank;
    }

    @Column(name = "gm_des_cat", length = 4)
    public String getGmDesCat() {
        return gmDesCat;
    }

    public void setGmDesCat(String gmDesCat) {
        this.gmDesCat = gmDesCat;
    }

    @Column(name = "gm_age_equ", length = 4)
    public String getGmAgeEqu() {
        return gmAgeEqu;
    }

    public void setGmAgeEqu(String gmAgeEqu) {
        this.gmAgeEqu = gmAgeEqu;
    }

    @Column(name = "vr_raw", length = 4)
    public String getVrRaw() {
        return vrRaw;
    }

    public void setVrRaw(String vrRaw) {
        this.vrRaw = vrRaw;
    }

    @Column(name = "vr_t_score", length = 4)
    public String getVrTScore() {
        return vrTScore;
    }

    public void setVrTScore(String vrTScore) {
        this.vrTScore = vrTScore;
    }

    @Column(name = "vr_boe", length = 4)
    public String getVrBoe() {
        return vrBoe;
    }

    public void setVrBoe(String vrBoe) {
        this.vrBoe = vrBoe;
    }

    @Column(name = "vr_per_rank", length = 4)
    public String getVrPerRank() {
        return vrPerRank;
    }

    public void setVrPerRank(String vrPerRank) {
        this.vrPerRank = vrPerRank;
    }

    @Column(name = "vr_des_cat", length = 4)
    public String getVrDesCat() {
        return vrDesCat;
    }

    public void setVrDesCat(String vrDesCat) {
        this.vrDesCat = vrDesCat;
    }

    @Column(name = "vr_age_equ", length = 4)
    public String getVrAgeEqu() {
        return vrAgeEqu;
    }

    public void setVrAgeEqu(String vrAgeEqu) {
        this.vrAgeEqu = vrAgeEqu;
    }

    @Column(name = "fm_raw", length = 4)
    public String getFmRaw() {
        return fmRaw;
    }

    public void setFmRaw(String fmRaw) {
        this.fmRaw = fmRaw;
    }

    @Column(name = "fm_t_score", length = 4)
    public String getFmTScore() {
        return fmTScore;
    }

    public void setFmTScore(String fmTScore) {
        this.fmTScore = fmTScore;
    }

    @Column(name = "fm_boe", length = 4)
    public String getFmBoe() {
        return fmBoe;
    }

    public void setFmBoe(String fmBoe) {
        this.fmBoe = fmBoe;
    }

    @Column(name = "fm_per_rank", length = 4)
    public String getFmPerRank() {
        return fmPerRank;
    }

    public void setFmPerRank(String fmPerRank) {
        this.fmPerRank = fmPerRank;
    }

    @Column(name = "fm_des_cat", length = 4)
    public String getFmDesCat() {
        return fmDesCat;
    }

    public void setFmDesCat(String fmDesCat) {
        this.fmDesCat = fmDesCat;
    }

    @Column(name = "fm_age_equ", length = 4)
    public String getFmAgeEqu() {
        return fmAgeEqu;
    }

    public void setFmAgeEqu(String fmAgeEqu) {
        this.fmAgeEqu = fmAgeEqu;
    }

    @Column(name = "rl_raw", length = 4)
    public String getRlRaw() {
        return rlRaw;
    }

    public void setRlRaw(String rlRaw) {
        this.rlRaw = rlRaw;
    }

    @Column(name = "rl_t_score", length = 4)
    public String getRlTScore() {
        return rlTScore;
    }

    public void setRlTScore(String rlTScore) {
        this.rlTScore = rlTScore;
    }

    @Column(name = "rl_boe", length = 4)
    public String getRlBoe() {
        return rlBoe;
    }

    public void setRlBoe(String rlBoe) {
        this.rlBoe = rlBoe;
    }

    @Column(name = "rl_per_rank", length = 4)
    public String getRlPerRank() {
        return rlPerRank;
    }

    public void setRlPerRank(String rlPerRank) {
        this.rlPerRank = rlPerRank;
    }

    @Column(name = "rl_des_cat", length = 4)
    public String getRlDesCat() {
        return rlDesCat;
    }

    public void setRlDesCat(String rlDesCat) {
        this.rlDesCat = rlDesCat;
    }

    @Column(name = "rl_age_equ", length = 4)
    public String getRlAgeEqu() {
        return rlAgeEqu;
    }

    public void setRlAgeEqu(String rlAgeEqu) {
        this.rlAgeEqu = rlAgeEqu;
    }

    @Column(name = "el_raw", length = 4)
    public String getElRaw() {
        return elRaw;
    }

    public void setElRaw(String elRaw) {
        this.elRaw = elRaw;
    }

    @Column(name = "el_t_score", length = 4)
    public String getElTScore() {
        return elTScore;
    }

    public void setElTScore(String elTScore) {
        this.elTScore = elTScore;
    }

    @Column(name = "el_boe", length = 4)
    public String getElBoe() {
        return elBoe;
    }

    public void setElBoe(String elBoe) {
        this.elBoe = elBoe;
    }

    @Column(name = "el_per_rank", length = 4)
    public String getElPerRank() {
        return elPerRank;
    }

    public void setElPerRank(String elPerRank) {
        this.elPerRank = elPerRank;
    }

    @Column(name = "el_des_cat", length = 4)
    public String getElDesCat() {
        return elDesCat;
    }

    public void setElDesCat(String elDesCat) {
        this.elDesCat = elDesCat;
    }

    @Column(name = "el_age_equ", length = 4)
    public String getElAgeEqu() {
        return elAgeEqu;
    }

    public void setElAgeEqu(String elAgeEqu) {
        this.elAgeEqu = elAgeEqu;
    }

    @Column(name = "cogn_t_score_sum", length = 4)
    public String getCognTScoreSum() {
        return cognTScoreSum;
    }

    public void setCognTScoreSum(String cognTScoreSum) {
        this.cognTScoreSum = cognTScoreSum;
    }

    @Column(name = "elc_stand_score", length = 4)
    public String getElcStandScore() {
        return elcStandScore;
    }

    public void setElcStandScore(String elcStandScore) {
        this.elcStandScore = elcStandScore;
    }

    @Column(name = "elc_boe", length = 4)
    public String getElcBoe() {
        return elcBoe;
    }

    public void setElcBoe(String elcBoe) {
        this.elcBoe = elcBoe;
    }

    @Column(name = "elc_per_rank", length = 4)
    public String getElcPerRank() {
        return elcPerRank;
    }

    public void setElcPerRank(String elcPerRank) {
        this.elcPerRank = elcPerRank;
    }

    @Column(name = "elc_des_cat", length = 4)
    public String getElcDesCat() {
        return elcDesCat;
    }

    public void setElcDesCat(String elcDesCat) {
        this.elcDesCat = elcDesCat;
    }

    @Column(name = "msel_comment", length = 4)
    public String getMselComment() {
        return mselComment;
    }

    public void setMselComment(String mselComment) {
        this.mselComment = mselComment;
    }

    @Override
    public boolean isFieldAuditable(String fieldname) {
        return false;
    }

    @Override
    public String toString() {
        return this.recordId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof ZpoMullen)) return false;

        ZpoMullen that = (ZpoMullen) o;

        return (recordId.equals(that.recordId));
    }
}
