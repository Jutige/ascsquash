package com.asc.squash.domaine;

public class Site {

    private Long siteId;
    private String siteName;
    private String siteAddress;
    private String sitePostalCode;
    private String siteCity;

    public Site() {
    }

    public Site(Long siteId, String siteName, String siteAddress, String sitePostalCode, String siteCity) {
        this.siteId = siteId;
        this.siteName = siteName;
        this.siteAddress = siteAddress;
        this.sitePostalCode = sitePostalCode;
        this.siteCity = siteCity;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteAddress() {
        return siteAddress;
    }

    public void setSiteAddress(String siteAddress) {
        this.siteAddress = siteAddress;
    }

    public String getSitePostalCode() {
        return sitePostalCode;
    }

    public void setSitePostalCode(String sitePostalCode) {
        this.sitePostalCode = sitePostalCode;
    }

    public String getSiteCity() {
        return siteCity;
    }

    public void setSiteCity(String siteCity) {
        this.siteCity = siteCity;
    }
}
