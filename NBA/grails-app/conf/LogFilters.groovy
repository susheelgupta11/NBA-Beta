import org.nba.user.NbaUser


class LogFilters {

	def filters = {

		all(controller: '*', action: '*') {
			before = {
				println params

				if (session.SPRING_SECURITY_CONTEXT?.authentication?.principal?.username != null) {

					NbaUser user = NbaUser.findByUsername(session.SPRING_SECURITY_CONTEXT?.authentication?.principal?.username)
					if (user) {
						if (session["user"] == null) {
							session["user"] = user
							session.setMaxInactiveInterval(1800);
							session['loginDate'] = Calendar.getInstance().getTime()
							
						}
					} else {
						response.sendRedirect(request.getContextPath() + "/login/auth")
						return false
					}

				} else {

					if (params.controller == "formPreview" && params.action == "previewForm4Info")
						println "FORM PREVIEW................1"


					if (params.controller != "login" && params.controller != "assets" && params.controller != "simpleCaptcha" && params.controller != "register" && params.controller != "masterData" ||
							params.controller == "manageContent" && (params?.action == "adminEdits" || params?.action == "latestUpdates" || params?.action == "instructionToApplicant" || params?.action == "faqs")) {
						println "FORM PREVIEW................2"
						response.sendRedirect(request.getContextPath() + "/login/auth")
						flash.message = "Sorry! Session has expired"
						return false
					}

				}


			}
			after = { Map model ->

			}
			afterView = { Exception e ->

			}
		}
	}
}
