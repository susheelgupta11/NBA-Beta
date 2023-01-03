import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagementform1Part3_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/form1Part3.gsp" }
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
invokeTag('captureHead','sitemesh',24,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(appForm?.id)
printHtmlPart(6)
expressionOut.print(tabStatus)
printHtmlPart(7)
})
invokeTag('javascript','g',30,[:],2)
printHtmlPart(8)
invokeTag('render','g',35,['template':("leftTabs"),'model':([formType:formType])],-1)
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(11)
if(true && (appForm?.nature == 'Oral')) {
printHtmlPart(12)
invokeTag('radio','g',83,['onclick':("checkRadio_checked()"),'class':("istradditional radio col-sm-1"),'name':("tradditional"),'checked':("checked"),'value':("Oral")],-1)
printHtmlPart(13)
expressionOut.print(appForm?.nature)
printHtmlPart(14)
}
else {
printHtmlPart(12)
invokeTag('radio','g',91,['onclick':("checkRadio_checked()"),'class':("istradditional radio col-sm-1"),'name':("tradditional"),'value':("Oral")],-1)
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (appForm?.nature == 'Document')) {
printHtmlPart(12)
invokeTag('radio','g',95,['onclick':("checkRadio_checked()"),'class':("istradditional radio col-sm-1"),'name':("tradditional"),'checked':("checked"),'value':("Document")],-1)
printHtmlPart(13)
expressionOut.print(appForm?.nature)
printHtmlPart(17)
}
else {
printHtmlPart(12)
invokeTag('radio','g',102,['onclick':("checkRadio_checked()"),'class':("istradditional radio col-sm-1"),'name':("tradditional"),'value':("Document")],-1)
printHtmlPart(18)
}
printHtmlPart(16)
if(true && (appForm?.nature == 'No')) {
printHtmlPart(12)
invokeTag('radio','g',108,['onclick':("checkRadio_checked()"),'class':("istradditional radio col-sm-1"),'name':("tradditional"),'checked':("checked"),'value':("No")],-1)
printHtmlPart(19)
expressionOut.print(appForm?.nature)
printHtmlPart(20)
}
else {
printHtmlPart(12)
invokeTag('radio','g',118,['onclick':("checkRadio_checked()"),'class':("istradditional radio col-sm-1"),'name':("tradditional"),'value':("No")],-1)
printHtmlPart(21)
}
printHtmlPart(22)
invokeTag('textArea','g',129,['rows':("4"),'class':("width controlclass"),'PlaceHolder':("Provide details such as, nature of knowledge,if it is oral or source of knowledge, if documented not exceeding 500 words."),'name':("traditionalKnowledgeDesc"),'txtreq1':("1"),'txtmaxword100':("1"),'value':(appForm?.traditionalKnowledgeDesc)],-1)
printHtmlPart(23)
invokeTag('hiddenField','g',135,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(24)
invokeTag('hiddenField','g',136,['name':("formType"),'value':(formType)],-1)
printHtmlPart(25)
})
invokeTag('form','g',137,['controller':("applicationManagement"),'action':("saveDetailedTraditionalKnowledge"),'autocomplete':("off")],2)
printHtmlPart(26)
invokeTag('render','g',145,['template':("geoLocationOfCommunityForm"),'model':([appForm:appForm,listOfStates:listOfStates])],-1)
printHtmlPart(27)
if(true && (appForm?.isNoForTraditional != 'No' && listOfCommunityLocations)) {
printHtmlPart(28)
invokeTag('render','g',160,['template':("geoLocationOfCommunity"),'model':([listOfCommunityLocations:listOfCommunityLocations,appForm:appForm])],-1)
printHtmlPart(29)
}
printHtmlPart(30)
invokeTag('render','g',168,['template':("form1part3"),'model':([appForm:appForm])],-1)
printHtmlPart(31)
if(true && (listOfContactPerson)) {
printHtmlPart(28)
invokeTag('render','g',175,['template':("authorizedPersonGrid"),'model':([listOfContactPerson:listOfContactPerson,appForm:appForm])],-1)
printHtmlPart(29)
}
printHtmlPart(32)
createTagBody(2, {->
printHtmlPart(10)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(33)
for( purpose in (purposeList) ) {
printHtmlPart(34)
if(true && (appForm?.purposeOfProposal == purpose)) {
printHtmlPart(35)
invokeTag('radio','g',211,['name':("purpose"),'value':(purpose),'checked':("checked")],-1)
printHtmlPart(36)
expressionOut.print(purpose)
printHtmlPart(37)
}
else {
printHtmlPart(35)
invokeTag('radio','g',214,['name':("purpose"),'value':(purpose)],-1)
printHtmlPart(36)
expressionOut.print(purpose)
printHtmlPart(37)
}
printHtmlPart(24)
}
printHtmlPart(38)
invokeTag('textArea','g',235,['class':(" width txtlastvalid"),'onkeyup':("TextareaValidataion(this)"),'rows':("4"),'txtreq1':("1"),'txtmaxword100':("1"),'placeHolder':("Details in 500 words"),'name':("briefDescription"),'value':(appForm?.briefDescription)],-1)
printHtmlPart(39)
if(true && (!appForm?.isRisky)) {
printHtmlPart(34)
invokeTag('radio','g',243,['name':("isRisky"),'checkattr':("true"),'value':("Yes"),'class':("left radiobtn yes")],-1)
printHtmlPart(40)
invokeTag('radio','g',246,['name':("isRisky"),'value':("No"),'checkattr':("false"),'class':("radiobtn no")],-1)
printHtmlPart(41)
}
else {
printHtmlPart(24)
if(true && (appForm?.isRisky == 'true')) {
printHtmlPart(24)
invokeTag('radio','g',252,['name':("isRisky"),'checkattr':("true"),'checked':("checked"),'value':("Yes"),'class':("left radiobtn yes")],-1)
printHtmlPart(42)
}
else {
printHtmlPart(34)
invokeTag('radio','g',256,['name':("isRisky"),'checkattr':("true"),'value':("Yes"),'class':("left radiobtn yes")],-1)
printHtmlPart(42)
}
printHtmlPart(43)
if(true && (appForm?.isRisky == 'false')) {
printHtmlPart(34)
invokeTag('radio','g',261,['name':("isRisky"),'value':("No"),'checkattr':("false"),'checked':("checked"),'class':("radiobtn no")],-1)
printHtmlPart(44)
}
else {
printHtmlPart(34)
invokeTag('radio','g',267,['name':("isRisky"),'value':("No"),'checkattr':("false"),'class':("radiobtn no")],-1)
printHtmlPart(44)
}
printHtmlPart(45)
}
printHtmlPart(46)
invokeTag('textArea','g',277,['class':("txtlastvalid width txtremovevalidate"),'txtmaxword100':("1"),'name':("riskInvolved"),'placeHolder':("Details in 500 words"),'value':(appForm?.riskInvolved)],-1)
printHtmlPart(47)
invokeTag('hiddenField','g',282,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(24)
invokeTag('hiddenField','g',283,['name':("formType"),'value':(formType)],-1)
printHtmlPart(24)
invokeTag('hiddenField','g',286,['id':("selfForAuthorized"),'name':("selfForAuthorized")],-1)
printHtmlPart(48)
})
invokeTag('form','g',294,['name':("saveForm3"),'controller':("applicationManagement"),'action':("saveForm3"),'autocomplete':("off")],2)
printHtmlPart(49)
createClosureForHtmlPart(50, 2)
invokeTag('link','g',302,['controller':("applicationManagement"),'action':("form1Part2"),'class':("btn btn-primary "),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(51)
createClosureForHtmlPart(52, 2)
invokeTag('link','g',306,['controller':("applicationManagement"),'action':("form1Part4"),'onclick':("checkRadio_checked()"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn btn-primary pull-right "),'method':("POST")],2)
printHtmlPart(53)
})
invokeTag('captureBody','sitemesh',307,[:],1)
printHtmlPart(54)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1616571845142L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
