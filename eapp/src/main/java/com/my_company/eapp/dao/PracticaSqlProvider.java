package com.my_company.eapp.dao;

import com.my_company.eapp.model.Practica;
import com.my_company.eapp.model.PracticaExample.Criteria;
import com.my_company.eapp.model.PracticaExample.Criterion;
import com.my_company.eapp.model.PracticaExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class PracticaSqlProvider {
    public String countByExample(PracticaExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("practica");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(PracticaExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("practica");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Practica row) {
        SQL sql = new SQL();
        sql.INSERT_INTO("practica");
        
        if (row.getUltimaFecha() != null) {
            sql.VALUES("ultima_fecha", "#{ultimaFecha,jdbcType=DATE}");
        }
        
        if (row.getConteo() != null) {
            sql.VALUES("conteo", "#{conteo,jdbcType=INTEGER}");
        }
        
        if (row.getIdPalabraFrase() != null) {
            sql.VALUES("id_palabra_frase", "#{idPalabraFrase,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(PracticaExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id_practica");
        } else {
            sql.SELECT("id_practica");
        }
        sql.SELECT("ultima_fecha");
        sql.SELECT("conteo");
        sql.SELECT("id_palabra_frase");
        sql.FROM("practica");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }
    
     public String selectByIdPalabra(Integer idPalabraFrase) {
        SQL sql = new SQL();
        sql.SELECT("id_practica");
        
        sql.SELECT("ultima_fecha");
        sql.SELECT("conteo");
        sql.SELECT("id_palabra_frase");
        sql.FROM("practica");
        sql.WHERE("id_palabra_frase = #{idPalabraFrase}");
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Practica row = (Practica) parameter.get("row");
        PracticaExample example = (PracticaExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("practica");
        
        if (row.getIdPractica() != null) {
            sql.SET("id_practica = #{row.idPractica,jdbcType=INTEGER}");
        }
        
        if (row.getUltimaFecha() != null) {
            sql.SET("ultima_fecha = #{row.ultimaFecha,jdbcType=DATE}");
        }
        
        if (row.getConteo() != null) {
            sql.SET("conteo = #{row.conteo,jdbcType=INTEGER}");
        }
        
        if (row.getIdPalabraFrase() != null) {
            sql.SET("id_palabra_frase = #{row.idPalabraFrase,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("practica");
        
        sql.SET("id_practica = #{row.idPractica,jdbcType=INTEGER}");
        sql.SET("ultima_fecha = #{row.ultimaFecha,jdbcType=DATE}");
        sql.SET("conteo = #{row.conteo,jdbcType=INTEGER}");
        sql.SET("id_palabra_frase = #{row.idPalabraFrase,jdbcType=INTEGER}");
        
        PracticaExample example = (PracticaExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Practica row) {
        SQL sql = new SQL();
        sql.UPDATE("practica");
        
        if (row.getUltimaFecha() != null) {
            sql.SET("ultima_fecha = #{ultimaFecha,jdbcType=DATE}");
        }
        
        if (row.getConteo() != null) {
            sql.SET("conteo = #{conteo,jdbcType=INTEGER}");
        }
        
        if (row.getIdPalabraFrase() != null) {
            sql.SET("id_palabra_frase = #{idPalabraFrase,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id_practica = #{idPractica,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, PracticaExample example, boolean includeExamplePhrase) {
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