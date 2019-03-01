package ni.org.ics.zpo.v2.domain.catalogs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

import ni.org.ics.zpo.v2.domain.BaseMetaData;
import ni.org.ics.zpo.v2.domain.audit.Auditable;


@Entity
@Table(name = "providers", catalog = "zika_zpo_v2")
public class Provider extends BaseMetaData implements Auditable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private Cs us;
	private Speciality speciality;
	
	@Id
	@Column(name = "ID", nullable = false, length =50)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Column(name = "NOMBRE", nullable = false, length =255)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@ManyToOne
	@JoinColumn(name="CS", insertable = false, updatable = false)
	@ForeignKey(name = "US_PROVEEDORES_FK")
	public Cs getUs() {
		return us;
	}
	public void setUs(Cs us) {
		this.us = us;
	}
	@ManyToOne
	@JoinColumn(name="ESPECIALIDAD", insertable = false, updatable = false)
	@ForeignKey(name = "ESP_PROVEEDORES_FK")
	public Speciality getSpeciality() {
		return speciality;
	}
	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}
	@Override
	public String toString(){
		return name;
	}
	@Override
	public boolean equals(Object other) {
		
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Provider))
			return false;
		
		Provider castOther = (Provider) other;

		return (this.getId().equals(castOther.getId()));
	}
	@Override
	public boolean isFieldAuditable(String fieldname) {
		// TODO Auto-generated method stub
		return true;
	}
}
