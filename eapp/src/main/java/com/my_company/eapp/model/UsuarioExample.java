package com.my_company.eapp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UsuarioExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UsuarioExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdUsuarioIsNull() {
            addCriterion("id_usuario is null");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioIsNotNull() {
            addCriterion("id_usuario is not null");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioEqualTo(Integer value) {
            addCriterion("id_usuario =", value, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioNotEqualTo(Integer value) {
            addCriterion("id_usuario <>", value, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioGreaterThan(Integer value) {
            addCriterion("id_usuario >", value, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_usuario >=", value, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioLessThan(Integer value) {
            addCriterion("id_usuario <", value, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioLessThanOrEqualTo(Integer value) {
            addCriterion("id_usuario <=", value, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioIn(List<Integer> values) {
            addCriterion("id_usuario in", values, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioNotIn(List<Integer> values) {
            addCriterion("id_usuario not in", values, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioBetween(Integer value1, Integer value2) {
            addCriterion("id_usuario between", value1, value2, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioNotBetween(Integer value1, Integer value2) {
            addCriterion("id_usuario not between", value1, value2, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andNombreUsuarioIsNull() {
            addCriterion("nombre_usuario is null");
            return (Criteria) this;
        }

        public Criteria andNombreUsuarioIsNotNull() {
            addCriterion("nombre_usuario is not null");
            return (Criteria) this;
        }

        public Criteria andNombreUsuarioEqualTo(String value) {
            addCriterion("nombre_usuario =", value, "nombreUsuario");
            return (Criteria) this;
        }

        public Criteria andNombreUsuarioNotEqualTo(String value) {
            addCriterion("nombre_usuario <>", value, "nombreUsuario");
            return (Criteria) this;
        }

        public Criteria andNombreUsuarioGreaterThan(String value) {
            addCriterion("nombre_usuario >", value, "nombreUsuario");
            return (Criteria) this;
        }

        public Criteria andNombreUsuarioGreaterThanOrEqualTo(String value) {
            addCriterion("nombre_usuario >=", value, "nombreUsuario");
            return (Criteria) this;
        }

        public Criteria andNombreUsuarioLessThan(String value) {
            addCriterion("nombre_usuario <", value, "nombreUsuario");
            return (Criteria) this;
        }

        public Criteria andNombreUsuarioLessThanOrEqualTo(String value) {
            addCriterion("nombre_usuario <=", value, "nombreUsuario");
            return (Criteria) this;
        }

        public Criteria andNombreUsuarioLike(String value) {
            addCriterion("nombre_usuario like", value, "nombreUsuario");
            return (Criteria) this;
        }

        public Criteria andNombreUsuarioNotLike(String value) {
            addCriterion("nombre_usuario not like", value, "nombreUsuario");
            return (Criteria) this;
        }

        public Criteria andNombreUsuarioIn(List<String> values) {
            addCriterion("nombre_usuario in", values, "nombreUsuario");
            return (Criteria) this;
        }

        public Criteria andNombreUsuarioNotIn(List<String> values) {
            addCriterion("nombre_usuario not in", values, "nombreUsuario");
            return (Criteria) this;
        }

        public Criteria andNombreUsuarioBetween(String value1, String value2) {
            addCriterion("nombre_usuario between", value1, value2, "nombreUsuario");
            return (Criteria) this;
        }

        public Criteria andNombreUsuarioNotBetween(String value1, String value2) {
            addCriterion("nombre_usuario not between", value1, value2, "nombreUsuario");
            return (Criteria) this;
        }

        public Criteria andNombreIsNull() {
            addCriterion("nombre is null");
            return (Criteria) this;
        }

        public Criteria andNombreIsNotNull() {
            addCriterion("nombre is not null");
            return (Criteria) this;
        }

        public Criteria andNombreEqualTo(String value) {
            addCriterion("nombre =", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreNotEqualTo(String value) {
            addCriterion("nombre <>", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreGreaterThan(String value) {
            addCriterion("nombre >", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreGreaterThanOrEqualTo(String value) {
            addCriterion("nombre >=", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreLessThan(String value) {
            addCriterion("nombre <", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreLessThanOrEqualTo(String value) {
            addCriterion("nombre <=", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreLike(String value) {
            addCriterion("nombre like", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreNotLike(String value) {
            addCriterion("nombre not like", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreIn(List<String> values) {
            addCriterion("nombre in", values, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreNotIn(List<String> values) {
            addCriterion("nombre not in", values, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreBetween(String value1, String value2) {
            addCriterion("nombre between", value1, value2, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreNotBetween(String value1, String value2) {
            addCriterion("nombre not between", value1, value2, "nombre");
            return (Criteria) this;
        }

        public Criteria andApellidoIsNull() {
            addCriterion("apellido is null");
            return (Criteria) this;
        }

        public Criteria andApellidoIsNotNull() {
            addCriterion("apellido is not null");
            return (Criteria) this;
        }

        public Criteria andApellidoEqualTo(String value) {
            addCriterion("apellido =", value, "apellido");
            return (Criteria) this;
        }

        public Criteria andApellidoNotEqualTo(String value) {
            addCriterion("apellido <>", value, "apellido");
            return (Criteria) this;
        }

        public Criteria andApellidoGreaterThan(String value) {
            addCriterion("apellido >", value, "apellido");
            return (Criteria) this;
        }

        public Criteria andApellidoGreaterThanOrEqualTo(String value) {
            addCriterion("apellido >=", value, "apellido");
            return (Criteria) this;
        }

        public Criteria andApellidoLessThan(String value) {
            addCriterion("apellido <", value, "apellido");
            return (Criteria) this;
        }

        public Criteria andApellidoLessThanOrEqualTo(String value) {
            addCriterion("apellido <=", value, "apellido");
            return (Criteria) this;
        }

        public Criteria andApellidoLike(String value) {
            addCriterion("apellido like", value, "apellido");
            return (Criteria) this;
        }

        public Criteria andApellidoNotLike(String value) {
            addCriterion("apellido not like", value, "apellido");
            return (Criteria) this;
        }

        public Criteria andApellidoIn(List<String> values) {
            addCriterion("apellido in", values, "apellido");
            return (Criteria) this;
        }

        public Criteria andApellidoNotIn(List<String> values) {
            addCriterion("apellido not in", values, "apellido");
            return (Criteria) this;
        }

        public Criteria andApellidoBetween(String value1, String value2) {
            addCriterion("apellido between", value1, value2, "apellido");
            return (Criteria) this;
        }

        public Criteria andApellidoNotBetween(String value1, String value2) {
            addCriterion("apellido not between", value1, value2, "apellido");
            return (Criteria) this;
        }

        public Criteria andFechaRegistroIsNull() {
            addCriterion("fecha_registro is null");
            return (Criteria) this;
        }

        public Criteria andFechaRegistroIsNotNull() {
            addCriterion("fecha_registro is not null");
            return (Criteria) this;
        }

        public Criteria andFechaRegistroEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_registro =", value, "fechaRegistro");
            return (Criteria) this;
        }

        public Criteria andFechaRegistroNotEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_registro <>", value, "fechaRegistro");
            return (Criteria) this;
        }

        public Criteria andFechaRegistroGreaterThan(Date value) {
            addCriterionForJDBCDate("fecha_registro >", value, "fechaRegistro");
            return (Criteria) this;
        }

        public Criteria andFechaRegistroGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_registro >=", value, "fechaRegistro");
            return (Criteria) this;
        }

        public Criteria andFechaRegistroLessThan(Date value) {
            addCriterionForJDBCDate("fecha_registro <", value, "fechaRegistro");
            return (Criteria) this;
        }

        public Criteria andFechaRegistroLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_registro <=", value, "fechaRegistro");
            return (Criteria) this;
        }

        public Criteria andFechaRegistroIn(List<Date> values) {
            addCriterionForJDBCDate("fecha_registro in", values, "fechaRegistro");
            return (Criteria) this;
        }

        public Criteria andFechaRegistroNotIn(List<Date> values) {
            addCriterionForJDBCDate("fecha_registro not in", values, "fechaRegistro");
            return (Criteria) this;
        }

        public Criteria andFechaRegistroBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fecha_registro between", value1, value2, "fechaRegistro");
            return (Criteria) this;
        }

        public Criteria andFechaRegistroNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fecha_registro not between", value1, value2, "fechaRegistro");
            return (Criteria) this;
        }

        public Criteria andContrasenhaIsNull() {
            addCriterion("contrasenha is null");
            return (Criteria) this;
        }

        public Criteria andContrasenhaIsNotNull() {
            addCriterion("contrasenha is not null");
            return (Criteria) this;
        }

        public Criteria andContrasenhaEqualTo(String value) {
            addCriterion("contrasenha =", value, "contrasenha");
            return (Criteria) this;
        }

        public Criteria andContrasenhaNotEqualTo(String value) {
            addCriterion("contrasenha <>", value, "contrasenha");
            return (Criteria) this;
        }

        public Criteria andContrasenhaGreaterThan(String value) {
            addCriterion("contrasenha >", value, "contrasenha");
            return (Criteria) this;
        }

        public Criteria andContrasenhaGreaterThanOrEqualTo(String value) {
            addCriterion("contrasenha >=", value, "contrasenha");
            return (Criteria) this;
        }

        public Criteria andContrasenhaLessThan(String value) {
            addCriterion("contrasenha <", value, "contrasenha");
            return (Criteria) this;
        }

        public Criteria andContrasenhaLessThanOrEqualTo(String value) {
            addCriterion("contrasenha <=", value, "contrasenha");
            return (Criteria) this;
        }

        public Criteria andContrasenhaLike(String value) {
            addCriterion("contrasenha like", value, "contrasenha");
            return (Criteria) this;
        }

        public Criteria andContrasenhaNotLike(String value) {
            addCriterion("contrasenha not like", value, "contrasenha");
            return (Criteria) this;
        }

        public Criteria andContrasenhaIn(List<String> values) {
            addCriterion("contrasenha in", values, "contrasenha");
            return (Criteria) this;
        }

        public Criteria andContrasenhaNotIn(List<String> values) {
            addCriterion("contrasenha not in", values, "contrasenha");
            return (Criteria) this;
        }

        public Criteria andContrasenhaBetween(String value1, String value2) {
            addCriterion("contrasenha between", value1, value2, "contrasenha");
            return (Criteria) this;
        }

        public Criteria andContrasenhaNotBetween(String value1, String value2) {
            addCriterion("contrasenha not between", value1, value2, "contrasenha");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}