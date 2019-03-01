package ni.org.ics.zpo.v2.domain.catalogs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "appointment_types", catalog = "zika_zpo_v2")
public class AppointmentType {
	private String appointmentType;
	
	@Id
	@Column(name = "TIPO_CITA", nullable = false, length =50)
	public String getAppointmentType() {
		return appointmentType;
	}
	public void setAppointmentType(String appointmentType) {
		this.appointmentType = appointmentType;
	}
	@Override
	public String toString(){
		return appointmentType;
	}
	@Override
	public boolean equals(Object other) {
		
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AppointmentType))
			return false;
		
		AppointmentType castOther = (AppointmentType) other;

		return (this.getAppointmentType().equals(castOther.getAppointmentType()));
	}
}
