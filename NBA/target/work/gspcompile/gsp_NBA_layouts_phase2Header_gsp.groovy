
import org.nba.user.NbaUser


import org.nba.user.NbaUserNbaRole


import org.nba.user.NbaRole


import org.nba.user.LinkOfficer


import org.nba.user.RoleEnum


import org.nba.application.ApplicationForm1

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_layouts_phase2Header_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/_phase2Header.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
invokeTag('set','g',8,['var':("headerDetails"),'value':(formDetails)],-1)
printHtmlPart(1)
if(true && (headerDetails)) {
printHtmlPart(2)
createClosureForHtmlPart(3, 2)
invokeTag('javascript','g',18,[:],2)
printHtmlPart(0)
}
printHtmlPart(4)
createClosureForHtmlPart(5, 1)
invokeTag('link','g',33,['controller':("loggedInAs"),'action':("inbox"),'params':([])],1)
printHtmlPart(6)
createClosureForHtmlPart(7, 1)
invokeTag('link','g',35,['controller':("logout"),'params':([csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(8)
invokeTag('set','g',41,['var':("userObject"),'value':(NbaUser?.findByUsername(sec.loggedInUserInfo(field:'username')))],-1)
printHtmlPart(9)
invokeTag('set','g',42,['var':("getNbaRole"),'value':(userObject?.nbaRole)],-1)
printHtmlPart(10)
invokeTag('set','g',43,['var':("getRoleDetails"),'value':(NbaRole.get(getNbaRole?.id))],-1)
printHtmlPart(10)
invokeTag('set','g',44,['var':("getAuthority"),'value':(getRoleDetails?.authority)],-1)
printHtmlPart(11)
invokeTag('set','g',45,['var':("linkDetails"),'value':(LinkOfficer.findByNbaUserTo(userObject))],-1)
printHtmlPart(9)
invokeTag('set','g',47,['var':("chkStatus"),'value':(linkDetails?.status)],-1)
printHtmlPart(12)
expressionOut.print(resource(dir: 'images', file: 'Logo1.jpg'))
printHtmlPart(13)
createTagBody(1, {->
printHtmlPart(14)
expressionOut.print(userObject?.name)
printHtmlPart(15)
expressionOut.print(getAuthority)
printHtmlPart(16)
})
invokeTag('ifLoggedIn','sec',60,[:],1)
printHtmlPart(17)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1579684206000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
