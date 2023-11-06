package com.my_company.eapp.dao;

import com.my_company.eapp.model.Significado;
import com.my_company.eapp.model.SignificadoExample.Criteria;
import com.my_company.eapp.model.SignificadoExample.Criterion;
import com.my_company.eapp.model.SignificadoExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class SignificadoSqlProvider {

    public String countByExample(SignificadoExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("significado");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(SignificadoExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("significado");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Significado row) {
        SQL sql = new SQL();
        sql.INSERT_INTO("significado");

        if (row.getDescripcion() != null) {
            sql.VALUES("descripcion", "#{descripcion,jdbcType=VARCHAR}");
        }

        if (row.getIdPalabraFrase() != null) {
            sql.VALUES("id_palabra_frase", "#{idPalabraFrase,jdbcType=INTEGER}");
        }

        if (row.getFechaRegistro() != null) {
            sql.VALUES("fecha_registro", "#{fechaRegistro,jdbcType=DATE}");
        }

        return sql.toString();
    }

    public String selectByExample(SignificadoExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id_significado");
        } else {
            sql.SELECT("id_significado");
        }
        sql.SELECT("descripcion");
        sql.SELECT("id_palabra_frase");
        sql.SELECT("fecha_registro");
        sql.FROM("significado");
        applyWhere(sql, example, false);

        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Significado row = (Significado) parameter.get("row");
        SignificadoExample example = (SignificadoExample) parameter.get("example");

        SQL sql = new SQL();
        sql.UPDATE("significado");

        if (row.getIdSignificado() != null) {
            sql.SET("id_significado = #{row.idSignificado,jdbcType=INTEGER}");
        }

        if (row.getDescripcion() != null) {
            sql.SET("descripcion = #{row.descripcion,jdbcType=VARCHAR}");
        }

        if (row.getIdPalabraFrase() != null) {
            sql.SET("id_palabra_frase = #{row.idPalabraFrase,jdbcType=INTEGER}");
        }

        if (row.getFechaRegistro() != null) {
            sql.SET("fecha_registro = #{row.fechaRegistro,jdbcType=DATE}");
        }

        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("significado");

        sql.SET("id_significado = #{row.idSignificado,jdbcType=INTEGER}");
        sql.SET("descripcion = #{row.descripcion,jdbcType=VARCHAR}");
        sql.SET("id_palabra_frase = #{row.idPalabraFrase,jdbcType=INTEGER}");
        sql.SET("fecha_registro = #{row.fechaRegistro,jdbcType=DATE}");

        SignificadoExample example = (SignificadoExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Significado row) {
        SQL sql = new SQL();
        sql.UPDATE("significado");

        if (row.getDescripcion() != null) {
            sql.SET("descripcion = #{descripcion,jdbcType=VARCHAR}");
        }

        if (row.getIdPalabraFrase() != null) {
            sql.SET("id_palabra_frase = #{idPalabraFrase,jdbcType=INTEGER}");
        }

        if (row.getFechaRegistro() != null) {
            sql.SET("fecha_registro = #{fechaRegistro,jdbcType=DATE}");
        }

        sql.WHERE("id_significado = #{idSignificado,jdbcType=INTEGER}");

        return sql.toString();
    }

    public String findRandomDefiniciones(Map<String, Object> params) {
        int count = (Integer) params.get("count");
        Integer excludePalabraFraseId = (Integer) params.get("excludePalabraFraseId");

        return new SQL() {
            {
                SELECT("*");
                FROM("significado");
                WHERE("id_palabra_frase != #{excludePalabraFraseId}");
                ORDER_BY("RANDOM()");
                LIMIT("" + count);
            }
        }.toString();
    }
    
    public String getSignificadoIdByDescripcion(String descripcion) {
        SQL sql = new SQL();
        sql.SELECT("id_significado") 
                .FROM("significado") // 
                .WHERE("descripcion = #{descripcion,jdbcType=VARCHAR}"); // donde el contenido coincide con el parámetro proporcionado

        return sql.toString();
    }
    protected void applyWhere(SQL sql, SignificadoExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }

        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }

        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }

                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }

                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }

        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}
