package org.apache.tuscany.sdo.plugin;

import java.io.File;

public class SchemaFileOption {
    
    /**
     * Name of the schema file
     * 
     */
    private File fileName;
    
    /**
     * The Java package to generate into. By default the value is derived from the schema URI.
     * 
     * @parameter
     */
    private String javaPackage;

    /**
     * The directory to generate into; defaults to ${project.build.directory}/sdo-source
     * 
     * @parameter expression="${project.build.directory}/sdo-source"
     */
    private String targetDirectory;

    /**
     * Specifies the prefix string to use for naming the generated factory.
     * 
     * @parameter
     */
    private String prefix;

    /**
     * This option can be used to eliminate the generated interface and to generate only an implementation class.
     * 
     * @parameter
     */
    private Boolean noInterfaces;

    /**
     * Turns off container management for containment properties.
     * 
     * @parameter
     */
    private Boolean noContainment;

    /**
     * This option eliminates all change notification overhead in the generated classes.
     * 
     * @parameter
     */
    private Boolean noNotification;

    /**
     * With this option, all generated properties will not record their unset state.
     * 
     * @parameter
     */
    private Boolean noUnsettable;

    /**
     * Generate a fast XML parser/loader for instances of the model.
     * 
     * @parameter
     */
    private Boolean generateLoader;

    /**
     * Generate a Switch class for the model.
     * 
     * @parameter
     */
    private Boolean generateSwitch;

    /**
     * With this option, generated code will not have EMF references.
     * 
     * @parameter
     */
    private Boolean noEMF;
    
    /**
     * With this option, generated interfaces will extend commonj.sdo.DataObject.
     * 
     * @parameter
     */
    private Boolean interfaceDataObject;

    public SchemaFileOption() {
    }

    public Boolean isGenerateLoader() {
        return generateLoader;
    }

    public void setGenerateLoader(Boolean generateLoader) {
        this.generateLoader = generateLoader;
    }

    public Boolean isGenerateSwitch() {
        return generateSwitch;
    }

    public void setGenerateSwitch(Boolean generateSwitch) {
        this.generateSwitch = generateSwitch;
    }

    public String getJavaPackage() {
        return javaPackage;
    }

    public void setJavaPackage(String javaPackage) {
        this.javaPackage = javaPackage;
    }

    public Boolean isNoContainment() {
        return noContainment;
    }

    public void setNoContainment(Boolean noContainment) {
        this.noContainment = noContainment;
    }

    public Boolean isNoEMF() {
        return noEMF;
    }

    public void setNoEMF(Boolean noEMF) {
        this.noEMF = noEMF;
    }
    
    public Boolean isNoInterfaces() {
        return noInterfaces;
    }

    public void setNoInterfaces(Boolean noInterfaces) {
        this.noInterfaces = noInterfaces;
    }

    public Boolean isNoNotification() {
        return noNotification;
    }

    public void setNoNotification(Boolean noNotification) {
        this.noNotification = noNotification;
    }

    public Boolean isNoUnsettable() {
        return noUnsettable;
    }

    public void setNoUnsettable(Boolean noUnsettable) {
        this.noUnsettable = noUnsettable;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getTargetDirectory() {
        return targetDirectory;
    }

    public void setTargetDirectory(String targetDirectory) {
        this.targetDirectory = targetDirectory;
    }

    public File getFileName() {
        return fileName;
    }

    public void setFileName(File fileName) {
        this.fileName = fileName;
    }

	public Boolean isInterfaceDataObject() {
		return interfaceDataObject;
	}

	public void setInterfaceDataObject(Boolean interfaceDataObject) {
		this.interfaceDataObject = interfaceDataObject;
	}

}
