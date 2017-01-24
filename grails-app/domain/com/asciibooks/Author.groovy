package com.asciibooks

class Author {

    String name
	String penName
	Boolean active = true
	Address Address
	Date lastUpdated
	Date dateCreated

	static hasMany = [books: Book]

    static constraints = {
    	penName nullable: true
    }

    String getDisplayName() {
    	penName ?: name
    }
}
