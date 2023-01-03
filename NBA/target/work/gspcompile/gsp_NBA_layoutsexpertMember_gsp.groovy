
import org.nba.user.NbaUser


import org.nba.user.NbaUserNbaRole


import org.nba.user.NbaRole


import org.nba.user.LinkOfficer


import org.nba.user.RoleEnum


import org.nba.application.ApplicationForm1

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_layoutsexpertMember_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/expertMember.gsp" }
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

response.setHeader("Cache-Control","private");
response.setHeader("Cache-Control","no-store");
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", -1);

printHtmlPart(0)

response.setHeader("Cache-control","no-store"); //HTTP 1.1 
response.setHeader("Pragma","no-cache"); //HTTP1.0 
response.setDateHeader("Expire",0); //prevents caching at the proxy server

printHtmlPart(0)
invokeTag('captureMeta','sitemesh',32,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',33,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge,chrome=1")],-1)
printHtmlPart(0)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('layoutTitle','g',35,['default':("National Biodiversity Application")],-1)
})
invokeTag('captureTitle','sitemesh',35,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',35,[:],2)
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',36,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1.0")],-1)
printHtmlPart(2)
expressionOut.print(assetPath(src: 'logo.png'))
printHtmlPart(3)
expressionOut.print(assetPath(src: 'logo.png'))
printHtmlPart(4)
expressionOut.print(assetPath(src: 'logo.png'))
printHtmlPart(5)
expressionOut.print(assetPath(src: 'logo.png'))
printHtmlPart(6)
invokeTag('captureMeta','sitemesh',46,['gsp_sm_xmlClosingForEmptyTag':(""),'content':("width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"),'name':("viewport")],-1)
printHtmlPart(0)
invokeTag('stylesheet','asset',47,['src':("googlefont.css")],-1)
printHtmlPart(7)
invokeTag('stylesheet','asset',49,['src':("beta-version/css/bootstrap.min.css")],-1)
printHtmlPart(0)
invokeTag('stylesheet','asset',50,['src':("beta-version/css/responsive.bootstrap.min.css")],-1)
printHtmlPart(0)
invokeTag('stylesheet','asset',51,['src':("beta-version/css/font-awesome.min.css")],-1)
printHtmlPart(0)
invokeTag('stylesheet','asset',52,['src':("beta-version/css/AdminLTE.css")],-1)
printHtmlPart(0)
invokeTag('stylesheet','asset',53,['src':("beta-version/css/custom.css")],-1)
printHtmlPart(0)
invokeTag('stylesheet','asset',54,['src':("beta-version/css/all-skins.css")],-1)
printHtmlPart(0)
invokeTag('stylesheet','asset',55,['src':("beta-version/css/dataTables.bootstrap.min.css")],-1)
printHtmlPart(8)
invokeTag('stylesheet','asset',58,['src':("morquee.css")],-1)
printHtmlPart(7)
invokeTag('javascript','asset',60,['src':("beta-version/js/jquery.min.js")],-1)
printHtmlPart(0)
invokeTag('javascript','asset',61,['src':("beta-version/js/adminlte.min.js")],-1)
printHtmlPart(8)
invokeTag('layoutHead','g',61,[:],-1)
printHtmlPart(9)
})
invokeTag('captureHead','sitemesh',68,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(8)
invokeTag('set','g',75,['var':("headerDetails"),'value':(formDetails)],-1)
printHtmlPart(7)
if(true && (headerDetails)) {
printHtmlPart(10)
createClosureForHtmlPart(11, 3)
invokeTag('javascript','g',82,[:],3)
printHtmlPart(0)
}
printHtmlPart(12)
createClosureForHtmlPart(13, 2)
invokeTag('link','g',93,['controller':("expertCommittee"),'action':("expertDash"),'params':([csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(14)
createClosureForHtmlPart(15, 2)
invokeTag('link','g',95,['controller':("logout"),'params':([csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(16)
invokeTag('set','g',101,['var':("userObject"),'value':(NbaUser.findByUsername(sec.loggedInUserInfo(field:'username')))],-1)
printHtmlPart(17)
invokeTag('set','g',102,['var':("getNbaRole"),'value':(userObject?.nbaRole)],-1)
printHtmlPart(18)
invokeTag('set','g',103,['var':("getRoleDetails"),'value':(NbaRole.get(getNbaRole?.id))],-1)
printHtmlPart(18)
invokeTag('set','g',104,['var':("getAuthority"),'value':(getRoleDetails?.authority)],-1)
printHtmlPart(19)
invokeTag('set','g',106,['var':("linkDetails"),'value':(LinkOfficer.findByNbaUserTo(userObject))],-1)
printHtmlPart(17)
invokeTag('set','g',107,['var':("chkStatus"),'value':(linkDetails?.status)],-1)
printHtmlPart(17)
invokeTag('set','g',108,['var':("tillTime"),'value':(" ${linkDetails?.toDate}")],-1)
printHtmlPart(20)
expressionOut.print(resource(dir: 'images', file: 'Logo1.jpg'))
printHtmlPart(21)
createTagBody(2, {->
printHtmlPart(22)
expressionOut.print(userObject?.username)
printHtmlPart(23)
expressionOut.print(getAuthority)
printHtmlPart(24)
})
invokeTag('ifLoggedIn','sec',119,[:],2)
printHtmlPart(25)
invokeTag('javascript','asset',148,['src':("beta-version/js/datatable/jquery.min.js")],-1)
printHtmlPart(26)
invokeTag('javascript','asset',149,['src':("beta-version/js/datatable/bootstrap.min.js")],-1)
printHtmlPart(26)
invokeTag('javascript','asset',150,['src':("beta-version/js/datatable/jquery.dataTables.min.js")],-1)
printHtmlPart(26)
invokeTag('javascript','asset',151,['src':("beta-version/js/datatable/dataTables.bootstrap.min.")],-1)
printHtmlPart(26)
invokeTag('javascript','asset',152,['src':("beta-version/js/datatable/dataTables.responsive.min.js")],-1)
printHtmlPart(27)
createClosureForHtmlPart(28, 2)
invokeTag('link','g',180,['action':("expertCom"),'params':([csrfPreventionSalt:csrfPreventionSalt])],2)
printHtmlPart(29)
createClosureForHtmlPart(30, 2)
invokeTag('link','g',181,['action':("authority"),'params':([csrfPreventionSalt:csrfPreventionSalt])],2)
printHtmlPart(29)
createClosureForHtmlPart(31, 2)
invokeTag('link','g',182,['action':("internalCom"),'params':([csrfPreventionSalt:csrfPreventionSalt])],2)
printHtmlPart(29)
createClosureForHtmlPart(32, 2)
invokeTag('link','g',183,['action':("nbaSec"),'params':([csrfPreventionSalt:csrfPreventionSalt])],2)
printHtmlPart(33)
createClosureForHtmlPart(34, 2)
invokeTag('link','g',187,['action':("addReco"),'controller':("expertCommittee"),'params':([csrfPreventionSalt:csrfPreventionSalt])],2)
printHtmlPart(35)
invokeTag('layoutBody','g',192,[:],-1)
printHtmlPart(36)
invokeTag('render','g',199,['template':("/layouts/footer")],-1)
printHtmlPart(37)
})
invokeTag('captureBody','sitemesh',199,['class':("hold-transition skin-blue sidebar-mini")],1)
printHtmlPart(38)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1668157187845L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
