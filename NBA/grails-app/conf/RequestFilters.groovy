
class RequestFilters{
	def filters = {
		requestHeadersFilter(controller: '*', action: '*') {
			after = {
				response.setHeader("Pragma", "no-cache")
				response.setDateHeader("Expires", 1L)
				response.setHeader("Cache-Control", "no-cache")
				response.addHeader("Cache-Control", "no-store")
// Below lines are added and commented by Susheel Gupta				
 //                 response.setHeader("Set-Cookie", "key=value; HttpOnly; SameSite=strict")
    //				response.setHeader("Content-Security-Policy","default-src https: http:; script-src 'self' 'unsafe-inline' 'unsafe-eval' https: http:; style-src http: https: 'unsafe-inline'; img-src 'self' data: https:; connect-src http: https: ws:;");
                   response.setHeader("Strict-Transport-Security", "max-age=7776000; includeSubdomains")
				   response.setHeader("x-content-type-options", "nosniff")
			       response.setHeader("Referrer-Policy", "no-referrer-when-downgrade")
//				response.setheader("X-xss protection",1L)
				}
		}
	 }
}
