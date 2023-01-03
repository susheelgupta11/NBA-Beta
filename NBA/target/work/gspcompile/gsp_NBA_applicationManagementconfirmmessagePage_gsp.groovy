import java.util.*
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagementconfirmmessagePage_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/confirmmessagePage.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("loggedInUser")],-1)
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',10,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(5)
if(true && (appForm?.isDeclarationDigitallySigned == 'true')) {
printHtmlPart(6)
expressionOut.print(resource(dir: 'images', file: 'amblam.png'))
printHtmlPart(7)
if(true && (formType == 'FormC')) {
printHtmlPart(8)
if(true && (appForm?.appNumber)) {
printHtmlPart(9)
expressionOut.print(appForm?.appNumber)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (appForm?.depostionOfMicroOrganism?.size() == 0)) {
printHtmlPart(12)
for( deposition in (appForm?.depostionOfMicroOrganism) ) {
printHtmlPart(13)
expressionOut.print(deposition?.nameOfDepositor)
printHtmlPart(14)
}
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (appForm?.depostionOfMicroOrganism?.size() == 0)) {
printHtmlPart(17)
for( deposition in (appForm?.depostionOfMicroOrganism) ) {
printHtmlPart(13)
expressionOut.print(deposition?.nameOfDepositor)
printHtmlPart(14)
}
printHtmlPart(15)
}
printHtmlPart(18)
}
else {
printHtmlPart(19)
if(true && (appForm?.companyProfiles?.size() == 0)) {
printHtmlPart(17)
for( individual in (appForm?.individualProfiles) ) {
printHtmlPart(13)
expressionOut.print(individual?.title)
printHtmlPart(13)
expressionOut.print(individual?.firstName)
printHtmlPart(13)
expressionOut.print(individual?.middleName)
printHtmlPart(13)
expressionOut.print(individual?.lastName)
printHtmlPart(20)
}
printHtmlPart(15)
}
else {
printHtmlPart(17)
for( company in (appForm?.companyProfiles) ) {
printHtmlPart(13)
expressionOut.print(company?.entityName)
printHtmlPart(20)
}
printHtmlPart(15)
}
printHtmlPart(21)
}
printHtmlPart(22)
if(true && (appForm?.companyProfiles?.size() == 0)) {
printHtmlPart(15)
loop:{
int i = 0
for( individual in (appForm?.individualProfiles) ) {
printHtmlPart(17)
if(true && (appForm?.individualProfiles?.size() - i == 1)) {
printHtmlPart(13)
expressionOut.print(individual?.address1)
printHtmlPart(13)
expressionOut.print(individual?.address2)
printHtmlPart(13)
expressionOut.print(individual?.address3)
printHtmlPart(17)
}
else {
printHtmlPart(13)
expressionOut.print(individual?.address1)
printHtmlPart(13)
expressionOut.print(individual?.address2)
printHtmlPart(13)
expressionOut.print(individual?.address3)
printHtmlPart(23)
}
printHtmlPart(15)
i++
}
}
printHtmlPart(24)
}
else {
printHtmlPart(15)
loop:{
int i = 0
for( company in (appForm?.companyProfiles) ) {
printHtmlPart(17)
if(true && (appForm?.companyProfiles?.size() - i == 1)) {
printHtmlPart(13)
expressionOut.print(company?.address1)
printHtmlPart(13)
expressionOut.print(company?.address2)
printHtmlPart(13)
expressionOut.print(company?.address3)
printHtmlPart(17)
}
else {
printHtmlPart(13)
expressionOut.print(company?.address1)
printHtmlPart(13)
expressionOut.print(company?.address2)
printHtmlPart(13)
expressionOut.print(company?.address3)
printHtmlPart(23)
}
printHtmlPart(15)
i++
}
}
printHtmlPart(24)
}
printHtmlPart(25)
if(true && (formType == 'Form1')) {
printHtmlPart(26)
}
else if(true && (formType == 'Form2')) {
printHtmlPart(27)
}
else if(true && (formType == 'Form3')) {
printHtmlPart(28)
}
else if(true && (formType == 'Form4')) {
printHtmlPart(29)
}
printHtmlPart(30)
if(true && (formType == 'Form1')) {
printHtmlPart(31)
}
else if(true && (formType == 'Form2')) {
printHtmlPart(32)
}
else if(true && (formType == 'Form3')) {
printHtmlPart(33)
}
else if(true && (formType == 'Form4')) {
printHtmlPart(34)
}
printHtmlPart(35)
expressionOut.print(appForm?.appNumber)
printHtmlPart(36)
if(true && (appForm?.depostionOfMicroOrganism?.size() == 0)) {
printHtmlPart(17)
for( deposition in (appForm?.depostionOfMicroOrganism) ) {
printHtmlPart(13)
expressionOut.print(deposition?.nameOfDepositor)
printHtmlPart(14)
}
printHtmlPart(15)
}
printHtmlPart(37)
if(true && (appForm?.companyProfiles?.size() == 0)) {
printHtmlPart(17)
invokeTag('set','g',214,['value':("Individual"),'var':("type")],-1)
printHtmlPart(17)
for( individual in (appForm?.individualProfiles) ) {
printHtmlPart(13)
expressionOut.print(individual?.title)
printHtmlPart(13)
expressionOut.print(individual?.firstName)
printHtmlPart(13)
expressionOut.print(individual?.middleName)
printHtmlPart(13)
expressionOut.print(individual?.lastName)
printHtmlPart(20)
}
printHtmlPart(15)
}
else {
printHtmlPart(15)
invokeTag('set','g',223,['value':("Company"),'var':("type")],-1)
printHtmlPart(17)
for( company in (appForm?.companyProfiles) ) {
printHtmlPart(13)
expressionOut.print(company?.entityName)
printHtmlPart(20)
}
printHtmlPart(15)
}
printHtmlPart(38)
if(true && (appForm?.depostionOfMicroOrganism?.size() == 0)) {
printHtmlPart(17)
for( deposition in (appForm?.depostionOfMicroOrganism) ) {
printHtmlPart(13)
expressionOut.print(deposition?.nameOfDepositor)
printHtmlPart(14)
}
printHtmlPart(15)
}
printHtmlPart(37)
if(true && (appForm?.companyProfiles?.size() == 0)) {
printHtmlPart(39)
for( individual in (appForm?.individualProfiles) ) {
printHtmlPart(13)
expressionOut.print(individual?.title)
printHtmlPart(13)
expressionOut.print(individusaal?.firstName)
printHtmlPart(13)
expressionOut.print(individual?.middleName)
printHtmlPart(13)
expressionOut.print(individual?.lastName)
printHtmlPart(20)
}
printHtmlPart(15)
}
else {
printHtmlPart(40)
for( company in (appForm?.companyProfiles) ) {
printHtmlPart(13)
expressionOut.print(company?.entityName)
printHtmlPart(20)
}
printHtmlPart(41)
}
printHtmlPart(42)
expressionOut.print(type)
printHtmlPart(43)
expressionOut.print(email)
printHtmlPart(44)
expressionOut.print(new Date().format('dd/MM/yyyy HH:mm:ss'))
printHtmlPart(45)
expressionOut.print(ipAddress)
printHtmlPart(46)
}
else {
printHtmlPart(47)
expressionOut.print(resource(dir: 'images', file: 'amblam.png'))
printHtmlPart(48)
if(true && (formType == 'FormC')) {
printHtmlPart(49)
}
else {
printHtmlPart(50)
}
printHtmlPart(51)
if(true && (formType == 'FormC')) {
printHtmlPart(52)
expressionOut.print(appForm?.appNumber)
printHtmlPart(53)
for( deposition in (appForm?.depostionOfMicroOrganism) ) {
printHtmlPart(17)
expressionOut.print(deposition?.nameOfDepositor)
printHtmlPart(10)
}
printHtmlPart(54)
for( deposition in (appForm?.depostionOfMicroOrganism) ) {
printHtmlPart(17)
expressionOut.print(deposition?.address1)
printHtmlPart(17)
expressionOut.print(deposition?.address2)
printHtmlPart(17)
expressionOut.print(deposition?.address3)
printHtmlPart(12)
}
printHtmlPart(55)
expressionOut.print(foreignRepo?.repostoryName)
printHtmlPart(56)
expressionOut.print(foreignRepo?.country?.country)
printHtmlPart(57)
}
else {
printHtmlPart(58)
if(true && (appForm?.companyProfiles?.size() == 0)) {
printHtmlPart(17)
for( individual in (appForm?.individualProfiles) ) {
printHtmlPart(13)
expressionOut.print(individual?.title)
printHtmlPart(13)
expressionOut.print(individual?.firstName)
printHtmlPart(13)
expressionOut.print(individual?.middleName)
printHtmlPart(13)
expressionOut.print(individual?.lastName)
printHtmlPart(20)
}
printHtmlPart(15)
}
else {
printHtmlPart(17)
for( company in (appForm?.companyProfiles) ) {
printHtmlPart(13)
expressionOut.print(company?.entityName)
printHtmlPart(20)
}
printHtmlPart(15)
}
printHtmlPart(59)
if(true && (listOfIndianResearcher)) {
printHtmlPart(17)
for( indianResearcher in (listOfIndianResearcher) ) {
printHtmlPart(13)
expressionOut.print(indianResearcher?.title)
printHtmlPart(13)
expressionOut.print(indianResearcher?.firstName)
printHtmlPart(13)
expressionOut.print(indianResearcher?.middleName)
printHtmlPart(13)
expressionOut.print(indianResearcher?.lastName)
printHtmlPart(20)
}
printHtmlPart(15)
}
else if(true && (listOfIndianGovtInst)) {
printHtmlPart(17)
for( govtInst in (listOfIndianGovtInst) ) {
printHtmlPart(13)
expressionOut.print(govtInst?.govtInstName)
printHtmlPart(23)
}
printHtmlPart(15)
}
printHtmlPart(54)
if(true && (appForm?.companyProfiles?.size() == 0)) {
printHtmlPart(17)
loop:{
int i = 0
for( individual in (individualProfileList) ) {
printHtmlPart(13)
if(true && (appForm?.individualProfiles?.size() - i == 1)) {
printHtmlPart(60)
expressionOut.print(individual?.address1)
printHtmlPart(60)
expressionOut.print(individual?.address2)
printHtmlPart(60)
expressionOut.print(individual?.address3)
printHtmlPart(13)
}
else {
printHtmlPart(60)
expressionOut.print(individual?.address1)
printHtmlPart(60)
expressionOut.print(individual?.address2)
printHtmlPart(60)
expressionOut.print(individual?.address3)
printHtmlPart(23)
}
printHtmlPart(17)
i++
}
}
printHtmlPart(15)
}
else {
printHtmlPart(17)
loop:{
int i = 0
for( company in (companyProfileList) ) {
printHtmlPart(13)
if(true && (appForm?.companyProfiles?.size() - i == 1)) {
printHtmlPart(60)
expressionOut.print(company?.address1)
printHtmlPart(60)
expressionOut.print(company?.address2)
printHtmlPart(60)
expressionOut.print(company?.address3)
printHtmlPart(13)
}
else {
printHtmlPart(60)
expressionOut.print(company?.address1)
printHtmlPart(60)
expressionOut.print(company?.address2)
printHtmlPart(60)
expressionOut.print(company?.address3)
printHtmlPart(23)
}
printHtmlPart(17)
i++
}
}
printHtmlPart(15)
}
printHtmlPart(59)
if(true && (listOfIndianResearcher)) {
printHtmlPart(17)
for( researcher in (listOfIndianResearcher) ) {
printHtmlPart(13)
expressionOut.print(researcher?.address1)
printHtmlPart(61)
expressionOut.print(researcher?.address2)
printHtmlPart(0)
expressionOut.print(researcher?.address3)
printHtmlPart(0)
expressionOut.print(researcher?.city)
printHtmlPart(62)
expressionOut.print(researcher?.pincode)
printHtmlPart(61)
expressionOut.print(researcher?.province)
printHtmlPart(0)
expressionOut.print(researcher?.country?.country)
printHtmlPart(17)
}
printHtmlPart(15)
}
else if(true && (listOfIndianGovtInst)) {
printHtmlPart(17)
for( govtinst in (listOfIndianGovtInst) ) {
printHtmlPart(13)
expressionOut.print(govtinst?.address1)
printHtmlPart(61)
expressionOut.print(govtinst?.address2)
printHtmlPart(0)
expressionOut.print(govtinst?.address3)
printHtmlPart(0)
expressionOut.print(govtinst?.city)
printHtmlPart(62)
expressionOut.print(govtinst?.pincode)
printHtmlPart(61)
expressionOut.print(govtinst?.province)
printHtmlPart(0)
expressionOut.print(govtinst?.country?.country)
printHtmlPart(17)
}
printHtmlPart(15)
}
printHtmlPart(63)
if(true && (params.formType == 'Form1')) {
printHtmlPart(64)
}
else if(true && (params.formType == 'Form2')) {
printHtmlPart(65)
}
else if(true && (params.formType == 'Form3')) {
printHtmlPart(66)
}
else if(true && (params.formType == 'Form4')) {
printHtmlPart(67)
}
else if(true && (params.formType == 'FormB')) {
printHtmlPart(68)
}
printHtmlPart(69)
if(true && (formType == 'Form1')) {
printHtmlPart(70)
}
else if(true && (formType == 'Form2')) {
printHtmlPart(71)
}
else if(true && (formType == 'Form3')) {
printHtmlPart(72)
}
else if(true && (formType == 'Form4')) {
printHtmlPart(73)
}
else if(true && (formType == 'FormB')) {
printHtmlPart(74)
}
printHtmlPart(75)
expressionOut.print(appForm?.appNumber)
printHtmlPart(76)
}
printHtmlPart(77)
if(true && (formType != 'FormC')) {
printHtmlPart(78)
if(true && (listOfIndianResearcher)) {
printHtmlPart(13)
for( researcher in (listOfIndianResearcher) ) {
printHtmlPart(79)
expressionOut.print(researcher?.title)
printHtmlPart(80)
expressionOut.print(researcher?.firstName)
printHtmlPart(80)
expressionOut.print(researcher?.middleName)
printHtmlPart(80)
expressionOut.print(researcher?.lastName)
printHtmlPart(81)
}
printHtmlPart(15)
}
else if(true && (listOfIndianGovtInst)) {
printHtmlPart(17)
for( govtinst in (listOfIndianGovtInst) ) {
printHtmlPart(79)
expressionOut.print(govtinst?.govtInstName)
printHtmlPart(82)
}
printHtmlPart(15)
}
printHtmlPart(15)
if(true && (appForm?.companyProfiles?.size() == 0)) {
printHtmlPart(17)
for( individual in (individualProfileList) ) {
printHtmlPart(83)
expressionOut.print(individual?.title)
printHtmlPart(0)
expressionOut.print(individual?.firstName)
printHtmlPart(0)
expressionOut.print(individual?.middleName)
printHtmlPart(60)
expressionOut.print(individual?.lastName)
printHtmlPart(84)
}
printHtmlPart(15)
}
else {
printHtmlPart(17)
for( company in (companyProfileList) ) {
printHtmlPart(83)
expressionOut.print(company?.entityName)
printHtmlPart(84)
}
printHtmlPart(85)
}
printHtmlPart(86)
}
printHtmlPart(87)
if(true && (formType == 'FormC')) {
printHtmlPart(88)
}
printHtmlPart(89)
if(true && (formType != 'FormC')) {
printHtmlPart(90)
out.print(new Date().format( 'dd-MM-yyyy' ))
printHtmlPart(91)
}
printHtmlPart(92)
}
printHtmlPart(93)
createClosureForHtmlPart(94, 2)
invokeTag('link','g',605,['controller':("loggedInAs"),'action':("inbox"),'class':("btn btn-primary"),'params':([appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(41)
createClosureForHtmlPart(95, 2)
invokeTag('link','g',608,['controller':("applicationManagement"),'action':("changeStatus"),'class':("btn btn-primary"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(41)
createClosureForHtmlPart(96, 2)
invokeTag('link','g',611,['controller':("applicationManagement"),'action':("form1feedback"),'class':("btn btn-primary"),'params':([appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(41)
createClosureForHtmlPart(97, 2)
invokeTag('link','g',614,['controller':("formPreview"),'action':("printAcknowledgement"),'class':("btn btn-primary"),'target':("_blank"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(98)
})
invokeTag('captureBody','sitemesh',616,[:],1)
printHtmlPart(99)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html'
public static final long LAST_MODIFIED = 1571313590000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
