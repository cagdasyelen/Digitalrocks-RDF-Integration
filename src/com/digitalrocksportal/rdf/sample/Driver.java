package com.digitalrocksportal.rdf.sample;

public class Driver {
	public static void main(String [] args){
		Metadata m = new Metadata();
		m.getRDFModel().write(System.out);
	}
}
