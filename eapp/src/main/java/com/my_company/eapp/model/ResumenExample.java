package com.my_company.eapp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ResumenExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResumenExample() {
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

        public Criteria andTiempoIsNull() {
            addCriterion("tiempo is null");
            return (Criteria) this;
        }

        public Criteria andTiempoIsNotNull() {
            addCriterion("tiempo is not null");
            return (Criteria) this;
        }

        public Criteria andTiempoEqualTo(Integer value) {
            addCriterion("tiempo =", value, "tiempo");
            return (Criteria) this;
        }

        public Criteria andTiempoNotEqualTo(Integer value) {
            addCriterion("tiempo <>", value, "tiempo");
            return (Criteria) this;
        }

        public Criteria andTiempoGreaterThan(Integer value) {
            addCriterion("tiempo >", value, "tiempo");
            return (Criteria) this;
        }

        public Criteria andTiempoGreaterThanOrEqualTo(Integer value) {
            addCriterion("tiempo >=", value, "tiempo");
            return (Criteria) this;
        }

        public Criteria andTiempoLessThan(Integer value) {
            addCriterion("tiempo <", value, "tiempo");
            return (Criteria) this;
        }

        public Criteria andTiempoLessThanOrEqualTo(Integer value) {
            addCriterion("tiempo <=", value, "tiempo");
            return (Criteria) this;
        }

        public Criteria andTiempoIn(List<Integer> values) {
            addCriterion("tiempo in", values, "tiempo");
            return (Criteria) this;
        }

        public Criteria andTiempoNotIn(List<Integer> values) {
            addCriterion("tiempo not in", values, "tiempo");
            return (Criteria) this;
        }

        public Criteria andTiempoBetween(Integer value1, Integer value2) {
            addCriterion("tiempo between", value1, value2, "tiempo");
            return (Criteria) this;
        }

        public Criteria andTiempoNotBetween(Integer value1, Integer value2) {
            addCriterion("tiempo not between", value1, value2, "tiempo");
            return (Criteria) this;
        }

        public Criteria andFechaDePracticaIsNull() {
            addCriterion("fecha_de_practica is null");
            return (Criteria) this;
        }

        public Criteria andFechaDePracticaIsNotNull() {
            addCriterion("fecha_de_practica is not null");
            return (Criteria) this;
        }

        public Criteria andFechaDePracticaEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_de_practica =", value, "fechaDePractica");
            return (Criteria) this;
        }

        public Criteria andFechaDePracticaNotEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_de_practica <>", value, "fechaDePractica");
            return (Criteria) this;
        }

        public Criteria andFechaDePracticaGreaterThan(Date value) {
            addCriterionForJDBCDate("fecha_de_practica >", value, "fechaDePractica");
            return (Criteria) this;
        }

        public Criteria andFechaDePracticaGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_de_practica >=", value, "fechaDePractica");
            return (Criteria) this;
        }

        public Criteria andFechaDePracticaLessThan(Date value) {
            addCriterionForJDBCDate("fecha_de_practica <", value, "fechaDePractica");
            return (Criteria) this;
        }

        public Criteria andFechaDePracticaLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_de_practica <=", value, "fechaDePractica");
            return (Criteria) this;
        }

        public Criteria andFechaDePracticaIn(List<Date> values) {
            addCriterionForJDBCDate("fecha_de_practica in", values, "fechaDePractica");
            return (Criteria) this;
        }

        public Criteria andFechaDePracticaNotIn(List<Date> values) {
            addCriterionForJDBCDate("fecha_de_practica not in", values, "fechaDePractica");
            return (Criteria) this;
        }

        public Criteria andFechaDePracticaBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fecha_de_practica between", value1, value2, "fechaDePractica");
            return (Criteria) this;
        }

        public Criteria andFechaDePracticaNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fecha_de_practica not between", value1, value2, "fechaDePractica");
            return (Criteria) this;
        }

        public Criteria andAciertosIsNull() {
            addCriterion("aciertos is null");
            return (Criteria) this;
        }

        public Criteria andAciertosIsNotNull() {
            addCriterion("aciertos is not null");
            return (Criteria) this;
        }

        public Criteria andAciertosEqualTo(Integer value) {
            addCriterion("aciertos =", value, "aciertos");
            return (Criteria) this;
        }

        public Criteria andAciertosNotEqualTo(Integer value) {
            addCriterion("aciertos <>", value, "aciertos");
            return (Criteria) this;
        }

        public Criteria andAciertosGreaterThan(Integer value) {
            addCriterion("aciertos >", value, "aciertos");
            return (Criteria) this;
        }

        public Criteria andAciertosGreaterThanOrEqualTo(Integer value) {
            addCriterion("aciertos >=", value, "aciertos");
            return (Criteria) this;
        }

        public Criteria andAciertosLessThan(Integer value) {
            addCriterion("aciertos <", value, "aciertos");
            return (Criteria) this;
        }

        public Criteria andAciertosLessThanOrEqualTo(Integer value) {
            addCriterion("aciertos <=", value, "aciertos");
            return (Criteria) this;
        }

        public Criteria andAciertosIn(List<Integer> values) {
            addCriterion("aciertos in", values, "aciertos");
            return (Criteria) this;
        }

        public Criteria andAciertosNotIn(List<Integer> values) {
            addCriterion("aciertos not in", values, "aciertos");
            return (Criteria) this;
        }

        public Criteria andAciertosBetween(Integer value1, Integer value2) {
            addCriterion("aciertos between", value1, value2, "aciertos");
            return (Criteria) this;
        }

        public Criteria andAciertosNotBetween(Integer value1, Integer value2) {
            addCriterion("aciertos not between", value1, value2, "aciertos");
            return (Criteria) this;
        }

        public Criteria andPalabrasPracticadasIsNull() {
            addCriterion("palabras_practicadas is null");
            return (Criteria) this;
        }

        public Criteria andPalabrasPracticadasIsNotNull() {
            addCriterion("palabras_practicadas is not null");
            return (Criteria) this;
        }

        public Criteria andPalabrasPracticadasEqualTo(Integer value) {
            addCriterion("palabras_practicadas =", value, "palabrasPracticadas");
            return (Criteria) this;
        }

        public Criteria andPalabrasPracticadasNotEqualTo(Integer value) {
            addCriterion("palabras_practicadas <>", value, "palabrasPracticadas");
            return (Criteria) this;
        }

        public Criteria andPalabrasPracticadasGreaterThan(Integer value) {
            addCriterion("palabras_practicadas >", value, "palabrasPracticadas");
            return (Criteria) this;
        }

        public Criteria andPalabrasPracticadasGreaterThanOrEqualTo(Integer value) {
            addCriterion("palabras_practicadas >=", value, "palabrasPracticadas");
            return (Criteria) this;
        }

        public Criteria andPalabrasPracticadasLessThan(Integer value) {
            addCriterion("palabras_practicadas <", value, "palabrasPracticadas");
            return (Criteria) this;
        }

        public Criteria andPalabrasPracticadasLessThanOrEqualTo(Integer value) {
            addCriterion("palabras_practicadas <=", value, "palabrasPracticadas");
            return (Criteria) this;
        }

        public Criteria andPalabrasPracticadasIn(List<Integer> values) {
            addCriterion("palabras_practicadas in", values, "palabrasPracticadas");
            return (Criteria) this;
        }

        public Criteria andPalabrasPracticadasNotIn(List<Integer> values) {
            addCriterion("palabras_practicadas not in", values, "palabrasPracticadas");
            return (Criteria) this;
        }

        public Criteria andPalabrasPracticadasBetween(Integer value1, Integer value2) {
            addCriterion("palabras_practicadas between", value1, value2, "palabrasPracticadas");
            return (Criteria) this;
        }

        public Criteria andPalabrasPracticadasNotBetween(Integer value1, Integer value2) {
            addCriterion("palabras_practicadas not between", value1, value2, "palabrasPracticadas");
            return (Criteria) this;
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

        public Criteria andIdTipoPracticaIsNull() {
            addCriterion("id_tipo_practica is null");
            return (Criteria) this;
        }

        public Criteria andIdTipoPracticaIsNotNull() {
            addCriterion("id_tipo_practica is not null");
            return (Criteria) this;
        }

        public Criteria andIdTipoPracticaEqualTo(Integer value) {
            addCriterion("id_tipo_practica =", value, "idTipoPractica");
            return (Criteria) this;
        }

        public Criteria andIdTipoPracticaNotEqualTo(Integer value) {
            addCriterion("id_tipo_practica <>", value, "idTipoPractica");
            return (Criteria) this;
        }

        public Criteria andIdTipoPracticaGreaterThan(Integer value) {
            addCriterion("id_tipo_practica >", value, "idTipoPractica");
            return (Criteria) this;
        }

        public Criteria andIdTipoPracticaGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_tipo_practica >=", value, "idTipoPractica");
            return (Criteria) this;
        }

        public Criteria andIdTipoPracticaLessThan(Integer value) {
            addCriterion("id_tipo_practica <", value, "idTipoPractica");
            return (Criteria) this;
        }

        public Criteria andIdTipoPracticaLessThanOrEqualTo(Integer value) {
            addCriterion("id_tipo_practica <=", value, "idTipoPractica");
            return (Criteria) this;
        }

        public Criteria andIdTipoPracticaIn(List<Integer> values) {
            addCriterion("id_tipo_practica in", values, "idTipoPractica");
            return (Criteria) this;
        }

        public Criteria andIdTipoPracticaNotIn(List<Integer> values) {
            addCriterion("id_tipo_practica not in", values, "idTipoPractica");
            return (Criteria) this;
        }

        public Criteria andIdTipoPracticaBetween(Integer value1, Integer value2) {
            addCriterion("id_tipo_practica between", value1, value2, "idTipoPractica");
            return (Criteria) this;
        }

        public Criteria andIdTipoPracticaNotBetween(Integer value1, Integer value2) {
            addCriterion("id_tipo_practica not between", value1, value2, "idTipoPractica");
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