package com.digitalrocksportal.rdf.sample;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;

/**
 * @author cagdas
 * This class represents a project page for digitalrocks portal
 * and encapsulates the required methods to insert schema.org 
 * entities.
 * 
 * For ref: https://www.digitalrocksportal.org/
 *
 */
/**
 * @author cagdas
 *
 */
public class Page {
	
	
	//Modify the schema.org entities here if needed
	//Please note that the main type needs to have the following properties
	private final String MAIN_TYPE = "Dataset";
	private final String AUTHOR_PROP = "author";
	private final String CONTRIBUTOR_PROP = "contributor";
	private final String CREATED_PROP = "dateCreated";
	private final String LICENSE = "license";
	private final String CITATION = "citation";
	
	private String pageUrl;
	private Document doc;
	
	//TODO: institution element will be added once it is seperated
	//on the website
	private Element outerDiv;
	private Element innerDiv;
	private Element authorTag;
	private Element authorAttr;
	private Element collaboratorsTag;
	private Elements collaborators;
	private Element createdTag;
	private Element createdAttr;
	private Element licenseTag;
	private Element licenseAttr;
	private Element citeTag;
	private Element citeAttr;
	

	
	
	/**
	 * 
	 * @param url Project url from digitalrocks portal(ie. "https://www.digitalrocksportal.org/projects/35/")
	 * @throws IOException
	 */
	public Page(String url) throws IOException{
		this.pageUrl = url;
		this.doc = Jsoup.connect(url).get();
		
		//Getting different shells of blocks containing "Author"
		Elements blocks =  doc.select("div:contains(Author)");
		int size = blocks.size();
		
		
		//Last two blocks are the inner 2 shells encapsulating the html element
		//containing author
		this.outerDiv = blocks.get(size - 2);
		this.innerDiv = blocks.get(size - 1);
		
		Elements elems = this.innerDiv.children();
		
		
		//Iterates through all children elements and saves them
		//in the related class field.
		for(Element e : elems){
			if(e.tagName().equals("h4")){
						
				if(e.text().equals("Author")){
					this.authorTag = e;
					this.authorAttr = e.nextElementSibling();
				}
				
				else if(e.text().equals("Collaborators")){
					this.collaboratorsTag = e;
					this.collaborators = e.nextElementSibling().children();
				}
				else if(e.text().equals("Created")){
					this.createdTag = e;
					this.createdAttr = e.nextElementSibling();
				}
				
				else if(e.text().equals("License")){
					this.licenseTag = e;
					this.licenseAttr = e.nextElementSibling();
				}
				
				else if(e.text().equals("Cite this project")){
					this.citeTag = e;
					this.citeAttr = e.nextElementSibling();
				}
	
				
			}
		}
		
	
	}
	
	/**
	 * 
	 * 
	 * @param type the main metadata type(ie. Dataset )
	 */
	public void inserMainType(){
		this.outerDiv.attr("itemscope itemtype", "http://schema.org/" + this.MAIN_TYPE);
	}

	/**
	 * Inserts author property
	 */
	public void insertAuthorProp(){
		this.authorAttr.attr("itemprop", this.AUTHOR_PROP);
	}
	
	
	/**
	 * Inserts contributor/collabrator property
	 */
	public void insertCollabratorsProp(){
		for(Element e: this.collaborators){
			e.attr("itemprop", this.CONTRIBUTOR_PROP);
		}
	}
	
	/**
	 * Inserts created date property
	 */
	public void insertCreatedDateProp(){
		this.createdAttr.attr("itemprop", this.CREATED_PROP);
	}
	
	/**
	 * Inserts license property
	 */
	public void insertLicense(){
		this.licenseAttr.attr("itemprop", this.LICENSE);
	}
	
	/**
	 * Inserts citation property
	 */
	public void insertCitation(){
		this.citeAttr.attr("itemprop", this.CITATION);
	}
	
	@Override
	public String toString(){
		return this.doc.toString();
	}
	
	
	public String getPageUrl() {
		return this.pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public Document getDoc() {
		return this.doc;
	}

	public void setDoc(Document doc) {
		this.doc = doc;
	}

	public Element getOuterDiv() {
		return this.outerDiv;
	}

	public void setOuterDiv(Element outerDiv) {
		this.outerDiv = outerDiv;
	}

	public Element getInnerDiv() {
		return this.innerDiv;
	}

	public void setInnerDiv(Element innerDiv) {
		this.innerDiv = innerDiv;
	}

	public Element getAuthorTag() {
		return this.authorTag;
	}

	public void setAuthorTag(Element authorTag) {
		this.authorTag = authorTag;
	}

	public Element getAuthorAttr() {
		return this.authorAttr;
	}

	public void setAuthorAttr(Element authorAttr) {
		this.authorAttr = authorAttr;
	}

	public Element getCollaboratorsTag() {
		return this.collaboratorsTag;
	}

	public void setCollaboratorsTag(Element collaboratorsTag) {
		this.collaboratorsTag = collaboratorsTag;
	}

	public Elements getCollaborators() {
		return this.collaborators;
	}

	public void setCollaborators(Elements collaborators) {
		this.collaborators = collaborators;
	}

	public Element getCreatedTag() {
		return this.createdTag;
	}

	public void setCreatedTag(Element createdTag) {
		this.createdTag = createdTag;
	}

	public Element getCreatedAttr() {
		return this.createdAttr;
	}

	public void setCreatedAttr(Element createdAttr) {
		this.createdAttr = createdAttr;
	}

	public Element getLicenseTag() {
		return this.licenseTag;
	}

	public void setLicenseTag(Element licenseTag) {
		this.licenseTag = licenseTag;
	}

	public Element getLicenseAttr() {
		return this.licenseAttr;
	}

	public void setLicenseAttr(Element licenseAttr) {
		this.licenseAttr = licenseAttr;
	}

	public Element getCiteTag() {
		return this.citeTag;
	}

	public void setCiteTag(Element citeTag) {
		this.citeTag = citeTag;
	}

	public Element getCiteAttr() {
		return this.citeAttr;
	}

	public void setCiteAttr(Element citeAttr) {
		this.citeAttr = citeAttr;
	}

	public static void main(String [] args) throws Exception{
		Page p = new Page("https://www.digitalrocksportal.org/projects/35/");
		System.out.println(p.toString());
		
	
	}

}
