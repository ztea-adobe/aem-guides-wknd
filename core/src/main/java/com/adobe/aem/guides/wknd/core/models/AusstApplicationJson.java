package com.adobe.aem.guides.wknd.core.models;

import com.google.gson.annotations.SerializedName;

public class AusstApplicationJson {

	@SerializedName("Name")
    String name;
	
	@SerializedName("SAPCode")
	String SAPCode;
	
	@SerializedName("CodexVersion")
	String CodexVersion;
	
	@SerializedName("AssetGuid")
	String AssetGuid;
	
	@SerializedName("ProductVersion")
	String ProductVersion;
	
	
	@SerializedName("BaseVersion")
	String BaseVersion;
	
	@SerializedName("Platform")
	String Platform;
	
	@SerializedName("Packages")
	AusstApplicationPackagesList packageList;
	
	/**
     * Get the Application.json name
     * 
     * @return packageList
     */
    public AusstApplicationPackagesList getPackageList() {
        return packageList;
    }
    
    /**
     * Set the name
     * 
     * @param packageList
     *            List of Ausst packages
     */
    public void setAusstApplicationPackagesList(AusstApplicationPackagesList packageList) {
        this.packageList = packageList;
    }
    
    /**
     * Get the Application.json name
     * 
     * @return name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Set the name
     * 
     * @param name
     *            String name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Get the Application.json SAPCode
     * 
     * @return SAPCode
     */
    public String getSAPCode() {
        return SAPCode;
    }
    
    /**
     * Set the SAPCode
     * 
     * @param SAPCode
     *            String name to set
     */
    public void setSAPCode(String SAPCode) {
        this.SAPCode = SAPCode;
    }
    
    /**
     * Get the Application.json CodexVersion
     * 
     * @return CodexVersion
     */
    public String getCodexVersion() {
        return CodexVersion;
    }
    
    /**
     * Set the CodexVersion
     * 
     * @param CodexVersion
     *            String name to set
     */
    public void setCodexVersion(String CodexVersion) {
        this.CodexVersion = CodexVersion;
    }
    
    /**
     * Get the Application.json AssetGuid
     * 
     * @return AssetGuid
     */
    public String getAssetGuid() {
        return AssetGuid;
    }
    
    /**
     * Set the AssetGuid
     * 
     * @param AssetGuid
     *            String name to set
     */
    public void setAssetGuid(String AssetGuid) {
        this.AssetGuid = AssetGuid;
    }
    
    /**
     * Get the Application.json ProductVersion
     * 
     * @return ProductVersion
     */
    public String getProductVersion() {
        return ProductVersion;
    }
    
    /**
     * Set the ProductVersion
     * 
     * @param ProductVersion
     *            String name to set
     */
    public void setProductVersion(String ProductVersion) {
        this.ProductVersion = ProductVersion;
    }
    
    /**
     * Get the Application.json BaseVersion
     * 
     * @return BaseVersion
     */
    public String getBaseVersion() {
        return BaseVersion;
    }
    
    /**
     * Set the BaseVersion
     * 
     * @param BaseVersion
     *            String name to set
     */
    public void setBaseVersion(String BaseVersion) {
        this.BaseVersion = BaseVersion;
    }
    
    /**
     * Get the Application.json Platform
     * 
     * @return Platform
     */
    public String getPlatform() {
        return Platform;
    }
    
    /**
     * Set the Platform
     * 
     * @param Platform
     *            String name to set
     */
    public void setPlatform(String Platform) {
        this.Platform = Platform;
    }
}
