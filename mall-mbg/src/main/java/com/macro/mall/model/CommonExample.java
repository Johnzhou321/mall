package com.macro.mall.model;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 通用Example
 * @author zhouguangming
 * @date 19-8-23
 * @since
 */
public class CommonExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;//应该是单数

    public CommonExample() {
        this.oredCriteria = new ArrayList<Criteria>();
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void setOredCriteria(List<Criteria> oredCriteria) {
        this.oredCriteria = oredCriteria;
    }

    public void or(Criteria criteria){
        oredCriteria.add(criteria);
    }

    public Criteria or(){
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria(){
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0){
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    public void clear(){
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    protected abstract static class GeneratedCriteria{
        protected List<Criterion> criterias;
        protected GeneratedCriteria(){
            super();
            criterias = new ArrayList<Criterion>();
        }

        public boolean isValid(){
            return criterias.size() > 0;
        }

        public List<Criterion> getCriterias(){
            return criterias;
        }

        public List<Criterion> getAllCriterias(){
            return criterias;
        }

        public Criteria addCriterion(String condition){
            if (StringUtils.isEmpty(condition)){
                throw new RuntimeException("Value for condition cannot be null");
            }
            criterias.add(new Criterion(condition));
            return (Criteria) this;
        }


        public Criteria addCriterion(String condition, Object value, String property){
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criterias.add(new Criterion(condition, value));
            return (Criteria)this;
        }

        public Criteria addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criterias.add(new Criterion(condition, value1, value2));
            return (Criteria)this;
        }

        public Criteria addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
            return (Criteria)this;
        }

        public Criteria addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
            return (Criteria)this;
        }

        public Criteria addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
            return (Criteria)this;
        }

    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria(){
            super();
        }

    }

    protected static class Criterion{

        protected String condition;

        protected Object value;

        protected Object secondValue;

        protected boolean noValue;

        protected boolean singleValue;

        protected boolean betweenValue;

        protected boolean listValue;

        protected String typeHandler;

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

        protected Criterion(String condition){
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler){
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

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler){
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
