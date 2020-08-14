package com.lanxin.dao;

import java.util.Set;

public interface RoleDao {

    public String selectPassByName(String username);

    public Set<String> roles(String username);

    public Set<String> functions(String username);
}
