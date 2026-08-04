package org.example.logitrack.mapper;


import org.example.logitrack.dtos.LigneCommandeRequestDTO;
import org.example.logitrack.dtos.LigneCommandeResponseDTO;
import org.example.logitrack.entity.LigneCommande;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ProduitMapper.class})
public interface LigneCommandeMapper {

    @Mapping(target = "produit.id", source = "produitId")
    @Mapping(target = "commande", ignore = true)
    LigneCommande toEntity(LigneCommandeRequestDTO dto);

    LigneCommandeResponseDTO toResponseDto(LigneCommande entity);
}