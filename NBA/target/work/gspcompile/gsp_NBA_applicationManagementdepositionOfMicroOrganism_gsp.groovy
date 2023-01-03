import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagementdepositionOfMicroOrganism_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/depositionOfMicroOrganism.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("loggedInUser")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',48,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(tabStatus)
printHtmlPart(7)
expressionOut.print(createLink(controller:'applicationManagement',action:'fetchMobileCode'))
printHtmlPart(8)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(9)
})
invokeTag('javascript','g',55,[:],2)
printHtmlPart(10)
invokeTag('render','g',61,['template':("leftTabs"),'model':([formType:formType,appForm:appForm])],-1)
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(13)
expressionOut.print(depositionOfMicroOrganism1?.nameOfDepositor)
printHtmlPart(14)
expressionOut.print(depositionOfMicroOrganism1?.address1)
printHtmlPart(15)
expressionOut.print(depositionOfMicroOrganism1?.address2)
printHtmlPart(16)
expressionOut.print(depositionOfMicroOrganism1?.address3)
printHtmlPart(17)
invokeTag('select','g',168,['name':("countryId"),'from':(listOfCountries),'optionKey':("id"),'optionValue':("country"),'value':(depositionOfMicroOrganism1?.country?.id),'class':("width country ctlwidth")],-1)
printHtmlPart(18)
invokeTag('select','g',189,['name':("state"),'from':(statesList?.state),'class':("form-control width ctlwidth"),'req1':("1"),'value':(depositionOfMicroOrganism1?.state),'noSelection':(['':'Select State'])],-1)
printHtmlPart(19)
expressionOut.print(depositionOfMicroOrganism1?.city)
printHtmlPart(20)
expressionOut.print(depositionOfMicroOrganism1?.zip)
printHtmlPart(21)
if(true && (!depositionOfMicroOrganism1)) {
printHtmlPart(22)
}
else if(true && (depositionOfMicroOrganism1?.mobile?.contains('-'))) {
printHtmlPart(23)
expressionOut.print(depositionOfMicroOrganism1?.mobile?.split('-')[0])
printHtmlPart(24)
}
printHtmlPart(25)
if(true && (!depositionOfMicroOrganism1)) {
printHtmlPart(26)
}
else if(true && (depositionOfMicroOrganism1?.mobile?.contains('-'))) {
printHtmlPart(27)
expressionOut.print(depositionOfMicroOrganism1?.mobile?.split('-')[1])
printHtmlPart(24)
}
printHtmlPart(28)
if(true && (!depositionOfMicroOrganism1)) {
printHtmlPart(29)
}
else if(true && (depositionOfMicroOrganism1?.phone?.contains('-'))) {
printHtmlPart(30)
expressionOut.print(depositionOfMicroOrganism1?.phone?.split('-')[0])
printHtmlPart(31)
}
printHtmlPart(32)
if(true && (!depositionOfMicroOrganism1)) {
printHtmlPart(33)
}
else if(true && (depositionOfMicroOrganism1?.phone?.contains('-'))) {
printHtmlPart(34)
expressionOut.print(depositionOfMicroOrganism1?.phone?.split('-')[1])
printHtmlPart(31)
}
printHtmlPart(35)
expressionOut.print(depositionOfMicroOrganism1?.email)
printHtmlPart(36)
invokeTag('hiddenField','g',306,['name':("profileId"),'value':(depositionOfMicroOrganism1?.id)],-1)
printHtmlPart(37)
invokeTag('hiddenField','g',307,['name':("formType"),'value':(formType)],-1)
printHtmlPart(37)
invokeTag('hiddenField','g',310,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(37)
invokeTag('hiddenField','g',312,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(38)
})
invokeTag('uploadForm','g',321,['class':("form-horizontal"),'role':("form"),'autocomplete':("off"),'action':("submitDepositionOfMicroOrganism")],2)
printHtmlPart(39)
if(true && (listOfDepositionOfMicroOrganism!=null)) {
printHtmlPart(40)
invokeTag('render','g',331,['template':("depositionOfMicroOrganismGrid"),'model':([csrfPreventionSalt:"${csrfPreventionSalt}",appFormId:appForm?.id,depositionOfMicroOrganism:depositionOfMicroOrganism1,listOfDepositionOfMicroOrganism:listOfDepositionOfMicroOrganism,deleteCalled:deleteCalled])],-1)
printHtmlPart(41)
}
printHtmlPart(42)
createClosureForHtmlPart(43, 2)
invokeTag('link','g',343,['controller':("applicationManagement"),'action':("formCPart2"),'class':("btn btn-primary pull-right btnfirstNext inactive"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(44)
})
invokeTag('captureBody','sitemesh',343,[:],1)
printHtmlPart(45)
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
