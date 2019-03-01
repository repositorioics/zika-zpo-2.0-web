package ni.org.ics.zpo.v2.domain.catalogs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Simple objeto de dominio que representa un cs
 * 
 * 
 * @author William Aviles
 **/

@Entity
@Table(name = "centers", catalog = "zika_zpo_v2")
public class Cs {
	private String cs;
	
	@Id
	@Column(name = "CS", nullable = false, length =50)
	public String getCs() {
		return cs;
	}
	public void setCs(String cs) {
		this.cs = cs;
	}
	@Override
	public String toString(){
		return cs;
	}
	@Override
	public boolean equals(Object other) {
		
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Cs))
			return false;
		
		Cs castOther = (Cs) other;

		return (this.getCs().equals(castOther.getCs()));
	}
}
