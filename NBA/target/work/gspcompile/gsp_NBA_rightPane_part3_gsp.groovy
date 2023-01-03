import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_rightPane_part3_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/rightPane/_part3.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(formDetails?.nature)
printHtmlPart(1)
if(true && (formDetails?.nature != 'No')) {
printHtmlPart(2)
expressionOut.print(formDetails?.traditionalKnowledgeDesc)
printHtmlPart(1)
}
printHtmlPart(3)
if(true && (formDetails?.nature == 'No')) {
printHtmlPart(4)
expressionOut.print(formDetails?.nature)
printHtmlPart(1)
}
printHtmlPart(5)
if(true && (formDetails?.nature != 'No')) {
printHtmlPart(6)
if(true && (allDataforMatching?.listOfCommunityLocations)) {
printHtmlPart(7)
if(true && (allDataforMatching?.listOfCommunityLocations)) {
printHtmlPart(8)

int a=1

printHtmlPart(8)
for( location in (allDataforMatching?.listOfCommunityLocations) ) {
printHtmlPart(9)
out.print(a)
printHtmlPart(10)

a++

printHtmlPart(11)
expressionOut.print(location?.communityKnowledge)
printHtmlPart(12)
expressionOut.print(location?.village)
printHtmlPart(13)
expressionOut.print(location?.town)
printHtmlPart(14)
expressionOut.print(location?.district)
printHtmlPart(13)
expressionOut.print(State?.findById(location?.state)?.state)
printHtmlPart(15)
}
printHtmlPart(16)
}
printHtmlPart(17)
}
printHtmlPart(18)
}
printHtmlPart(19)
if(true && (formDetails?.selfAuthorizedPerson)) {
printHtmlPart(20)
}
else {
printHtmlPart(21)
}
printHtmlPart(22)
if(true && (!formDetails?.selfAuthorizedPerson)) {
printHtmlPart(23)
if(true && (allDataforMatching?.listOfContactPerson)) {
printHtmlPart(24)

int b=1

printHtmlPart(25)
for( profile in (allDataforMatching?.listOfContactPerson) ) {
printHtmlPart(26)
out.print(b)
printHtmlPart(27)

b++

printHtmlPart(28)
expressionOut.print(profile?.nameOfContactPerson)
printHtmlPart(29)
expressionOut.print(profile?.addressOfContactPerson)
printHtmlPart(30)
expressionOut.print(profile?.mobileOfContactPerson)
printHtmlPart(30)
expressionOut.print(profile?.emailOfContactPerson)
printHtmlPart(31)
}
printHtmlPart(32)
}
printHtmlPart(23)
}
printHtmlPart(33)
expressionOut.print(formDetails?.purposeOfProposal)
printHtmlPart(34)
expressionOut.print(formDetails?.briefDescription)
printHtmlPart(35)
if(true && (formDetails?.isRisky == 'true')) {
printHtmlPart(36)
}
else {
printHtmlPart(37)
}
printHtmlPart(38)
if(true && (formDetails?.isRisky == 'true')) {
printHtmlPart(39)
expressionOut.print(formDetails?.riskInvolved)
printHtmlPart(40)
}
printHtmlPart(41)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1604250826000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
