package org.example.logitrack.mapper;

@Mapper(componentModel = "spring")

public interface AuthMapper {
    @Mapping(target="id",ignore = true)
    @Mapping(target = "role",ignore = true)
    User toEntity(RegisterUser user);
}