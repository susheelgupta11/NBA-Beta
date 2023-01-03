import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formB_formBpart3_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formB/_formBpart3.gsp" }
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
if(true && (!entity1)) {
printHtmlPart(5)
}
else {
printHtmlPart(6)
if(true && (entity1?.contactDetailsOfInstOrOrganization == 'whoShallGuideOutsideIndia')) {
printHtmlPart(7)
}
else {
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (entity1?.contactDetailsOfInstOrOrganization == 'whoShallRcvTheBioResource')) {
printHtmlPart(10)
}
else {
printHtmlPart(11)
}
printHtmlPart(12)
}
printHtmlPart(13)
expressionOut.print(entity1?.name)
printHtmlPart(14)
expressionOut.print(entity1?.address1)
printHtmlPart(15)
expressionOut.print(entity1?.address2)
printHtmlPart(16)
expressionOut.print(entity1?.address3)
printHtmlPart(17)
invokeTag('select','g',140,['name':("countryId"),'from':(listOfCountries),'optionKey':("id"),'optionValue':("country"),'value':(entity1?.country1?.id),'class':("width ctlwidth"),'noSelection':(['':'-Select-']),'req1':("1")],-1)
printHtmlPart(18)
expressionOut.print(entity1?.state)
printHtmlPart(19)
expressionOut.print(entity1?.city)
printHtmlPart(20)
expressionOut.print(entity1?.pincode)
printHtmlPart(21)
expressionOut.print(entity1?.phone)
printHtmlPart(22)
expressionOut.print(entity1?.email)
printHtmlPart(23)
invokeTag('hiddenField','g',204,['name':("profileId"),'value':(entity1?.id)],-1)
printHtmlPart(24)
invokeTag('hiddenField','g',204,['name':("formType"),'value':(formType)],-1)
printHtmlPart(24)
invokeTag('hiddenField','g',207,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(24)
invokeTag('hiddenField','g',207,['name':("type"),'value':("institute")],-1)
printHtmlPart(24)
invokeTag('hiddenField','g',208,['name':("part"),'value':("part3")],-1)
printHtmlPart(24)
invokeTag('hiddenField','g',212,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(24)
invokeTag('actionSubmit','g',213,['action':("saveFormBEntity"),'class':("btn btn-primary  btnctrl"),'value':("Save")],-1)
printHtmlPart(25)
})
invokeTag('form','g',214,['name':("formBInstt"),'controller':("formB"),'class':("form-horizontal"),'role':("form"),'autocomplete':("off")],1)
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
