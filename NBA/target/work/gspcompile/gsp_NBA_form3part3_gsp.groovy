import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_form3part3_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/form3/part3.gsp" }
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
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(tabStatus)
printHtmlPart(6)
expressionOut.print(appForm?.isTraditionalKnowledgeApplicable)
printHtmlPart(7)
})
invokeTag('javascript','g',35,[:],2)
printHtmlPart(8)
invokeTag('render','g',43,['template':("/applicationManagement/leftTabs"),'model':([formType:formType])],-1)
printHtmlPart(9)
invokeTag('render','g',73,['template':("/applicationManagement/geographicalLocationForm"),'model':([appForm:appForm,formType:formType])],-1)
printHtmlPart(10)
if(true && (listOfLocations)) {
printHtmlPart(11)
invokeTag('render','g',83,['template':("/applicationManagement/geographicalLocationGrid"),'model':([appForm:appForm,formType:formType,listOfLocations:listOfLocations])],-1)
printHtmlPart(12)
}
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(14)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(15)
if(true && (!appForm)) {
printHtmlPart(16)
}
else {
printHtmlPart(17)
if(true && (appForm?.isBioObtainedOutsideIndia == 'true')) {
printHtmlPart(18)
}
else {
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (appForm?.isBioObtainedOutsideIndia == 'false')) {
printHtmlPart(21)
}
else {
printHtmlPart(22)
}
printHtmlPart(23)
}
printHtmlPart(24)
expressionOut.print(appForm?.traditionalKnowledgeDesc)
printHtmlPart(25)
if(true && (!appForm)) {
printHtmlPart(26)
}
else {
printHtmlPart(20)
if(true && (appForm?.isApprovalOfCountryObtained == 'true' || appForm?.isBioObtainedOutsideIndia == 'false')) {
printHtmlPart(27)
}
else if(true && (appForm?.isApprovalOfCountryObtained == 'false')) {
printHtmlPart(28)
}
else {
printHtmlPart(29)
}
printHtmlPart(23)
}
printHtmlPart(30)
expressionOut.print(appForm?.reasonOfDisapproval)
printHtmlPart(31)
invokeTag('hiddenField','g',229,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(32)
invokeTag('hiddenField','g',230,['name':("formType"),'value':(formType)],-1)
printHtmlPart(33)
})
invokeTag('form','g',233,['class':("form-horizontal"),'role':("form"),'action':("saveConsent"),'autocomplete':("off")],2)
printHtmlPart(34)
createTagBody(2, {->
printHtmlPart(14)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(35)
if(true && (appForm?.isTraditionalKnowledgeApplicable == 'Applicable')) {
printHtmlPart(36)
invokeTag('radio','g',272,['class':("isApplicable radio col-sm-1 community"),'name':("isApplicable"),'onclick':("addtxtreq1()"),'checked':("checked"),'value':("Applicable")],-1)
printHtmlPart(37)
expressionOut.print(appForm?.isTraditionalKnowledgeApplicable)
printHtmlPart(38)
}
else {
printHtmlPart(36)
invokeTag('radio','g',278,['class':("isApplicable radio col-sm-1 community"),'name':("isApplicable"),'onclick':("addtxtreq1()"),'id':("isApplicable"),'value':("Applicable")],-1)
printHtmlPart(39)
}
printHtmlPart(40)
if(true && (appForm?.isTraditionalKnowledgeApplicable == 'Not applicable')) {
printHtmlPart(41)
invokeTag('radio','g',285,['class':(" radio col-sm-1 isNotApplicable"),'name':("isApplicable"),'checked':("checked"),'onclick':("removetxtreq1()"),'value':("Not applicable")],-1)
printHtmlPart(42)
expressionOut.print(appForm?.isTraditionalKnowledgeApplicable)
printHtmlPart(43)
}
else {
printHtmlPart(41)
invokeTag('radio','g',295,['class':("isNotApplicable radio col-sm-1 "),'name':("isApplicable"),'id':("isNotApplicable"),'onclick':("removetxtreq1()"),'value':("Not applicable")],-1)
printHtmlPart(44)
}
printHtmlPart(45)
invokeTag('textArea','g',307,['class':("width ctrl2 "),'rows':("3"),'txtmaxword100':("1"),'id':("rmvtxtreq"),'placeholder':("Please provide details in 500 words"),'name':("traditionalKnowledgeUsedInInvention"),'value':(appForm?.traditionalKnowledgeUsedInInvention)],-1)
printHtmlPart(46)
invokeTag('hiddenField','g',309,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(47)
invokeTag('hiddenField','g',311,['name':("formType"),'value':(formType)],-1)
printHtmlPart(48)
})
invokeTag('form','g',312,['class':("form-horizontal"),'role':("form"),'name':("tradDetails"),'action':("saveTradionalKnowledge"),'autocomplete':("off")],2)
printHtmlPart(49)
invokeTag('render','g',323,['template':("/applicationManagement/geoLocationOfCommunityForm"),'model':([appForm:appForm,formType:formType])],-1)
printHtmlPart(50)
if(true && (listOfCommunityLocations)) {
printHtmlPart(11)
invokeTag('render','g',329,['template':("/applicationManagement/geoLocationOfCommunity"),'model':([listOfCommunityLocations:listOfCommunityLocations,formType:formType,appForm:appForm])],-1)
printHtmlPart(12)
}
printHtmlPart(51)
createTagBody(2, {->
printHtmlPart(14)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(52)
invokeTag('textArea','g',363,['class':("width txtreq ctrl4"),'name':("detailsOfInstitute"),'placeholder':("Provide the name and contact details of the institution / organisation"),'id':("detailsOfInstitute"),'value':(appForm?.detailsOfInstitute)],-1)
printHtmlPart(53)
invokeTag('textArea','g',382,['class':("width ctrl4 "),'txtreq1':("1"),'rows':("4"),'txtmaxword100':("1"),'onkeyup':("txtareawordcount(this)"),'PlaceHolder':("Provide the details in 500 words"),'name':("benefitsToTheApplicant"),'value':(appForm?.benefitsToTheApplicant)],-1)
printHtmlPart(54)
invokeTag('hiddenField','g',389,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(32)
invokeTag('hiddenField','g',389,['name':("formType"),'value':(formType)],-1)
printHtmlPart(32)
invokeTag('hiddenField','g',391,['name':("isNoForTraditional"),'id':("isNoForTraditional")],-1)
printHtmlPart(55)
})
invokeTag('form','g',402,['class':("form-horizontal"),'role':("form"),'autocomplete':("off"),'action':("saveInstituteDetails")],2)
printHtmlPart(56)
createClosureForHtmlPart(57, 2)
invokeTag('link','g',405,['controller':("form3"),'action':("part2"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn btn-primary ")],2)
printHtmlPart(58)
invokeTag('set','g',407,['var':("ListId1"),'value':(listOfLocations?.bioResource?.scientificName)],-1)
printHtmlPart(59)
invokeTag('set','g',411,['var':("ListId2"),'value':(newList?.scientificName)],-1)
printHtmlPart(58)
if(true && ((appForm?.isDeclarationDigitallySigned == 'true' || appForm?.isDeclarationDigitallySigned == 'notDigital') && ListId1?.size() != 0 && (ListId1).containsAll(ListId2) == true)) {
printHtmlPart(12)
createClosureForHtmlPart(60, 3)
invokeTag('link','g',423,['controller':("applicationManagement"),'action':("form1Part5"),'class':("btn btn-primary pull-right"),'method':("POST"),'params':([appFormId:appForm?.id,formType:formType,declaration:"declaration",csrfPreventionSalt:"${csrfPreventionSalt}" ])],3)
printHtmlPart(59)
}
else if(true && ((!appForm?.isDeclarationDigitallySigned || appForm?.isDeclarationDigitallySigned == null) && (ListId1).containsAll(ListId2) == true)) {
printHtmlPart(12)
createClosureForHtmlPart(60, 3)
invokeTag('link','g',443,['controller':("applicationManagement"),'action':("form1Part5"),'class':("btn btn-primary pull-right"),'method':("POST"),'params':([appFormId:appForm?.id,formType:formType,declaration:"declaration",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(59)
}
else if(true && ((ListId1).containsAll(ListId2) == false)) {
printHtmlPart(61)
}
else {
printHtmlPart(62)
}
printHtmlPart(63)
})
invokeTag('captureBody','sitemesh',452,[:],1)
printHtmlPart(64)
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
