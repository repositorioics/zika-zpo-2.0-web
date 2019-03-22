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
@Table(name = "zpo_infant_ophthalmologic_eval", catalog = "zika_zpo_v2")
public class ZpoV2InfantOphthalmologicEvaluation extends BaseMetaData{

    private static final long serialVersionUID = 1L;
    private String recordId;
    private String eventName;
    private Date infantVisitDate;
    private String infantStatus;
    private Date infantDeathDt;
    private String infantVisit;
    private String infantOphth;
    private String infantOphthType;
    private String infantOphthAbno;
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

    @Column(name = "infant_visit_date", length = 1)
    public Date getInfantVisitDate() {
        return infantVisitDate;
    }

    public void setInfantVisitDate(Date infantVisitDate2) {
        this.infantVisitDate = infantVisitDate2;
    }

    @Column(name = "infant_status", length = 1)
    public String getInfantStatus() {
        return infantStatus;
    }

    public void setInfantStatus(String infantStatus2) {
        this.infantStatus = infantStatus2;
    }

    @Column(name = "infant_death_dt")
    public Date getInfantDeathDt() {
        return infantDeathDt;
    }

    public void setInfantDeathDt(Date infantDeathDt2) {
        this.infantDeathDt = infantDeathDt2;
    }

    @Column(name = "infant_visit", length = 1)
    public String getInfantVisit() {
        return infantVisit;
    }

    public void setInfantVisit(String infantVisit2) {
        this.infantVisit = infantVisit2;
    }

    @Column(name = "infant_ophth", nullable = true, length = 2)
    public String getInfantOphth() {
        return infantOphth;
    }

    public void setInfantOphth(String infantOphth) {
        this.infantOphth = infantOphth;
    }

    @Column(name = "infant_ophth_type", length = 2)
    public String getInfantOphthType() {
        return infantOphthType;
    }

    public void setInfantOphthType(String infantOphthType) {
        this.infantOphthType = infantOphthType;
    }

    @Column(name = "infant_ophth_abno", length = 2)
    public String getInfantOphthAbno() {
        return infantOphthAbno;
    }

    public void setInfantOphthAbno(String infantOphthAbno) {
        this.infantOphthAbno = infantOphthAbno;
    }

    @Column(name = "infant_comments_yn",  length = 2)
    public String getInfantCommentsYn() {
        return infantCommentsYn;
    }

    public void setInfantCommentsYn(String infantCommentsYn2) {
        this.infantCommentsYn = infantCommentsYn2;
    }

    @Column(name = "infant_comments", length = 100)
    public String getInfantComments() {
        return infantComments;
    }

    public void setInfantComments(String infantComments2_2) {
        this.infantComments = infantComments2_2;
    }

    @Override
    public String toString() {
        return "ZPOv2OphtEval{" + recordId + ", " + eventName + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ZpoV2InfantOphthalmologicEvaluation)) return false;

        ZpoV2InfantOphthalmologicEvaluation that = (ZpoV2InfantOphthalmologicEvaluation) o;

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
