package com.asciibooks

class Address {

	String street
	String street2
	String city
	String state
	String country
	String zipCode
	Long latitude
	Long longitude

    static constraints = {
    	street nullable: true
    	street2 nullable: true
    	city nullable: true
    	state nullable: true
    	country nullable: true
    	zipCode nullable: true
		latitude nullable: true
    	longitude nullable: true
    }

    String toString() {
    	(street ?: '') + (street2 ?: '') + ' ' + (city ?: '') + ' ' + (state ?: '') + (zipCode ? ", $zipCode" :  '')        
    }
}
