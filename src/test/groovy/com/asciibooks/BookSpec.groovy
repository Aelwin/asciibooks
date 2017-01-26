package com.asciibooks

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Book)
class BookSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

	@Unroll
	def "check constraints for #field with value #val has error #error"() {		
		when:
			def book = new Book("${field}": val)
			book.validate()
		
		then:
			if (book.errors["${field}"]) {				
				book.errors["${field}"].code == error
			} else {				
				assert !error
			}
			
		
		where:			
			field				|	val			||	error
			"title"				|	null		||	"nullable"
			"title"				|	""			||	false
			"isbn"				|	null		||	false
			"content"			|	null		||	false
			"description"		|	null		||	false
			"description"		|	"a"*5001	||	"size.toobig"
			"price"				|	-1			||	"range.toosmall"
			"price"				|	1000000		||	"range.toobig"
			"price"				|	null		||	"nullable"
			"price"				|	59			||	false

	}

	@Unroll
	void "Test Book.getFormattedPrice() Cents: #price Formatted: #formatted"() {
	    given:
	    	def book = new Book(price: price)

	    expect:	    	
	    	book.formattedPrice == formatted

	    where:
		    price || formatted
		    1     || '$0.01'
		    100   || '$1.00'
		    110   || '$1.10'
		    111   || '$1.11'
	}


}
