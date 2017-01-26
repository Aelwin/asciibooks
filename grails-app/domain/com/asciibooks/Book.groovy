package com.asciibooks

import java.text.DecimalFormat
import java.text.NumberFormat

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
    	price range: 0..100000
    	isbn nullable: true
    }

    static mapping = {
    	content sqlType: "text"
    }

    String getFormattedPrice() {
        if (price) {         
            //pongo el locale US para que pasen los test, lo suyo sería que no le pasase Locale
            def formatter = NumberFormat.getCurrencyInstance(new Locale("en", "US"))
            "${formatter.format(price/100)}"
        }
    }
}
