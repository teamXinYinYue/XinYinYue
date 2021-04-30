package com.xyy.po;

import java.util.ArrayList;
import java.util.List;

public class CategoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CategoryExample() {
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

        public Criteria andCa_idIsNull() {
            addCriterion("ca_id is null");
            return (Criteria) this;
        }

        public Criteria andCa_idIsNotNull() {
            addCriterion("ca_id is not null");
            return (Criteria) this;
        }

        public Criteria andCa_idEqualTo(Integer value) {
            addCriterion("ca_id =", value, "ca_id");
            return (Criteria) this;
        }

        public Criteria andCa_idNotEqualTo(Integer value) {
            addCriterion("ca_id <>", value, "ca_id");
            return (Criteria) this;
        }

        public Criteria andCa_idGreaterThan(Integer value) {
            addCriterion("ca_id >", value, "ca_id");
            return (Criteria) this;
        }

        public Criteria andCa_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("ca_id >=", value, "ca_id");
            return (Criteria) this;
        }

        public Criteria andCa_idLessThan(Integer value) {
            addCriterion("ca_id <", value, "ca_id");
            return (Criteria) this;
        }

        public Criteria andCa_idLessThanOrEqualTo(Integer value) {
            addCriterion("ca_id <=", value, "ca_id");
            return (Criteria) this;
        }

        public Criteria andCa_idIn(List<Integer> values) {
            addCriterion("ca_id in", values, "ca_id");
            return (Criteria) this;
        }

        public Criteria andCa_idNotIn(List<Integer> values) {
            addCriterion("ca_id not in", values, "ca_id");
            return (Criteria) this;
        }

        public Criteria andCa_idBetween(Integer value1, Integer value2) {
            addCriterion("ca_id between", value1, value2, "ca_id");
            return (Criteria) this;
        }

        public Criteria andCa_idNotBetween(Integer value1, Integer value2) {
            addCriterion("ca_id not between", value1, value2, "ca_id");
            return (Criteria) this;
        }

        public Criteria andCa_nameIsNull() {
            addCriterion("ca_name is null");
            return (Criteria) this;
        }

        public Criteria andCa_nameIsNotNull() {
            addCriterion("ca_name is not null");
            return (Criteria) this;
        }

        public Criteria andCa_nameEqualTo(String value) {
            addCriterion("ca_name =", value, "ca_name");
            return (Criteria) this;
        }

        public Criteria andCa_nameNotEqualTo(String value) {
            addCriterion("ca_name <>", value, "ca_name");
            return (Criteria) this;
        }

        public Criteria andCa_nameGreaterThan(String value) {
            addCriterion("ca_name >", value, "ca_name");
            return (Criteria) this;
        }

        public Criteria andCa_nameGreaterThanOrEqualTo(String value) {
            addCriterion("ca_name >=", value, "ca_name");
            return (Criteria) this;
        }

        public Criteria andCa_nameLessThan(String value) {
            addCriterion("ca_name <", value, "ca_name");
            return (Criteria) this;
        }

        public Criteria andCa_nameLessThanOrEqualTo(String value) {
            addCriterion("ca_name <=", value, "ca_name");
            return (Criteria) this;
        }

        public Criteria andCa_nameLike(String value) {
            addCriterion("ca_name like", value, "ca_name");
            return (Criteria) this;
        }

        public Criteria andCa_nameNotLike(String value) {
            addCriterion("ca_name not like", value, "ca_name");
            return (Criteria) this;
        }

        public Criteria andCa_nameIn(List<String> values) {
            addCriterion("ca_name in", values, "ca_name");
            return (Criteria) this;
        }

        public Criteria andCa_nameNotIn(List<String> values) {
            addCriterion("ca_name not in", values, "ca_name");
            return (Criteria) this;
        }

        public Criteria andCa_nameBetween(String value1, String value2) {
            addCriterion("ca_name between", value1, value2, "ca_name");
            return (Criteria) this;
        }

        public Criteria andCa_nameNotBetween(String value1, String value2) {
            addCriterion("ca_name not between", value1, value2, "ca_name");
            return (Criteria) this;
        }

        public Criteria andCa_infoIsNull() {
            addCriterion("ca_info is null");
            return (Criteria) this;
        }

        public Criteria andCa_infoIsNotNull() {
            addCriterion("ca_info is not null");
            return (Criteria) this;
        }

        public Criteria andCa_infoEqualTo(String value) {
            addCriterion("ca_info =", value, "ca_info");
            return (Criteria) this;
        }

        public Criteria andCa_infoNotEqualTo(String value) {
            addCriterion("ca_info <>", value, "ca_info");
            return (Criteria) this;
        }

        public Criteria andCa_infoGreaterThan(String value) {
            addCriterion("ca_info >", value, "ca_info");
            return (Criteria) this;
        }

        public Criteria andCa_infoGreaterThanOrEqualTo(String value) {
            addCriterion("ca_info >=", value, "ca_info");
            return (Criteria) this;
        }

        public Criteria andCa_infoLessThan(String value) {
            addCriterion("ca_info <", value, "ca_info");
            return (Criteria) this;
        }

        public Criteria andCa_infoLessThanOrEqualTo(String value) {
            addCriterion("ca_info <=", value, "ca_info");
            return (Criteria) this;
        }

        public Criteria andCa_infoLike(String value) {
            addCriterion("ca_info like", value, "ca_info");
            return (Criteria) this;
        }

        public Criteria andCa_infoNotLike(String value) {
            addCriterion("ca_info not like", value, "ca_info");
            return (Criteria) this;
        }

        public Criteria andCa_infoIn(List<String> values) {
            addCriterion("ca_info in", values, "ca_info");
            return (Criteria) this;
        }

        public Criteria andCa_infoNotIn(List<String> values) {
            addCriterion("ca_info not in", values, "ca_info");
            return (Criteria) this;
        }

        public Criteria andCa_infoBetween(String value1, String value2) {
            addCriterion("ca_info between", value1, value2, "ca_info");
            return (Criteria) this;
        }

        public Criteria andCa_infoNotBetween(String value1, String value2) {
            addCriterion("ca_info not between", value1, value2, "ca_info");
            return (Criteria) this;
        }

        public Criteria andL_idIsNull() {
            addCriterion("l_id is null");
            return (Criteria) this;
        }

        public Criteria andL_idIsNotNull() {
            addCriterion("l_id is not null");
            return (Criteria) this;
        }

        public Criteria andL_idEqualTo(Integer value) {
            addCriterion("l_id =", value, "l_id");
            return (Criteria) this;
        }

        public Criteria andL_idNotEqualTo(Integer value) {
            addCriterion("l_id <>", value, "l_id");
            return (Criteria) this;
        }

        public Criteria andL_idGreaterThan(Integer value) {
            addCriterion("l_id >", value, "l_id");
            return (Criteria) this;
        }

        public Criteria andL_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("l_id >=", value, "l_id");
            return (Criteria) this;
        }

        public Criteria andL_idLessThan(Integer value) {
            addCriterion("l_id <", value, "l_id");
            return (Criteria) this;
        }

        public Criteria andL_idLessThanOrEqualTo(Integer value) {
            addCriterion("l_id <=", value, "l_id");
            return (Criteria) this;
        }

        public Criteria andL_idIn(List<Integer> values) {
            addCriterion("l_id in", values, "l_id");
            return (Criteria) this;
        }

        public Criteria andL_idNotIn(List<Integer> values) {
            addCriterion("l_id not in", values, "l_id");
            return (Criteria) this;
        }

        public Criteria andL_idBetween(Integer value1, Integer value2) {
            addCriterion("l_id between", value1, value2, "l_id");
            return (Criteria) this;
        }

        public Criteria andL_idNotBetween(Integer value1, Integer value2) {
            addCriterion("l_id not between", value1, value2, "l_id");
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