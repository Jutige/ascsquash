package com.asc.squash.application.service;

import com.asc.squash.application.mapper.InfoDtoMapper;
import com.asc.squash.domaine.IInfoDomaine;
import com.asc.squash.domaine.Info;
import com.asc.squash.exposition.dto.InfoDto;
import com.asc.squash.exposition.dto.InfoDtoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class InfoManagmentImpl implements IInfoManagment{

    @Autowired
    IInfoDomaine infoDomaine;

    @Autowired
    InfoDtoMapper infoDtoMapper;

    @Override
    public InfoDtoResult createInfo(InfoDto infoDto) {

        Info info = infoDomaine.createInfo(infoDtoMapper.mapToDomain(infoDto));
        if (info != null) {
            InfoDto infoDto1 = infoDtoMapper.mapToEntity(info);

            //Envoi du mail à développer

            InfoDtoResult infoDtoResult = new InfoDtoResult (info.getIdInfo(), infoDto1);
            return infoDtoResult;
        }
        return null;
    }

    @Override
    public List<InfoDtoResult> listInfo() {

        List<InfoDtoResult> infoDtoResults = new ArrayList<InfoDtoResult>();
        for (Info info : infoDomaine.listInfo()){
            InfoDto infoDto = infoDtoMapper.mapToEntity(info);
            infoDtoResults.add(new InfoDtoResult(info.getIdInfo(),infoDto));
        }
        return infoDtoResults;
    }

    @Override
    public boolean deleteInfo(Long idInfo) {
        return infoDomaine.deleteInfo(idInfo);
    }

    @Override
    public boolean updateInfo(InfoDtoResult infoDtoResult) {

        Info info = infoDtoMapper.mapToDomain(infoDtoResult);
        info.setIdInfo(infoDtoResult.getIdInfo());
        return infoDomaine.updateInfo(info);
    }
}
