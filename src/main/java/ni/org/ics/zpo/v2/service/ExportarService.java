package ni.org.ics.zpo.v2.service;

import ni.org.ics.zpo.v2.utils.ConnectionUtil;
import ni.org.ics.zpo.v2.utils.Constants;
import ni.org.ics.zpo.v2.utils.ExportParameters;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * Created by FIRSTICT on 11/10/2016.
 * V1.0
 */
@Service("exportarService")
@Transactional
public class ExportarService {

    private static final String SEPARADOR = ",";
    private static final String SALTOLINEA = "\n";
    private static final String ENTER = "\r\n";
    private static final String QUOTE = "\"";
    private static final String COMILLA = "\"";
    private static final String ESPACIO = " ";

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public List<String> getRedCapEvents() {
        List<String> redCapEvents = new ArrayList<String>();
        redCapEvents.add(Constants.SCREENING);
        redCapEvents.add(Constants.MONTHS24);
        redCapEvents.add(Constants.MONTHS30);
        redCapEvents.add(Constants.MONTHS36);
        redCapEvents.add(Constants.MONTHS42);
        redCapEvents.add(Constants.MONTHS48);
        redCapEvents.add(Constants.MONTHS54);
        redCapEvents.add(Constants.MONTHS60);
        redCapEvents.add(Constants.MONTHS66);
        redCapEvents.add(Constants.MONTHS72);
        redCapEvents.add(Constants.MONTHS78);
        redCapEvents.add(Constants.MONTHS84);
        redCapEvents.add(Constants.EXIT);
        redCapEvents.add(Constants.INFEXIT);
        return redCapEvents;
    }

    public List<String> getEventsExport() {
        List<String> redCapEvents = new ArrayList<String>();
        redCapEvents.add(Constants.MONTHS24);
        redCapEvents.add(Constants.MONTHS30);
        redCapEvents.add(Constants.MONTHS36);
        redCapEvents.add(Constants.MONTHS42);
        redCapEvents.add(Constants.MONTHS48);
        redCapEvents.add(Constants.MONTHS54);
        redCapEvents.add(Constants.MONTHS60);
        redCapEvents.add(Constants.MONTHS66);
        redCapEvents.add(Constants.MONTHS72);
        redCapEvents.add(Constants.MONTHS78);
        redCapEvents.add(Constants.MONTHS84);
        redCapEvents.add(Constants.EXIT);
        redCapEvents.add(Constants.INFEXIT);
        return redCapEvents;
    }

