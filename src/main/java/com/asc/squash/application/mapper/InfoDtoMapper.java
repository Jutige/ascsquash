package com.asc.squash.application.mapper;

import com.asc.squash.domaine.IUserDomaine;
import com.asc.squash.domaine.Info;
import com.asc.squash.domaine.User;
import com.asc.squash.exposition.dto.InfoDto;
import com.asc.squash.infrastructure.AbstractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InfoDtoMapper extends AbstractMapper<Info, InfoDto> {

    @Autowired
    private IUserDomaine userDomaine;

    @Override
    public Info mapToDomain(InfoDto infoDto) {

        User user = userDomaine.findByIdUser(infoDto.getIdUser());
        return new Info(infoDto.getTitle(),
                infoDto.getBody(),
                infoDto.getCreationDate(),
                infoDto.getUpdateDate(),
                user);
    }

    @Override
    public InfoDto mapToEntity(Info info) {
        return new InfoDto(info.getTitle(),
                info.getBody(),
                info.getCreationDate(),
                info.getUpdateDate(),
                info.getUserCreate().getIdUser(),
                false);
    }
}
