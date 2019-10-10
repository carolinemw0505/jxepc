package com.egoonet.lighting.assembly_jxepc_server.dao;

import com.egoonet.lighting.assembly_jxepc_server.entity.Role;
import com.egoonet.lighting.assembly_jxepc_server.entity.UserName;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by sang on 2017/12/17.
 */
@Mapper
public interface UserNameDao {

        UserName loadUserByUsername(@Param("username") String username);

        long reg(UserName user);

        int updateUserEmail(@Param("email") String email, @Param("id") Long id);

        List<UserName> getUserByNickname(@Param("nickname") String nickname);

        List<Role> getAllRole();

        int updateUserEnabled(@Param("enabled") Boolean enabled, @Param("uid") Long uid);

        int deleteUserById(Long uid);

        int deleteUserRolesByUid(Long id);

        int setUserRoles(@Param("rids") Long[] rids, @Param("id") Long id);

        UserName getUserById(@Param("id") Long id);
}
