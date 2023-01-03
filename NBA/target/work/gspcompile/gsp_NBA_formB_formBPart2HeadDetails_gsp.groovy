import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formB_formBPart2HeadDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formB/_formBPart2HeadDetails.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
expressionOut.print(entity2?.name)
printHtmlPart(2)
expressionOut.print(entity2?.supervisorDesignation)
printHtmlPart(3)
expressionOut.print(entity2?.headOfInstName)
printHtmlPart(4)
expressionOut.print(entity2?.headOfInstDesignation)
printHtmlPart(5)
expressionOut.print(entity2?.address1)
printHtmlPart(6)
expressionOut.print(entity2?.address2)
printHtmlPart(7)
expressionOut.print(entity2?.address3)
printHtmlPart(8)
invokeTag('select','g',115,['name':("state"),'from':(listOfStates?.state),'id':("state"),'req1':("1"),'class':("width controlreq"),'value':(entity2?.state),'noSelection':(['':'Select State'])],-1)
printHtmlPart(9)
expressionOut.print(entity2?.city)
printHtmlPart(10)
expressionOut.print(entity2?.pincode)
printHtmlPart(11)
expressionOut.print(entity2?.phone)
printHtmlPart(12)
expressionOut.print(entity2?.email)
printHtmlPart(13)
invokeTag('hiddenField','g',167,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(14)
invokeTag('hiddenField','g',167,['name':("type"),'value':("supervisor")],-1)
printHtmlPart(14)
invokeTag('hiddenField','g',168,['name':("part"),'value':("part2")],-1)
printHtmlPart(14)
invokeTag('hiddenField','g',169,['name':("formType"),'value':(formType)],-1)
printHtmlPart(15)
invokeTag('hiddenField','g',170,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(14)
invokeTag('actionSubmit','g',172,['action':("saveFormBEntity"),'class':("btn btn-primary  btncontrol"),'value':("Save")],-1)
printHtmlPart(16)
})
invokeTag('form','g',172,['name':("supervisorForm"),'class':("form-horizontal"),'role':("form"),'autocomplete':("off"),'controller':("formB")],1)
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
