package com.my_company.eapp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PalabraFraseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PalabraFraseExample() {
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

        public Criteria andIdPalabraFraseIsNull() {
            addCriterion("id_palabra_frase is null");
            return (Criteria) this;
        }

        public Criteria andIdPalabraFraseIsNotNull() {
            addCriterion("id_palabra_frase is not null");
            return (Criteria) this;
        }

        public Criteria andIdPalabraFraseEqualTo(Integer value) {
            addCriterion("id_palabra_frase =", value, "idPalabraFrase");
            return (Criteria) this;
        }

        public Criteria andIdPalabraFraseNotEqualTo(Integer value) {
            addCriterion("id_palabra_frase <>", value, "idPalabraFrase");
            return (Criteria) this;
        }

        public Criteria andIdPalabraFraseGreaterThan(Integer value) {
            addCriterion("id_palabra_frase >", value, "idPalabraFrase");
            return (Criteria) this;
        }

        public Criteria andIdPalabraFraseGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_palabra_frase >=", value, "idPalabraFrase");
            return (Criteria) this;
        }

        public Criteria andIdPalabraFraseLessThan(Integer value) {
            addCriterion("id_palabra_frase <", value, "idPalabraFrase");
            return (Criteria) this;
        }

        public Criteria andIdPalabraFraseLessThanOrEqualTo(Integer value) {
            addCriterion("id_palabra_frase <=", value, "idPalabraFrase");
            return (Criteria) this;
        }

        public Criteria andIdPalabraFraseIn(List<Integer> values) {
            addCriterion("id_palabra_frase in", values, "idPalabraFrase");
            return (Criteria) this;
        }

        public Criteria andIdPalabraFraseNotIn(List<Integer> values) {
            addCriterion("id_palabra_frase not in", values, "idPalabraFrase");
            return (Criteria) this;
        }

        public Criteria andIdPalabraFraseBetween(Integer value1, Integer value2) {
            addCriterion("id_palabra_frase between", value1, value2, "idPalabraFrase");
            return (Criteria) this;
        }

        public Criteria andIdPalabraFraseNotBetween(Integer value1, Integer value2) {
            addCriterion("id_palabra_frase not between", value1, value2, "idPalabraFrase");
            return (Criteria) this;
        }

        public Criteria andContenidoIsNull() {
            addCriterion("contenido is null");
            return (Criteria) this;
        }

        public Criteria andContenidoIsNotNull() {
            addCriterion("contenido is not null");
            return (Criteria) this;
        }

        public Criteria andContenidoEqualTo(String value) {
            addCriterion("contenido =", value, "contenido");
            return (Criteria) this;
        }

        public Criteria andContenidoNotEqualTo(String value) {
            addCriterion("contenido <>", value, "contenido");
            return (Criteria) this;
        }

        public Criteria andContenidoGreaterThan(String value) {
            addCriterion("contenido >", value, "contenido");
            return (Criteria) this;
        }

        public Criteria andContenidoGreaterThanOrEqualTo(String value) {
            addCriterion("contenido >=", value, "contenido");
            return (Criteria) this;
        }

        public Criteria andContenidoLessThan(String value) {
            addCriterion("contenido <", value, "contenido");
            return (Criteria) this;
        }

        public Criteria andContenidoLessThanOrEqualTo(String value) {
            addCriterion("contenido <=", value, "contenido");
            return (Criteria) this;
        }

        public Criteria andContenidoLike(String value) {
            addCriterion("contenido like", value, "contenido");
            return (Criteria) this;
        }

        public Criteria andContenidoNotLike(String value) {
            addCriterion("contenido not like", value, "contenido");
            return (Criteria) this;
        }

        public Criteria andContenidoIn(List<String> values) {
            addCriterion("contenido in", values, "contenido");
            return (Criteria) this;
        }

        public Criteria andContenidoNotIn(List<String> values) {
            addCriterion("contenido not in", values, "contenido");
            return (Criteria) this;
        }

        public Criteria andContenidoBetween(String value1, String value2) {
            addCriterion("contenido between", value1, value2, "contenido");
            return (Criteria) this;
        }

        public Criteria andContenidoNotBetween(String value1, String value2) {
            addCriterion("contenido not between", value1, value2, "contenido");
            return (Criteria) this;
        }

        public Criteria andDificultadIsNull() {
            addCriterion("dificultad is null");
            return (Criteria) this;
        }

        public Criteria andDificultadIsNotNull() {
            addCriterion("dificultad is not null");
            return (Criteria) this;
        }

        public Criteria andDificultadEqualTo(String value) {
            addCriterion("dificultad =", value, "dificultad");
            return (Criteria) this;
        }

        public Criteria andDificultadNotEqualTo(String value) {
            addCriterion("dificultad <>", value, "dificultad");
            return (Criteria) this;
        }

        public Criteria andDificultadGreaterThan(String value) {
            addCriterion("dificultad >", value, "dificultad");
            return (Criteria) this;
        }

        public Criteria andDificultadGreaterThanOrEqualTo(String value) {
            addCriterion("dificultad >=", value, "dificultad");
            return (Criteria) this;
        }

        public Criteria andDificultadLessThan(String value) {
            addCriterion("dificultad <", value, "dificultad");
            return (Criteria) this;
        }

        public Criteria andDificultadLessThanOrEqualTo(String value) {
            addCriterion("dificultad <=", value, "dificultad");
            return (Criteria) this;
        }

        public Criteria andDificultadLike(String value) {
            addCriterion("dificultad like", value, "dificultad");
            return (Criteria) this;
        }

        public Criteria andDificultadNotLike(String value) {
            addCriterion("dificultad not like", value, "dificultad");
            return (Criteria) this;
        }

        public Criteria andDificultadIn(List<String> values) {
            addCriterion("dificultad in", values, "dificultad");
            return (Criteria) this;
        }

        public Criteria andDificultadNotIn(List<String> values) {
            addCriterion("dificultad not in", values, "dificultad");
            return (Criteria) this;
        }

        public Criteria andDificultadBetween(String value1, String value2) {
            addCriterion("dificultad between", value1, value2, "dificultad");
            return (Criteria) this;
        }

        public Criteria andDificultadNotBetween(String value1, String value2) {
            addCriterion("dificultad not between", value1, value2, "dificultad");
            return (Criteria) this;
        }

        public Criteria andAprendidoIsNull() {
            addCriterion("aprendido is null");
            return (Criteria) this;
        }

        public Criteria andAprendidoIsNotNull() {
            addCriterion("aprendido is not null");
            return (Criteria) this;
        }

        public Criteria andAprendidoEqualTo(Boolean value) {
            addCriterion("aprendido =", value, "aprendido");
            return (Criteria) this;
        }

        public Criteria andAprendidoNotEqualTo(Boolean value) {
            addCriterion("aprendido <>", value, "aprendido");
            return (Criteria) this;
        }

        public Criteria andAprendidoGreaterThan(Boolean value) {
            addCriterion("aprendido >", value, "aprendido");
            return (Criteria) this;
        }

        public Criteria andAprendidoGreaterThanOrEqualTo(Boolean value) {
            addCriterion("aprendido >=", value, "aprendido");
            return (Criteria) this;
        }

        public Criteria andAprendidoLessThan(Boolean value) {
            addCriterion("aprendido <", value, "aprendido");
            return (Criteria) this;
        }

        public Criteria andAprendidoLessThanOrEqualTo(Boolean value) {
            addCriterion("aprendido <=", value, "aprendido");
            return (Criteria) this;
        }

        public Criteria andAprendidoIn(List<Boolean> values) {
            addCriterion("aprendido in", values, "aprendido");
            return (Criteria) this;
        }

        public Criteria andAprendidoNotIn(List<Boolean> values) {
            addCriterion("aprendido not in", values, "aprendido");
            return (Criteria) this;
        }

        public Criteria andAprendidoBetween(Boolean value1, Boolean value2) {
            addCriterion("aprendido between", value1, value2, "aprendido");
            return (Criteria) this;
        }

        public Criteria andAprendidoNotBetween(Boolean value1, Boolean value2) {
            addCriterion("aprendido not between", value1, value2, "aprendido");
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
            addCriterionForJDBCDate("p.fecha_registro between", value1, value2, "fechaRegistro");
            return (Criteria) this;
        }

        public Criteria andFechaRegistroNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fecha_registro not between", value1, value2, "fechaRegistro");
            return (Criteria) this;
        }

        public Criteria andCodTipoIsNull() {
            addCriterion("cod_tipo is null");
            return (Criteria) this;
        }

        public Criteria andCodTipoIsNotNull() {
            addCriterion("cod_tipo is not null");
            return (Criteria) this;
        }

        public Criteria andCodTipoEqualTo(String value) {
            addCriterion("p.cod_tipo =", value, "codTipo");
            return (Criteria) this;
        }

        public Criteria andCodTipoNotEqualTo(String value) {
            addCriterion("cod_tipo <>", value, "codTipo");
            return (Criteria) this;
        }

        public Criteria andCodTipoGreaterThan(String value) {
            addCriterion("cod_tipo >", value, "codTipo");
            return (Criteria) this;
        }

        public Criteria andCodTipoGreaterThanOrEqualTo(String value) {
            addCriterion("cod_tipo >=", value, "codTipo");
            return (Criteria) this;
        }

        public Criteria andCodTipoLessThan(String value) {
            addCriterion("cod_tipo <", value, "codTipo");
            return (Criteria) this;
        }

        public Criteria andCodTipoLessThanOrEqualTo(String value) {
            addCriterion("cod_tipo <=", value, "codTipo");
            return (Criteria) this;
        }

        public Criteria andCodTipoLike(String value) {
            addCriterion("cod_tipo like", value, "codTipo");
            return (Criteria) this;
        }

        public Criteria andCodTipoNotLike(String value) {
            addCriterion("cod_tipo not like", value, "codTipo");
            return (Criteria) this;
        }

        public Criteria andCodTipoIn(List<String> values) {
            addCriterion("cod_tipo in", values, "codTipo");
            return (Criteria) this;
        }

        public Criteria andCodTipoNotIn(List<String> values) {
            addCriterion("cod_tipo not in", values, "codTipo");
            return (Criteria) this;
        }

        public Criteria andCodTipoBetween(String value1, String value2) {
            addCriterion("cod_tipo between", value1, value2, "codTipo");
            return (Criteria) this;
        }

        public Criteria andCodTipoNotBetween(String value1, String value2) {
            addCriterion("cod_tipo not between", value1, value2, "codTipo");
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