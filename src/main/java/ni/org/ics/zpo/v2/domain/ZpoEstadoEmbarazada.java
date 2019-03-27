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
	private char mes24 = '0';
	private char mes30 = '0';
    private char mes36 = '0';
    private char mes42 = '0';
    private char mes48 = '0';
    private char mes54 = '0';
    private char mes60 = '0';
    private char mes66 = '0';
    private char mes72 = '0';
    private char mes78 = '0';
    private char mes84 = '0';
	
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

    @Column(name="mes24", nullable = false, length = 1)
    public char getMes24() {
        return mes24;
    }

    public void setMes24(char mes12) {
        this.mes24 = mes12;
    }

    @Column(name="mes30", nullable = false, length = 1)
	public char getMes30() {
		return mes30;
	}

	public void setMes30(char mes24) {
		this.mes30 = mes24;
	}

    @Column(name="mes36", nullable = false, length = 1)
    public char getMes36() {
        return mes36;
    }

    public void setMes36(char mes36) {
        this.mes36 = mes36;
    }

    @Column(name="mes42", nullable = false, length = 1)
    public char getMes42() {
        return mes42;
    }

    public void setMes42(char mes42) {
        this.mes42 = mes42;
    }

    @Column(name="mes48", nullable = false, length = 1)
    public char getMes48() {
        return mes48;
    }

    public void setMes48(char mes48) {
        this.mes48 = mes48;
    }

    @Column(name="mes54", nullable = false, length = 1)
    public char getMes54() {
        return mes54;
    }

    public void setMes54(char mes54) {
        this.mes54 = mes54;
    }

    @Column(name="mes60", nullable = false, length = 1)
    public char getMes60() {
        return mes60;
    }

    public void setMes60(char mes60) {
        this.mes60 = mes60;
    }

    @Column(name="mes66", nullable = false, length = 1)
    public char getMes66() {
        return mes66;
    }

    public void setMes66(char mes66) {
        this.mes66 = mes66;
    }

    @Column(name="mes72", nullable = false, length = 1)
    public char getMes72() {
        return mes72;
    }

    public void setMes72(char mes72) {
        this.mes72 = mes72;
    }

    @Column(name="mes78", nullable = false, length = 1)
    public char getMes78() {
        return mes78;
    }

    public void setMes78(char mes78) {
        this.mes78 = mes78;
    }

    @Column(name="mes84", nullable = false, length = 1)
    public char getMes84() {
        return mes84;
    }

    public void setMes84(char mes84) {
        this.mes84 = mes84;
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
