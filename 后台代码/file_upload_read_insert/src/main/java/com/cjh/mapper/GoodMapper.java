package com.cjh.mapper;

import java.util.List;

import com.cjh.entity.Good;

public interface GoodMapper {
	public List<Good> selectAll() throws Exception;
}
