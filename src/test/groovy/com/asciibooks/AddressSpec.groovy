package com.asciibooks

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Address)
class AddressSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }


    void "toString() does not contain the string null"() {
	    given: "An address with all null properties"
	    	Address address = new Address()	    	

	    expect: "The toString to not contain the word null"
	    	address.toString().contains("null") == false
	}
}
