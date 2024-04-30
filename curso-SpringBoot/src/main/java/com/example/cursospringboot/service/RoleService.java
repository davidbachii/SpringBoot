package com.example.cursospringboot.service;

import com.example.cursospringboot.entity.Role;

import java.util.Optional;
import java.util.Set;

public interface RoleService {


    void assignRoleToUser(String email, String roleName);

    Set<Role> getRolesOfUser(String email);

    boolean userHasRole(String email, String roleName);

    Optional<Role> getRoleByName(String name);
    Role createRole(Role role);

    Role updateRole(String name, Role roleDetails);

    void deleteRole(String name);
}
