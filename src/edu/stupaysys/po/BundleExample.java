package edu.stupaysys.po;

import java.util.ArrayList;
import java.util.List;

public class BundleExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table bundle
     *
     * @mbg.generated Mon Dec 02 17:00:21 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table bundle
     *
     * @mbg.generated Mon Dec 02 17:00:21 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table bundle
     *
     * @mbg.generated Mon Dec 02 17:00:21 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bundle
     *
     * @mbg.generated Mon Dec 02 17:00:21 CST 2019
     */
    public BundleExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bundle
     *
     * @mbg.generated Mon Dec 02 17:00:21 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bundle
     *
     * @mbg.generated Mon Dec 02 17:00:21 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bundle
     *
     * @mbg.generated Mon Dec 02 17:00:21 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bundle
     *
     * @mbg.generated Mon Dec 02 17:00:21 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bundle
     *
     * @mbg.generated Mon Dec 02 17:00:21 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bundle
     *
     * @mbg.generated Mon Dec 02 17:00:21 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bundle
     *
     * @mbg.generated Mon Dec 02 17:00:21 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bundle
     *
     * @mbg.generated Mon Dec 02 17:00:21 CST 2019
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bundle
     *
     * @mbg.generated Mon Dec 02 17:00:21 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bundle
     *
     * @mbg.generated Mon Dec 02 17:00:21 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table bundle
     *
     * @mbg.generated Mon Dec 02 17:00:21 CST 2019
     */
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

        public Criteria andBundleidIsNull() {
            addCriterion("bundleid is null");
            return (Criteria) this;
        }

        public Criteria andBundleidIsNotNull() {
            addCriterion("bundleid is not null");
            return (Criteria) this;
        }

        public Criteria andBundleidEqualTo(Integer value) {
            addCriterion("bundleid =", value, "bundleid");
            return (Criteria) this;
        }

        public Criteria andBundleidNotEqualTo(Integer value) {
            addCriterion("bundleid <>", value, "bundleid");
            return (Criteria) this;
        }

        public Criteria andBundleidGreaterThan(Integer value) {
            addCriterion("bundleid >", value, "bundleid");
            return (Criteria) this;
        }

        public Criteria andBundleidGreaterThanOrEqualTo(Integer value) {
            addCriterion("bundleid >=", value, "bundleid");
            return (Criteria) this;
        }

        public Criteria andBundleidLessThan(Integer value) {
            addCriterion("bundleid <", value, "bundleid");
            return (Criteria) this;
        }

        public Criteria andBundleidLessThanOrEqualTo(Integer value) {
            addCriterion("bundleid <=", value, "bundleid");
            return (Criteria) this;
        }

        public Criteria andBundleidIn(List<Integer> values) {
            addCriterion("bundleid in", values, "bundleid");
            return (Criteria) this;
        }

        public Criteria andBundleidNotIn(List<Integer> values) {
            addCriterion("bundleid not in", values, "bundleid");
            return (Criteria) this;
        }

        public Criteria andBundleidBetween(Integer value1, Integer value2) {
            addCriterion("bundleid between", value1, value2, "bundleid");
            return (Criteria) this;
        }

        public Criteria andBundleidNotBetween(Integer value1, Integer value2) {
            addCriterion("bundleid not between", value1, value2, "bundleid");
            return (Criteria) this;
        }

        public Criteria andBundlenameIsNull() {
            addCriterion("bundlename is null");
            return (Criteria) this;
        }

        public Criteria andBundlenameIsNotNull() {
            addCriterion("bundlename is not null");
            return (Criteria) this;
        }

        public Criteria andBundlenameEqualTo(String value) {
            addCriterion("bundlename =", value, "bundlename");
            return (Criteria) this;
        }

        public Criteria andBundlenameNotEqualTo(String value) {
            addCriterion("bundlename <>", value, "bundlename");
            return (Criteria) this;
        }

        public Criteria andBundlenameGreaterThan(String value) {
            addCriterion("bundlename >", value, "bundlename");
            return (Criteria) this;
        }

        public Criteria andBundlenameGreaterThanOrEqualTo(String value) {
            addCriterion("bundlename >=", value, "bundlename");
            return (Criteria) this;
        }

        public Criteria andBundlenameLessThan(String value) {
            addCriterion("bundlename <", value, "bundlename");
            return (Criteria) this;
        }

        public Criteria andBundlenameLessThanOrEqualTo(String value) {
            addCriterion("bundlename <=", value, "bundlename");
            return (Criteria) this;
        }

        public Criteria andBundlenameLike(String value) {
            addCriterion("bundlename like", value, "bundlename");
            return (Criteria) this;
        }

        public Criteria andBundlenameNotLike(String value) {
            addCriterion("bundlename not like", value, "bundlename");
            return (Criteria) this;
        }

        public Criteria andBundlenameIn(List<String> values) {
            addCriterion("bundlename in", values, "bundlename");
            return (Criteria) this;
        }

        public Criteria andBundlenameNotIn(List<String> values) {
            addCriterion("bundlename not in", values, "bundlename");
            return (Criteria) this;
        }

        public Criteria andBundlenameBetween(String value1, String value2) {
            addCriterion("bundlename between", value1, value2, "bundlename");
            return (Criteria) this;
        }

        public Criteria andBundlenameNotBetween(String value1, String value2) {
            addCriterion("bundlename not between", value1, value2, "bundlename");
            return (Criteria) this;
        }

        public Criteria andBundlevalidtimeIsNull() {
            addCriterion("bundlevalidtime is null");
            return (Criteria) this;
        }

        public Criteria andBundlevalidtimeIsNotNull() {
            addCriterion("bundlevalidtime is not null");
            return (Criteria) this;
        }

        public Criteria andBundlevalidtimeEqualTo(Integer value) {
            addCriterion("bundlevalidtime =", value, "bundlevalidtime");
            return (Criteria) this;
        }

        public Criteria andBundlevalidtimeNotEqualTo(Integer value) {
            addCriterion("bundlevalidtime <>", value, "bundlevalidtime");
            return (Criteria) this;
        }

        public Criteria andBundlevalidtimeGreaterThan(Integer value) {
            addCriterion("bundlevalidtime >", value, "bundlevalidtime");
            return (Criteria) this;
        }

        public Criteria andBundlevalidtimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("bundlevalidtime >=", value, "bundlevalidtime");
            return (Criteria) this;
        }

        public Criteria andBundlevalidtimeLessThan(Integer value) {
            addCriterion("bundlevalidtime <", value, "bundlevalidtime");
            return (Criteria) this;
        }

        public Criteria andBundlevalidtimeLessThanOrEqualTo(Integer value) {
            addCriterion("bundlevalidtime <=", value, "bundlevalidtime");
            return (Criteria) this;
        }

        public Criteria andBundlevalidtimeIn(List<Integer> values) {
            addCriterion("bundlevalidtime in", values, "bundlevalidtime");
            return (Criteria) this;
        }

        public Criteria andBundlevalidtimeNotIn(List<Integer> values) {
            addCriterion("bundlevalidtime not in", values, "bundlevalidtime");
            return (Criteria) this;
        }

        public Criteria andBundlevalidtimeBetween(Integer value1, Integer value2) {
            addCriterion("bundlevalidtime between", value1, value2, "bundlevalidtime");
            return (Criteria) this;
        }

        public Criteria andBundlevalidtimeNotBetween(Integer value1, Integer value2) {
            addCriterion("bundlevalidtime not between", value1, value2, "bundlevalidtime");
            return (Criteria) this;
        }

        public Criteria andBundlestateIsNull() {
            addCriterion("bundlestate is null");
            return (Criteria) this;
        }

        public Criteria andBundlestateIsNotNull() {
            addCriterion("bundlestate is not null");
            return (Criteria) this;
        }

        public Criteria andBundlestateEqualTo(Integer value) {
            addCriterion("bundlestate =", value, "bundlestate");
            return (Criteria) this;
        }

        public Criteria andBundlestateNotEqualTo(Integer value) {
            addCriterion("bundlestate <>", value, "bundlestate");
            return (Criteria) this;
        }

        public Criteria andBundlestateGreaterThan(Integer value) {
            addCriterion("bundlestate >", value, "bundlestate");
            return (Criteria) this;
        }

        public Criteria andBundlestateGreaterThanOrEqualTo(Integer value) {
            addCriterion("bundlestate >=", value, "bundlestate");
            return (Criteria) this;
        }

        public Criteria andBundlestateLessThan(Integer value) {
            addCriterion("bundlestate <", value, "bundlestate");
            return (Criteria) this;
        }

        public Criteria andBundlestateLessThanOrEqualTo(Integer value) {
            addCriterion("bundlestate <=", value, "bundlestate");
            return (Criteria) this;
        }

        public Criteria andBundlestateIn(List<Integer> values) {
            addCriterion("bundlestate in", values, "bundlestate");
            return (Criteria) this;
        }

        public Criteria andBundlestateNotIn(List<Integer> values) {
            addCriterion("bundlestate not in", values, "bundlestate");
            return (Criteria) this;
        }

        public Criteria andBundlestateBetween(Integer value1, Integer value2) {
            addCriterion("bundlestate between", value1, value2, "bundlestate");
            return (Criteria) this;
        }

        public Criteria andBundlestateNotBetween(Integer value1, Integer value2) {
            addCriterion("bundlestate not between", value1, value2, "bundlestate");
            return (Criteria) this;
        }

        public Criteria andBundlepriceIsNull() {
            addCriterion("bundleprice is null");
            return (Criteria) this;
        }

        public Criteria andBundlepriceIsNotNull() {
            addCriterion("bundleprice is not null");
            return (Criteria) this;
        }

        public Criteria andBundlepriceEqualTo(Double value) {
            addCriterion("bundleprice =", value, "bundleprice");
            return (Criteria) this;
        }

        public Criteria andBundlepriceNotEqualTo(Double value) {
            addCriterion("bundleprice <>", value, "bundleprice");
            return (Criteria) this;
        }

        public Criteria andBundlepriceGreaterThan(Double value) {
            addCriterion("bundleprice >", value, "bundleprice");
            return (Criteria) this;
        }

        public Criteria andBundlepriceGreaterThanOrEqualTo(Double value) {
            addCriterion("bundleprice >=", value, "bundleprice");
            return (Criteria) this;
        }

        public Criteria andBundlepriceLessThan(Double value) {
            addCriterion("bundleprice <", value, "bundleprice");
            return (Criteria) this;
        }

        public Criteria andBundlepriceLessThanOrEqualTo(Double value) {
            addCriterion("bundleprice <=", value, "bundleprice");
            return (Criteria) this;
        }

        public Criteria andBundlepriceIn(List<Double> values) {
            addCriterion("bundleprice in", values, "bundleprice");
            return (Criteria) this;
        }

        public Criteria andBundlepriceNotIn(List<Double> values) {
            addCriterion("bundleprice not in", values, "bundleprice");
            return (Criteria) this;
        }

        public Criteria andBundlepriceBetween(Double value1, Double value2) {
            addCriterion("bundleprice between", value1, value2, "bundleprice");
            return (Criteria) this;
        }

        public Criteria andBundlepriceNotBetween(Double value1, Double value2) {
            addCriterion("bundleprice not between", value1, value2, "bundleprice");
            return (Criteria) this;
        }

        public Criteria andBundleinfoIsNull() {
            addCriterion("bundleinfo is null");
            return (Criteria) this;
        }

        public Criteria andBundleinfoIsNotNull() {
            addCriterion("bundleinfo is not null");
            return (Criteria) this;
        }

        public Criteria andBundleinfoEqualTo(String value) {
            addCriterion("bundleinfo =", value, "bundleinfo");
            return (Criteria) this;
        }

        public Criteria andBundleinfoNotEqualTo(String value) {
            addCriterion("bundleinfo <>", value, "bundleinfo");
            return (Criteria) this;
        }

        public Criteria andBundleinfoGreaterThan(String value) {
            addCriterion("bundleinfo >", value, "bundleinfo");
            return (Criteria) this;
        }

        public Criteria andBundleinfoGreaterThanOrEqualTo(String value) {
            addCriterion("bundleinfo >=", value, "bundleinfo");
            return (Criteria) this;
        }

        public Criteria andBundleinfoLessThan(String value) {
            addCriterion("bundleinfo <", value, "bundleinfo");
            return (Criteria) this;
        }

        public Criteria andBundleinfoLessThanOrEqualTo(String value) {
            addCriterion("bundleinfo <=", value, "bundleinfo");
            return (Criteria) this;
        }

        public Criteria andBundleinfoLike(String value) {
            addCriterion("bundleinfo like", value, "bundleinfo");
            return (Criteria) this;
        }

        public Criteria andBundleinfoNotLike(String value) {
            addCriterion("bundleinfo not like", value, "bundleinfo");
            return (Criteria) this;
        }

        public Criteria andBundleinfoIn(List<String> values) {
            addCriterion("bundleinfo in", values, "bundleinfo");
            return (Criteria) this;
        }

        public Criteria andBundleinfoNotIn(List<String> values) {
            addCriterion("bundleinfo not in", values, "bundleinfo");
            return (Criteria) this;
        }

        public Criteria andBundleinfoBetween(String value1, String value2) {
            addCriterion("bundleinfo between", value1, value2, "bundleinfo");
            return (Criteria) this;
        }

        public Criteria andBundleinfoNotBetween(String value1, String value2) {
            addCriterion("bundleinfo not between", value1, value2, "bundleinfo");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table bundle
     *
     * @mbg.generated do_not_delete_during_merge Mon Dec 02 17:00:21 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table bundle
     *
     * @mbg.generated Mon Dec 02 17:00:21 CST 2019
     */
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