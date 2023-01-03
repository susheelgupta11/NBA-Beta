import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagement_biologicalResourcesGrid_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/_biologicalResourcesGrid.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (formType == 'Form1')) {
printHtmlPart(1)
}
else if(true && (formType == 'Form3')) {
printHtmlPart(2)
}
else if(true && (formType == 'Form2' || formType == 'Form4')) {
printHtmlPart(3)
}
printHtmlPart(4)
if(true && (formType == 'Form1' && formType != 'Form4')) {
printHtmlPart(5)
}
printHtmlPart(6)
if(true && (formType == 'Form1' && formType !='Form4' && formType != 'Form2')) {
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (listOfBioResources)) {
printHtmlPart(9)

int i=1

printHtmlPart(9)
for( bioResource in (listOfBioResources) ) {
printHtmlPart(10)
out.print(i)
printHtmlPart(11)

i++

printHtmlPart(12)
expressionOut.print(bioResource?.accessIntention)
printHtmlPart(11)
if(true && (bioResource?.accessIntention == 'Biological Resources' || bioResource?.accessIntention == 'Biological Resources & Traditional Knowledge' || bioResource?.accessIntention == 'Associated Knowledge')) {
printHtmlPart(13)
expressionOut.print(bioResource?.commonName)
printHtmlPart(14)
expressionOut.print(bioResource?.scientificName)
printHtmlPart(14)
expressionOut.print(bioResource?.nature)
printHtmlPart(14)
expressionOut.print(bioResource?.biologicalResource)
printHtmlPart(15)
}
else {
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (formType == 'Form1' && formType != 'Form4')) {
printHtmlPart(18)
if(true && (bioResource?.accessIntention == 'Biological Resources' || bioResource?.accessIntention == 'Biological Resources & Traditional Knowledge' || bioResource?.accessIntention == 'Associated Knowledge')) {
printHtmlPart(19)
expressionOut.print(bioResource?.quantity)
printHtmlPart(20)
expressionOut.print(bioResource?.qtyUnit)
printHtmlPart(21)
}
else {
printHtmlPart(22)
}
printHtmlPart(23)
}
printHtmlPart(23)
if(true && (formType == 'Form1')) {
printHtmlPart(13)
expressionOut.print(bioResource?.fromTime?.format('dd/MM/yyyy'))
printHtmlPart(24)
expressionOut.print(bioResource?.toTime?.format('dd/MM/yyyy'))
printHtmlPart(25)
expressionOut.print(bioResource?.traditionalUse)
printHtmlPart(26)
}
printHtmlPart(27)
createClosureForHtmlPart(28, 3)
invokeTag('remoteLink','g',97,['controller':("applicationManagement"),'onSuccess':("showhidewithvalidation_edit()"),'onComplete':("hideShowOnEdit()"),'action':("editForm1Part2"),'update':("AddUpdateDetails"),'params':([bioResource:bioResource?.id,formType:formType,appFormID:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(20)
createClosureForHtmlPart(29, 3)
invokeTag('remoteLink','g',102,['controller':("applicationManagement"),'action':("deleteBioProfile"),'onSuccess':("loadPage()"),'update':("updateBioResources"),'params':([bioResourceID:bioResource?.id,formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(30)
}
printHtmlPart(31)
}
else {
printHtmlPart(32)
}
printHtmlPart(33)
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
