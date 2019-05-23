package com.simba.goodfitmanager.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FitUnbindExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FitUnbindExample() {
        oredCriteria = new ArrayList<Criteria>();
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
            criteria = new ArrayList<Criterion>();
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

        public Criteria andIcidIsNull() {
            addCriterion("icid is null");
            return (Criteria) this;
        }

        public Criteria andIcidIsNotNull() {
            addCriterion("icid is not null");
            return (Criteria) this;
        }

        public Criteria andIcidEqualTo(String value) {
            addCriterion("icid =", value, "icid");
            return (Criteria) this;
        }

        public Criteria andIcidNotEqualTo(String value) {
            addCriterion("icid <>", value, "icid");
            return (Criteria) this;
        }

        public Criteria andIcidGreaterThan(String value) {
            addCriterion("icid >", value, "icid");
            return (Criteria) this;
        }

        public Criteria andIcidGreaterThanOrEqualTo(String value) {
            addCriterion("icid >=", value, "icid");
            return (Criteria) this;
        }

        public Criteria andIcidLessThan(String value) {
            addCriterion("icid <", value, "icid");
            return (Criteria) this;
        }

        public Criteria andIcidLessThanOrEqualTo(String value) {
            addCriterion("icid <=", value, "icid");
            return (Criteria) this;
        }

        public Criteria andIcidLike(String value) {
            addCriterion("icid like", value, "icid");
            return (Criteria) this;
        }

        public Criteria andIcidNotLike(String value) {
            addCriterion("icid not like", value, "icid");
            return (Criteria) this;
        }

        public Criteria andIcidIn(List<String> values) {
            addCriterion("icid in", values, "icid");
            return (Criteria) this;
        }

        public Criteria andIcidNotIn(List<String> values) {
            addCriterion("icid not in", values, "icid");
            return (Criteria) this;
        }

        public Criteria andIcidBetween(String value1, String value2) {
            addCriterion("icid between", value1, value2, "icid");
            return (Criteria) this;
        }

        public Criteria andIcidNotBetween(String value1, String value2) {
            addCriterion("icid not between", value1, value2, "icid");
            return (Criteria) this;
        }

        public Criteria andRelieveTimeIsNull() {
            addCriterion("relieve_time is null");
            return (Criteria) this;
        }

        public Criteria andRelieveTimeIsNotNull() {
            addCriterion("relieve_time is not null");
            return (Criteria) this;
        }

        public Criteria andRelieveTimeEqualTo(Date value) {
            addCriterion("relieve_time =", value, "relieveTime");
            return (Criteria) this;
        }

        public Criteria andRelieveTimeNotEqualTo(Date value) {
            addCriterion("relieve_time <>", value, "relieveTime");
            return (Criteria) this;
        }

        public Criteria andRelieveTimeGreaterThan(Date value) {
            addCriterion("relieve_time >", value, "relieveTime");
            return (Criteria) this;
        }

        public Criteria andRelieveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("relieve_time >=", value, "relieveTime");
            return (Criteria) this;
        }

        public Criteria andRelieveTimeLessThan(Date value) {
            addCriterion("relieve_time <", value, "relieveTime");
            return (Criteria) this;
        }

        public Criteria andRelieveTimeLessThanOrEqualTo(Date value) {
            addCriterion("relieve_time <=", value, "relieveTime");
            return (Criteria) this;
        }

        public Criteria andRelieveTimeIn(List<Date> values) {
            addCriterion("relieve_time in", values, "relieveTime");
            return (Criteria) this;
        }

        public Criteria andRelieveTimeNotIn(List<Date> values) {
            addCriterion("relieve_time not in", values, "relieveTime");
            return (Criteria) this;
        }

        public Criteria andRelieveTimeBetween(Date value1, Date value2) {
            addCriterion("relieve_time between", value1, value2, "relieveTime");
            return (Criteria) this;
        }

        public Criteria andRelieveTimeNotBetween(Date value1, Date value2) {
            addCriterion("relieve_time not between", value1, value2, "relieveTime");
            return (Criteria) this;
        }

        public Criteria andRelieveCarIsNull() {
            addCriterion("relieve_car is null");
            return (Criteria) this;
        }

        public Criteria andRelieveCarIsNotNull() {
            addCriterion("relieve_car is not null");
            return (Criteria) this;
        }

        public Criteria andRelieveCarEqualTo(String value) {
            addCriterion("relieve_car =", value, "relieveCar");
            return (Criteria) this;
        }

        public Criteria andRelieveCarNotEqualTo(String value) {
            addCriterion("relieve_car <>", value, "relieveCar");
            return (Criteria) this;
        }

        public Criteria andRelieveCarGreaterThan(String value) {
            addCriterion("relieve_car >", value, "relieveCar");
            return (Criteria) this;
        }

        public Criteria andRelieveCarGreaterThanOrEqualTo(String value) {
            addCriterion("relieve_car >=", value, "relieveCar");
            return (Criteria) this;
        }

        public Criteria andRelieveCarLessThan(String value) {
            addCriterion("relieve_car <", value, "relieveCar");
            return (Criteria) this;
        }

        public Criteria andRelieveCarLessThanOrEqualTo(String value) {
            addCriterion("relieve_car <=", value, "relieveCar");
            return (Criteria) this;
        }

        public Criteria andRelieveCarLike(String value) {
            addCriterion("relieve_car like", value, "relieveCar");
            return (Criteria) this;
        }

        public Criteria andRelieveCarNotLike(String value) {
            addCriterion("relieve_car not like", value, "relieveCar");
            return (Criteria) this;
        }

        public Criteria andRelieveCarIn(List<String> values) {
            addCriterion("relieve_car in", values, "relieveCar");
            return (Criteria) this;
        }

        public Criteria andRelieveCarNotIn(List<String> values) {
            addCriterion("relieve_car not in", values, "relieveCar");
            return (Criteria) this;
        }

        public Criteria andRelieveCarBetween(String value1, String value2) {
            addCriterion("relieve_car between", value1, value2, "relieveCar");
            return (Criteria) this;
        }

        public Criteria andRelieveCarNotBetween(String value1, String value2) {
            addCriterion("relieve_car not between", value1, value2, "relieveCar");
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