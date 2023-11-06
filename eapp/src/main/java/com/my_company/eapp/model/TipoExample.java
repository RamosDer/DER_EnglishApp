package com.my_company.eapp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TipoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TipoExample() {
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

        public Criteria andCodTipoIsNull() {
            addCriterion("cod_tipo is null");
            return (Criteria) this;
        }

        public Criteria andCodTipoIsNotNull() {
            addCriterion("cod_tipo is not null");
            return (Criteria) this;
        }

        public Criteria andCodTipoEqualTo(String value) {
            addCriterion("cod_tipo =", value, "codTipo");
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

        public Criteria andDescripcionIsNull() {
            addCriterion("descripcion is null");
            return (Criteria) this;
        }

        public Criteria andDescripcionIsNotNull() {
            addCriterion("descripcion is not null");
            return (Criteria) this;
        }

        public Criteria andDescripcionEqualTo(String value) {
            addCriterion("descripcion =", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionNotEqualTo(String value) {
            addCriterion("descripcion <>", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionGreaterThan(String value) {
            addCriterion("descripcion >", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionGreaterThanOrEqualTo(String value) {
            addCriterion("descripcion >=", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionLessThan(String value) {
            addCriterion("descripcion <", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionLessThanOrEqualTo(String value) {
            addCriterion("descripcion <=", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionLike(String value) {
            addCriterion("descripcion like", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionNotLike(String value) {
            addCriterion("descripcion not like", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionIn(List<String> values) {
            addCriterion("descripcion in", values, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionNotIn(List<String> values) {
            addCriterion("descripcion not in", values, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionBetween(String value1, String value2) {
            addCriterion("descripcion between", value1, value2, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionNotBetween(String value1, String value2) {
            addCriterion("descripcion not between", value1, value2, "descripcion");
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

        public Criteria andIdCategoriaIsNull() {
            addCriterion("id_categoria is null");
            return (Criteria) this;
        }

        public Criteria andIdCategoriaIsNotNull() {
            addCriterion("id_categoria is not null");
            return (Criteria) this;
        }

        public Criteria andIdCategoriaEqualTo(Integer value) {
            addCriterion("id_categoria =", value, "idCategoria");
            return (Criteria) this;
        }

        public Criteria andIdCategoriaNotEqualTo(Integer value) {
            addCriterion("id_categoria <>", value, "idCategoria");
            return (Criteria) this;
        }

        public Criteria andIdCategoriaGreaterThan(Integer value) {
            addCriterion("id_categoria >", value, "idCategoria");
            return (Criteria) this;
        }

        public Criteria andIdCategoriaGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_categoria >=", value, "idCategoria");
            return (Criteria) this;
        }

        public Criteria andIdCategoriaLessThan(Integer value) {
            addCriterion("id_categoria <", value, "idCategoria");
            return (Criteria) this;
        }

        public Criteria andIdCategoriaLessThanOrEqualTo(Integer value) {
            addCriterion("id_categoria <=", value, "idCategoria");
            return (Criteria) this;
        }

        public Criteria andIdCategoriaIn(List<Integer> values) {
            addCriterion("id_categoria in", values, "idCategoria");
            return (Criteria) this;
        }

        public Criteria andIdCategoriaNotIn(List<Integer> values) {
            addCriterion("id_categoria not in", values, "idCategoria");
            return (Criteria) this;
        }

        public Criteria andIdCategoriaBetween(Integer value1, Integer value2) {
            addCriterion("id_categoria between", value1, value2, "idCategoria");
            return (Criteria) this;
        }

        public Criteria andIdCategoriaNotBetween(Integer value1, Integer value2) {
            addCriterion("id_categoria not between", value1, value2, "idCategoria");
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