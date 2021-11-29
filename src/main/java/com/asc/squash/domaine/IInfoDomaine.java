package com.asc.squash.domaine;

import java.util.List;

public interface IInfoDomaine {
    Info createInfo(Info mapToDomain);

    List<Info> listInfo();

    boolean deleteInfo(Long idInfo);

    boolean updateInfo(Info info);

    Info getInfoById(Long idInfo);
}
