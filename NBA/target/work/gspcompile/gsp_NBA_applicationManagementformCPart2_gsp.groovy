import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagementformCPart2_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/formCPart2.gsp" }
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
invokeTag('captureHead','sitemesh',23,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(tabStatus)
printHtmlPart(7)
})
invokeTag('javascript','g',28,[:],2)
printHtmlPart(8)
invokeTag('render','g',34,['template':("leftTabs"),'model':([formType:formType,appForm:appForm])],-1)
printHtmlPart(9)
invokeTag('render','g',60,['template':("formCMicroorganismName"),'model':([appForm:appFormId,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"])],-1)
printHtmlPart(10)
if(true && (listOfScientistName!=null)) {
printHtmlPart(11)
invokeTag('render','g',67,['template':("microOrganismScientistNameGrid"),'model':([csrfPreventionSalt:"${csrfPreventionSalt}",appFormId:appFormId,microOrgaScirntistName:microOrgaScirntistName,listOfScientistName:listOfScientistName,deleteCalled:deleteCalled])],-1)
printHtmlPart(12)
}
printHtmlPart(13)
invokeTag('render','g',73,['template':("formCMicroorganism"),'model':([appForm:appFormId,geoLocationlist1:geoLocationlist1,geoLocationlist:geoLocationlist,listOfScientistName:listOfScientistName,
						formType:formType,statesList:listOfStates,scientistNameObj:scientistNameObj,accessSources:accessSources,csrfPreventionSalt:"${csrfPreventionSalt}"])],-1)
printHtmlPart(14)
if(true && (locations?.size() >0)) {
printHtmlPart(15)
invokeTag('render','g',82,['template':("formCMicroorganismGrid"),'model':([appFormId:appFormId,geoLocationlist:geoLocationlist,listOfScientistName:listOfScientistName,deleteCalled:deleteCalled,microOrgaScirntistName:microOrgaScirntistName,
								bioResourceLocations:bioResourceLocations,locations:locations,geoLocationlist1:geoLocationlist1,deleteCalled1:deleteCalled1,csrfPreventionSalt:"${csrfPreventionSalt}"])],-1)
printHtmlPart(16)
}
printHtmlPart(17)
createClosureForHtmlPart(18, 2)
invokeTag('link','g',91,['controller':("applicationManagement"),'action':("depositionOfMicroOrganism"),'class':("btn btn-primary"),'params':([appFormId:appFormId,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(19)
invokeTag('set','g',94,['var':("ListId1"),'value':(locations?.bioResource?.scientistName)],-1)
printHtmlPart(12)
invokeTag('set','g',95,['var':("ListId2"),'value':(newList?.scientistName)],-1)
printHtmlPart(12)
if(true && ((ListId1).containsAll(ListId2) == true)) {
printHtmlPart(20)
createClosureForHtmlPart(21, 3)
invokeTag('link','g',100,['controller':("applicationManagement"),'action':("formCPart3"),'class':("btn  btn-primary pull-right"),'params':([formType:formType,appFormId:appFormId,csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(19)
}
else {
printHtmlPart(22)
}
printHtmlPart(23)
})
invokeTag('captureBody','sitemesh',128,[:],1)
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
