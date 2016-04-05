package com.danco.gloomezis.hadleer;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface TResultHandler <T>{
	//написать типизированное возвращение
T handle(ResultSet result) throws SQLException;
}
  