package ni.org.ics.zpo.v2.domain.audit;

public interface Auditable {
	
	public boolean isFieldAuditable(String fieldname);

}
