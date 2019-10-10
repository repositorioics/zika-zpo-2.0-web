package ni.org.ics.zpo.v2.domain;

import ni.org.ics.zpo.v2.domain.audit.Auditable;

import javax.persistence.*;
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
    private Date testingDateMsel;
    private Integer adjAgeMsel;//edad infante
    private Date actDobMsel;//fecha nac
    private String gmRaw;
    private Integer gmTScore;
    private String gmPerRank;
    private String gmDesCat;
    private String gmAgeEqu;
    private String vrRaw;
    private Integer vrTScore;
    private String vrPerRank;
    private String vrDesCat;
    private String vrAgeEqu;
    private String fmRaw;
    private Integer fmTScore;
    private String fmPerRank;
    private String fmDesCat;
    private String fmAgeEqu;
    private String rlRaw;
    private String rlTScore;
    private String rlPerRank;
    private String rlDesCat;
    private String rlAgeEqu;
    private String elRaw;
    private Integer elTScore;
    private String elPerRank;
    private String elDesCat;
    private String elAgeEqu;
    private Integer cognTScoreSum;
    private String elcStandScore;
    private String elcPerRank;
    private String elcDesCat;
    private String mselComment;

    @Id
    @Column(name = "cod_nino_msel", nullable = false, length = 25)
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

    @Column(name = "testing_date_msel")
    public Date getTestingDateMsel() {
        return testingDateMsel;
    }

    public void setTestingDateMsel(Date testingDateMsel) {
        this.testingDateMsel = testingDateMsel;
    }

    @Column(name = "age_at_testing_msel", length = 2)
    public Integer getAdjAgeMsel() {
        return adjAgeMsel;
    }

    public void setAdjAgeMsel(Integer adjAgeMsel) {
        this.adjAgeMsel = adjAgeMsel;
    }

    @Basic
    @Column(name = "child_dob_msel")
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

    @Column(name = "gm_t_score")
    public Integer getGmTScore() {
        return gmTScore;
    }

    public void setGmTScore(Integer gmTScore) {
        this.gmTScore = gmTScore;
    }


    @Column(name = "gm_per_rank", length = 4)
    public String getGmPerRank() {
        return gmPerRank;
    }

    public void setGmPerRank(String gmPerRank) {
        this.gmPerRank = gmPerRank;
    }

    @Column(name = "gm_des_cat", length = 1)
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

    @Column(name = "vr_t_score")
    public Integer getVrTScore() {
        return vrTScore;
    }

    public void setVrTScore(Integer vrTScore) {
        this.vrTScore = vrTScore;
    }

    @Column(name = "vr_per_rank", length = 4)
    public String getVrPerRank() {
        return vrPerRank;
    }

    public void setVrPerRank(String vrPerRank) {
        this.vrPerRank = vrPerRank;
    }

    @Column(name = "vr_des_cat", length = 1)
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

    @Column(name = "fm_t_score")
    public Integer getFmTScore() {
        return fmTScore;
    }

    public void setFmTScore(Integer fmTScore) {
        this.fmTScore = fmTScore;
    }

    @Column(name = "fm_per_rank", length = 4)
    public String getFmPerRank() {
        return fmPerRank;
    }

    public void setFmPerRank(String fmPerRank) {
        this.fmPerRank = fmPerRank;
    }

    @Column(name = "fm_des_cat", length = 1)
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

    @Column(name = "rl_per_rank", length = 4)
    public String getRlPerRank() {
        return rlPerRank;
    }

    public void setRlPerRank(String rlPerRank) {
        this.rlPerRank = rlPerRank;
    }

    @Column(name = "rl_des_cat", length = 1)
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

    @Column(name = "el_t_score")
    public Integer getElTScore() {
        return elTScore;
    }

    public void setElTScore(Integer elTScore) {
        this.elTScore = elTScore;
    }

    @Column(name = "el_per_rank", length = 4)
    public String getElPerRank() {
        return elPerRank;
    }

    public void setElPerRank(String elPerRank) {
        this.elPerRank = elPerRank;
    }

    @Column(name = "el_des_cat", length = 1)
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


    @Column(name = "cogn_t_score_sum")
    public Integer getCognTScoreSum() {
        return cognTScoreSum;
    }

    public void setCognTScoreSum(Integer cognTScoreSum) {
        this.cognTScoreSum = cognTScoreSum;
    }

    @Column(name = "elc_stand_score", length = 4)
    public String getElcStandScore() {
        return elcStandScore;
    }

    public void setElcStandScore(String elcStandScore) {
        this.elcStandScore = elcStandScore;
    }

    @Column(name = "elc_per_rank", length = 4)
    public String getElcPerRank() {
        return elcPerRank;
    }

    public void setElcPerRank(String elcPerRank) {
        this.elcPerRank = elcPerRank;
    }

    @Column(name = "elc_des_cat", length = 1)
    public String getElcDesCat() {
        return elcDesCat;
    }

    public void setElcDesCat(String elcDesCat) {
        this.elcDesCat = elcDesCat;
    }

    @Column(name = "msel_comment", length = 100)
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
        return "ZpoMullen{" +
                "recordId='" + recordId + '\'' +
                ", eventName='" + eventName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZpoMullen zpoMullen = (ZpoMullen) o;

        if (!recordId.equals( zpoMullen.recordId )) return false;
        return eventName.equals( zpoMullen.eventName );
    }

    @Override
    public int hashCode() {
        int result = recordId.hashCode();
        result = 31 * result + eventName.hashCode();
        return result;
    }
}
