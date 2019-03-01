package ni.org.ics.zpo.v2.domain.catalogs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "specialities", catalog = "zika_zpo_v2")
public class Speciality {
	private String speciality;
	
	@Id
	@Column(name = "ESPECIALIDAD", nullable = false, length =50)
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	@Override
	public String toString(){
		return speciality;
	}
	@Override
	public boolean equals(Object other) {
		
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Speciality))
			return false;
		
		Speciality castOther = (Speciality) other;

		return (this.getSpeciality().equals(castOther.getSpeciality()));
	}
}
