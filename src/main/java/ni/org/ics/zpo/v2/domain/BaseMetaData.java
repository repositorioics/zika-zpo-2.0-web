package ni.org.ics.zpo.v2.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass 
public class BaseMetaData implements Serializable 
{  

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date recordDate;
	private String recordUser;
	private char pasive = '0';
	//Manejo ODK
	private Integer idInstancia;
	private String instancePath;
	private String estado;
	//Metadata del formulario movil
	private String start;
	private String end;
	private String deviceid;
	private String simserial;
	private String phonenumber;
	private Date today;	
	
	public BaseMetaData() {

	}

	public BaseMetaData(Date recordDate, String recordUser) {
		super();
		this.recordDate = recordDate;
		this.recordUser = recordUser;
	}

	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="FECHA_REGISTRO")
	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	@Column(name="USUARIO_REGISTRO", length = 50)
	public String getRecordUser() {
		return recordUser;
	}

	public void setRecordUser(String recordUser) {
		this.recordUser = recordUser;
	}
	
	@Column(name="PASIVO", nullable = false, length = 1)
	public char getPasive() {
		return pasive;
	}

	public void setPasive(char pasive) {
		this.pasive = pasive;
	}

	@Column(name="id_instancia", length = 4)
	public Integer getIdInstancia() {
		return idInstancia;
	}

	public void setIdInstancia(Integer idInstancia) {
		this.idInstancia = idInstancia;
	}

	@Column(name="instance_path", length = 255)
	public String getInstancePath() {
		return instancePath;
	}

	public void setInstancePath(String instancePath) {
		this.instancePath = instancePath;
	}

	@Column(name="estado", length = 50)
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Column(name="start", length = 100)
	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	@Column(name="end", length = 100)
	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	@Column(name="identificador_equipo", length = 100)
	public String getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}

	@Column(name="simserial", length = 100)
	public String getSimserial() {
		return simserial;
	}

	public void setSimserial(String simserial) {
		this.simserial = simserial;
	}

	@Column(name="phonenumber", length = 25)
	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	@Column(name="today")
	public Date getToday() {
		return today;
	}

	public void setToday(Date today) {
		this.today = today;
	}

}  
