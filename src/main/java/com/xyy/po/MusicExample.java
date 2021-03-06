package com.xyy.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MusicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MusicExample() {
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

        public Criteria andM_idIsNull() {
            addCriterion("m_id is null");
            return (Criteria) this;
        }

        public Criteria andM_idIsNotNull() {
            addCriterion("m_id is not null");
            return (Criteria) this;
        }

        public Criteria andM_idEqualTo(Integer value) {
            addCriterion("m_id =", value, "m_id");
            return (Criteria) this;
        }

        public Criteria andM_idNotEqualTo(Integer value) {
            addCriterion("m_id <>", value, "m_id");
            return (Criteria) this;
        }

        public Criteria andM_idGreaterThan(Integer value) {
            addCriterion("m_id >", value, "m_id");
            return (Criteria) this;
        }

        public Criteria andM_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("m_id >=", value, "m_id");
            return (Criteria) this;
        }

        public Criteria andM_idLessThan(Integer value) {
            addCriterion("m_id <", value, "m_id");
            return (Criteria) this;
        }

        public Criteria andM_idLessThanOrEqualTo(Integer value) {
            addCriterion("m_id <=", value, "m_id");
            return (Criteria) this;
        }

        public Criteria andM_idIn(List<Integer> values) {
            addCriterion("m_id in", values, "m_id");
            return (Criteria) this;
        }

        public Criteria andM_idNotIn(List<Integer> values) {
            addCriterion("m_id not in", values, "m_id");
            return (Criteria) this;
        }

        public Criteria andM_idBetween(Integer value1, Integer value2) {
            addCriterion("m_id between", value1, value2, "m_id");
            return (Criteria) this;
        }

        public Criteria andM_idNotBetween(Integer value1, Integer value2) {
            addCriterion("m_id not between", value1, value2, "m_id");
            return (Criteria) this;
        }

        public Criteria andM_nameIsNull() {
            addCriterion("m_name is null");
            return (Criteria) this;
        }

        public Criteria andM_nameIsNotNull() {
            addCriterion("m_name is not null");
            return (Criteria) this;
        }

        public Criteria andM_nameEqualTo(String value) {
            addCriterion("m_name =", value, "m_name");
            return (Criteria) this;
        }

        public Criteria andM_nameNotEqualTo(String value) {
            addCriterion("m_name <>", value, "m_name");
            return (Criteria) this;
        }

        public Criteria andM_nameGreaterThan(String value) {
            addCriterion("m_name >", value, "m_name");
            return (Criteria) this;
        }

        public Criteria andM_nameGreaterThanOrEqualTo(String value) {
            addCriterion("m_name >=", value, "m_name");
            return (Criteria) this;
        }

        public Criteria andM_nameLessThan(String value) {
            addCriterion("m_name <", value, "m_name");
            return (Criteria) this;
        }

        public Criteria andM_nameLessThanOrEqualTo(String value) {
            addCriterion("m_name <=", value, "m_name");
            return (Criteria) this;
        }

        public Criteria andM_nameLike(String value) {
            addCriterion("m_name like", value, "m_name");
            return (Criteria) this;
        }

        public Criteria andM_nameNotLike(String value) {
            addCriterion("m_name not like", value, "m_name");
            return (Criteria) this;
        }

        public Criteria andM_nameIn(List<String> values) {
            addCriterion("m_name in", values, "m_name");
            return (Criteria) this;
        }

        public Criteria andM_nameNotIn(List<String> values) {
            addCriterion("m_name not in", values, "m_name");
            return (Criteria) this;
        }

        public Criteria andM_nameBetween(String value1, String value2) {
            addCriterion("m_name between", value1, value2, "m_name");
            return (Criteria) this;
        }

        public Criteria andM_nameNotBetween(String value1, String value2) {
            addCriterion("m_name not between", value1, value2, "m_name");
            return (Criteria) this;
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

        public Criteria andPriorityIsNull() {
            addCriterion("priority is null");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNotNull() {
            addCriterion("priority is not null");
            return (Criteria) this;
        }

        public Criteria andPriorityEqualTo(Integer value) {
            addCriterion("priority =", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotEqualTo(Integer value) {
            addCriterion("priority <>", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThan(Integer value) {
            addCriterion("priority >", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThanOrEqualTo(Integer value) {
            addCriterion("priority >=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThan(Integer value) {
            addCriterion("priority <", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThanOrEqualTo(Integer value) {
            addCriterion("priority <=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityIn(List<Integer> values) {
            addCriterion("priority in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotIn(List<Integer> values) {
            addCriterion("priority not in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityBetween(Integer value1, Integer value2) {
            addCriterion("priority between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotBetween(Integer value1, Integer value2) {
            addCriterion("priority not between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andHotIsNull() {
            addCriterion("hot is null");
            return (Criteria) this;
        }

        public Criteria andHotIsNotNull() {
            addCriterion("hot is not null");
            return (Criteria) this;
        }

        public Criteria andHotEqualTo(Integer value) {
            addCriterion("hot =", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotNotEqualTo(Integer value) {
            addCriterion("hot <>", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotGreaterThan(Integer value) {
            addCriterion("hot >", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotGreaterThanOrEqualTo(Integer value) {
            addCriterion("hot >=", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotLessThan(Integer value) {
            addCriterion("hot <", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotLessThanOrEqualTo(Integer value) {
            addCriterion("hot <=", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotIn(List<Integer> values) {
            addCriterion("hot in", values, "hot");
            return (Criteria) this;
        }

        public Criteria andHotNotIn(List<Integer> values) {
            addCriterion("hot not in", values, "hot");
            return (Criteria) this;
        }

        public Criteria andHotBetween(Integer value1, Integer value2) {
            addCriterion("hot between", value1, value2, "hot");
            return (Criteria) this;
        }

        public Criteria andHotNotBetween(Integer value1, Integer value2) {
            addCriterion("hot not between", value1, value2, "hot");
            return (Criteria) this;
        }

        public Criteria andMdateIsNull() {
            addCriterion("mdate is null");
            return (Criteria) this;
        }

        public Criteria andMdateIsNotNull() {
            addCriterion("mdate is not null");
            return (Criteria) this;
        }

        public Criteria andMdateEqualTo(Date value) {
            addCriterion("mdate =", value, "mdate");
            return (Criteria) this;
        }

        public Criteria andMdateNotEqualTo(Date value) {
            addCriterion("mdate <>", value, "mdate");
            return (Criteria) this;
        }

        public Criteria andMdateGreaterThan(Date value) {
            addCriterion("mdate >", value, "mdate");
            return (Criteria) this;
        }

        public Criteria andMdateGreaterThanOrEqualTo(Date value) {
            addCriterion("mdate >=", value, "mdate");
            return (Criteria) this;
        }

        public Criteria andMdateLessThan(Date value) {
            addCriterion("mdate <", value, "mdate");
            return (Criteria) this;
        }

        public Criteria andMdateLessThanOrEqualTo(Date value) {
            addCriterion("mdate <=", value, "mdate");
            return (Criteria) this;
        }

        public Criteria andMdateIn(List<Date> values) {
            addCriterion("mdate in", values, "mdate");
            return (Criteria) this;
        }

        public Criteria andMdateNotIn(List<Date> values) {
            addCriterion("mdate not in", values, "mdate");
            return (Criteria) this;
        }

        public Criteria andMdateBetween(Date value1, Date value2) {
            addCriterion("mdate between", value1, value2, "mdate");
            return (Criteria) this;
        }

        public Criteria andMdateNotBetween(Date value1, Date value2) {
            addCriterion("mdate not between", value1, value2, "mdate");
            return (Criteria) this;
        }

        public Criteria andPathIsNull() {
            addCriterion("path is null");
            return (Criteria) this;
        }

        public Criteria andPathIsNotNull() {
            addCriterion("path is not null");
            return (Criteria) this;
        }

        public Criteria andPathEqualTo(String value) {
            addCriterion("path =", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotEqualTo(String value) {
            addCriterion("path <>", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThan(String value) {
            addCriterion("path >", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThanOrEqualTo(String value) {
            addCriterion("path >=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThan(String value) {
            addCriterion("path <", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThanOrEqualTo(String value) {
            addCriterion("path <=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLike(String value) {
            addCriterion("path like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotLike(String value) {
            addCriterion("path not like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathIn(List<String> values) {
            addCriterion("path in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotIn(List<String> values) {
            addCriterion("path not in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathBetween(String value1, String value2) {
            addCriterion("path between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotBetween(String value1, String value2) {
            addCriterion("path not between", value1, value2, "path");
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