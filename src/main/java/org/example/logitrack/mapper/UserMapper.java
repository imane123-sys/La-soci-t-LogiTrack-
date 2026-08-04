package org.example.logitrack.mapper;

import org.example.logitrack.dtos.UserDTO;
import org.example.logitrack.dtos.UserRegistrationDTO;
import org.example.logitrack.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDto(User user);

    User toEntity(UserRegistrationDTO dto);

    List<UserDTO> toDtoList(List<User> users);
}