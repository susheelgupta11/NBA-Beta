import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formPreviewprintAcknowledgement_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formPreview/printAcknowledgement.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("projectPreview")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',28,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(4)
if(true && (appForm?.isDeclarationDigitallySigned == 'true')) {
printHtmlPart(5)
expressionOut.print(resource(dir: 'images', file: 'amblam.png'))
printHtmlPart(6)
if(true && (formType == 'FormC')) {
printHtmlPart(7)
if(true && (appForm?.appNumber)) {
printHtmlPart(8)
expressionOut.print(appForm?.appNumber)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (appForm?.depostionOfMicroOrganism?.size() == 0)) {
printHtmlPart(11)
for( deposition in (appForm?.depostionOfMicroOrganism) ) {
printHtmlPart(12)
expressionOut.print(deposition?.nameOfDepositor)
printHtmlPart(13)
}
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (appForm?.depostionOfMicroOrganism?.size() == 0)) {
printHtmlPart(11)
for( deposition in (appForm?.depostionOfMicroOrganism) ) {
printHtmlPart(12)
expressionOut.print(deposition?.nameOfDepositor)
printHtmlPart(13)
}
printHtmlPart(14)
}
printHtmlPart(16)
}
else {
printHtmlPart(17)
if(true && (appForm?.companyProfiles?.size() == 0)) {
printHtmlPart(11)
for( individual in (appForm?.individualProfiles) ) {
printHtmlPart(12)
expressionOut.print(individual?.title)
printHtmlPart(12)
expressionOut.print(individual?.firstName)
printHtmlPart(12)
expressionOut.print(individual?.middleName)
printHtmlPart(12)
expressionOut.print(individual?.lastName)
printHtmlPart(18)
}
printHtmlPart(14)
}
else {
printHtmlPart(11)
for( company in (appForm?.companyProfiles) ) {
printHtmlPart(12)
expressionOut.print(company?.entityName)
printHtmlPart(18)
}
printHtmlPart(14)
}
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (appForm?.companyProfiles?.size() == 0)) {
printHtmlPart(14)
loop:{
int i = 0
for( individual in (appForm?.individualProfiles) ) {
printHtmlPart(11)
if(true && (appForm?.individualProfiles?.size() - i == 1)) {
printHtmlPart(12)
expressionOut.print(individual?.address1)
printHtmlPart(12)
expressionOut.print(individual?.address2)
printHtmlPart(12)
expressionOut.print(individual?.address3)
printHtmlPart(11)
}
else {
printHtmlPart(12)
expressionOut.print(individual?.address1)
printHtmlPart(12)
expressionOut.print(individual?.address2)
printHtmlPart(12)
expressionOut.print(individual?.address3)
printHtmlPart(21)
}
printHtmlPart(14)
i++
}
}
printHtmlPart(22)
}
else {
printHtmlPart(14)
loop:{
int i = 0
for( company in (appForm?.companyProfiles) ) {
printHtmlPart(11)
if(true && (appForm?.companyProfiles?.size() - i == 1)) {
printHtmlPart(12)
expressionOut.print(company?.address1)
printHtmlPart(12)
expressionOut.print(company?.address2)
printHtmlPart(12)
expressionOut.print(company?.address3)
printHtmlPart(11)
}
else {
printHtmlPart(12)
expressionOut.print(company?.address1)
printHtmlPart(12)
expressionOut.print(company?.address2)
printHtmlPart(12)
expressionOut.print(company?.address3)
printHtmlPart(21)
}
printHtmlPart(14)
i++
}
}
printHtmlPart(22)
}
printHtmlPart(23)
if(true && (formType == 'Form1')) {
printHtmlPart(24)
}
else if(true && (formType == 'Form2')) {
printHtmlPart(25)
}
else if(true && (formType == 'Form3')) {
printHtmlPart(26)
}
else if(true && (formType == 'Form4')) {
printHtmlPart(27)
}
printHtmlPart(28)
if(true && (formType == 'Form1')) {
printHtmlPart(29)
}
else if(true && (formType == 'Form2')) {
printHtmlPart(30)
}
else if(true && (formType == 'Form3')) {
printHtmlPart(31)
}
else if(true && (formType == 'Form4')) {
printHtmlPart(32)
}
printHtmlPart(33)
expressionOut.print(appForm?.appNumber)
printHtmlPart(34)
if(true && (appForm?.depostionOfMicroOrganism?.size() == 0)) {
printHtmlPart(11)
for( deposition in (appForm?.depostionOfMicroOrganism) ) {
printHtmlPart(12)
expressionOut.print(deposition?.nameOfDepositor)
printHtmlPart(13)
}
printHtmlPart(14)
}
printHtmlPart(35)
if(true && (appForm?.companyProfiles?.size() == 0)) {
printHtmlPart(11)
invokeTag('set','g',227,['value':("Individual"),'var':("type")],-1)
printHtmlPart(11)
for( individual in (appForm?.individualProfiles) ) {
printHtmlPart(12)
expressionOut.print(individual?.title)
printHtmlPart(12)
expressionOut.print(individual?.firstName)
printHtmlPart(12)
expressionOut.print(individual?.middleName)
printHtmlPart(12)
expressionOut.print(individual?.lastName)
printHtmlPart(36)
}
printHtmlPart(14)
}
else {
printHtmlPart(14)
invokeTag('set','g',236,['value':("Company"),'var':("type")],-1)
printHtmlPart(11)
for( company in (appForm?.companyProfiles) ) {
printHtmlPart(12)
expressionOut.print(company?.entityName)
printHtmlPart(36)
}
printHtmlPart(14)
}
printHtmlPart(37)
if(true && (appForm?.depostionOfMicroOrganism?.size() == 0)) {
printHtmlPart(11)
for( deposition in (appForm?.depostionOfMicroOrganism) ) {
printHtmlPart(12)
expressionOut.print(deposition?.nameOfDepositor)
printHtmlPart(13)
}
printHtmlPart(14)
}
printHtmlPart(35)
if(true && (appForm?.companyProfiles?.size() == 0)) {
printHtmlPart(38)
for( individual in (appForm?.individualProfiles) ) {
printHtmlPart(12)
expressionOut.print(individual?.title)
printHtmlPart(12)
expressionOut.print(individual?.firstName)
printHtmlPart(12)
expressionOut.print(individual?.middleName)
printHtmlPart(12)
expressionOut.print(individual?.lastName)
printHtmlPart(36)
}
printHtmlPart(14)
}
else {
printHtmlPart(39)
for( company in (appForm?.companyProfiles) ) {
printHtmlPart(12)
expressionOut.print(company?.entityName)
printHtmlPart(36)
}
printHtmlPart(40)
}
printHtmlPart(41)
expressionOut.print(type)
printHtmlPart(42)
expressionOut.print(email)
printHtmlPart(43)
expressionOut.print(new Date().format('dd/MM/yyyy HH:mm:ss'))
printHtmlPart(44)
expressionOut.print(ipAddress)
printHtmlPart(45)
}
else {
printHtmlPart(46)
expressionOut.print(resource(dir: 'images', file: 'amblam.png'))
printHtmlPart(47)
if(true && (formType == 'FormC')) {
printHtmlPart(48)
}
else {
printHtmlPart(49)
}
printHtmlPart(50)
if(true && (formType == 'FormC')) {
printHtmlPart(51)
expressionOut.print(appForm?.appNumber)
printHtmlPart(52)
for( deposition in (appForm?.depostionOfMicroOrganism) ) {
printHtmlPart(11)
expressionOut.print(deposition?.nameOfDepositor)
printHtmlPart(9)
}
printHtmlPart(53)
for( deposition in (appForm?.depostionOfMicroOrganism) ) {
printHtmlPart(11)
expressionOut.print(deposition?.address1)
printHtmlPart(11)
expressionOut.print(deposition?.address2)
printHtmlPart(11)
expressionOut.print(deposition?.address3)
printHtmlPart(54)
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
printHtmlPart(11)
for( individual in (appForm?.individualProfiles) ) {
printHtmlPart(12)
expressionOut.print(individual?.title)
printHtmlPart(12)
expressionOut.print(individual?.firstName)
printHtmlPart(12)
expressionOut.print(individual?.middleName)
printHtmlPart(12)
expressionOut.print(individual?.lastName)
printHtmlPart(36)
}
printHtmlPart(14)
}
else {
printHtmlPart(11)
for( company in (appForm?.companyProfiles) ) {
printHtmlPart(12)
expressionOut.print(company?.entityName)
printHtmlPart(36)
}
printHtmlPart(14)
}
printHtmlPart(59)
if(true && (listOfIndianResearcher)) {
printHtmlPart(11)
for( indianResearcher in (listOfIndianResearcher) ) {
printHtmlPart(12)
expressionOut.print(indianResearcher?.title)
printHtmlPart(12)
expressionOut.print(indianResearcher?.firstName)
printHtmlPart(12)
expressionOut.print(indianResearcher?.middleName)
printHtmlPart(12)
expressionOut.print(indianResearcher?.lastName)
printHtmlPart(36)
}
printHtmlPart(14)
}
else if(true && (listOfIndianGovtInst)) {
printHtmlPart(11)
for( govtInst in (listOfIndianGovtInst) ) {
printHtmlPart(12)
expressionOut.print(govtInst?.govtInstName)
printHtmlPart(21)
}
printHtmlPart(14)
}
printHtmlPart(60)
if(true && (appForm?.companyProfiles?.size() == 0)) {
printHtmlPart(11)
loop:{
int i = 0
for( individual in (individualProfileList) ) {
printHtmlPart(12)
if(true && (appForm?.individualProfiles?.size() - i == 1)) {
printHtmlPart(61)
expressionOut.print(individual?.address1)
printHtmlPart(61)
expressionOut.print(individual?.address2)
printHtmlPart(61)
expressionOut.print(individual?.address3)
printHtmlPart(12)
}
else {
printHtmlPart(61)
expressionOut.print(individual?.address1)
printHtmlPart(61)
expressionOut.print(individual?.address2)
printHtmlPart(61)
expressionOut.print(individual?.address3)
printHtmlPart(21)
}
printHtmlPart(11)
i++
}
}
printHtmlPart(14)
}
else {
printHtmlPart(11)
loop:{
int i = 0
for( company in (companyProfileList) ) {
printHtmlPart(12)
if(true && (appForm?.companyProfiles?.size() - i == 1)) {
printHtmlPart(61)
expressionOut.print(company?.address1)
printHtmlPart(61)
expressionOut.print(company?.address2)
printHtmlPart(61)
expressionOut.print(company?.address3)
printHtmlPart(12)
}
else {
printHtmlPart(61)
expressionOut.print(company?.address1)
printHtmlPart(61)
expressionOut.print(company?.address2)
printHtmlPart(61)
expressionOut.print(company?.address3)
printHtmlPart(21)
}
printHtmlPart(11)
i++
}
}
printHtmlPart(14)
}
printHtmlPart(59)
if(true && (listOfIndianResearcher)) {
printHtmlPart(11)
for( researcher in (listOfIndianResearcher) ) {
printHtmlPart(12)
expressionOut.print(researcher?.address1)
printHtmlPart(62)
expressionOut.print(researcher?.address2)
printHtmlPart(63)
expressionOut.print(researcher?.address3)
printHtmlPart(63)
expressionOut.print(researcher?.city)
printHtmlPart(64)
expressionOut.print(researcher?.pincode)
printHtmlPart(62)
expressionOut.print(researcher?.province)
printHtmlPart(63)
expressionOut.print(researcher?.country?.country)
printHtmlPart(11)
}
printHtmlPart(14)
}
else if(true && (listOfIndianGovtInst)) {
printHtmlPart(11)
for( govtinst in (listOfIndianGovtInst) ) {
printHtmlPart(12)
expressionOut.print(govtinst?.address1)
printHtmlPart(62)
expressionOut.print(govtinst?.address2)
printHtmlPart(63)
expressionOut.print(govtinst?.address3)
printHtmlPart(63)
expressionOut.print(govtinst?.city)
printHtmlPart(64)
expressionOut.print(govtinst?.pincode)
printHtmlPart(62)
expressionOut.print(govtinst?.province)
printHtmlPart(63)
expressionOut.print(govtinst?.country?.country)
printHtmlPart(11)
}
printHtmlPart(14)
}
printHtmlPart(65)
if(true && (params.formType == 'Form1')) {
printHtmlPart(66)
}
else if(true && (params.formType == 'Form2')) {
printHtmlPart(67)
}
else if(true && (params.formType == 'Form3')) {
printHtmlPart(68)
}
else if(true && (params.formType == 'Form4')) {
printHtmlPart(69)
}
else if(true && (params.formType == 'FormB')) {
printHtmlPart(70)
}
printHtmlPart(71)
if(true && (formType == 'Form1')) {
printHtmlPart(72)
}
else if(true && (formType == 'Form2')) {
printHtmlPart(73)
}
else if(true && (formType == 'Form3')) {
printHtmlPart(74)
}
else if(true && (formType == 'Form4')) {
printHtmlPart(75)
}
else if(true && (formType == 'FormB')) {
printHtmlPart(76)
}
printHtmlPart(77)
expressionOut.print(appForm?.appNumber)
printHtmlPart(78)
}
printHtmlPart(79)
if(true && (formType != 'FormC')) {
printHtmlPart(80)
if(true && (listOfIndianResearcher)) {
printHtmlPart(12)
for( researcher in (listOfIndianResearcher) ) {
printHtmlPart(81)
expressionOut.print(researcher?.title)
printHtmlPart(82)
expressionOut.print(researcher?.firstName)
printHtmlPart(82)
expressionOut.print(researcher?.middleName)
printHtmlPart(82)
expressionOut.print(researcher?.lastName)
printHtmlPart(83)
}
printHtmlPart(14)
}
else if(true && (listOfIndianGovtInst)) {
printHtmlPart(11)
for( govtinst in (listOfIndianGovtInst) ) {
printHtmlPart(81)
expressionOut.print(govtinst?.govtInstName)
printHtmlPart(84)
}
printHtmlPart(14)
}
printHtmlPart(14)
if(true && (appForm?.companyProfiles?.size() == 0)) {
printHtmlPart(11)
for( individual in (individualProfileList) ) {
printHtmlPart(85)
expressionOut.print(individual?.title)
printHtmlPart(63)
expressionOut.print(individual?.firstName)
printHtmlPart(63)
expressionOut.print(individual?.middleName)
printHtmlPart(61)
expressionOut.print(individual?.lastName)
printHtmlPart(86)
}
printHtmlPart(14)
}
else {
printHtmlPart(11)
for( company in (companyProfileList) ) {
printHtmlPart(85)
expressionOut.print(company?.entityName)
printHtmlPart(86)
}
printHtmlPart(87)
}
printHtmlPart(88)
}
printHtmlPart(89)
if(true && (formType == 'FormC')) {
printHtmlPart(90)
}
printHtmlPart(91)
if(true && (formType != 'FormC')) {
printHtmlPart(92)
out.print(new Date().format( 'dd-MM-yyyy' ))
printHtmlPart(93)
}
printHtmlPart(94)
}
printHtmlPart(95)
})
invokeTag('captureBody','sitemesh',612,[:],1)
printHtmlPart(96)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1571034298000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
