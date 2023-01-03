
import org.nba.application.IndianResearcher

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formB_indianResearcher_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formB/_indianResearcher.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
expressionOut.print(indianResearcher?.samePresentAddress)
printHtmlPart(2)
})
invokeTag('javascript','g',119,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(5)
if(true && (flash.args != 'phonePattern')) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
invokeTag('select','g',146,['id':("foucuscontrol"),'name':("title"),'req1':("1"),'class':("width controlclass1"),'value':(indianResearcher?.title),'from':(IndianResearcher.TitleName.values()),'noSelection':(['':'-Select title-'])],-1)
printHtmlPart(9)
expressionOut.print(indianResearcher?.firstName)
printHtmlPart(10)
expressionOut.print(indianResearcher?.middleName)
printHtmlPart(11)
expressionOut.print(indianResearcher?.lastName)
printHtmlPart(12)
expressionOut.print(indianResearcher?.address1)
printHtmlPart(13)
expressionOut.print(indianResearcher?.address2)
printHtmlPart(14)
expressionOut.print(indianResearcher?.address3)
printHtmlPart(15)
invokeTag('select','g',248,['name':("countryId"),'from':(countryIndiaFromList),'optionKey':("id"),'optionValue':("country"),'value':(indianResearcher?.country?.id),'class':("width country ctlwidth")],-1)
printHtmlPart(16)
invokeTag('select','g',262,['name':("state"),'from':(listOfStates?.state),'req1':("1"),'class':("width ctlwidth"),'value':(indianResearcher?.province),'noSelection':(['':'Select State'])],-1)
printHtmlPart(17)
expressionOut.print(indianResearcher?.city)
printHtmlPart(18)
expressionOut.print(indianResearcher?.pincode)
printHtmlPart(19)
if(true && (!indianResearcher)) {
printHtmlPart(20)
}
else if(true && (indianResearcher?.mobile?.contains('-'))) {
printHtmlPart(21)
expressionOut.print(indianResearcher?.mobile?.split('-')[0])
printHtmlPart(22)
}
printHtmlPart(23)
if(true && (!indianResearcher)) {
printHtmlPart(24)
}
else if(true && (indianResearcher?.mobile?.contains('-'))) {
printHtmlPart(25)
expressionOut.print(indianResearcher?.mobile?.split('-')[1])
printHtmlPart(26)
}
printHtmlPart(27)
if(true && (!indianResearcher)) {
printHtmlPart(28)
}
else if(true && (indianResearcher?.phone?.contains('-'))) {
printHtmlPart(29)
expressionOut.print(indianResearcher?.phone?.split('-')[0])
printHtmlPart(26)
}
printHtmlPart(23)
if(true && (!indianResearcher)) {
printHtmlPart(30)
}
else if(true && (indianResearcher?.phone?.contains('-') || flash.message)) {
printHtmlPart(31)
expressionOut.print(indianResearcher?.phone?.split('-')[1])
printHtmlPart(32)
}
printHtmlPart(33)
expressionOut.print(indianResearcher?.email)
printHtmlPart(34)
if(true && (!indianResearcher)) {
printHtmlPart(35)
}
else {
printHtmlPart(36)
if(true && (indianResearcher?.samePresentAddress == 'Yes')) {
printHtmlPart(37)
}
else {
printHtmlPart(38)
}
printHtmlPart(36)
if(true && (indianResearcher?.samePresentAddress == 'No')) {
printHtmlPart(39)
}
else {
printHtmlPart(40)
}
printHtmlPart(41)
}
printHtmlPart(42)
expressionOut.print(indianResearcher?.presentAddress1)
printHtmlPart(43)
expressionOut.print(indianResearcher?.presentAddress2)
printHtmlPart(44)
expressionOut.print(indianResearcher?.presentAddress3)
printHtmlPart(45)
invokeTag('select','g',479,['name':("presentCountry"),'from':(listOfCountries),'optionKey':("id"),'optionValue':("country"),'req1':("1"),'value':(indianResearcher?.presentCountry?.id),'class':("width country ctlwidth"),'noSelection':(['':'-Select-']),'onchange':(remoteFunction (controller: 'applicationManagement',action: 'fetchStates',
							params: "'countryId='+this.value+'&csrfPreventionSalt=${csrfPreventionSalt}'+'&formType=${formType}'",update: 'updateStates1',onComplete: 'updateCountryCodes1(this)'))],-1)
printHtmlPart(46)
expressionOut.print(indianResearcher?.presentCity)
printHtmlPart(47)
expressionOut.print(indianResearcher?.presentPincode)
printHtmlPart(48)
if(true && (indianResearcher?.samePresentAddress == 'Yes' || !indianResearcher)) {
printHtmlPart(49)
}
else if(true && (indianResearcher?.presentMobile?.contains('-'))) {
printHtmlPart(50)
expressionOut.print(indianResearcher?.presentMobile?.split('-')[0])
printHtmlPart(22)
}
printHtmlPart(23)
if(true && (indianResearcher?.samePresentAddress == 'Yes' || !indianResearcher)) {
printHtmlPart(51)
}
else if(true && (indianResearcher?.presentMobile?.contains('-'))) {
printHtmlPart(52)
expressionOut.print(indianResearcher?.presentMobile?.split('-')[1])
printHtmlPart(26)
}
printHtmlPart(53)
if(true && (indianResearcher?.samePresentAddress == 'Yes' || !indianResearcher)) {
printHtmlPart(54)
}
else if(true && (indianResearcher?.presentPhone?.contains('-'))) {
printHtmlPart(55)
expressionOut.print(indianResearcher?.presentPhone?.split('-')[0])
printHtmlPart(26)
}
printHtmlPart(23)
if(true && (indianResearcher?.samePresentAddress == 'Yes' || !indianResearcher)) {
printHtmlPart(56)
}
else if(true && (indianResearcher?.presentPhone?.contains('-'))) {
printHtmlPart(57)
expressionOut.print(indianResearcher?.presentPhone?.split('-')[1])
printHtmlPart(26)
}
printHtmlPart(58)
if(true && (indianResearcher?.addressproofLetter)) {
printHtmlPart(59)
invokeTag('select','g',580,['id':("foucuscontrol"),'name':("addressproofSelect"),'class':("width controlclass1"),'req1':("1"),'value':(indianResearcher?.addressproofSelect),'from':(addressproofSelect),'noSelection':(['':'-Select Proof-'])],-1)
printHtmlPart(60)
expressionOut.print(indianResearcher?.addressproofNo)
printHtmlPart(61)
expressionOut.print(indianResearcher?.addressproofLetter)
printHtmlPart(62)
createTagBody(3, {->
printHtmlPart(63)
expressionOut.print(indianResearcher?.addressproofLetterFileName)
printHtmlPart(64)
})
invokeTag('link','g',597,['controller':("applicationManagement"),'action':("showUndertakingFile"),'id':(indianResearcher?.id),'target':("_blank"),'params':([filename: "addressproofLetter",appFormId:"${appForm?.id}",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(65)
}
else {
printHtmlPart(66)
invokeTag('select','g',605,['id':("foucuscontrol"),'name':("addressproofSelect"),'req1':("1"),'class':("width controlclass1"),'value':(""),'from':(addressproofSelect)],-1)
printHtmlPart(67)
}
printHtmlPart(68)
invokeTag('hiddenField','g',627,['name':("profileId"),'value':(indianResearcher?.id)],-1)
printHtmlPart(69)
invokeTag('hiddenField','g',628,['name':("formType"),'value':(formType)],-1)
printHtmlPart(69)
invokeTag('hiddenField','g',629,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(70)
})
invokeTag('uploadForm','g',1,['class':("form-horizontal"),'role':("form"),'autocomplete':("off"),'action':("submitIndianResearcher")],1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1650522439418L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
