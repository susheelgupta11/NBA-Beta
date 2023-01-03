package org.nba.phse2

class HtmlTagLib {

	def saySomething = {attrs, body ->
		if (attrs.tone == 'loud')
			out << body().toUpperCase()
		else if (attrs.tone == 'quiet')
			out << body().toLowerCase()
		else
			out << body()
	}
}


// for the gsp page

//<g:saySomething tone='loud'>
//I'm shouting now!
//</g:saySomething>