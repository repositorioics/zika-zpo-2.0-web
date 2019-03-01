package ni.org.ics.zpo.v2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import ni.org.ics.zpo.v2.domain.audit.Auditable;

/**
 * Created by FIRSTICT on 10/6/2016.
 * V1.0
 */
@Entity
@Table(name = "zpo_estado_embarazada", catalog = "zika_zpo_v2")
public class ZpoEstadoEmbarazada extends BaseMetaData implements Auditable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String recordId;
	private char ingreso = '0';
	private char mes12 = '0';
	private char mes24 = '0';
	
	@Id
    @Column(name = "record_id", nullable = false, length = 25)
    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    @Column(name="ingreso", nullable = false, length = 1)
	public char getIngreso() {
		return ingreso;
	}

	public void setIngreso(char ingreso) {
		this.ingreso = ingreso;
	}

    @Column(name="mes12", nullable = false, length = 1)
    public char getMes12() {
        return mes12;
    }

    public void setMes12(char mes12) {
        this.mes12 = mes12;
    }

    @Column(name="mes24", nullable = false, length = 1)
	public char getMes24() {
		return mes24;
	}

	public void setMes24(char mes24) {
		this.mes24 = mes24;
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
		if (!(other instanceof ZpoEstadoEmbarazada))
			return false;
		
		ZpoEstadoEmbarazada castOther = (ZpoEstadoEmbarazada) other;

		return (this.getRecordId().equals(castOther.getRecordId()));
	}
	
    
}
