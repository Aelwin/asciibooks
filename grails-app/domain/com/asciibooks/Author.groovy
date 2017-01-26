package com.asciibooks

class Author {

    String name
	String penName
	Boolean active = true
	Address address
	Date lastUpdated
	Date dateCreated

	static hasMany = [books: Book]

    static constraints = {
    	penName nullable: true
        address nullable: true
    }

    String getDisplayName() {
    	penName ?: name
    }

    /*def getBooks() {
        Book.findAllByAuthor(this)
    }*/
}
