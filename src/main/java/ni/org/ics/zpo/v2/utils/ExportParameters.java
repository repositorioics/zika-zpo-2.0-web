package ni.org.ics.zpo.v2.utils;

/**
 * Created by FIRSTICT on 11/14/2016.
 * V1.0
 */
public class ExportParameters {

    private String tableName;
    private String codigoInicio;
    private String codigoFin;
    private String event;
    private boolean addHeader;

    public ExportParameters(String tableName, String codigoInicio, String codigoFin, String evento) {
        this.tableName = tableName;
        this.codigoInicio = codigoInicio;
        this.codigoFin = codigoFin;
        this.event = evento;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getCodigoInicio() {
        return codigoInicio;
    }

    public void setCodigoInicio(String codigoInicio) {
        this.codigoInicio = codigoInicio;
    }

    public String getCodigoFin() {
        return codigoFin;
    }

    public void setCodigoFin(String codigoFin) {
        this.codigoFin = codigoFin;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public boolean isAddHeader() {
        return addHeader;
    }

    public void setAddHeader(boolean addHeader) {
        this.addHeader = addHeader;
    }

    public boolean thereAreCodes(){
        return (this.getCodigoInicio()!=null && this.getCodigoFin() !=null && !this.getCodigoInicio().isEmpty() && !this.getCodigoFin().isEmpty());
    }
}
