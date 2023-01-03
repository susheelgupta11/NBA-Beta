import grails.plugin.springsecurity.SpringSecurityService;

class UrlMappings {
	
		static mappings = {
			"/$controller/$action?/$id?(.$format)?"{
				constraints {
					
					
					// apply constraints here
				}
			}

			"/"(controller:"login")
			"/500"(view:'/internalError')
			"404"(view:'/error')
			"404"(view: "/errors/forbidden")
			
			"/login/$action?"(controller: "login")
			"/logout/$action?"(controller: "logout")
		}
	}
	