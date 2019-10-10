package com.egoonet.lighting.assembly_jxepc_server.dao;

import com.egoonet.lighting.assembly_jxepc_server.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by sang on 2017/12/17.
 */
@Mapper
public interface RoleDao {
        int addRoles(@Param("roles") String[] roles, @Param("uid") Long uid);

        List<Role> getRolesByUid(Long uid);
}
