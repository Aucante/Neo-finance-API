package com.example.neofinanceapi.services.Impl;

import com.example.neofinanceapi.dto.UserDto;
import com.example.neofinanceapi.models.User;
import com.example.neofinanceapi.repositories.UserRepository;
import com.example.neofinanceapi.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        return userRepository.findAll()
                .stream()
                .map(UserDto::fromUserEntity)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Integer id) {
        return userRepository.findById(id)
                .map(UserDto::fromUserEntity)
                .orElseThrow(() -> new EntityNotFoundException("User not found with this provided ID : ." + id));
    }

    @Override
    public void delete(Integer id) {

    }
}
