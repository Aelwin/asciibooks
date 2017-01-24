package com.asciibooks

class Book {

	String title
	String isbn
	String content
	String description
	Integer price
	Boolean published = false

	static belongsTo = [author: Author]

    static constraints = {
    	content nullable: true
    	description size: 1..5000, nullable: true
    	price range 0..100000
    	isbn nullable: true
    }

    static mapping = {
    	content sqlType: "text"
    }
}
