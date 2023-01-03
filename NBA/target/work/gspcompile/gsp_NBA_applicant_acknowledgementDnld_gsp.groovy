import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicant_acknowledgementDnld_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicant/_acknowledgementDnld.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createClosureForHtmlPart(1, 1)
invokeTag('captureHead','sitemesh',4,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
if(true && (appForm?.isDeclarationDigitallySigned == 'true')) {
printHtmlPart(4)
expressionOut.print(resource(dir: 'images', file: 'amblam.png'))
printHtmlPart(5)
if(true && (formType == 'FormC')) {
printHtmlPart(6)
if(true && (appForm?.appNumber)) {
printHtmlPart(7)
expressionOut.print(appForm?.appNumber)
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (appForm?.depostionOfMicroOrganism?.size() == 0)) {
printHtmlPart(10)
for( deposition in (appForm?.depostionOfMicroOrganism) ) {
printHtmlPart(11)
expressionOut.print(deposition?.nameOfDepositor)
printHtmlPart(12)
}
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (appForm?.depostionOfMicroOrganism?.size() == 0)) {
printHtmlPart(10)
for( deposition in (appForm?.depostionOfMicroOrganism) ) {
printHtmlPart(11)
expressionOut.print(deposition?.nameOfDepositor)
printHtmlPart(12)
}
printHtmlPart(13)
}
printHtmlPart(15)
}
else {
printHtmlPart(16)
if(true && (appForm?.companyProfiles?.size() == 0)) {
printHtmlPart(10)
for( individual in (appForm?.individualProfiles) ) {
printHtmlPart(11)
expressionOut.print(individual?.title)
printHtmlPart(11)
expressionOut.print(individual?.firstName)
printHtmlPart(11)
expressionOut.print(individual?.middleName)
printHtmlPart(11)
expressionOut.print(individual?.lastName)
printHtmlPart(17)
}
printHtmlPart(13)
}
else {
printHtmlPart(10)
for( company in (appForm?.companyProfiles) ) {
printHtmlPart(11)
expressionOut.print(company?.entityName)
printHtmlPart(17)
}
printHtmlPart(13)
}
printHtmlPart(18)
}
printHtmlPart(19)
if(true && (appForm?.companyProfiles?.size() == 0)) {
printHtmlPart(13)
loop:{
int i = 0
for( individual in (appForm?.individualProfiles) ) {
printHtmlPart(10)
if(true && (appForm?.individualProfiles?.size() - i == 1)) {
printHtmlPart(11)
expressionOut.print(individual?.address1)
printHtmlPart(11)
expressionOut.print(individual?.address2)
printHtmlPart(11)
expressionOut.print(individual?.address3)
printHtmlPart(10)
}
else {
printHtmlPart(11)
expressionOut.print(individual?.address1)
printHtmlPart(11)
expressionOut.print(individual?.address2)
printHtmlPart(11)
expressionOut.print(individual?.address3)
printHtmlPart(20)
}
printHtmlPart(13)
i++
}
}
printHtmlPart(21)
}
else {
printHtmlPart(13)
loop:{
int i = 0
for( company in (appForm?.companyProfiles) ) {
printHtmlPart(10)
if(true && (appForm?.companyProfiles?.size() - i == 1)) {
printHtmlPart(11)
expressionOut.print(company?.address1)
printHtmlPart(11)
expressionOut.print(company?.address2)
printHtmlPart(11)
expressionOut.print(company?.address3)
printHtmlPart(10)
}
else {
printHtmlPart(11)
expressionOut.print(company?.address1)
printHtmlPart(11)
expressionOut.print(company?.address2)
printHtmlPart(11)
expressionOut.print(company?.address3)
printHtmlPart(20)
}
printHtmlPart(13)
i++
}
}
printHtmlPart(21)
}
printHtmlPart(22)
if(true && (formType == 'Form1')) {
printHtmlPart(23)
}
else if(true && (formType == 'Form2')) {
printHtmlPart(24)
}
else if(true && (formType == 'Form3')) {
printHtmlPart(25)
}
else if(true && (formType == 'Form4')) {
printHtmlPart(26)
}
printHtmlPart(27)
if(true && (formType == 'Form1')) {
printHtmlPart(28)
}
else if(true && (formType == 'Form2')) {
printHtmlPart(29)
}
else if(true && (formType == 'Form3')) {
printHtmlPart(30)
}
else if(true && (formType == 'Form4')) {
printHtmlPart(31)
}
printHtmlPart(32)
expressionOut.print(appForm?.appNumber)
printHtmlPart(33)
if(true && (appForm?.depostionOfMicroOrganism?.size() == 0)) {
printHtmlPart(10)
for( deposition in (appForm?.depostionOfMicroOrganism) ) {
printHtmlPart(11)
expressionOut.print(deposition?.nameOfDepositor)
printHtmlPart(12)
}
printHtmlPart(13)
}
printHtmlPart(34)
if(true && (appForm?.companyProfiles?.size() == 0)) {
printHtmlPart(10)
invokeTag('set','g',207,['value':("Individual"),'var':("type")],-1)
printHtmlPart(10)
for( individual in (appForm?.individualProfiles) ) {
printHtmlPart(11)
expressionOut.print(individual?.title)
printHtmlPart(11)
expressionOut.print(individual?.firstName)
printHtmlPart(11)
expressionOut.print(individual?.middleName)
printHtmlPart(11)
expressionOut.print(individual?.lastName)
printHtmlPart(17)
}
printHtmlPart(13)
}
else {
printHtmlPart(13)
invokeTag('set','g',215,['value':("Company"),'var':("type")],-1)
printHtmlPart(10)
for( company in (appForm?.companyProfiles) ) {
printHtmlPart(11)
expressionOut.print(company?.entityName)
printHtmlPart(17)
}
printHtmlPart(13)
}
printHtmlPart(35)
if(true && (appForm?.depostionOfMicroOrganism?.size() == 0)) {
printHtmlPart(10)
for( deposition in (appForm?.depostionOfMicroOrganism) ) {
printHtmlPart(11)
expressionOut.print(deposition?.nameOfDepositor)
printHtmlPart(12)
}
printHtmlPart(13)
}
printHtmlPart(34)
if(true && (appForm?.companyProfiles?.size() == 0)) {
printHtmlPart(36)
for( individual in (appForm?.individualProfiles) ) {
printHtmlPart(11)
expressionOut.print(individual?.title)
printHtmlPart(11)
expressionOut.print(individual?.firstName)
printHtmlPart(11)
expressionOut.print(individual?.middleName)
printHtmlPart(11)
expressionOut.print(individual?.lastName)
printHtmlPart(17)
}
printHtmlPart(13)
}
else {
printHtmlPart(37)
for( company in (appForm?.companyProfiles) ) {
printHtmlPart(11)
expressionOut.print(company?.entityName)
printHtmlPart(17)
}
printHtmlPart(38)
}
printHtmlPart(39)
expressionOut.print(type)
printHtmlPart(40)
expressionOut.print(email)
printHtmlPart(41)
expressionOut.print(new Date().format('dd/MM/yyyy HH:mm:ss'))
printHtmlPart(42)
expressionOut.print(ipAddress)
printHtmlPart(43)
}
else {
printHtmlPart(44)
expressionOut.print(resource(dir: 'images', file: 'amblam.png'))
printHtmlPart(45)
if(true && (formType == 'FormC')) {
printHtmlPart(46)
}
else {
printHtmlPart(47)
}
printHtmlPart(48)
if(true && (formType == 'FormC')) {
printHtmlPart(49)
expressionOut.print(appForm?.appNumber)
printHtmlPart(50)
for( deposition in (appForm?.depostionOfMicroOrganism) ) {
printHtmlPart(10)
expressionOut.print(deposition?.nameOfDepositor)
printHtmlPart(8)
}
printHtmlPart(51)
for( deposition in (appForm?.depostionOfMicroOrganism) ) {
printHtmlPart(10)
expressionOut.print(deposition?.address1)
printHtmlPart(10)
expressionOut.print(deposition?.address2)
printHtmlPart(10)
expressionOut.print(deposition?.address3)
printHtmlPart(52)
}
printHtmlPart(53)
expressionOut.print(foreignRepo?.repostoryName)
printHtmlPart(54)
}
else {
printHtmlPart(55)
if(true && (appForm?.companyProfiles?.size() == 0)) {
printHtmlPart(10)
for( individual in (appForm?.individualProfiles) ) {
printHtmlPart(11)
expressionOut.print(individual?.title)
printHtmlPart(11)
expressionOut.print(individual?.firstName)
printHtmlPart(11)
expressionOut.print(individual?.middleName)
printHtmlPart(11)
expressionOut.print(individual?.lastName)
printHtmlPart(17)
}
printHtmlPart(13)
}
else {
printHtmlPart(10)
for( company in (appForm?.companyProfiles) ) {
printHtmlPart(11)
expressionOut.print(company?.entityName)
printHtmlPart(17)
}
printHtmlPart(13)
}
printHtmlPart(56)
if(true && (listOfIndianResearcher)) {
printHtmlPart(10)
for( indianResearcher in (listOfIndianResearcher) ) {
printHtmlPart(11)
expressionOut.print(indianResearcher?.title)
printHtmlPart(11)
expressionOut.print(indianResearcher?.firstName)
printHtmlPart(11)
expressionOut.print(indianResearcher?.middleName)
printHtmlPart(11)
expressionOut.print(indianResearcher?.lastName)
printHtmlPart(17)
}
printHtmlPart(13)
}
else if(true && (listOfIndianGovtInst)) {
printHtmlPart(10)
for( govtInst in (listOfIndianGovtInst) ) {
printHtmlPart(11)
expressionOut.print(govtInst?.govtInstName)
printHtmlPart(20)
}
printHtmlPart(13)
}
printHtmlPart(51)
if(true && (appForm?.companyProfiles?.size() == 0)) {
printHtmlPart(10)
loop:{
int i = 0
for( individual in (individualProfileList) ) {
printHtmlPart(11)
if(true && (appForm?.individualProfiles?.size() - i == 1)) {
printHtmlPart(57)
expressionOut.print(individual?.address1)
printHtmlPart(57)
expressionOut.print(individual?.address2)
printHtmlPart(57)
expressionOut.print(individual?.address3)
printHtmlPart(11)
}
else {
printHtmlPart(57)
expressionOut.print(individual?.address1)
printHtmlPart(57)
expressionOut.print(individual?.address2)
printHtmlPart(57)
expressionOut.print(individual?.address3)
printHtmlPart(20)
}
printHtmlPart(10)
i++
}
}
printHtmlPart(13)
}
else {
printHtmlPart(10)
loop:{
int i = 0
for( company in (companyProfileList) ) {
printHtmlPart(11)
if(true && (appForm?.companyProfiles?.size() - i == 1)) {
printHtmlPart(57)
expressionOut.print(company?.address1)
printHtmlPart(57)
expressionOut.print(company?.address2)
printHtmlPart(57)
expressionOut.print(company?.address3)
printHtmlPart(11)
}
else {
printHtmlPart(57)
expressionOut.print(company?.address1)
printHtmlPart(57)
expressionOut.print(company?.address2)
printHtmlPart(57)
expressionOut.print(company?.address3)
printHtmlPart(20)
}
printHtmlPart(10)
i++
}
}
printHtmlPart(13)
}
printHtmlPart(56)
if(true && (listOfIndianResearcher)) {
printHtmlPart(10)
for( researcher in (listOfIndianResearcher) ) {
printHtmlPart(11)
expressionOut.print(researcher?.address1)
printHtmlPart(58)
expressionOut.print(researcher?.address2)
printHtmlPart(59)
expressionOut.print(researcher?.address3)
printHtmlPart(59)
expressionOut.print(researcher?.city)
printHtmlPart(60)
expressionOut.print(researcher?.pincode)
printHtmlPart(58)
expressionOut.print(researcher?.province)
printHtmlPart(59)
expressionOut.print(researcher?.country?.country)
printHtmlPart(10)
}
printHtmlPart(13)
}
else if(true && (listOfIndianGovtInst)) {
printHtmlPart(10)
for( govtinst in (listOfIndianGovtInst) ) {
printHtmlPart(11)
expressionOut.print(govtinst?.address1)
printHtmlPart(58)
expressionOut.print(govtinst?.address2)
printHtmlPart(59)
expressionOut.print(govtinst?.address3)
printHtmlPart(59)
expressionOut.print(govtinst?.city)
printHtmlPart(60)
expressionOut.print(govtinst?.pincode)
printHtmlPart(58)
expressionOut.print(govtinst?.province)
printHtmlPart(59)
expressionOut.print(govtinst?.country?.country)
printHtmlPart(10)
}
printHtmlPart(13)
}
printHtmlPart(61)
if(true && (params.formType == 'Form1')) {
printHtmlPart(62)
}
else if(true && (params.formType == 'Form2')) {
printHtmlPart(63)
}
else if(true && (params.formType == 'Form3')) {
printHtmlPart(64)
}
else if(true && (params.formType == 'Form4')) {
printHtmlPart(65)
}
else if(true && (params.formType == 'FormB')) {
printHtmlPart(66)
}
printHtmlPart(67)
if(true && (formType == 'Form1')) {
printHtmlPart(68)
}
else if(true && (formType == 'Form2')) {
printHtmlPart(69)
}
else if(true && (formType == 'Form3')) {
printHtmlPart(70)
}
else if(true && (formType == 'Form4')) {
printHtmlPart(71)
}
else if(true && (formType == 'FormB')) {
printHtmlPart(72)
}
printHtmlPart(73)
expressionOut.print(appForm?.appNumber)
printHtmlPart(74)
}
printHtmlPart(75)
if(true && (formType != 'FormC')) {
printHtmlPart(76)
if(true && (listOfIndianResearcher)) {
printHtmlPart(11)
for( researcher in (listOfIndianResearcher) ) {
printHtmlPart(77)
expressionOut.print(researcher?.title)
printHtmlPart(78)
expressionOut.print(researcher?.firstName)
printHtmlPart(78)
expressionOut.print(researcher?.middleName)
printHtmlPart(78)
expressionOut.print(researcher?.lastName)
printHtmlPart(79)
}
printHtmlPart(13)
}
else if(true && (listOfIndianGovtInst)) {
printHtmlPart(10)
for( govtinst in (listOfIndianGovtInst) ) {
printHtmlPart(77)
expressionOut.print(govtinst?.govtInstName)
printHtmlPart(80)
}
printHtmlPart(13)
}
printHtmlPart(13)
if(true && (appForm?.companyProfiles?.size() == 0)) {
printHtmlPart(10)
for( individual in (individualProfileList) ) {
printHtmlPart(81)
expressionOut.print(individual?.title)
printHtmlPart(59)
expressionOut.print(individual?.firstName)
printHtmlPart(59)
expressionOut.print(individual?.middleName)
printHtmlPart(57)
expressionOut.print(individual?.lastName)
printHtmlPart(82)
}
printHtmlPart(13)
}
else {
printHtmlPart(10)
for( company in (companyProfileList) ) {
printHtmlPart(81)
expressionOut.print(company?.entityName)
printHtmlPart(82)
}
printHtmlPart(83)
}
printHtmlPart(84)
}
printHtmlPart(85)
if(true && (formType == 'FormC')) {
printHtmlPart(86)
}
printHtmlPart(87)
if(true && (formType != 'FormC')) {
printHtmlPart(88)
out.print(new Date().format( 'dd-MM-yyyy' ))
printHtmlPart(89)
}
printHtmlPart(90)
}
printHtmlPart(91)
createClosureForHtmlPart(92, 2)
invokeTag('link','g',600,['controller':("formPreview"),'action':("printAcknowledgement"),'class':("btn btn-success"),'target':("_blank"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(93)
})
invokeTag('captureBody','sitemesh',601,[:],1)
printHtmlPart(94)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1661052566704L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