    private List<String> getTableMetaData(String tableName) throws Exception {
        Connection con = ConnectionUtil.getConnection();
        List<String> columns = new ArrayList<String>();
        try {
            DatabaseMetaData meta = con.getMetaData();
            ResultSet res = meta.getColumns(null, null, tableName, null);
            while (res.next()) {
                //excluir estos campos
                if (!res.getString("COLUMN_NAME").equalsIgnoreCase("identificador_equipo") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("end") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("estado") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("id_instancia") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("instance_path") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("PASIVO") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("phonenumber") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("FECHA_REGISTRO") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("USUARIO_REGISTRO") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("simserial") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("start") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("age_at_testing_msel") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("cogn_t_score_sum") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("atender_visita_psych") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("ayudar_amigas_psych") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("banar_hijo_psych") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("banarse_psych") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("cocinar_psych") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("compartir_info_psych") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("cuidar_cabello_psych") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("funcionamiento_puntaje_psych") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("juntar_mujeres_psych") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("lavar_dientes_psych") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("lavar_ropa_psych") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("limpiar_psych") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("mercado_psych") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("score_depression_psych") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("sintomas_puntaje_psych") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("tareas_salud_psych") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("trabajar_psych") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("usar_ropa_limpia_psych") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("vestir_hijo_psych") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("abnormal_results") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("area_comunicacion") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("area_motorafina") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("area_motoragruesa") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("area_socioindividual") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("area_solucionproblemas") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("event_name") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("idCompleted") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("child_exam_circumstances") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("today")) {
                    if (res.getString("COLUMN_NAME").equalsIgnoreCase("record_id") && !columns.isEmpty()) {
                        //el record_id siempre debe ser el primer campo
                        String columnaTmp = columns.get(0);
                        columns.set(0, res.getString("COLUMN_NAME"));
                        columns.add(columnaTmp);
                    } else {
                        columns.add(res.getString("COLUMN_NAME"));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null)
                con.close();
        }
        return columns;
    }

    private List<String> getTableMetaDataCuestSaInf(String tableName) throws Exception {
        Connection con = ConnectionUtil.getConnection();
        List<String> columns = new ArrayList<String>();
        try {
            DatabaseMetaData meta = con.getMetaData();
            ResultSet res = meta.getColumns(null, null, tableName, null);
            while (res.next()) {
                //excluir estos campos
                if (!res.getString("COLUMN_NAME").equalsIgnoreCase("identificador_equipo") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("end") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("estado") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("id_instancia") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("instance_path") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("PASIVO") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("phonenumber") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("FECHA_REGISTRO") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("USUARIO_REGISTRO") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("simserial") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("start") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("today") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("descripcion_prob_neuro_nino_upd") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("event_name") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("problema_comer_nino_upd")) {
                    if (res.getString("COLUMN_NAME").equalsIgnoreCase("record_id") && !columns.isEmpty()) {
                        //el record_id siempre debe ser el primer campo
                        String columnaTmp = columns.get(0);
                        columns.set(0, res.getString("COLUMN_NAME"));
                        columns.add(columnaTmp);
                    } else {
                        columns.add(res.getString("COLUMN_NAME"));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null)
                con.close();
        }
        return columns;
    }

    private List<String> getTableMetaDataCuestSaInfUpd(String tableName) throws Exception {
        Connection con = ConnectionUtil.getConnection();
        List<String> columns = new ArrayList<String>();
        try {
            DatabaseMetaData meta = con.getMetaData();
            ResultSet res = meta.getColumns(null, null, tableName, null);
            while (res.next()) {
                //excluir estos campos
                if (!res.getString("COLUMN_NAME").equalsIgnoreCase("identificador_equipo") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("end") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("estado") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("id_instancia") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("instance_path") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("PASIVO") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("phonenumber") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("FECHA_REGISTRO") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("USUARIO_REGISTRO") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("simserial") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("start") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("today") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("amamantando_nino") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("circunferencia_nacer_nino") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("edad_gestacional_nino") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("fecha_amamantar_nino") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("ocurrio_embarazo_nino") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("parto_multiple_nino") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("peso_nacer_nino") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("prob_embarazo_nino") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("prob_embarazo_otro_nino") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("problemas_bebe_nino") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("problemas_extrem_nino") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("problemas_lactancia_nino") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("talla_nacer_nino") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("event_name") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("transfusion_nino_upd")) {
                    if (res.getString("COLUMN_NAME").equalsIgnoreCase("record_id") && !columns.isEmpty()) {
                        //el record_id siempre debe ser el primer campo
                        String columnaTmp = columns.get(0);
                        columns.set(0, res.getString("COLUMN_NAME"));
                        columns.add(columnaTmp);
                    } else {
                        columns.add(res.getString("COLUMN_NAME"));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null)
                con.close();
        }
        return columns;
    }

    private List<String> getTableMetaDataCuestSaMat(String tableName) throws Exception {
        Connection con = ConnectionUtil.getConnection();
        List<String> columns = new ArrayList<String>();
        try {
            DatabaseMetaData meta = con.getMetaData();
            ResultSet res = meta.getColumns(null, null, tableName, null);
            while (res.next()) {
                //excluir estos campos
                if (!res.getString("COLUMN_NAME").equalsIgnoreCase("identificador_equipo") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("end") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("estado") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("id_instancia") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("instance_path") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("PASIVO") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("phonenumber") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("FECHA_REGISTRO") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("USUARIO_REGISTRO") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("simserial") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("start") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("today") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("event_name") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("embarazada_visita_maternal_upd") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("dado_luz_maternal_upd")) {
                    if (res.getString("COLUMN_NAME").equalsIgnoreCase("record_id") && !columns.isEmpty()) {
                        //el record_id siempre debe ser el primer campo
                        String columnaTmp = columns.get(0);
                        columns.set(0, res.getString("COLUMN_NAME"));
                        columns.add(columnaTmp);
                    } else {
                        columns.add(res.getString("COLUMN_NAME"));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null)
                con.close();
        }
        return columns;
    }

    private List<String> getTableMetaDataCuestSaMatUpd(String tableName) throws Exception {
        Connection con = ConnectionUtil.getConnection();
        List<String> columns = new ArrayList<String>();
        try {
            DatabaseMetaData meta = con.getMetaData();
            ResultSet res = meta.getColumns(null, null, tableName, null);
            while (res.next()) {
                //excluir estos campos
                if (!res.getString("COLUMN_NAME").equalsIgnoreCase("identificador_equipo") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("end") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("estado") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("id_instancia") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("instance_path") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("PASIVO") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("phonenumber") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("FECHA_REGISTRO") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("USUARIO_REGISTRO") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("simserial") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("start") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("today") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("alcohol_embar_maternal") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("defecto_genetico1_maternal") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("defecto_genetico2_maternal") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("defectos_geneticos_maternal") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("frecuencia_alcohol_maternal") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("fumo_embara_maternal") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("hijos_vivos_maternal") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("otro_defecto_maternal") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("otro_problema_maternal") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("prob_fuera_embar_maternal") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("quien_defecto1_maternal") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("quien_defecto2_maternal") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("event_name") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("veces_embarazada_maternal")) {
                    if (res.getString("COLUMN_NAME").equalsIgnoreCase("record_id") && !columns.isEmpty()) {
                        //el record_id siempre debe ser el primer campo
                        String columnaTmp = columns.get(0);
                        columns.set(0, res.getString("COLUMN_NAME"));
                        columns.add(columnaTmp);
                    } else {
                        columns.add(res.getString("COLUMN_NAME"));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null)
                con.close();
        }
        return columns;
    }

    private List<String> getTableMetaDataCuestDemoUpd(String tableName) throws Exception {
        Connection con = ConnectionUtil.getConnection();
        List<String> columns = new ArrayList<String>();
        try {
            DatabaseMetaData meta = con.getMetaData();
            ResultSet res = meta.getColumns(null, null, tableName, null);
            while (res.next()) {
                //excluir estos campos
                if (!res.getString("COLUMN_NAME").equalsIgnoreCase("identificador_equipo") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("end") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("estado") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("id_instancia") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("instance_path") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("PASIVO") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("phonenumber") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("FECHA_REGISTRO") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("USUARIO_REGISTRO") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("simserial") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("start") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("today") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("codigo_madre_demogr") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("escolaridad_madre_demogr") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("escolaridad_padre_demogr") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("etnicidad_demogr") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("fecha_nacimiento_madre_demogr") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("fecha_nacimiento_nino_demogr") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("fecha_nacimiento_padre_demogr") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("nombre_madre_demogr") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("nombre_nino_demogr") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("nombre_padre_demogr") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("raza_demogr") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("sexo_demogr") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("event_name") &&
                        !res.getString("COLUMN_NAME").equalsIgnoreCase("ubicacion_casa_demogr")) {
                    if (res.getString("COLUMN_NAME").equalsIgnoreCase("record_id") && !columns.isEmpty()) {
                        //el record_id siempre debe ser el primer campo
                        String columnaTmp = columns.get(0);
                        columns.set(0, res.getString("COLUMN_NAME"));
                        columns.add(columnaTmp);
                    } else {
                        columns.add(res.getString("COLUMN_NAME"));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null)
                con.close();
        }
        return columns;
    }

    public StringBuffer getZpoV2CuestDemoExportData(ExportParameters exportParameters) throws Exception {

        StringBuffer sb = new StringBuffer();
        Connection con = ConnectionUtil.getConnection();
        PreparedStatement pStatement = null;
        ResultSet res = null;
        String columnas = "";
        String valores = "";

        try {
            //recuperar los nombres de las columnas
            List<String> columns = getTableMetaData(exportParameters.getTableName());
            columnas = parseColumns(columns);

            //pasar a recuperar los datos. Setear parámetro si los hay
            StringBuilder sqlStrBuilder = new StringBuilder();
            sqlStrBuilder.append("select ").append(columnas).append(" from ").append(exportParameters.getTableName()).append(" where 1=1 ");

            if (exportParameters.thereAreCodes()) sqlStrBuilder.append(" and record_id between ? and ? ");
            if (!exportParameters.getEvent().equalsIgnoreCase("all")) {
                sqlStrBuilder.append(" and event_name = ?");
            }

          //  pStatement = con.prepareStatement(sqlStrBuilder.toString());
            pStatement = con.prepareStatement(sqlStrBuilder.toString().replaceAll("record_id", "substring(record_id,1,7) as record_id"));
            if (exportParameters.thereAreCodes()) {
                pStatement.setString(1, exportParameters.getCodigoInicio());
                pStatement.setString(2, exportParameters.getCodigoFin());
            }
            if (!exportParameters.getEvent().equalsIgnoreCase("all"))
                pStatement.setString(exportParameters.thereAreCodes() ? 3 : 1, exportParameters.getEvent());

            res = pStatement.executeQuery();

            //Columnas que necesita redcap y no estan en la tabla
            columnas = columnas.replaceAll("record_id", "study_id");
           // columnas = columnas.replaceAll("event_name", "redcap_event_name");
            columnas += SEPARADOR + "demographics_questionnaire_complete";

            sb.append(columnas);
            sb.append(SALTOLINEA);

            while (res.next()) {
                for (String col : columns) {
                    Object val = res.getObject(col);
                    if (val != null) {
                        if (val instanceof String) {
                            String valFormat = val.toString().replaceAll(ENTER, ESPACIO).replaceAll(SALTOLINEA, ESPACIO);
                            //si contiene uno de estos caracteres especiales escapar
                            if (valFormat.contains(SEPARADOR) || valFormat.contains(COMILLA) || valFormat.contains(SALTOLINEA)) {
                                valores += SEPARADOR + QUOTE + valFormat.trim() + QUOTE;
                            } else {
                                if (valores.isEmpty()) valores += valFormat.trim();
                                else valores += SEPARADOR + valFormat.trim();
                            }
                        } else if (val instanceof Integer) {
                            if (valores.isEmpty()) valores += String.valueOf(res.getInt(col));
                            else valores += SEPARADOR + String.valueOf(res.getInt(col));

                        } else if (val instanceof java.util.Date) {
                            if (valores.isEmpty()) valores += DateToString(res.getDate(col), "dd/MM/yyyy");
                            else valores += SEPARADOR + DateToString(res.getDate(col), "dd/MM/yyyy");

                        } else if (val instanceof Float) {
                            if (valores.isEmpty()) valores += String.valueOf(res.getFloat(col));
                            else valores += SEPARADOR + String.valueOf(res.getFloat(col));
                        }

                    } else {
                        valores += SEPARADOR;
                    }
                }
                //valor para demographics_questionnaire_complete
                valores += SEPARADOR + "1";
                sb.append(valores);
                valores = "";
                sb.append(SALTOLINEA);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (res != null) res.close();
            if (pStatement != null) pStatement.close();
            if (con != null) con.close();
        }
        return sb;
    }

    public StringBuffer getZpoV2CuestDemoUpdExportData(ExportParameters exportParameters) throws Exception {

        StringBuffer sb = new StringBuffer();
        Connection con = ConnectionUtil.getConnection();
        PreparedStatement pStatement = null;
        ResultSet res = null;
        String columnas = "";
        String valores = "";

        try {
            //recuperar los nombres de las columnas
            List<String> columns = getTableMetaDataCuestDemoUpd(exportParameters.getTableName());
            columnas = parseColumns(columns);

            //pasar a recuperar los datos. Setear parámetro si los hay
            StringBuilder sqlStrBuilder = new StringBuilder();
            sqlStrBuilder.append("select ").append(columnas).append(" from ").append(exportParameters.getTableName()).append(" where 1=1 ");

            if (exportParameters.thereAreCodes()) sqlStrBuilder.append(" and record_id between ? and ? ");
            if (!exportParameters.getEvent().equalsIgnoreCase("all")) {
                sqlStrBuilder.append(" and event_name = ?");
            }

         //   pStatement = con.prepareStatement(sqlStrBuilder.toString());
            pStatement = con.prepareStatement(sqlStrBuilder.toString().replaceAll("record_id", "substring(record_id,1,7) as record_id"));
            if (exportParameters.thereAreCodes()) {
                pStatement.setString(1, exportParameters.getCodigoInicio());
                pStatement.setString(2, exportParameters.getCodigoFin());
            }
            if (!exportParameters.getEvent().equalsIgnoreCase("all"))
                pStatement.setString(exportParameters.thereAreCodes() ? 3 : 1, exportParameters.getEvent());

            res = pStatement.executeQuery();
            //Valores de campos múltiples

          //  columnas = columnas.replaceAll("event_name", "redcap_event_name");
            columnas = columnas.replaceAll("fecha_de_hoy_demogr", "fecha_hoy_demogr_upd");
            columnas = columnas.replaceAll("direccion_barrio_demogr", "barrio_demogr_upd");
            columnas = columnas.replaceAll("direccion_exacta_demogr", "direccion_demogr_upd");
            columnas = columnas.replaceAll("direccion_color_casa_demogr", "color_casa_demogr_upd");
            columnas = columnas.replaceAll("numeros_telefonicos_demogr", "numero_telefonico_demogr_upd");
            columnas = columnas.replaceAll("numero_celular_demogr", "celular_demogr_upd");
            columnas = columnas.replaceAll("estado_civil_demogr", "estado_civil_demogr_upd");
            columnas = columnas.replaceAll("nombre_encuestador_demogr", "encuestador_demogr_upd");

            columnas += SEPARADOR + "demographics_update_complete";

            sb.append(columnas);
            sb.append(SALTOLINEA);

            while (res.next()) {
                for (String col : columns) {
                    Object val = res.getObject(col);
                    if (val != null) {
                        if (val instanceof String) {
                            String valFormat = val.toString().replaceAll(ENTER, ESPACIO).replaceAll(SALTOLINEA, ESPACIO);
                            //si contiene uno de estos caracteres especiales escapar
                            if (valFormat.contains(SEPARADOR) || valFormat.contains(COMILLA) || valFormat.contains(SALTOLINEA)) {
                                valores += SEPARADOR + QUOTE + valFormat.trim() + QUOTE;
                            } else {
                                if (valores.isEmpty()) valores += valFormat.trim();
                                else valores += SEPARADOR + valFormat.trim();
                            }
                        } else if (val instanceof Integer) {
                            if (valores.isEmpty()) valores += String.valueOf(res.getInt(col));
                            else valores += SEPARADOR + String.valueOf(res.getInt(col));

                        } else if (val instanceof java.util.Date) {
                            if (valores.isEmpty()) valores += DateToString(res.getDate(col), "dd/MM/yyyy");
                            else valores += SEPARADOR + DateToString(res.getDate(col), "dd/MM/yyyy");

                        } else if (val instanceof Float) {
                            if (valores.isEmpty()) valores += String.valueOf(res.getFloat(col));
                            else valores += SEPARADOR + String.valueOf(res.getFloat(col));
                        }

                    } else {
                        valores += SEPARADOR;
                    }
                }
                //valor para demographics_update_complete
                valores += SEPARADOR + "1";
                sb.append(valores);
                valores = "";
                sb.append(SALTOLINEA);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (res != null) res.close();
            if (pStatement != null) pStatement.close();
            if (con != null) con.close();
        }
        return sb;
    }

    public StringBuffer getZpoV2StudyExitExportData(ExportParameters exportParameters) throws Exception {

        StringBuffer sb = new StringBuffer();
        Connection con = ConnectionUtil.getConnection();
        PreparedStatement pStatement = null;
        ResultSet res = null;
        String columnas = "";
        String valores = "";

        try {
            //recuperar los nombres de las columnas
            List<String> columns = getTableMetaData(exportParameters.getTableName());
            columnas = parseColumns(columns);

            //pasar a recuperar los datos. Setear parámetro si los hay
            StringBuilder sqlStrBuilder = new StringBuilder();
            sqlStrBuilder.append("select ").append(columnas).append(" from ").append(exportParameters.getTableName()).append(" where 1=1 ");

            if (exportParameters.thereAreCodes()) sqlStrBuilder.append(" and record_id between ? and ? ");
            if (!exportParameters.getEvent().equalsIgnoreCase("all")) {
                sqlStrBuilder.append(" and event_name = ?");
            }

          //  pStatement = con.prepareStatement(sqlStrBuilder.toString());
            pStatement = con.prepareStatement(sqlStrBuilder.toString().replaceAll("record_id", "substring(record_id,1,7) as record_id"));
            if (exportParameters.thereAreCodes()) {
                pStatement.setString(1, exportParameters.getCodigoInicio());
                pStatement.setString(2, exportParameters.getCodigoFin());
            }
            if (!exportParameters.getEvent().equalsIgnoreCase("all"))
                pStatement.setString(exportParameters.thereAreCodes() ? 3 : 1, exportParameters.getEvent());

            res = pStatement.executeQuery();

            //Columnas que necesita redcap y no estan en la tabla
            columnas = columnas.replaceAll("record_id", "codigo_identifica_discont");
          //  columnas = columnas.replaceAll("event_name", "redcap_event_name");
            columnas += SEPARADOR + "discontinuation_form_complete";

            sb.append(columnas);
            sb.append(SALTOLINEA);

            while (res.next()) {
                for (String col : columns) {
                    Object val = res.getObject(col);
                    if (val != null) {
                        if (val instanceof String) {
                            String valFormat = val.toString().replaceAll(ENTER, ESPACIO).replaceAll(SALTOLINEA, ESPACIO);
                            //si contiene uno de estos caracteres especiales escapar
                            if (valFormat.contains(SEPARADOR) || valFormat.contains(COMILLA) || valFormat.contains(SALTOLINEA)) {
                                valores += SEPARADOR + QUOTE + valFormat.trim() + QUOTE;
                            } else {
                                if (valores.isEmpty()) valores += valFormat.trim();
                                else valores += SEPARADOR + valFormat.trim();
                            }
                        } else if (val instanceof Integer) {
                            if (valores.isEmpty()) valores += String.valueOf(res.getInt(col));
                            else valores += SEPARADOR + String.valueOf(res.getInt(col));

                        } else if (val instanceof java.util.Date) {
                            if (valores.isEmpty()) valores += DateToString(res.getDate(col), "dd/MM/yyyy");
                            else valores += SEPARADOR + DateToString(res.getDate(col), "dd/MM/yyyy");

                        } else if (val instanceof Float) {
                            if (valores.isEmpty()) valores += String.valueOf(res.getFloat(col));
                            else valores += SEPARADOR + String.valueOf(res.getFloat(col));
                        }

                    } else {
                        valores += SEPARADOR;
                    }
                }
                //valor para discontinuation_form_complete
                valores += SEPARADOR + "1";
                sb.append(valores);
                valores = "";
                sb.append(SALTOLINEA);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (res != null) res.close();
            if (pStatement != null) pStatement.close();
            if (con != null) con.close();
        }
        return sb;
    }

    public StringBuffer getZpoV2CuestSocioExportData(ExportParameters exportParameters) throws Exception {

        StringBuffer sb = new StringBuffer();
        Connection con = ConnectionUtil.getConnection();
        PreparedStatement pStatement = null;
        ResultSet res = null;
        String columnas = "";
        String valores = "";

        try {
            //recuperar los nombres de las columnas
            List<String> columns = getTableMetaData(exportParameters.getTableName());
            columnas = parseColumns(columns);

            //pasar a recuperar los datos. Setear parámetro si los hay
            StringBuilder sqlStrBuilder = new StringBuilder();
            sqlStrBuilder.append("select ").append(columnas).append(" from ").append(exportParameters.getTableName()).append(" where 1=1 ");

            if (exportParameters.thereAreCodes()) sqlStrBuilder.append(" and record_id between ? and ? ");
            if (!exportParameters.getEvent().equalsIgnoreCase("all")) {
                sqlStrBuilder.append(" and event_name = ?");
            }

           // pStatement = con.prepareStatement(sqlStrBuilder.toString());
            pStatement = con.prepareStatement(sqlStrBuilder.toString().replaceAll("record_id", "substring(record_id,1,7) as record_id"));
            if (exportParameters.thereAreCodes()) {
                pStatement.setString(1, exportParameters.getCodigoInicio());
                pStatement.setString(2, exportParameters.getCodigoFin());
            }
            if (!exportParameters.getEvent().equalsIgnoreCase("all"))
                pStatement.setString(exportParameters.thereAreCodes() ? 3 : 1, exportParameters.getEvent());

            res = pStatement.executeQuery();
            //Valores de campos múltiples
            String[] paredesCasa = "1,2,3,4,5,6,7,8".split(",");
            String[] fuenteAgua = "1,2,3,4,5,6,7,8".split(",");
            String[] tipoBano = "1,2,3,4".split(",");
            String[] piso = "1,2,3,4,5,6".split(",");
            String[] animales = "1,2,3,4,5,6,7,8,9,10".split(",");

            //Columnas que necesita redcap y no estan en la tabla
          //  columnas = columnas.replaceAll("event_name", "redcap_event_name");
            columnas = columnas.replaceAll("record_id", "study_id");
            columnas = columnas.replaceAll("paredes_casa_ses", "paredes_casa_ses___1,paredes_casa_ses___2,paredes_casa_ses___3,paredes_casa_ses___4,paredes_casa_ses___5,paredes_casa_ses___6,paredes_casa_ses___7, paredes_casa_ses___8");
            columnas = columnas.replaceAll("fuente_agua_ses", "fuente_agua_ses___1,fuente_agua_ses___2,fuente_agua_ses___3,fuente_agua_ses___4,fuente_agua_ses___5,fuente_agua_ses___6,fuente_agua_ses___7, fuente_agua_ses___8");
            columnas = columnas.replaceAll("tipo_bano_ses", "tipo_bano_ses___1,tipo_bano_ses___2,tipo_bano_ses___3,tipo_bano_ses___4");
            columnas = columnas.replaceAll("piso_ses", "piso_ses___1,piso_ses___2,piso_ses___3,piso_ses___4,piso_ses___5,piso_ses___6");
            columnas = columnas.replaceAll("animales_ses", "animales_ses___1,animales_ses___2,animales_ses___3,animales_ses___4,animales_ses___5,animales_ses___6,animales_ses___7,animales_ses___8,animales_ses___9,animales_ses___10");


            columnas += SEPARADOR + "socioeconomics_questionnaire_complete";

            sb.append(columnas);
            sb.append(SALTOLINEA);

            while (res.next()) {
                for (String col : columns) {
                    Object val = res.getObject(col);
                    if (val != null) {
                        if (col.equalsIgnoreCase("paredes_casa_ses")) {
                            valores += setValuesMultipleField(val.toString(), paredesCasa);

                        } else if (col.equalsIgnoreCase("fuente_agua_ses")) {
                            valores += setValuesMultipleField(val.toString(), fuenteAgua);

                        } else if (col.equalsIgnoreCase("tipo_bano_ses")) {
                            valores += setValuesMultipleField(val.toString(), tipoBano);

                        } else if (col.equalsIgnoreCase("piso_ses")) {
                            valores += setValuesMultipleField(val.toString(), piso);

                        } else if (col.equalsIgnoreCase("animales_ses")) {
                            valores += setValuesMultipleField(val.toString(), animales);

                        } else {
                            if (val instanceof String) {
                                String valFormat = val.toString().replaceAll(ENTER, ESPACIO).replaceAll(SALTOLINEA, ESPACIO);
                                //si contiene uno de estos caracteres especiales escapar
                                if (valFormat.contains(SEPARADOR) || valFormat.contains(COMILLA) || valFormat.contains(SALTOLINEA)) {
                                    valores += SEPARADOR + QUOTE + valFormat.trim() + QUOTE;
                                } else {
                                    if (valores.isEmpty()) valores += valFormat.trim();
                                    else valores += SEPARADOR + valFormat.trim();
                                }
                            } else if (val instanceof Integer) {
                                if (valores.isEmpty()) valores += String.valueOf(res.getInt(col));
                                else valores += SEPARADOR + String.valueOf(res.getInt(col));

                            } else if (val instanceof java.util.Date) {
                                if (valores.isEmpty()) valores += DateToString(res.getDate(col), "dd/MM/yyyy");
                                else valores += SEPARADOR + DateToString(res.getDate(col), "dd/MM/yyyy");

                            } else if (val instanceof Float) {
                                if (valores.isEmpty()) valores += String.valueOf(res.getFloat(col));
                                else valores += SEPARADOR + String.valueOf(res.getFloat(col));
                            }
                        }
                    } else {
                        if (col.equalsIgnoreCase("paredes_casa_ses")) {
                            for (int i = 0; i < paredesCasa.length; i++) {
                                valores += SEPARADOR;
                            }
                        } else if (col.equalsIgnoreCase("fuente_agua_ses")) {
                            for (int i = 0; i < fuenteAgua.length; i++) {
                                valores += SEPARADOR;
                            }
                        } else if (col.equalsIgnoreCase("tipo_bano_ses")) {
                            for (int i = 0; i < tipoBano.length; i++) {
                                valores += SEPARADOR;
                            }
                        } else if (col.equalsIgnoreCase("piso_ses")) {
                            for (int i = 0; i < piso.length; i++) {
                                valores += SEPARADOR;
                            }
                        } else if (col.equalsIgnoreCase("animales_ses")) {
                            for (int i = 0; i < animales.length; i++) {
                                valores += SEPARADOR;
                            }
                        } else {
                            valores += SEPARADOR;
                        }
                    }
                }
                //valor para socioeconomics_questionnaire_complete
                valores += SEPARADOR + "1";
                sb.append(valores);
                valores = "";
                sb.append(SALTOLINEA);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (res != null) res.close();
            if (pStatement != null) pStatement.close();
            if (con != null) con.close();
        }
        return sb;
    }

    public StringBuffer getZpoV2CuestSaInfExportData(ExportParameters exportParameters) throws Exception {

        StringBuffer sb = new StringBuffer();
        Connection con = ConnectionUtil.getConnection();
        PreparedStatement pStatement = null;
        ResultSet res = null;
        String columnas = "";
        String valores = "";

        try {
            //recuperar los nombres de las columnas
            List<String> columns = getTableMetaDataCuestSaInf(exportParameters.getTableName());
            columnas = parseColumns(columns);

            //pasar a recuperar los datos. Setear parámetro si los hay
            StringBuilder sqlStrBuilder = new StringBuilder();
            sqlStrBuilder.append("select ").append(columnas).append(" from ").append(exportParameters.getTableName()).append(" where 1=1 ");

            if (exportParameters.thereAreCodes()) sqlStrBuilder.append(" and record_id between ? and ? ");
            if (!exportParameters.getEvent().equalsIgnoreCase("all")) {
                sqlStrBuilder.append(" and event_name = ?");
            }

          //  pStatement = con.prepareStatement(sqlStrBuilder.toString());
            pStatement = con.prepareStatement(sqlStrBuilder.toString().replaceAll("record_id", "substring(record_id,1,7) as record_id"));
            if (exportParameters.thereAreCodes()) {
                pStatement.setString(1, exportParameters.getCodigoInicio());
                pStatement.setString(2, exportParameters.getCodigoFin());
            }
            if (!exportParameters.getEvent().equalsIgnoreCase("all"))
                pStatement.setString(exportParameters.thereAreCodes() ? 3 : 1, exportParameters.getEvent());

            res = pStatement.executeQuery();

            //Valores de campos múltiples
            String[] problemaEmbarazoNino = "1,2,3,4,5,6,7,8".split(",");
            String[] ocurrioEmbarazoNino = "1,2,3,4,5".split(",");
            String[] problemasBebeNino = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16".split(",");
            String[] parteDiaAfueraNino = "1,2,3,4,5".split(",");
            String[] problemasNino = "1,2,3,4,5,6,7,8,9,10,11,12,13".split(",");

            //columnas que necesita redcap y no estan en la tabla
            columnas = columnas.replaceAll("record_id", "study_id");
            columnas = columnas.replaceAll("prob_embarazo_nino", "prob_embarazo_nino___1,prob_embarazo_nino___2,prob_embarazo_nino___3,prob_embarazo_nino___4,prob_embarazo_nino___5,prob_embarazo_nino___6,prob_embarazo_nino___7,prob_embarazo_nino___8");
            columnas = columnas.replaceAll("ocurrio_embarazo_nino", "ocurrio_embarazo_nino___1,ocurrio_embarazo_nino___2,ocurrio_embarazo_nino___3,ocurrio_embarazo_nino___4,ocurrio_embarazo_nino___5");
            columnas = columnas.replaceAll("problemas_bebe_nino", "problemas_bebe_nino___1,problemas_bebe_nino___2,problemas_bebe_nino___3,problemas_bebe_nino___4,problemas_bebe_nino___5,problemas_bebe_nino___6,problemas_bebe_nino___7,problemas_bebe_nino___8,problemas_bebe_nino___9,problemas_bebe_nino___10,problemas_bebe_nino___11,problemas_bebe_nino___12,problemas_bebe_nino___13,problemas_bebe_nino___14,problemas_bebe_nino___15,problemas_bebe_nino___16");
            columnas = columnas.replaceAll("parte_dia_afuera_nino", "parte_dia_afuera_nino___1,parte_dia_afuera_nino___2,parte_dia_afuera_nino___3,parte_dia_afuera_nino___4,parte_dia_afuera_nino___5");
            columnas = columnas.replaceAll("problemas_nino", "problemas_nino___1,problemas_nino___2,problemas_nino___3,problemas_nino___4,problemas_nino___5,problemas_nino___6,problemas_nino___7,problemas_nino___8,problemas_nino___9,problemas_nino___10,problemas_nino___11,problemas_nino___12,problemas_nino___13");

            //columnas = columnas.replaceAll("event_name", "redcap_event_name");
            columnas += SEPARADOR + "child_health_questionnaire_complete";

            sb.append(columnas);
            sb.append(SALTOLINEA);

            while (res.next()) {
                for (String col : columns) {
                    Object val = res.getObject(col);
                    if (val != null) {
                        if (col.equalsIgnoreCase("prob_embarazo_nino")) {
                            valores += setValuesMultipleField(val.toString(), problemaEmbarazoNino);

                        } else if (col.equalsIgnoreCase("ocurrio_embarazo_nino")) {
                            valores += setValuesMultipleField(val.toString(), ocurrioEmbarazoNino);

                        } else if (col.equalsIgnoreCase("problemas_bebe_nino")) {
                            valores += setValuesMultipleField(val.toString(), problemasBebeNino);

                        } else if (col.equalsIgnoreCase("parte_dia_afuera_nino")) {
                            valores += setValuesMultipleField(val.toString(), parteDiaAfueraNino);

                        } else if (col.equalsIgnoreCase("problemas_nino")) {
                            valores += setValuesMultipleField(val.toString(), problemasNino);

                        } else {
                            if (val instanceof String) {
                                String valFormat = val.toString().replaceAll(ENTER, ESPACIO).replaceAll(SALTOLINEA, ESPACIO);
                                //si contiene uno de estos caracteres especiales escapar
                                if (valFormat.contains(SEPARADOR) || valFormat.contains(COMILLA) || valFormat.contains(SALTOLINEA)) {
                                    valores += SEPARADOR + QUOTE + valFormat.trim() + QUOTE;
                                } else {
                                    if (valores.isEmpty()) valores += valFormat.trim();
                                    else valores += SEPARADOR + valFormat.trim();
                                }
                            } else if (val instanceof Integer) {
                                if (valores.isEmpty()) valores += String.valueOf(res.getInt(col));
                                else valores += SEPARADOR + String.valueOf(res.getInt(col));

                            } else if (val instanceof java.util.Date) {
                                if (valores.isEmpty()) valores += DateToString(res.getDate(col), "dd/MM/yyyy");
                                else valores += SEPARADOR + DateToString(res.getDate(col), "dd/MM/yyyy");

                            } else if (val instanceof Float) {
                                if (valores.isEmpty()) valores += String.valueOf(res.getFloat(col));
                                else valores += SEPARADOR + String.valueOf(res.getFloat(col));
                            }
                        }
                    } else {
                        if (col.equalsIgnoreCase("prob_embarazo_nino")) {
                            for (int i = 0; i < problemaEmbarazoNino.length; i++) {
                                valores += SEPARADOR;
                            }
                        } else if (col.equalsIgnoreCase("ocurrio_embarazo_nino")) {
                            for (int i = 0; i < ocurrioEmbarazoNino.length; i++) {
                                valores += SEPARADOR;
                            }
                        } else if (col.equalsIgnoreCase("problemas_bebe_nino")) {
                            for (int i = 0; i < problemasBebeNino.length; i++) {
                                valores += SEPARADOR;
                            }

                        } else if (col.equalsIgnoreCase("parte_dia_afuera_nino")) {
                            for (int i = 0; i < parteDiaAfueraNino.length; i++) {
                                valores += SEPARADOR;
                            }
                        } else if (col.equalsIgnoreCase("problemas_nino")) {
                            for (int i = 0; i < problemasNino.length; i++) {
                                valores += SEPARADOR;
                            }
                        } else {
                            valores += SEPARADOR;
                        }
                    }
                }
                //valor para child_health_questionnaire_complete
                valores += SEPARADOR + "1";
                sb.append(valores);
                valores = "";
                sb.append(SALTOLINEA);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (res != null) res.close();
            if (pStatement != null) pStatement.close();
            if (con != null) con.close();
        }
        return sb;
    }

    public StringBuffer getZpoV2CuestSaInfUpdExportData(ExportParameters exportParameters) throws Exception {

        StringBuffer sb = new StringBuffer();
        Connection con = ConnectionUtil.getConnection();
        PreparedStatement pStatement = null;
        ResultSet res = null;
        String columnas = "";
        String valores = "";

        try {
            //recuperar los nombres de las columnas
            List<String> columns = getTableMetaDataCuestSaInfUpd(exportParameters.getTableName());
            columnas = parseColumns(columns);

            //pasar a recuperar los datos. Setear parámetro si los hay
            StringBuilder sqlStrBuilder = new StringBuilder();
            sqlStrBuilder.append("select ").append(columnas).append(" from ").append(exportParameters.getTableName()).append(" where 1=1 ");

            if (exportParameters.thereAreCodes()) sqlStrBuilder.append(" and record_id between ? and ? ");
            if (!exportParameters.getEvent().equalsIgnoreCase("all")) {
                sqlStrBuilder.append(" and event_name = ?");
            }

          //  pStatement = con.prepareStatement(sqlStrBuilder.toString());
            pStatement = con.prepareStatement(sqlStrBuilder.toString().replaceAll("record_id", "substring(record_id,1,7) as record_id"));
            if (exportParameters.thereAreCodes()) {
                pStatement.setString(1, exportParameters.getCodigoInicio());
                pStatement.setString(2, exportParameters.getCodigoFin());
            }
            if (!exportParameters.getEvent().equalsIgnoreCase("all"))
                pStatement.setString(exportParameters.thereAreCodes() ? 3 : 1, exportParameters.getEvent());

            res = pStatement.executeQuery();

            //Valores de campos múltiples
            String[] parteDiaAfueraNino = "1,2,3,4,5".split(",");
            String[] problemasNino = "1,2,3,4,5,6,7,8,9,10,11,12,13".split(",");

            //columnas que necesita redcap y no estan en la tabla
            columnas = columnas.replaceAll("record_id", "study_id");
            columnas = columnas.replaceAll("parte_dia_afuera_nino", "parte_dia_afuera_nino_upd___1,parte_dia_afuera_nino_upd___2,parte_dia_afuera_nino_upd___3,parte_dia_afuera_nino_upd___4,parte_dia_afuera_nino_upd___5");
            columnas = columnas.replaceAll("problemas_nino", "problemas_nino_upd___1,problemas_nino_upd___2,problemas_nino_upd___3,problemas_nino_upd___4,problemas_nino_upd___5,problemas_nino_upd___6,problemas_nino_upd___7,problemas_nino_upd___8,problemas_nino_upd___9,problemas_nino_upd___10,problemas_nino_upd___11,problemas_nino_upd___12,problemas_nino_upd___13");

          //  columnas = columnas.replaceAll("event_name", "redcap_event_name");
          /*  columnas = columnas.replaceAll("fecha_hoy_nino", "fecha_hoy_nino_upd");
            columnas = columnas.replaceAll("vision_prob_nino", "prob_vision_nino_upd");
            columnas = columnas.replaceAll("vision_describa_nino", "describa_vision_nino_upd");
            columnas = columnas.replaceAll("audicion_prob_nino", "prob_auditivo_nino_upd");
            columnas = columnas.replaceAll("audicion_describa_nino", "describa_auditivo_nino_upd");
            columnas = columnas.replaceAll("neuro_prob_nino", "prob_neuro_nino_upd");
            columnas = columnas.replaceAll("medicamento_nino", "algun_medicam_nino_upd");
            columnas = columnas.replaceAll("medicamento_lista_nino", "medicamentos_nino_upd");
            columnas = columnas.replaceAll("tiempo_fuera_nino", "tiempo_fuera_nino_upd");
            columnas = columnas.replaceAll("quien_cuida_nino", "quien_cuida_nino_upd");
            columnas = columnas.replaceAll("mayoria_tiempo_nino", "donde_pasa_nino_upd");
            columnas = columnas.replaceAll("picaduras_nino", "nino_picaduras_nino_upd");
            columnas = columnas.replaceAll("mosquitero_dormir_nino", "mosquitero_dormir_nino_upd");
            columnas = columnas.replaceAll("mosquitero_frecuencia_nino", "mosquitero_frecuen_nino_upd");
            columnas = columnas.replaceAll("repelente_insectos_nino", "repelente_insectos_nino_upd");
            columnas = columnas.replaceAll("repelente_frecuencia_nino", "repelente_frecuen_nino_upd");
            columnas = columnas.replaceAll("ministerio_fuera_nino", "ministerio_afuera_nino_upd");
            columnas = columnas.replaceAll("ultima_vez_fuera_nino", "ultima_vez_fuera_nino_upd");
            columnas = columnas.replaceAll("ministerio_dentro_nino", "ministerio_dentro_nino_upd");
            columnas = columnas.replaceAll("ultima_vez_dentro_nino", "ultima_vez_dentro_nino_upd");
            columnas = columnas.replaceAll("aplica_abate_nino", "aplica_abate_nino_upd");
            columnas = columnas.replaceAll("ultima_vez_abate_nino", "ultima_vez_abate_nino_upd");
            columnas = columnas.replaceAll("insecticida_ambiental_nino", "insecticida_ambiental_nino_upd");
            columnas = columnas.replaceAll("ultima_vez_insecticida_nino", "ultima_vez_insect_nino_upd");
            columnas = columnas.replaceAll("fiebre_amarilla_nino", "fiebre_amarilla_nino_upd");
            columnas = columnas.replaceAll("fecha_fiebre_amarilla_nino", "fecha_fiebre_amar_nino_upd");
            columnas = columnas.replaceAll("transfusion_sangre_nino", "transfusion_nino_upd");
            columnas = columnas.replaceAll("fecha_transfusion_nino", "fecha_transfusion_nino_upd");
            columnas = columnas.replaceAll("paises_fuera_nino", "paises_fuera_nino_upd");
            columnas = columnas.replaceAll("donde_pais_afuera_nino", "donde_afuera_nino_upd");
            columnas = columnas.replaceAll("fuera_managua_nino", "fuera_managua_nino_upd");
            columnas = columnas.replaceAll("adonde_fuera_managua_nino", "donde_managua_nino_upd");
            columnas = columnas.replaceAll("visto_medico_nino", "visto_medico_nino_upd");
            columnas = columnas.replaceAll("motivo_medico_nino", "motivo_medico_nino_upd");
            columnas = columnas.replaceAll("visita_enfermedad_nino", "visita_enfermedad_nino_upd");
            columnas = columnas.replaceAll("problemas_otro_nino", "problemas_otro_nino_upd");
            columnas = columnas.replaceAll("diagnosticado_zika_nino", "diagnosticado_zika_nino_upd");
            columnas = columnas.replaceAll("fecha_zika_nino", "fecha_zika_nino_upd");
            columnas = columnas.replaceAll("diagnos_chikungunya_nino", "diagnos_chikungunya_nino_upd");
            columnas = columnas.replaceAll("fecha_chikungunya_nino", "fecha_chikungunya_nino_upd");
            columnas = columnas.replaceAll("diagnosticado_dengue_nino", "diagnosticado_dengue_nino_upd");
            columnas = columnas.replaceAll("fecha_dengue_nino", "fecha_dengue_nino_upd");
            columnas = columnas.replaceAll("nombre_encuestador_nino", "encuestador_nino_upd");*/

            columnas += SEPARADOR + "child_health_update_complete";

            sb.append(columnas);
            sb.append(SALTOLINEA);

            while (res.next()) {
                for (String col : columns) {
                    Object val = res.getObject(col);
                    if (val != null) {
                        if (col.equalsIgnoreCase("parte_dia_afuera_nino")) {
                            valores += setValuesMultipleField(val.toString(), parteDiaAfueraNino);

                        } else if (col.equalsIgnoreCase("problemas_nino")) {
                            valores += setValuesMultipleField(val.toString(), problemasNino);

                        } else {
                            if (val instanceof String) {
                                String valFormat = val.toString().replaceAll(ENTER, ESPACIO).replaceAll(SALTOLINEA, ESPACIO);
                                //si contiene uno de estos caracteres especiales escapar
                                if (valFormat.contains(SEPARADOR) || valFormat.contains(COMILLA) || valFormat.contains(SALTOLINEA)) {
                                    valores += SEPARADOR + QUOTE + valFormat.trim() + QUOTE;
                                } else {
                                    if (valores.isEmpty()) valores += valFormat.trim();
                                    else valores += SEPARADOR + valFormat.trim();
                                }
                            } else if (val instanceof Integer) {
                                if (valores.isEmpty()) valores += String.valueOf(res.getInt(col));
                                else valores += SEPARADOR + String.valueOf(res.getInt(col));

                            } else if (val instanceof java.util.Date) {
                                if (valores.isEmpty()) valores += DateToString(res.getDate(col), "dd/MM/yyyy");
                                else valores += SEPARADOR + DateToString(res.getDate(col), "dd/MM/yyyy");

                            } else if (val instanceof Float) {
                                if (valores.isEmpty()) valores += String.valueOf(res.getFloat(col));
                                else valores += SEPARADOR + String.valueOf(res.getFloat(col));
                            }
                        }
                    } else {
                        if (col.equalsIgnoreCase("parte_dia_afuera_nino")) {
                            for (int i = 0; i < parteDiaAfueraNino.length; i++) {
                                valores += SEPARADOR;
                            }
                        } else if (col.equalsIgnoreCase("problemas_nino")) {
                            for (int i = 0; i < problemasNino.length; i++) {
                                valores += SEPARADOR;
                            }
                        } else {
                            valores += SEPARADOR;
                        }
                    }
                }
                //valor para child_health_update_complete
                valores += SEPARADOR + "1";
                sb.append(valores);
                valores = "";
                sb.append(SALTOLINEA);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (res != null) res.close();
            if (pStatement != null) pStatement.close();
            if (con != null) con.close();
        }
        return sb;
    }

    public StringBuffer getZpoV2ExamFisInfExportData(ExportParameters exportParameters) throws Exception {

        StringBuffer sb = new StringBuffer();
        Connection con = ConnectionUtil.getConnection();
        PreparedStatement pStatement = null;
        ResultSet res = null;
        String columnas = "";
        String valores = "";

        try {
            //recuperar los nombres de las columnas
            List<String> columns = getTableMetaData(exportParameters.getTableName());
            columnas = parseColumns(columns);

            //pasar a recuperar los datos. Setear parámetro si los hay
            StringBuilder sqlStrBuilder = new StringBuilder();
            sqlStrBuilder.append("select ").append(columnas).append(" from ").append(exportParameters.getTableName()).append(" where 1=1 ");

            if (exportParameters.thereAreCodes()) sqlStrBuilder.append(" and record_id between ? and ? ");
            if (!exportParameters.getEvent().equalsIgnoreCase("all")) {
                sqlStrBuilder.append(" and event_name = ?");
            }

           // pStatement = con.prepareStatement(sqlStrBuilder.toString());
            pStatement = con.prepareStatement(sqlStrBuilder.toString().replaceAll("record_id", "substring(record_id,1,7) as record_id"));
            if (exportParameters.thereAreCodes()) {
                pStatement.setString(1, exportParameters.getCodigoInicio());
                pStatement.setString(2, exportParameters.getCodigoFin());
            }
            if (!exportParameters.getEvent().equalsIgnoreCase("all"))
                pStatement.setString(exportParameters.thereAreCodes() ? 3 : 1, exportParameters.getEvent());

            res = pStatement.executeQuery();

            //Valores de campos múltiples
            String[] childExamOptho = "1,2,3".split(",");

            //columnas que necesita redcap y no estan en la tabla
            columnas = columnas.replaceAll("record_id", "study_id");
            columnas = columnas.replaceAll("child_exam_optho_fiding", "child_exam_optho_fiding___1,child_exam_optho_fiding___2,child_exam_optho_fiding___3");

            columnas += SEPARADOR + "child_physical_exam_complete";

            sb.append(columnas);
            sb.append(SALTOLINEA);

            while (res.next()) {
                for (String col : columns) {
                    Object val = res.getObject(col);
                    if (val != null) {
                        if (col.equalsIgnoreCase("child_exam_optho_fiding")) {
                            valores += setValuesMultipleField(val.toString(), childExamOptho);

                        } else {
                            if (val instanceof String) {
                                String valFormat = val.toString().replaceAll(ENTER, ESPACIO).replaceAll(SALTOLINEA, ESPACIO);
                                //si contiene uno de estos caracteres especiales escapar
                                if (valFormat.contains(SEPARADOR) || valFormat.contains(COMILLA) || valFormat.contains(SALTOLINEA)) {
                                    valores += SEPARADOR + QUOTE + valFormat.trim() + QUOTE;
                                } else {
                                    if (valores.isEmpty()) valores += valFormat.trim();
                                    else valores += SEPARADOR + valFormat.trim();
                                }
                            } else if (val instanceof Integer) {
                                if (valores.isEmpty()) valores += String.valueOf(res.getInt(col));
                                else valores += SEPARADOR + String.valueOf(res.getInt(col));

                            } else if (val instanceof java.util.Date) {
                                if (valores.isEmpty()) valores += DateToString(res.getDate(col), "dd/MM/yyyy");
                                else valores += SEPARADOR + DateToString(res.getDate(col), "dd/MM/yyyy");

                            } else if (val instanceof Float) {
                                if (valores.isEmpty()) valores += String.valueOf(res.getFloat(col));
                                else valores += SEPARADOR + String.valueOf(res.getFloat(col));
                            }
                        }
                    } else {
                        if (col.equalsIgnoreCase("child_exam_optho_fiding")) {
                            for (int i = 0; i < childExamOptho.length; i++) {
                                valores += SEPARADOR;
                            }
                        } else {
                            valores += SEPARADOR;
                        }
                    }
                }
                //valor para child_health_update_complete
                valores += SEPARADOR + "1";
                sb.append(valores);
                valores = "";
                sb.append(SALTOLINEA);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (res != null) res.close();
            if (pStatement != null) pStatement.close();
            if (con != null) con.close();
        }
        return sb;
    }

    public StringBuffer getZpoV2CuestSaMatExportData(ExportParameters exportParameters) throws Exception {

        StringBuffer sb = new StringBuffer();
        Connection con = ConnectionUtil.getConnection();
        PreparedStatement pStatement = null;
        ResultSet res = null;
        String columnas = "";
        String valores = "";

        try {
            //recuperar los nombres de las columnas
            List<String> columns = getTableMetaDataCuestSaMat(exportParameters.getTableName());
            columnas = parseColumns(columns);

            //pasar a recuperar los datos. Setear parámetro si los hay
            StringBuilder sqlStrBuilder = new StringBuilder();
            sqlStrBuilder.append("select ").append(columnas).append(" from ").append(exportParameters.getTableName()).append(" where 1=1 ");

            if (exportParameters.thereAreCodes()) sqlStrBuilder.append(" and record_id between ? and ? ");
            if (!exportParameters.getEvent().equalsIgnoreCase("all")) {
                sqlStrBuilder.append(" and event_name = ?");
            }

           // pStatement = con.prepareStatement(sqlStrBuilder.toString());
            pStatement = con.prepareStatement(sqlStrBuilder.toString().replaceAll("record_id", "substring(record_id,1,7) as record_id"));
            if (exportParameters.thereAreCodes()) {
                pStatement.setString(1, exportParameters.getCodigoInicio());
                pStatement.setString(2, exportParameters.getCodigoFin());
            }
            if (!exportParameters.getEvent().equalsIgnoreCase("all"))
                pStatement.setString(exportParameters.thereAreCodes() ? 3 : 1, exportParameters.getEvent());

            res = pStatement.executeQuery();

            columnas = columnas.replaceAll("record_id", "study_id");
            //columnas que necesita redcap y no estan en la tabla
         //   columnas = columnas.replaceAll("event_name", "redcap_event_name");

            columnas += SEPARADOR + "maternal_health_questionnaire_complete";

            sb.append(columnas);
            sb.append(SALTOLINEA);

            while (res.next()) {
                for (String col : columns) {
                    Object val = res.getObject(col);
                    if (val != null) {
                        if (val instanceof String) {
                            String valFormat = val.toString().replaceAll(ENTER, ESPACIO).replaceAll(SALTOLINEA, ESPACIO);
                            //si contiene uno de estos caracteres especiales escapar
                            if (valFormat.contains(SEPARADOR) || valFormat.contains(COMILLA) || valFormat.contains(SALTOLINEA)) {
                                valores += SEPARADOR + QUOTE + valFormat.trim() + QUOTE;
                            } else {
                                if (valores.isEmpty()) valores += valFormat.trim();
                                else valores += SEPARADOR + valFormat.trim();
                            }
                        } else if (val instanceof Integer) {
                            if (valores.isEmpty()) valores += String.valueOf(res.getInt(col));
                            else valores += SEPARADOR + String.valueOf(res.getInt(col));

                        } else if (val instanceof java.util.Date) {
                            if (valores.isEmpty()) valores += DateToString(res.getDate(col), "dd/MM/yyyy");
                            else valores += SEPARADOR + DateToString(res.getDate(col), "dd/MM/yyyy");

                        } else if (val instanceof Float) {
                            if (valores.isEmpty()) valores += String.valueOf(res.getFloat(col));
                            else valores += SEPARADOR + String.valueOf(res.getFloat(col));
                        }

                    } else {
                        valores += SEPARADOR;
                    }
                }
                //valor para maternal_health_questionnaire_complete
                valores += SEPARADOR + "1";
                sb.append(valores);
                valores = "";
                sb.append(SALTOLINEA);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (res != null) res.close();
            if (pStatement != null) pStatement.close();
            if (con != null) con.close();
        }
        return sb;
    }

    public StringBuffer getZpoV2CuestSaludMaternaUpdExportData(ExportParameters exportParameters) throws Exception {

        StringBuffer sb = new StringBuffer();
        Connection con = ConnectionUtil.getConnection();
        PreparedStatement pStatement = null;
        ResultSet res = null;
        String columnas = "";
        String valores = "";

        try {
            //recuperar los nombres de las columnas
            List<String> columns = getTableMetaDataCuestSaMatUpd(exportParameters.getTableName());
            columnas = parseColumns(columns);

            //pasar a recuperar los datos. Setear parámetro si los hay
            StringBuilder sqlStrBuilder = new StringBuilder();
            sqlStrBuilder.append("select ").append(columnas).append(" from ").append(exportParameters.getTableName()).append(" where 1=1 ");

            if (exportParameters.thereAreCodes()) sqlStrBuilder.append(" and record_id between ? and ? ");
            if (!exportParameters.getEvent().equalsIgnoreCase("all")) {
                sqlStrBuilder.append(" and event_name = ?");
            }

           // pStatement = con.prepareStatement(sqlStrBuilder.toString());
            pStatement = con.prepareStatement(sqlStrBuilder.toString().replaceAll("record_id", "substring(record_id,1,7) as record_id"));
            if (exportParameters.thereAreCodes()) {
                pStatement.setString(1, exportParameters.getCodigoInicio());
                pStatement.setString(2, exportParameters.getCodigoFin());
            }
            if (!exportParameters.getEvent().equalsIgnoreCase("all"))
                pStatement.setString(exportParameters.thereAreCodes() ? 3 : 1, exportParameters.getEvent());

            res = pStatement.executeQuery();

            //columnas que necesita redcap y no estan en la tabla
         //   columnas = columnas.replaceAll("event_name", "redcap_event_name");
            columnas = columnas.replaceAll("record_id", "study_id");
            /*columnas = columnas.replaceAll("fecha_hoy_maternal", "fecha_hoy_maternal_upd");
            columnas = columnas.replaceAll("fuma_cigarros_maternal", "cigarros_maternal_upd");
            columnas = columnas.replaceAll("toma_alcohol_maternal", "alcohol_maternal_upd");
            columnas = columnas.replaceAll("medicam_actual_maternal", "medicamento_maternal_upd");
            columnas = columnas.replaceAll("otro_medicam_maternal", "otro_medicamento_maternal_upd");
            columnas = columnas.replaceAll("nombre_encuestador_maternal", "encuestador_maternal_upd");*/

            columnas += SEPARADOR + "maternal_health_questionnaire_update_complete";

            sb.append(columnas);
            sb.append(SALTOLINEA);

            while (res.next()) {
                for (String col : columns) {
                    Object val = res.getObject(col);
                    if (val != null) {
                        if (val instanceof String) {
                            String valFormat = val.toString().replaceAll(ENTER, ESPACIO).replaceAll(SALTOLINEA, ESPACIO);
                            //si contiene uno de estos caracteres especiales escapar
                            if (valFormat.contains(SEPARADOR) || valFormat.contains(COMILLA) || valFormat.contains(SALTOLINEA)) {
                                valores += SEPARADOR + QUOTE + valFormat.trim() + QUOTE;
                            } else {
                                if (valores.isEmpty()) valores += valFormat.trim();
                                else valores += SEPARADOR + valFormat.trim();
                            }
                        } else if (val instanceof Integer) {
                            if (valores.isEmpty()) valores += String.valueOf(res.getInt(col));
                            else valores += SEPARADOR + String.valueOf(res.getInt(col));

                        } else if (val instanceof java.util.Date) {
                            if (valores.isEmpty()) valores += DateToString(res.getDate(col), "dd/MM/yyyy");
                            else valores += SEPARADOR + DateToString(res.getDate(col), "dd/MM/yyyy");

                        } else if (val instanceof Float) {
                            if (valores.isEmpty()) valores += String.valueOf(res.getFloat(col));
                            else valores += SEPARADOR + String.valueOf(res.getFloat(col));
                        }

                    } else {
                        valores += SEPARADOR;
                    }
                }
                //valor para maternal_health_questionnaire_update_complete
                valores += SEPARADOR + "1";
                sb.append(valores);
                valores = "";
                sb.append(SALTOLINEA);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (res != null) res.close();
            if (pStatement != null) pStatement.close();
            if (con != null) con.close();
        }
        return sb;
    }

    public StringBuffer getZpoV2IndCuidadoFamiliaExportData(ExportParameters exportParameters) throws Exception {

        StringBuffer sb = new StringBuffer();
        Connection con = ConnectionUtil.getConnection();
        PreparedStatement pStatement = null;
        ResultSet res = null;
        String columnas = "";
        String valores = "";

        try {
            //recuperar los nombres de las columnas
            List<String> columns = getTableMetaData(exportParameters.getTableName());
            columnas = parseColumns(columns);

            //pasar a recuperar los datos. Setear parámetro si los hay
            StringBuilder sqlStrBuilder = new StringBuilder();
            sqlStrBuilder.append("select ").append(columnas).append(" from ").append(exportParameters.getTableName()).append(" where 1=1 ");

            if (exportParameters.thereAreCodes()) sqlStrBuilder.append(" and record_id between ? and ? ");
            if (!exportParameters.getEvent().equalsIgnoreCase("all")) {
                sqlStrBuilder.append(" and event_name = ?");
            }

           // pStatement = con.prepareStatement(sqlStrBuilder.toString());
            pStatement = con.prepareStatement(sqlStrBuilder.toString().replaceAll("record_id", "substring(record_id,1,7) as record_id"));
            if (exportParameters.thereAreCodes()) {
                pStatement.setString(1, exportParameters.getCodigoInicio());
                pStatement.setString(2, exportParameters.getCodigoFin());
            }
            if (!exportParameters.getEvent().equalsIgnoreCase("all"))
                pStatement.setString(exportParameters.thereAreCodes() ? 3 : 1, exportParameters.getEvent());

            res = pStatement.executeQuery();

            //Valores de campos múltiples
            String[] materialesJugar = "1,2,3,4,5,6".split(",");
            String[] variedadJugar = "1,2,3,4,5,6,7,8,9".split(",");
            String[] actividadJugar = "1,2,3,4,5,6,7,8".split(",");

            //columnas que necesita redcap y no estan en la tabla
            columnas = columnas.replaceAll("record_id", "study_id");
            columnas = columnas.replaceAll("materiales_jugar_fci", "materiales_jugar_fci___1,materiales_jugar_fci___2,materiales_jugar_fci___3,materiales_jugar_fci___4,materiales_jugar_fci___5,materiales_jugar_fci___6");
            columnas = columnas.replaceAll("variedad_jugar_fci", "variedad_jugar_fci___1,variedad_jugar_fci___2,variedad_jugar_fci___3,variedad_jugar_fci___4,variedad_jugar_fci___5,variedad_jugar_fci___6,variedad_jugar_fci___7,variedad_jugar_fci___8,variedad_jugar_fci___9");
            columnas = columnas.replaceAll("actividades_jugar_fci", "actividades_jugar_fci___1,actividades_jugar_fci___2,actividades_jugar_fci___3,actividades_jugar_fci___4,actividades_jugar_fci___5,actividades_jugar_fci___6,actividades_jugar_fci___7,actividades_jugar_fci___8");


            columnas += SEPARADOR + "family_care_indicators_questionnaire_complete";

            sb.append(columnas);
            sb.append(SALTOLINEA);

            while (res.next()) {
                for (String col : columns) {
                    Object val = res.getObject(col);
                    if (val != null) {
                        if (col.equalsIgnoreCase("materiales_jugar_fci")) {
                            valores += setValuesMultipleField(val.toString(), materialesJugar);

                        } else if (col.equalsIgnoreCase("variedad_jugar_fci")) {
                            valores += setValuesMultipleField(val.toString(), variedadJugar);

                        } else if (col.equalsIgnoreCase("actividades_jugar_fci")) {
                            valores += setValuesMultipleField(val.toString(), actividadJugar);

                        } else {
                            if (val instanceof String) {
                                String valFormat = val.toString().replaceAll(ENTER, ESPACIO).replaceAll(SALTOLINEA, ESPACIO);
                                //si contiene uno de estos caracteres especiales escapar
                                if (valFormat.contains(SEPARADOR) || valFormat.contains(COMILLA) || valFormat.contains(SALTOLINEA)) {
                                    valores += SEPARADOR + QUOTE + valFormat.trim() + QUOTE;
                                } else {
                                    if (valores.isEmpty()) valores += valFormat.trim();
                                    else valores += SEPARADOR + valFormat.trim();
                                }
                            } else if (val instanceof Integer) {
                                if (valores.isEmpty()) valores += String.valueOf(res.getInt(col));
                                else valores += SEPARADOR + String.valueOf(res.getInt(col));

                            } else if (val instanceof java.util.Date) {
                                if (valores.isEmpty()) valores += DateToString(res.getDate(col), "dd/MM/yyyy");
                                else valores += SEPARADOR + DateToString(res.getDate(col), "dd/MM/yyyy");

                            } else if (val instanceof Float) {
                                if (valores.isEmpty()) valores += String.valueOf(res.getFloat(col));
                                else valores += SEPARADOR + String.valueOf(res.getFloat(col));
                            }
                        }
                    } else {
                        if (col.equalsIgnoreCase("materiales_jugar_fci")) {
                            for (int i = 0; i < materialesJugar.length; i++) {
                                valores += SEPARADOR;
                            }
                        } else if (col.equalsIgnoreCase("variedad_jugar_fci")) {
                            for (int i = 0; i < variedadJugar.length; i++) {
                                valores += SEPARADOR;
                            }
                        } else if (col.equalsIgnoreCase("actividades_jugar_fci")) {
                            for (int i = 0; i < actividadJugar.length; i++) {
                                valores += SEPARADOR;
                            }
                        } else {
                            valores += SEPARADOR;
                        }
                    }
                }
                //valor para family_care_indicators_questionnaire_complete
                valores += SEPARADOR + "1";
                sb.append(valores);
                valores = "";
                sb.append(SALTOLINEA);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (res != null) res.close();
            if (pStatement != null) pStatement.close();
            if (con != null) con.close();
        }
        return sb;
    }

    public StringBuffer getZpoV2MullenExportData(ExportParameters exportParameters) throws Exception {

        StringBuffer sb = new StringBuffer();
        Connection con = ConnectionUtil.getConnection();
        PreparedStatement pStatement = null;
        ResultSet res = null;
        String columnas = "";
        String valores = "";

        try {
            //recuperar los nombres de las columnas
            List<String> columns = getTableMetaData(exportParameters.getTableName());
            columnas = parseColumns(columns);

            //pasar a recuperar los datos. Setear parámetro si los hay
            StringBuilder sqlStrBuilder = new StringBuilder();
            sqlStrBuilder.append("select ").append(columnas).append(" from ").append(exportParameters.getTableName()).append(" where 1=1 ");

            if (exportParameters.thereAreCodes()) sqlStrBuilder.append(" and record_id between ? and ? ");
            if (!exportParameters.getEvent().equalsIgnoreCase("all")) {
                sqlStrBuilder.append(" and event_name = ?");
            }

            //pStatement = con.prepareStatement(sqlStrBuilder.toString());
            pStatement = con.prepareStatement(sqlStrBuilder.toString().replaceAll("record_id", "substring(record_id,1,7) as record_id"));
            if (exportParameters.thereAreCodes()) {
                pStatement.setString(1, exportParameters.getCodigoInicio());
                pStatement.setString(2, exportParameters.getCodigoFin());
            }
            if (!exportParameters.getEvent().equalsIgnoreCase("all"))
                pStatement.setString(exportParameters.thereAreCodes() ? 3 : 1, exportParameters.getEvent());

            res = pStatement.executeQuery();

            //Columnas que necesita redcap y no estan en la tabla
           // columnas = columnas.replaceAll("event_name", "redcap_event_name");
            columnas = columnas.replaceAll("record_id", "study_id");
            columnas += SEPARADOR + "mullen_msel_complete";

            sb.append(columnas);
            sb.append(SALTOLINEA);

            while (res.next()) {
                for (String col : columns) {
                    Object val = res.getObject(col);
                    if (val != null) {
                        if (val instanceof String) {
                            String valFormat = val.toString().replaceAll(ENTER, ESPACIO).replaceAll(SALTOLINEA, ESPACIO);
                            //si contiene uno de estos caracteres especiales escapar
                            if (valFormat.contains(SEPARADOR) || valFormat.contains(COMILLA) || valFormat.contains(SALTOLINEA)) {
                                valores += SEPARADOR + QUOTE + valFormat.trim() + QUOTE;
                            } else {
                                if (valores.isEmpty()) valores += valFormat.trim();
                                else valores += SEPARADOR + valFormat.trim();
                            }
                        } else if (val instanceof Integer) {
                            if (valores.isEmpty()) valores += String.valueOf(res.getInt(col));
                            else valores += SEPARADOR + String.valueOf(res.getInt(col));

                        } else if (val instanceof java.util.Date) {
                            if (valores.isEmpty()) valores += DateToString(res.getDate(col), "dd/MM/yyyy");
                            else valores += SEPARADOR + DateToString(res.getDate(col), "dd/MM/yyyy");

                        } else if (val instanceof Float) {
                            if (valores.isEmpty()) valores += String.valueOf(res.getFloat(col));
                            else valores += SEPARADOR + String.valueOf(res.getFloat(col));
                        }

                    } else {
                        valores += SEPARADOR;
                    }
                }
                //valor para mullen_msel_complete
                valores += SEPARADOR + "1";
                sb.append(valores);
                valores = "";
                sb.append(SALTOLINEA);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (res != null) res.close();
            if (pStatement != null) pStatement.close();
            if (con != null) con.close();
        }
        return sb;
    }

    public StringBuffer getZpoV2EvalVisualExportData(ExportParameters exportParameters) throws Exception {

        StringBuffer sb = new StringBuffer();
        Connection con = ConnectionUtil.getConnection();
        PreparedStatement pStatement = null;
        ResultSet res = null;
        String columnas = "";
        String valores = "";

        try {
            //recuperar los nombres de las columnas
            List<String> columns = getTableMetaData(exportParameters.getTableName());
            columnas = parseColumns(columns);

            //pasar a recuperar los datos. Setear parámetro si los hay
            StringBuilder sqlStrBuilder = new StringBuilder();
            sqlStrBuilder.append("select ").append(columnas).append(" from ").append(exportParameters.getTableName()).append(" where 1=1 ");

            if (exportParameters.thereAreCodes()) sqlStrBuilder.append(" and record_id between ? and ? ");
            if (!exportParameters.getEvent().equalsIgnoreCase("all")) {
                sqlStrBuilder.append(" and event_name = ?");
            }

           // pStatement = con.prepareStatement(sqlStrBuilder.toString());
            pStatement = con.prepareStatement(sqlStrBuilder.toString().replaceAll("record_id", "substring(record_id,1,7) as record_id"));
            if (exportParameters.thereAreCodes()) {
                pStatement.setString(1, exportParameters.getCodigoInicio());
                pStatement.setString(2, exportParameters.getCodigoFin());
            }
            if (!exportParameters.getEvent().equalsIgnoreCase("all"))
                pStatement.setString(exportParameters.thereAreCodes() ? 3 : 1, exportParameters.getEvent());

            res = pStatement.executeQuery();

            //columnas que necesita redcap y no estan en la tabla
          //  columnas = columnas.replaceAll("event_name", "redcap_event_name");
            columnas = columnas.replaceAll("record_id", "study_id");
            columnas = columnas.replaceAll("incapaz_nivel_joven_optho", "incapaz_nivel_joven_optho___1");
            columnas = columnas.replaceAll("semanas_optho", "semanas_optho___1");
            columnas = columnas.replaceAll("meses_3_optho", "meses_3_optho___1");
            columnas = columnas.replaceAll("meses_5_optho", "meses_5_optho___1");
            columnas = columnas.replaceAll("meses_7_optho", "meses_7_optho___1");
            columnas = columnas.replaceAll("meses_12_optho", "meses_12_optho___1");

            columnas += SEPARADOR + "ophthalmology_form_complete";

            sb.append(columnas);
            sb.append(SALTOLINEA);

            while (res.next()) {
                for (String col : columns) {
                    Object val = res.getObject(col);
                    if (val != null) {
                        if (val instanceof String) {
                            String valFormat = val.toString().replaceAll(ENTER, ESPACIO).replaceAll(SALTOLINEA, ESPACIO);
                            //si contiene uno de estos caracteres especiales escapar
                            if (valFormat.contains(SEPARADOR) || valFormat.contains(COMILLA) || valFormat.contains(SALTOLINEA)) {
                                valores += SEPARADOR + QUOTE + valFormat.trim() + QUOTE;
                            } else {
                                if (valores.isEmpty()) valores += valFormat.trim();
                                else valores += SEPARADOR + valFormat.trim();
                            }
                        } else if (val instanceof Integer) {
                            if (valores.isEmpty()) valores += String.valueOf(res.getInt(col));
                            else valores += SEPARADOR + String.valueOf(res.getInt(col));

                        } else if (val instanceof java.util.Date) {
                            if (valores.isEmpty()) valores += DateToString(res.getDate(col), "dd/MM/yyyy");
                            else valores += SEPARADOR + DateToString(res.getDate(col), "dd/MM/yyyy");

                        } else if (val instanceof Float) {
                            if (valores.isEmpty()) valores += String.valueOf(res.getFloat(col));
                            else valores += SEPARADOR + String.valueOf(res.getFloat(col));
                        }

                    } else {
                        valores += SEPARADOR;
                    }
                }
                //valor para ophthalmology_form_complete
                valores += SEPARADOR + "1";
                sb.append(valores);
                valores = "";
                sb.append(SALTOLINEA);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (res != null) res.close();
            if (pStatement != null) pStatement.close();
            if (con != null) con.close();
        }
        return sb;
    }

    public StringBuffer getZpoV2EvalAuditivaExportData(ExportParameters exportParameters) throws Exception {

        StringBuffer sb = new StringBuffer();
        Connection con = ConnectionUtil.getConnection();
        PreparedStatement pStatement = null;
        ResultSet res = null;
        String columnas = "";
        String valores = "";

        try {
            //recuperar los nombres de las columnas
            List<String> columns = getTableMetaData(exportParameters.getTableName());
            columnas = parseColumns(columns);

            //pasar a recuperar los datos. Setear parámetro si los hay
            StringBuilder sqlStrBuilder = new StringBuilder();
            sqlStrBuilder.append("select ").append(columnas).append(" from ").append(exportParameters.getTableName()).append(" where 1=1 ");

            if (exportParameters.thereAreCodes()) sqlStrBuilder.append(" and record_id between ? and ? ");
            if (!exportParameters.getEvent().equalsIgnoreCase("all")) {
                sqlStrBuilder.append(" and event_name = ?");
            }

          //  pStatement = con.prepareStatement(sqlStrBuilder.toString());
            pStatement = con.prepareStatement(sqlStrBuilder.toString().replaceAll("record_id", "substring(record_id,1,7) as record_id"));
            if (exportParameters.thereAreCodes()) {
                pStatement.setString(1, exportParameters.getCodigoInicio());
                pStatement.setString(2, exportParameters.getCodigoFin());
            }
            if (!exportParameters.getEvent().equalsIgnoreCase("all"))
                pStatement.setString(exportParameters.thereAreCodes() ? 3 : 1, exportParameters.getEvent());

            res = pStatement.executeQuery();

            //Valores de campos múltiples
            String[] haPadecidoAlguna = "1,2,3,4,5,6".split(",");

            //columnas que necesita redcap y no estan en la tabla
            columnas = columnas.replaceAll("record_id", "study_id");
            columnas = columnas.replaceAll("ha_padecido_de_alguna_de_l", "ha_padecido_de_alguna_de_l___1,ha_padecido_de_alguna_de_l___2,ha_padecido_de_alguna_de_l___3,ha_padecido_de_alguna_de_l___4,ha_padecido_de_alguna_de_l___5,ha_padecido_de_alguna_de_l___6");
          //  columnas = columnas.replaceAll("event_name", "redcap_event_name");
            columnas = columnas.replaceAll("record_id", "codigo_del_estudio");


            columnas += SEPARADOR + "hearing_form_complete";

            sb.append(columnas);
            sb.append(SALTOLINEA);

            while (res.next()) {
                for (String col : columns) {
                    Object val = res.getObject(col);
                    if (val != null) {
                        if (col.equalsIgnoreCase("ha_padecido_de_alguna_de_l")) {
                            valores += setValuesMultipleField(val.toString(), haPadecidoAlguna);

                        } else {
                            if (val instanceof String) {
                                String valFormat = val.toString().replaceAll(ENTER, ESPACIO).replaceAll(SALTOLINEA, ESPACIO);
                                //si contiene uno de estos caracteres especiales escapar
                                if (valFormat.contains(SEPARADOR) || valFormat.contains(COMILLA) || valFormat.contains(SALTOLINEA)) {
                                    valores += SEPARADOR + QUOTE + valFormat.trim() + QUOTE;
                                } else {
                                    if (valores.isEmpty()) valores += valFormat.trim();
                                    else valores += SEPARADOR + valFormat.trim();
                                }
                            } else if (val instanceof Integer) {
                                if (valores.isEmpty()) valores += String.valueOf(res.getInt(col));
                                else valores += SEPARADOR + String.valueOf(res.getInt(col));

                            } else if (val instanceof java.util.Date) {
                                if (valores.isEmpty()) valores += DateToString(res.getDate(col), "dd/MM/yyyy");
                                else valores += SEPARADOR + DateToString(res.getDate(col), "dd/MM/yyyy");

                            } else if (val instanceof Float) {
                                if (valores.isEmpty()) valores += String.valueOf(res.getFloat(col));
                                else valores += SEPARADOR + String.valueOf(res.getFloat(col));
                            }
                        }
                    } else {
                        if (col.equalsIgnoreCase("ha_padecido_de_alguna_de_l")) {
                            for (int i = 0; i < haPadecidoAlguna.length; i++) {
                                valores += SEPARADOR;
                            }
                        } else {
                            valores += SEPARADOR;
                        }
                    }
                }
                //valor para hearing_form_complete
                valores += SEPARADOR + "1";
                sb.append(valores);
                valores = "";
                sb.append(SALTOLINEA);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (res != null) res.close();
            if (pStatement != null) pStatement.close();
            if (con != null) con.close();
        }
        return sb;
    }

    public StringBuffer getZpoV2EvalPsicoExportData(ExportParameters exportParameters) throws Exception {

        StringBuffer sb = new StringBuffer();
        Connection con = ConnectionUtil.getConnection();
        PreparedStatement pStatement = null;
        ResultSet res = null;
        String columnas = "";
        String valores = "";

        try {
            //recuperar los nombres de las columnas
            List<String> columns = getTableMetaData(exportParameters.getTableName());
            columnas = parseColumns(columns);

            //pasar a recuperar los datos. Setear parámetro si los hay
            StringBuilder sqlStrBuilder = new StringBuilder();
            sqlStrBuilder.append("select ").append(columnas).append(" from ").append(exportParameters.getTableName()).append(" where 1=1 ");

            if (exportParameters.thereAreCodes()) sqlStrBuilder.append(" and record_id between ? and ? ");
            if (!exportParameters.getEvent().equalsIgnoreCase("all")) {
                sqlStrBuilder.append(" and event_name = ?");
            }

           // pStatement = con.prepareStatement(sqlStrBuilder.toString());
            pStatement = con.prepareStatement(sqlStrBuilder.toString().replaceAll("record_id", "substring(record_id,1,7) as record_id"));
            if (exportParameters.thereAreCodes()) {
                pStatement.setString(1, exportParameters.getCodigoInicio());
                pStatement.setString(2, exportParameters.getCodigoFin());
            }
            if (!exportParameters.getEvent().equalsIgnoreCase("all"))
                pStatement.setString(exportParameters.thereAreCodes() ? 3 : 1, exportParameters.getEvent());

            res = pStatement.executeQuery();

            //Columnas que necesita redcap y no estan en la tabla
           // columnas = columnas.replaceAll("event_name", "redcap_event_name");
            columnas = columnas.replaceAll("record_id", "study_id");
            columnas += SEPARADOR + "psychological_evaluation_complete";

            sb.append(columnas);
            sb.append(SALTOLINEA);

            while (res.next()) {
                for (String col : columns) {
                    Object val = res.getObject(col);
                    if (val != null) {
                        if (val instanceof String) {
                            String valFormat = val.toString().replaceAll(ENTER, ESPACIO).replaceAll(SALTOLINEA, ESPACIO);
                            //si contiene uno de estos caracteres especiales escapar
                            if (valFormat.contains(SEPARADOR) || valFormat.contains(COMILLA) || valFormat.contains(SALTOLINEA)) {
                                valores += SEPARADOR + QUOTE + valFormat.trim() + QUOTE;
                            } else {
                                if (valores.isEmpty()) valores += valFormat.trim();
                                else valores += SEPARADOR + valFormat.trim();
                            }
                        } else if (val instanceof Integer) {
                            if (valores.isEmpty()) valores += String.valueOf(res.getInt(col));
                            else valores += SEPARADOR + String.valueOf(res.getInt(col));

                        } else if (val instanceof java.util.Date) {
                            if (valores.isEmpty()) valores += DateToString(res.getDate(col), "dd/MM/yyyy");
                            else valores += SEPARADOR + DateToString(res.getDate(col), "dd/MM/yyyy");

                        } else if (val instanceof Float) {
                            if (valores.isEmpty()) valores += String.valueOf(res.getFloat(col));
                            else valores += SEPARADOR + String.valueOf(res.getFloat(col));
                        }

                    } else {
                        valores += SEPARADOR;
                    }
                }
                //valor para psychological_evaluation_complete
                valores += SEPARADOR + "1";
                sb.append(valores);
                valores = "";
                sb.append(SALTOLINEA);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (res != null) res.close();
            if (pStatement != null) pStatement.close();
            if (con != null) con.close();
        }
        return sb;
    }

    public StringBuffer getZpoV2EdadesEtapasExportData(ExportParameters exportParameters) throws Exception {

        StringBuffer sb = new StringBuffer();
        Connection con = ConnectionUtil.getConnection();
        PreparedStatement pStatement = null;
        ResultSet res = null;
        String columnas = "";
        String valores = "";

        try {
            //recuperar los nombres de las columnas
            List<String> columns = getTableMetaData(exportParameters.getTableName());
            columnas = parseColumns(columns);

            //pasar a recuperar los datos. Setear parámetro si los hay
            StringBuilder sqlStrBuilder = new StringBuilder();
            sqlStrBuilder.append("select ").append(columnas).append(" from ").append(exportParameters.getTableName()).append(" where 1=1 ");

            if (exportParameters.thereAreCodes()) sqlStrBuilder.append(" and record_id between ? and ? ");
            if (!exportParameters.getEvent().equalsIgnoreCase("all")) {
                sqlStrBuilder.append(" and event_name = ?");
            }


             pStatement = con.prepareStatement(sqlStrBuilder.toString());
            if (exportParameters.thereAreCodes()) {
                pStatement.setString(1, exportParameters.getCodigoInicio());
                pStatement.setString(2, exportParameters.getCodigoFin());
            }
            if (!exportParameters.getEvent().equalsIgnoreCase("all"))
                pStatement.setString(exportParameters.thereAreCodes() ? 3 : 1, exportParameters.getEvent());

            res = pStatement.executeQuery();


            //columnas que necesita redcap y no estan en la tabla
           // columnas = columnas.replaceAll("event_name", "redcap_event_name");
            columnas = columnas.replaceAll("record_id", "study_id");
            columnas += SEPARADOR + "asq3_42_meses_39_meses_0_das_a_44_meses_30_das_complete";

            sb.append(columnas);
            sb.append(SALTOLINEA);

            while (res.next()) {
                for (String col : columns) {
                    Object val = res.getObject(col);
                    if (val != null) {
                        if (val instanceof String) {
                            String valFormat = val.toString().replaceAll(ENTER, ESPACIO).replaceAll(SALTOLINEA, ESPACIO);
                            //si contiene uno de estos caracteres especiales escapar
                            if (valFormat.contains(SEPARADOR) || valFormat.contains(COMILLA) || valFormat.contains(SALTOLINEA)) {
                                valores += SEPARADOR + QUOTE + valFormat.trim() + QUOTE;
                            } else {
                                if (valores.isEmpty()) valores += valFormat.trim();
                                else valores += SEPARADOR + valFormat.trim();
                            }
                        } else if (val instanceof Integer) {
                            if (valores.isEmpty()) valores += String.valueOf(res.getInt(col));
                            else valores += SEPARADOR + String.valueOf(res.getInt(col));

                        } else if (val instanceof java.util.Date) {
                            if (valores.isEmpty()) valores += DateToString(res.getDate(col), "dd/MM/yyyy");
                            else valores += SEPARADOR + DateToString(res.getDate(col), "dd/MM/yyyy");

                        } else if (val instanceof Float) {
                            if (valores.isEmpty()) valores += String.valueOf(res.getFloat(col));
                            else valores += SEPARADOR + String.valueOf(res.getFloat(col));
                        }

                    } else {
                        valores += SEPARADOR;
                    }
                }
                //valor para asq3_42_meses_39_meses_0_das_a_44_meses_30_das_complete
                valores += SEPARADOR + "1";
                sb.append(valores);
                valores = "";
                sb.append(SALTOLINEA);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (res != null) res.close();
            if (pStatement != null) pStatement.close();
            if (con != null) con.close();
        }
        return sb;
    }

    public StringBuffer getZpoV2EdadesEtapas54ExportData(ExportParameters exportParameters) throws Exception {

        StringBuffer sb = new StringBuffer();
        Connection con = ConnectionUtil.getConnection();
        PreparedStatement pStatement = null;
        ResultSet res = null;
        String columnas = "";
        String valores = "";

        try {
            //recuperar los nombres de las columnas
            List<String> columns = getTableMetaData(exportParameters.getTableName());
            columnas = parseColumns(columns);

            //pasar a recuperar los datos. Setear parámetro si los hay
            StringBuilder sqlStrBuilder = new StringBuilder();
            sqlStrBuilder.append("select ").append(columnas).append(" from ").append(exportParameters.getTableName()).append(" where 1=1 ");

            if (exportParameters.thereAreCodes()) sqlStrBuilder.append(" and record_id between ? and ? ");
            if (!exportParameters.getEvent().equalsIgnoreCase("all")) {
                sqlStrBuilder.append(" and event_name = ?");
            }

            pStatement = con.prepareStatement(sqlStrBuilder.toString());
            //    pStatement = con.prepareStatement(sqlStrBuilder.toString().replaceAll("record_id", "substring(record_id,1,7) as record_id"));
            if (exportParameters.thereAreCodes()) {
                pStatement.setString(1, exportParameters.getCodigoInicio());
                pStatement.setString(2, exportParameters.getCodigoFin());
            }
            if (!exportParameters.getEvent().equalsIgnoreCase("all"))
                pStatement.setString(exportParameters.thereAreCodes() ? 3 : 1, exportParameters.getEvent());

            res = pStatement.executeQuery();


            //columnas que necesita redcap y no estan en la tabla
            // columnas = columnas.replaceAll("event_name", "redcap_event_name");

            columnas = columnas.replaceAll("record_id", "study_id");
            columnas += SEPARADOR + "asq3_54_meses_51_meses_0_das_a_56_meses_30_das_complete";

            sb.append(columnas);
            sb.append(SALTOLINEA);

            while (res.next()) {
                for (String col : columns) {
                    Object val = res.getObject(col);
                    if (val != null) {
                        if (val instanceof String) {
                            String valFormat = val.toString().replaceAll(ENTER, ESPACIO).replaceAll(SALTOLINEA, ESPACIO);
                            //si contiene uno de estos caracteres especiales escapar
                            if (valFormat.contains(SEPARADOR) || valFormat.contains(COMILLA) || valFormat.contains(SALTOLINEA)) {
                                valores += SEPARADOR + QUOTE + valFormat.trim() + QUOTE;
                            } else {
                                if (valores.isEmpty()) valores += valFormat.trim();
                                else valores += SEPARADOR + valFormat.trim();
                            }
                        } else if (val instanceof Integer) {
                            if (valores.isEmpty()) valores += String.valueOf(res.getInt(col));
                            else valores += SEPARADOR + String.valueOf(res.getInt(col));

                        } else if (val instanceof java.util.Date) {
                            if (valores.isEmpty()) valores += DateToString(res.getDate(col), "dd/MM/yyyy");
                            else valores += SEPARADOR + DateToString(res.getDate(col), "dd/MM/yyyy");

                        } else if (val instanceof Float) {
                            if (valores.isEmpty()) valores += String.valueOf(res.getFloat(col));
                            else valores += SEPARADOR + String.valueOf(res.getFloat(col));
                        }

                    } else {
                        valores += SEPARADOR;
                    }
                }
                //valor para asq3_54_meses_51_meses_0_das_a_56_meses_30_das_complete
                valores += SEPARADOR + "1";
                sb.append(valores);
                valores = "";
                sb.append(SALTOLINEA);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (res != null) res.close();
            if (pStatement != null) pStatement.close();
            if (con != null) con.close();
        }
        return sb;
    }

    public StringBuffer getZpoV2BiosCollExportData(ExportParameters exportParameters) throws Exception {

        StringBuffer sb = new StringBuffer();
        Connection con = ConnectionUtil.getConnection();
        PreparedStatement pStatement = null;
        ResultSet res = null;
        String columnas = "";
        String valores = "";

        try {
            //recuperar los nombres de las columnas
            List<String> columns = getTableMetaData(exportParameters.getTableName());
            columnas = parseColumns(columns);

            //pasar a recuperar los datos. Setear parámetro si los hay
            StringBuilder sqlStrBuilder = new StringBuilder();
            sqlStrBuilder.append("select ").append(columnas).append(" from ").append(exportParameters.getTableName()).append(" where 1=1 ");

            if (exportParameters.thereAreCodes()) sqlStrBuilder.append(" and record_id between ? and ? ");
            if (!exportParameters.getEvent().equalsIgnoreCase("all")) {
                sqlStrBuilder.append(" and event_name = ?");
            }

           // pStatement = con.prepareStatement(sqlStrBuilder.toString());

            pStatement = con.prepareStatement(sqlStrBuilder.toString().replaceAll("record_id", "substring(record_id,1,7) as record_id"));
            if (exportParameters.thereAreCodes()) {
                pStatement.setString(1, exportParameters.getCodigoInicio());
                pStatement.setString(2, exportParameters.getCodigoFin());
            }
            if (!exportParameters.getEvent().equalsIgnoreCase("all"))
                pStatement.setString(exportParameters.thereAreCodes() ? 3 : 1, exportParameters.getEvent());

            res = pStatement.executeQuery();

            //columnas que necesita redcap y no estan en la tabla
            columnas = columnas.replaceAll("record_id", "study_id");
          //  columnas = columnas.replaceAll("event_name", "redcap_event_name");

            columnas += SEPARADOR + "blood_sample_complete";

            sb.append(columnas);
            sb.append(SALTOLINEA);

            while (res.next()) {
                for (String col : columns) {
                    Object val = res.getObject(col);
                    if (val != null) {
                        if (val instanceof String) {
                            String valFormat = val.toString().replaceAll(ENTER, ESPACIO).replaceAll(SALTOLINEA, ESPACIO);
                            //si contiene uno de estos caracteres especiales escapar
                            if (valFormat.contains(SEPARADOR) || valFormat.contains(COMILLA) || valFormat.contains(SALTOLINEA)) {
                                valores += SEPARADOR + QUOTE + valFormat.trim() + QUOTE;
                            } else {
                                if (valores.isEmpty()) valores += valFormat.trim();
                                else valores += SEPARADOR + valFormat.trim();
                            }
                        } else if (val instanceof Integer) {
                            if (valores.isEmpty()) valores += String.valueOf(res.getInt(col));
                            else valores += SEPARADOR + String.valueOf(res.getInt(col));

                        } else if (val instanceof java.util.Date) {
                            if (valores.isEmpty()) valores += DateToString(res.getDate(col), "dd/MM/yyyy");
                            else valores += SEPARADOR + DateToString(res.getDate(col), "dd/MM/yyyy");

                        } else if (val instanceof Float) {
                            if (valores.isEmpty()) valores += String.valueOf(res.getFloat(col));
                            else valores += SEPARADOR + String.valueOf(res.getFloat(col));
                        }

                    } else {
                        valores += SEPARADOR;
                    }
                }
                //valor para blood_sample_complete
                valores += SEPARADOR + "1";
                sb.append(valores);
                valores = "";
                sb.append(SALTOLINEA);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (res != null) res.close();
            if (pStatement != null) pStatement.close();
            if (con != null) con.close();
        }
        return sb;
    }

    public StringBuffer getAllExportData(ExportParameters exportParameters) throws Exception {

        StringBuffer sb = new StringBuffer();
        Connection con = ConnectionUtil.getConnection();
        PreparedStatement pStatement = null;
        ResultSet res = null;
        String columnas = "study_id,redcap_event_name";

        try {
            //recuperar los nombres de las columnas de todas las tablas
            String[] tableNames = exportParameters.getTableName().split(",");
            List<String[]> allColumns = getAllTableMetaData(tableNames);
            List<String> participantes = getSubjects(exportParameters);
            List<String> registros = new ArrayList<String>();
            int primerRegistro = 0;

            //Valores de campos múltiples
            String[] paredesCasa = "1,2,3,4,5,6,7,8".split(",");
            String[] fuenteAgua = "1,2,3,4,5,6,7,8".split(",");
            String[] tipoBano = "1,2,3,4".split(",");
            String[] piso = "1,2,3,4,5,6".split(",");
            String[] animales = "1,2,3,4,5,6,7,8,9,10".split(",");

            String[] problemaEmbarazoNino = "1,2,3,4,5,6,7,8".split(",");
            String[] ocurrioEmbarazoNino = "1,2,3,4,5".split(",");
            String[] problemasBebeNino = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16".split(",");
            String[] parteDiaAfueraNino = "1,2,3,4,5".split(",");
            String[] problemasNino = "1,2,3,4,5,6,7,8,9,10,11,12,13".split(",");

            String[] parteDiaAfueraNinoUpd = "1,2,3,4,5".split(",");
            String[] problemasNinoUpd = "1,2,3,4,5,6,7,8,9,10,11,12,13".split(",");

            String[] childExamOptho = "1,2,3".split(",");

            String[] materialesJugar = "1,2,3,4,5,6".split(",");
            String[] variedadJugar = "1,2,3,4,5,6,7,8,9".split(",");
            String[] actividadJugar = "1,2,3,4,5,6,7,8".split(",");

            String[] haPadecidoAlguna = "1,2,3,4,5,6".split(",");

            //for (String redCapEvent : redCapEvents){
            for (String participante : participantes) {
                String valores = participante + SEPARADOR + exportParameters.getEvent();
                boolean existeDato = false;

                for (String tableName : tableNames) {
                    String columnasT = getTableColumns(allColumns, tableName);
                    boolean encontroRegistros = false;
                    //pasar a recuperar los datos. Setear parámetro si los hay
                    pStatement = con.prepareStatement("select " + columnasT + " from " + tableName + " where event_name = ?" + " and record_id = ? ");
                    pStatement.setString(1, exportParameters.getEvent());
                    pStatement.setString(2, participante);

                    res = pStatement.executeQuery();

                    String[] arrayColumnasT = columnasT.split(",");
                    while (res.next()) {
                        existeDato = true;
                        encontroRegistros = true;

                        for (String[] col : allColumns) {
                            if (existeColumna( col[1], arrayColumnasT )) {
                                Object val = null;
                                try {
                                    val = res.getObject(col[1]);
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                                if (val != null) {
                                    //campos que necesitan un trato especial
                                    //Cuestionario Socieconomico
                                    if (col[1].equalsIgnoreCase("paredes_casa_ses")) {
                                        valores += setValuesMultipleField(val.toString(), paredesCasa);

                                    } else if (col[1].equalsIgnoreCase("fuente_agua_ses")) {
                                        valores += setValuesMultipleField(val.toString(), fuenteAgua);

                                    } else if (col[1].equalsIgnoreCase("tipo_bano_ses")) {
                                        valores += setValuesMultipleField(val.toString(), tipoBano);

                                    } else if (col[1].equalsIgnoreCase("piso_ses")) {
                                        valores += setValuesMultipleField(val.toString(), piso);

                                    } else if (col[1].equalsIgnoreCase("animales_ses")) {
                                        valores += setValuesMultipleField(val.toString(), animales);

                                        //Cuestionario Salud Infantil

                                    } else if (col[1].equalsIgnoreCase("prob_embarazo_nino")) {
                                        valores += setValuesMultipleField(val.toString(), problemaEmbarazoNino);

                                    } else if (col[1].equalsIgnoreCase("ocurrio_embarazo_nino")) {
                                        valores += setValuesMultipleField(val.toString(), ocurrioEmbarazoNino);

                                    } else if (col[1].equalsIgnoreCase("problemas_bebe_nino")) {
                                        valores += setValuesMultipleField(val.toString(), problemasBebeNino);

                                    } else if (col[1].equalsIgnoreCase("parte_dia_afuera_nino")) {
                                        valores += setValuesMultipleField(val.toString(), parteDiaAfueraNino);

                                    } else if (col[1].equalsIgnoreCase("problemas_nino")) {
                                        valores += setValuesMultipleField(val.toString(), problemasNino);


                                        //Cuesionario Salud Infantil Update
                                    } else if (col[1].equalsIgnoreCase("parte_dia_afuera_nino")) {
                                        valores += setValuesMultipleField(val.toString(), parteDiaAfueraNinoUpd);

                                    } else if (col[1].equalsIgnoreCase("problemas_nino")) {
                                        valores += setValuesMultipleField(val.toString(), problemasNinoUpd);

                                        //Examen Fisico Infante

                                    } else if (col[1].equalsIgnoreCase("child_exam_optho_fiding")) {
                                        valores += setValuesMultipleField(val.toString(), childExamOptho);

                                        //Indicadores Cuidado Familia

                                    } else if (col[1].equalsIgnoreCase("materiales_jugar_fci")) {
                                        valores += setValuesMultipleField(val.toString(), materialesJugar);

                                    } else if (col[1].equalsIgnoreCase("variedad_jugar_fci")) {
                                        valores += setValuesMultipleField(val.toString(), variedadJugar);

                                    } else if (col[1].equalsIgnoreCase("actividades_jugar_fci")) {
                                        valores += setValuesMultipleField(val.toString(), actividadJugar);

                                        //Evaluacion Auditivo
                                    } else if (col[1].equalsIgnoreCase("ha_padecido_de_alguna_de_l")) {
                                        valores += setValuesMultipleField(val.toString(), haPadecidoAlguna);


                                    } else { //defecto
                                        if (val instanceof String) {
                                            String valFormat = val.toString().replaceAll(ENTER, ESPACIO).replaceAll(SALTOLINEA, ESPACIO);
                                            //si contiene uno de estos caracteres especiales escapar
                                            if (valFormat.contains(SEPARADOR) || valFormat.contains(COMILLA) || valFormat.contains(SALTOLINEA)) {
                                                valores += SEPARADOR + QUOTE + valFormat.trim() + QUOTE;
                                            } else {
                                                if (valores.isEmpty()) valores += valFormat.trim();
                                                else valores += SEPARADOR + valFormat.trim();
                                            }
                                        } else if (val instanceof Integer) {
                                            if (valores.isEmpty())
                                                valores += String.valueOf(res.getInt(col[1]));
                                            else valores += SEPARADOR + String.valueOf(res.getInt(col[1]));

                                        } else if (val instanceof java.util.Date) {
                                            if (valores.isEmpty())
                                                valores += DateToString(res.getDate(col[1]), "MM/dd/yyyy");
                                            else
                                                valores += SEPARADOR + DateToString(res.getDate(col[1]), "MM/dd/yyyy");

                                        } else if (val instanceof Float) {
                                            if (valores.isEmpty())
                                                valores += String.valueOf(res.getFloat(col[1]));
                                            else valores += SEPARADOR + String.valueOf(res.getFloat(col[1]));
                                        }
                                    }
                                } else {
                                    //campos que necesitan un trato especial
                                    //Cuestionario Socieconomico
                                    if (col[1].equalsIgnoreCase("paredes_casa_ses")) {
                                        for (int i = 0; i < paredesCasa.length; i++) {
                                            valores += SEPARADOR;
                                        }
                                    } else if (col[1].equalsIgnoreCase("fuente_agua_ses")) {
                                        for (int i = 0; i < fuenteAgua.length; i++) {
                                            valores += SEPARADOR;
                                        }
                                    } else if (col[1].equalsIgnoreCase("tipo_bano_ses")) {
                                        for (int i = 0; i < tipoBano.length; i++) {
                                            valores += SEPARADOR;
                                        }
                                    } else if (col[1].equalsIgnoreCase("piso_ses")) {
                                        for (int i = 0; i < piso.length; i++) {
                                            valores += SEPARADOR;
                                        }
                                    } else if (col[1].equalsIgnoreCase("animales_ses")) {
                                        for (int i = 0; i < animales.length; i++) {
                                            valores += SEPARADOR;
                                        }
                                        //Cuestionario Salud Infantil
                                    } else if (col[1].equalsIgnoreCase("prob_embarazo_nino")) {
                                        for (int i = 0; i < problemaEmbarazoNino.length; i++) {
                                            valores += SEPARADOR;
                                        }
                                    } else if (col[1].equalsIgnoreCase("ocurrio_embarazo_nino")) {
                                        for (int i = 0; i < ocurrioEmbarazoNino.length; i++) {
                                            valores += SEPARADOR;
                                        }
                                    } else if (col[1].equalsIgnoreCase("problemas_bebe_nino")) {
                                        for (int i = 0; i < problemasBebeNino.length; i++) {
                                            valores += SEPARADOR;
                                        }

                                    } else if (col[1].equalsIgnoreCase("parte_dia_afuera_nino")) {
                                        for (int i = 0; i < parteDiaAfueraNino.length; i++) {
                                            valores += SEPARADOR;
                                        }
                                    } else if (col[1].equalsIgnoreCase("problemas_nino")) {
                                        for (int i = 0; i < problemasNino.length; i++) {
                                            valores += SEPARADOR;
                                        }

                                        //Cuestionario Salud Infantil Update

                                    } else if (col[1].equalsIgnoreCase("parte_dia_afuera_nino")) {
                                        for (int i = 0; i < parteDiaAfueraNinoUpd.length; i++) {
                                            valores += SEPARADOR;
                                        }
                                    } else if (col[1].equalsIgnoreCase("problemas_nino")) {
                                        for (int i = 0; i < problemasNinoUpd.length; i++) {
                                            valores += SEPARADOR;
                                        }
                                        //Examen Fisico Infante
                                    } else if (col[1].equalsIgnoreCase("child_exam_optho_fiding")) {
                                        for (int i = 0; i < childExamOptho.length; i++) {
                                            valores += SEPARADOR;
                                        }

                                        //Indicadores Cuidado Familia
                                    } else if (col[1].equalsIgnoreCase("materiales_jugar_fci")) {
                                        for (int i = 0; i < materialesJugar.length; i++) {
                                            valores += SEPARADOR;
                                        }
                                    } else if (col[1].equalsIgnoreCase("variedad_jugar_fci")) {
                                        for (int i = 0; i < variedadJugar.length; i++) {
                                            valores += SEPARADOR;
                                        }
                                    } else if (col[1].equalsIgnoreCase("actividades_jugar_fci")) {
                                        for (int i = 0; i < actividadJugar.length; i++) {
                                            valores += SEPARADOR;
                                        }

                                        //Evaluacion Auditiva
                                    } else if (col[1].equalsIgnoreCase("ha_padecido_de_alguna_de_l")) {
                                        for (int i = 0; i < haPadecidoAlguna.length; i++) {
                                            valores += SEPARADOR;
                                        }
                                    } else {
                                        valores += SEPARADOR;
                                    }
                                }// fin else valor=null
                            }//fin llamado existeColumna()
                        }//fin foreach allColumns
                    }// fiN WHILE.NEXT

                    //columnas que necesita redcap y no estan en la tabla
                    if (tableName.equalsIgnoreCase(Constants.VIEW_ZPOV2_CUEST_DEMO)) {
                        columnasT += SEPARADOR + "demographics_questionnaire_complete";

                    } else if (tableName.equalsIgnoreCase(Constants.VIEW_ZPOV2_CUEST_DEMO_UPD)) {
                        columnasT += SEPARADOR + "demographics_update_complete";

                    } else if (tableName.equalsIgnoreCase(Constants.TABLE_ZPOV2_STUDY_EXIT)) {
                        columnasT += SEPARADOR + "discontinuation_form_complete";

                    } else if (tableName.equalsIgnoreCase(Constants.TABLE_ZPOV2_CUEST_SOCIO)) {
                        columnasT = columnasT.replaceAll("paredes_casa_ses", "paredes_casa_ses___1,paredes_casa_ses___2,paredes_casa_ses___3,paredes_casa_ses___4,paredes_casa_ses___5,paredes_casa_ses___6,paredes_casa_ses___7, paredes_casa_ses___8");
                        columnasT = columnasT.replaceAll("fuente_agua_ses", "fuente_agua_ses___1,fuente_agua_ses___2,fuente_agua_ses___3,fuente_agua_ses___4,fuente_agua_ses___5,fuente_agua_ses___6,fuente_agua_ses___7, fuente_agua_ses___8");
                        columnasT = columnasT.replaceAll("tipo_bano_ses", "tipo_bano_ses___1,tipo_bano_ses___2,tipo_bano_ses___3,tipo_bano_ses___4");
                        columnasT = columnasT.replaceAll("piso_ses", "piso_ses___1,piso_ses___2,piso_ses___3,piso_ses___4,piso_ses___5,piso_ses___6");
                        columnasT = columnasT.replaceAll("animales_ses", "animales_ses___1,animales_ses___2,animales_ses___3,animales_ses___4,animales_ses___5,animales_ses___6,animales_ses___7,animales_ses___8,animales_ses___9,animales_ses___10");
                        columnasT += SEPARADOR + "socioeconomics_questionnaire_complete";

                    } else if (tableName.equalsIgnoreCase(Constants.VIEW_ZPOV2_CUEST_SA_INF)) {
                        columnasT = columnasT.replaceAll("prob_embarazo_nino", "prob_embarazo_nino___1,prob_embarazo_nino___2,prob_embarazo_nino___3,prob_embarazo_nino___4,prob_embarazo_nino___5,prob_embarazo_nino___6,prob_embarazo_nino___7,prob_embarazo_nino___8");
                        columnasT = columnasT.replaceAll("ocurrio_embarazo_nino", "ocurrio_embarazo_nino___1,ocurrio_embarazo_nino___2,ocurrio_embarazo_nino___3,ocurrio_embarazo_nino___4,ocurrio_embarazo_nino___5");
                        columnasT = columnasT.replaceAll("problemas_bebe_nino", "problemas_bebe_nino___1,problemas_bebe_nino___2,problemas_bebe_nino___3,problemas_bebe_nino___4,problemas_bebe_nino___5,problemas_bebe_nino___6,problemas_bebe_nino___7,problemas_bebe_nino___8,problemas_bebe_nino___9,problemas_bebe_nino___10,problemas_bebe_nino___11,problemas_bebe_nino___12,problemas_bebe_nino___13,problemas_bebe_nino___14,problemas_bebe_nino___15,problemas_bebe_nino___16");
                        columnasT = columnasT.replaceAll("parte_dia_afuera_nino", "parte_dia_afuera_nino___1,parte_dia_afuera_nino___2,parte_dia_afuera_nino___3,parte_dia_afuera_nino___4,parte_dia_afuera_nino___5");
                        columnasT = columnasT.replaceAll("problemas_nino", "problemas_nino___1,problemas_nino___2,problemas_nino___3,problemas_nino___4,problemas_nino___5,problemas_nino___6,problemas_nino___7,problemas_nino___8,problemas_nino___9,problemas_nino___10,problemas_nino___11,problemas_nino___12,problemas_nino___13");
                        columnasT += SEPARADOR + "child_health_questionnaire_complete";


                    } else if (tableName.equalsIgnoreCase(Constants.VIEW_ZPOV2_CUEST_SA_INF_UPD)) {
                        columnasT = columnasT.replaceAll("parte_dia_afuera_nino", "parte_dia_afuera_nino_upd___1,parte_dia_afuera_nino_upd___2,parte_dia_afuera_nino_upd___3,parte_dia_afuera_nino_upd___4,parte_dia_afuera_nino_upd___5");
                        columnasT = columnasT.replaceAll("problemas_nino", "problemas_nino_upd___1,problemas_nino_upd___2,problemas_nino_upd___3,problemas_nino_upd___4,problemas_nino_upd___5,problemas_nino_upd___6,problemas_nino_upd___7,problemas_nino_upd___8,problemas_nino_upd___9,problemas_nino_upd___10,problemas_nino_upd___11,problemas_nino_upd___12,problemas_nino_upd___13");
                        columnasT += SEPARADOR + "child_health_update_complete";

                    } else if (tableName.equalsIgnoreCase(Constants.TABLE_ZPOV2_EXAM_FIS_INF)) {
                        columnasT = columnasT.replaceAll("child_exam_optho_fiding", "child_exam_optho_fiding___1,child_exam_optho_fiding___2,child_exam_optho_fiding___3");
                        columnasT += SEPARADOR + "child_physical_exam_complete";

                    } else if (tableName.equalsIgnoreCase(Constants.VIEW_ZPOV2_CUEST_SA_MAT)) {
                        columnasT += SEPARADOR + "maternal_health_questionnaire_complete";

                    } else if (tableName.equalsIgnoreCase(Constants.VIEW_ZPOV2_CUEST_SA_MAT_UPD)) {
                        columnasT += SEPARADOR + "maternal_health_questionnaire_update_complete";

                    } else if (tableName.equalsIgnoreCase(Constants.TABLE_ZPOV2_IND_CUI_FAM)) {
                        columnasT = columnasT.replaceAll("materiales_jugar_fci", "materiales_jugar_fci___1,materiales_jugar_fci___2,materiales_jugar_fci___3,materiales_jugar_fci___4,materiales_jugar_fci___5,materiales_jugar_fci___6");
                        columnasT = columnasT.replaceAll("variedad_jugar_fci", "variedad_jugar_fci___1,variedad_jugar_fci___2,variedad_jugar_fci___3,variedad_jugar_fci___4,variedad_jugar_fci___5,variedad_jugar_fci___6,variedad_jugar_fci___7,variedad_jugar_fci___8,variedad_jugar_fci___9");
                        columnasT = columnasT.replaceAll("actividades_jugar_fci", "actividades_jugar_fci___1,actividades_jugar_fci___2,actividades_jugar_fci___3,actividades_jugar_fci___4,actividades_jugar_fci___5,actividades_jugar_fci___6,actividades_jugar_fci___7,actividades_jugar_fci___8");
                        columnasT += SEPARADOR + "family_care_indicators_questionnaire_complete";

                    } else if (tableName.equalsIgnoreCase(Constants.TABLE_ZPOV2_BIOS_COLL)) {
                        columnasT += SEPARADOR + "blood_sample_complete";

                    } else if (tableName.equalsIgnoreCase(Constants.VIEW_ZPOV2_MULLEN)) {
                        columnasT += SEPARADOR + "mullen_msel_complete";

                    } else if (tableName.equalsIgnoreCase(Constants.TABLE_ZPOV2_EVAL_VISUAL)) {
                        columnasT = columnasT.replaceAll("incapaz_nivel_joven_optho", "incapaz_nivel_joven_optho___1");
                        columnasT = columnasT.replaceAll("semanas_optho", "semanas_optho___1");
                        columnasT = columnasT.replaceAll("meses_3_optho", "meses_3_optho___1");
                        columnasT = columnasT.replaceAll("meses_5_optho", "meses_5_optho___1");
                        columnasT = columnasT.replaceAll("meses_7_optho", "meses_7_optho___1");
                        columnasT = columnasT.replaceAll("meses_12_optho", "meses_12_optho___1");
                        columnasT += SEPARADOR + "ophthalmology_form_complete";

                    } else if (tableName.equalsIgnoreCase(Constants.VIEW_ZPOV2_EVAL_AUDI)) {

                        columnasT = columnasT.replaceAll("ha_padecido_de_alguna_de_l", "ha_padecido_de_alguna_de_l___1,ha_padecido_de_alguna_de_l___2,ha_padecido_de_alguna_de_l___3,ha_padecido_de_alguna_de_l___4,ha_padecido_de_alguna_de_l___5,ha_padecido_de_alguna_de_l___6");
                        columnasT += SEPARADOR + "hearing_form_complete";

                    } else if (tableName.equalsIgnoreCase(Constants.TABLE_ZPOV2_PSYC_EVAL)) {
                        columnasT += SEPARADOR + "psychological_evaluation_complete";

                    } else if (tableName.equalsIgnoreCase(Constants.VIEW_ZPOV2_EDADES_ETAPAS_42)) {
                        columnasT += SEPARADOR + "asq3_42_meses_39_meses_0_das_a_44_meses_30_das_complete";

                    }

                    if (primerRegistro == 0) {
                        columnas += ((columnas.isEmpty() ? "" : SEPARADOR) + columnasT);
                    }

                    if (!encontroRegistros) {
                        arrayColumnasT = columnasT.split(",");
                        for (int i = 0; i < arrayColumnasT.length; i++) {
                            valores += SEPARADOR;
                        }
                    } else {
                        //valor para zp0XXX_complete
                        valores += SEPARADOR + "1";
                    }
                }//fin for tables names
                if (existeDato) {
                    registros.add(valores);
                }
                primerRegistro++;
            }
            //}

            if (exportParameters.isAddHeader()) {
                sb.append(columnas);
            }
           for (String registro : registros) {
                sb.append(SALTOLINEA);
                sb.append(registro);
            }
            //sb.append(SALTOLINEA);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (res != null) res.close();
            if (pStatement != null) pStatement.close();
            if (con != null) con.close();
        }
        return sb;
    }


    private List<String[]> getAllTableMetaData(String[] tableNames) throws Exception {
        Connection con = ConnectionUtil.getConnection();
        List<String[]> columns = new ArrayList<String[]>();
        try {
            DatabaseMetaData meta = con.getMetaData();
            for (String tableName : tableNames) {
                ResultSet res = meta.getColumns(null, null, tableName, null);
                while (res.next()) {
                    //excluir estos campos
                    if (!res.getString("COLUMN_NAME").equalsIgnoreCase("identificador_equipo") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("end") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("estado") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("id_instancia") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("instance_path") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("PASIVO") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("phonenumber") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("FECHA_REGISTRO") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("USUARIO_REGISTRO") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("simserial") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("start") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("record_id") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("event_name") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("age_at_testing_msel") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("cogn_t_score_sum") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("atender_visita_psych") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("ayudar_amigas_psych") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("banar_hijo_psych") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("banarse_psych") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("cocinar_psych") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("compartir_info_psych") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("cuidar_cabello_psych") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("funcionamiento_puntaje_psych") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("juntar_mujeres_psych") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("lavar_dientes_psych") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("lavar_ropa_psych") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("limpiar_psych") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("mercado_psych") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("score_depression_psych") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("sintomas_puntaje_psych") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("tareas_salud_psych") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("trabajar_psych") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("usar_ropa_limpia_psych") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("vestir_hijo_psych") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("abnormal_results") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("area_comunicacion") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("area_motorafina") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("area_motoragruesa") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("area_socioindividual") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("event_name") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("area_solucionproblemas") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("idCompleted") &&
                            !res.getString("COLUMN_NAME").equalsIgnoreCase("today")
                    ) {

                        String[] columna = {res.getString("TABLE_NAME"), res.getString("COLUMN_NAME")};
                        columns.add(columna);

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null)
                con.close();
        }
        return columns;
    }



    private static boolean existeColumna(String buscar, String[] todas) {
        for (String comparar : todas) {
            if (comparar.equalsIgnoreCase(buscar)) {
                return true;
            }
        }
        return false;
    }

    private static String parseColumns(List<String> columns) {
        String columnas = "";
        for (String col : columns) {
            if (columnas.isEmpty()) //es primer columna
                columnas += col;
            else
                columnas += SEPARADOR + col;
        }
        return columnas;
    }

    private static String getTableColumns(List<String[]> allColumns, String tableName) {
        String columnas = "";
        for (String col[] : allColumns) {
            if (col[0].equalsIgnoreCase(tableName)) {
                if (columnas.isEmpty()) //es primer columna
                    columnas += col[1];
                else
                    columnas += SEPARADOR + col[1];
            }
        }
        return columnas;
    }

    public List<String> getCompleteRedCapEvents() {
        List<String> redCapEvents = new ArrayList<String>();
        redCapEvents.add(Constants.SCREENING);
        redCapEvents.add(Constants.MONTHS24);
        redCapEvents.add(Constants.MONTHS30);
        redCapEvents.add(Constants.MONTHS36);
        redCapEvents.add(Constants.MONTHS42);
        redCapEvents.add(Constants.MONTHS48);
        redCapEvents.add(Constants.MONTHS54);
        redCapEvents.add(Constants.MONTHS60);
        redCapEvents.add(Constants.MONTHS66);
        redCapEvents.add(Constants.MONTHS72);
        redCapEvents.add(Constants.MONTHS78);
        redCapEvents.add(Constants.MONTHS84);
        redCapEvents.add(Constants.EXIT);
        redCapEvents.add(Constants.INFEXIT);
        return redCapEvents;
    }

    @SuppressWarnings("unchecked")
    private List<String> getSubjects(ExportParameters exportParameters) throws SQLException {
        StringBuilder sqlStrBuilder = new StringBuilder("select zpo00.recordId from ZpoScreening zpo00");
        if (exportParameters.thereAreCodes()) sqlStrBuilder.append(" where zpo00.recordId between :inicio and :fin ");

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(sqlStrBuilder.toString());
        if (exportParameters.thereAreCodes()) {
            query.setString("inicio", exportParameters.getCodigoInicio());
            query.setString("fin", exportParameters.getCodigoFin());
        }
        List<String> subjects = query.list();
        sqlStrBuilder = new StringBuilder("select zpID.recordId from ZpoInfantData zpID");
        if (exportParameters.thereAreCodes()) sqlStrBuilder.append(" where zpID.recordId between :inicio and :fin ");
        query = session.createQuery(sqlStrBuilder.toString());
        if (exportParameters.thereAreCodes()) {
            query.setString("inicio", exportParameters.getCodigoInicio());
            query.setString("fin", exportParameters.getCodigoFin());
        }
        subjects.addAll(query.list());
        return subjects;
    }

    private static String setValuesMultipleField(String val, String[] valuesField) {
        String[] detalle = val.split(" ");
        String valuesResult = "";
        for (String item : valuesField) {
            String si = "";
            for (String det : detalle) {
                if (item.equalsIgnoreCase(det)) {
                    si = "1";
                    break;
                }
            }
            valuesResult += SEPARADOR + si;
        }
        return valuesResult;
    }

    public static String DateToString(Date dtFecha, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        if (dtFecha != null)
            return simpleDateFormat.format(dtFecha);
        else
            return null;
    }
}
