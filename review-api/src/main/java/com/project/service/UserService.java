package com.project.service;

import com.project.dto.UserDto;

public interface UserService {
    public UserDto createUser(UserDto userDto);

    public UserDto updateUser(UserDto userDto);

    public void deleteUser(Long userId);
}
