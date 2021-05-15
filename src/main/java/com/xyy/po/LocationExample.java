package com.xyy.po;

import java.util.ArrayList;
import java.util.List;

public class LocationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LocationExample() {
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

        public Criteria andI_infoIsNull() {
            addCriterion("i_info is null");
            return (Criteria) this;
        }

        public Criteria andI_infoIsNotNull() {
            addCriterion("i_info is not null");
            return (Criteria) this;
        }

        public Criteria andI_infoEqualTo(String value) {
            addCriterion("i_info =", value, "i_info");
            return (Criteria) this;
        }

        public Criteria andI_infoNotEqualTo(String value) {
            addCriterion("i_info <>", value, "i_info");
            return (Criteria) this;
        }

        public Criteria andI_infoGreaterThan(String value) {
            addCriterion("i_info >", value, "i_info");
            return (Criteria) this;
        }

        public Criteria andI_infoGreaterThanOrEqualTo(String value) {
            addCriterion("i_info >=", value, "i_info");
            return (Criteria) this;
        }

        public Criteria andI_infoLessThan(String value) {
            addCriterion("i_info <", value, "i_info");
            return (Criteria) this;
        }

        public Criteria andI_infoLessThanOrEqualTo(String value) {
            addCriterion("i_info <=", value, "i_info");
            return (Criteria) this;
        }

        public Criteria andI_infoLike(String value) {
            addCriterion("i_info like", value, "i_info");
            return (Criteria) this;
        }

        public Criteria andI_infoNotLike(String value) {
            addCriterion("i_info not like", value, "i_info");
            return (Criteria) this;
        }

        public Criteria andI_infoIn(List<String> values) {
            addCriterion("i_info in", values, "i_info");
            return (Criteria) this;
        }

        public Criteria andI_infoNotIn(List<String> values) {
            addCriterion("i_info not in", values, "i_info");
            return (Criteria) this;
        }

        public Criteria andI_infoBetween(String value1, String value2) {
            addCriterion("i_info between", value1, value2, "i_info");
            return (Criteria) this;
        }

        public Criteria andI_infoNotBetween(String value1, String value2) {
            addCriterion("i_info not between", value1, value2, "i_info");
            return (Criteria) this;
        }

        public Criteria andI_pathIsNull() {
            addCriterion("i_path is null");
            return (Criteria) this;
        }

        public Criteria andI_pathIsNotNull() {
            addCriterion("i_path is not null");
            return (Criteria) this;
        }

        public Criteria andI_pathEqualTo(String value) {
            addCriterion("i_path =", value, "i_path");
            return (Criteria) this;
        }

        public Criteria andI_pathNotEqualTo(String value) {
            addCriterion("i_path <>", value, "i_path");
            return (Criteria) this;
        }

        public Criteria andI_pathGreaterThan(String value) {
            addCriterion("i_path >", value, "i_path");
            return (Criteria) this;
        }

        public Criteria andI_pathGreaterThanOrEqualTo(String value) {
            addCriterion("i_path >=", value, "i_path");
            return (Criteria) this;
        }

        public Criteria andI_pathLessThan(String value) {
            addCriterion("i_path <", value, "i_path");
            return (Criteria) this;
        }

        public Criteria andI_pathLessThanOrEqualTo(String value) {
            addCriterion("i_path <=", value, "i_path");
            return (Criteria) this;
        }

        public Criteria andI_pathLike(String value) {
            addCriterion("i_path like", value, "i_path");
            return (Criteria) this;
        }

        public Criteria andI_pathNotLike(String value) {
            addCriterion("i_path not like", value, "i_path");
            return (Criteria) this;
        }

        public Criteria andI_pathIn(List<String> values) {
            addCriterion("i_path in", values, "i_path");
            return (Criteria) this;
        }

        public Criteria andI_pathNotIn(List<String> values) {
            addCriterion("i_path not in", values, "i_path");
            return (Criteria) this;
        }

        public Criteria andI_pathBetween(String value1, String value2) {
            addCriterion("i_path between", value1, value2, "i_path");
            return (Criteria) this;
        }

        public Criteria andI_pathNotBetween(String value1, String value2) {
            addCriterion("i_path not between", value1, value2, "i_path");
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