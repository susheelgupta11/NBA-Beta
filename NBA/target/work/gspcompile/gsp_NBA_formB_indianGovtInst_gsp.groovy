import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formB_indianGovtInst_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formB/_indianGovtInst.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
expressionOut.print(indianGovtInst?.samePresentAddress)
printHtmlPart(2)
})
invokeTag('javascript','g',56,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(5)
expressionOut.print(flash.message)
printHtmlPart(6)
expressionOut.print(indianGovtInst?.govtInstName)
printHtmlPart(7)
expressionOut.print(indianGovtInst?.address1)
printHtmlPart(8)
expressionOut.print(indianGovtInst?.address2)
printHtmlPart(9)
expressionOut.print(indianGovtInst?.address3)
printHtmlPart(10)
invokeTag('select','g',143,['name':("countryId"),'from':(listOfCountries),'optionKey':("id"),'optionValue':("country"),'value':(indianGovtInst?.country?.id),'class':("width country ctlwidth"),'noSelection':(['':'-Select-']),'req1':("1"),'onchange':(remoteFunction (controller: 'applicationManagement',action: 'fetchStates',
							params: "'countryId='+this.value+'&csrfPreventionSalt=${csrfPreventionSalt}'+'&formType=${formType}'",update: 'updateStates',onComplete: 'updateCountryCodes(this)'))],-1)
printHtmlPart(11)
expressionOut.print(indianGovtInst?.city)
printHtmlPart(12)
expressionOut.print(indianGovtInst?.pincode)
printHtmlPart(13)
if(true && (!indianGovtInst)) {
printHtmlPart(14)
}
else if(true && (indianGovtInst?.phone?.contains('-'))) {
printHtmlPart(15)
expressionOut.print(indianGovtInst?.phone?.split('-')[0])
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (!indianGovtInst)) {
printHtmlPart(18)
}
else if(true && (indianGovtInst?.phone?.contains('-'))) {
printHtmlPart(19)
expressionOut.print(indianGovtInst?.phone?.split('-')[1])
printHtmlPart(16)
}
printHtmlPart(20)
expressionOut.print(indianGovtInst?.email)
printHtmlPart(21)
if(true && (!indianGovtInst)) {
printHtmlPart(22)
}
else {
printHtmlPart(23)
if(true && (indianGovtInst?.samePresentAddress == 'Yes')) {
printHtmlPart(24)
}
else {
printHtmlPart(25)
}
printHtmlPart(23)
if(true && (indianGovtInst?.samePresentAddress == 'No')) {
printHtmlPart(26)
}
else {
printHtmlPart(27)
}
printHtmlPart(28)
}
printHtmlPart(29)
expressionOut.print(indianGovtInst?.presentAddress1)
printHtmlPart(30)
expressionOut.print(indianGovtInst?.presentAddress2)
printHtmlPart(31)
expressionOut.print(indianGovtInst?.presentAddress3)
printHtmlPart(32)
invokeTag('select','g',326,['name':("presentCountry"),'from':(listOfCountries),'optionKey':("id"),'optionValue':("country"),'value':(indianGovtInst?.presentCountry?.id),'req1':("1"),'class':("width country ctlwidth"),'noSelection':(['':'-Select-']),'onchange':(remoteFunction (controller: 'applicationManagement',action: 'fetchStates',
							params: "'countryId='+this.value+'&csrfPreventionSalt=${csrfPreventionSalt}'+'&formType=${formType}'",update: 'updateStates1',onComplete: 'updateCountryCodes1(this)'))],-1)
printHtmlPart(33)
expressionOut.print(indianGovtInst?.presentCity)
printHtmlPart(34)
expressionOut.print(indianGovtInst?.presentPincode)
printHtmlPart(35)
if(true && (indianGovtInst?.samePresentAddress == 'Yes' || !indianGovtInst)) {
printHtmlPart(36)
}
else if(true && (indianGovtInst?.presentPhone?.contains('-'))) {
printHtmlPart(37)
expressionOut.print(indianGovtInst?.presentPhone?.split('-')[0])
printHtmlPart(16)
}
printHtmlPart(38)
if(true && (indianGovtInst?.samePresentAddress == 'Yes' || !indianGovtInst)) {
printHtmlPart(39)
}
else if(true && (indianGovtInst?.presentPhone?.contains('-'))) {
printHtmlPart(40)
expressionOut.print(indianGovtInst?.presentPhone?.split('-')[1])
printHtmlPart(16)
}
printHtmlPart(41)
invokeTag('hiddenField','g',385,['name':("profileId"),'value':(indianGovtInst?.id)],-1)
printHtmlPart(42)
invokeTag('hiddenField','g',386,['name':("formType"),'value':(formType)],-1)
printHtmlPart(42)
invokeTag('hiddenField','g',387,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(43)
})
invokeTag('uploadForm','g',391,['class':("form-horizontal"),'role':("form"),'autocomplete':("off"),'action':("submitIndianGovtInst")],1)
printHtmlPart(44)
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
