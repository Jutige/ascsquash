package com.asc.squash.infrastructure.Info;

import com.asc.squash.domaine.IInfoDomaine;
import com.asc.squash.domaine.Info;
import com.asc.squash.infrastructure.User.IUserRepository;
import com.asc.squash.infrastructure.User.UserEntity;
import com.asc.squash.infrastructure.User.UserEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class InfoRepositoryImpl implements IInfoDomaine {

    @Autowired
    IInfoRepository infoRepository;

    @Autowired
    IUserRepository userRepository;

    @Autowired
    UserEntityMapper userEntityMapper;

    @Override
    public Info createInfo(Info info) {
        UserEntity userEntity = userRepository.findByIdMail(info.getUserCreate().getIdUser());
        InfoEntity infoEntity = new InfoEntity(info.getTitle(),
                info.getBody(),
                new Date(),
                userEntity);
        InfoEntity infoEntityResult =  infoRepository.save(infoEntity);
        return new Info (infoEntityResult.getTitle(),
                infoEntityResult.getBody(),
                infoEntityResult.getCreationDate(),
                infoEntityResult.getUpdateDate(),
                userEntityMapper.mapToDomain(infoEntityResult.getUserCreate()),
                infoEntityResult.getIdInfo());
    }

    @Override
    public List<Info> listInfo() {

        List<Info> infos = new ArrayList<Info>();
        for (InfoEntity infoEntity : infoRepository.findByIdInfoNotNull()){
            infos.add(new Info(infoEntity.getTitle(),
                    infoEntity.getBody(),
                    infoEntity.getCreationDate(),
                    infoEntity.getUpdateDate(),
                    userEntityMapper.mapToDomain(infoEntity.getUserCreate()),
                    infoEntity.getIdInfo()));
        }
        return infos;
    }

    @Override
    public boolean deleteInfo(Long idInfo) {

        InfoEntity info = infoRepository.findByIdInfo(idInfo);
        if (info != null){
            infoRepository.delete(info);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateInfo(Info info) {
        InfoEntity infoEntity = infoRepository.findByIdInfo(info.getIdInfo());
        if (infoEntity != null) {
            infoEntity.setTitle(info.getTitle());
            infoEntity.setBody(info.getBody());
            infoRepository.save(infoEntity);
            return true;
        }
        return false;
    }
}
