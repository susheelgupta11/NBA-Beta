
import org.nba.user.NbaUser

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_loggedInAslinkOfficerList_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loggedInAs/linkOfficerList.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("superAdmin")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',16,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createClosureForHtmlPart(6, 2)
invokeTag('link','g',20,['controller':("loggedInAs"),'action':("linkOfficer"),'class':("btn btn-primary pull-right"),'style':("margin-bottom: 5px;")],2)
printHtmlPart(7)
if(true && (message)) {
printHtmlPart(8)
expressionOut.print(message)
printHtmlPart(9)
}
printHtmlPart(10)
loop:{
int i = 0
for( userlist in (linkOfficerInstance) ) {
printHtmlPart(11)
expressionOut.print(i+1)
printHtmlPart(12)
expressionOut.print(userlist?.nbaUserFrom?.name)
printHtmlPart(12)
expressionOut.print(userlist?.nbaUserTo?.name)
printHtmlPart(13)
if(true && (userlist?.status == true)) {
printHtmlPart(14)
}
else if(true && (userlist?.status == false)) {
printHtmlPart(15)
}
else if(true && (userlist?.status == '' || null == userlist?.status)) {
printHtmlPart(16)
}
printHtmlPart(17)
createClosureForHtmlPart(18, 3)
invokeTag('link','g',51,['action':("editLinkOfficer"),'params':([editId:userlist?.id])],3)
printHtmlPart(19)
createClosureForHtmlPart(20, 3)
invokeTag('link','g',52,['action':("deleteOfficer"),'params':([deleteId:userlist?.id]),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],3)
printHtmlPart(21)
i++
}
}
printHtmlPart(22)
})
invokeTag('captureBody','sitemesh',63,['class':("hold-transition skin-blue sidebar-mini")],1)
printHtmlPart(23)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1597739172000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
