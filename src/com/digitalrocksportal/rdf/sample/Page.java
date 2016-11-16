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
public class Page {
	
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
	
	public static void main(String [] args) throws Exception{
		Page p = new Page("https://www.digitalrocksportal.org/projects/35/");
		
		
		/*
		//Adding the itemtype & itemscope
		e.attr("itemscope itemtype", "http://schema.org/Dataset");
		
	

		*/
	}

}
