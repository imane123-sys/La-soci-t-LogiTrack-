package org.example.logitrack.mapper;

import org.example.logitrack.dtos.ClientDTO;
import org.example.logitrack.entity.Client;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientDTO toDto(Client client);

    Client toEntity(ClientDTO clientDTO);

    List<ClientDTO> toDtoList(List<Client> clients);
}