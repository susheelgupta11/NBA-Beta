
import org.nba.user.NbaUserNbaRole


import org.nba.user.NbaRole


import org.nba.user.NbaUser


import org.nba.user.RoleEnum

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_common_applicationTabs_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/common/_applicationTabs.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)

session.setAttribute("csrfPreventionSalt",csrfPreventionSalt)

printHtmlPart(2)
createClosureForHtmlPart(3, 1)
invokeTag('link','g',23,['controller':("loggedInAs"),'action':("inbox"),'class':("active"),'params':([])],1)
printHtmlPart(4)
invokeTag('set','g',27,['var':("userObject"),'value':(NbaUserNbaRole.findByNbaRoleAndNbaUser(NbaRole.findByAuthority(RoleEnum?.Role?.ADMIN),NbaUser.findByUsername(sec.loggedInUserInfo(field:'username')))?.nbaRole?.authority)],-1)
printHtmlPart(5)
if(true && (userObject != 'ADMIN')) {
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
expressionOut.print(aboutNBA)
printHtmlPart(8)
})
invokeTag('link','g',32,['controller':("loggedInAs"),'action':("decideForm"),'params':([])],2)
printHtmlPart(9)
}
printHtmlPart(10)
createClosureForHtmlPart(11, 1)
invokeTag('link','g',37,['controller':("loggedInAs"),'action':("notifications"),'params':([])],1)
printHtmlPart(12)
if(true && (userObject == 'ADMIN')) {
printHtmlPart(13)
createClosureForHtmlPart(14, 2)
invokeTag('link','g',39,['controller':("manageContent"),'action':("adminEdits"),'params':([csrfPreventionSalt:"", menu1:"aboutNBA"])],2)
printHtmlPart(15)
}
printHtmlPart(16)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1545301750000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
