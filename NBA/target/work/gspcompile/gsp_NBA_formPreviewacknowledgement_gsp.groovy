import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formPreviewacknowledgement_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formPreview/acknowledgement.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (appForm?.isDeclarationDigitallySigned == 'true')) {
printHtmlPart(1)
expressionOut.print(resource(dir: 'images', file: 'amblam.png'))
printHtmlPart(2)
if(true && (formType == 'FormC')) {
printHtmlPart(3)
if(true && (appForm?.appNumber)) {
printHtmlPart(4)
expressionOut.print(appForm?.appNumber)
printHtmlPart(5)
}
printHtmlPart(6)
if(true && (appForm?.depostionOfMicroOrganism?.size() == 0)) {
printHtmlPart(7)
for( deposition in (appForm?.depostionOfMicroOrganism) ) {
printHtmlPart(8)
expressionOut.print(deposition?.nameOfDepositor)
printHtmlPart(9)
}
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (appForm?.depostionOfMicroOrganism?.size() == 0)) {
printHtmlPart(7)
for( deposition in (appForm?.depostionOfMicroOrganism) ) {
printHtmlPart(8)
expressionOut.print(deposition?.nameOfDepositor)
printHtmlPart(9)
}
printHtmlPart(10)
}
printHtmlPart(12)
}
else {
printHtmlPart(13)
if(true && (appForm?.companyProfiles?.size() == 0)) {
printHtmlPart(7)
for( individual in (appForm?.individualProfiles) ) {
printHtmlPart(8)
expressionOut.print(individual?.title)
printHtmlPart(8)
expressionOut.print(individual?.firstName)
printHtmlPart(8)
expressionOut.print(individual?.middleName)
printHtmlPart(8)
expressionOut.print(individual?.lastName)
printHtmlPart(14)
}
printHtmlPart(10)
}
else {
printHtmlPart(7)
for( company in (appForm?.companyProfiles) ) {
printHtmlPart(8)
expressionOut.print(company?.entityName)
printHtmlPart(14)
}
printHtmlPart(10)
}
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (appForm?.companyProfiles?.size() == 0)) {
printHtmlPart(10)
loop:{
int i = 0
for( individual in (appForm?.individualProfiles) ) {
printHtmlPart(7)
if(true && (appForm?.individualProfiles?.size() - i == 1)) {
printHtmlPart(8)
expressionOut.print(individual?.address1)
printHtmlPart(8)
expressionOut.print(individual?.address2)
printHtmlPart(8)
expressionOut.print(individual?.address3)
printHtmlPart(7)
}
else {
printHtmlPart(8)
expressionOut.print(individual?.address1)
printHtmlPart(8)
expressionOut.print(individual?.address2)
printHtmlPart(8)
expressionOut.print(individual?.address3)
printHtmlPart(17)
}
printHtmlPart(10)
i++
}
}
printHtmlPart(18)
}
else {
printHtmlPart(10)
loop:{
int i = 0
for( company in (appForm?.companyProfiles) ) {
printHtmlPart(7)
if(true && (appForm?.companyProfiles?.size() - i == 1)) {
printHtmlPart(8)
expressionOut.print(company?.address1)
printHtmlPart(8)
expressionOut.print(company?.address2)
printHtmlPart(8)
expressionOut.print(company?.address3)
printHtmlPart(7)
}
else {
printHtmlPart(8)
expressionOut.print(company?.address1)
printHtmlPart(8)
expressionOut.print(company?.address2)
printHtmlPart(8)
expressionOut.print(company?.address3)
printHtmlPart(17)
}
printHtmlPart(10)
i++
}
}
printHtmlPart(18)
}
printHtmlPart(19)
if(true && (formType == 'Form1')) {
printHtmlPart(20)
}
else if(true && (formType == 'Form2')) {
printHtmlPart(21)
}
else if(true && (formType == 'Form3')) {
printHtmlPart(22)
}
else if(true && (formType == 'Form4')) {
printHtmlPart(23)
}
printHtmlPart(24)
if(true && (formType == 'Form1')) {
printHtmlPart(25)
}
else if(true && (formType == 'Form2')) {
printHtmlPart(26)
}
else if(true && (formType == 'Form3')) {
printHtmlPart(27)
}
else if(true && (formType == 'Form4')) {
printHtmlPart(28)
}
printHtmlPart(29)
expressionOut.print(appForm?.appNumber)
printHtmlPart(30)
if(true && (appForm?.depostionOfMicroOrganism?.size() == 0)) {
printHtmlPart(7)
for( deposition in (appForm?.depostionOfMicroOrganism) ) {
printHtmlPart(8)
expressionOut.print(deposition?.nameOfDepositor)
printHtmlPart(9)
}
printHtmlPart(10)
}
printHtmlPart(31)
if(true && (appForm?.companyProfiles?.size() == 0)) {
printHtmlPart(7)
invokeTag('set','g',200,['value':("Individual"),'var':("type")],-1)
printHtmlPart(7)
for( individual in (appForm?.individualProfiles) ) {
printHtmlPart(8)
expressionOut.print(individual?.title)
printHtmlPart(8)
expressionOut.print(individual?.firstName)
printHtmlPart(8)
expressionOut.print(individual?.middleName)
printHtmlPart(8)
expressionOut.print(individual?.lastName)
printHtmlPart(14)
}
printHtmlPart(10)
}
else {
printHtmlPart(10)
invokeTag('set','g',208,['value':("Company"),'var':("type")],-1)
printHtmlPart(7)
for( company in (appForm?.companyProfiles) ) {
printHtmlPart(8)
expressionOut.print(company?.entityName)
printHtmlPart(14)
}
printHtmlPart(10)
}
printHtmlPart(32)
if(true && (appForm?.depostionOfMicroOrganism?.size() == 0)) {
printHtmlPart(7)
for( deposition in (appForm?.depostionOfMicroOrganism) ) {
printHtmlPart(8)
expressionOut.print(deposition?.nameOfDepositor)
printHtmlPart(9)
}
printHtmlPart(10)
}
printHtmlPart(31)
if(true && (appForm?.companyProfiles?.size() == 0)) {
printHtmlPart(33)
for( individual in (appForm?.individualProfiles) ) {
printHtmlPart(8)
expressionOut.print(individual?.title)
printHtmlPart(8)
expressionOut.print(individusaal?.firstName)
printHtmlPart(8)
expressionOut.print(individual?.middleName)
printHtmlPart(8)
expressionOut.print(individual?.lastName)
printHtmlPart(14)
}
printHtmlPart(10)
}
else {
printHtmlPart(34)
for( company in (appForm?.companyProfiles) ) {
printHtmlPart(8)
expressionOut.print(company?.entityName)
printHtmlPart(14)
}
printHtmlPart(35)
}
printHtmlPart(36)
expressionOut.print(type)
printHtmlPart(37)
expressionOut.print(email)
printHtmlPart(38)
expressionOut.print(new Date().format('dd/MM/yyyy HH:mm:ss'))
printHtmlPart(39)
expressionOut.print(ipAddress)
printHtmlPart(40)
}
else {
printHtmlPart(41)
expressionOut.print(resource(dir: 'images', file: 'amblam.png'))
printHtmlPart(42)
if(true && (formType == 'FormC')) {
printHtmlPart(43)
}
else {
printHtmlPart(44)
}
printHtmlPart(45)
if(true && (formType == 'FormC')) {
printHtmlPart(46)
expressionOut.print(appForm?.appNumber)
printHtmlPart(47)
for( deposition in (appForm?.depostionOfMicroOrganism) ) {
printHtmlPart(7)
expressionOut.print(deposition?.nameOfDepositor)
printHtmlPart(5)
}
printHtmlPart(48)
for( deposition in (appForm?.depostionOfMicroOrganism) ) {
printHtmlPart(7)
expressionOut.print(deposition?.address1)
printHtmlPart(7)
expressionOut.print(deposition?.address2)
printHtmlPart(7)
expressionOut.print(deposition?.address3)
printHtmlPart(49)
}
printHtmlPart(50)
expressionOut.print(foreignRepo?.repostoryName)
printHtmlPart(51)
}
else {
printHtmlPart(52)
if(true && (appForm?.companyProfiles?.size() == 0)) {
printHtmlPart(7)
for( individual in (appForm?.individualProfiles) ) {
printHtmlPart(8)
expressionOut.print(individual?.title)
printHtmlPart(8)
expressionOut.print(individual?.firstName)
printHtmlPart(8)
expressionOut.print(individual?.middleName)
printHtmlPart(8)
expressionOut.print(individual?.lastName)
printHtmlPart(14)
}
printHtmlPart(10)
}
else {
printHtmlPart(7)
for( company in (appForm?.companyProfiles) ) {
printHtmlPart(8)
expressionOut.print(company?.entityName)
printHtmlPart(14)
}
printHtmlPart(10)
}
printHtmlPart(53)
if(true && (listOfIndianResearcher)) {
printHtmlPart(7)
for( indianResearcher in (listOfIndianResearcher) ) {
printHtmlPart(8)
expressionOut.print(indianResearcher?.title)
printHtmlPart(8)
expressionOut.print(indianResearcher?.firstName)
printHtmlPart(8)
expressionOut.print(indianResearcher?.middleName)
printHtmlPart(8)
expressionOut.print(indianResearcher?.lastName)
printHtmlPart(14)
}
printHtmlPart(10)
}
else if(true && (listOfIndianGovtInst)) {
printHtmlPart(7)
for( govtInst in (listOfIndianGovtInst) ) {
printHtmlPart(8)
expressionOut.print(govtInst?.govtInstName)
printHtmlPart(17)
}
printHtmlPart(10)
}
printHtmlPart(48)
if(true && (appForm?.companyProfiles?.size() == 0)) {
printHtmlPart(7)
loop:{
int i = 0
for( individual in (individualProfileList) ) {
printHtmlPart(8)
if(true && (appForm?.individualProfiles?.size() - i == 1)) {
printHtmlPart(54)
expressionOut.print(individual?.address1)
printHtmlPart(54)
expressionOut.print(individual?.address2)
printHtmlPart(54)
expressionOut.print(individual?.address3)
printHtmlPart(8)
}
else {
printHtmlPart(54)
expressionOut.print(individual?.address1)
printHtmlPart(54)
expressionOut.print(individual?.address2)
printHtmlPart(54)
expressionOut.print(individual?.address3)
printHtmlPart(17)
}
printHtmlPart(7)
i++
}
}
printHtmlPart(10)
}
else {
printHtmlPart(7)
loop:{
int i = 0
for( company in (companyProfileList) ) {
printHtmlPart(8)
if(true && (appForm?.companyProfiles?.size() - i == 1)) {
printHtmlPart(54)
expressionOut.print(company?.address1)
printHtmlPart(54)
expressionOut.print(company?.address2)
printHtmlPart(54)
expressionOut.print(company?.address3)
printHtmlPart(8)
}
else {
printHtmlPart(54)
expressionOut.print(company?.address1)
printHtmlPart(54)
expressionOut.print(company?.address2)
printHtmlPart(54)
expressionOut.print(company?.address3)
printHtmlPart(17)
}
printHtmlPart(7)
i++
}
}
printHtmlPart(10)
}
printHtmlPart(53)
if(true && (listOfIndianResearcher)) {
printHtmlPart(7)
for( researcher in (listOfIndianResearcher) ) {
printHtmlPart(8)
expressionOut.print(researcher?.address1)
printHtmlPart(55)
expressionOut.print(researcher?.address2)
printHtmlPart(56)
expressionOut.print(researcher?.address3)
printHtmlPart(56)
expressionOut.print(researcher?.city)
printHtmlPart(57)
expressionOut.print(researcher?.pincode)
printHtmlPart(55)
expressionOut.print(researcher?.province)
printHtmlPart(56)
expressionOut.print(researcher?.country?.country)
printHtmlPart(7)
}
printHtmlPart(10)
}
else if(true && (listOfIndianGovtInst)) {
printHtmlPart(7)
for( govtinst in (listOfIndianGovtInst) ) {
printHtmlPart(8)
expressionOut.print(govtinst?.address1)
printHtmlPart(55)
expressionOut.print(govtinst?.address2)
printHtmlPart(56)
expressionOut.print(govtinst?.address3)
printHtmlPart(56)
expressionOut.print(govtinst?.city)
printHtmlPart(57)
expressionOut.print(govtinst?.pincode)
printHtmlPart(55)
expressionOut.print(govtinst?.province)
printHtmlPart(56)
expressionOut.print(govtinst?.country?.country)
printHtmlPart(7)
}
printHtmlPart(10)
}
printHtmlPart(58)
if(true && (params.formType == 'Form1')) {
printHtmlPart(59)
}
else if(true && (params.formType == 'Form2')) {
printHtmlPart(60)
}
else if(true && (params.formType == 'Form3')) {
printHtmlPart(61)
}
else if(true && (params.formType == 'Form4')) {
printHtmlPart(62)
}
else if(true && (params.formType == 'FormB')) {
printHtmlPart(63)
}
printHtmlPart(64)
if(true && (formType == 'Form1')) {
printHtmlPart(65)
}
else if(true && (formType == 'Form2')) {
printHtmlPart(66)
}
else if(true && (formType == 'Form3')) {
printHtmlPart(67)
}
else if(true && (formType == 'Form4')) {
printHtmlPart(68)
}
else if(true && (formType == 'FormB')) {
printHtmlPart(69)
}
printHtmlPart(70)
expressionOut.print(appForm?.appNumber)
printHtmlPart(71)
}
printHtmlPart(72)
if(true && (formType != 'FormC')) {
printHtmlPart(73)
if(true && (listOfIndianResearcher)) {
printHtmlPart(8)
for( researcher in (listOfIndianResearcher) ) {
printHtmlPart(74)
expressionOut.print(researcher?.title)
printHtmlPart(75)
expressionOut.print(researcher?.firstName)
printHtmlPart(75)
expressionOut.print(researcher?.middleName)
printHtmlPart(75)
expressionOut.print(researcher?.lastName)
printHtmlPart(76)
}
printHtmlPart(10)
}
else if(true && (listOfIndianGovtInst)) {
printHtmlPart(7)
for( govtinst in (listOfIndianGovtInst) ) {
printHtmlPart(74)
expressionOut.print(govtinst?.govtInstName)
printHtmlPart(77)
}
printHtmlPart(10)
}
printHtmlPart(10)
if(true && (appForm?.companyProfiles?.size() == 0)) {
printHtmlPart(7)
for( individual in (individualProfileList) ) {
printHtmlPart(78)
expressionOut.print(individual?.title)
printHtmlPart(56)
expressionOut.print(individual?.firstName)
printHtmlPart(56)
expressionOut.print(individual?.middleName)
printHtmlPart(54)
expressionOut.print(individual?.lastName)
printHtmlPart(79)
}
printHtmlPart(10)
}
else {
printHtmlPart(7)
for( company in (companyProfileList) ) {
printHtmlPart(78)
expressionOut.print(company?.entityName)
printHtmlPart(79)
}
printHtmlPart(80)
}
printHtmlPart(81)
}
printHtmlPart(82)
if(true && (formType == 'FormC')) {
printHtmlPart(83)
}
printHtmlPart(84)
if(true && (formType != 'FormC')) {
printHtmlPart(85)
out.print(new Date().format( 'dd-MM-yyyy' ))
printHtmlPart(86)
}
printHtmlPart(87)
}
printHtmlPart(88)
createClosureForHtmlPart(89, 1)
invokeTag('link','g',594,['controller':("loggedInAs"),'action':("inbox"),'class':("btn btn-primary"),'params':([appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(35)
createClosureForHtmlPart(90, 1)
invokeTag('link','g',597,['controller':("applicationManagement"),'action':("changeStatus"),'class':("btn btn-primary"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(35)
createClosureForHtmlPart(91, 1)
invokeTag('link','g',600,['controller':("applicationManagement"),'action':("form1feedback"),'class':("btn btn-primary"),'params':([appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(35)
createClosureForHtmlPart(92, 1)
invokeTag('link','g',603,['controller':("formPreview"),'action':("printAcknowledgement"),'class':("btn btn-primary"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(93)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1582111442000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
