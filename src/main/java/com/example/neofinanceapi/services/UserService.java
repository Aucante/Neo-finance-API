package com.example.neofinanceapi.services;

import com.example.neofinanceapi.dto.UserDto;
import com.example.neofinanceapi.dto.user.UserPortfolioDetailsDto;

public interface UserService extends AbstractService<UserDto> {
    UserPortfolioDetailsDto findFullPortfolioDetailsById(Integer userId);
}
