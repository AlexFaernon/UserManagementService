package com.university.usermanagementservice.dao;

import com.university.usermanagementservice.dto.Role;
import com.university.usermanagementservice.dto.User;

import java.util.List;
import java.util.Map;

public interface UserRepository {

    Map<Integer , User> getAllUsers();

    List<Role> getRolesByUserId(int userId);

    User getUserById(int userId);
}
