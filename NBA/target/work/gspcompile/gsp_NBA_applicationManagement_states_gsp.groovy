import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagement_states_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/_states.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (formType=='FormB')) {
printHtmlPart(1)
if(true && (statesList)) {
printHtmlPart(2)
invokeTag('select','g',23,['name':("province"),'from':(statesList?.state),'class':(" stateddl width ctrolreqddl"),'value':(""),'noSelection':(['':'Select State'])],-1)
printHtmlPart(3)
}
else {
printHtmlPart(4)
expressionOut.print(individualProfile?.province)
printHtmlPart(5)
}
printHtmlPart(1)
}
printHtmlPart(1)
if(true && (formType=='FormC')) {
printHtmlPart(1)
if(true && (statesList)) {
printHtmlPart(1)
if(true && (part=='Part3')) {
printHtmlPart(6)
invokeTag('select','g',51,['name':("province"),'from':(statesList?.state),'class':(" stateddl width ctrolreqddl"),'value':(""),'noSelection':(['':'Select State'])],-1)
printHtmlPart(7)
}
else {
printHtmlPart(8)
invokeTag('select','g',63,['name':("province"),'from':(statesList?.state),'class':(" stateddl width ctrolreqddl"),'value':(""),'noSelection':(['':'Select State'])],-1)
printHtmlPart(7)
}
printHtmlPart(1)
}
else {
printHtmlPart(1)
if(true && (part=='Part3')) {
printHtmlPart(9)
}
else {
printHtmlPart(10)
}
printHtmlPart(1)
}
printHtmlPart(1)
}
printHtmlPart(1)
if(true && (formType!='FormB'&&formType!='FormC')) {
printHtmlPart(1)
if(true && (statesList)) {
printHtmlPart(11)
invokeTag('select','g',102,['name':("province"),'from':(statesList?.state),'class':(" stateddl width ctrolreqddl"),'value':(""),'noSelection':(['':'Select State'])],-1)
printHtmlPart(3)
}
else {
printHtmlPart(12)
expressionOut.print(individualProfile?.province)
printHtmlPart(5)
}
printHtmlPart(1)
}
printHtmlPart(13)
if(true && (listOfCountries)) {
printHtmlPart(13)
}
printHtmlPart(13)
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
