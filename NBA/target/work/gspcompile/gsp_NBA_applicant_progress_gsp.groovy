
import org.nba.user.NbaUser


import org.nba.user.NbaRole

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicant_progress_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicant/_progress.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createClosureForHtmlPart(2, 1)
invokeTag('captureHead','sitemesh',11,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(3)
expressionOut.print(formDetails?.appNumber)
printHtmlPart(4)
invokeTag('set','g',25,['var':("counter"),'value':(1)],-1)
printHtmlPart(5)
if(true && (applicationList)) {
printHtmlPart(6)
loop:{
int i = 0
for( applicationListInstance in (applicationList) ) {
printHtmlPart(7)

def currentDesk = NbaUser?.findByUsername(applicationListInstance?.forwardMember)

printHtmlPart(8)
if(true && (currentDesk)) {
printHtmlPart(8)
expressionOut.print(currentDesk?.name)
printHtmlPart(9)
expressionOut.print(currentDesk?.nbaRole?.authority)
printHtmlPart(10)
}
else {
printHtmlPart(8)

def currentTable = NbaUser?.findByAnswer(applicationListInstance?.forwardMember)

printHtmlPart(8)
expressionOut.print(currentTable?.name)
printHtmlPart(9)
expressionOut.print(currentTable?.nbaRole?.authority)
printHtmlPart(10)
}
printHtmlPart(11)
expressionOut.print(applicationListInstance?.statusUpdate?:'NA')
printHtmlPart(12)
invokeTag('formatDate','g',53,['format':("dd/MM/yyyy"),'date':(applicationListInstance?.noteDate)],-1)
printHtmlPart(13)
if(true && (counter == 1)) {
printHtmlPart(14)
}
printHtmlPart(15)
invokeTag('set','g',58,['var':("counter"),'value':(counter + 1)],-1)
printHtmlPart(6)
i++
}
}
printHtmlPart(6)
}
else {
printHtmlPart(16)
}
printHtmlPart(17)
})
invokeTag('captureBody','sitemesh',68,[:],1)
printHtmlPart(18)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1649069907919L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
