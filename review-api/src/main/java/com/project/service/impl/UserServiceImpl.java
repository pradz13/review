package com.project.service.impl;

import com.project.dto.UserDto;
import com.project.entities.DateTimeLogger;
import com.project.entities.User;
import com.project.repository.UserRepository;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = convertToEntity(userDto);
        return convertToDto(userRepository.save(user));
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        Long userId = userDto.getId();
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found for userId : " + userId));
        setValuesFromDtoToEntity(userDto, user);
        return convertToDto(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found for userId : " + userId));
        userRepository.delete(user);
    }

    private User convertToEntity(UserDto userDto) {
        return User.builder()
                .name(userDto.getName())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .email(userDto.getEmail())
                .roles("ROLE_USER")
                .isEnabled(true)
                .dateTimeLogger(DateTimeLogger.builder()
                        .createdTp(LocalDateTime.now())
                        .lastUpdatedTp(LocalDateTime.now())
                        .build())
                .build();

    }

    private UserDto convertToDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();

    }

    private void setValuesFromDtoToEntity(UserDto userDto, User user) {
        user.setName(userDto.getName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEmail(userDto.getEmail());
    }
}
