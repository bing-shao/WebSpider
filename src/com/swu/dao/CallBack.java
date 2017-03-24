package com.swu.dao;

import java.sql.ResultSet;
import java.util.List;

public interface CallBack {

	public abstract List<Object> getResults(ResultSet rs);
}
