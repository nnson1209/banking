package com.shark.sharkbank.role.services;

import com.shark.sharkbank.res.Response;
import com.shark.sharkbank.role.entity.Role;

import java.util.List;

public interface RoleService {
    Response<Role> createRole(Role roleRequest);

    Response<Role> updateRole(Role roleRequest);

    Response<List<Role>> getAllRoles();

    Response<?> deleteRole(Long id);
}
