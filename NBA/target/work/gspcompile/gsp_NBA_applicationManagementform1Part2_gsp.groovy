
import java.util.Collections

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagementform1Part2_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/form1Part2.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("loggedInUser")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',56,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(tabStatus)
printHtmlPart(7)
})
invokeTag('javascript','g',65,[:],2)
printHtmlPart(8)
invokeTag('render','g',75,['template':("leftTabs"),'model':([appForm:appForm,formType:formType])],-1)
printHtmlPart(9)
if(true && (bioResourceInst)) {
printHtmlPart(10)
invokeTag('render','g',117,['template':("editForm1Part2"),'model':([bioResourceInst:bioResourceInst,formType:formType])],-1)
printHtmlPart(11)
}
else {
printHtmlPart(10)
invokeTag('render','g',121,['template':("addPart1"),'model':([bioResourceInst:bioResourceInst])],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (listOfBioResources)) {
printHtmlPart(13)
invokeTag('render','g',133,['template':("biologicalResourcesGrid"),'model':([listOfBioResources:listOfBioResources])],-1)
printHtmlPart(14)
}
printHtmlPart(15)
invokeTag('render','g',143,['template':("geographicalLocationForm"),'model':([bioresource:bioresource,listOfStates:listOfStates,appForm:appForm,geoLocation:geoLocation,formType:formType])],-1)
printHtmlPart(16)
if(true && (listOfLocations)) {
printHtmlPart(13)
invokeTag('render','g',152,['template':("geographicalLocationGrid"),'model':([appForm:appForm,listOfLocations:listOfLocations,formType:formType])],-1)
printHtmlPart(14)
}
printHtmlPart(17)
createTagBody(2, {->
printHtmlPart(18)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(19)
if(true && (appForm?.individualProfiles?.size() > 0)) {
printHtmlPart(20)
createClosureForHtmlPart(21, 4)
invokeTag('link','g',170,['controller':("applicationManagement"),'action':("individualProfile"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("""btn btn-primary
									""")],4)
printHtmlPart(22)
}
else {
printHtmlPart(20)
createClosureForHtmlPart(21, 4)
invokeTag('link','g',177,['controller':("applicationManagement"),'action':("companyProfile"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("""btn btn-primary
									""")],4)
printHtmlPart(22)
}
printHtmlPart(22)
invokeTag('hiddenField','g',181,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(23)
invokeTag('set','g',184,['var':("ListId1"),'value':(listOfLocations?.bioResource?.scientificName)],-1)
printHtmlPart(22)
invokeTag('set','g',185,['var':("ListId2"),'value':(newList?.scientificName)],-1)
printHtmlPart(22)
if(true && ((ListId1).containsAll(ListId2) == true)) {
printHtmlPart(20)
createClosureForHtmlPart(24, 4)
invokeTag('link','g',189,['controller':("applicationManagement"),'action':("form1Part3"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn  btn-primary pull-right"),'method':("POST")],4)
printHtmlPart(22)
}
else {
printHtmlPart(25)
}
printHtmlPart(26)
})
invokeTag('form','g',193,['controller':("applicationManagement"),'action':("saveDetailedTraditionalKnowledge"),'autocomplete':("off"),'class':("form-horizontal"),'role':("form")],2)
printHtmlPart(27)
})
invokeTag('captureBody','sitemesh',195,[:],1)
printHtmlPart(28)
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
