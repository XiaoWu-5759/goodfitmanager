package com.simba.goodfitmanager.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FitChangeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FitChangeExample() {
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

        public Criteria andOldIcidIsNull() {
            addCriterion("old_icid is null");
            return (Criteria) this;
        }

        public Criteria andOldIcidIsNotNull() {
            addCriterion("old_icid is not null");
            return (Criteria) this;
        }

        public Criteria andOldIcidEqualTo(String value) {
            addCriterion("old_icid =", value, "oldIcid");
            return (Criteria) this;
        }

        public Criteria andOldIcidNotEqualTo(String value) {
            addCriterion("old_icid <>", value, "oldIcid");
            return (Criteria) this;
        }

        public Criteria andOldIcidGreaterThan(String value) {
            addCriterion("old_icid >", value, "oldIcid");
            return (Criteria) this;
        }

        public Criteria andOldIcidGreaterThanOrEqualTo(String value) {
            addCriterion("old_icid >=", value, "oldIcid");
            return (Criteria) this;
        }

        public Criteria andOldIcidLessThan(String value) {
            addCriterion("old_icid <", value, "oldIcid");
            return (Criteria) this;
        }

        public Criteria andOldIcidLessThanOrEqualTo(String value) {
            addCriterion("old_icid <=", value, "oldIcid");
            return (Criteria) this;
        }

        public Criteria andOldIcidLike(String value) {
            addCriterion("old_icid like", value, "oldIcid");
            return (Criteria) this;
        }

        public Criteria andOldIcidNotLike(String value) {
            addCriterion("old_icid not like", value, "oldIcid");
            return (Criteria) this;
        }

        public Criteria andOldIcidIn(List<String> values) {
            addCriterion("old_icid in", values, "oldIcid");
            return (Criteria) this;
        }

        public Criteria andOldIcidNotIn(List<String> values) {
            addCriterion("old_icid not in", values, "oldIcid");
            return (Criteria) this;
        }

        public Criteria andOldIcidBetween(String value1, String value2) {
            addCriterion("old_icid between", value1, value2, "oldIcid");
            return (Criteria) this;
        }

        public Criteria andOldIcidNotBetween(String value1, String value2) {
            addCriterion("old_icid not between", value1, value2, "oldIcid");
            return (Criteria) this;
        }

        public Criteria andNewIcidIsNull() {
            addCriterion("new_icid is null");
            return (Criteria) this;
        }

        public Criteria andNewIcidIsNotNull() {
            addCriterion("new_icid is not null");
            return (Criteria) this;
        }

        public Criteria andNewIcidEqualTo(String value) {
            addCriterion("new_icid =", value, "newIcid");
            return (Criteria) this;
        }

        public Criteria andNewIcidNotEqualTo(String value) {
            addCriterion("new_icid <>", value, "newIcid");
            return (Criteria) this;
        }

        public Criteria andNewIcidGreaterThan(String value) {
            addCriterion("new_icid >", value, "newIcid");
            return (Criteria) this;
        }

        public Criteria andNewIcidGreaterThanOrEqualTo(String value) {
            addCriterion("new_icid >=", value, "newIcid");
            return (Criteria) this;
        }

        public Criteria andNewIcidLessThan(String value) {
            addCriterion("new_icid <", value, "newIcid");
            return (Criteria) this;
        }

        public Criteria andNewIcidLessThanOrEqualTo(String value) {
            addCriterion("new_icid <=", value, "newIcid");
            return (Criteria) this;
        }

        public Criteria andNewIcidLike(String value) {
            addCriterion("new_icid like", value, "newIcid");
            return (Criteria) this;
        }

        public Criteria andNewIcidNotLike(String value) {
            addCriterion("new_icid not like", value, "newIcid");
            return (Criteria) this;
        }

        public Criteria andNewIcidIn(List<String> values) {
            addCriterion("new_icid in", values, "newIcid");
            return (Criteria) this;
        }

        public Criteria andNewIcidNotIn(List<String> values) {
            addCriterion("new_icid not in", values, "newIcid");
            return (Criteria) this;
        }

        public Criteria andNewIcidBetween(String value1, String value2) {
            addCriterion("new_icid between", value1, value2, "newIcid");
            return (Criteria) this;
        }

        public Criteria andNewIcidNotBetween(String value1, String value2) {
            addCriterion("new_icid not between", value1, value2, "newIcid");
            return (Criteria) this;
        }

        public Criteria andChangeTimeIsNull() {
            addCriterion("change_time is null");
            return (Criteria) this;
        }

        public Criteria andChangeTimeIsNotNull() {
            addCriterion("change_time is not null");
            return (Criteria) this;
        }

        public Criteria andChangeTimeEqualTo(Date value) {
            addCriterion("change_time =", value, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeNotEqualTo(Date value) {
            addCriterion("change_time <>", value, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeGreaterThan(Date value) {
            addCriterion("change_time >", value, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("change_time >=", value, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeLessThan(Date value) {
            addCriterion("change_time <", value, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeLessThanOrEqualTo(Date value) {
            addCriterion("change_time <=", value, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeIn(List<Date> values) {
            addCriterion("change_time in", values, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeNotIn(List<Date> values) {
            addCriterion("change_time not in", values, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeBetween(Date value1, Date value2) {
            addCriterion("change_time between", value1, value2, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeNotBetween(Date value1, Date value2) {
            addCriterion("change_time not between", value1, value2, "changeTime");
            return (Criteria) this;
        }

        public Criteria andC4sIdIsNull() {
            addCriterion("c_4s_id is null");
            return (Criteria) this;
        }

        public Criteria andC4sIdIsNotNull() {
            addCriterion("c_4s_id is not null");
            return (Criteria) this;
        }

        public Criteria andC4sIdEqualTo(Integer value) {
            addCriterion("c_4s_id =", value, "c4sId");
            return (Criteria) this;
        }

        public Criteria andC4sIdNotEqualTo(Integer value) {
            addCriterion("c_4s_id <>", value, "c4sId");
            return (Criteria) this;
        }

        public Criteria andC4sIdGreaterThan(Integer value) {
            addCriterion("c_4s_id >", value, "c4sId");
            return (Criteria) this;
        }

        public Criteria andC4sIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_4s_id >=", value, "c4sId");
            return (Criteria) this;
        }

        public Criteria andC4sIdLessThan(Integer value) {
            addCriterion("c_4s_id <", value, "c4sId");
            return (Criteria) this;
        }

        public Criteria andC4sIdLessThanOrEqualTo(Integer value) {
            addCriterion("c_4s_id <=", value, "c4sId");
            return (Criteria) this;
        }

        public Criteria andC4sIdIn(List<Integer> values) {
            addCriterion("c_4s_id in", values, "c4sId");
            return (Criteria) this;
        }

        public Criteria andC4sIdNotIn(List<Integer> values) {
            addCriterion("c_4s_id not in", values, "c4sId");
            return (Criteria) this;
        }

        public Criteria andC4sIdBetween(Integer value1, Integer value2) {
            addCriterion("c_4s_id between", value1, value2, "c4sId");
            return (Criteria) this;
        }

        public Criteria andC4sIdNotBetween(Integer value1, Integer value2) {
            addCriterion("c_4s_id not between", value1, value2, "c4sId");
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