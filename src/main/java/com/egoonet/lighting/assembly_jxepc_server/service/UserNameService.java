package com.egoonet.lighting.assembly_jxepc_server.service;

import com.egoonet.lighting.assembly_jxepc_server.dao.RoleDao;
import com.egoonet.lighting.assembly_jxepc_server.dao.UserNameDao;
import com.egoonet.lighting.assembly_jxepc_server.entity.Role;
import com.egoonet.lighting.assembly_jxepc_server.entity.UserName;
import com.egoonet.lighting.assembly_jxepc_server.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.List;

/**
 * Created by sang on 2017/12/17.
 */
@Service
@Transactional
public class UserNameService implements UserDetailsService {
    @Autowired
    private UserNameDao userNameDao;
    @Autowired
    private RoleDao roleDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserName user = userNameDao.loadUserByUsername(s);
        if (user == null) {
            //避免返回null，这里返回一个不含有任何值的User对象，在后期的密码比对过程中一样会验证失败
            return new UserName();
        }
        //查询用户的角色信息，并返回存入user中
        List<Role> roles = roleDao.getRolesByUid(user.getId());
        user.setRoles(roles);
        return user;
    }

    /**
     * @param user
     * @return 0表示成功
     * 1表示用户名重复
     * 2表示失败
     */
    public int reg(UserName user) {
        UserName loadUserByUsername = userNameDao.loadUserByUsername(user.getUsername());
        if (loadUserByUsername != null) {
            return 1;
        }
        //插入用户,插入之前先对密码进行加密
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        user.setEnabled(true);//用户可用
        long result = userNameDao.reg(user);
        //配置用户的角色，默认都是普通用户
        String[] roles = new String[]{"2"};
        int i = roleDao.addRoles(roles, user.getId());
        boolean b = i == roles.length && result == 1;
        if (b) {
            return 0;
        } else {
            return 2;
        }
    }

    public int updateUserEmail(String email) {
        return userNameDao.updateUserEmail(email, Util.getCurrentUser().getId());
    }

    public List<UserName> getUserByNickname(String nickname) {
        List<UserName> list = userNameDao.getUserByNickname(nickname);
        return list;
    }

    public List<Role> getAllRole() {
        return userNameDao.getAllRole();
    }

    public int updateUserEnabled(Boolean enabled, Long uid) {
        return userNameDao.updateUserEnabled(enabled, uid);
    }

    public int deleteUserById(Long uid) {
        return userNameDao.deleteUserById(uid);
    }

    public int updateUserRoles(Long[] rids, Long id) {
        int i = userNameDao.deleteUserRolesByUid(id);
        return userNameDao.setUserRoles(rids, id);
    }

    public UserName getUserById(Long id) {
        return userNameDao.getUserById(id);
    }
}
