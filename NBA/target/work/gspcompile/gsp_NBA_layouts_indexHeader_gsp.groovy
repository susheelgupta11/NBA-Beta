
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

class gsp_NBA_layouts_indexHeader_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/_indexHeader.gsp" }
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
invokeTag('link','g',26,['controller':("dashboard"),'action':("dashboard"),'params':([csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(6)
createClosureForHtmlPart(7, 1)
invokeTag('link','g',28,['controller':("logout"),'params':([csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(8)
invokeTag('set','g',35,['var':("userObject"),'value':(NbaUser.findByUsername(sec.loggedInUserInfo(field:'username')))],-1)
printHtmlPart(9)
invokeTag('set','g',36,['var':("getAuthority"),'value':(userObject?.nbaRole?.authority)],-1)
printHtmlPart(10)
invokeTag('set','g',39,['var':("linkDetails"),'value':(LinkOfficer.findByNbaUserTo(userObject))],-1)
printHtmlPart(11)
invokeTag('set','g',39,['var':("chkStatus"),'value':(linkDetails?.status)],-1)
printHtmlPart(11)
invokeTag('set','g',40,['var':("tillTime"),'value':(" ${linkDetails?.toDate}")],-1)
printHtmlPart(12)
invokeTag('set','g',43,['var':("linkOfficerName"),'value':(" ${linkDetails?.nbaUserFrom?.answer}")],-1)
printHtmlPart(13)
invokeTag('set','g',44,['var':("linkRole"),'value':(linkDetails?.nbaUserFrom?.nbaRole)],-1)
printHtmlPart(14)
invokeTag('set','g',45,['var':("linkAuth"),'value':(linkRole?.authority)],-1)
printHtmlPart(15)
expressionOut.print(resource(dir: 'images', file: 'Logo1.jpg'))
printHtmlPart(16)
if(true && (linkOfficer == 'Yes')) {
printHtmlPart(17)
expressionOut.print(linkOfficerName)
printHtmlPart(18)
expressionOut.print(linkAuth)
printHtmlPart(19)
}
else {
printHtmlPart(20)
createTagBody(2, {->
printHtmlPart(21)
expressionOut.print(userObject?.name)
printHtmlPart(22)
expressionOut.print(getAuthority)
printHtmlPart(23)
})
invokeTag('ifLoggedIn','sec',62,[:],2)
printHtmlPart(24)
}
printHtmlPart(0)
if(true && (linkOfficer != 'Yes')) {
printHtmlPart(25)
if(true && (chkStatus != null)) {
printHtmlPart(26)
if(true && (chkStatus == true)) {
printHtmlPart(27)
createClosureForHtmlPart(28, 4)
invokeTag('link','g',75,['controller':("dashboard"),'action':("linkOfficerDashboard"),'params':([linkOfficer:'Yes'])],4)
printHtmlPart(29)
}
else if(true && (chkStatus == false)) {
printHtmlPart(30)
}
printHtmlPart(31)
}
printHtmlPart(0)
}
printHtmlPart(32)
expressionOut.print(tillTime)
printHtmlPart(33)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1646928523305L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
