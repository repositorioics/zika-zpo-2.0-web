package ni.org.ics.zpo.v2.domain;

import javax.persistence.*;
import ni.org.ics.zpo.v2.domain.audit.Auditable;

import java.util.Date;

/**
 * Created by FIRSTICT on 10/6/2016.
 * V1.0
 */
@Entity
@Table(name = "zpo_screening", catalog = "zika_zpo_v2")
public class ZpoScreening extends BaseMetaData implements Auditable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String recordId;
    private String eventName;
    private Date scrVisitDate;
    private String scrConsentObta;
    private String scrConsentA; //envio muestras a EEUU
    private String scrConsentB; //USO FUTORO DE MUESTRAS BIOLOGICAS
    private String scrConsentC; //ESTUDIOS GENETICOS
    private String scrWitness;
    private String scrAssistant;
    private String scrReasonNot;
    private String scrReasonOther;
    private String scrCs;
    private String scrTipo;

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

    @Column(name = "scr_witness", nullable = true, length = 2)
    public String getScrWitness() {
        return scrWitness;
    }

    public void setScrWitness(String scrWitness) {
        this.scrWitness = scrWitness;
    }

    @Column(name = "scr_assistant", nullable = true, length = 2)
    public String getScrAssistant() {
        return scrAssistant;
    }

    @Column(name = "scr_consent_c", nullable = true, length = 2)
    public void setScrAssistant(String scrAssistant) {
        this.scrAssistant = scrAssistant;
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

    @Column(name = "scr_tipo", nullable = true, length = 1)
    public String getScrTipo() {
        return scrTipo;
    }

    public void setScrTipo(String scrTipo) {
        this.scrTipo = scrTipo;
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
		if (!(other instanceof ZpoScreening))
			return false;
		
		ZpoScreening castOther = (ZpoScreening) other;

		return (this.getRecordId().equals(castOther.getRecordId()));
	}
}

