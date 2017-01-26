package com.asciibooks

import grails.test.mixin.TestFor
import grails.buildtestdata.mixin.Build
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Author)
@Build([Author, Book])
class AuthorSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    @Unroll
	def "check constraints for #field with value #val has error #error"() {		
		when:
			def author = new Author("${field}": val)
			author.validate()
		
		then:
			if (author.errors["${field}"]) {				
				author.errors["${field}"].code == error
			} else {				
				assert !error
			}
			
		
		where:			
			field				|	val			||	error
			"name"				|	null		||	"nullable"
			"penName"			|	null		||	false
			"address"			|	null		||	false
	}

	@Unroll
	void "DisplayName is correct"() {
	    given:
	    	def author = new Author(name: name, penName: penName)

	    expect:
	    	author.displayName == displayName

	    where:
		    name    | penName   | displayName
		    "Eric"  | "Author"  | "Author"
		    "Eric"  | null      | "Eric"
	}

	void "is active by default"() {
	    given:
	    	def author = new Author()

	    expect:
	    	author.active 
	}

	void "getBooks"() {
	    given: "An author with one book"
	    	def author = Author.build() 
	    	Book.build(author: author)  	    	

	    and: "another unrelated book"
	    	def anotherAuthor = Author.build() 
	    	Book.build(author: anotherAuthor)     

	    expect: "Author.books to return one book."
	    	author.books.size() == 1      
	}

}
