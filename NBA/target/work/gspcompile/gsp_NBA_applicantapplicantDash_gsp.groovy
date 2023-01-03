
import org.nba.application.AppStatus


import org.nba.application.FormCategory


import org.nba.user.NbaUser


import org.nba.communication.LetterStatus


import org.nba.communication.LetterType

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicantapplicantDash_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicant/applicantDash.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=ISO-8859-1")],-1)
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("appltDash")],-1)
printHtmlPart(0)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(4)
expressionOut.print(applicationDetails.size()?:0)
printHtmlPart(5)
if(true && (applicationDetails)) {
printHtmlPart(6)

def i= 1

printHtmlPart(6)
for( applicationDetail in (applicationDetails) ) {
printHtmlPart(7)
out.print(i)
printHtmlPart(8)

i++

printHtmlPart(9)
if(true && (applicationDetail?.individualProfiles)) {
printHtmlPart(10)
for( individualProfile in (applicationDetail?.individualProfiles) ) {
printHtmlPart(11)
expressionOut.print(individualProfile?.title)
printHtmlPart(12)
expressionOut.print(individualProfile?.firstName)
printHtmlPart(12)
expressionOut.print(individualProfile?.middleName)
printHtmlPart(12)
expressionOut.print(individualProfile?.lastName)
printHtmlPart(13)
}
printHtmlPart(14)
}
else if(true && (applicationDetail?.companyProfiles)) {
printHtmlPart(13)
loop:{
int k = 0
for( company in (applicationDetail?.companyProfiles) ) {
printHtmlPart(12)
expressionOut.print(company?.entityName)
printHtmlPart(13)
k++
}
}
printHtmlPart(14)
}
else if(true && (applicationDetail?.indianResearcher)) {
printHtmlPart(13)
for( researcher in (applicationDetail?.indianResearcher) ) {
printHtmlPart(11)
expressionOut.print(researcher?.title)
printHtmlPart(12)
expressionOut.print(researcher?.firstName)
printHtmlPart(12)
expressionOut.print(researcher?.middleName)
printHtmlPart(12)
expressionOut.print(researcher?.lastName)
printHtmlPart(15)
}
printHtmlPart(14)
}
else if(true && (applicationDetail?.depostionOfMicroOrganism)) {
printHtmlPart(13)
for( depost in (applicationDetail?.depostionOfMicroOrganism) ) {
printHtmlPart(12)
expressionOut.print(depost?.nameOfDepositor)
printHtmlPart(13)
}
printHtmlPart(14)
}
else if(true && (applicationDetail?.indianGovtInst)) {
printHtmlPart(13)
for( govt in (applicationDetail?.indianGovtInst) ) {
printHtmlPart(12)
expressionOut.print(govt?.govtInstName)
printHtmlPart(13)
}
printHtmlPart(14)
}
printHtmlPart(16)
if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_1)) {
printHtmlPart(17)
invokeTag('set','g',108,['value':("previewForm1Info"),'var':("dyaction")],-1)
printHtmlPart(18)
}
else if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_2)) {
printHtmlPart(13)
invokeTag('set','g',112,['value':("previewForm2Info"),'var':("dyaction")],-1)
printHtmlPart(19)
}
else if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_3)) {
printHtmlPart(13)
invokeTag('set','g',116,['value':("previewForm3Info"),'var':("dyaction")],-1)
printHtmlPart(20)
}
else if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_4)) {
printHtmlPart(13)
invokeTag('set','g',120,['value':("previewForm4Info"),'var':("dyaction")],-1)
printHtmlPart(21)
}
else if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_B)) {
printHtmlPart(13)
invokeTag('set','g',124,['value':("previewFormBInfo"),'var':("dyaction")],-1)
printHtmlPart(22)
}
else if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_C)) {
printHtmlPart(13)
invokeTag('set','g',128,['value':("previewFormCInfo"),'var':("dyaction")],-1)
printHtmlPart(23)
}
printHtmlPart(24)
expressionOut.print(applicationDetail.appNumber)
printHtmlPart(25)
if(true && (applicationDetail.currentStatus?.status)) {
printHtmlPart(13)
expressionOut.print(applicationDetail.currentStatus?.status)
printHtmlPart(14)
}
printHtmlPart(26)
if(true && (applicationDetail?.letterCommunications)) {
printHtmlPart(14)
for( commu in (applicationDetail?.letterCommunications?.last()) ) {
printHtmlPart(14)
if(true && (commu?.letterStatus.ltrstatus == LetterStatus.LtrStatus.LETTER_SEND && commu?.letterType.ltrType != LetterType.LtrType.SBB_LETTER)) {
printHtmlPart(27)
expressionOut.print(commu?.subject)
printHtmlPart(28)
}
printHtmlPart(27)
}
printHtmlPart(27)
}
else {
printHtmlPart(29)
}
printHtmlPart(30)
if(true && (applicationDetail?.letterCommunications?.sort{it.id})) {
printHtmlPart(14)
for( commu in (applicationDetail?.letterCommunications?.last()) ) {
printHtmlPart(14)
if(true && (commu?.letterStatus.ltrstatus == LetterStatus.LtrStatus.LETTER_SEND && commu?.letterType.ltrType != LetterType.LtrType.SBB_LETTER)) {
printHtmlPart(14)
invokeTag('formatDate','g',157,['date':(commu?.sendDate),'format':("dd/MM/yyyy")],-1)
printHtmlPart(31)
}
printHtmlPart(14)
}
printHtmlPart(14)
}
else {
}
printHtmlPart(32)
createClosureForHtmlPart(33, 4)
invokeTag('link','g',175,['controller':("applicant"),'action':("createComment"),'params':([inst:applicationDetail?.id,csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(34)
createClosureForHtmlPart(35, 4)
invokeTag('remoteLink','g',183,['action':("acknowledgementDnld"),'controller':("applicant"),'title':("Check File Status"),'params':([appFormId:applicationDetail?.id,csrfPreventionSalt:csrfPreventionSalt,formType:applicationDetail?.category?.category]),'data-target':("#success"),'data-toggle':("modal"),'update':("nin")],4)
printHtmlPart(36)
if(true && (applicationDetail.currentStatus?.status != AppStatus.Status.SUBMITTED)) {
printHtmlPart(37)
createClosureForHtmlPart(38, 5)
invokeTag('remoteLink','g',190,['action':("fileStatus"),'controller':("applicant"),'title':("Check File Status"),'params':([instance:applicationDetail?.id]),'data-target':("#success"),'data-toggle':("modal"),'update':("nin")],5)
printHtmlPart(39)
}
printHtmlPart(40)
}
printHtmlPart(41)
}
printHtmlPart(42)
expressionOut.print(pendingApplication?.size()?:0)
printHtmlPart(43)
if(true && (pendingApplication)) {
printHtmlPart(44)

def i= 1

printHtmlPart(44)
for( applicationDetail in (pendingApplication) ) {
printHtmlPart(45)
out.print(i)
printHtmlPart(46)

i++

printHtmlPart(47)
if(true && (applicationDetail?.individualProfiles)) {
printHtmlPart(48)
for( individualProfile in (applicationDetail?.individualProfiles) ) {
printHtmlPart(49)
expressionOut.print(individualProfile?.title)
printHtmlPart(50)
expressionOut.print(individualProfile?.firstName)
printHtmlPart(50)
expressionOut.print(individualProfile?.middleName)
printHtmlPart(50)
expressionOut.print(individualProfile?.lastName)
printHtmlPart(51)
}
printHtmlPart(12)
}
else if(true && (applicationDetail?.companyProfiles)) {
printHtmlPart(51)
loop:{
int k = 0
for( company in (applicationDetail?.companyProfiles) ) {
printHtmlPart(50)
expressionOut.print(company?.entityName)
printHtmlPart(51)
k++
}
}
printHtmlPart(12)
}
else if(true && (applicationDetail?.indianResearcher)) {
printHtmlPart(51)
for( researcher in (applicationDetail?.indianResearcher) ) {
printHtmlPart(49)
expressionOut.print(researcher?.title)
printHtmlPart(50)
expressionOut.print(researcher?.firstName)
printHtmlPart(50)
expressionOut.print(researcher?.middleName)
printHtmlPart(50)
expressionOut.print(researcher?.lastName)
printHtmlPart(52)
}
printHtmlPart(12)
}
else if(true && (applicationDetail?.depostionOfMicroOrganism)) {
printHtmlPart(51)
for( depost in (applicationDetail?.depostionOfMicroOrganism) ) {
printHtmlPart(50)
expressionOut.print(depost?.nameOfDepositor)
printHtmlPart(51)
}
printHtmlPart(12)
}
else if(true && (applicationDetail?.indianGovtInst)) {
printHtmlPart(51)
for( govt in (applicationDetail?.indianGovtInst) ) {
printHtmlPart(50)
expressionOut.print(govt?.govtInstName)
printHtmlPart(51)
}
printHtmlPart(12)
}
printHtmlPart(53)
if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_1)) {
printHtmlPart(18)
}
else if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_2)) {
printHtmlPart(19)
}
else if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_3)) {
printHtmlPart(20)
}
else if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_4)) {
printHtmlPart(21)
}
else if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_B)) {
printHtmlPart(22)
}
else if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_C)) {
printHtmlPart(23)
}
printHtmlPart(54)
expressionOut.print(applicationDetail?.appNumber)
printHtmlPart(55)
if(true && (applicationDetail.currentStatus?.status)) {
printHtmlPart(51)
expressionOut.print(applicationDetail.currentStatus?.status)
printHtmlPart(12)
}
printHtmlPart(56)
createClosureForHtmlPart(57, 4)
invokeTag('link','g',345,['controller':("applicant"),'action':("deleteApplication"),'params':([instance:applicationDetail?.id,csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(58)
if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_1 && applicationDetail?.individualProfiles && applicationDetail?.individualProfiles?.size() >=0 &&
(applicationDetail?.currentStatus?.status == AppStatus.Status.PENDING || applicationDetail?.currentStatus?.status == AppStatus.Status.NBA_PENDING ))) {
printHtmlPart(41)
createClosureForHtmlPart(59, 5)
invokeTag('link','g',359,['controller':("applicationManagement"),'action':("individualProfile"),'params':([formType:"Form1",appFormId:applicationDetail?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],5)
printHtmlPart(60)
}
else if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_1 && applicationDetail?.companyProfiles && applicationDetail?.companyProfiles?.size() >=0 && 
 (applicationDetail?.currentStatus?.status == AppStatus.Status.PENDING || applicationDetail?.currentStatus?.status == AppStatus.Status.NBA_PENDING ))) {
printHtmlPart(41)
createClosureForHtmlPart(59, 5)
invokeTag('link','g',367,['controller':("applicationManagement"),'action':("companyProfile"),'params':([formType:"Form1",appFormId:applicationDetail?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],5)
printHtmlPart(61)
}
printHtmlPart(62)
if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_C && applicationDetail?.depostionOfMicroOrganism && applicationDetail?.depostionOfMicroOrganism?.size() >=0 && 
 (applicationDetail?.currentStatus?.status == AppStatus.Status.PENDING || applicationDetail?.currentStatus?.status == AppStatus.Status.NBA_PENDING ))) {
printHtmlPart(41)
createClosureForHtmlPart(59, 5)
invokeTag('link','g',376,['controller':("applicationManagement"),'action':("depositionOfMicroOrganism"),'params':([formType:"FormC",appFormId:applicationDetail?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],5)
printHtmlPart(63)
}
printHtmlPart(64)
if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_B && applicationDetail?.indianGovtInst && applicationDetail?.indianGovtInst?.size() >=0 && 
 (applicationDetail?.currentStatus?.status == AppStatus.Status.PENDING || applicationDetail?.currentStatus?.status == AppStatus.Status.NBA_PENDING ))) {
printHtmlPart(41)
createClosureForHtmlPart(59, 5)
invokeTag('link','g',386,['controller':("formB"),'action':("indianGovtInst"),'params':([formType:"FormB",appFormId:applicationDetail?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],5)
printHtmlPart(63)
}
printHtmlPart(65)
if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_2 && applicationDetail?.individualProfiles && applicationDetail?.individualProfiles?.size() >=0 &&
 (applicationDetail?.currentStatus?.status == AppStatus.Status.PENDING || applicationDetail?.currentStatus?.status == AppStatus.Status.NBA_PENDING ))) {
printHtmlPart(41)
createClosureForHtmlPart(59, 5)
invokeTag('link','g',397,['controller':("applicationManagement"),'action':("individualProfile"),'params':([formType:"Form2",appFormId:applicationDetail?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],5)
printHtmlPart(61)
}
else if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_2 && applicationDetail?.companyProfiles && applicationDetail?.companyProfiles?.size() >=0 && 
 (applicationDetail?.currentStatus?.status == AppStatus.Status.PENDING || applicationDetail?.currentStatus?.status == AppStatus.Status.NBA_PENDING ))) {
printHtmlPart(41)
createClosureForHtmlPart(59, 5)
invokeTag('link','g',408,['controller':("applicationManagement"),'action':("companyProfile"),'params':([formType:"Form2",appFormId:applicationDetail?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],5)
printHtmlPart(61)
}
printHtmlPart(64)
if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_3 && applicationDetail?.individualProfiles && applicationDetail?.individualProfiles?.size() >=0 && 
(applicationDetail?.currentStatus?.status == AppStatus.Status.PENDING || applicationDetail?.currentStatus?.status == AppStatus.Status.NBA_PENDING ))) {
printHtmlPart(41)
createClosureForHtmlPart(59, 5)
invokeTag('link','g',418,['controller':("applicationManagement"),'action':("individualProfile"),'params':([formType:"Form3",appFormId:applicationDetail?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],5)
printHtmlPart(41)
}
else if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_3 && applicationDetail?.companyProfiles && applicationDetail?.companyProfiles?.size() >=0 && 
 (applicationDetail?.currentStatus?.status == AppStatus.Status.PENDING || applicationDetail?.currentStatus?.status == AppStatus.Status.NBA_PENDING ))) {
printHtmlPart(41)
createClosureForHtmlPart(59, 5)
invokeTag('link','g',428,['controller':("applicationManagement"),'action':("companyProfile"),'params':([formType:"Form3",appFormId:applicationDetail?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],5)
printHtmlPart(61)
}
printHtmlPart(66)
if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_4 && applicationDetail?.individualProfiles && applicationDetail?.individualProfiles?.size() >=0 && 
													 (applicationDetail?.currentStatus?.status == AppStatus.Status.PENDING || applicationDetail?.currentStatus?.status == AppStatus.Status.NBA_PENDING ))) {
printHtmlPart(41)
createClosureForHtmlPart(59, 5)
invokeTag('link','g',436,['controller':("applicationManagement"),'action':("individualProfile"),'params':([formType:"Form4",appFormId:applicationDetail?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],5)
printHtmlPart(61)
}
else if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_4 && applicationDetail?.companyProfiles && applicationDetail?.companyProfiles?.size() >=0 && 
	 (applicationDetail?.currentStatus?.status == AppStatus.Status.PENDING || applicationDetail?.currentStatus?.status == AppStatus.Status.NBA_PENDING ))) {
printHtmlPart(41)
createClosureForHtmlPart(59, 5)
invokeTag('link','g',445,['controller':("applicationManagement"),'action':("companyProfile"),'params':([formType:"Form4",appFormId:applicationDetail?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],5)
printHtmlPart(61)
}
else if(true && (applicationDetail?.category?.category == FormCategory.Category.Form_B && applicationDetail?.indianResearcher && applicationDetail?.indianResearcher?.size() >=0 && 
 (applicationDetail?.currentStatus?.status == AppStatus.Status.PENDING || applicationDetail?.currentStatus?.status == AppStatus.Status.NBA_PENDING ))) {
printHtmlPart(41)
createClosureForHtmlPart(59, 5)
invokeTag('link','g',455,['controller':("formB"),'action':("indianResearcher"),'params':([formType:"FormB",appFormId:applicationDetail?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],5)
printHtmlPart(60)
}
printHtmlPart(67)
}
printHtmlPart(17)
}
printHtmlPart(68)
invokeTag('render','g',463,['template':("/common/rightPan")],-1)
printHtmlPart(69)
})
invokeTag('captureBody','sitemesh',464,[:],1)
printHtmlPart(70)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1654150976854L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
