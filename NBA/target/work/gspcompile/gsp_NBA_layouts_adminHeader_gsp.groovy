
import org.nba.user.NbaUser


import org.nba.user.NbaUserNbaRole


import org.nba.user.NbaRole


import org.nba.user.RoleEnum

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_layouts_adminHeader_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/_adminHeader.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(0)
invokeTag('set','g',6,['var':("getRole"),'value':("ADMIN")],-1)
printHtmlPart(0)
})
invokeTag('ifAnyGranted','sec',7,['roles':("ADMIN")],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(0)
invokeTag('set','g',10,['var':("getApplicant"),'value':("APPLICANT")],-1)
printHtmlPart(0)
})
invokeTag('ifAnyGranted','sec',11,['roles':("APPLICANT")],1)
printHtmlPart(2)
createClosureForHtmlPart(3, 1)
invokeTag('link','g',19,['controller':("loggedInAs"),'action':("inbox"),'params':([csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(4)
if(true && (getApplicant == 'APPLICANT')) {
printHtmlPart(5)
createClosureForHtmlPart(6, 2)
invokeTag('link','g',21,['controller':("register"),'action':("userDetail")],2)
printHtmlPart(7)
createClosureForHtmlPart(8, 2)
invokeTag('link','g',22,['controller':("register"),'action':("changePassword")],2)
printHtmlPart(4)
}
printHtmlPart(9)
if(true && (getRole == 'ADMIN')) {
printHtmlPart(10)
createClosureForHtmlPart(11, 2)
invokeTag('link','g',27,['controller':("manageContent"),'action':("adminEdits"),'params':([csrfPreventionSalt:"${csrfPreventionSalt}", menu1:"aboutNBA"])],2)
printHtmlPart(4)
}
printHtmlPart(12)
createClosureForHtmlPart(13, 1)
invokeTag('link','g',30,['controller':("logout"),'params':([csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(14)
expressionOut.print(resource(dir: 'images', file: 'Logo1.jpg'))
printHtmlPart(15)
createTagBody(1, {->
printHtmlPart(16)
invokeTag('username','sec',39,[:],-1)
printHtmlPart(17)
})
invokeTag('ifLoggedIn','sec',40,[:],1)
printHtmlPart(18)
invokeTag('set','g',70,['var':("userObject"),'value':(NbaUserNbaRole.findByNbaRoleAndNbaUser(NbaRole.findByAuthority(RoleEnum?.Role?.ADMIN),NbaUser.findByUsername(sec.loggedInUserInfo(field:'username')))?.nbaRole?.authority)],-1)
printHtmlPart(19)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1651300079604L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
