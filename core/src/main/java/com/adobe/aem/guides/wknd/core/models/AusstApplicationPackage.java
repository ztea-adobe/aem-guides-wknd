package com.adobe.aem.guides.wknd.core.models;

import com.google.gson.annotations.SerializedName;

public class AusstApplicationPackage {
	
	// i.e., core, non-core
	@SerializedName("Type")
    String type;
	
	// i.e., AdobePhotoshop24-Core
	@SerializedName("PackageName")
	String packageName;
	
	// i.e., 1839275063
	@SerializedName("DownloadSize")
	long downloadSize;
	
	// i.e., 5005473024
	@SerializedName("ExtractSize")
	long extractSize;
	
	// i.e., /AdobeProducts/PHSP/24.0.0.59/macuniversal/621a808b-eb87-4b6e-96f2-6a4e92480b96/AdobePhotoshop24-Core.zip
	@SerializedName("Path")
	String path;
	
	// i.e., zip, dmg
	@SerializedName("Format")
	String format;
	
	// i.e., cffc2cb5b3858ee86ca64823a266b6d8
	@SerializedName("packageHashKey")
	String packageHashKey;
	
	// i.e., 64-bit
	@SerializedName("ProcessorFamily")
	String processorFamily;
	
	// i.e., AdobePhotoshop24-Core.zip
	@SerializedName("fullPackageName")
	String fullPackageName;
    
    /**
     * Get the type value from Application.json - Packages - Package
     * 
     * @return package type
     */
    public String getType() {
        return type;
    }
    
    /**
     * Set the package type
     * 
     * @param type
     *            String type to set
     */
    public void setType(String type) {
        this.type = type;
    }
    
    /**
     * Get the PackageName value from Application.json - Packages - Package
     * 
     * @return the package name
     */
    public String getPackageName() {
        return packageName;
    }
    
    /**
     * Set the package name
     * 
     * @param packageName
     *            String name to set
     */
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
    
    /**
     * Get the DownloadSize value from Application.json - Packages - Package
     * 
     * @return the package download size
     */
    public long getDownloadSize() {
        return downloadSize;
    }
    
    /**
     * Set the package download size
     * 
     * @param downloadSize
     *            long value to set for download size
     */
    public void setDownloadSize(long downloadSize) {
        this.downloadSize = downloadSize;
    }
    
    /**
     * Get the ExtractSize value from Application.json - Packages - Package
     * 
     * @return the package extract size
     */
    public long getExtractSize() {
        return extractSize;
    }
    
    /**
     * Set the package extract size
     * 
     * @param extractSize
     *            long value to set for extract size
     */
    public void setExtractSize(long extractSize) {
        this.extractSize = extractSize;
    }

    /**
     * Get the path value from Application.json - Packages - Package
     * 
     * @return package path
     */
    public String getPath() {
        return type;
    }
    
    /**
     * Set the package path
     * 
     * @param path
     *            String path to set
     */
    public void setPath(String path) {
        this.path = path;
    }
    
    /**
     * Get the format value from Application.json - Packages - Package
     * 
     * @return package format
     */
    public String getFormat() {
        return format;
    }
    
    /**
     * Set the package format
     * 
     * @param format
     *            String format to set
     */
    public void setFormat(String format) {
        this.format = format;
    }
    
    /**
     * Get the packageHashKey value from Application.json - Packages - Package
     * 
     * @return package packageHashKey
     */
    public String getPackageHashKey() {
        return packageHashKey;
    }
    
    /**
     * Set the package packageHashKey
     * 
     * @param packageHashKey
     *            String packageHashKey to set
     */
    public void setPackageHashKey(String packageHashKey) {
        this.packageHashKey = packageHashKey;
    }
    
    /**
     * Get the processorFamily value from Application.json - Packages - Package
     * 
     * @return package processorFamily
     */
    public String getProcessorFamily() {
        return packageHashKey;
    }
    
    /**
     * Set the package processorFamily
     * 
     * @param processorFamily
     *            String processorFamily to set
     */
    public void setProcessorFamily(String processorFamily) {
        this.processorFamily = processorFamily;
    }
    
    
    /**
     * Get the fullPackageName value from Application.json - Packages - Package
     * 
     * @return package fullPackageName
     */
    public String getFullPackageName() {
        return fullPackageName;
    }
    
    /**
     * Set the package fullPackageName
     * 
     * @param fullPackageName
     *            String fullPackageName to set
     */
    public void setFullPackageName(String fullPackageName) {
        this.fullPackageName = fullPackageName;
    }
}
