package com.asc.squash.exposition.dto;

public class SiteDto {
    private String siteName;
    private String siteAddress;
    private String sitePostalCode;
    private String siteCity;

    public SiteDto() {
    }

    public SiteDto(String siteName, String siteAddress, String sitePostalCode, String siteCity) {
        this.siteName = siteName;
        this.siteAddress = siteAddress;
        this.sitePostalCode = sitePostalCode;
        this.siteCity = siteCity;
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

    @Override
    public String toString() {
        return "SiteDto{" +
                "siteName='" + siteName + '\'' +
                ", siteAddress='" + siteAddress + '\'' +
                ", sitePostalCode='" + sitePostalCode + '\'' +
                ", siteCity='" + siteCity + '\'' +
                '}';
    }
}
