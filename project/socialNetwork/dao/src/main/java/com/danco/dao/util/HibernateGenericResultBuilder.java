package com.danco.dao.util;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

import com.danco.api.dao.util.ResultBuilder;

public final class HibernateGenericResultBuilder<T> implements ResultBuilder<T>{
	
	 private final Criteria criteria;

	    public HibernateGenericResultBuilder(Criteria criteria) {
	        this.criteria = criteria;
	    }

	    @Override public ResultBuilder<T> withOffset(int offset) {
	        criteria.setFirstResult(offset);
	        return this;
	    }

	    @Override public ResultBuilder<T> withLimit(int limit) {
	        criteria.setMaxResults(limit);
	        return this;
	    }

	    @Override public ResultBuilder<T> orderedBy(String property) {
	        criteria.addOrder(Order.asc(property));
	        return this;
	    }

	    @SuppressWarnings("unchecked")
		@Override public List<T> result() {
	        return criteria.list();
	    }
}
