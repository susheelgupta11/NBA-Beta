import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formB_formBpart2_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formB/_formBpart2.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
expressionOut.print(createLink(controller:'applicationManagement',action:'fetchMobileCode'))
printHtmlPart(2)
})
invokeTag('javascript','g',29,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
expressionOut.print(entity1?.name)
printHtmlPart(5)
expressionOut.print(entity1?.address1)
printHtmlPart(6)
expressionOut.print(entity1?.address2)
printHtmlPart(7)
expressionOut.print(entity1?.address3)
printHtmlPart(8)
invokeTag('select','g',95,['name':("state"),'from':(listOfStates?.state),'id':("state"),'req1':("1"),'class':("width controlclass1"),'value':(entity1?.state),'noSelection':(['':'Select State'])],-1)
printHtmlPart(9)
expressionOut.print(entity1?.city)
printHtmlPart(10)
expressionOut.print(entity1?.pincode)
printHtmlPart(11)
expressionOut.print(entity1?.phone)
printHtmlPart(12)
expressionOut.print(entity1?.fax)
printHtmlPart(13)
expressionOut.print(entity1?.email)
printHtmlPart(14)
invokeTag('hiddenField','g',158,['name':("profileId"),'value':(entity1?.id)],-1)
printHtmlPart(15)
invokeTag('hiddenField','g',159,['name':("formType"),'value':(formType)],-1)
printHtmlPart(15)
invokeTag('hiddenField','g',160,['name':("part"),'value':("part2")],-1)
printHtmlPart(15)
invokeTag('hiddenField','g',161,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(15)
invokeTag('hiddenField','g',162,['name':("type"),'value':("institute")],-1)
printHtmlPart(15)
invokeTag('hiddenField','g',163,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(15)
invokeTag('actionSubmit','g',164,['action':("saveFormBEntity"),'class':("btn btn-primary  btnctrl"),'value':("Save")],-1)
printHtmlPart(16)
})
invokeTag('form','g',165,['name':("formBInstt"),'controller':("formB"),'class':("form-horizontal"),'role':("form"),'autocomplete':("off")],1)
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
