import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formB_formBPart3HeadDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formB/_formBPart3HeadDetails.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
if(true && (!entity2)) {
printHtmlPart(2)
}
else {
printHtmlPart(3)
if(true && (entity2?.category == 'contactDetails1')) {
printHtmlPart(4)
}
else {
printHtmlPart(5)
}
printHtmlPart(3)
if(true && (entity2?.category == 'contactDetails2')) {
printHtmlPart(6)
}
else {
printHtmlPart(7)
}
printHtmlPart(3)
if(true && (entity2?.category == 'contactDetails3')) {
printHtmlPart(8)
}
else {
printHtmlPart(9)
}
printHtmlPart(10)
}
printHtmlPart(11)
expressionOut.print(entity2?.name)
printHtmlPart(12)
expressionOut.print(entity2?.address1)
printHtmlPart(13)
expressionOut.print(entity2?.address2)
printHtmlPart(14)
expressionOut.print(entity2?.address3)
printHtmlPart(15)
invokeTag('select','g',118,['name':("countryId"),'from':(listOfCountries),'optionKey':("id"),'optionValue':("country"),'value':(entity2?.country1?.id),'class':("width controlreq"),'noSelection':(['':'-Select-']),'req1':("1")],-1)
printHtmlPart(16)
expressionOut.print(entity2?.state)
printHtmlPart(17)
expressionOut.print(entity2?.city)
printHtmlPart(18)
expressionOut.print(entity2?.pincode)
printHtmlPart(19)
expressionOut.print(entity2?.mobile)
printHtmlPart(20)
expressionOut.print(entity2?.phone)
printHtmlPart(21)
expressionOut.print(entity2?.email)
printHtmlPart(22)
if(true && (entity2?.addressproofLetter)) {
printHtmlPart(23)
invokeTag('select','g',182,['id':("foucuscontrol"),'name':("addressproofSelect"),'class':("width controlreq addressproofSelect"),'req1':("1"),'value':(entity2?.addressproofSelect),'from':(recipientAddressProof)],-1)
printHtmlPart(24)
expressionOut.print(entity2?.addressproofNo)
printHtmlPart(25)
expressionOut.print(entity2?.addressproofLetter)
printHtmlPart(26)
createTagBody(3, {->
printHtmlPart(27)
expressionOut.print(entity2?.addressproofLetterFileName)
printHtmlPart(28)
})
invokeTag('link','g',200,['controller':("formB"),'action':("showUndertakingFile"),'id':(entity2?.id),'target':("_blank"),'params':([filename: "addressproofLetter",appFormId:"${appForm?.id}",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(29)
}
else {
printHtmlPart(30)
invokeTag('select','g',205,['id':("foucuscontrol"),'name':("addressproofSelect"),'req1':("1"),'class':("width controlreq addressproofSelect"),'value':(""),'from':(recipientAddressProof)],-1)
printHtmlPart(31)
}
printHtmlPart(32)
invokeTag('hiddenField','g',222,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(33)
invokeTag('hiddenField','g',224,['name':("type"),'value':("supervisor")],-1)
printHtmlPart(33)
invokeTag('hiddenField','g',225,['name':("part"),'value':("part3")],-1)
printHtmlPart(33)
invokeTag('hiddenField','g',228,['name':("formType"),'value':(formType)],-1)
printHtmlPart(34)
invokeTag('hiddenField','g',232,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(33)
invokeTag('actionSubmit','g',235,['action':("saveFormBEntity"),'class':("btn btn-primary  btncontrol"),'value':("Save")],-1)
printHtmlPart(35)
})
invokeTag('uploadForm','g',235,['name':("fundindAgencyForm"),'class':("form-horizontal"),'role':("form"),'autocomplete':("off"),'controller':("formB")],1)
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
