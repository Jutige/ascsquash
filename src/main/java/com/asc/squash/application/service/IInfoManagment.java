package com.asc.squash.application.service;

import com.asc.squash.exposition.dto.InfoDto;
import com.asc.squash.exposition.dto.InfoDtoResult;

import java.util.List;

public interface IInfoManagment {
    InfoDtoResult createInfo(InfoDto infoDto);

    List<InfoDtoResult> listInfo();

    boolean deleteInfo(Long idInfo);

    boolean updateInfo(InfoDtoResult infoDtoResult);

    InfoDtoResult getInfoById(Long idInfo);
}
