package ni.org.ics.zpo.v2.utils;

import java.io.Serializable;

/**
 * Created by FIRSTICT on 11/25/2016.
 * V1.0
 */
public class ZpAgendaEmbarazada implements Serializable {

    private static final long serialVersionUID = 1L;
    String codigo;
    String fechaIngreso;
    String formulario;
    String fechaProgramacionCita;
    String evento;
    String fechaProgramada;
    String fechaCita;
    String horaCita;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFormulario() {
        return formulario;
    }

    public void setFormulario(String formulario) {
        this.formulario = formulario;
    }

    public String getFechaProgramacionCita() {
        return fechaProgramacionCita;
    }

    public void setFechaProgramacionCita(String fechaProgramacionCita) {
        this.fechaProgramacionCita = fechaProgramacionCita;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getFechaProgramada() {
        return fechaProgramada;
    }

    public void setFechaProgramada(String fechaProgramada) {
        this.fechaProgramada = fechaProgramada;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(String horaCita) {
        this.horaCita = horaCita;
    }
}
