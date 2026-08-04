package org.example.logitrack.mapper;



import org.example.logitrack.dtos.ProduitDTO;
import org.example.logitrack.entity.Produit;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProduitMapper {

    ProduitDTO toDto(Produit produit);

    Produit toEntity(ProduitDTO produitDTO);

    List<ProduitDTO> toDtoList(List<Produit> produits);
}


