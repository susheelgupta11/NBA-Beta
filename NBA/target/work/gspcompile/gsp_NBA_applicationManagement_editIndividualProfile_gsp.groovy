
import org.nba.application.IndividualProfile

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagement_editIndividualProfile_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/_editIndividualProfile.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(2)
invokeTag('select','g',25,['id':("foucuscontrol"),'name':("title"),'req1':("1"),'class':("width controlclass1"),'value':(individualProfile?.title),'from':(IndividualProfile.TitleName.values()),'noSelection':(['':'-Select title-'])],-1)
printHtmlPart(3)
expressionOut.print(individualProfile?.firstName)
printHtmlPart(4)
expressionOut.print(individualProfile?.middleName)
printHtmlPart(5)
expressionOut.print(individualProfile?.lastName)
printHtmlPart(6)
invokeTag('select','g',74,['from':(nationality),'class':("width"),'name':("nationality"),'id':("nationality"),'value':(individualProfile?.nationality)],-1)
printHtmlPart(7)
if(true && ("")) {
printHtmlPart(8)
}
printHtmlPart(9)
expressionOut.print(individualProfile?.address1)
printHtmlPart(10)
expressionOut.print(individualProfile?.address2)
printHtmlPart(11)
expressionOut.print(individualProfile?.address3)
printHtmlPart(12)
invokeTag('select','g',142,['name':("countryId"),'from':(listOfCountries),'optionKey':("id"),'optionValue':("country"),'id':("country"),'value':(individualProfile?.country?.id),'class':("width  country"),'noSelection':(['':'-Select-']),'onchange':(remoteFunction (controller: 'applicationManagement',action: 'fetchStates',
							params: "'countryId=' + this.value",update: 'updateStates'))],-1)
printHtmlPart(13)
expressionOut.print(individualProfile?.city)
printHtmlPart(14)
expressionOut.print(individualProfile?.pincode)
printHtmlPart(15)
expressionOut.print(individualProfile?.mobile)
printHtmlPart(16)
expressionOut.print(individualProfile?.phone)
printHtmlPart(17)
expressionOut.print(individualProfile?.email)
printHtmlPart(18)
if(true && (individualProfile?.idProof)) {
printHtmlPart(19)
createTagBody(3, {->
printHtmlPart(20)
expressionOut.print(individualProfile?.idProofFileName)
printHtmlPart(19)
})
invokeTag('link','g',231,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(individualProfile?.id),'target':("_blank"),'params':([filename: 'idProof', dataName: 'idProof',csrfPreventionSalt:'${csrfPreventionSalt}'])],3)
printHtmlPart(21)
}
else {
printHtmlPart(22)
}
printHtmlPart(23)
if(true && (individualProfile?.passportCopy)) {
printHtmlPart(24)
createTagBody(3, {->
printHtmlPart(20)
expressionOut.print(individualProfile?.passportCopyFileName)
printHtmlPart(19)
})
invokeTag('link','g',258,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(individualProfile?.id),'target':("_blank"),'params':([filename: 'passportCopy', dataName: 'passportCopy',csrfPreventionSalt:'${csrfPreventionSalt}'])],3)
printHtmlPart(25)
}
else {
printHtmlPart(26)
}
printHtmlPart(27)
if(true && (individualProfile?.authorizationLetter)) {
printHtmlPart(28)
createTagBody(3, {->
printHtmlPart(20)
expressionOut.print(individualProfile?.authorizationLetterFileName)
printHtmlPart(19)
})
invokeTag('link','g',284,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(individualProfile?.id),'target':("_blank"),'params':([filename: 'authorizationLetter', dataName: 'authorizationLetter',csrfPreventionSalt:'${csrfPreventionSalt}'])],3)
printHtmlPart(25)
}
else {
printHtmlPart(29)
}
printHtmlPart(30)
expressionOut.print(individualProfile?.profile)
printHtmlPart(31)
invokeTag('hiddenField','g',332,['name':("profileId"),'value':(individualProfile?.id)],-1)
printHtmlPart(32)
invokeTag('hiddenField','g',333,['name':("formType"),'value':(formType)],-1)
printHtmlPart(33)
})
invokeTag('uploadForm','g',1,['class':("form-horizontal"),'role':("form"),'autocomplete':("off"),'action':("saveEditedIndividualProfile")],1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1650527026699L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
