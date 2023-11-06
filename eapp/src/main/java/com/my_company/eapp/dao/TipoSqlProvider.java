package com.my_company.eapp.dao;

import com.my_company.eapp.model.Tipo;
import com.my_company.eapp.model.TipoExample.Criteria;
import com.my_company.eapp.model.TipoExample.Criterion;
import com.my_company.eapp.model.TipoExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class TipoSqlProvider {

    public String countByExample(TipoExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("tipo");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(TipoExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("tipo");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Tipo row) {
        SQL sql = new SQL();
        sql.INSERT_INTO("tipo");
        
        if (row.getCodTipo() != null) {
            sql.VALUES("cod_tipo", "#{codTipo,jdbcType=VARCHAR}");
        }

        if (row.getDescripcion() != null) {
            sql.VALUES("descripcion", "#{descripcion,jdbcType=VARCHAR}");
        }

        if (row.getFechaRegistro() != null) {
            sql.VALUES("fecha_registro", "#{fechaRegistro,jdbcType=DATE}");
        }

        if (row.getIdCategoria() != null) {
            sql.VALUES("id_categoria", "#{idCategoria,jdbcType=INTEGER}");
        }

        return sql.toString();
    }

    public String selectByExample(TipoExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("cod_tipo");
        } else {
            sql.SELECT("cod_tipo");
        }
        sql.SELECT("descripcion");
        sql.SELECT("fecha_registro");
        sql.SELECT("id_categoria");
        sql.FROM("tipo");
        applyWhere(sql, example, false);

        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Tipo row = (Tipo) parameter.get("row");
        TipoExample example = (TipoExample) parameter.get("example");

        SQL sql = new SQL();
        sql.UPDATE("tipo");

        if (row.getCodTipo() != null) {
            sql.SET("cod_tipo = #{row.codTipo,jdbcType=VARCHAR}");
        }

        if (row.getDescripcion() != null) {
            sql.SET("descripcion = #{row.descripcion,jdbcType=VARCHAR}");
        }

        if (row.getFechaRegistro() != null) {
            sql.SET("fecha_registro = #{row.fechaRegistro,jdbcType=DATE}");
        }

        if (row.getIdCategoria() != null) {
            sql.SET("id_categoria = #{row.idCategoria,jdbcType=INTEGER}");
        }

        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("tipo");

        sql.SET("cod_tipo = #{row.codTipo,jdbcType=VARCHAR}");
        sql.SET("descripcion = #{row.descripcion,jdbcType=VARCHAR}");
        sql.SET("fecha_registro = #{row.fechaRegistro,jdbcType=DATE}");
        sql.SET("id_categoria = #{row.idCategoria,jdbcType=INTEGER}");

        TipoExample example = (TipoExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Tipo row) {
        SQL sql = new SQL();
        sql.UPDATE("tipo");

        if (row.getDescripcion() != null) {
            sql.SET("descripcion = #{descripcion,jdbcType=VARCHAR}");
        }

        if (row.getFechaRegistro() != null) {
            sql.SET("fecha_registro = #{fechaRegistro,jdbcType=DATE}");
        }

        if (row.getIdCategoria() != null) {
            sql.SET("id_categoria = #{idCategoria,jdbcType=INTEGER}");
        }

        sql.WHERE("cod_tipo = #{codTipo,jdbcType=VARCHAR}");

        return sql.toString();
    }

    public String selectByCategoria(Map<String, Object> parameter) {
        Integer idCategoria = (Integer) parameter.get("idCategoria");

        SQL sql = new SQL();
        sql.SELECT("cod_tipo", "descripcion", "fecha_registro", "id_categoria")
                .FROM("tipo")
                .WHERE("id_categoria = #{idCategoria,jdbcType=INTEGER}");

        return sql.toString();
    }

    protected void applyWhere(SQL sql, TipoExample example, boolean includeExamplePhrase) {
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
