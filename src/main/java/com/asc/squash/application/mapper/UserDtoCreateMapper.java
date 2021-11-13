package com.asc.squash.application.mapper;

import com.asc.squash.domaine.User;
import com.asc.squash.exposition.dto.UserDtoCreate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDtoCreateMapper {
    UserDtoCreate mapToUserDtoCreate(User user);
    User mapToUser(UserDtoCreate userDtoCreate);
}
