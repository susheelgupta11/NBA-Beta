import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_rightPane_part4_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/rightPane/_part4.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (formDetails?.instituteParticipation == 'true')) {
printHtmlPart(1)
}
else {
printHtmlPart(2)
}
printHtmlPart(3)
if(true && (formDetails?.instituteParticipation == 'true')) {
printHtmlPart(4)
if(true && (formDetails?.instituteParticipation == 'true')) {
printHtmlPart(5)
expressionOut.print(formDetails?.detailsOfInstitute)
printHtmlPart(6)
}
else {
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (formDetails?.letterOfintent)) {
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(10)
expressionOut.print(formDetails?.letterOfIntentName)
printHtmlPart(9)
})
invokeTag('link','g',51,['controller':("applicationManagement"),'action':("showAppDc"),'id':(formDetails?.id),'target':("_blank"),'params':([filename: "letterOfIntentName", dataName: "letterOfIntentName",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(11)
}
else {
printHtmlPart(12)
}
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (formDetails?.isBenefitSharing?.equals('true'))) {
printHtmlPart(15)
}
else if(true && (formDetails?.isBenefitSharing?.equals('false'))) {
printHtmlPart(16)
}
else {
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (formDetails?.isBenefitSharing?.equals('true'))) {
printHtmlPart(19)
if(true && (formDetails?.sharingDoc)) {
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(10)
expressionOut.print(formDetails?.sharingDocName)
printHtmlPart(9)
})
invokeTag('link','g',110,['controller':("applicationManagement"),'action':("showAppDc"),'id':(formDetails?.id),'target':("_blank"),'params':([filename: "sharingDocName", dataName: "sharingDocName",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(20)
}
else {
printHtmlPart(21)
}
printHtmlPart(22)
}
printHtmlPart(23)
if(true && (formDetails?.companyProfiles?.size() != 0)) {
printHtmlPart(24)
if(true && (formDetails?.payBenefitSharing == 'Monetary')) {
printHtmlPart(25)
}
else if(true && (formDetails?.payBenefitSharing == 'Non-Monetary')) {
printHtmlPart(26)
}
else {
printHtmlPart(27)
}
printHtmlPart(28)
if(true && (formDetails?.isMonetary == 'purchasePrice')) {
printHtmlPart(29)
}
else if(true && (formDetails?.isMonetary == 'exFactorySale')) {
printHtmlPart(30)
}
else {
printHtmlPart(27)
}
printHtmlPart(31)
}
printHtmlPart(32)
if(true && (formDetails?.otherInfo)) {
printHtmlPart(33)
expressionOut.print(formDetails?.otherInfo)
printHtmlPart(34)
}
else {
printHtmlPart(35)
}
printHtmlPart(36)
if(true && (formDetails?.isTradingPurpose?.equals('true'))) {
printHtmlPart(37)
if(true && (formDetails?.biologicalResources)) {
printHtmlPart(20)

int i=1

printHtmlPart(20)
for( bioResource in (formDetails?.biologicalResources) ) {
printHtmlPart(38)
out.print(i)
printHtmlPart(39)

i++

printHtmlPart(40)
expressionOut.print(bioResource?.accessIntention)
printHtmlPart(41)
if(true && (bioResource?.accessIntention == 'Biological Resources' || bioResource?.accessIntention == 'Biological Resources & Traditional Knowledge' || bioResource?.accessIntention == 'Associated Knowledge')) {
printHtmlPart(42)
expressionOut.print(bioResource?.commonName)
printHtmlPart(43)
expressionOut.print(bioResource?.scientificName)
printHtmlPart(43)
expressionOut.print(bioResource?.nature)
printHtmlPart(43)
expressionOut.print(bioResource?.biologicalResource)
printHtmlPart(44)
}
else {
printHtmlPart(45)
}
printHtmlPart(46)
if(true && (bioResource?.accessIntention == 'Biological Resources' || bioResource?.accessIntention == 'Biological Resources & Traditional Knowledge' || bioResource?.accessIntention == 'Associated Knowledge')) {
printHtmlPart(47)
expressionOut.print(bioResource?.quantity)
printHtmlPart(48)
expressionOut.print(bioResource?.qtyUnit)
printHtmlPart(49)
}
else {
printHtmlPart(50)
}
printHtmlPart(51)
expressionOut.print(bioResource?.ratePerUnit)
printHtmlPart(52)
expressionOut.print(bioResource?.stateBiodeversityBoard)
printHtmlPart(53)
expressionOut.print(bioResource?.prospectiveBuyers)
printHtmlPart(54)
}
}
else {
printHtmlPart(55)
}
printHtmlPart(56)
if(true && (formDetails?.conditionOfAbs == true)) {
printHtmlPart(57)
}
printHtmlPart(6)
if(true && (formDetails?.infromationTrue == true)) {
printHtmlPart(58)
}
else {
printHtmlPart(59)
}
printHtmlPart(60)
if(true && (formDetails?.approvalOfNba == true)) {
printHtmlPart(61)
}
printHtmlPart(6)
if(true && (formDetails?.recordsWithTheNba == true)) {
printHtmlPart(62)
}
printHtmlPart(6)
if(true && (formDetails?.infromationTrue == true)) {
printHtmlPart(63)
}
printHtmlPart(64)
}
printHtmlPart(65)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1616580952704L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
