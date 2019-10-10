package com.egoonet.lighting.assembly_jxepc_server.utils;

import com.egoonet.lighting.assembly_jxepc_server.entity.UserName;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by sang on 2017/12/20.
 */
public class Util {
    public static UserName getCurrentUser() {
        UserName userName = (UserName) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userName;
    }
}
