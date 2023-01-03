import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formReviewPdfs_formRemarkBLegalPdfGenerator_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formReviewPdfs/_formRemarkBLegalPdfGenerator.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',22,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=ISO-8859-1")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',23,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',24,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',24,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',38,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(4)
expressionOut.print(formDetails?.submittedOn)
printHtmlPart(5)
expressionOut.print(formDetails?.appNumber)
printHtmlPart(6)
expressionOut.print(formRemkInstance?.appFormCatgRmk)
printHtmlPart(7)
if(true && (formDetails?.individualProfiles)) {
printHtmlPart(8)
for( individualProfile in (formDetails?.individualProfiles) ) {
printHtmlPart(9)
expressionOut.print(individualProfile?.title)
printHtmlPart(10)
expressionOut.print(individualProfile?.firstName)
printHtmlPart(10)
expressionOut.print(individualProfile?.middleName)
printHtmlPart(10)
expressionOut.print(individualProfile?.lastName)
printHtmlPart(10)
expressionOut.print(individualProfile?.address1)
printHtmlPart(10)
expressionOut.print(individualProfile?.address2)
printHtmlPart(10)
expressionOut.print(individualProfile?.address3)
printHtmlPart(10)
expressionOut.print(individualProfile?.city)
printHtmlPart(10)
invokeTag('set','g',93,['value':(individualProfile?.nationality),'var':("nationality")],-1)
printHtmlPart(8)
}
printHtmlPart(11)
}
else if(true && (formDetails?.companyProfiles)) {
printHtmlPart(8)
loop:{
int k = 0
for( company in (formDetails?.companyProfiles) ) {
printHtmlPart(10)
expressionOut.print(company?.entityName)
printHtmlPart(12)
invokeTag('set','g',99,['value':(company?.nationality),'var':("nationality")],-1)
printHtmlPart(8)
k++
}
}
printHtmlPart(11)
}
else if(true && (formDetails?.indianResearcher)) {
printHtmlPart(8)
for( researcher in (formDetails?.indianResearcher) ) {
printHtmlPart(9)
expressionOut.print(researcher?.title)
printHtmlPart(10)
expressionOut.print(researcher?.firstName)
printHtmlPart(10)
expressionOut.print(researcher?.middleName)
printHtmlPart(10)
expressionOut.print(researcher?.lastName)
printHtmlPart(10)
expressionOut.print(researcher?.address1)
printHtmlPart(10)
expressionOut.print(researcher?.address2)
printHtmlPart(10)
expressionOut.print(researcher?.address3)
printHtmlPart(10)
expressionOut.print(researcher?.presentCity)
printHtmlPart(13)
invokeTag('set','g',113,['value':(researcher?.nationality),'var':("nationality")],-1)
printHtmlPart(8)
}
printHtmlPart(11)
}
else if(true && (formDetails?.depostionOfMicroOrganism)) {
printHtmlPart(8)
for( depost in (formDetails?.depostionOfMicroOrganism) ) {
printHtmlPart(10)
expressionOut.print(depost?.nameOfDepositor)
printHtmlPart(10)
expressionOut.print(depost?.address1)
printHtmlPart(10)
expressionOut.print(depost?.address2)
printHtmlPart(10)
expressionOut.print(depost?.address3)
printHtmlPart(10)
expressionOut.print(depost?.city)
printHtmlPart(13)
invokeTag('set','g',123,['value':(depost?.nationality),'var':("nationality")],-1)
printHtmlPart(8)
}
printHtmlPart(11)
}
else if(true && (formDetails?.indianGovtInst)) {
printHtmlPart(8)
for( govt in (formDetails?.indianGovtInst) ) {
printHtmlPart(10)
expressionOut.print(govt?.govtInstName)
printHtmlPart(10)
expressionOut.print(govt?.address1)
printHtmlPart(10)
expressionOut.print(govt?.address2)
printHtmlPart(10)
expressionOut.print(govt?.address3)
printHtmlPart(10)
expressionOut.print(govt?.presentCity)
printHtmlPart(10)
invokeTag('set','g',132,['value':("Indian"),'var':("nationality")],-1)
printHtmlPart(8)
}
printHtmlPart(11)
}
printHtmlPart(14)
expressionOut.print(formRemkInstance?.applicantNameContRmk)
printHtmlPart(15)
expressionOut.print(nationality)
printHtmlPart(14)
expressionOut.print(formRemkInstance?.appltnationality)
printHtmlPart(16)
if(true && (formRemkInstance?.prescribedApplication == true)) {
printHtmlPart(17)
}
else if(true && (formRemkInstance?.prescribedApplication == false)) {
printHtmlPart(18)
}
else if(true && (formRemkInstance?.prescribedApplication == '' || formRemkInstance?.prescribedApplication == null)) {
printHtmlPart(19)
}
printHtmlPart(20)
expressionOut.print(formRemkInstance?.whetherPrescriedRmk)
printHtmlPart(21)
expressionOut.print(indianInst?.name)
printHtmlPart(22)
expressionOut.print(indianInst?.address1)
printHtmlPart(23)
expressionOut.print(indianInst?.address2)
printHtmlPart(24)
expressionOut.print(indianInst?.address3)
printHtmlPart(24)
expressionOut.print(indianInst?.city)
printHtmlPart(25)
expressionOut.print(indianInst?.pincode)
printHtmlPart(23)
expressionOut.print(indianInst?.state)
printHtmlPart(24)
expressionOut.print(indianInst?.country)
printHtmlPart(26)
expressionOut.print(indianInst?.phone)
printHtmlPart(27)
expressionOut.print(indianInst?.fax)
printHtmlPart(28)
expressionOut.print(indianInst?.email)
printHtmlPart(29)
expressionOut.print(formRemkInstance?.indinstitueRemk)
printHtmlPart(30)
expressionOut.print(superVisor?.name)
printHtmlPart(31)
expressionOut.print(superVisor?.address1)
printHtmlPart(23)
expressionOut.print(superVisor?.address2)
printHtmlPart(24)
expressionOut.print(superVisor?.address3)
printHtmlPart(24)
expressionOut.print(superVisor?.city)
printHtmlPart(25)
expressionOut.print(superVisor?.pincode)
printHtmlPart(23)
expressionOut.print(superVisor?.state)
printHtmlPart(24)
expressionOut.print(superVisor?.country)
printHtmlPart(26)
expressionOut.print(superVisor?.phone)
printHtmlPart(27)
expressionOut.print(superVisor?.fax)
printHtmlPart(28)
expressionOut.print(superVisor?.email)
printHtmlPart(32)
expressionOut.print(formRemkInstance?.headSuperRemk)
printHtmlPart(33)
if(true && (formDetails?.formBFundingAgency)) {
printHtmlPart(31)
for( fund in (formDetails?.formBFundingAgency) ) {
printHtmlPart(31)
expressionOut.print(fund?.institutionOrganizationName)
printHtmlPart(31)
}
printHtmlPart(31)
}
printHtmlPart(34)
expressionOut.print(formRemkInstance?.fundingRemk)
printHtmlPart(35)
if(true && (formRemkInstance?.letterBoardChk == '' || formRemkInstance?.letterBoardChk == null)) {
printHtmlPart(36)
}
printHtmlPart(37)
if(true && (formRemkInstance?.letterBoardChk == "true")) {
printHtmlPart(38)
}
printHtmlPart(37)
if(true && (formRemkInstance?.letterBoardChk == "false")) {
printHtmlPart(39)
}
printHtmlPart(40)
expressionOut.print(formRemkInstance?.letterBoardRemark)
printHtmlPart(41)
expressionOut.print(formDetails?.emergencyDetails)
printHtmlPart(34)
expressionOut.print(formRemkInstance?.emergencyRemk)
printHtmlPart(42)
if(true && (formRemkInstance?.orderChk == '' || formRemkInstance?.orderChk == null)) {
printHtmlPart(43)
}
printHtmlPart(44)
if(true && (formRemkInstance?.orderChk == "true")) {
printHtmlPart(45)
}
printHtmlPart(44)
if(true && (formRemkInstance?.orderChk == "false")) {
printHtmlPart(46)
}
printHtmlPart(47)
expressionOut.print(formRemkInstance?.orderRemark)
printHtmlPart(48)
})
invokeTag('captureBody','sitemesh',263,[:],1)
printHtmlPart(49)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1671616474376L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
