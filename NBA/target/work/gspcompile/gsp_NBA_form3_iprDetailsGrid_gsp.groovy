
import org.nba.common.Country

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_form3_iprDetailsGrid_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/form3/_iprDetailsGrid.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (listOfIprDetails)) {
printHtmlPart(1)

i=1

printHtmlPart(2)
for( ipr in (listOfIprDetails) ) {
printHtmlPart(3)
out.print(i)
printHtmlPart(4)

i++

printHtmlPart(5)
expressionOut.print(Country.get(ipr?.country)?.country)
printHtmlPart(6)
expressionOut.print(ipr?.patentApplicationNo)
printHtmlPart(6)
expressionOut.print(ipr?.patentApplicationDate?.format('dd/MM/yyyy'))
printHtmlPart(6)
expressionOut.print(ipr?.status)
printHtmlPart(6)
expressionOut.print(ipr?.patentNo)
printHtmlPart(7)
expressionOut.print(ipr?.patentDate?.format('dd/MM/yyyy'))
printHtmlPart(8)
if(true && (ipr?.status?.contains('-'))) {
printHtmlPart(9)
}
else if(true && (!ipr?.status?.contains('-'))) {
printHtmlPart(10)
expressionOut.print(ipr?.reasons)
printHtmlPart(11)
}
else {
printHtmlPart(12)
}
printHtmlPart(13)
createClosureForHtmlPart(14, 3)
invokeTag('remoteLink','g',54,['controller':("form3"),'action':("part2"),'onSuccess':("showStatusForForm3Part2(null,'${ipr?.status}')"),'params':([iprId:ipr?.id,formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]),'update':("iprDetailForm")],3)
printHtmlPart(15)
createClosureForHtmlPart(16, 3)
invokeTag('remoteLink','g',59,['controller':("form3"),'action':("deleteIprDetails"),'update':("updateIprDetails"),'params':([iprId:ipr?.id,formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]),'onSuccess':("form3Part2()")],3)
printHtmlPart(17)
}
printHtmlPart(18)
}
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1537268164000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
