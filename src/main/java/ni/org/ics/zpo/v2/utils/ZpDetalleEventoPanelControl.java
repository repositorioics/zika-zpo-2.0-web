package ni.org.ics.zpo.v2.utils;

import java.util.List;

/**
 * Created by FIRSTICT on 1/3/2017.
 * V1.0
 */
public class ZpDetalleEventoPanelControl {
    String codigo;
    String fechaIngreso;
    String evento;
    List<String[]> formularios;

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

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public List<String[]> getFormularios() {
        return formularios;
    }

    public void setFormularios(List<String[]> formularios) {
        this.formularios = formularios;
    }
}
