package com.my_company.eapp.dao;

import com.my_company.eapp.model.Oracion;
import com.my_company.eapp.model.OracionExample.Criteria;
import com.my_company.eapp.model.OracionExample.Criterion;
import com.my_company.eapp.model.OracionExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OracionSqlProvider {
    public String countByExample(OracionExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("oracion");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OracionExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("oracion");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Oracion row) {
        SQL sql = new SQL();
        sql.INSERT_INTO("oracion");
        
        if (row.getTexto() != null) {
            sql.VALUES("texto", "#{texto,jdbcType=VARCHAR}");
        }
        
        if (row.getFechaRegistro() != null) {
            sql.VALUES("fecha_registro", "#{fechaRegistro,jdbcType=DATE}");
        }
        
        if (row.getIdPalabraFrase() != null) {
            sql.VALUES("id_palabra_frase", "#{idPalabraFrase,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OracionExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id_oracion");
        } else {
            sql.SELECT("id_oracion");
        }
        sql.SELECT("texto");
        sql.SELECT("fecha_registro");
        sql.SELECT("id_palabra_frase");
        sql.FROM("oracion");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Oracion row = (Oracion) parameter.get("row");
        OracionExample example = (OracionExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("oracion");
        
        if (row.getIdOracion() != null) {
            sql.SET("id_oracion = #{row.idOracion,jdbcType=INTEGER}");
        }
        
        if (row.getTexto() != null) {
            sql.SET("texto = #{row.texto,jdbcType=VARCHAR}");
        }
        
        if (row.getFechaRegistro() != null) {
            sql.SET("fecha_registro = #{row.fechaRegistro,jdbcType=DATE}");
        }
        
        if (row.getIdPalabraFrase() != null) {
            sql.SET("id_palabra_frase = #{row.idPalabraFrase,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("oracion");
        
        sql.SET("id_oracion = #{row.idOracion,jdbcType=INTEGER}");
        sql.SET("texto = #{row.texto,jdbcType=VARCHAR}");
        sql.SET("fecha_registro = #{row.fechaRegistro,jdbcType=DATE}");
        sql.SET("id_palabra_frase = #{row.idPalabraFrase,jdbcType=INTEGER}");
        
        OracionExample example = (OracionExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Oracion row) {
        SQL sql = new SQL();
        sql.UPDATE("oracion");
        
        if (row.getTexto() != null) {
            sql.SET("texto = #{texto,jdbcType=VARCHAR}");
        }
        
        if (row.getFechaRegistro() != null) {
            sql.SET("fecha_registro = #{fechaRegistro,jdbcType=DATE}");
        }
        
        if (row.getIdPalabraFrase() != null) {
            sql.SET("id_palabra_frase = #{idPalabraFrase,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id_oracion = #{idOracion,jdbcType=INTEGER}");
        
        return sql.toString();
    }
    
    public String getOracionIdByPalabraFraseId(Integer idPalabraFrase) {
        SQL sql = new SQL();
        sql.SELECT("id_oracion, texto, fecha_registro,id_palabra_frase") // seleccionas el id_palabra_frase
                .FROM("oracion") // de la tabla palabra_frase
                .WHERE("id_palabra_frase = #{idPalabraFrase,jdbcType=VARCHAR}"); // donde el contenido coincide con el parámetro proporcionado

        return sql.toString();
    }

    protected void applyWhere(SQL sql, OracionExample example, boolean includeExamplePhrase) {
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
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
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
