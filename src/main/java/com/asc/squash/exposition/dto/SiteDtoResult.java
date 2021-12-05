package com.asc.squash.exposition.dto;

public class SiteDtoResult extends SiteDto{

    private Long siteId;

    public SiteDtoResult() {
    }

    public SiteDtoResult(Long siteId, SiteDto siteDto) {
        super(siteDto.getSiteName(),
                siteDto.getSiteAddress(),
                siteDto.getSitePostalCode(),
                siteDto.getSiteCity());
        this.siteId = siteId;
    }

    public SiteDtoResult(String siteName, String siteAddress, String sitePostalCode, String siteCity, Long siteId) {
        super(siteName, siteAddress, sitePostalCode, siteCity);
        this.siteId = siteId;
    }
}
