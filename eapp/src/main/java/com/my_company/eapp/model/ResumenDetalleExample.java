package com.my_company.eapp.model;

import java.util.ArrayList;
import java.util.List;

public class ResumenDetalleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResumenDetalleExample() {
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

        public Criteria andIdResumenDetalleIsNull() {
            addCriterion("id_resumen_detalle is null");
            return (Criteria) this;
        }

        public Criteria andIdResumenDetalleIsNotNull() {
            addCriterion("id_resumen_detalle is not null");
            return (Criteria) this;
        }

        public Criteria andIdResumenDetalleEqualTo(Long value) {
            addCriterion("id_resumen_detalle =", value, "idResumenDetalle");
            return (Criteria) this;
        }

        public Criteria andIdResumenDetalleNotEqualTo(Long value) {
            addCriterion("id_resumen_detalle <>", value, "idResumenDetalle");
            return (Criteria) this;
        }

        public Criteria andIdResumenDetalleGreaterThan(Long value) {
            addCriterion("id_resumen_detalle >", value, "idResumenDetalle");
            return (Criteria) this;
        }

        public Criteria andIdResumenDetalleGreaterThanOrEqualTo(Long value) {
            addCriterion("id_resumen_detalle >=", value, "idResumenDetalle");
            return (Criteria) this;
        }

        public Criteria andIdResumenDetalleLessThan(Long value) {
            addCriterion("id_resumen_detalle <", value, "idResumenDetalle");
            return (Criteria) this;
        }

        public Criteria andIdResumenDetalleLessThanOrEqualTo(Long value) {
            addCriterion("id_resumen_detalle <=", value, "idResumenDetalle");
            return (Criteria) this;
        }

        public Criteria andIdResumenDetalleIn(List<Long> values) {
            addCriterion("id_resumen_detalle in", values, "idResumenDetalle");
            return (Criteria) this;
        }

        public Criteria andIdResumenDetalleNotIn(List<Long> values) {
            addCriterion("id_resumen_detalle not in", values, "idResumenDetalle");
            return (Criteria) this;
        }

        public Criteria andIdResumenDetalleBetween(Long value1, Long value2) {
            addCriterion("id_resumen_detalle between", value1, value2, "idResumenDetalle");
            return (Criteria) this;
        }

        public Criteria andIdResumenDetalleNotBetween(Long value1, Long value2) {
            addCriterion("id_resumen_detalle not between", value1, value2, "idResumenDetalle");
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

        public Criteria andCorrectoIsNull() {
            addCriterion("correcto is null");
            return (Criteria) this;
        }

        public Criteria andCorrectoIsNotNull() {
            addCriterion("correcto is not null");
            return (Criteria) this;
        }

        public Criteria andCorrectoEqualTo(Boolean value) {
            addCriterion("correcto =", value, "correcto");
            return (Criteria) this;
        }

        public Criteria andCorrectoNotEqualTo(Boolean value) {
            addCriterion("correcto <>", value, "correcto");
            return (Criteria) this;
        }

        public Criteria andCorrectoGreaterThan(Boolean value) {
            addCriterion("correcto >", value, "correcto");
            return (Criteria) this;
        }

        public Criteria andCorrectoGreaterThanOrEqualTo(Boolean value) {
            addCriterion("correcto >=", value, "correcto");
            return (Criteria) this;
        }

        public Criteria andCorrectoLessThan(Boolean value) {
            addCriterion("correcto <", value, "correcto");
            return (Criteria) this;
        }

        public Criteria andCorrectoLessThanOrEqualTo(Boolean value) {
            addCriterion("correcto <=", value, "correcto");
            return (Criteria) this;
        }

        public Criteria andCorrectoIn(List<Boolean> values) {
            addCriterion("correcto in", values, "correcto");
            return (Criteria) this;
        }

        public Criteria andCorrectoNotIn(List<Boolean> values) {
            addCriterion("correcto not in", values, "correcto");
            return (Criteria) this;
        }

        public Criteria andCorrectoBetween(Boolean value1, Boolean value2) {
            addCriterion("correcto between", value1, value2, "correcto");
            return (Criteria) this;
        }

        public Criteria andCorrectoNotBetween(Boolean value1, Boolean value2) {
            addCriterion("correcto not between", value1, value2, "correcto");
            return (Criteria) this;
        }

        public Criteria andIdResumenIsNull() {
            addCriterion("id_resumen is null");
            return (Criteria) this;
        }

        public Criteria andIdResumenIsNotNull() {
            addCriterion("id_resumen is not null");
            return (Criteria) this;
        }

        public Criteria andIdResumenEqualTo(Integer value) {
            addCriterion("id_resumen =", value, "idResumen");
            return (Criteria) this;
        }

        public Criteria andIdResumenNotEqualTo(Integer value) {
            addCriterion("id_resumen <>", value, "idResumen");
            return (Criteria) this;
        }

        public Criteria andIdResumenGreaterThan(Integer value) {
            addCriterion("id_resumen >", value, "idResumen");
            return (Criteria) this;
        }

        public Criteria andIdResumenGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_resumen >=", value, "idResumen");
            return (Criteria) this;
        }

        public Criteria andIdResumenLessThan(Integer value) {
            addCriterion("id_resumen <", value, "idResumen");
            return (Criteria) this;
        }

        public Criteria andIdResumenLessThanOrEqualTo(Integer value) {
            addCriterion("id_resumen <=", value, "idResumen");
            return (Criteria) this;
        }

        public Criteria andIdResumenIn(List<Integer> values) {
            addCriterion("id_resumen in", values, "idResumen");
            return (Criteria) this;
        }

        public Criteria andIdResumenNotIn(List<Integer> values) {
            addCriterion("id_resumen not in", values, "idResumen");
            return (Criteria) this;
        }

        public Criteria andIdResumenBetween(Integer value1, Integer value2) {
            addCriterion("id_resumen between", value1, value2, "idResumen");
            return (Criteria) this;
        }

        public Criteria andIdResumenNotBetween(Integer value1, Integer value2) {
            addCriterion("id_resumen not between", value1, value2, "idResumen");
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