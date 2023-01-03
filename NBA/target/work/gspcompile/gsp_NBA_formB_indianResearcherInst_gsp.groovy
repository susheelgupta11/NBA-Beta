import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formB_indianResearcherInst_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formB/_indianResearcherInst.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(2)
expressionOut.print(flash.message)
printHtmlPart(3)
invokeTag('select','g',63,['id':("foucuscontrol"),'name':("title"),'req1':("1"),'class':("width controlclass1"),'value':(individualProfile?.title),'from':(IndividualProfile.TitleName.values()),'noSelection':(['':'-Select title-'])],-1)
printHtmlPart(4)
expressionOut.print(individualProfile?.firstName)
printHtmlPart(5)
expressionOut.print(individualProfile?.middleName)
printHtmlPart(6)
expressionOut.print(individualProfile?.lastName)
printHtmlPart(7)
invokeTag('select','g',114,['from':(nationality),'class':("width controlclass1"),'name':("nationality"),'req1':("1"),'id':("nationality"),'value':(individualProfile?.nationality),'onchange':("updateCountry(this)")],-1)
printHtmlPart(8)
expressionOut.print(companyProfile1?.address1)
printHtmlPart(9)
expressionOut.print(companyProfile1?.address2)
printHtmlPart(10)
expressionOut.print(companyProfile1?.address3)
printHtmlPart(11)
invokeTag('select','g',176,['name':("countryId"),'from':(listOfCountries),'optionKey':("id"),'optionValue':("country"),'value':(companyProfile1?.country?.id),'class':("width country ctlwidth"),'noSelection':(['':'-Select-']),'req1':("1"),'onchange':(remoteFunction (controller: 'applicationManagement',action: 'fetchStates',
							params: "'countryId='+this.value+'&csrfPreventionSalt=${csrfPreventionSalt}'",update: 'updateStates',onComplete: 'updateCountryCodes(this)'))],-1)
printHtmlPart(12)
expressionOut.print(companyProfile1?.city)
printHtmlPart(13)
expressionOut.print(companyProfile1?.pincode)
printHtmlPart(14)
if(true && (!companyProfile1)) {
printHtmlPart(15)
}
else if(true && (companyProfile1?.mobile?.contains('-'))) {
printHtmlPart(16)
expressionOut.print(companyProfile1?.mobile?.split('-')[0])
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (!companyProfile1)) {
printHtmlPart(19)
}
else if(true && (companyProfile1?.mobile?.contains('-'))) {
printHtmlPart(20)
expressionOut.print(companyProfile1?.mobile?.split('-')[1])
printHtmlPart(21)
}
printHtmlPart(22)
if(true && (!companyProfile1)) {
printHtmlPart(23)
}
else if(true && (companyProfile1?.phone?.contains('-'))) {
printHtmlPart(24)
expressionOut.print(companyProfile1?.phone?.split('-')[0])
printHtmlPart(21)
}
printHtmlPart(18)
if(true && (!companyProfile1)) {
printHtmlPart(25)
}
else if(true && (companyProfile1?.phone?.contains('-'))) {
printHtmlPart(26)
expressionOut.print(companyProfile1?.phone?.split('-')[1])
printHtmlPart(21)
}
printHtmlPart(27)
expressionOut.print(companyProfile1?.email)
printHtmlPart(28)
invokeTag('hiddenField','g',423,['name':("profileId"),'value':(companyProfile1?.id)],-1)
printHtmlPart(29)
invokeTag('hiddenField','g',423,['name':("formType"),'value':(formType)],-1)
printHtmlPart(29)
invokeTag('hiddenField','g',425,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(30)
})
invokeTag('uploadForm','g',427,['class':("form-horizontal"),'role':("form"),'autocomplete':("off"),'action':("submitCompanyProfile")],1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1664179406253L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
