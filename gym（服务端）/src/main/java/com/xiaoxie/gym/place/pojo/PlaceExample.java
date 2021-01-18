package com.xiaoxie.gym.place.pojo;

import java.util.ArrayList;
import java.util.List;

public class PlaceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlaceExample() {
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

        public Criteria andFieldNameIsNull() {
            addCriterion("field_name is null");
            return (Criteria) this;
        }

        public Criteria andFieldNameIsNotNull() {
            addCriterion("field_name is not null");
            return (Criteria) this;
        }

        public Criteria andFieldNameEqualTo(String value) {
            addCriterion("field_name =", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotEqualTo(String value) {
            addCriterion("field_name <>", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameGreaterThan(String value) {
            addCriterion("field_name >", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameGreaterThanOrEqualTo(String value) {
            addCriterion("field_name >=", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameLessThan(String value) {
            addCriterion("field_name <", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameLessThanOrEqualTo(String value) {
            addCriterion("field_name <=", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameLike(String value) {
            addCriterion("field_name like", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotLike(String value) {
            addCriterion("field_name not like", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameIn(List<String> values) {
            addCriterion("field_name in", values, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotIn(List<String> values) {
            addCriterion("field_name not in", values, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameBetween(String value1, String value2) {
            addCriterion("field_name between", value1, value2, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotBetween(String value1, String value2) {
            addCriterion("field_name not between", value1, value2, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldLocaleIsNull() {
            addCriterion("field_locale is null");
            return (Criteria) this;
        }

        public Criteria andFieldLocaleIsNotNull() {
            addCriterion("field_locale is not null");
            return (Criteria) this;
        }

        public Criteria andFieldLocaleEqualTo(String value) {
            addCriterion("field_locale =", value, "fieldLocale");
            return (Criteria) this;
        }

        public Criteria andFieldLocaleNotEqualTo(String value) {
            addCriterion("field_locale <>", value, "fieldLocale");
            return (Criteria) this;
        }

        public Criteria andFieldLocaleGreaterThan(String value) {
            addCriterion("field_locale >", value, "fieldLocale");
            return (Criteria) this;
        }

        public Criteria andFieldLocaleGreaterThanOrEqualTo(String value) {
            addCriterion("field_locale >=", value, "fieldLocale");
            return (Criteria) this;
        }

        public Criteria andFieldLocaleLessThan(String value) {
            addCriterion("field_locale <", value, "fieldLocale");
            return (Criteria) this;
        }

        public Criteria andFieldLocaleLessThanOrEqualTo(String value) {
            addCriterion("field_locale <=", value, "fieldLocale");
            return (Criteria) this;
        }

        public Criteria andFieldLocaleLike(String value) {
            addCriterion("field_locale like", value, "fieldLocale");
            return (Criteria) this;
        }

        public Criteria andFieldLocaleNotLike(String value) {
            addCriterion("field_locale not like", value, "fieldLocale");
            return (Criteria) this;
        }

        public Criteria andFieldLocaleIn(List<String> values) {
            addCriterion("field_locale in", values, "fieldLocale");
            return (Criteria) this;
        }

        public Criteria andFieldLocaleNotIn(List<String> values) {
            addCriterion("field_locale not in", values, "fieldLocale");
            return (Criteria) this;
        }

        public Criteria andFieldLocaleBetween(String value1, String value2) {
            addCriterion("field_locale between", value1, value2, "fieldLocale");
            return (Criteria) this;
        }

        public Criteria andFieldLocaleNotBetween(String value1, String value2) {
            addCriterion("field_locale not between", value1, value2, "fieldLocale");
            return (Criteria) this;
        }

        public Criteria andFieldTimeIsNull() {
            addCriterion("field_time is null");
            return (Criteria) this;
        }

        public Criteria andFieldTimeIsNotNull() {
            addCriterion("field_time is not null");
            return (Criteria) this;
        }

        public Criteria andFieldTimeEqualTo(String value) {
            addCriterion("field_time =", value, "fieldTime");
            return (Criteria) this;
        }

        public Criteria andFieldTimeNotEqualTo(String value) {
            addCriterion("field_time <>", value, "fieldTime");
            return (Criteria) this;
        }

        public Criteria andFieldTimeGreaterThan(String value) {
            addCriterion("field_time >", value, "fieldTime");
            return (Criteria) this;
        }

        public Criteria andFieldTimeGreaterThanOrEqualTo(String value) {
            addCriterion("field_time >=", value, "fieldTime");
            return (Criteria) this;
        }

        public Criteria andFieldTimeLessThan(String value) {
            addCriterion("field_time <", value, "fieldTime");
            return (Criteria) this;
        }

        public Criteria andFieldTimeLessThanOrEqualTo(String value) {
            addCriterion("field_time <=", value, "fieldTime");
            return (Criteria) this;
        }

        public Criteria andFieldTimeLike(String value) {
            addCriterion("field_time like", value, "fieldTime");
            return (Criteria) this;
        }

        public Criteria andFieldTimeNotLike(String value) {
            addCriterion("field_time not like", value, "fieldTime");
            return (Criteria) this;
        }

        public Criteria andFieldTimeIn(List<String> values) {
            addCriterion("field_time in", values, "fieldTime");
            return (Criteria) this;
        }

        public Criteria andFieldTimeNotIn(List<String> values) {
            addCriterion("field_time not in", values, "fieldTime");
            return (Criteria) this;
        }

        public Criteria andFieldTimeBetween(String value1, String value2) {
            addCriterion("field_time between", value1, value2, "fieldTime");
            return (Criteria) this;
        }

        public Criteria andFieldTimeNotBetween(String value1, String value2) {
            addCriterion("field_time not between", value1, value2, "fieldTime");
            return (Criteria) this;
        }

        public Criteria andFieldChargeIsNull() {
            addCriterion("field_charge is null");
            return (Criteria) this;
        }

        public Criteria andFieldChargeIsNotNull() {
            addCriterion("field_charge is not null");
            return (Criteria) this;
        }

        public Criteria andFieldChargeEqualTo(Double value) {
            addCriterion("field_charge =", value, "fieldCharge");
            return (Criteria) this;
        }

        public Criteria andFieldChargeNotEqualTo(Double value) {
            addCriterion("field_charge <>", value, "fieldCharge");
            return (Criteria) this;
        }

        public Criteria andFieldChargeGreaterThan(Double value) {
            addCriterion("field_charge >", value, "fieldCharge");
            return (Criteria) this;
        }

        public Criteria andFieldChargeGreaterThanOrEqualTo(Double value) {
            addCriterion("field_charge >=", value, "fieldCharge");
            return (Criteria) this;
        }

        public Criteria andFieldChargeLessThan(Double value) {
            addCriterion("field_charge <", value, "fieldCharge");
            return (Criteria) this;
        }

        public Criteria andFieldChargeLessThanOrEqualTo(Double value) {
            addCriterion("field_charge <=", value, "fieldCharge");
            return (Criteria) this;
        }

        public Criteria andFieldChargeIn(List<Double> values) {
            addCriterion("field_charge in", values, "fieldCharge");
            return (Criteria) this;
        }

        public Criteria andFieldChargeNotIn(List<Double> values) {
            addCriterion("field_charge not in", values, "fieldCharge");
            return (Criteria) this;
        }

        public Criteria andFieldChargeBetween(Double value1, Double value2) {
            addCriterion("field_charge between", value1, value2, "fieldCharge");
            return (Criteria) this;
        }

        public Criteria andFieldChargeNotBetween(Double value1, Double value2) {
            addCriterion("field_charge not between", value1, value2, "fieldCharge");
            return (Criteria) this;
        }

        public Criteria andFieldManagernameIsNull() {
            addCriterion("field_managername is null");
            return (Criteria) this;
        }

        public Criteria andFieldManagernameIsNotNull() {
            addCriterion("field_managername is not null");
            return (Criteria) this;
        }

        public Criteria andFieldManagernameEqualTo(String value) {
            addCriterion("field_managername =", value, "fieldManagername");
            return (Criteria) this;
        }

        public Criteria andFieldManagernameNotEqualTo(String value) {
            addCriterion("field_managername <>", value, "fieldManagername");
            return (Criteria) this;
        }

        public Criteria andFieldManagernameGreaterThan(String value) {
            addCriterion("field_managername >", value, "fieldManagername");
            return (Criteria) this;
        }

        public Criteria andFieldManagernameGreaterThanOrEqualTo(String value) {
            addCriterion("field_managername >=", value, "fieldManagername");
            return (Criteria) this;
        }

        public Criteria andFieldManagernameLessThan(String value) {
            addCriterion("field_managername <", value, "fieldManagername");
            return (Criteria) this;
        }

        public Criteria andFieldManagernameLessThanOrEqualTo(String value) {
            addCriterion("field_managername <=", value, "fieldManagername");
            return (Criteria) this;
        }

        public Criteria andFieldManagernameLike(String value) {
            addCriterion("field_managername like", value, "fieldManagername");
            return (Criteria) this;
        }

        public Criteria andFieldManagernameNotLike(String value) {
            addCriterion("field_managername not like", value, "fieldManagername");
            return (Criteria) this;
        }

        public Criteria andFieldManagernameIn(List<String> values) {
            addCriterion("field_managername in", values, "fieldManagername");
            return (Criteria) this;
        }

        public Criteria andFieldManagernameNotIn(List<String> values) {
            addCriterion("field_managername not in", values, "fieldManagername");
            return (Criteria) this;
        }

        public Criteria andFieldManagernameBetween(String value1, String value2) {
            addCriterion("field_managername between", value1, value2, "fieldManagername");
            return (Criteria) this;
        }

        public Criteria andFieldManagernameNotBetween(String value1, String value2) {
            addCriterion("field_managername not between", value1, value2, "fieldManagername");
            return (Criteria) this;
        }

        public Criteria andFieldManegertelIsNull() {
            addCriterion("field_manegertel is null");
            return (Criteria) this;
        }

        public Criteria andFieldManegertelIsNotNull() {
            addCriterion("field_manegertel is not null");
            return (Criteria) this;
        }

        public Criteria andFieldManegertelEqualTo(String value) {
            addCriterion("field_manegertel =", value, "fieldManegertel");
            return (Criteria) this;
        }

        public Criteria andFieldManegertelNotEqualTo(String value) {
            addCriterion("field_manegertel <>", value, "fieldManegertel");
            return (Criteria) this;
        }

        public Criteria andFieldManegertelGreaterThan(String value) {
            addCriterion("field_manegertel >", value, "fieldManegertel");
            return (Criteria) this;
        }

        public Criteria andFieldManegertelGreaterThanOrEqualTo(String value) {
            addCriterion("field_manegertel >=", value, "fieldManegertel");
            return (Criteria) this;
        }

        public Criteria andFieldManegertelLessThan(String value) {
            addCriterion("field_manegertel <", value, "fieldManegertel");
            return (Criteria) this;
        }

        public Criteria andFieldManegertelLessThanOrEqualTo(String value) {
            addCriterion("field_manegertel <=", value, "fieldManegertel");
            return (Criteria) this;
        }

        public Criteria andFieldManegertelLike(String value) {
            addCriterion("field_manegertel like", value, "fieldManegertel");
            return (Criteria) this;
        }

        public Criteria andFieldManegertelNotLike(String value) {
            addCriterion("field_manegertel not like", value, "fieldManegertel");
            return (Criteria) this;
        }

        public Criteria andFieldManegertelIn(List<String> values) {
            addCriterion("field_manegertel in", values, "fieldManegertel");
            return (Criteria) this;
        }

        public Criteria andFieldManegertelNotIn(List<String> values) {
            addCriterion("field_manegertel not in", values, "fieldManegertel");
            return (Criteria) this;
        }

        public Criteria andFieldManegertelBetween(String value1, String value2) {
            addCriterion("field_manegertel between", value1, value2, "fieldManegertel");
            return (Criteria) this;
        }

        public Criteria andFieldManegertelNotBetween(String value1, String value2) {
            addCriterion("field_manegertel not between", value1, value2, "fieldManegertel");
            return (Criteria) this;
        }

        public Criteria andFieldStatusIsNull() {
            addCriterion("field_status is null");
            return (Criteria) this;
        }

        public Criteria andFieldStatusIsNotNull() {
            addCriterion("field_status is not null");
            return (Criteria) this;
        }

        public Criteria andFieldStatusEqualTo(Integer value) {
            addCriterion("field_status =", value, "fieldStatus");
            return (Criteria) this;
        }

        public Criteria andFieldStatusNotEqualTo(Integer value) {
            addCriterion("field_status <>", value, "fieldStatus");
            return (Criteria) this;
        }

        public Criteria andFieldStatusGreaterThan(Integer value) {
            addCriterion("field_status >", value, "fieldStatus");
            return (Criteria) this;
        }

        public Criteria andFieldStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("field_status >=", value, "fieldStatus");
            return (Criteria) this;
        }

        public Criteria andFieldStatusLessThan(Integer value) {
            addCriterion("field_status <", value, "fieldStatus");
            return (Criteria) this;
        }

        public Criteria andFieldStatusLessThanOrEqualTo(Integer value) {
            addCriterion("field_status <=", value, "fieldStatus");
            return (Criteria) this;
        }

        public Criteria andFieldStatusIn(List<Integer> values) {
            addCriterion("field_status in", values, "fieldStatus");
            return (Criteria) this;
        }

        public Criteria andFieldStatusNotIn(List<Integer> values) {
            addCriterion("field_status not in", values, "fieldStatus");
            return (Criteria) this;
        }

        public Criteria andFieldStatusBetween(Integer value1, Integer value2) {
            addCriterion("field_status between", value1, value2, "fieldStatus");
            return (Criteria) this;
        }

        public Criteria andFieldStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("field_status not between", value1, value2, "fieldStatus");
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