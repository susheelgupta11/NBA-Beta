import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formBformBPart4_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formB/formBPart4.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("loggedInUser")],-1)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',73,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(tabStatus)
printHtmlPart(5)
expressionOut.print(appForm?.typeOfExercise)
printHtmlPart(6)
})
invokeTag('javascript','g',78,[:],2)
printHtmlPart(7)
invokeTag('render','g',84,['template':("/applicationManagement/leftTabs"),'model':([appForm:appForm,formType:formType])],-1)
printHtmlPart(8)
if(true && (bioRes)) {
printHtmlPart(9)
invokeTag('render','g',118,['template':("bioResourceForm"),'model':([bioRes:bioRes,csrfPreventionSalt:"${csrfPreventionSalt}"])],-1)
printHtmlPart(10)
}
else {
printHtmlPart(11)
invokeTag('render','g',122,['template':("bioResourceForm"),'model':([csrfPreventionSalt:"${csrfPreventionSalt}"])],-1)
printHtmlPart(10)
}
printHtmlPart(12)
if(true && (listOfBioResources)) {
printHtmlPart(10)
invokeTag('render','g',130,['template':("bioresourceGrid"),'model':([listOfBioResources:listOfBioResources])],-1)
printHtmlPart(13)
}
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(15)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(16)
expressionOut.print(appForm?.researchDurationFrom?.format('dd/MM/yyyy'))
printHtmlPart(17)
expressionOut.print(appForm?.researchDurationTo?.format('dd/MM/yyyy'))
printHtmlPart(18)
if(true && (!appForm)) {
printHtmlPart(19)
}
else {
printHtmlPart(20)
if(true && (appForm?.typeOfExercise == 'oneTime')) {
printHtmlPart(21)
}
else {
printHtmlPart(22)
}
printHtmlPart(23)
if(true && (appForm?.typeOfExercise == 'multipleTime')) {
printHtmlPart(24)
}
else {
printHtmlPart(25)
}
printHtmlPart(11)
}
printHtmlPart(26)
expressionOut.print(appForm?.numOfTimesOfSending)
printHtmlPart(27)
expressionOut.print(appForm?.reasonsForSending)
printHtmlPart(28)
invokeTag('hiddenField','g',247,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(11)
invokeTag('hiddenField','g',248,['name':("formType"),'value':(formType)],-1)
printHtmlPart(29)
})
invokeTag('formRemote','g',250,['name':("researchDuration"),'class':("form-horizontal"),'role':("form"),'autocomplete':("off"),'url':([controller:'formB',action:'researchDuration']),'update':(""),'onSuccess':(""),'onComplete':("loadPage()")],2)
printHtmlPart(30)
invokeTag('render','g',263,['template':("/applicationManagement/geographicalLocationForm"),'model':([bioresource:bioresource,listOfStates:listOfStates,appForm:appForm,geoLocation:geoLocation,formType:formType])],-1)
printHtmlPart(31)
if(true && (listOfLocations)) {
printHtmlPart(10)
invokeTag('render','g',272,['template':("/applicationManagement/geographicalLocationGrid"),'model':([appForm:appForm,listOfLocations:listOfLocations,formType:formType])],-1)
printHtmlPart(13)
}
printHtmlPart(32)
createTagBody(2, {->
printHtmlPart(33)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(34)
createTagBody(3, {->
expressionOut.print(appForm?.emergencyDetails)
})
invokeTag('textArea','g',291,['class':("form-control widthemergencyDetails txtlastvalid txtremovevalidate"),'rows':("4"),'name':("emergencyDetails"),'txtmaxword100':("1"),'placeholder':("Details in 500 words")],3)
printHtmlPart(35)
invokeTag('hiddenField','g',296,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(9)
invokeTag('hiddenField','g',297,['name':("formType"),'value':(formType)],-1)
printHtmlPart(36)
})
invokeTag('formRemote','g',306,['name':("emergencyDetails"),'class':("form-horizontal"),'role':("form"),'autocomplete':("off"),'url':([controller:'formB',action:'researchDuration']),'update':(""),'onSuccess':(""),'onComplete':("loadPage()")],2)
printHtmlPart(37)
createClosureForHtmlPart(38, 2)
invokeTag('link','g',309,['controller':("formB"),'action':("formBPart3"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("""btn btn-primary
									""")],2)
printHtmlPart(39)
invokeTag('set','g',311,['var':("ListId1"),'value':(listOfLocations?.bioResource?.scientificName)],-1)
printHtmlPart(13)
invokeTag('set','g',316,['var':("ListId2"),'value':(newList?.scientificName)],-1)
printHtmlPart(13)
if(true && ((ListId1).containsAll(ListId2) == true)) {
printHtmlPart(10)
createClosureForHtmlPart(40, 3)
invokeTag('link','g',323,['controller':("formB"),'action':("formBPart5"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn  btn-primary pull-right"),'method':("POST")],3)
printHtmlPart(13)
}
else {
printHtmlPart(41)
}
printHtmlPart(42)
})
invokeTag('captureBody','sitemesh',326,[:],1)
printHtmlPart(43)
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
