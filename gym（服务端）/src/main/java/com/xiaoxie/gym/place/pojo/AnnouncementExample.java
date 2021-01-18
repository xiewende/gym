package com.xiaoxie.gym.place.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AnnouncementExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AnnouncementExample() {
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
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAnnouncementTitleIsNull() {
            addCriterion("announcement_title is null");
            return (Criteria) this;
        }

        public Criteria andAnnouncementTitleIsNotNull() {
            addCriterion("announcement_title is not null");
            return (Criteria) this;
        }

        public Criteria andAnnouncementTitleEqualTo(String value) {
            addCriterion("announcement_title =", value, "announcementTitle");
            return (Criteria) this;
        }

        public Criteria andAnnouncementTitleNotEqualTo(String value) {
            addCriterion("announcement_title <>", value, "announcementTitle");
            return (Criteria) this;
        }

        public Criteria andAnnouncementTitleGreaterThan(String value) {
            addCriterion("announcement_title >", value, "announcementTitle");
            return (Criteria) this;
        }

        public Criteria andAnnouncementTitleGreaterThanOrEqualTo(String value) {
            addCriterion("announcement_title >=", value, "announcementTitle");
            return (Criteria) this;
        }

        public Criteria andAnnouncementTitleLessThan(String value) {
            addCriterion("announcement_title <", value, "announcementTitle");
            return (Criteria) this;
        }

        public Criteria andAnnouncementTitleLessThanOrEqualTo(String value) {
            addCriterion("announcement_title <=", value, "announcementTitle");
            return (Criteria) this;
        }

        public Criteria andAnnouncementTitleLike(String value) {
            addCriterion("announcement_title like", value, "announcementTitle");
            return (Criteria) this;
        }

        public Criteria andAnnouncementTitleNotLike(String value) {
            addCriterion("announcement_title not like", value, "announcementTitle");
            return (Criteria) this;
        }

        public Criteria andAnnouncementTitleIn(List<String> values) {
            addCriterion("announcement_title in", values, "announcementTitle");
            return (Criteria) this;
        }

        public Criteria andAnnouncementTitleNotIn(List<String> values) {
            addCriterion("announcement_title not in", values, "announcementTitle");
            return (Criteria) this;
        }

        public Criteria andAnnouncementTitleBetween(String value1, String value2) {
            addCriterion("announcement_title between", value1, value2, "announcementTitle");
            return (Criteria) this;
        }

        public Criteria andAnnouncementTitleNotBetween(String value1, String value2) {
            addCriterion("announcement_title not between", value1, value2, "announcementTitle");
            return (Criteria) this;
        }

        public Criteria andAnnouncementAuthorIsNull() {
            addCriterion("announcement_author is null");
            return (Criteria) this;
        }

        public Criteria andAnnouncementAuthorIsNotNull() {
            addCriterion("announcement_author is not null");
            return (Criteria) this;
        }

        public Criteria andAnnouncementAuthorEqualTo(String value) {
            addCriterion("announcement_author =", value, "announcementAuthor");
            return (Criteria) this;
        }

        public Criteria andAnnouncementAuthorNotEqualTo(String value) {
            addCriterion("announcement_author <>", value, "announcementAuthor");
            return (Criteria) this;
        }

        public Criteria andAnnouncementAuthorGreaterThan(String value) {
            addCriterion("announcement_author >", value, "announcementAuthor");
            return (Criteria) this;
        }

        public Criteria andAnnouncementAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("announcement_author >=", value, "announcementAuthor");
            return (Criteria) this;
        }

        public Criteria andAnnouncementAuthorLessThan(String value) {
            addCriterion("announcement_author <", value, "announcementAuthor");
            return (Criteria) this;
        }

        public Criteria andAnnouncementAuthorLessThanOrEqualTo(String value) {
            addCriterion("announcement_author <=", value, "announcementAuthor");
            return (Criteria) this;
        }

        public Criteria andAnnouncementAuthorLike(String value) {
            addCriterion("announcement_author like", value, "announcementAuthor");
            return (Criteria) this;
        }

        public Criteria andAnnouncementAuthorNotLike(String value) {
            addCriterion("announcement_author not like", value, "announcementAuthor");
            return (Criteria) this;
        }

        public Criteria andAnnouncementAuthorIn(List<String> values) {
            addCriterion("announcement_author in", values, "announcementAuthor");
            return (Criteria) this;
        }

        public Criteria andAnnouncementAuthorNotIn(List<String> values) {
            addCriterion("announcement_author not in", values, "announcementAuthor");
            return (Criteria) this;
        }

        public Criteria andAnnouncementAuthorBetween(String value1, String value2) {
            addCriterion("announcement_author between", value1, value2, "announcementAuthor");
            return (Criteria) this;
        }

        public Criteria andAnnouncementAuthorNotBetween(String value1, String value2) {
            addCriterion("announcement_author not between", value1, value2, "announcementAuthor");
            return (Criteria) this;
        }

        public Criteria andAnnouncementTimeIsNull() {
            addCriterion("announcement_time is null");
            return (Criteria) this;
        }

        public Criteria andAnnouncementTimeIsNotNull() {
            addCriterion("announcement_time is not null");
            return (Criteria) this;
        }

        public Criteria andAnnouncementTimeEqualTo(Date value) {
            addCriterionForJDBCDate("announcement_time =", value, "announcementTime");
            return (Criteria) this;
        }

        public Criteria andAnnouncementTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("announcement_time <>", value, "announcementTime");
            return (Criteria) this;
        }

        public Criteria andAnnouncementTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("announcement_time >", value, "announcementTime");
            return (Criteria) this;
        }

        public Criteria andAnnouncementTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("announcement_time >=", value, "announcementTime");
            return (Criteria) this;
        }

        public Criteria andAnnouncementTimeLessThan(Date value) {
            addCriterionForJDBCDate("announcement_time <", value, "announcementTime");
            return (Criteria) this;
        }

        public Criteria andAnnouncementTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("announcement_time <=", value, "announcementTime");
            return (Criteria) this;
        }

        public Criteria andAnnouncementTimeIn(List<Date> values) {
            addCriterionForJDBCDate("announcement_time in", values, "announcementTime");
            return (Criteria) this;
        }

        public Criteria andAnnouncementTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("announcement_time not in", values, "announcementTime");
            return (Criteria) this;
        }

        public Criteria andAnnouncementTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("announcement_time between", value1, value2, "announcementTime");
            return (Criteria) this;
        }

        public Criteria andAnnouncementTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("announcement_time not between", value1, value2, "announcementTime");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContenIsNull() {
            addCriterion("announcement_conten is null");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContenIsNotNull() {
            addCriterion("announcement_conten is not null");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContenEqualTo(String value) {
            addCriterion("announcement_conten =", value, "announcementConten");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContenNotEqualTo(String value) {
            addCriterion("announcement_conten <>", value, "announcementConten");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContenGreaterThan(String value) {
            addCriterion("announcement_conten >", value, "announcementConten");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContenGreaterThanOrEqualTo(String value) {
            addCriterion("announcement_conten >=", value, "announcementConten");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContenLessThan(String value) {
            addCriterion("announcement_conten <", value, "announcementConten");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContenLessThanOrEqualTo(String value) {
            addCriterion("announcement_conten <=", value, "announcementConten");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContenLike(String value) {
            addCriterion("announcement_conten like", value, "announcementConten");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContenNotLike(String value) {
            addCriterion("announcement_conten not like", value, "announcementConten");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContenIn(List<String> values) {
            addCriterion("announcement_conten in", values, "announcementConten");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContenNotIn(List<String> values) {
            addCriterion("announcement_conten not in", values, "announcementConten");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContenBetween(String value1, String value2) {
            addCriterion("announcement_conten between", value1, value2, "announcementConten");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContenNotBetween(String value1, String value2) {
            addCriterion("announcement_conten not between", value1, value2, "announcementConten");
            return (Criteria) this;
        }

        public Criteria andAnnouncementDelelteIsNull() {
            addCriterion("announcement_delelte is null");
            return (Criteria) this;
        }

        public Criteria andAnnouncementDelelteIsNotNull() {
            addCriterion("announcement_delelte is not null");
            return (Criteria) this;
        }

        public Criteria andAnnouncementDelelteEqualTo(Integer value) {
            addCriterion("announcement_delelte =", value, "announcementDelelte");
            return (Criteria) this;
        }

        public Criteria andAnnouncementDelelteNotEqualTo(Integer value) {
            addCriterion("announcement_delelte <>", value, "announcementDelelte");
            return (Criteria) this;
        }

        public Criteria andAnnouncementDelelteGreaterThan(Integer value) {
            addCriterion("announcement_delelte >", value, "announcementDelelte");
            return (Criteria) this;
        }

        public Criteria andAnnouncementDelelteGreaterThanOrEqualTo(Integer value) {
            addCriterion("announcement_delelte >=", value, "announcementDelelte");
            return (Criteria) this;
        }

        public Criteria andAnnouncementDelelteLessThan(Integer value) {
            addCriterion("announcement_delelte <", value, "announcementDelelte");
            return (Criteria) this;
        }

        public Criteria andAnnouncementDelelteLessThanOrEqualTo(Integer value) {
            addCriterion("announcement_delelte <=", value, "announcementDelelte");
            return (Criteria) this;
        }

        public Criteria andAnnouncementDelelteIn(List<Integer> values) {
            addCriterion("announcement_delelte in", values, "announcementDelelte");
            return (Criteria) this;
        }

        public Criteria andAnnouncementDelelteNotIn(List<Integer> values) {
            addCriterion("announcement_delelte not in", values, "announcementDelelte");
            return (Criteria) this;
        }

        public Criteria andAnnouncementDelelteBetween(Integer value1, Integer value2) {
            addCriterion("announcement_delelte between", value1, value2, "announcementDelelte");
            return (Criteria) this;
        }

        public Criteria andAnnouncementDelelteNotBetween(Integer value1, Integer value2) {
            addCriterion("announcement_delelte not between", value1, value2, "announcementDelelte");
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