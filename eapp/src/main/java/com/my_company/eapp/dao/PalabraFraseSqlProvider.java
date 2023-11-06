package com.my_company.eapp.dao;

import com.my_company.eapp.model.PalabraFrase;
import com.my_company.eapp.model.PalabraFraseExample.Criteria;
import com.my_company.eapp.model.PalabraFraseExample.Criterion;
import com.my_company.eapp.model.PalabraFraseExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class PalabraFraseSqlProvider {

    public String countByExample(PalabraFraseExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("palabra_frase");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(PalabraFraseExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("palabra_frase");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(PalabraFrase row) {
        SQL sql = new SQL();
        sql.INSERT_INTO("palabra_frase");

        if (row.getContenido() != null) {
            sql.VALUES("contenido", "#{contenido,jdbcType=VARCHAR}");
        }

        if (row.getDificultad() != null) {
            sql.VALUES("dificultad", "#{dificultad,jdbcType=VARCHAR}");
        }

        if (row.getAprendido() != null) {
            sql.VALUES("aprendido", "#{aprendido,jdbcType=BIT}");
        }

        if (row.getFechaRegistro() != null) {
            sql.VALUES("fecha_registro", "#{fechaRegistro,jdbcType=DATE}");
        }

        if (row.getCodTipo() != null) {
            sql.VALUES("cod_tipo", "#{codTipo,jdbcType=VARCHAR}");
        }

        return sql.toString();
    }

    public String selectByExample(PalabraFraseExample example, Integer idCategoria) {
        System.out.println("Example: "+example);
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id_palabra_frase");
        } else {
            sql.SELECT("id_palabra_frase");
        }
        sql.SELECT("p.contenido");
        sql.SELECT("p.dificultad");
        sql.SELECT("p.aprendido");
        sql.SELECT("p.fecha_registro");
        sql.SELECT("p.cod_tipo");
        
        sql.FROM("palabra_frase p");
        
        sql.JOIN("tipo t ON p.cod_tipo = t.cod_tipo");
        sql.JOIN("categoria c ON t.id_categoria = c.id_categoria");
        
        if (idCategoria != null) {
            sql.WHERE("c.id_categoria = #{idCategoria}");
        }

        applyWhere(sql, example, true);

        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        PalabraFrase row = (PalabraFrase) parameter.get("row");
        PalabraFraseExample example = (PalabraFraseExample) parameter.get("example");

        SQL sql = new SQL();
        sql.UPDATE("palabra_frase");

        if (row.getIdPalabraFrase() != null) {
            sql.SET("id_palabra_frase = #{row.idPalabraFrase,jdbcType=INTEGER}");
        }

        if (row.getContenido() != null) {
            sql.SET("contenido = #{row.contenido,jdbcType=VARCHAR}");
        }

        if (row.getDificultad() != null) {
            sql.SET("dificultad = #{row.dificultad,jdbcType=VARCHAR}");
        }

        if (row.getAprendido() != null) {
            sql.SET("aprendido = #{row.aprendido,jdbcType=BIT}");
        }

        if (row.getFechaRegistro() != null) {
            sql.SET("fecha_registro = #{row.fechaRegistro,jdbcType=DATE}");
        }

        if (row.getCodTipo() != null) {
            sql.SET("cod_tipo = #{row.codTipo,jdbcType=VARCHAR}");
        }

        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("palabra_frase");

        sql.SET("id_palabra_frase = #{row.idPalabraFrase,jdbcType=INTEGER}");
        sql.SET("contenido = #{row.contenido,jdbcType=VARCHAR}");
        sql.SET("dificultad = #{row.dificultad,jdbcType=VARCHAR}");
        sql.SET("aprendido = #{row.aprendido,jdbcType=BIT}");
        sql.SET("fecha_registro = #{row.fechaRegistro,jdbcType=DATE}");
        sql.SET("cod_tipo = #{row.codTipo,jdbcType=VARCHAR}");

        PalabraFraseExample example = (PalabraFraseExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(PalabraFrase row) {
        SQL sql = new SQL();
        sql.UPDATE("palabra_frase");

        if (row.getContenido() != null) {
            sql.SET("contenido = #{contenido,jdbcType=VARCHAR}");
        }

        if (row.getDificultad() != null) {
            sql.SET("dificultad = #{dificultad,jdbcType=VARCHAR}");
        }

        if (row.getAprendido() != null) {
            sql.SET("aprendido = #{aprendido,jdbcType=BIT}");
        }

        if (row.getFechaRegistro() != null) {
            sql.SET("fecha_registro = #{fechaRegistro,jdbcType=DATE}");
        }

        if (row.getCodTipo() != null) {
            sql.SET("cod_tipo = #{codTipo,jdbcType=VARCHAR}");
        }

        sql.WHERE("id_palabra_frase = #{idPalabraFrase,jdbcType=INTEGER}");

        return sql.toString();
    }

    public String getPalabraFraseIdByContenido(String contenido) {
        SQL sql = new SQL();
        sql.SELECT("id_palabra_frase") // seleccionas el id_palabra_frase
                .FROM("palabra_frase") // de la tabla palabra_frase
                .WHERE("contenido = #{contenido,jdbcType=VARCHAR}"); // donde el contenido coincide con el parámetro proporcionado

        return sql.toString();
    }

    protected void applyWhere(SQL sql, PalabraFraseExample example, boolean includeExamplePhrase) {
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
