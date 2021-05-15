package com.xyy.po;

import java.util.ArrayList;
import java.util.List;

public class AdminExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdminExample() {
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

        public Criteria andAdmin_idIsNull() {
            addCriterion("admin_id is null");
            return (Criteria) this;
        }

        public Criteria andAdmin_idIsNotNull() {
            addCriterion("admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdmin_idEqualTo(Integer value) {
            addCriterion("admin_id =", value, "admin_id");
            return (Criteria) this;
        }

        public Criteria andAdmin_idNotEqualTo(Integer value) {
            addCriterion("admin_id <>", value, "admin_id");
            return (Criteria) this;
        }

        public Criteria andAdmin_idGreaterThan(Integer value) {
            addCriterion("admin_id >", value, "admin_id");
            return (Criteria) this;
        }

        public Criteria andAdmin_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin_id >=", value, "admin_id");
            return (Criteria) this;
        }

        public Criteria andAdmin_idLessThan(Integer value) {
            addCriterion("admin_id <", value, "admin_id");
            return (Criteria) this;
        }

        public Criteria andAdmin_idLessThanOrEqualTo(Integer value) {
            addCriterion("admin_id <=", value, "admin_id");
            return (Criteria) this;
        }

        public Criteria andAdmin_idIn(List<Integer> values) {
            addCriterion("admin_id in", values, "admin_id");
            return (Criteria) this;
        }

        public Criteria andAdmin_idNotIn(List<Integer> values) {
            addCriterion("admin_id not in", values, "admin_id");
            return (Criteria) this;
        }

        public Criteria andAdmin_idBetween(Integer value1, Integer value2) {
            addCriterion("admin_id between", value1, value2, "admin_id");
            return (Criteria) this;
        }

        public Criteria andAdmin_idNotBetween(Integer value1, Integer value2) {
            addCriterion("admin_id not between", value1, value2, "admin_id");
            return (Criteria) this;
        }

        public Criteria andAdmin_unameIsNull() {
            addCriterion("admin_uname is null");
            return (Criteria) this;
        }

        public Criteria andAdmin_unameIsNotNull() {
            addCriterion("admin_uname is not null");
            return (Criteria) this;
        }

        public Criteria andAdmin_unameEqualTo(String value) {
            addCriterion("admin_uname =", value, "admin_uname");
            return (Criteria) this;
        }

        public Criteria andAdmin_unameNotEqualTo(String value) {
            addCriterion("admin_uname <>", value, "admin_uname");
            return (Criteria) this;
        }

        public Criteria andAdmin_unameGreaterThan(String value) {
            addCriterion("admin_uname >", value, "admin_uname");
            return (Criteria) this;
        }

        public Criteria andAdmin_unameGreaterThanOrEqualTo(String value) {
            addCriterion("admin_uname >=", value, "admin_uname");
            return (Criteria) this;
        }

        public Criteria andAdmin_unameLessThan(String value) {
            addCriterion("admin_uname <", value, "admin_uname");
            return (Criteria) this;
        }

        public Criteria andAdmin_unameLessThanOrEqualTo(String value) {
            addCriterion("admin_uname <=", value, "admin_uname");
            return (Criteria) this;
        }

        public Criteria andAdmin_unameLike(String value) {
            addCriterion("admin_uname like", value, "admin_uname");
            return (Criteria) this;
        }

        public Criteria andAdmin_unameNotLike(String value) {
            addCriterion("admin_uname not like", value, "admin_uname");
            return (Criteria) this;
        }

        public Criteria andAdmin_unameIn(List<String> values) {
            addCriterion("admin_uname in", values, "admin_uname");
            return (Criteria) this;
        }

        public Criteria andAdmin_unameNotIn(List<String> values) {
            addCriterion("admin_uname not in", values, "admin_uname");
            return (Criteria) this;
        }

        public Criteria andAdmin_unameBetween(String value1, String value2) {
            addCriterion("admin_uname between", value1, value2, "admin_uname");
            return (Criteria) this;
        }

        public Criteria andAdmin_unameNotBetween(String value1, String value2) {
            addCriterion("admin_uname not between", value1, value2, "admin_uname");
            return (Criteria) this;
        }

        public Criteria andAdmin_pass_wordIsNull() {
            addCriterion("admin_pass_word is null");
            return (Criteria) this;
        }

        public Criteria andAdmin_pass_wordIsNotNull() {
            addCriterion("admin_pass_word is not null");
            return (Criteria) this;
        }

        public Criteria andAdmin_pass_wordEqualTo(String value) {
            addCriterion("admin_pass_word =", value, "admin_pass_word");
            return (Criteria) this;
        }

        public Criteria andAdmin_pass_wordNotEqualTo(String value) {
            addCriterion("admin_pass_word <>", value, "admin_pass_word");
            return (Criteria) this;
        }

        public Criteria andAdmin_pass_wordGreaterThan(String value) {
            addCriterion("admin_pass_word >", value, "admin_pass_word");
            return (Criteria) this;
        }

        public Criteria andAdmin_pass_wordGreaterThanOrEqualTo(String value) {
            addCriterion("admin_pass_word >=", value, "admin_pass_word");
            return (Criteria) this;
        }

        public Criteria andAdmin_pass_wordLessThan(String value) {
            addCriterion("admin_pass_word <", value, "admin_pass_word");
            return (Criteria) this;
        }

        public Criteria andAdmin_pass_wordLessThanOrEqualTo(String value) {
            addCriterion("admin_pass_word <=", value, "admin_pass_word");
            return (Criteria) this;
        }

        public Criteria andAdmin_pass_wordLike(String value) {
            addCriterion("admin_pass_word like", value, "admin_pass_word");
            return (Criteria) this;
        }

        public Criteria andAdmin_pass_wordNotLike(String value) {
            addCriterion("admin_pass_word not like", value, "admin_pass_word");
            return (Criteria) this;
        }

        public Criteria andAdmin_pass_wordIn(List<String> values) {
            addCriterion("admin_pass_word in", values, "admin_pass_word");
            return (Criteria) this;
        }

        public Criteria andAdmin_pass_wordNotIn(List<String> values) {
            addCriterion("admin_pass_word not in", values, "admin_pass_word");
            return (Criteria) this;
        }

        public Criteria andAdmin_pass_wordBetween(String value1, String value2) {
            addCriterion("admin_pass_word between", value1, value2, "admin_pass_word");
            return (Criteria) this;
        }

        public Criteria andAdmin_pass_wordNotBetween(String value1, String value2) {
            addCriterion("admin_pass_word not between", value1, value2, "admin_pass_word");
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