package ni.org.ics.zpo.v2.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

import ni.org.ics.zpo.v2.domain.audit.Auditable;
import ni.org.ics.zpo.v2.domain.catalogs.AppointmentType;
import ni.org.ics.zpo.v2.domain.catalogs.Cs;
import ni.org.ics.zpo.v2.domain.catalogs.Provider;
import ni.org.ics.zpo.v2.domain.catalogs.Speciality;
import ni.org.ics.zpo.v2.domain.catalogs.SubjectType;

@Entity
@Table(name = "zpo_agenda_estudio", catalog = "zika_zpo_v2")
public class ZpoAgendaEstudio extends BaseMetaData implements Auditable, Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private Date appointmentDateTime;
    private Provider provider;
    private Cs healtUnit;
    private String recordId;
    private SubjectType subjectType;
    private AppointmentType appointmentType;
    private Speciality specialityType;
    private String obs;
    
    @Id
    @Column(name = "ID", nullable = false, length = 50)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Column(name = "FECHA_HORA_CITA", nullable = false, length = 50)
	public Date getAppointmentDateTime() {
		return appointmentDateTime;
	}
	public void setAppointmentDateTime(Date appointmentDateTime) {
		this.appointmentDateTime = appointmentDateTime;
	}
	@ManyToOne
	@JoinColumn(name="PROVEEDOR", insertable = false, updatable = false)
	@ForeignKey(name = "PRO_CITAS_FK")
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	@ManyToOne
	@JoinColumn(name="US", insertable = false, updatable = false)
	@ForeignKey(name = "US_CITAS_FK")
	public Cs getHealtUnit() {
		return healtUnit;
	}
	public void setHealtUnit(Cs healtUnit) {
		this.healtUnit = healtUnit;
	}
	@Column(name = "RECORD_ID", nullable = false, length = 25)
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	@ManyToOne
	@JoinColumn(name="TIPO_SUJETO", insertable = false, updatable = false)
	@ForeignKey(name = "TSUJ_CITAS_FK")
	public SubjectType getSubjectType() {
		return subjectType;
	}
	public void setSubjectType(SubjectType subjectType) {
		this.subjectType = subjectType;
	}
	
	@ManyToOne
	@JoinColumn(name="TIPO_CITA", insertable = false, updatable = false)
	@ForeignKey(name = "TCITA_CITAS_FK")
	public AppointmentType getAppointmentType() {
		return appointmentType;
	}
	public void setAppointmentType(AppointmentType appointmentType) {
		this.appointmentType = appointmentType;
	}
	
	@ManyToOne
	@JoinColumn(name="ESPECIALISTA", insertable = false, updatable = false)
	@ForeignKey(name = "ESP_CITAS_FK")
	public Speciality getSpecialityType() {
		return specialityType;
	}
	public void setSpecialityType(Speciality specialityType) {
		this.specialityType = specialityType;
	}
	@Column(name = "OBSERVACIONES", nullable = false, length = 25)
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	@Override
	public boolean equals(Object other) {
		
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ZpoAgendaEstudio))
			return false;
		
		ZpoAgendaEstudio castOther = (ZpoAgendaEstudio) other;

		return (this.getId().equals(castOther.getId()));
	}
	@Override
	public boolean isFieldAuditable(String fieldname) {
		return true;
	}
    
}
