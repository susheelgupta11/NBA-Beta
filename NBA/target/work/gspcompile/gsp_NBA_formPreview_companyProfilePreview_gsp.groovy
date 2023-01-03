import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formPreview_companyProfilePreview_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formPreview/_companyProfilePreview.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
for( companyProfile1 in (listOfCompanyData) ) {
printHtmlPart(1)
expressionOut.print(companyProfile1?.entityName)
printHtmlPart(2)
if(true && (companyProfile1?.entityType)) {
printHtmlPart(3)
invokeTag('radio','g',56,['name':("entityType"),'value':(entityType),'disabled':("disabled"),'req1':("1"),'class':("ctlwidth leftflot"),'checked':("checked")],-1)
printHtmlPart(4)
expressionOut.print(companyProfile1?.entityType)
printHtmlPart(5)
}
else {
printHtmlPart(6)
}
printHtmlPart(7)
if(true && (companyProfile1?.nationality == 'notRegisteredInIndia')) {
printHtmlPart(8)
}
else {
printHtmlPart(9)
}
printHtmlPart(10)
expressionOut.print(companyProfile1?.address1)
printHtmlPart(11)
expressionOut.print(companyProfile1?.address2)
printHtmlPart(11)
expressionOut.print(companyProfile1?.address3)
printHtmlPart(12)
expressionOut.print(companyProfile1?.country?.id)
printHtmlPart(13)
expressionOut.print(companyProfile1?.city)
printHtmlPart(14)
expressionOut.print(companyProfile1?.pincode)
printHtmlPart(15)
if(true && (!companyProfile1)) {
printHtmlPart(16)
}
else if(true && (companyProfile1?.mobile?.contains('-'))) {
printHtmlPart(17)
expressionOut.print(companyProfile1?.mobile)
printHtmlPart(18)
}
printHtmlPart(19)
if(true && (!companyProfile1)) {
printHtmlPart(20)
}
else if(true && (companyProfile1?.phone?.contains('-'))) {
printHtmlPart(17)
expressionOut.print(companyProfile1?.phone)
printHtmlPart(18)
}
printHtmlPart(21)
expressionOut.print(companyProfile1?.email)
printHtmlPart(22)
expressionOut.print(companyProfile1?.website)
printHtmlPart(23)
expressionOut.print(companyProfile1?.businessNature)
printHtmlPart(24)
if(true && (companyProfile1?.registrationDoc)) {
printHtmlPart(17)
createTagBody(3, {->
printHtmlPart(25)
expressionOut.print(companyProfile1?.registrationDocName)
printHtmlPart(17)
})
invokeTag('link','g',223,['controller':("applicationManagement"),'action':("showDc"),'id':(companyProfile1?.id),'target':("_blank"),'class':("fumargin"),'params':([filename: 'registrationDocName', dataName: 'registrationDoc',csrfPreventionSalt:'${csrfPreventionSalt}'])],3)
printHtmlPart(18)
}
else {
printHtmlPart(26)
}
printHtmlPart(27)
expressionOut.print(companyProfile1?.title)
printHtmlPart(11)
expressionOut.print(companyProfile1?.firstName)
printHtmlPart(11)
expressionOut.print(companyProfile1?.middleName)
printHtmlPart(11)
expressionOut.print(companyProfile1?.lastName)
printHtmlPart(28)
expressionOut.print(companyProfile1?.designation)
printHtmlPart(29)
if(true && (!companyProfile1)) {
printHtmlPart(20)
}
else if(true && (companyProfile1?.mobile?.contains('-'))) {
printHtmlPart(17)
expressionOut.print(companyProfile1?.mobile)
printHtmlPart(18)
}
printHtmlPart(30)
expressionOut.print(companyProfile1?.personEmail)
printHtmlPart(31)
if(true && (companyProfile1?.passportCopy)) {
printHtmlPart(17)
createTagBody(3, {->
printHtmlPart(25)
expressionOut.print(companyProfile1?.passportCopyFileName)
printHtmlPart(17)
})
invokeTag('link','g',298,['controller':("applicationManagement"),'action':("showDc"),'id':(companyProfile1?.id),'target':("_blank"),'params':([filename: 'passportCopy', dataName: 'passportCopy',csrfPreventionSalt:'${csrfPreventionSalt}'])],3)
printHtmlPart(18)
}
else {
printHtmlPart(32)
}
printHtmlPart(33)
if(true && (companyProfile1?.authorizationLetter)) {
printHtmlPart(17)
createTagBody(3, {->
printHtmlPart(25)
expressionOut.print(companyProfile1?.authorizationLetterFileName)
printHtmlPart(17)
})
invokeTag('link','g',321,['controller':("applicationManagement"),'action':("showDc"),'class':("fumargin"),'id':(companyProfile1?.id),'target':("_blank"),'params':([filename: 'authorizationLetterFileName', dataName: 'authorizationLetterFileName',csrfPreventionSalt:'${csrfPreventionSalt}'])],3)
printHtmlPart(18)
}
else {
printHtmlPart(34)
}
printHtmlPart(35)
}
printHtmlPart(36)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1537268168000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
