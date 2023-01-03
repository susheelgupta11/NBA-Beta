import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_form4_thirdPartyGrid_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/form4/_thirdPartyGrid.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)

int i=1

printHtmlPart(1)
for( thirdParty in (listOfThirdParty) ) {
printHtmlPart(2)
out.print(i)
printHtmlPart(3)

i++

printHtmlPart(4)
expressionOut.print(thirdParty?.name)
printHtmlPart(5)
expressionOut.print(thirdParty?.addressForComm)
printHtmlPart(5)
expressionOut.print(thirdParty?.state)
printHtmlPart(5)
expressionOut.print(thirdParty?.pincode)
printHtmlPart(5)
expressionOut.print(thirdParty?.country)
printHtmlPart(5)
expressionOut.print(thirdParty?.phone)
printHtmlPart(5)
expressionOut.print(thirdParty?.fax)
printHtmlPart(5)
expressionOut.print(thirdParty?.website)
printHtmlPart(5)
expressionOut.print(thirdParty?.email)
printHtmlPart(6)
createClosureForHtmlPart(7, 2)
invokeTag('link','g',55,['controller':("form4"),'action':("part3"),'params':([thirdPartyInstId:thirdParty?.id,formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(8)
createClosureForHtmlPart(9, 2)
invokeTag('remoteLink','g',60,['controller':("form4"),'action':("deleteThirdParty"),'update':("thirdPartyGrid"),'params':([thirdPartyInstId:thirdParty?.id,formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(10)
}
printHtmlPart(11)
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
