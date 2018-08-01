package com.eakay.next.repository.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;


public interface BaseMyBatisMapper<T> extends Mapper<T>, MySqlMapper<T>
{
}
