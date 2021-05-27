package com.xyy.po;

import java.util.ArrayList;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andU_idIsNull() {
            addCriterion("u_id is null");
            return (Criteria) this;
        }

        public Criteria andU_idIsNotNull() {
            addCriterion("u_id is not null");
            return (Criteria) this;
        }

        public Criteria andU_idEqualTo(Integer value) {
            addCriterion("u_id =", value, "u_id");
            return (Criteria) this;
        }

        public Criteria andU_idNotEqualTo(Integer value) {
            addCriterion("u_id <>", value, "u_id");
            return (Criteria) this;
        }

        public Criteria andU_idGreaterThan(Integer value) {
            addCriterion("u_id >", value, "u_id");
            return (Criteria) this;
        }

        public Criteria andU_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("u_id >=", value, "u_id");
            return (Criteria) this;
        }

        public Criteria andU_idLessThan(Integer value) {
            addCriterion("u_id <", value, "u_id");
            return (Criteria) this;
        }

        public Criteria andU_idLessThanOrEqualTo(Integer value) {
            addCriterion("u_id <=", value, "u_id");
            return (Criteria) this;
        }

        public Criteria andU_idIn(List<Integer> values) {
            addCriterion("u_id in", values, "u_id");
            return (Criteria) this;
        }

        public Criteria andU_idNotIn(List<Integer> values) {
            addCriterion("u_id not in", values, "u_id");
            return (Criteria) this;
        }

        public Criteria andU_idBetween(Integer value1, Integer value2) {
            addCriterion("u_id between", value1, value2, "u_id");
            return (Criteria) this;
        }

        public Criteria andU_idNotBetween(Integer value1, Integer value2) {
            addCriterion("u_id not between", value1, value2, "u_id");
            return (Criteria) this;
        }

        public Criteria andR_idIsNull() {
            addCriterion("r_id is null");
            return (Criteria) this;
        }

        public Criteria andR_idIsNotNull() {
            addCriterion("r_id is not null");
            return (Criteria) this;
        }

        public Criteria andR_idEqualTo(Integer value) {
            addCriterion("r_id =", value, "r_id");
            return (Criteria) this;
        }

        public Criteria andR_idNotEqualTo(Integer value) {
            addCriterion("r_id <>", value, "r_id");
            return (Criteria) this;
        }

        public Criteria andR_idGreaterThan(Integer value) {
            addCriterion("r_id >", value, "r_id");
            return (Criteria) this;
        }

        public Criteria andR_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("r_id >=", value, "r_id");
            return (Criteria) this;
        }

        public Criteria andR_idLessThan(Integer value) {
            addCriterion("r_id <", value, "r_id");
            return (Criteria) this;
        }

        public Criteria andR_idLessThanOrEqualTo(Integer value) {
            addCriterion("r_id <=", value, "r_id");
            return (Criteria) this;
        }

        public Criteria andR_idIn(List<Integer> values) {
            addCriterion("r_id in", values, "r_id");
            return (Criteria) this;
        }

        public Criteria andR_idNotIn(List<Integer> values) {
            addCriterion("r_id not in", values, "r_id");
            return (Criteria) this;
        }

        public Criteria andR_idBetween(Integer value1, Integer value2) {
            addCriterion("r_id between", value1, value2, "r_id");
            return (Criteria) this;
        }

        public Criteria andR_idNotBetween(Integer value1, Integer value2) {
            addCriterion("r_id not between", value1, value2, "r_id");
            return (Criteria) this;
        }

        public Criteria andU_nameIsNull() {
            addCriterion("u_name is null");
            return (Criteria) this;
        }

        public Criteria andU_nameIsNotNull() {
            addCriterion("u_name is not null");
            return (Criteria) this;
        }

        public Criteria andU_nameEqualTo(String value) {
            addCriterion("u_name =", value, "u_name");
            return (Criteria) this;
        }

        public Criteria andU_nameNotEqualTo(String value) {
            addCriterion("u_name <>", value, "u_name");
            return (Criteria) this;
        }

        public Criteria andU_nameGreaterThan(String value) {
            addCriterion("u_name >", value, "u_name");
            return (Criteria) this;
        }

        public Criteria andU_nameGreaterThanOrEqualTo(String value) {
            addCriterion("u_name >=", value, "u_name");
            return (Criteria) this;
        }

        public Criteria andU_nameLessThan(String value) {
            addCriterion("u_name <", value, "u_name");
            return (Criteria) this;
        }

        public Criteria andU_nameLessThanOrEqualTo(String value) {
            addCriterion("u_name <=", value, "u_name");
            return (Criteria) this;
        }

        public Criteria andU_nameLike(String value) {
            addCriterion("u_name like", value, "u_name");
            return (Criteria) this;
        }

        public Criteria andU_nameNotLike(String value) {
            addCriterion("u_name not like", value, "u_name");
            return (Criteria) this;
        }

        public Criteria andU_nameIn(List<String> values) {
            addCriterion("u_name in", values, "u_name");
            return (Criteria) this;
        }

        public Criteria andU_nameNotIn(List<String> values) {
            addCriterion("u_name not in", values, "u_name");
            return (Criteria) this;
        }

        public Criteria andU_nameBetween(String value1, String value2) {
            addCriterion("u_name between", value1, value2, "u_name");
            return (Criteria) this;
        }

        public Criteria andU_nameNotBetween(String value1, String value2) {
            addCriterion("u_name not between", value1, value2, "u_name");
            return (Criteria) this;
        }

        public Criteria andPass_wordIsNull() {
            addCriterion("pass_word is null");
            return (Criteria) this;
        }

        public Criteria andPass_wordIsNotNull() {
            addCriterion("pass_word is not null");
            return (Criteria) this;
        }

        public Criteria andPass_wordEqualTo(String value) {
            addCriterion("pass_word =", value, "pass_word");
            return (Criteria) this;
        }

        public Criteria andPass_wordNotEqualTo(String value) {
            addCriterion("pass_word <>", value, "pass_word");
            return (Criteria) this;
        }

        public Criteria andPass_wordGreaterThan(String value) {
            addCriterion("pass_word >", value, "pass_word");
            return (Criteria) this;
        }

        public Criteria andPass_wordGreaterThanOrEqualTo(String value) {
            addCriterion("pass_word >=", value, "pass_word");
            return (Criteria) this;
        }

        public Criteria andPass_wordLessThan(String value) {
            addCriterion("pass_word <", value, "pass_word");
            return (Criteria) this;
        }

        public Criteria andPass_wordLessThanOrEqualTo(String value) {
            addCriterion("pass_word <=", value, "pass_word");
            return (Criteria) this;
        }

        public Criteria andPass_wordLike(String value) {
            addCriterion("pass_word like", value, "pass_word");
            return (Criteria) this;
        }

        public Criteria andPass_wordNotLike(String value) {
            addCriterion("pass_word not like", value, "pass_word");
            return (Criteria) this;
        }

        public Criteria andPass_wordIn(List<String> values) {
            addCriterion("pass_word in", values, "pass_word");
            return (Criteria) this;
        }

        public Criteria andPass_wordNotIn(List<String> values) {
            addCriterion("pass_word not in", values, "pass_word");
            return (Criteria) this;
        }

        public Criteria andPass_wordBetween(String value1, String value2) {
            addCriterion("pass_word between", value1, value2, "pass_word");
            return (Criteria) this;
        }

        public Criteria andPass_wordNotBetween(String value1, String value2) {
            addCriterion("pass_word not between", value1, value2, "pass_word");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andSign_infoIsNull() {
            addCriterion("sign_info is null");
            return (Criteria) this;
        }

        public Criteria andSign_infoIsNotNull() {
            addCriterion("sign_info is not null");
            return (Criteria) this;
        }

        public Criteria andSign_infoEqualTo(String value) {
            addCriterion("sign_info =", value, "sign_info");
            return (Criteria) this;
        }

        public Criteria andSign_infoNotEqualTo(String value) {
            addCriterion("sign_info <>", value, "sign_info");
            return (Criteria) this;
        }

        public Criteria andSign_infoGreaterThan(String value) {
            addCriterion("sign_info >", value, "sign_info");
            return (Criteria) this;
        }

        public Criteria andSign_infoGreaterThanOrEqualTo(String value) {
            addCriterion("sign_info >=", value, "sign_info");
            return (Criteria) this;
        }

        public Criteria andSign_infoLessThan(String value) {
            addCriterion("sign_info <", value, "sign_info");
            return (Criteria) this;
        }

        public Criteria andSign_infoLessThanOrEqualTo(String value) {
            addCriterion("sign_info <=", value, "sign_info");
            return (Criteria) this;
        }

        public Criteria andSign_infoLike(String value) {
            addCriterion("sign_info like", value, "sign_info");
            return (Criteria) this;
        }

        public Criteria andSign_infoNotLike(String value) {
            addCriterion("sign_info not like", value, "sign_info");
            return (Criteria) this;
        }

        public Criteria andSign_infoIn(List<String> values) {
            addCriterion("sign_info in", values, "sign_info");
            return (Criteria) this;
        }

        public Criteria andSign_infoNotIn(List<String> values) {
            addCriterion("sign_info not in", values, "sign_info");
            return (Criteria) this;
        }

        public Criteria andSign_infoBetween(String value1, String value2) {
            addCriterion("sign_info between", value1, value2, "sign_info");
            return (Criteria) this;
        }

        public Criteria andSign_infoNotBetween(String value1, String value2) {
            addCriterion("sign_info not between", value1, value2, "sign_info");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
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