package com.xiaoxie.gym.place.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FieldOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FieldOrderExample() {
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

        public Criteria andFieldIdIsNull() {
            addCriterion("field_id is null");
            return (Criteria) this;
        }

        public Criteria andFieldIdIsNotNull() {
            addCriterion("field_id is not null");
            return (Criteria) this;
        }

        public Criteria andFieldIdEqualTo(Integer value) {
            addCriterion("field_id =", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdNotEqualTo(Integer value) {
            addCriterion("field_id <>", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdGreaterThan(Integer value) {
            addCriterion("field_id >", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("field_id >=", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdLessThan(Integer value) {
            addCriterion("field_id <", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdLessThanOrEqualTo(Integer value) {
            addCriterion("field_id <=", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdIn(List<Integer> values) {
            addCriterion("field_id in", values, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdNotIn(List<Integer> values) {
            addCriterion("field_id not in", values, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdBetween(Integer value1, Integer value2) {
            addCriterion("field_id between", value1, value2, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdNotBetween(Integer value1, Integer value2) {
            addCriterion("field_id not between", value1, value2, "fieldId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andOrderDataIsNull() {
            addCriterion("order_data is null");
            return (Criteria) this;
        }

        public Criteria andOrderDataIsNotNull() {
            addCriterion("order_data is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDataEqualTo(Date value) {
            addCriterionForJDBCDate("order_data =", value, "orderData");
            return (Criteria) this;
        }

        public Criteria andOrderDataNotEqualTo(Date value) {
            addCriterionForJDBCDate("order_data <>", value, "orderData");
            return (Criteria) this;
        }

        public Criteria andOrderDataGreaterThan(Date value) {
            addCriterionForJDBCDate("order_data >", value, "orderData");
            return (Criteria) this;
        }

        public Criteria andOrderDataGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("order_data >=", value, "orderData");
            return (Criteria) this;
        }

        public Criteria andOrderDataLessThan(Date value) {
            addCriterionForJDBCDate("order_data <", value, "orderData");
            return (Criteria) this;
        }

        public Criteria andOrderDataLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("order_data <=", value, "orderData");
            return (Criteria) this;
        }

        public Criteria andOrderDataIn(List<Date> values) {
            addCriterionForJDBCDate("order_data in", values, "orderData");
            return (Criteria) this;
        }

        public Criteria andOrderDataNotIn(List<Date> values) {
            addCriterionForJDBCDate("order_data not in", values, "orderData");
            return (Criteria) this;
        }

        public Criteria andOrderDataBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("order_data between", value1, value2, "orderData");
            return (Criteria) this;
        }

        public Criteria andOrderDataNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("order_data not between", value1, value2, "orderData");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNull() {
            addCriterion("order_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNotNull() {
            addCriterion("order_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeEqualTo(String value) {
            addCriterion("order_time =", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotEqualTo(String value) {
            addCriterion("order_time <>", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThan(String value) {
            addCriterion("order_time >", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThanOrEqualTo(String value) {
            addCriterion("order_time >=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThan(String value) {
            addCriterion("order_time <", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThanOrEqualTo(String value) {
            addCriterion("order_time <=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLike(String value) {
            addCriterion("order_time like", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotLike(String value) {
            addCriterion("order_time not like", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIn(List<String> values) {
            addCriterion("order_time in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotIn(List<String> values) {
            addCriterion("order_time not in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeBetween(String value1, String value2) {
            addCriterion("order_time between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotBetween(String value1, String value2) {
            addCriterion("order_time not between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderChargeIsNull() {
            addCriterion("order_charge is null");
            return (Criteria) this;
        }

        public Criteria andOrderChargeIsNotNull() {
            addCriterion("order_charge is not null");
            return (Criteria) this;
        }

        public Criteria andOrderChargeEqualTo(Double value) {
            addCriterion("order_charge =", value, "orderCharge");
            return (Criteria) this;
        }

        public Criteria andOrderChargeNotEqualTo(Double value) {
            addCriterion("order_charge <>", value, "orderCharge");
            return (Criteria) this;
        }

        public Criteria andOrderChargeGreaterThan(Double value) {
            addCriterion("order_charge >", value, "orderCharge");
            return (Criteria) this;
        }

        public Criteria andOrderChargeGreaterThanOrEqualTo(Double value) {
            addCriterion("order_charge >=", value, "orderCharge");
            return (Criteria) this;
        }

        public Criteria andOrderChargeLessThan(Double value) {
            addCriterion("order_charge <", value, "orderCharge");
            return (Criteria) this;
        }

        public Criteria andOrderChargeLessThanOrEqualTo(Double value) {
            addCriterion("order_charge <=", value, "orderCharge");
            return (Criteria) this;
        }

        public Criteria andOrderChargeIn(List<Double> values) {
            addCriterion("order_charge in", values, "orderCharge");
            return (Criteria) this;
        }

        public Criteria andOrderChargeNotIn(List<Double> values) {
            addCriterion("order_charge not in", values, "orderCharge");
            return (Criteria) this;
        }

        public Criteria andOrderChargeBetween(Double value1, Double value2) {
            addCriterion("order_charge between", value1, value2, "orderCharge");
            return (Criteria) this;
        }

        public Criteria andOrderChargeNotBetween(Double value1, Double value2) {
            addCriterion("order_charge not between", value1, value2, "orderCharge");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(Integer value) {
            addCriterion("order_status =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(Integer value) {
            addCriterion("order_status <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(Integer value) {
            addCriterion("order_status >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_status >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(Integer value) {
            addCriterion("order_status <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(Integer value) {
            addCriterion("order_status <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<Integer> values) {
            addCriterion("order_status in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<Integer> values) {
            addCriterion("order_status not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(Integer value1, Integer value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("order_status not between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderDelelteIsNull() {
            addCriterion("order_delelte is null");
            return (Criteria) this;
        }

        public Criteria andOrderDelelteIsNotNull() {
            addCriterion("order_delelte is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDelelteEqualTo(Integer value) {
            addCriterion("order_delelte =", value, "orderDelelte");
            return (Criteria) this;
        }

        public Criteria andOrderDelelteNotEqualTo(Integer value) {
            addCriterion("order_delelte <>", value, "orderDelelte");
            return (Criteria) this;
        }

        public Criteria andOrderDelelteGreaterThan(Integer value) {
            addCriterion("order_delelte >", value, "orderDelelte");
            return (Criteria) this;
        }

        public Criteria andOrderDelelteGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_delelte >=", value, "orderDelelte");
            return (Criteria) this;
        }

        public Criteria andOrderDelelteLessThan(Integer value) {
            addCriterion("order_delelte <", value, "orderDelelte");
            return (Criteria) this;
        }

        public Criteria andOrderDelelteLessThanOrEqualTo(Integer value) {
            addCriterion("order_delelte <=", value, "orderDelelte");
            return (Criteria) this;
        }

        public Criteria andOrderDelelteIn(List<Integer> values) {
            addCriterion("order_delelte in", values, "orderDelelte");
            return (Criteria) this;
        }

        public Criteria andOrderDelelteNotIn(List<Integer> values) {
            addCriterion("order_delelte not in", values, "orderDelelte");
            return (Criteria) this;
        }

        public Criteria andOrderDelelteBetween(Integer value1, Integer value2) {
            addCriterion("order_delelte between", value1, value2, "orderDelelte");
            return (Criteria) this;
        }

        public Criteria andOrderDelelteNotBetween(Integer value1, Integer value2) {
            addCriterion("order_delelte not between", value1, value2, "orderDelelte");
            return (Criteria) this;
        }

        public Criteria andOrderBeginIsNull() {
            addCriterion("order_begin is null");
            return (Criteria) this;
        }

        public Criteria andOrderBeginIsNotNull() {
            addCriterion("order_begin is not null");
            return (Criteria) this;
        }

        public Criteria andOrderBeginEqualTo(Date value) {
            addCriterionForJDBCDate("order_begin =", value, "orderBegin");
            return (Criteria) this;
        }

        public Criteria andOrderBeginNotEqualTo(Date value) {
            addCriterionForJDBCDate("order_begin <>", value, "orderBegin");
            return (Criteria) this;
        }

        public Criteria andOrderBeginGreaterThan(Date value) {
            addCriterionForJDBCDate("order_begin >", value, "orderBegin");
            return (Criteria) this;
        }

        public Criteria andOrderBeginGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("order_begin >=", value, "orderBegin");
            return (Criteria) this;
        }

        public Criteria andOrderBeginLessThan(Date value) {
            addCriterionForJDBCDate("order_begin <", value, "orderBegin");
            return (Criteria) this;
        }

        public Criteria andOrderBeginLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("order_begin <=", value, "orderBegin");
            return (Criteria) this;
        }

        public Criteria andOrderBeginIn(List<Date> values) {
            addCriterionForJDBCDate("order_begin in", values, "orderBegin");
            return (Criteria) this;
        }

        public Criteria andOrderBeginNotIn(List<Date> values) {
            addCriterionForJDBCDate("order_begin not in", values, "orderBegin");
            return (Criteria) this;
        }

        public Criteria andOrderBeginBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("order_begin between", value1, value2, "orderBegin");
            return (Criteria) this;
        }

        public Criteria andOrderBeginNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("order_begin not between", value1, value2, "orderBegin");
            return (Criteria) this;
        }

        public Criteria andOrderEndIsNull() {
            addCriterion("order_end is null");
            return (Criteria) this;
        }

        public Criteria andOrderEndIsNotNull() {
            addCriterion("order_end is not null");
            return (Criteria) this;
        }

        public Criteria andOrderEndEqualTo(Date value) {
            addCriterionForJDBCDate("order_end =", value, "orderEnd");
            return (Criteria) this;
        }

        public Criteria andOrderEndNotEqualTo(Date value) {
            addCriterionForJDBCDate("order_end <>", value, "orderEnd");
            return (Criteria) this;
        }

        public Criteria andOrderEndGreaterThan(Date value) {
            addCriterionForJDBCDate("order_end >", value, "orderEnd");
            return (Criteria) this;
        }

        public Criteria andOrderEndGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("order_end >=", value, "orderEnd");
            return (Criteria) this;
        }

        public Criteria andOrderEndLessThan(Date value) {
            addCriterionForJDBCDate("order_end <", value, "orderEnd");
            return (Criteria) this;
        }

        public Criteria andOrderEndLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("order_end <=", value, "orderEnd");
            return (Criteria) this;
        }

        public Criteria andOrderEndIn(List<Date> values) {
            addCriterionForJDBCDate("order_end in", values, "orderEnd");
            return (Criteria) this;
        }

        public Criteria andOrderEndNotIn(List<Date> values) {
            addCriterionForJDBCDate("order_end not in", values, "orderEnd");
            return (Criteria) this;
        }

        public Criteria andOrderEndBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("order_end between", value1, value2, "orderEnd");
            return (Criteria) this;
        }

        public Criteria andOrderEndNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("order_end not between", value1, value2, "orderEnd");
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