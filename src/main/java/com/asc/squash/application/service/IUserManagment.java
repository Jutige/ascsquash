package com.asc.squash.application.service;

import com.asc.squash.exposition.dto.UserDtoCreate;

public interface IUserManagment {
    String createJoueur(UserDtoCreate userDto);
}
