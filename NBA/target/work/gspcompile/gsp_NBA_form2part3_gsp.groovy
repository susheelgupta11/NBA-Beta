import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_form2part3_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/form2/part3.gsp" }
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
invokeTag('captureHead','sitemesh',25,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(tabStatus)
printHtmlPart(6)
})
invokeTag('javascript','g',30,[:],2)
printHtmlPart(7)
invokeTag('render','g',38,['template':("/applicationManagement/leftTabs"),'model':([formType:formType])],-1)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(10)
if(true && (appForm?.nature == 'Oral')) {
printHtmlPart(11)
invokeTag('radio','g',81,['onclick':("checkRadio_checked()"),'class':("istradditional radio col-sm-1"),'name':("tradditional"),'checked':("checked"),'value':("Oral")],-1)
printHtmlPart(12)
expressionOut.print(appForm?.nature)
printHtmlPart(13)
}
else {
printHtmlPart(11)
invokeTag('radio','g',87,['onclick':("checkRadio_checked()"),'class':("istradditional radio col-sm-1"),'name':("tradditional"),'value':("Oral")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (appForm?.nature == 'Document')) {
printHtmlPart(11)
invokeTag('radio','g',95,['onclick':("checkRadio_checked()"),'class':("istradditional radio col-sm-1"),'name':("tradditional"),'checked':("checked"),'value':("Document")],-1)
printHtmlPart(12)
expressionOut.print(appForm?.nature)
printHtmlPart(16)
}
else {
printHtmlPart(11)
invokeTag('radio','g',102,['onclick':("checkRadio_checked()"),'class':("istradditional radio col-sm-1"),'name':("tradditional"),'value':("Document")],-1)
printHtmlPart(17)
}
printHtmlPart(15)
if(true && (appForm.isNoForTraditional == 'No')) {
printHtmlPart(11)
invokeTag('radio','g',111,['onclick':("checkRadio_checked()"),'class':("istradditional radio col-sm-1"),'name':("tradditional"),'checked':("checked"),'value':("No")],-1)
printHtmlPart(18)
expressionOut.print(appForm.isNoForTraditional)
printHtmlPart(19)
}
else {
printHtmlPart(11)
invokeTag('radio','g',120,['onclick':("checkRadio_checked()"),'class':("istradditional radio col-sm-1"),'name':("tradditional"),'value':("No")],-1)
printHtmlPart(20)
}
printHtmlPart(21)
invokeTag('textArea','g',130,['rows':("4"),'class':("width controlclass"),'PlaceHolder':("Provide details such as, nature of knowledge,if it is oral or source of knowledge, if documented not exceeding 500 words."),'name':("traditionalKnowledgeDesc"),'txtreq1':("1"),'txtmaxword100':("1"),'value':(appForm?.traditionalKnowledgeDesc)],-1)
printHtmlPart(22)
invokeTag('hiddenField','g',134,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(23)
invokeTag('hiddenField','g',135,['name':("formType"),'value':(formType)],-1)
printHtmlPart(24)
})
invokeTag('form','g',138,['controller':("applicationManagement"),'autocomplete':("off"),'action':("saveDetailedTraditionalKnowledge")],2)
printHtmlPart(25)
invokeTag('render','g',156,['template':("/applicationManagement/geoLocationOfCommunityForm"),'model':([appForm:appForm,listOfStates:listOfStates])],-1)
printHtmlPart(26)
if(true && (listOfCommunityLocations)) {
printHtmlPart(27)
invokeTag('render','g',166,['template':("/applicationManagement/geoLocationOfCommunity"),'model':([listOfCommunityLocations:listOfCommunityLocations,appForm:appForm])],-1)
printHtmlPart(28)
}
printHtmlPart(29)
createTagBody(2, {->
printHtmlPart(30)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(31)
invokeTag('textArea','g',192,['class':("width txtreq controlRD txtmaxword100"),'name':("detailsOfInstitute"),'id':("detailsOfInstitute"),'value':(appForm?.detailsOfInstitute)],-1)
printHtmlPart(32)
if(true && (appForm?.bonafideLetter)) {
printHtmlPart(33)
if(true && (flash.message)) {
printHtmlPart(34)
expressionOut.print(flash.message)
printHtmlPart(35)
}
else {
printHtmlPart(36)
createTagBody(5, {->
printHtmlPart(37)
expressionOut.print(appForm?.bonafideLetterName)
printHtmlPart(36)
})
invokeTag('link','g',217,['controller':("form2"),'action':("showDc"),'id':(appForm?.id),'target':("_blank"),'params':([filename: "bonafideLetterName", dataName: "bonafideLetterName",csrfPreventionSalt:"${csrfPreventionSalt}"])],5)
printHtmlPart(38)
}
printHtmlPart(39)
}
else {
printHtmlPart(33)
if(true && (flash.message)) {
printHtmlPart(34)
expressionOut.print(flash.message)
printHtmlPart(35)
}
printHtmlPart(39)
}
printHtmlPart(40)
invokeTag('hiddenField','g',232,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(41)
invokeTag('hiddenField','g',233,['id':("isNoForTraditional"),'name':("isNoForTraditional")],-1)
printHtmlPart(41)
invokeTag('hiddenField','g',234,['name':("formType"),'value':(formType)],-1)
printHtmlPart(42)
})
invokeTag('uploadForm','g',237,['action':("savePart3"),'class':("form-horizontal"),'role':("form"),'autocomplete':("off")],2)
printHtmlPart(43)
createClosureForHtmlPart(44, 2)
invokeTag('link','g',246,['controller':("form2"),'action':("part2"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn btn-primary pull-left")],2)
printHtmlPart(28)
createClosureForHtmlPart(45, 2)
invokeTag('link','g',250,['controller':("form2"),'action':("part4"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn btn-primary pull-right")],2)
printHtmlPart(46)
})
invokeTag('captureBody','sitemesh',253,[:],1)
printHtmlPart(47)
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
