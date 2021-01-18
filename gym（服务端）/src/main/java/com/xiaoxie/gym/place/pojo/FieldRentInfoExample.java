package com.xiaoxie.gym.place.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FieldRentInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FieldRentInfoExample() {
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

        public Criteria andTentuserIdIsNull() {
            addCriterion("tentUser_id is null");
            return (Criteria) this;
        }

        public Criteria andTentuserIdIsNotNull() {
            addCriterion("tentUser_id is not null");
            return (Criteria) this;
        }

        public Criteria andTentuserIdEqualTo(Integer value) {
            addCriterion("tentUser_id =", value, "tentuserId");
            return (Criteria) this;
        }

        public Criteria andTentuserIdNotEqualTo(Integer value) {
            addCriterion("tentUser_id <>", value, "tentuserId");
            return (Criteria) this;
        }

        public Criteria andTentuserIdGreaterThan(Integer value) {
            addCriterion("tentUser_id >", value, "tentuserId");
            return (Criteria) this;
        }

        public Criteria andTentuserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tentUser_id >=", value, "tentuserId");
            return (Criteria) this;
        }

        public Criteria andTentuserIdLessThan(Integer value) {
            addCriterion("tentUser_id <", value, "tentuserId");
            return (Criteria) this;
        }

        public Criteria andTentuserIdLessThanOrEqualTo(Integer value) {
            addCriterion("tentUser_id <=", value, "tentuserId");
            return (Criteria) this;
        }

        public Criteria andTentuserIdIn(List<Integer> values) {
            addCriterion("tentUser_id in", values, "tentuserId");
            return (Criteria) this;
        }

        public Criteria andTentuserIdNotIn(List<Integer> values) {
            addCriterion("tentUser_id not in", values, "tentuserId");
            return (Criteria) this;
        }

        public Criteria andTentuserIdBetween(Integer value1, Integer value2) {
            addCriterion("tentUser_id between", value1, value2, "tentuserId");
            return (Criteria) this;
        }

        public Criteria andTentuserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("tentUser_id not between", value1, value2, "tentuserId");
            return (Criteria) this;
        }

        public Criteria andRentDataIsNull() {
            addCriterion("rent_data is null");
            return (Criteria) this;
        }

        public Criteria andRentDataIsNotNull() {
            addCriterion("rent_data is not null");
            return (Criteria) this;
        }

        public Criteria andRentDataEqualTo(Date value) {
            addCriterionForJDBCDate("rent_data =", value, "rentData");
            return (Criteria) this;
        }

        public Criteria andRentDataNotEqualTo(Date value) {
            addCriterionForJDBCDate("rent_data <>", value, "rentData");
            return (Criteria) this;
        }

        public Criteria andRentDataGreaterThan(Date value) {
            addCriterionForJDBCDate("rent_data >", value, "rentData");
            return (Criteria) this;
        }

        public Criteria andRentDataGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("rent_data >=", value, "rentData");
            return (Criteria) this;
        }

        public Criteria andRentDataLessThan(Date value) {
            addCriterionForJDBCDate("rent_data <", value, "rentData");
            return (Criteria) this;
        }

        public Criteria andRentDataLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("rent_data <=", value, "rentData");
            return (Criteria) this;
        }

        public Criteria andRentDataIn(List<Date> values) {
            addCriterionForJDBCDate("rent_data in", values, "rentData");
            return (Criteria) this;
        }

        public Criteria andRentDataNotIn(List<Date> values) {
            addCriterionForJDBCDate("rent_data not in", values, "rentData");
            return (Criteria) this;
        }

        public Criteria andRentDataBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("rent_data between", value1, value2, "rentData");
            return (Criteria) this;
        }

        public Criteria andRentDataNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("rent_data not between", value1, value2, "rentData");
            return (Criteria) this;
        }

        public Criteria andRentStatusIsNull() {
            addCriterion("rent_status is null");
            return (Criteria) this;
        }

        public Criteria andRentStatusIsNotNull() {
            addCriterion("rent_status is not null");
            return (Criteria) this;
        }

        public Criteria andRentStatusEqualTo(Integer value) {
            addCriterion("rent_status =", value, "rentStatus");
            return (Criteria) this;
        }

        public Criteria andRentStatusNotEqualTo(Integer value) {
            addCriterion("rent_status <>", value, "rentStatus");
            return (Criteria) this;
        }

        public Criteria andRentStatusGreaterThan(Integer value) {
            addCriterion("rent_status >", value, "rentStatus");
            return (Criteria) this;
        }

        public Criteria andRentStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("rent_status >=", value, "rentStatus");
            return (Criteria) this;
        }

        public Criteria andRentStatusLessThan(Integer value) {
            addCriterion("rent_status <", value, "rentStatus");
            return (Criteria) this;
        }

        public Criteria andRentStatusLessThanOrEqualTo(Integer value) {
            addCriterion("rent_status <=", value, "rentStatus");
            return (Criteria) this;
        }

        public Criteria andRentStatusIn(List<Integer> values) {
            addCriterion("rent_status in", values, "rentStatus");
            return (Criteria) this;
        }

        public Criteria andRentStatusNotIn(List<Integer> values) {
            addCriterion("rent_status not in", values, "rentStatus");
            return (Criteria) this;
        }

        public Criteria andRentStatusBetween(Integer value1, Integer value2) {
            addCriterion("rent_status between", value1, value2, "rentStatus");
            return (Criteria) this;
        }

        public Criteria andRentStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("rent_status not between", value1, value2, "rentStatus");
            return (Criteria) this;
        }

        public Criteria andRentTypeIsNull() {
            addCriterion("rent_type is null");
            return (Criteria) this;
        }

        public Criteria andRentTypeIsNotNull() {
            addCriterion("rent_type is not null");
            return (Criteria) this;
        }

        public Criteria andRentTypeEqualTo(Integer value) {
            addCriterion("rent_type =", value, "rentType");
            return (Criteria) this;
        }

        public Criteria andRentTypeNotEqualTo(Integer value) {
            addCriterion("rent_type <>", value, "rentType");
            return (Criteria) this;
        }

        public Criteria andRentTypeGreaterThan(Integer value) {
            addCriterion("rent_type >", value, "rentType");
            return (Criteria) this;
        }

        public Criteria andRentTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("rent_type >=", value, "rentType");
            return (Criteria) this;
        }

        public Criteria andRentTypeLessThan(Integer value) {
            addCriterion("rent_type <", value, "rentType");
            return (Criteria) this;
        }

        public Criteria andRentTypeLessThanOrEqualTo(Integer value) {
            addCriterion("rent_type <=", value, "rentType");
            return (Criteria) this;
        }

        public Criteria andRentTypeIn(List<Integer> values) {
            addCriterion("rent_type in", values, "rentType");
            return (Criteria) this;
        }

        public Criteria andRentTypeNotIn(List<Integer> values) {
            addCriterion("rent_type not in", values, "rentType");
            return (Criteria) this;
        }

        public Criteria andRentTypeBetween(Integer value1, Integer value2) {
            addCriterion("rent_type between", value1, value2, "rentType");
            return (Criteria) this;
        }

        public Criteria andRentTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("rent_type not between", value1, value2, "rentType");
            return (Criteria) this;
        }

        public Criteria andRentTimeIsNull() {
            addCriterion("rent_time is null");
            return (Criteria) this;
        }

        public Criteria andRentTimeIsNotNull() {
            addCriterion("rent_time is not null");
            return (Criteria) this;
        }

        public Criteria andRentTimeEqualTo(String value) {
            addCriterion("rent_time =", value, "rentTime");
            return (Criteria) this;
        }

        public Criteria andRentTimeNotEqualTo(String value) {
            addCriterion("rent_time <>", value, "rentTime");
            return (Criteria) this;
        }

        public Criteria andRentTimeGreaterThan(String value) {
            addCriterion("rent_time >", value, "rentTime");
            return (Criteria) this;
        }

        public Criteria andRentTimeGreaterThanOrEqualTo(String value) {
            addCriterion("rent_time >=", value, "rentTime");
            return (Criteria) this;
        }

        public Criteria andRentTimeLessThan(String value) {
            addCriterion("rent_time <", value, "rentTime");
            return (Criteria) this;
        }

        public Criteria andRentTimeLessThanOrEqualTo(String value) {
            addCriterion("rent_time <=", value, "rentTime");
            return (Criteria) this;
        }

        public Criteria andRentTimeLike(String value) {
            addCriterion("rent_time like", value, "rentTime");
            return (Criteria) this;
        }

        public Criteria andRentTimeNotLike(String value) {
            addCriterion("rent_time not like", value, "rentTime");
            return (Criteria) this;
        }

        public Criteria andRentTimeIn(List<String> values) {
            addCriterion("rent_time in", values, "rentTime");
            return (Criteria) this;
        }

        public Criteria andRentTimeNotIn(List<String> values) {
            addCriterion("rent_time not in", values, "rentTime");
            return (Criteria) this;
        }

        public Criteria andRentTimeBetween(String value1, String value2) {
            addCriterion("rent_time between", value1, value2, "rentTime");
            return (Criteria) this;
        }

        public Criteria andRentTimeNotBetween(String value1, String value2) {
            addCriterion("rent_time not between", value1, value2, "rentTime");
            return (Criteria) this;
        }

        public Criteria andRentBeginIsNull() {
            addCriterion("rent_begin is null");
            return (Criteria) this;
        }

        public Criteria andRentBeginIsNotNull() {
            addCriterion("rent_begin is not null");
            return (Criteria) this;
        }

        public Criteria andRentBeginEqualTo(Date value) {
            addCriterionForJDBCDate("rent_begin =", value, "rentBegin");
            return (Criteria) this;
        }

        public Criteria andRentBeginNotEqualTo(Date value) {
            addCriterionForJDBCDate("rent_begin <>", value, "rentBegin");
            return (Criteria) this;
        }

        public Criteria andRentBeginGreaterThan(Date value) {
            addCriterionForJDBCDate("rent_begin >", value, "rentBegin");
            return (Criteria) this;
        }

        public Criteria andRentBeginGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("rent_begin >=", value, "rentBegin");
            return (Criteria) this;
        }

        public Criteria andRentBeginLessThan(Date value) {
            addCriterionForJDBCDate("rent_begin <", value, "rentBegin");
            return (Criteria) this;
        }

        public Criteria andRentBeginLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("rent_begin <=", value, "rentBegin");
            return (Criteria) this;
        }

        public Criteria andRentBeginIn(List<Date> values) {
            addCriterionForJDBCDate("rent_begin in", values, "rentBegin");
            return (Criteria) this;
        }

        public Criteria andRentBeginNotIn(List<Date> values) {
            addCriterionForJDBCDate("rent_begin not in", values, "rentBegin");
            return (Criteria) this;
        }

        public Criteria andRentBeginBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("rent_begin between", value1, value2, "rentBegin");
            return (Criteria) this;
        }

        public Criteria andRentBeginNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("rent_begin not between", value1, value2, "rentBegin");
            return (Criteria) this;
        }

        public Criteria andRentEndIsNull() {
            addCriterion("rent_end is null");
            return (Criteria) this;
        }

        public Criteria andRentEndIsNotNull() {
            addCriterion("rent_end is not null");
            return (Criteria) this;
        }

        public Criteria andRentEndEqualTo(Date value) {
            addCriterionForJDBCDate("rent_end =", value, "rentEnd");
            return (Criteria) this;
        }

        public Criteria andRentEndNotEqualTo(Date value) {
            addCriterionForJDBCDate("rent_end <>", value, "rentEnd");
            return (Criteria) this;
        }

        public Criteria andRentEndGreaterThan(Date value) {
            addCriterionForJDBCDate("rent_end >", value, "rentEnd");
            return (Criteria) this;
        }

        public Criteria andRentEndGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("rent_end >=", value, "rentEnd");
            return (Criteria) this;
        }

        public Criteria andRentEndLessThan(Date value) {
            addCriterionForJDBCDate("rent_end <", value, "rentEnd");
            return (Criteria) this;
        }

        public Criteria andRentEndLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("rent_end <=", value, "rentEnd");
            return (Criteria) this;
        }

        public Criteria andRentEndIn(List<Date> values) {
            addCriterionForJDBCDate("rent_end in", values, "rentEnd");
            return (Criteria) this;
        }

        public Criteria andRentEndNotIn(List<Date> values) {
            addCriterionForJDBCDate("rent_end not in", values, "rentEnd");
            return (Criteria) this;
        }

        public Criteria andRentEndBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("rent_end between", value1, value2, "rentEnd");
            return (Criteria) this;
        }

        public Criteria andRentEndNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("rent_end not between", value1, value2, "rentEnd");
            return (Criteria) this;
        }

        public Criteria andRentChargeIsNull() {
            addCriterion("rent_charge is null");
            return (Criteria) this;
        }

        public Criteria andRentChargeIsNotNull() {
            addCriterion("rent_charge is not null");
            return (Criteria) this;
        }

        public Criteria andRentChargeEqualTo(Double value) {
            addCriterion("rent_charge =", value, "rentCharge");
            return (Criteria) this;
        }

        public Criteria andRentChargeNotEqualTo(Double value) {
            addCriterion("rent_charge <>", value, "rentCharge");
            return (Criteria) this;
        }

        public Criteria andRentChargeGreaterThan(Double value) {
            addCriterion("rent_charge >", value, "rentCharge");
            return (Criteria) this;
        }

        public Criteria andRentChargeGreaterThanOrEqualTo(Double value) {
            addCriterion("rent_charge >=", value, "rentCharge");
            return (Criteria) this;
        }

        public Criteria andRentChargeLessThan(Double value) {
            addCriterion("rent_charge <", value, "rentCharge");
            return (Criteria) this;
        }

        public Criteria andRentChargeLessThanOrEqualTo(Double value) {
            addCriterion("rent_charge <=", value, "rentCharge");
            return (Criteria) this;
        }

        public Criteria andRentChargeIn(List<Double> values) {
            addCriterion("rent_charge in", values, "rentCharge");
            return (Criteria) this;
        }

        public Criteria andRentChargeNotIn(List<Double> values) {
            addCriterion("rent_charge not in", values, "rentCharge");
            return (Criteria) this;
        }

        public Criteria andRentChargeBetween(Double value1, Double value2) {
            addCriterion("rent_charge between", value1, value2, "rentCharge");
            return (Criteria) this;
        }

        public Criteria andRentChargeNotBetween(Double value1, Double value2) {
            addCriterion("rent_charge not between", value1, value2, "rentCharge");
            return (Criteria) this;
        }

        public Criteria andDeleteTagIsNull() {
            addCriterion("delete_tag is null");
            return (Criteria) this;
        }

        public Criteria andDeleteTagIsNotNull() {
            addCriterion("delete_tag is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteTagEqualTo(Integer value) {
            addCriterion("delete_tag =", value, "deleteTag");
            return (Criteria) this;
        }

        public Criteria andDeleteTagNotEqualTo(Integer value) {
            addCriterion("delete_tag <>", value, "deleteTag");
            return (Criteria) this;
        }

        public Criteria andDeleteTagGreaterThan(Integer value) {
            addCriterion("delete_tag >", value, "deleteTag");
            return (Criteria) this;
        }

        public Criteria andDeleteTagGreaterThanOrEqualTo(Integer value) {
            addCriterion("delete_tag >=", value, "deleteTag");
            return (Criteria) this;
        }

        public Criteria andDeleteTagLessThan(Integer value) {
            addCriterion("delete_tag <", value, "deleteTag");
            return (Criteria) this;
        }

        public Criteria andDeleteTagLessThanOrEqualTo(Integer value) {
            addCriterion("delete_tag <=", value, "deleteTag");
            return (Criteria) this;
        }

        public Criteria andDeleteTagIn(List<Integer> values) {
            addCriterion("delete_tag in", values, "deleteTag");
            return (Criteria) this;
        }

        public Criteria andDeleteTagNotIn(List<Integer> values) {
            addCriterion("delete_tag not in", values, "deleteTag");
            return (Criteria) this;
        }

        public Criteria andDeleteTagBetween(Integer value1, Integer value2) {
            addCriterion("delete_tag between", value1, value2, "deleteTag");
            return (Criteria) this;
        }

        public Criteria andDeleteTagNotBetween(Integer value1, Integer value2) {
            addCriterion("delete_tag not between", value1, value2, "deleteTag");
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