package com.company.restapiexample.mapper;

import com.company.restapiexample.dto.UserDto;
import com.company.restapiexample.entity.User;
import org.mapstruct.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDto UserDto);

    UserDto toDto(User User);

    List<UserDto> toDto(List<User> Users);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(UserDto userDto, @MappingTarget User user);


}