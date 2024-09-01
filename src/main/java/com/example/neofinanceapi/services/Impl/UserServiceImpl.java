package com.example.neofinanceapi.services.Impl;

import com.example.neofinanceapi.dto.PortfolioDto;
import com.example.neofinanceapi.dto.PortfolioLineDto;
import com.example.neofinanceapi.dto.UserDto;
import com.example.neofinanceapi.dto.portofolio.PortfolioDetailsDto;
import com.example.neofinanceapi.dto.user.UserPortfolioDetailsDto;
import com.example.neofinanceapi.exceptions.ObjectsValidator;
import com.example.neofinanceapi.models.Portfolio;
import com.example.neofinanceapi.models.PortfolioLine;
import com.example.neofinanceapi.models.User;
import com.example.neofinanceapi.repositories.PortfolioRepository;
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

    private final PortfolioRepository portfolioRepository;

    private final ObjectsValidator<UserDto> validator;

    @Override
    public Integer save(UserDto dto) {
        validator.validate(dto);
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
        userRepository.deleteById(id);
    }

    @Override
    public UserPortfolioDetailsDto findFullPortfolioDetailsById(Integer id) {
        UserDto userDto = userRepository.findById(id)
                .map(UserDto::fromUserEntity)
                .orElseThrow(() -> new EntityNotFoundException("User not found with this provided ID : ." + id));

        List<Portfolio> portfolios = portfolioRepository.findAllByUserId(id);


        List<PortfolioDetailsDto> portfolioDetailsDtos = portfolios.stream()
                .map(portfolio -> {

                    PortfolioDto portfolioDto = PortfolioDto.fromPortfolioEntity(portfolio);

                    List<PortfolioLineDto> portfolioLineDtos = portfolio.getPortfolioLines().stream()
                            .map(PortfolioLineDto::fromPortfolioLineEntity)
                            .collect(Collectors.toList());

                    return new PortfolioDetailsDto(portfolioDto, portfolioLineDtos);
                })
                .collect(Collectors.toList());

        return new UserPortfolioDetailsDto(userDto, portfolioDetailsDtos);
    }
}
