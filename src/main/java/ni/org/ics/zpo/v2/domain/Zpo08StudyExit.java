package ni.org.ics.zpo.v2.domain;

import ni.org.ics.zpo.v2.domain.audit.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by FIRSTICT on 10/11/2016.
 * V1.0
 */
@Entity
@Table(name = "zpo08_study_exit", catalog = "zika_zpo")
public class Zpo08StudyExit extends BaseMetaData implements Auditable {

    private static final long serialVersionUID = 1L;
    private String recordId;
    private String eventName;
    private Date extStudyExitDate;
    private String extSubjClass;
    private String extStudyExitReason;
    private String extNonpregMatrnlDth;
    private String extAcuteHealthSpec;
    private String extHealthCondSpec;
    private String extFatalInjSpec;
    private String extInfDeathTime;
    private String extTestResultsRcvd;
    private String extCounselingRcvd;
    private String extComments;
    private String extIdCompleting;
    private Date extDateCompleted;
    private String extIdReviewer;
    private Date extDateReviewed;
    private String extIdDataEntry;
    private Date extDateEntered;

    @Id
    @Column(name = "record_id", nullable = false, length = 25)
    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    @Column(name = "event_name", nullable = true, length = 100)
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @Column(name = "ext_study_exit_date", nullable = true)
    public Date getExtStudyExitDate() {
        return extStudyExitDate;
    }

    public void setExtStudyExitDate(Date extStudyExitDate) {
        this.extStudyExitDate = extStudyExitDate;
    }

    @Column(name = "ext_subj_class", nullable = true, length = 1)
    public String getExtSubjClass() {
        return extSubjClass;
    }

    public void setExtSubjClass(String extSubjClass) {
        this.extSubjClass = extSubjClass;
    }

    @Column(name = "ext_study_exit_reason", nullable = true, length = 2)
    public String getExtStudyExitReason() {
        return extStudyExitReason;
    }

    public void setExtStudyExitReason(String extStudyExitReason) {
        this.extStudyExitReason = extStudyExitReason;
    }

    @Column(name = "ext_nonpreg_matrnl_dth", nullable = true, length = 2)
    public String getExtNonpregMatrnlDth() {
        return extNonpregMatrnlDth;
    }

    public void setExtNonpregMatrnlDth(String extNonpregMatrnlDth) {
        this.extNonpregMatrnlDth = extNonpregMatrnlDth;
    }

    @Column(name = "ext_acute_health_spec", nullable = true)
    public String getExtAcuteHealthSpec() {
        return extAcuteHealthSpec;
    }

    public void setExtAcuteHealthSpec(String extAcuteHealthSpec) {
        this.extAcuteHealthSpec = extAcuteHealthSpec;
    }

    @Column(name = "ext_health_cond_spec", nullable = true)
    public String getExtHealthCondSpec() {
        return extHealthCondSpec;
    }

    public void setExtHealthCondSpec(String extHealthCondSpec) {
        this.extHealthCondSpec = extHealthCondSpec;
    }

    @Column(name = "ext_fatal_inj_spec", nullable = true)
    public String getExtFatalInjSpec() {
        return extFatalInjSpec;
    }

    public void setExtFatalInjSpec(String extFatalInjSpec) {
        this.extFatalInjSpec = extFatalInjSpec;
    }

    @Column(name = "ext_inf_death_time", nullable = true, length = 2)
    public String getExtInfDeathTime() {
        return extInfDeathTime;
    }

    public void setExtInfDeathTime(String extInfDeathTime) {
        this.extInfDeathTime = extInfDeathTime;
    }

    @Column(name = "ext_test_results_rcvd", nullable = true, length = 1)
    public String getExtTestResultsRcvd() {
        return extTestResultsRcvd;
    }

    public void setExtTestResultsRcvd(String extTestResultsRcvd) {
        this.extTestResultsRcvd = extTestResultsRcvd;
    }

    @Column(name = "ext_counseling_rcvd", nullable = true, length = 1)
    public String getExtCounselingRcvd() {
        return extCounselingRcvd;
    }

    public void setExtCounselingRcvd(String extCounselingRcvd) {
        this.extCounselingRcvd = extCounselingRcvd;
    }

    @Column(name = "ext_comments", nullable = true)
    public String getExtComments() { return extComments;  }

    public void setExtComments(String extComments) { this.extComments = extComments; }

    @Column(name = "ext_id_completing", nullable = true, length = 50)
    public String getExtIdCompleting() {
        return extIdCompleting;
    }

    public void setExtIdCompleting(String extIdCompleting) {
        this.extIdCompleting = extIdCompleting;
    }

    @Column(name = "ext_date_completed", nullable = true)
    public Date getExtDateCompleted() {
        return extDateCompleted;
    }

    public void setExtDateCompleted(Date extDateCompleted) {
        this.extDateCompleted = extDateCompleted;
    }

    @Column(name = "ext_id_reviewer", nullable = true, length = 50)
    public String getExtIdReviewer() {
        return extIdReviewer;
    }

    public void setExtIdReviewer(String extIdReviewer) {
        this.extIdReviewer = extIdReviewer;
    }

    @Column(name = "ext_date_reviewed", nullable = true)
    public Date getExtDateReviewed() {
        return extDateReviewed;
    }

    public void setExtDateReviewed(Date extDateReviewed) {
        this.extDateReviewed = extDateReviewed;
    }

    @Column(name = "ext_id_data_entry", nullable = true, length = 50)
    public String getExtIdDataEntry() {
        return extIdDataEntry;
    }

    public void setExtIdDataEntry(String extIdDataEntry) {
        this.extIdDataEntry = extIdDataEntry;
    }

    @Column(name = "ext_date_entered", nullable = true)
    public Date getExtDateEntered() {
        return extDateEntered;
    }

    public void setExtDateEntered(Date extDateEntered) {
        this.extDateEntered = extDateEntered;
    }

    @Override
    public boolean isFieldAuditable(String fieldname) {
        return true;
    }

    @Override
    public String toString() {
        return this.recordId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Zpo08StudyExit)) return false;

        Zpo08StudyExit that = (Zpo08StudyExit) o;

        return (recordId.equals(that.recordId));
    }
}
