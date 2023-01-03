
import org.nba.user.NbaUser


import org.nba.user.NbaUserNbaRole


import org.nba.user.NbaRole


import org.nba.user.RoleEnum


import org.nba.application.ApplicationForm1


import org.nba.application.FormCategory


import org.nba.user.LinkOfficer

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_layouts_dashboardHeader_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/_dashboardHeader.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
invokeTag('set','g',8,['var':("headerDetails"),'value':(formDetails)],-1)
printHtmlPart(1)
if(true && (headerDetails)) {
printHtmlPart(2)
createClosureForHtmlPart(3, 2)
invokeTag('javascript','g',18,[:],2)
printHtmlPart(0)
}
printHtmlPart(4)
createClosureForHtmlPart(5, 1)
invokeTag('link','g',26,['controller':("loggedInAs"),'action':("inbox"),'params':([csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(6)
createClosureForHtmlPart(7, 1)
invokeTag('link','g',28,['controller':("logout"),'params':([csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(8)
invokeTag('set','g',33,['var':("userObject"),'value':(NbaUser.findByUsername(sec.loggedInUserInfo(field:'username')))],-1)
printHtmlPart(9)
invokeTag('set','g',34,['var':("getNbaRole"),'value':(userObject?.nbaRole)],-1)
printHtmlPart(10)
invokeTag('set','g',35,['var':("getRoleDetails"),'value':(NbaRole.get(getNbaRole?.id))],-1)
printHtmlPart(10)
invokeTag('set','g',36,['var':("getAuthority"),'value':(getRoleDetails?.authority)],-1)
printHtmlPart(11)
invokeTag('set','g',38,['var':("linkDetails"),'value':(LinkOfficer.findByNbaUserTo(userObject))],-1)
printHtmlPart(10)
invokeTag('set','g',39,['var':("linkOfficerName"),'value':(" ${linkDetails?.nbaUserFrom?.answer}")],-1)
printHtmlPart(12)
invokeTag('set','g',40,['var':("linkRole"),'value':(linkDetails?.nbaUserFrom?.nbaRole)],-1)
printHtmlPart(13)
invokeTag('set','g',41,['var':("linkAuth"),'value':(linkRole?.authority)],-1)
printHtmlPart(14)
expressionOut.print(resource(dir: 'images', file: 'Logo1.jpg'))
printHtmlPart(15)
if(true && (linkOfficer == 'Yes')) {
printHtmlPart(16)
expressionOut.print(linkOfficerName)
printHtmlPart(17)
expressionOut.print(linkAuth)
printHtmlPart(18)
}
else {
printHtmlPart(19)
createTagBody(2, {->
printHtmlPart(20)
expressionOut.print(userObject?.name)
printHtmlPart(21)
expressionOut.print(getAuthority)
printHtmlPart(19)
})
invokeTag('ifLoggedIn','sec',54,[:],2)
printHtmlPart(19)
}
printHtmlPart(22)
if(true && (headerDetails?.individualProfiles)) {
printHtmlPart(23)
for( individualProfile in (headerDetails?.individualProfiles) ) {
printHtmlPart(24)
expressionOut.print(individualProfile?.title)
printHtmlPart(25)
expressionOut.print(individualProfile?.firstName)
printHtmlPart(25)
expressionOut.print(individualProfile?.middleName)
printHtmlPart(25)
expressionOut.print(individualProfile?.lastName)
printHtmlPart(26)
}
printHtmlPart(27)
}
else if(true && (headerDetails?.companyProfiles)) {
printHtmlPart(26)
loop:{
int k = 0
for( company in (headerDetails?.companyProfiles) ) {
printHtmlPart(25)
expressionOut.print(company?.entityName)
printHtmlPart(26)
k++
}
}
printHtmlPart(27)
}
else if(true && (headerDetails?.indianResearcher)) {
printHtmlPart(26)
for( researcher in (headerDetails?.indianResearcher) ) {
printHtmlPart(24)
expressionOut.print(researcher?.title)
printHtmlPart(25)
expressionOut.print(researcher?.firstName)
printHtmlPart(25)
expressionOut.print(researcher?.middleName)
printHtmlPart(25)
expressionOut.print(researcher?.lastName)
printHtmlPart(28)
}
printHtmlPart(27)
}
else if(true && (headerDetails?.depostionOfMicroOrganism)) {
printHtmlPart(26)
for( depost in (headerDetails?.depostionOfMicroOrganism) ) {
printHtmlPart(25)
expressionOut.print(depost?.nameOfDepositor)
printHtmlPart(26)
}
printHtmlPart(27)
}
else if(true && (headerDetails?.indianGovtInst)) {
printHtmlPart(26)
for( govt in (headerDetails?.indianGovtInst) ) {
printHtmlPart(25)
expressionOut.print(govt?.govtInstName)
printHtmlPart(26)
}
printHtmlPart(27)
}
printHtmlPart(29)
expressionOut.print(headerDetails?.appNumber)
printHtmlPart(30)
if(true && (headerDetails?.individualProfiles)) {
printHtmlPart(31)
}
else if(true && (headerDetails?.companyProfiles)) {
printHtmlPart(26)
for( ct in (headerDetails?.companyProfiles) ) {
printHtmlPart(32)
expressionOut.print(ct?.entityType)
printHtmlPart(26)
}
printHtmlPart(32)
}
else if(true && (headerDetails?.indianGovtInst)) {
printHtmlPart(33)
}
else if(true && (headerDetails?.depostionOfMicroOrganism)) {
printHtmlPart(34)
}
else if(true && (headerDetails?.indianResearcher)) {
printHtmlPart(35)
}
printHtmlPart(36)
if(true && (headerDetails?.individualProfiles)) {
printHtmlPart(26)
for( natio in (headerDetails?.individualProfiles) ) {
printHtmlPart(26)
if(true && (natio?.nationality == 'Indian')) {
printHtmlPart(37)
}
else {
printHtmlPart(38)
}
printHtmlPart(26)
}
printHtmlPart(27)
}
else if(true && (headerDetails?.companyProfiles)) {
printHtmlPart(39)
for( natio in (headerDetails?.companyProfiles) ) {
printHtmlPart(40)
if(true && (natio?.nationality == 'registeredInIndia' || 'noNonIndianParticipation'== natio?.nationality)) {
printHtmlPart(37)
}
else {
printHtmlPart(38)
}
printHtmlPart(26)
}
printHtmlPart(27)
}
else if(true && (headerDetails?.indianGovtInst)) {
printHtmlPart(41)
}
else if(true && (headerDetails?.depostionOfMicroOrganism)) {
printHtmlPart(26)
for( natio in (headerDetails?.depostionOfMicroOrganism) ) {
printHtmlPart(25)
if(true && (natio?.nationality == 'Indian')) {
printHtmlPart(37)
}
else {
printHtmlPart(38)
}
printHtmlPart(26)
}
printHtmlPart(27)
}
else if(true && (headerDetails?.indianResearcher)) {
printHtmlPart(42)
}
printHtmlPart(43)
if(true && (headerDetails?.category?.category == FormCategory?.Category?.Form_1)) {
printHtmlPart(44)
invokeTag('set','g',165,['var':("fee"),'value':("10,000 /-")],-1)
printHtmlPart(45)
}
else if(true && (headerDetails?.category?.category == FormCategory?.Category?.Form_2)) {
printHtmlPart(46)
invokeTag('set','g',170,['var':("fee"),'value':("5,000 /-")],-1)
printHtmlPart(45)
}
else if(true && (headerDetails?.category?.category == FormCategory?.Category?.Form_3)) {
printHtmlPart(47)
invokeTag('set','g',175,['var':("fee"),'value':("500 /-")],-1)
printHtmlPart(45)
}
else if(true && (headerDetails?.category?.category == FormCategory?.Category?.Form_4)) {
printHtmlPart(48)
invokeTag('set','g',178,['var':("fee"),'value':("10,000 /-")],-1)
printHtmlPart(45)
}
else if(true && (headerDetails?.category?.category == FormCategory?.Category?.Form_B)) {
printHtmlPart(49)
}
else if(true && (headerDetails?.category?.category == FormCategory?.Category?.Form_C)) {
printHtmlPart(50)
}
printHtmlPart(51)
expressionOut.print(fee)
printHtmlPart(52)
if(true && (headerDetails?.versionApplicationForm1 != null)) {
printHtmlPart(45)
expressionOut.print(headerDetails?.versionApplicationForm1.size()+1)
printHtmlPart(45)
}
else if(true && (formDetails)) {
printHtmlPart(53)
}
printHtmlPart(54)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1648113463227L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
