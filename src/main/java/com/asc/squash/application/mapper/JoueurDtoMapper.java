package com.asc.squash.application.mapper;

import com.asc.squash.domaine.Joueur;
import com.asc.squash.exposition.dto.JoueurDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JoueurDtoMapper {

    JoueurDto mapToJoueurDto (Joueur joueur);
    Joueur mapToJoueur (JoueurDto joueurDto);
}
