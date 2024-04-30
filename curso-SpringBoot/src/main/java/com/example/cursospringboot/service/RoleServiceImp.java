package com.example.cursospringboot.service;


import com.example.cursospringboot.entity.Role;
import com.example.cursospringboot.entity.User;
import com.example.cursospringboot.repository.RoleRepository;
import com.example.cursospringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class RoleServiceImp implements RoleService{

    @Autowired
    RoleRepository roleRepository;


    @Autowired
    UserRepository userRepository;

    @Override
    public void assignRoleToUser(String email, String roleName) {
        Optional<User> userOptional = userRepository.findById(email);
        Optional<Role> roleOptional = roleRepository.findByName(roleName);

        if (userOptional.isPresent() && roleOptional.isPresent()) {
            User user = userOptional.get();
            Role role = roleOptional.get();

            user.getRoles().add(role);
            userRepository.save(user);
        }
    }

    @Override
    public Set<Role> getRolesOfUser(String email) {
        Optional<User> userOptional = userRepository.findById(email);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return user.getRoles();
        }

        return null;
    }

    @Override
    public boolean userHasRole(String email, String roleName) {
        Optional<User> userOptional = userRepository.findById(email);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return user.getRoles().stream().anyMatch(role -> role.getName().equals(roleName));
        }

        return false;
    }

    @Override
    public Optional<Role> getRoleByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(String name, Role roleDetails) {
        Role role = roleRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        role.setName(roleDetails.getName());
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(String name) {
        Role role = roleRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        roleRepository.delete(role);
    }
}
