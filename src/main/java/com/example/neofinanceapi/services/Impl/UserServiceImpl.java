package com.example.neofinanceapi.services.Impl;

import com.example.neofinanceapi.dto.UserDto;
import com.example.neofinanceapi.models.User;
import com.example.neofinanceapi.repositories.UserRepository;
import com.example.neofinanceapi.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Integer save(UserDto dto) {
        User user = UserDto.toUserEntity(dto);

        return userRepository.save(user).getId();
    }

    @Override
    public List<UserDto> findAll() {
        return List.of();
    }

    @Override
    public UserDto findById(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
