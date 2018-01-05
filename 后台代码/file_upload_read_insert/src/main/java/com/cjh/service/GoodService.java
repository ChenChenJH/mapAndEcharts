package com.cjh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjh.entity.Good;
import com.cjh.mapper.GoodMapper;

@Service
public class GoodService {
	@Autowired
	private GoodMapper goodMapper;

	public List<Good> selectAll() throws Exception {
		return goodMapper.selectAll();
	}
}
