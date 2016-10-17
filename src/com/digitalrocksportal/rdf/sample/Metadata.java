package com.digitalrocksportal.rdf.sample;

import org.apache.jena.vocabulary.*;
import org.apache.jena.rdf.model.*;

/**
 * @author cagdasyelen
 * 
 * This class is to define the metadata in a project page.
 * Even though this class is under the sample package, 
 * the same template will be used in the project package.
 */
public class Metadata {
	
	private String URL;
	private String projectName;
	private String description;
	
	
	private String author;
	private String [] collaborators;
	private String dateCreated;
	private String license;
	private String citation;
	
	private Model RDFModel;
	
	
	/**
	 * Hard coded constructor for the metadata object.
	 * 
	 */
	public Metadata(){
		this.URL = "https://www.digitalrocksportal.org/projects/35/";
		this.projectName = "Austin Chalk";
		this.description = "Rock sample obtained from an Austin Chalk Formation outcrop.";
		
		this.author = "Zoya Heidari (The University of Texas at Austin)";
		this.collaborators = new String[1];
		this.collaborators[0]= "Artur Posenato Garcia (The University of Texas at Austin)";
		this.dateCreated = "March 4, 2016";
		this.license = "ODC-BY 1.0";
		this.citation = "doi:10.17612/P73011";
	}
	

	public Model getRDFModel(){
		if(this.RDFModel == null){
			this.RDFModel = ModelFactory.createDefaultModel();

			Resource r = RDFModel.createResource(this.URL);
			
			r.addProperty(DC.identifier, this.projectName);
			r.addProperty(DC.description, this.description);
			r.addProperty(DC.creator, this.author);
			
			for(int i=0 ; i<this.collaborators.length ; i++){
				r.addProperty(DC.contributor, this.collaborators[i]);
			}
			
			r.addProperty(DC.date, this.dateCreated);
			r.addProperty(DCTerms.license, this.license);
			r.addProperty(DCTerms.bibliographicCitation, this.citation);
			
		}
		
		return this.RDFModel;
	}



	public String getURL() {
		return this.URL;
	}


	public void setURL(String uRL) {
		this.URL = uRL;
	}


	public String getProjectName() {
		return this.projectName;
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	public String getDescription() {
		return this.description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getAuthor() {
		return this.author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String[] getCollaborators() {
		return collaborators;
	}


	public void setCollaborators(String[] collaborators) {
		this.collaborators = collaborators;
	}


	public String getDateCreated() {
		return this.dateCreated;
	}


	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}


	public String getLicense() {
		return this.license;
	}


	public void setLicense(String license) {
		this.license = license;
	}


	public String getCitation() {
		return this.citation;
	}


	public void setCitation(String citation) {
		this.citation = citation;
	}
	
}
