
import java.util.Collections

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formBformBPart3_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formB/formBPart3.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("loggedInUser")],-1)
printHtmlPart(0)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',120,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(tabStatus)
printHtmlPart(7)
expressionOut.print(entity2?.category)
printHtmlPart(8)
expressionOut.print(fundingAgencyObj)
printHtmlPart(9)
expressionOut.print(deletefundingagency)
printHtmlPart(10)
})
invokeTag('javascript','g',128,[:],2)
printHtmlPart(11)
invokeTag('render','g',136,['template':("/applicationManagement/leftTabs"),'model':([appForm:appForm,formType:formType])],-1)
printHtmlPart(12)
invokeTag('render','g',168,['template':("formBpart3")],-1)
printHtmlPart(13)
invokeTag('render','g',174,['template':("formBPart3HeadDetails")],-1)
printHtmlPart(14)
invokeTag('render','g',186,['template':("formBFundingAgency"),'model':([csrfPreventionSalt:"${csrfPreventionSalt}",
						appForm:appForm,formType:formType,fundingAgencyObj:fundingAgencyObj])],-1)
printHtmlPart(15)
if(true && (listOfFundingAgency)) {
printHtmlPart(16)
invokeTag('render','g',194,['template':("formBFundingAgencyGrid"),'model':([csrfPreventionSalt:"${csrfPreventionSalt}",
						appForm:appForm,formType:formType,listOfFundingAgency:listOfFundingAgency])],-1)
printHtmlPart(17)
}
printHtmlPart(18)
createTagBody(2, {->
printHtmlPart(19)
invokeTag('textArea','g',207,['class':("form-control widthemergencyDetails txtlastvalid txtremovevalidate"),'txtmaxword200':("1"),'txtreq1':("1"),'rows':("4"),'name':("description"),'value':(appForm?.briefDescription),'placeholder':("Purpose of taking the sample/sending bio resources outside India and brief description thereof (500 words)")],-1)
printHtmlPart(20)
invokeTag('hiddenField','g',211,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(21)
invokeTag('hiddenField','g',212,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(21)
invokeTag('hiddenField','g',213,['name':("formType"),'value':(formType)],-1)
printHtmlPart(22)
invokeTag('actionSubmit','g',214,['type':("button"),'action':("saveDescription"),'class':("btn btn-primary ctrolvalid"),'value':("Save"),'onclick':("validateResearchDuration()")],-1)
printHtmlPart(23)
})
invokeTag('form','g',216,['controller':("formB"),'name':("descriptionForm"),'class':("form-horizontal"),'role':("form"),'autocomplete':("off")],2)
printHtmlPart(24)
createClosureForHtmlPart(25, 2)
invokeTag('link','g',226,['controller':("formB"),'action':("formBPart2"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("""btn btn-primary
									""")],2)
printHtmlPart(26)
invokeTag('hiddenField','g',228,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(27)
createClosureForHtmlPart(28, 2)
invokeTag('link','g',233,['controller':("formB"),'action':("formBPart4"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn  btn-primary pull-right"),'method':("POST")],2)
printHtmlPart(29)
})
invokeTag('captureBody','sitemesh',246,[:],1)
printHtmlPart(30)
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
