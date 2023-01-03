import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formB_leftTabs_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formB/_leftTabs.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (formType == 'Form1')) {
printHtmlPart(1)
if(true && (appForm == null)) {
printHtmlPart(2)
createClosureForHtmlPart(3, 3)
invokeTag('link','g',11,['controller':("applicationManagement"),'action':("selectIndividualOrCompany"),'class':("list-group-item menu1 addinactive"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(4)
}
else if(true && (appForm?.individualProfiles?.size() >= 0)) {
printHtmlPart(2)
createClosureForHtmlPart(3, 3)
invokeTag('link','g',16,['controller':("applicationManagement"),'action':("individualProfile"),'class':("list-group-item  menu1 addinactive"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(4)
}
printHtmlPart(4)
createClosureForHtmlPart(5, 2)
invokeTag('link','g',21,['controller':("applicationManagement"),'action':("form1Part2"),'class':("list-group-item addinactive menu2"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(4)
createClosureForHtmlPart(6, 2)
invokeTag('link','g',25,['controller':("applicationManagement"),'action':("form1Part3"),'class':("list-group-item addinactive menu3"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(4)
createClosureForHtmlPart(7, 2)
invokeTag('link','g',28,['controller':("applicationManagement"),'action':("form1Part4"),'class':("list-group-item addinactive menu4"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(8)
if(true && (appForm?.isTradingPurpose == 'true')) {
printHtmlPart(8)
createClosureForHtmlPart(9, 3)
invokeTag('link','g',31,['controller':("formA"),'action':("form1FormA"),'class':("list-group-item addinactive menu5"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(8)
}
printHtmlPart(4)
if(true && (appForm?.isDeclarationDigitallySigned == 'true')) {
printHtmlPart(2)
createClosureForHtmlPart(10, 3)
invokeTag('link','g',36,['controller':("applicationManagement"),'action':("form1Part5"),'class':("list-group-item addinactive menu6"),'params':([formType:formType,appFormId:appForm?.id,declaration:"declaration",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(4)
}
else if(true && (appForm?.isDeclarationDigitallySigned == 'notDigital')) {
printHtmlPart(2)
createClosureForHtmlPart(10, 3)
invokeTag('link','g',42,['controller':("applicationManagement"),'action':("form1Part5"),'class':("list-group-item addinactive menu6"),'params':([formType:formType,appFormId:appForm?.id,declaration:"declaration",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(4)
}
else {
printHtmlPart(2)
createClosureForHtmlPart(10, 3)
invokeTag('link','g',46,['controller':("applicationManagement"),'action':("form1Part5"),'class':("list-group-item addinactive menu6"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(4)
}
printHtmlPart(11)
}
else if(true && (formType == 'Form2')) {
printHtmlPart(12)
if(true && (appForm == null)) {
printHtmlPart(2)
createClosureForHtmlPart(3, 3)
invokeTag('link','g',54,['controller':("applicationManagement"),'action':("selectIndividualOrCompany"),'class':("list-group-item menu1 addinactive"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(4)
}
else if(true && (appForm?.individualProfiles?.size() >= 0)) {
printHtmlPart(2)
createClosureForHtmlPart(3, 3)
invokeTag('link','g',59,['controller':("applicationManagement"),'action':("individualProfile"),'class':("list-group-item  menu1 addinactive"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(4)
}
printHtmlPart(4)
createClosureForHtmlPart(5, 2)
invokeTag('link','g',66,['controller':("form2"),'action':("part2"),'class':("list-group-item addinactive menu2"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(4)
createClosureForHtmlPart(6, 2)
invokeTag('link','g',69,['controller':("form2"),'action':("part3"),'class':("list-group-item addinactive menu3"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(4)
createClosureForHtmlPart(7, 2)
invokeTag('link','g',72,['controller':("form2"),'action':("part4"),'class':("list-group-item addinactive menu4"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(4)
createClosureForHtmlPart(10, 2)
invokeTag('link','g',77,['controller':("applicationManagement"),'action':("form1Part5"),'class':("list-group-item addinactive menu5"),'params':([formType:formType,appFormId:appForm?.id,declaration:"declaration",csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (formType == 'Form3')) {
printHtmlPart(15)
if(true && (appForm == null)) {
printHtmlPart(2)
createClosureForHtmlPart(3, 3)
invokeTag('link','g',84,['controller':("applicationManagement"),'action':("selectIndividualOrCompany"),'class':("list-group-item menu1 addinactive"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(4)
}
else if(true && (appForm?.individualProfiles?.size() > 0)) {
printHtmlPart(2)
createClosureForHtmlPart(3, 3)
invokeTag('link','g',88,['controller':("applicationManagement"),'action':("individualProfile"),'class':("list-group-item  menu1 addinactive"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(4)
}
else if(true && (appForm?.companyProfiles?.size() > 0)) {
printHtmlPart(2)
createClosureForHtmlPart(3, 3)
invokeTag('link','g',94,['controller':("applicationManagement"),'action':("companyProfile"),'class':("list-group-item  menu1 addinactive"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(4)
}
printHtmlPart(4)
createClosureForHtmlPart(5, 2)
invokeTag('link','g',101,['controller':("form3"),'action':("part2"),'class':("list-group-item addinactive menu2"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(4)
createClosureForHtmlPart(6, 2)
invokeTag('link','g',104,['controller':("form3"),'action':("part3"),'class':("list-group-item addinactive menu3"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(4)
createClosureForHtmlPart(7, 2)
invokeTag('link','g',107,['controller':("applicationManagement"),'action':("form1Part5"),'class':("list-group-item addinactive menu5"),'params':([formType:formType,appFormId:appForm?.id,declaration:"declaration",csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(16)
}
printHtmlPart(14)
if(true && (formType == 'Form4')) {
printHtmlPart(17)
if(true && (appForm == null)) {
printHtmlPart(2)
createClosureForHtmlPart(3, 3)
invokeTag('link','g',115,['controller':("applicationManagement"),'action':("selectIndividualOrCompany"),'class':("list-group-item menu1 addinactive"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(4)
}
else if(true && (appForm?.individualProfiles?.size() >= 0)) {
printHtmlPart(2)
createClosureForHtmlPart(3, 3)
invokeTag('link','g',119,['controller':("applicationManagement"),'action':("individualProfile"),'class':("list-group-item  menu1 addinactive"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(4)
}
printHtmlPart(4)
createClosureForHtmlPart(5, 2)
invokeTag('link','g',122,['controller':("form4"),'action':("part2"),'class':("list-group-item addinactive menu2"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(4)
createClosureForHtmlPart(6, 2)
invokeTag('link','g',125,['controller':("form4"),'action':("part3"),'class':("list-group-item addinactive menu3"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(4)
createClosureForHtmlPart(7, 2)
invokeTag('link','g',134,['controller':("applicationManagement"),'action':("form1Part5"),'class':("list-group-item addinactive menu5"),'params':([formType:formType,appFormId:appForm?.id,declaration:"declaration",csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(16)
}
printHtmlPart(14)
if(true && (formType == 'FormB')) {
printHtmlPart(18)
createClosureForHtmlPart(3, 2)
invokeTag('link','g',140,['controller':("applicationManagement"),'action':("selectIndividualOrCompany"),'class':("list-group-item menu1 addinactive"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(19)
createClosureForHtmlPart(5, 2)
invokeTag('link','g',144,['controller':("form4"),'action':("part2"),'class':("list-group-item addinactive menu2"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(4)
createClosureForHtmlPart(6, 2)
invokeTag('link','g',146,['controller':("form4"),'action':("part3"),'class':("list-group-item addinactive menu3"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(4)
createClosureForHtmlPart(7, 2)
invokeTag('link','g',151,['controller':("applicationManagement"),'action':("form1Part5"),'class':("list-group-item addinactive menu5"),'params':([formType:formType,appFormId:appForm?.id,declaration:"declaration",csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(20)
createClosureForHtmlPart(21, 2)
invokeTag('link','g',153,['controller':("formB"),'action':("formBPart5"),'class':("list-group-item himanshu"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(14)
}
printHtmlPart(22)
if(true && (formType == 'FormC')) {
printHtmlPart(23)
createClosureForHtmlPart(3, 2)
invokeTag('link','g',159,['controller':("applicationManagement"),'action':("depositionOfMicroOrganism"),'class':("list-group-item menu1 addinactive"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(4)
createClosureForHtmlPart(5, 2)
invokeTag('link','g',164,['controller':("applicationManagement"),'action':("formCPart2"),'class':("list-group-item addinactive menu2"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(2)
createClosureForHtmlPart(6, 2)
invokeTag('link','g',172,['controller':("applicationManagement"),'action':("formCPart3"),'class':("list-group-item addinactive menu2"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(4)
createClosureForHtmlPart(7, 2)
invokeTag('link','g',177,['controller':("applicationManagement"),'action':("formCPart4"),'class':("list-group-item addinactive menu2"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(16)
}
printHtmlPart(24)
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
