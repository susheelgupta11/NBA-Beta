import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_loggedInAsnotifications_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loggedInAs/notifications.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("loggedInUser")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(5)
for( notification in (listOfNotifications?.sort{it?.id}) ) {
printHtmlPart(6)
if(true && (notification?.docName == 'Notification 1.')) {
printHtmlPart(7)
createClosureForHtmlPart(8, 4)
invokeTag('link','g',35,['controller':("loggedInAs"),'action':("showDc"),'id':(notification?.id),'params':([filename: "notification1", dataName: "notification1"]),'target':("_blank")],4)
printHtmlPart(9)
}
printHtmlPart(6)
if(true && (notification?.docName == 'Notification 2.')) {
printHtmlPart(10)
createClosureForHtmlPart(11, 4)
invokeTag('link','g',46,['controller':("loggedInAs"),'action':("showDc"),'id':(notification?.id),'params':([filename: "notification2", dataName: "notification2"]),'target':("_blank")],4)
printHtmlPart(9)
}
printHtmlPart(6)
if(true && (notification?.docName == 'Notification 3.')) {
printHtmlPart(12)
createClosureForHtmlPart(13, 4)
invokeTag('link','g',57,['controller':("loggedInAs"),'action':("showDc"),'id':(notification?.id),'params':([filename: "notification3", dataName: "notification3"]),'target':("_blank")],4)
printHtmlPart(9)
}
printHtmlPart(6)
if(true && (notification?.docName == 'Notification 4.')) {
printHtmlPart(14)
createClosureForHtmlPart(15, 4)
invokeTag('link','g',69,['controller':("loggedInAs"),'action':("showDc"),'id':(notification?.id),'params':([filename: "notification4", dataName: "notification4"]),'target':("_blank")],4)
printHtmlPart(9)
}
printHtmlPart(6)
if(true && (notification?.docName == 'Notification 5.(i)')) {
printHtmlPart(16)
if(true && (notification5i)) {
printHtmlPart(17)
createClosureForHtmlPart(18, 5)
invokeTag('link','g',82,['controller':("loggedInAs"),'action':("showDc"),'id':(notification5i?.id),'params':([filename: "notification5i", dataName: "notification5i"]),'target':("_blank")],5)
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (notification5ii)) {
printHtmlPart(17)
createClosureForHtmlPart(21, 5)
invokeTag('link','g',89,['controller':("loggedInAs"),'action':("showDc"),'id':(notification5ii?.id),'params':([filename: "notification5ii", dataName: "notification5ii"]),'target':("_blank")],5)
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (notification5iii)) {
printHtmlPart(17)
createClosureForHtmlPart(22, 5)
invokeTag('link','g',96,['controller':("loggedInAs"),'action':("showDc"),'id':(notification5iii?.id),'params':([filename: "notification5iii", dataName: "notification5iii"]),'target':("_blank")],5)
printHtmlPart(19)
}
printHtmlPart(23)
}
printHtmlPart(6)
if(true && (notification?.docName == 'Notification 6.')) {
printHtmlPart(24)
createClosureForHtmlPart(25, 4)
invokeTag('link','g',109,['controller':("loggedInAs"),'action':("showDc"),'id':(notification?.id),'params':([filename: "notification6", dataName: "notification6"]),'target':("_blank")],4)
printHtmlPart(9)
}
printHtmlPart(6)
if(true && (notification?.docName == 'Notification 7.')) {
printHtmlPart(26)
createClosureForHtmlPart(27, 4)
invokeTag('link','g',120,['controller':("loggedInAs"),'action':("showDc"),'id':(notification?.id),'params':([filename: "notification7", dataName: "notification7"]),'target':("_blank")],4)
printHtmlPart(9)
}
printHtmlPart(6)
if(true && (notification?.docName == 'Notification 8.')) {
printHtmlPart(28)
createClosureForHtmlPart(29, 4)
invokeTag('link','g',133,['controller':("loggedInAs"),'action':("showDc"),'id':(notification?.id),'params':([filename: "notification8", dataName: "notification8"]),'target':("_blank")],4)
printHtmlPart(9)
}
printHtmlPart(6)
if(true && (notification?.docName == 'Notification 9.(a- Bihar)')) {
printHtmlPart(30)
if(true && (notificationBihar)) {
createClosureForHtmlPart(31, 5)
invokeTag('link','g',145,['controller':("loggedInAs"),'action':("showDc"),'id':(notificationBihar?.id),'params':([filename: "notificationBihar", dataName: "notificationBihar"]),'target':("_blank")],5)
}
printHtmlPart(32)
if(true && (notificationGoa)) {
createClosureForHtmlPart(33, 5)
invokeTag('link','g',150,['controller':("loggedInAs"),'action':("showDc"),'id':(notificationGoa?.id),'params':([filename: "notificationGoa", dataName: "notificationGoa",csrfPreventionSalt:"${csrfPreventionSalt}"]),'target':("_blank")],5)
}
printHtmlPart(34)
if(true && (notificationHimachal)) {
createClosureForHtmlPart(35, 5)
invokeTag('link','g',155,['controller':("loggedInAs"),'action':("showDc"),'id':(notificationHimachal?.id),'params':([filename: "notificationHimachal", dataName: "notificationHimachal",csrfPreventionSalt:"${csrfPreventionSalt}"]),'target':("_blank")],5)
}
printHtmlPart(32)
if(true && (notificationKarnataka)) {
createClosureForHtmlPart(36, 5)
invokeTag('link','g',160,['controller':("loggedInAs"),'action':("showDc"),'id':(notificationKarnataka?.id),'params':([filename: "notificationKarnataka", dataName: "notificationKarnataka",csrfPreventionSalt:"${csrfPreventionSalt}"]),'target':("_blank")],5)
}
printHtmlPart(32)
if(true && (notificationKerala)) {
createClosureForHtmlPart(37, 5)
invokeTag('link','g',165,['controller':("loggedInAs"),'action':("showDc"),'id':(notificationKerala?.id),'params':([filename: "notificationKerala", dataName: "notificationKerala",csrfPreventionSalt:"${csrfPreventionSalt}"]),'target':("_blank")],5)
}
printHtmlPart(34)
if(true && (notificationMadhya)) {
createClosureForHtmlPart(38, 5)
invokeTag('link','g',170,['controller':("loggedInAs"),'action':("showDc"),'id':(notificationMadhya?.id),'params':([filename: "notificationMadhya", dataName: "notificationMadhya",csrfPreventionSalt:"${csrfPreventionSalt}"]),'target':("_blank")],5)
}
printHtmlPart(32)
if(true && (notificationManipur)) {
createClosureForHtmlPart(39, 5)
invokeTag('link','g',175,['controller':("loggedInAs"),'action':("showDc"),'id':(notificationManipur?.id),'params':([filename: "notificationManipur", dataName: "notificationManipur",csrfPreventionSalt:"${csrfPreventionSalt}"]),'target':("_blank")],5)
}
printHtmlPart(32)
if(true && (notificationMeghalaya)) {
createClosureForHtmlPart(40, 5)
invokeTag('link','g',180,['controller':("loggedInAs"),'action':("showDc"),'id':(notificationMeghalaya?.id),'params':([filename: "notificationMeghalaya", dataName: "notificationMeghalaya",csrfPreventionSalt:"${csrfPreventionSalt}"]),'target':("_blank")],5)
}
printHtmlPart(32)
if(true && (notificationMizoram)) {
createClosureForHtmlPart(41, 5)
invokeTag('link','g',185,['controller':("loggedInAs"),'action':("showDc"),'id':(notificationMizoram?.id),'params':([filename: "notificationMizoram", dataName: "notificationMizoram",csrfPreventionSalt:"${csrfPreventionSalt}"]),'target':("_blank")],5)
}
printHtmlPart(32)
if(true && (notificationOrissa)) {
createClosureForHtmlPart(42, 5)
invokeTag('link','g',190,['controller':("loggedInAs"),'action':("showDc"),'id':(notificationOrissa?.id),'params':([filename: "notificationOrissa", dataName: "notificationOrissa",csrfPreventionSalt:"${csrfPreventionSalt}"]),'target':("_blank")],5)
}
printHtmlPart(34)
if(true && (notificationPunjab)) {
createClosureForHtmlPart(43, 5)
invokeTag('link','g',195,['controller':("loggedInAs"),'action':("showDc"),'id':(notificationPunjab?.id),'params':([filename: "notificationPunjab", dataName: "notificationPunjab",csrfPreventionSalt:"${csrfPreventionSalt}"]),'target':("_blank")],5)
}
printHtmlPart(32)
if(true && (notificationTamil)) {
printHtmlPart(20)
createClosureForHtmlPart(44, 5)
invokeTag('link','g',200,['controller':("loggedInAs"),'action':("showDc"),'id':(notificationTamil?.id),'params':([filename: "notificationTamil", dataName: "notificationTamil",csrfPreventionSalt:"${csrfPreventionSalt}"]),'target':("_blank")],5)
}
printHtmlPart(32)
if(true && (notificationTripura)) {
createClosureForHtmlPart(45, 5)
invokeTag('link','g',205,['controller':("loggedInAs"),'action':("showDc"),'id':(notificationTripura?.id),'params':([filename: "notificationTripura", dataName: "notificationTripura",csrfPreventionSalt:"${csrfPreventionSalt}"]),'target':("_blank")],5)
}
printHtmlPart(32)
if(true && (notificationUttar)) {
createClosureForHtmlPart(46, 5)
invokeTag('link','g',210,['controller':("loggedInAs"),'action':("showDc"),'id':(notificationUttar?.id),'params':([filename: "notificationUttar", dataName: "notificationUttar",csrfPreventionSalt:"${csrfPreventionSalt}"]),'target':("_blank")],5)
}
printHtmlPart(32)
if(true && (notificationUttarakhand)) {
createClosureForHtmlPart(47, 5)
invokeTag('link','g',215,['controller':("loggedInAs"),'action':("showDc"),'id':(notificationUttarakhand?.id),'params':([filename: "notificationUttarakhand", dataName: "notificationUttarakhand",csrfPreventionSalt:"${csrfPreventionSalt}"]),'target':("_blank")],5)
}
printHtmlPart(32)
if(true && (notificationWest)) {
createClosureForHtmlPart(48, 5)
invokeTag('link','g',220,['controller':("loggedInAs"),'action':("showDc"),'id':(notificationWest?.id),'params':([filename: "notificationWest", dataName: "notificationWest",csrfPreventionSalt:"${csrfPreventionSalt}"]),'target':("_blank")],5)
}
printHtmlPart(34)
if(true && (notificationBihar)) {
createClosureForHtmlPart(49, 5)
invokeTag('link','g',225,['controller':("loggedInAs"),'action':("showDc"),'id':(notification?.id),'params':([filename: "notificationBihar", dataName: "notificationBihar",csrfPreventionSalt:"${csrfPreventionSalt}"]),'target':("_blank")],5)
}
printHtmlPart(34)
if(true && (notificationBihar)) {
createClosureForHtmlPart(50, 5)
invokeTag('link','g',230,['controller':("loggedInAs"),'action':("showDc"),'id':(notification?.id),'params':([filename: "notificationBihar", dataName: "notificationBihar",csrfPreventionSalt:"${csrfPreventionSalt}"]),'target':("_blank")],5)
}
printHtmlPart(51)
}
printHtmlPart(6)
if(true && (notification?.docName == 'Notification 10.')) {
printHtmlPart(52)
createClosureForHtmlPart(53, 4)
invokeTag('link','g',242,['controller':("loggedInAs"),'action':("showDc"),'id':(notification?.id),'params':([filename: "notification10", dataName: "notification10",csrfPreventionSalt:"${csrfPreventionSalt}"]),'target':("_blank")],4)
printHtmlPart(9)
}
printHtmlPart(54)
}
printHtmlPart(55)
})
invokeTag('captureBody','sitemesh',251,[:],1)
printHtmlPart(56)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1537268168000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
