package com.my_company.eapp.dao;

import com.my_company.eapp.model.Usuario;
import com.my_company.eapp.model.UsuarioExample.Criteria;
import com.my_company.eapp.model.UsuarioExample.Criterion;
import com.my_company.eapp.model.UsuarioExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class UsuarioSqlProvider {
    public String countByExample(UsuarioExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("usuario");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(UsuarioExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("usuario");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String doesUsernameExist(String username) {
        SQL sql = new SQL();
        sql.SELECT("count(*)")
           .FROM("usuario")
           .WHERE("nombre_usuario = #{username}");
        return sql.toString();
    }

    public String insertSelective(Usuario row) {
        SQL sql = new SQL();
        sql.INSERT_INTO("usuario");
        
        if (row.getNombreUsuario() != null) {
            sql.VALUES("nombre_usuario", "#{nombreUsuario,jdbcType=VARCHAR}");
        }
        
        if (row.getNombre() != null) {
            sql.VALUES("nombre", "#{nombre,jdbcType=VARCHAR}");
        }
        
        if (row.getApellido() != null) {
            sql.VALUES("apellido", "#{apellido,jdbcType=VARCHAR}");
        }
        
        if (row.getFechaRegistro() != null) {
            sql.VALUES("fecha_registro", "#{fechaRegistro,jdbcType=DATE}");
        }
        
        if (row.getContrasenha() != null) {
            sql.VALUES("contrasenha", "#{contrasenha,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(UsuarioExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id_usuario");
        } else {
            sql.SELECT("id_usuario");
        }
        sql.SELECT("nombre_usuario");
        sql.SELECT("nombre");
        sql.SELECT("apellido");
        sql.SELECT("fecha_registro");
        sql.SELECT("contrasenha");
        sql.FROM("usuario");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Usuario row = (Usuario) parameter.get("row");
        UsuarioExample example = (UsuarioExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("usuario");
        
        if (row.getIdUsuario() != null) {
            sql.SET("id_usuario = #{row.idUsuario,jdbcType=INTEGER}");
        }
        
        if (row.getNombreUsuario() != null) {
            sql.SET("nombre_usuario = #{row.nombreUsuario,jdbcType=VARCHAR}");
        }
        
        if (row.getNombre() != null) {
            sql.SET("nombre = #{row.nombre,jdbcType=VARCHAR}");
        }
        
        if (row.getApellido() != null) {
            sql.SET("apellido = #{row.apellido,jdbcType=VARCHAR}");
        }
        
        if (row.getFechaRegistro() != null) {
            sql.SET("fecha_registro = #{row.fechaRegistro,jdbcType=DATE}");
        }
        
        if (row.getContrasenha() != null) {
            sql.SET("contrasenha = #{row.contrasenha,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("usuario");
        
        sql.SET("id_usuario = #{row.idUsuario,jdbcType=INTEGER}");
        sql.SET("nombre_usuario = #{row.nombreUsuario,jdbcType=VARCHAR}");
        sql.SET("nombre = #{row.nombre,jdbcType=VARCHAR}");
        sql.SET("apellido = #{row.apellido,jdbcType=VARCHAR}");
        sql.SET("fecha_registro = #{row.fechaRegistro,jdbcType=DATE}");
        sql.SET("contrasenha = #{row.contrasenha,jdbcType=VARCHAR}");
        
        UsuarioExample example = (UsuarioExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Usuario row) {
        SQL sql = new SQL();
        sql.UPDATE("usuario");
        
        if (row.getNombreUsuario() != null) {
            sql.SET("nombre_usuario = #{nombreUsuario,jdbcType=VARCHAR}");
        }
        
        if (row.getNombre() != null) {
            sql.SET("nombre = #{nombre,jdbcType=VARCHAR}");
        }
        
        if (row.getApellido() != null) {
            sql.SET("apellido = #{apellido,jdbcType=VARCHAR}");
        }
        
        if (row.getFechaRegistro() != null) {
            sql.SET("fecha_registro = #{fechaRegistro,jdbcType=DATE}");
        }
        
        if (row.getContrasenha() != null) {
            sql.SET("contrasenha = #{contrasenha,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id_usuario = #{idUsuario,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, UsuarioExample example, boolean includeExamplePhrase) {
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
