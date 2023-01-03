import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_form2part2_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/form2/part2.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("loggedInUser")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',18,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(tabStatus)
printHtmlPart(6)
})
invokeTag('javascript','g',23,[:],2)
printHtmlPart(7)
invokeTag('render','g',30,['template':("/applicationManagement/leftTabs"),'model':([formType:formType])],-1)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(10)
invokeTag('textArea','g',74,['class':("width controlclass2"),'name':("briefDescription"),'placeHolder':("Provide the details in 500 words"),'txtreq1':("1"),'txtmaxword100':("1"),'value':(appForm?.briefDescription)],-1)
printHtmlPart(11)
invokeTag('textArea','g',92,['class':("width controlclass2"),'name':("resultsOfResearch"),'txtreq1':("1"),'txtmaxword100':("1"),'value':(appForm?.resultsOfResearch),'placeHolder':(" Please specify the type / description of research results to be transferred in 500 words ")],-1)
printHtmlPart(12)
invokeTag('hiddenField','g',99,['name':("formType"),'value':(formType)],-1)
printHtmlPart(13)
invokeTag('hiddenField','g',100,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(14)
})
invokeTag('form','g',105,['controller':("form2"),'action':("saveResearchResults"),'autocomplete':("off"),'class':("form-horizontal"),'role':("form")],2)
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(16)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(17)
for( resource in (natureOfReources) ) {
printHtmlPart(18)
expressionOut.print(resource)
printHtmlPart(19)
expressionOut.print(resource)
printHtmlPart(20)
}
printHtmlPart(21)
invokeTag('select','g',215,['name':("bioResource"),'from':(resources),'value':(""),'onchange':("hideshowother(this,'other')"),'class':("width controlclass Associate dsblcontrol1"),'noSelection':(['':'-Select-'])],-1)
printHtmlPart(22)
invokeTag('hiddenField','g',229,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(23)
invokeTag('hiddenField','g',230,['name':("formType"),'value':(formType)],-1)
printHtmlPart(24)
})
invokeTag('formRemote','g',237,['name':("biologicalResources"),'class':("form-horizontal"),'role':("form"),'autocomplete':("off"),'url':([controller:'applicationManagement',action:'saveBiologicalResources']),'update':("updateBioResources"),'onSuccess':("ClearAllFields()"),'onComplete':("loadPage()")],2)
printHtmlPart(25)
if(true && (listOfBioResources)) {
printHtmlPart(13)
invokeTag('render','g',247,['template':("/applicationManagement/biologicalResourcesGrid"),'model':([listOfBioResources:listOfBioResources,appForm:appForm])],-1)
printHtmlPart(26)
}
printHtmlPart(27)
invokeTag('render','g',254,['template':("/applicationManagement/geographicalLocationForm"),'model':([newList:newList,listOfBioResources:listOfBioResources,appForm:appForm,geoLocation:geoLocation,listOfStates:listOfStates])],-1)
printHtmlPart(28)
if(true && (listOfLocations)) {
printHtmlPart(29)
invokeTag('render','g',261,['template':("/applicationManagement/geographicalLocationGrid"),'model':([appForm:appForm,listOfLocations:listOfLocations])],-1)
printHtmlPart(30)
}
printHtmlPart(31)
if(true && (appForm?.individualProfiles?.size() > 0 && appForm?.individualProfiles?.getAt(0)?.nationality == 'Non Indian' || appForm?.individualProfiles?.getAt(0)?.nationality == 'Non-Resident Indian')) {
printHtmlPart(32)
createTagBody(3, {->
printHtmlPart(33)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(34)
if(true && (!appForm.isApprovalOfNbaObtained)) {
printHtmlPart(35)
}
else {
printHtmlPart(36)
if(true && (appForm.isApprovalOfNbaObtained == 'true')) {
printHtmlPart(37)
}
else {
printHtmlPart(38)
}
printHtmlPart(39)
if(true && (appForm.isApprovalOfNbaObtained == 'false')) {
printHtmlPart(40)
}
else {
printHtmlPart(41)
}
printHtmlPart(42)
}
printHtmlPart(43)
if(true && (appForm?.nbaApprovalFile)) {
printHtmlPart(44)
if(true && (flash.message)) {
printHtmlPart(45)
expressionOut.print(flash.message)
printHtmlPart(46)
}
else {
printHtmlPart(47)
createTagBody(6, {->
printHtmlPart(48)
expressionOut.print(appForm?.nbaApprovalFileName)
printHtmlPart(47)
})
invokeTag('link','g',339,['controller':("form2"),'action':("showDc"),'id':(appForm?.id),'target':("_blank"),'params':([filename: "nbaApprovalFileName", dataName: "nbaApprovalFileName",csrfPreventionSalt:"${csrfPreventionSalt}"])],6)
printHtmlPart(49)
}
printHtmlPart(50)
}
else {
printHtmlPart(51)
if(true && (flash.message)) {
printHtmlPart(45)
expressionOut.print(flash.message)
printHtmlPart(46)
}
printHtmlPart(52)
}
printHtmlPart(53)
invokeTag('hiddenField','g',351,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(23)
invokeTag('hiddenField','g',354,['name':("formType"),'value':(formType)],-1)
printHtmlPart(54)
})
invokeTag('uploadForm','g',360,['action':("saveNbaApproval"),'class':("form-horizontal"),'role':("form"),'autocomplete':("off")],3)
printHtmlPart(55)
}
printHtmlPart(56)
if(true && (appForm?.individualProfiles?.size() > 0)) {
printHtmlPart(26)
createClosureForHtmlPart(57, 3)
invokeTag('link','g',378,['controller':("applicationManagement"),'action':("individualProfile"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("""btn btn-primary
									""")],3)
printHtmlPart(29)
}
else {
printHtmlPart(26)
createClosureForHtmlPart(57, 3)
invokeTag('link','g',384,['controller':("applicationManagement"),'action':("companyProfile"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("""btn btn-primary
									""")],3)
printHtmlPart(29)
}
printHtmlPart(29)
invokeTag('set','g',387,['var':("ListId1"),'value':(listOfLocations?.bioResource?.scientificName)],-1)
printHtmlPart(29)
invokeTag('set','g',388,['var':("ListId2"),'value':(newList?.scientificName)],-1)
printHtmlPart(29)
if(true && ((ListId1).containsAll(ListId2) == true)) {
printHtmlPart(26)
createClosureForHtmlPart(58, 3)
invokeTag('link','g',394,['controller':("form2"),'action':("part3"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn  btn-primary pull-right"),'method':("POST")],3)
printHtmlPart(59)
}
else {
printHtmlPart(60)
}
printHtmlPart(61)
})
invokeTag('captureBody','sitemesh',398,[:],1)
printHtmlPart(62)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1537268164000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
