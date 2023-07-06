package com.rest.api.get;

public class test {

	public static void main(String[] args) {

		String url = "https://google.com/authorize?redirect_uri=https://facebook.com&id=hdhfdfhdjfhdfhui9494&scope=test%test%test&state=hjsdfdfgdefvdyfdhd";
		
		System.out.println(url.substring(url.indexOf("&id")+4));
		
		System.out.println(url.substring(url.indexOf("redirect_uri")+"redirect_uri".length()+1, url.indexOf("&id")));
		
		
	}

}
