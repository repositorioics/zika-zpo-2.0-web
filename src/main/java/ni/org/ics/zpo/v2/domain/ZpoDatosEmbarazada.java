package ni.org.ics.zpo.v2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import ni.org.ics.zpo.v2.domain.audit.Auditable;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by FIRSTICT on 10/6/2016.
 * V1.0
 */
@Entity
@Table(name = "zpo_datos_embarazada", catalog = "zika_zpo")
public class ZpoDatosEmbarazada extends BaseMetaData implements Auditable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String recordId;
	private String cs;
	private String nombre1;
	private String nombre2;
	private String apellido1;
	private String apellido2;
	private Date fechaNac;
	private String direccion;
	private BigDecimal latitud;
	private BigDecimal longitud;
	private String telefonoContacto;

    @Id
    @Column(name = "record_id", nullable = false, length = 25)
    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    @Column(name = "cs", nullable = true, length = 100)
	public String getCs() {
		return cs;
	}

	public void setCs(String cs) {
		this.cs = cs;
	}

    @Column(name = "nombre1", nullable = true, length = 50)
	public String getNombre1() {
		return nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

    @Column(name = "nombre2", nullable = true, length = 50)
	public String getNombre2() {
		return nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

    @Column(name = "apellido1", nullable = true, length = 50)
	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

    @Column(name = "apellido2", nullable = true, length = 50)
	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

    @Column(name = "fecha_nacimiento", nullable = true)
	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

    @Column(name = "direccion", nullable = true)
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

    @Column(name = "latitud", nullable = true)
	public BigDecimal getLatitud() {
		return latitud;
	}

	public void setLatitud(BigDecimal latitud) {
		this.latitud = latitud;
	}

    @Column(name = "longitud", nullable = true)
	public BigDecimal getLongitud() {
		return longitud;
	}

	public void setLongitud(BigDecimal longitud) {
		this.longitud = longitud;
	}

    @Column(name = "telefono_contacto", nullable = true, length = 50)
	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	@Override
	public boolean isFieldAuditable(String fieldname) {
		// TODO Auto-generated method stub
		return false;
	}
    
	
    
    
}
