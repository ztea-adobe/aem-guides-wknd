package com.adobe.aem.guides.wknd.core.models;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class AusstApplicationPackagesList {

	/**
	 * List of package objects in the format of
	 * 
	   ...
	   Packages: {
		Package: [
		{
			<package properties
		},
		...
		]
		}
		...
	 * 
	 */
	@SerializedName("Package")
    List<AusstApplicationPackage> packageList;
	
	/**
     * Get the Application.json packageList
     * 
     * @return packageList
     */
    public List<AusstApplicationPackage> getPackageList() {
        return packageList;
    }
    
    /**
     * Set the name
     * 
     * @param packageList
     *            List of AusstApplicationPackage models
     */
    public void setPackageList(List<AusstApplicationPackage> packageList) {
        this.packageList = packageList;
    }
}
