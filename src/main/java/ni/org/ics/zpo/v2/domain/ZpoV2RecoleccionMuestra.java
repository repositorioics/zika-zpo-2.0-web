package ni.org.ics.zpo.v2.domain;

import ni.org.ics.zpo.v2.domain.audit.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Miguel Salinas on 19/03/2019.
 * V1.0
 */
@Entity
@Table(name = "zpo_biospecimen_collection", catalog = "zika_zpo_v2")
public class ZpoV2RecoleccionMuestra extends BaseMetaData implements Auditable {

    private static final long serialVersionUID = 1L;
    private String recordId;
    private String eventName;
    private Date bloodTodaysDate;
    private String bloodSampleCollected;
    private String bloodWhichPerson;
    private Date bloodMomSampleDate;
    private Integer bloodMomTubes;
    private String bloodMomType;
    private Date bloodChildSampleDate;
    private Integer bloodChildTubes;
    private String bloodChildType;
    private String bloodPersonnel;


    /*private Date bscDov;
    private String bscVisit;
    private String bscMatBldCol1;
    private String bscMatBldId1;
    private String bscMatBldRsn1;
    private String bscMatBldRsnOther1;
    private Double bscMatBldVol1;
    private String bscMatBldCol2;
    private String bscMatBldId2;
    private String bscMatBldRsn2;
    private String bscMatBldRsnOther2;
    private Double bscMatBldVol2;
    private String bscPhlebotomist;*/

    @Id
    @Column(name = "record_id", nullable = false, length = 25)
    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    @Id
    @Column(name = "event_name", nullable = true, length = 100)
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }


    @Column(name = "blood_todays_date")
    public Date getBloodTodaysDate() {
        return bloodTodaysDate;
    }

    public void setBloodTodaysDate(Date bloodTodaysDate) {
        this.bloodTodaysDate = bloodTodaysDate;
    }

    @Column(name = "blood_sample_collected", length = 1)
    public String getBloodSampleCollected() {
        return bloodSampleCollected;
    }

    public void setBloodSampleCollected(String bloodSampleCollected) {
        this.bloodSampleCollected = bloodSampleCollected;
    }

    @Column(name = "blood_which_person", length = 1)
    public String getBloodWhichPerson() {
        return bloodWhichPerson;
    }

    public void setBloodWhichPerson(String bloodWhichPerson) {
        this.bloodWhichPerson = bloodWhichPerson;
    }

    @Column(name = "blood_mom_sample_date")
    public Date getBloodMomSampleDate() {
        return bloodMomSampleDate;
    }

    public void setBloodMomSampleDate(Date bloodMomSampleDate) {
        this.bloodMomSampleDate = bloodMomSampleDate;
    }


    @Column(name = "blood_mom_tubes")
    public Integer getBloodMomTubes() {
        return bloodMomTubes;
    }

    public void setBloodMomTubes(Integer bloodMomTubes) {
        this.bloodMomTubes = bloodMomTubes;
    }

    @Column(name = "blood_mom_type", length = 50)
    public String getBloodMomType() {
        return bloodMomType;
    }

    public void setBloodMomType(String bloodMomType) {
        this.bloodMomType = bloodMomType;
    }

    @Column(name = "blood_child_sample_date")
    public Date getBloodChildSampleDate() {
        return bloodChildSampleDate;
    }

    public void setBloodChildSampleDate(Date bloodChildSampleDate) {
        this.bloodChildSampleDate = bloodChildSampleDate;
    }


    @Column(name = "blood_child_tubes")
    public Integer getBloodChildTubes() {
        return bloodChildTubes;
    }

    public void setBloodChildTubes(Integer bloodChildTubes) {
        this.bloodChildTubes = bloodChildTubes;
    }

    @Column(name = "blood_child_type", length = 50)
    public String getBloodChildType() {
        return bloodChildType;
    }

    public void setBloodChildType(String bloodChildType) {
        this.bloodChildType = bloodChildType;
    }

    @Column(name = "blood_personnel", length =100)
    public String getBloodPersonnel() {
        return bloodPersonnel;
    }

    public void setBloodPersonnel(String bloodPersonnel) {
        this.bloodPersonnel = bloodPersonnel;
    }

    @Override
    public String toString() {
        return "ZpoV2RecoleccionMuestra{" + recordId + "," + eventName + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ZpoV2RecoleccionMuestra)) return false;

        ZpoV2RecoleccionMuestra that = (ZpoV2RecoleccionMuestra) o;

        if (!eventName.equals(that.eventName)) return false;
        if (!recordId.equals(that.recordId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recordId.hashCode();
        result = 31 * result + eventName.hashCode();
        return result;
    }

    @Override
    public boolean isFieldAuditable(String fieldname) {
        return true;
    }
}
