import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_form4part2_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/form4/part2.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("loggedInUser")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',22,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(appForm?.id)
printHtmlPart(7)
expressionOut.print(declaration)
printHtmlPart(8)
expressionOut.print(tabStatus)
printHtmlPart(9)
})
invokeTag('javascript','g',29,[:],2)
printHtmlPart(10)
invokeTag('render','g',36,['template':("/applicationManagement/leftTabs"),'model':([formType:formType])],-1)
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(13)
for( resource in (natureOfReources) ) {
printHtmlPart(14)
expressionOut.print(resource)
printHtmlPart(15)
expressionOut.print(resource)
printHtmlPart(16)
}
printHtmlPart(17)
invokeTag('select','g',142,['name':("bioResource"),'from':(resources),'value':(""),'onchange':("hideshowother(this,'other')"),'class':("width controlclass  Associate dsblcontrol1"),'noSelection':(['':'-Select-']),'req1':("1")],-1)
printHtmlPart(18)
invokeTag('select','g',168,['name':("qtyUnit"),'from':(quantityList),'value':(""),'class':("width controlclass  Associate dsblcontrol1"),'noSelection':(['':'-Select-']),'req1':("1")],-1)
printHtmlPart(19)
invokeTag('textArea','g',180,['class':("width controlclass"),'placeHolder':("Provide details in 500 words"),'txtreq1':("1"),'rows':("4"),'txtmaxword100':("1"),'name':("bioResouceTraditionalKnowledge"),'value':("")],-1)
printHtmlPart(20)
invokeTag('hiddenField','g',186,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(21)
invokeTag('hiddenField','g',187,['name':("formType"),'value':(formType)],-1)
printHtmlPart(22)
})
invokeTag('formRemote','g',194,['name':("biologicalResources"),'class':("form-horizontal"),'role':("form"),'autocomplete':("off"),'url':([controller:'applicationManagement',action:'saveBiologicalResources']),'update':("updateBioResources"),'onSuccess':("ClearAllFields()"),'onComplete':("loadPage()")],2)
printHtmlPart(23)
if(true && (listOfBioResources)) {
printHtmlPart(24)
invokeTag('render','g',201,['template':("/applicationManagement/biologicalResourcesGrid"),'model':([listOfBioResources:listOfBioResources])],-1)
printHtmlPart(25)
}
printHtmlPart(26)
createTagBody(2, {->
printHtmlPart(27)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(28)
if(true && (appForm?.nbaApprovalFile)) {
printHtmlPart(29)
if(true && (flash.message)) {
printHtmlPart(30)
expressionOut.print(flash.message)
printHtmlPart(31)
}
else {
printHtmlPart(32)
createTagBody(5, {->
printHtmlPart(33)
expressionOut.print(appForm?.nbaApprovalFileName)
printHtmlPart(32)
})
invokeTag('link','g',237,['controller':("form4"),'action':("showDc"),'id':(appForm?.id),'target':("_blank"),'params':([filename: "nbaApprovalFileName", dataName: "nbaApprovalFileName", nbaApprovalPart2:"part2",csrfPreventionSalt:"${csrfPreventionSalt}"])],5)
printHtmlPart(34)
}
printHtmlPart(35)
}
else if(true && (!appForm?.nbaApprovalFile)) {
printHtmlPart(36)
if(true && (flash.message)) {
printHtmlPart(30)
expressionOut.print(flash.message)
printHtmlPart(31)
}
printHtmlPart(35)
}
printHtmlPart(37)
expressionOut.print(appForm?.applicationNo)
printHtmlPart(38)
expressionOut.print(appForm?.dateOfApproval?.format('dd/MM/yyyy'))
printHtmlPart(39)
if(true && (!appForm?.isbenefitSharingDetailImplemented)) {
printHtmlPart(40)
}
else {
printHtmlPart(21)
if(true && (appForm?.isbenefitSharingDetailImplemented == 'true')) {
printHtmlPart(41)
}
else {
printHtmlPart(42)
}
printHtmlPart(43)
if(true && (appForm?.isbenefitSharingDetailImplemented == 'false')) {
printHtmlPart(44)
}
else {
printHtmlPart(45)
}
printHtmlPart(46)
}
printHtmlPart(47)
invokeTag('textArea','g',328,['class':("width txtreqc1 txtmaxword100 ctrl1"),'name':("benefitMechanism"),'value':(appForm?.benefitMechanism),'placeHolder':("Provide details in 500 words"),'rows':("5")],-1)
printHtmlPart(48)
if(true && (appForm?.mouFile)) {
printHtmlPart(49)
createTagBody(4, {->
printHtmlPart(32)
expressionOut.print(appForm?.mouFileName)
printHtmlPart(34)
})
invokeTag('link','g',337,['controller':("form3"),'action':("showDc"),'id':(appForm?.id),'target':("_blank"),'params':([filename: 'mouFileName', dataName: 'mouFileName',csrfPreventionSalt:'${csrfPreventionSalt}'])],4)
printHtmlPart(35)
}
else {
printHtmlPart(50)
}
printHtmlPart(51)
invokeTag('hiddenField','g',348,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(21)
invokeTag('hiddenField','g',349,['name':("formType"),'value':(formType)],-1)
printHtmlPart(52)
})
invokeTag('uploadForm','g',351,['class':("form-horizontal"),'role':("form"),'autocomplete':("off"),'action':("savePart2")],2)
printHtmlPart(53)
if(true && (appForm?.individualProfiles?.size() > 0)) {
printHtmlPart(25)
createClosureForHtmlPart(54, 3)
invokeTag('link','g',364,['controller':("applicationManagement"),'action':("individualProfile"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("""btn btn-primary
									""")],3)
printHtmlPart(55)
}
else {
printHtmlPart(25)
createClosureForHtmlPart(54, 3)
invokeTag('link','g',370,['controller':("applicationManagement"),'action':("companyProfile"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("""btn btn-primary
									""")],3)
printHtmlPart(55)
}
printHtmlPart(56)
createClosureForHtmlPart(57, 2)
invokeTag('link','g',377,['controller':("form4"),'action':("part3"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn  btn-primary pull-right")],2)
printHtmlPart(58)
})
invokeTag('captureBody','sitemesh',383,[:],1)
printHtmlPart(59)
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
