package ni.org.ics.zpo.v2.domain.catalogs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "subject_type", catalog = "zika_zpo_v2")
public class SubjectType {
	private String subjectType;
	
	@Id
	@Column(name = "TIPO_SUJETO", nullable = false, length =50)
	public String getSubjectType() {
		return subjectType;
	}
	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType;
	}
	@Override
	public String toString(){
		return subjectType;
	}
	@Override
	public boolean equals(Object other) {
		
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SubjectType))
			return false;
		
		SubjectType castOther = (SubjectType) other;

		return (this.getSubjectType().equals(castOther.getSubjectType()));
	}
}
