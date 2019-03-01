package ni.org.ics.zpo.v2.domain;

import javax.persistence.*;
import ni.org.ics.zpo.v2.domain.audit.Auditable;

import java.util.Date;

/**
 * Created by FIRSTICT on 10/6/2016.
 * V1.0
 */
@Entity
@Table(name = "zpo00_screening", catalog = "zika_zpo_v2")
public class Zpo00Screening extends BaseMetaData implements Auditable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String recordId;
    private String eventName;
    private Date scrVisitDate;
    private String scrConsentObta;
    private String scrObDobDay;
    private String scrObDobMon;
    private Integer scrObDobYear;
    private Integer scrObAge;
    private String scrObAssent;
    private String scrConsentA; //envio muestras a EEUU
    private String scrConsentB; //USO FUTORO DE MUESTRAS BIOLOGICAS
    private String scrConsentC; //ESTUDIOS GENETICOS
    private String scrName1Tutor;
    private String scrName2Tutor;
    private String scrLastName1Tutor;
    private String scrLastName2Tutor;
    private String scrFamilyRelationship;
    private String scrFamilyRelOther;
    private String scrIlliterate;
    private String scrName1Witness;
    private String scrName2Witness;
    private String scrLastName1Witness;
    private String scrLastName2Witness;
    private String scrReasonNot;
    private String scrReasonOther;
    private String scrCs;

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

    @Column(name = "scr_visit_date", nullable = false)
    public Date getScrVisitDate() {
        return scrVisitDate;
    }

    public void setScrVisitDate(Date scrVisitDate) {
        this.scrVisitDate = scrVisitDate;
    }

    @Column(name = "scr_consent_obta", nullable = true, length = 1)
    public String getScrConsentObta() {
        return scrConsentObta;
    }

    public void setScrConsentObta(String scrConsentObta) {
        this.scrConsentObta = scrConsentObta;
    }

    @Column(name = "scr_ob_dob_day", nullable = true, length = 2)
    public String getScrObDobDay() {
        return scrObDobDay;
    }

    public void setScrObDobDay(String scrObDobDay) {
        this.scrObDobDay = scrObDobDay;
    }

    @Column(name = "scr_ob_dob_mon", nullable = true, length = 2)
    public String getScrObDobMon() {
        return scrObDobMon;
    }

    public void setScrObDobMon(String scrObDobMon) {
        this.scrObDobMon = scrObDobMon;
    }

    @Column(name = "scr_ob_dob_year", nullable = true)
    public Integer getScrObDobYear() {
        return scrObDobYear;
    }

    public void setScrObDobYear(Integer scrObDobYear) {
        this.scrObDobYear = scrObDobYear;
    }

    @Column(name = "scr_ob_age", nullable = true)
    public Integer getScrObAge() {
        return scrObAge;
    }

    public void setScrObAge(Integer scrObAge) {
        this.scrObAge = scrObAge;
    }

    @Column(name = "scr_ob_assent", nullable = true, length = 2)
    public String getScrObAssent() {
        return scrObAssent;
    }

    public void setScrObAssent(String scrObAssent) {
        this.scrObAssent = scrObAssent;
    }

    @Column(name = "scr_consent_a",columnDefinition = "", nullable = true, length = 2)
    public String getScrConsentA() {
        return scrConsentA;
    }

    public void setScrConsentA(String scrConsentA) {
        this.scrConsentA = scrConsentA;
    }

    @Column(name = "scr_consent_b", nullable = true, length = 2)
    public String getScrConsentB() {
        return scrConsentB;
    }

    public void setScrConsentB(String scrConsentB) {
        this.scrConsentB = scrConsentB;
    }

    @Column(name = "scr_consent_c", nullable = true, length = 2)
    public String getScrConsentC() {
        return scrConsentC;
    }

    public void setScrConsentC(String scrConsentC) {
        this.scrConsentC = scrConsentC;
    }

    @Column(name = "name1_tutor", length = 100)
    public String getScrName1Tutor() {
        return scrName1Tutor;
    }

    public void setScrName1Tutor(String nombre1Tutor) {
        this.scrName1Tutor = nombre1Tutor;
    }

    @Column(name = "name2_tutor", length = 100)
    public String getScrName2Tutor() {
        return scrName2Tutor;
    }

    public void setScrName2Tutor(String nombre2Tutor) {
        this.scrName2Tutor = nombre2Tutor;
    }

    @Column(name = "lastname1_tutor", length = 100)
    public String getScrLastName1Tutor() {
        return scrLastName1Tutor;
    }

    public void setScrLastName1Tutor(String apellido1Tutor) {
        this.scrLastName1Tutor = apellido1Tutor;
    }

    @Column(name = "lastname2_tutor", length = 100)
    public String getScrLastName2Tutor() {
        return scrLastName2Tutor;
    }

    public void setScrLastName2Tutor(String apellido2Tutor) {
        this.scrLastName2Tutor = apellido2Tutor;
    }

    @Column(name = "family_relationship", nullable = true, length = 50)
    public String getScrFamilyRelationship() {
        return scrFamilyRelationship;
    }

    public void setScrFamilyRelationship(String relacionFamiliar) {
        this.scrFamilyRelationship = relacionFamiliar;
    }

    @Column(name = "family_relation_other", nullable = true, length = 100)
    public String getScrFamilyRelOther() {
        return scrFamilyRelOther;
    }

    public void setScrFamilyRelOther(String scrFamilyRelOther) {
        this.scrFamilyRelOther = scrFamilyRelOther;
    }

    @Column(name = "illiterate", length = 1)
    public String getScrIlliterate() {
        return scrIlliterate;
    }

    public void setScrIlliterate(String testigoPresente) {
        this.scrIlliterate = testigoPresente;
    }

    @Column(name = "name1_witness", length = 100)
    public String getScrName1Witness() {
        return scrName1Witness;
    }

    public void setScrName1Witness(String nombre1Testigo) {
        this.scrName1Witness = nombre1Testigo;
    }

    @Column(name = "name2_witness", length = 100)
    public String getScrName2Witness() {
        return scrName2Witness;
    }

    public void setScrName2Witness(String nombre2Testigo) {
        this.scrName2Witness = nombre2Testigo;
    }

    @Column(name = "lastaname1_witness", length = 100)
    public String getScrLastName1Witness() {
        return scrLastName1Witness;
    }

    public void setScrLastName1Witness(String apellido1Testigo) {
        this.scrLastName1Witness = apellido1Testigo;
    }

    @Column(name = "lastname2_witness", length = 100)
    public String getScrLastName2Witness() {
        return scrLastName2Witness;
    }

    public void setScrLastName2Witness(String apellido2Testigo) {
        this.scrLastName2Witness = apellido2Testigo;
    }

    @Column(name = "scr_reason_not", nullable = true, length = 2)
    public String getScrReasonNot() {
        return scrReasonNot;
    }

    public void setScrReasonNot(String scrReasonNot) {
        this.scrReasonNot = scrReasonNot;
    }

    @Column(name = "scr_reason_other", nullable = true)
    public String getScrReasonOther() {
        return scrReasonOther;
    }

    public void setScrReasonOther(String scrReasonOther) {
        this.scrReasonOther = scrReasonOther;
    }

    @Column(name = "scr_cs", nullable = true, length = 5)
    public String getScrCs() {
        return scrCs;
    }

    public void setScrCs(String scrCs) {
        this.scrCs = scrCs;
    }

    @Override
	public boolean isFieldAuditable(String fieldname) {
		return true;
	}
	
	@Override
	public String toString(){
		return this.recordId;
	}
	
	@Override
	public boolean equals(Object other) {
		
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Zpo00Screening))
			return false;
		
		Zpo00Screening castOther = (Zpo00Screening) other;

		return (this.getRecordId().equals(castOther.getRecordId()));
	}
}

