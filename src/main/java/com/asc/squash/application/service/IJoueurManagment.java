package com.asc.squash.application.service;

import com.asc.squash.exposition.dto.JoueurDto;
import org.springframework.http.HttpStatus;

public interface IJoueurManagment {


    String createJoueur(JoueurDto joueurDto);
}
