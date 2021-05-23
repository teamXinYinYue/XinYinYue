package com.xyy.po;

import java.util.ArrayList;
import java.util.List;

public class SingerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SingerExample() {
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

        public Criteria andS_idIsNull() {
            addCriterion("s_id is null");
            return (Criteria) this;
        }

        public Criteria andS_idIsNotNull() {
            addCriterion("s_id is not null");
            return (Criteria) this;
        }

        public Criteria andS_idEqualTo(Integer value) {
            addCriterion("s_id =", value, "s_id");
            return (Criteria) this;
        }

        public Criteria andS_idNotEqualTo(Integer value) {
            addCriterion("s_id <>", value, "s_id");
            return (Criteria) this;
        }

        public Criteria andS_idGreaterThan(Integer value) {
            addCriterion("s_id >", value, "s_id");
            return (Criteria) this;
        }

        public Criteria andS_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("s_id >=", value, "s_id");
            return (Criteria) this;
        }

        public Criteria andS_idLessThan(Integer value) {
            addCriterion("s_id <", value, "s_id");
            return (Criteria) this;
        }

        public Criteria andS_idLessThanOrEqualTo(Integer value) {
            addCriterion("s_id <=", value, "s_id");
            return (Criteria) this;
        }

        public Criteria andS_idIn(List<Integer> values) {
            addCriterion("s_id in", values, "s_id");
            return (Criteria) this;
        }

        public Criteria andS_idNotIn(List<Integer> values) {
            addCriterion("s_id not in", values, "s_id");
            return (Criteria) this;
        }

        public Criteria andS_idBetween(Integer value1, Integer value2) {
            addCriterion("s_id between", value1, value2, "s_id");
            return (Criteria) this;
        }

        public Criteria andS_idNotBetween(Integer value1, Integer value2) {
            addCriterion("s_id not between", value1, value2, "s_id");
            return (Criteria) this;
        }

        public Criteria andS_nameIsNull() {
            addCriterion("s_name is null");
            return (Criteria) this;
        }

        public Criteria andS_nameIsNotNull() {
            addCriterion("s_name is not null");
            return (Criteria) this;
        }

        public Criteria andS_nameEqualTo(String value) {
            addCriterion("s_name =", value, "s_name");
            return (Criteria) this;
        }

        public Criteria andS_nameNotEqualTo(String value) {
            addCriterion("s_name <>", value, "s_name");
            return (Criteria) this;
        }

        public Criteria andS_nameGreaterThan(String value) {
            addCriterion("s_name >", value, "s_name");
            return (Criteria) this;
        }

        public Criteria andS_nameGreaterThanOrEqualTo(String value) {
            addCriterion("s_name >=", value, "s_name");
            return (Criteria) this;
        }

        public Criteria andS_nameLessThan(String value) {
            addCriterion("s_name <", value, "s_name");
            return (Criteria) this;
        }

        public Criteria andS_nameLessThanOrEqualTo(String value) {
            addCriterion("s_name <=", value, "s_name");
            return (Criteria) this;
        }

        public Criteria andS_nameLike(String value) {
            addCriterion("s_name like", value, "s_name");
            return (Criteria) this;
        }

        public Criteria andS_nameNotLike(String value) {
            addCriterion("s_name not like", value, "s_name");
            return (Criteria) this;
        }

        public Criteria andS_nameIn(List<String> values) {
            addCriterion("s_name in", values, "s_name");
            return (Criteria) this;
        }

        public Criteria andS_nameNotIn(List<String> values) {
            addCriterion("s_name not in", values, "s_name");
            return (Criteria) this;
        }

        public Criteria andS_nameBetween(String value1, String value2) {
            addCriterion("s_name between", value1, value2, "s_name");
            return (Criteria) this;
        }

        public Criteria andS_nameNotBetween(String value1, String value2) {
            addCriterion("s_name not between", value1, value2, "s_name");
            return (Criteria) this;
        }

        public Criteria andS_infoIsNull() {
            addCriterion("s_info is null");
            return (Criteria) this;
        }

        public Criteria andS_infoIsNotNull() {
            addCriterion("s_info is not null");
            return (Criteria) this;
        }

        public Criteria andS_infoEqualTo(String value) {
            addCriterion("s_info =", value, "s_info");
            return (Criteria) this;
        }

        public Criteria andS_infoNotEqualTo(String value) {
            addCriterion("s_info <>", value, "s_info");
            return (Criteria) this;
        }

        public Criteria andS_infoGreaterThan(String value) {
            addCriterion("s_info >", value, "s_info");
            return (Criteria) this;
        }

        public Criteria andS_infoGreaterThanOrEqualTo(String value) {
            addCriterion("s_info >=", value, "s_info");
            return (Criteria) this;
        }

        public Criteria andS_infoLessThan(String value) {
            addCriterion("s_info <", value, "s_info");
            return (Criteria) this;
        }

        public Criteria andS_infoLessThanOrEqualTo(String value) {
            addCriterion("s_info <=", value, "s_info");
            return (Criteria) this;
        }

        public Criteria andS_infoLike(String value) {
            addCriterion("s_info like", value, "s_info");
            return (Criteria) this;
        }

        public Criteria andS_infoNotLike(String value) {
            addCriterion("s_info not like", value, "s_info");
            return (Criteria) this;
        }

        public Criteria andS_infoIn(List<String> values) {
            addCriterion("s_info in", values, "s_info");
            return (Criteria) this;
        }

        public Criteria andS_infoNotIn(List<String> values) {
            addCriterion("s_info not in", values, "s_info");
            return (Criteria) this;
        }

        public Criteria andS_infoBetween(String value1, String value2) {
            addCriterion("s_info between", value1, value2, "s_info");
            return (Criteria) this;
        }

        public Criteria andS_infoNotBetween(String value1, String value2) {
            addCriterion("s_info not between", value1, value2, "s_info");
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