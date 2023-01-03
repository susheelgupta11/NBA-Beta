
import org.nba.application.IndianResearcher

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formA_formAUndertaking_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formA/_formAUndertaking.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(2)
if(true && (appFormId?.conditionOfAbs == true)) {
printHtmlPart(3)
}
else {
printHtmlPart(4)
}
printHtmlPart(5)
if(true && (appFormId?.approvalOfNba == true)) {
printHtmlPart(6)
}
else {
printHtmlPart(7)
}
printHtmlPart(5)
if(true && (appFormId?.recordsWithTheNba == true)) {
printHtmlPart(8)
}
else {
printHtmlPart(8)
}
printHtmlPart(5)
if(true && (appFormId?.infromationTrue == true)) {
printHtmlPart(9)
}
else {
printHtmlPart(9)
}
printHtmlPart(10)
invokeTag('hiddenField','g',50,['name':("formType"),'value':(formType)],-1)
printHtmlPart(11)
invokeTag('hiddenField','g',51,['name':("appFormId"),'value':(appFormId?.id)],-1)
printHtmlPart(12)
})
invokeTag('uploadForm','g',55,['class':("form-horizontal"),'role':("form"),'autocomplete':("off"),'action':("submitFormAUnderTaking")],1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1537268166000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
