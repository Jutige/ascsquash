package com.asc.squash.application.service;

import com.asc.squash.exposition.dto.JoueurDto;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface IJoueurManagment {


    String createJoueur(JoueurDto joueurDto);

    List<JoueurDto> listJoueurDto();

    JoueurDto updateJoueur(JoueurDto joueurDto);

    String deleteJoueur(String mail);
}
