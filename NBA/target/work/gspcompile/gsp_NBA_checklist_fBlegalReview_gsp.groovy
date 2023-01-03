import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_checklist_fBlegalReview_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/checklist/_fBlegalReview.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('textField','g',25,['name':("formCatg"),'class':("remark"),'value':(formRemkInstance?.appFormCatgRmk)],-1)
printHtmlPart(1)
if(true && (formDetails?.individualProfiles)) {
printHtmlPart(2)
for( individualProfile in (formDetails?.individualProfiles) ) {
printHtmlPart(3)
expressionOut.print(individualProfile?.title)
printHtmlPart(4)
expressionOut.print(individualProfile?.firstName)
printHtmlPart(4)
expressionOut.print(individualProfile?.middleName)
printHtmlPart(4)
expressionOut.print(individualProfile?.lastName)
printHtmlPart(4)
expressionOut.print(individualProfile?.address1)
printHtmlPart(4)
expressionOut.print(individualProfile?.address2)
printHtmlPart(4)
expressionOut.print(individualProfile?.address3)
printHtmlPart(4)
expressionOut.print(individualProfile?.city)
printHtmlPart(4)
invokeTag('set','g',46,['value':(individualProfile?.nationality),'var':("nationality")],-1)
printHtmlPart(2)
}
printHtmlPart(5)
}
else if(true && (formDetails?.companyProfiles)) {
printHtmlPart(2)
loop:{
int k = 0
for( company in (formDetails?.companyProfiles) ) {
printHtmlPart(4)
expressionOut.print(company?.entityName)
printHtmlPart(4)
invokeTag('set','g',52,['value':(company?.nationality),'var':("nationality")],-1)
printHtmlPart(2)
k++
}
}
printHtmlPart(5)
}
else if(true && (formDetails?.indianResearcher)) {
printHtmlPart(2)
for( researcher in (formDetails?.indianResearcher) ) {
printHtmlPart(3)
expressionOut.print(researcher?.title)
printHtmlPart(4)
expressionOut.print(researcher?.firstName)
printHtmlPart(4)
expressionOut.print(researcher?.middleName)
printHtmlPart(4)
expressionOut.print(researcher?.lastName)
printHtmlPart(4)
expressionOut.print(researcher?.address1)
printHtmlPart(4)
expressionOut.print(researcher?.address2)
printHtmlPart(4)
expressionOut.print(researcher?.address3)
printHtmlPart(4)
expressionOut.print(researcher?.presentCity)
printHtmlPart(4)
invokeTag('set','g',65,['value':(researcher?.nationality),'var':("nationality")],-1)
printHtmlPart(2)
}
printHtmlPart(5)
}
else if(true && (formDetails?.depostionOfMicroOrganism)) {
printHtmlPart(2)
for( depost in (formDetails?.depostionOfMicroOrganism) ) {
printHtmlPart(4)
expressionOut.print(depost?.nameOfDepositor)
printHtmlPart(4)
expressionOut.print(depost?.address1)
printHtmlPart(4)
expressionOut.print(depost?.address2)
printHtmlPart(4)
expressionOut.print(depost?.address3)
printHtmlPart(4)
expressionOut.print(depost?.city)
printHtmlPart(4)
invokeTag('set','g',74,['value':(depost?.nationality),'var':("nationality")],-1)
printHtmlPart(2)
}
printHtmlPart(5)
}
else if(true && (formDetails?.indianGovtInst)) {
printHtmlPart(2)
for( govt in (formDetails?.indianGovtInst) ) {
printHtmlPart(4)
expressionOut.print(govt?.govtInstName)
printHtmlPart(4)
expressionOut.print(govt?.address1)
printHtmlPart(4)
expressionOut.print(govt?.address2)
printHtmlPart(4)
expressionOut.print(govt?.address3)
printHtmlPart(4)
expressionOut.print(govt?.presentCity)
printHtmlPart(4)
invokeTag('set','g',83,['value':("Indian"),'var':("nationality")],-1)
printHtmlPart(2)
}
printHtmlPart(5)
}
printHtmlPart(6)
invokeTag('textField','g',86,['name':("appltname"),'class':("remark"),'value':(formRemkInstance?.applicantNameContRmk)],-1)
printHtmlPart(7)
expressionOut.print(nationality)
printHtmlPart(8)
invokeTag('textField','g',96,['name':("appltnationality"),'value':(formRemkInstance?.appltnationality),'class':("remark")],-1)
printHtmlPart(9)
if(true && (formRemkInstance?.prescribedApplication == true)) {
printHtmlPart(10)
invokeTag('radio','g',105,['name':("prescribedApplication"),'value':("true"),'checked':("true"),'id':("wheatherYes")],-1)
printHtmlPart(11)
invokeTag('radio','g',106,['name':("prescribedApplication"),'value':("false"),'id':("wheatherNo")],-1)
printHtmlPart(12)
}
else if(true && (formRemkInstance?.prescribedApplication == false)) {
printHtmlPart(10)
invokeTag('radio','g',110,['name':("prescribedApplication"),'value':("true"),'id':("wheatherYes")],-1)
printHtmlPart(11)
invokeTag('radio','g',111,['name':("prescribedApplication"),'checked':("true"),'value':("false"),'id':("wheatherNo")],-1)
printHtmlPart(13)
}
else if(true && (formRemkInstance?.prescribedApplication == '' || formRemkInstance?.prescribedApplication == null)) {
printHtmlPart(10)
invokeTag('radio','g',117,['name':("prescribedApplication"),'value':("true"),'id':("wheatherYes")],-1)
printHtmlPart(11)
invokeTag('radio','g',118,['name':("prescribedApplication"),'value':("false"),'id':("wheatherNo")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
invokeTag('textField','g',122,['name':("whetherPrescriedRmk"),'value':(formRemkInstance?.whetherPrescriedRmk),'class':("remark")],-1)
printHtmlPart(15)
expressionOut.print(indianInst?.name)
printHtmlPart(16)
expressionOut.print(indianInst?.address1)
printHtmlPart(17)
expressionOut.print(indianInst?.address2)
printHtmlPart(18)
expressionOut.print(indianInst?.address3)
printHtmlPart(18)
expressionOut.print(indianInst?.city)
printHtmlPart(19)
expressionOut.print(indianInst?.pincode)
printHtmlPart(17)
expressionOut.print(indianInst?.state)
printHtmlPart(18)
expressionOut.print(indianInst?.country)
printHtmlPart(20)
expressionOut.print(indianInst?.phone)
printHtmlPart(21)
expressionOut.print(indianInst?.fax)
printHtmlPart(22)
expressionOut.print(indianInst?.email)
printHtmlPart(23)
invokeTag('textField','g',141,['name':("indinstitueRemk"),'value':(formRemkInstance?.indinstitueRemk),'class':("remark")],-1)
printHtmlPart(24)
expressionOut.print(superVisor?.name)
printHtmlPart(25)
expressionOut.print(superVisor?.address1)
printHtmlPart(17)
expressionOut.print(superVisor?.address2)
printHtmlPart(18)
expressionOut.print(superVisor?.address3)
printHtmlPart(18)
expressionOut.print(superVisor?.city)
printHtmlPart(19)
expressionOut.print(superVisor?.pincode)
printHtmlPart(17)
expressionOut.print(superVisor?.state)
printHtmlPart(18)
expressionOut.print(superVisor?.country)
printHtmlPart(20)
expressionOut.print(superVisor?.phone)
printHtmlPart(21)
expressionOut.print(superVisor?.fax)
printHtmlPart(22)
expressionOut.print(superVisor?.email)
printHtmlPart(26)
invokeTag('textField','g',157,['name':("headSuperRemk"),'value':(formRemkInstance?.headSuperRemk),'class':("remark")],-1)
printHtmlPart(27)
if(true && (formDetails?.formBFundingAgency)) {
printHtmlPart(25)
for( fund in (formDetails?.formBFundingAgency) ) {
printHtmlPart(25)
expressionOut.print(fund?.institutionOrganizationName)
printHtmlPart(25)
}
printHtmlPart(25)
}
printHtmlPart(28)
invokeTag('textField','g',173,['name':("fundingRemk"),'value':(formRemkInstance?.fundingRemk),'class':("remark")],-1)
printHtmlPart(29)
if(true && (formRemkInstance?.letterBoardChk == '' || formRemkInstance?.letterBoardChk == null)) {
printHtmlPart(30)
}
printHtmlPart(31)
if(true && (formRemkInstance?.letterBoardChk == "true")) {
printHtmlPart(32)
}
printHtmlPart(31)
if(true && (formRemkInstance?.letterBoardChk == "false")) {
printHtmlPart(33)
}
printHtmlPart(34)
invokeTag('textField','g',194,['name':("letterBoardRemark"),'value':(formRemkInstance?.letterBoardRemark),'class':("remark")],-1)
printHtmlPart(35)
expressionOut.print(formDetails?.emergencyDetails)
printHtmlPart(28)
invokeTag('textField','g',205,['name':("emergencyRemk"),'value':(formRemkInstance?.emergencyRemk),'class':("remark")],-1)
printHtmlPart(36)
if(true && (formRemkInstance?.orderChk == '' || formRemkInstance?.orderChk == null)) {
printHtmlPart(37)
}
printHtmlPart(38)
if(true && (formRemkInstance?.orderChk == "true")) {
printHtmlPart(39)
}
printHtmlPart(38)
if(true && (formRemkInstance?.orderChk == "false")) {
printHtmlPart(40)
}
printHtmlPart(41)
invokeTag('textField','g',222,['name':("orderRemark"),'value':(formRemkInstance?.orderRemark),'class':("remark")],-1)
printHtmlPart(42)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1645116121270L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
