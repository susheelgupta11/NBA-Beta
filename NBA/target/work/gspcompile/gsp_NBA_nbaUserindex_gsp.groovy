import org.nba.user.NbaUser
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_nbaUserindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/nbaUser/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("superAdmin")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',20,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
if(true && (message)) {
printHtmlPart(6)
expressionOut.print(message)
printHtmlPart(7)
}
printHtmlPart(8)
loop:{
int i = 0
for( nbaUserInstance in (nbaUserInstanceList) ) {
printHtmlPart(9)
expressionOut.print(i+1)
printHtmlPart(10)
expressionOut.print(nbaUserInstance?.name)
printHtmlPart(11)
if(true && (nbaUserInstance?.accountLocked == false)) {
printHtmlPart(12)
expressionOut.print(nbaUserInstance?.username)
printHtmlPart(11)
}
else {
printHtmlPart(13)
}
printHtmlPart(12)
expressionOut.print(nbaUserInstance?.nbaRole?.authority?: 'Not Assign')
printHtmlPart(14)
if(true && (nbaUserInstance?.accountLocked == true)) {
printHtmlPart(15)
}
else if(true && (nbaUserInstance?.accountLocked == false)) {
printHtmlPart(16)
}
printHtmlPart(17)
invokeTag('formatDate','g',71,['format':("dd-MM-yyyy"),'date':(nbaUserInstance?.dtCreated)],-1)
printHtmlPart(18)
createClosureForHtmlPart(19, 3)
invokeTag('link','g',75,['action':("edit"),'params':([id:nbaUserInstance?.id,csrfPreventionSalt:csrfPreventionSalt])],3)
printHtmlPart(20)
if(true && (nbaUserInstance?.accountLocked == false)) {
printHtmlPart(21)
createClosureForHtmlPart(22, 4)
invokeTag('link','g',78,['action':("changeUser"),'params':([id:nbaUserInstance?.id,status:'deactivate',csrfPreventionSalt:csrfPreventionSalt]),'onclick':("return confirm('Are you sure to deactivate?');")],4)
printHtmlPart(23)
}
else {
printHtmlPart(24)
createClosureForHtmlPart(25, 4)
invokeTag('link','g',81,['action':("changeUser"),'params':([id:nbaUserInstance?.id,status:'activate',csrfPreventionSalt:csrfPreventionSalt]),'onclick':("return confirm('Are you sure to activate?');")],4)
printHtmlPart(23)
}
printHtmlPart(26)
i++
}
}
printHtmlPart(27)
})
invokeTag('captureBody','sitemesh',81,[:],1)
printHtmlPart(28)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1668753646789L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
