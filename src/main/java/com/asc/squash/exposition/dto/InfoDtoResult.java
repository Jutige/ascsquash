package com.asc.squash.exposition.dto;

import java.util.Date;

public class InfoDtoResult extends InfoDto{

    private Long IdInfo;

    public InfoDtoResult() {
    }

    public InfoDtoResult(String title, String body, Date creationDate, Date updateDate, String idUser, boolean notification, Long idInfo) {
        super(title, body, creationDate, updateDate, idUser, notification);
        IdInfo = idInfo;
    }

    public InfoDtoResult(Long idInfo, InfoDto infoDto){
        super(infoDto.getTitle(),
                infoDto.getBody(),
                infoDto.getCreationDate(),
                infoDto.getUpdateDate(),
                infoDto.getIdUser(),
                infoDto.isNotification());
        IdInfo = idInfo;
    }

    public Long getIdInfo() {
        return IdInfo;
    }

    public void setIdInfo(Long idInfo) {
        IdInfo = idInfo;
    }
}
