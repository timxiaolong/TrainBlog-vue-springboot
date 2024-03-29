package com.trainblog.mapper;

import com.trainblog.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tyl
 * @since 2024-01-19
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
