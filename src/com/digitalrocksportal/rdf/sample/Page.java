package com.digitalrocksportal.rdf.sample;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import org.jsoup.Jsoup;

public class Page {
	
	public static void main(String [] args) throws Exception{
		Document doc = Jsoup.connect("https://www.digitalrocksportal.org/projects/35/").get();
		Elements elems =  doc.select("div:contains(Author)");
		
		int size = elems.size();
		Element e = elems.get(size  - 2);
		
		
		//Adding the itemtype & itemscope
		e.attr("itemscope itemtype", "http://schema.org/Dataset");
		
		System.out.println(e);
		
	}

}
