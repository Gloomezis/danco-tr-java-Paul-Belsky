package com.danco.api.dao.util;

import java.util.List;

public interface ResultBuilder<T> {
	
	ResultBuilder<T> withOffset(int offset);

	ResultBuilder<T> withLimit(int limit);

	ResultBuilder<T> orderedBy(String property);

	List<T> result();
}
