package com.asc.squash.application.service;

import com.asc.squash.exposition.dto.JoueurDto;
import com.asc.squash.exposition.dto.UserDto;
import com.asc.squash.exposition.dto.UserDtoCreate;

import java.util.List;

public interface IUserManagment {
    String createUser(UserDtoCreate userDto);

    List<UserDto> listUserDto();

    String deleteUser(String mail);
}
