import com.asciibooks.*

class BootStrap {

    def init = { servletContext ->
    	def eric = new Author(name: "Eric", biography: "Grails Developer & Writer").save()
		def grails3Book = new Book(author: eric, title: "Practical Grails 3", price: 100).save()
    }
    def destroy = {
    }
}
