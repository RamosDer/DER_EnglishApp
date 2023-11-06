package com.my_company.eapp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OracionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OracionExample() {
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

        public Criteria andIdOracionIsNull() {
            addCriterion("id_oracion is null");
            return (Criteria) this;
        }

        public Criteria andIdOracionIsNotNull() {
            addCriterion("id_oracion is not null");
            return (Criteria) this;
        }

        public Criteria andIdOracionEqualTo(Integer value) {
            addCriterion("id_oracion =", value, "idOracion");
            return (Criteria) this;
        }

        public Criteria andIdOracionNotEqualTo(Integer value) {
            addCriterion("id_oracion <>", value, "idOracion");
            return (Criteria) this;
        }

        public Criteria andIdOracionGreaterThan(Integer value) {
            addCriterion("id_oracion >", value, "idOracion");
            return (Criteria) this;
        }

        public Criteria andIdOracionGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_oracion >=", value, "idOracion");
            return (Criteria) this;
        }

        public Criteria andIdOracionLessThan(Integer value) {
            addCriterion("id_oracion <", value, "idOracion");
            return (Criteria) this;
        }

        public Criteria andIdOracionLessThanOrEqualTo(Integer value) {
            addCriterion("id_oracion <=", value, "idOracion");
            return (Criteria) this;
        }

        public Criteria andIdOracionIn(List<Integer> values) {
            addCriterion("id_oracion in", values, "idOracion");
            return (Criteria) this;
        }

        public Criteria andIdOracionNotIn(List<Integer> values) {
            addCriterion("id_oracion not in", values, "idOracion");
            return (Criteria) this;
        }

        public Criteria andIdOracionBetween(Integer value1, Integer value2) {
            addCriterion("id_oracion between", value1, value2, "idOracion");
            return (Criteria) this;
        }

        public Criteria andIdOracionNotBetween(Integer value1, Integer value2) {
            addCriterion("id_oracion not between", value1, value2, "idOracion");
            return (Criteria) this;
        }

        public Criteria andTextoIsNull() {
            addCriterion("texto is null");
            return (Criteria) this;
        }

        public Criteria andTextoIsNotNull() {
            addCriterion("texto is not null");
            return (Criteria) this;
        }

        public Criteria andTextoEqualTo(String value) {
            addCriterion("texto =", value, "texto");
            return (Criteria) this;
        }

        public Criteria andTextoNotEqualTo(String value) {
            addCriterion("texto <>", value, "texto");
            return (Criteria) this;
        }

        public Criteria andTextoGreaterThan(String value) {
            addCriterion("texto >", value, "texto");
            return (Criteria) this;
        }

        public Criteria andTextoGreaterThanOrEqualTo(String value) {
            addCriterion("texto >=", value, "texto");
            return (Criteria) this;
        }

        public Criteria andTextoLessThan(String value) {
            addCriterion("texto <", value, "texto");
            return (Criteria) this;
        }

        public Criteria andTextoLessThanOrEqualTo(String value) {
            addCriterion("texto <=", value, "texto");
            return (Criteria) this;
        }

        public Criteria andTextoLike(String value) {
            addCriterion("texto like", value, "texto");
            return (Criteria) this;
        }

        public Criteria andTextoNotLike(String value) {
            addCriterion("texto not like", value, "texto");
            return (Criteria) this;
        }

        public Criteria andTextoIn(List<String> values) {
            addCriterion("texto in", values, "texto");
            return (Criteria) this;
        }

        public Criteria andTextoNotIn(List<String> values) {
            addCriterion("texto not in", values, "texto");
            return (Criteria) this;
        }

        public Criteria andTextoBetween(String value1, String value2) {
            addCriterion("texto between", value1, value2, "texto");
            return (Criteria) this;
        }

        public Criteria andTextoNotBetween(String value1, String value2) {
            addCriterion("texto not between", value1, value2, "texto");
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