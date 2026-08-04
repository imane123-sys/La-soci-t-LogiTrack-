package org.example.logitrack.mapper;


import org.example.logitrack.dtos.CommandeRequestDTO;
import org.example.logitrack.dtos.CommandeResponseDTO;
import org.example.logitrack.entity.Commande;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ClientMapper.class, LigneCommandeMapper.class})
public interface CommandeMapper {

    @Mapping(target = "client.id", source = "clientId")
    Commande toEntity(CommandeRequestDTO requestDTO);

    CommandeResponseDTO toResponseDto(Commande entity);

    List<CommandeResponseDTO> toResponseDtoList(List<Commande> commandes);
}