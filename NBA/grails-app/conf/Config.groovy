queryPath = "web-app/query/"




pdfFilePath = System.getProperty("java.io.tmpdir") + "/M-UPLOAD/"
pdfFileAttachedPath = System.getProperty("java.io.tmpdir") + "/NBA-FILE-ATTACH/"
fileForBenefitSharing = System.getProperty("java.io.tmpdir")+"/BENEFIT-SHARING/"
pdfAgendaDynPath = System.getProperty("java.io.tmpdir") + "/NBA-FILE-AGENDA-DYNAMIC/"
periodicreportFileAttachedPath = System.getProperty("java.io.tmpdir") + "/PERIODIC-FILE-ATTACH/"
periodicReportFiles = System.getProperty("java.io.tmpdir") + "/PERIODIC-FILES/"
docFileForAgenda =  System.getProperty("java.io.tmpdir") + "/DOC-AGENDA/"
fileForSBBConsent =  System.getProperty("java.io.tmpdir") + "/SBB-CONSENT/"
fileForKMS =  System.getProperty("java.io.tmpdir") + "/KMS/"
fileForRecommendation=  System.getProperty("java.io.tmpdir") + "/RECO-EC/"
manualUpload = System.getProperty("java.io.tmpdir") + "/Manual-data/"


// files path for phase one at local-- Added by Susheel Gupta

individualId = System.getProperty("java.io.tmpdir") + "/individual-Id/"
individualPassport = System.getProperty("java.io.tmpdir") + "/individual-Passport/"
individualAuthority = System.getProperty("java.io.tmpdir") + "/individual-Authority/"
agentDocuments = System.getProperty("java.io.tmpdir") + "/agent-documents/"
letterOfIntent = System.getProperty("java.io.tmpdir") + "/intent-letter/" 
sharingDoc     = System.getProperty("java.io.tmpdir") + "/sharing-doc/" 
paymentReceipt =  System.getProperty("java.io.tmpdir") + "/payment-doc/" 
companyRegistration = System.getProperty("java.io.tmpdir") + "/registration/"
companyPassport = System.getProperty("java.io.tmpdir") + "/passport/"
companyAuthority = System.getProperty("java.io.tmpdir") + "/authority/"
bonafide = System.getProperty("java.io.tmpdir") + "/Bonafide-doc/"
nbaApproval = System.getProperty("java.io.tmpdir") + "/NBA-APPROVAL/"
mouFilePath = System.getProperty("java.io.tmpdir") + "/MOU-FILE/"
nbaApprovalForm3 = System.getProperty("java.io.tmpdir") + "/MOU-FORM3/"
agreementBtwnApplicantAndThirdParty = System.getProperty("java.io.tmpdir") + "/Agreement-Third/"
indianResearcherAddress =  System.getProperty("java.io.tmpdir") + "/researcher-address/"

declearation = System.getProperty("java.io.tmpdir") + "/Declearation/"
fundingAgencyFormB = System.getProperty("java.io.tmpdir") + "/FUNDING-AGENCY/"
undertakingCopyFormB =  System.getProperty("java.io.tmpdir") + "/UNDERTAKING/"
declarationBySupervisorCopyFormB =  System.getProperty("java.io.tmpdir") + "/declaration/"
declarationByRecipientCopyFormB =   System.getProperty("java.io.tmpdir") + "/Recipient/"
declarationByApplicantOnNationalityCopyFormB =   System.getProperty("java.io.tmpdir") + "/ApplicantOnNationality/"

undertakingCopyFormC =   System.getProperty("java.io.tmpdir") + "/UNDERTAKING-FORMC/"
// files path for phase one at production-- Added by Susheel Gupta


//individualId =        /var+"/individual-Id/"
//individualPassport =  /var+ + "/individual-Passport/"
//individualAuthority = /var++ "/individual-Authority/"
//agentDocuments =      /var++ "/agent-documents/"
//letterOfIntent =      /var+ + "/intent-letter/"
//sharingDoc     =      /var+ + "/sharing-doc/"
//paymentReceipt =      /var+ + "/payment-doc/"
//companyRegistration = /var+ + "/registration/"
//companyPassport =     /var++ "/passport/"
//companyAuthority =    /var+ + "/authority/"








grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination

baseUrl = 'http://api.cbddev.xyz'

// The ACCEPT header will not be used for content negotiation for user agents containing the following strings (defaults to the 4 major rendering engines)
grails.mime.disable.accept.header.userAgents = ['Gecko', 'WebKit', 'Presto', 'Trident']
grails.mime.types = [ // the first one is the default format
    all:           '*/*', // 'all' maps to '*' or the first available format in withFormat
	png:           'image/png',
    atom:          'application/atom+xml',
    css:           'text/css',
    csv:           'text/csv',
    form:          'application/x-www-form-urlencoded',
    html:          ['text/html','application/xhtml+xml'],
    js:            'text/javascript',
    json:          ['application/json', 'text/json'],
    multipartForm: 'multipart/form-data',
    rss:           'application/rss+xml',
    text:          'text/plain',
    hal:           ['application/hal+json','application/hal+xml'],
    xml:           ['text/xml', 'application/xml']
]

//xssSanitizer:
//     enabled: true

// Legacy setting for codec used to encode data with ${}
grails.views.default.codec = "html"

// The default scope for controllers. May be prototype, session or singleton.
// If unspecified, controllers are prototype scoped.
grails.controllers.defaultScope = 'singleton'


// GSP settings
grails {
    views {
        gsp {
            encoding = 'UTF-8'
            htmlcodec = 'xml' // use xml escaping instead of HTML4 escaping
            codecs {
                expression = 'html' // escapes values inside ${}
                scriptlet = 'html' // escapes output from scriptlets in GSPs
                taglib = 'none' // escapes output from taglibs
                staticparts = 'none' // escapes output from static template parts
            }
        }
        // escapes all not-encoded output at final stage of outputting
        // filteringCodecForContentType.'text/html' = 'html'
    }
}


simpleCaptcha {
	
chars = "Aa@BbCc4DdEeF2fGgHhJKkL7MmNnOoPp5QqRrSsTtUuVvWwXxYZz3"
	
}

grails {
	
// for local email sending from gmail	
	// mail {
	// 	host = "smtp.gmail.com"
	// 	from = "nba.beta1@gmail.com"
	// 	port = 465
	//     username = "nba.beta1@gmail.com"
	// 	password = "Nba@1234"
		
	// 	props = ["mail.smtp.auth": "true","mail.smtp.socketFactory.port": "465",
    //     "mail.smtp.socketFactory.class": "javax.net.ssl.SSLSocketFactory","mail.smtp.socketFactory.fallback": "false",
    //     "mail.smtp.starttls.enable": "true", "mail.debug": "true", "mail.smtp.ssl.protocols": "TLSv1.2"]
	// }
	
// for live server email sending process need to uncomment the below code
//	host = "164.100.14.95" and "relay.nic.in"
	mail {
		host = "relay.nic.in"
		port = 25
		username = "info.nba@gov.in"
		password = "Nba@42003"
	}

// for  local email sending with microsoft account

// mail {
//     host = "smtp.live.com"
//     port = 587
//     username = "susheel.gupta11@hotmail.com"
//     password = "Appu@1988"
//     props = ["mail.smtp.starttls.enable":"true",
//              "mail.smtp.port":"587"]
//   }
//	
	
grails.converters.encoding = "UTF-8"
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false

// configure passing transaction's read-only attribute to Hibernate session, queries and criterias
// set "singleSession = false" OSIV mode in hibernate configuration after enabling
grails.hibernate.pass.readonly = false
// configure passing read-only to OSIV session by default, requires "singleSession = false" OSIV mode
grails.hibernate.osiv.readonly = false

environments {
    development {
        grails.logging.jul.usebridge = true
    }
    production {
        grails.logging.jul.usebridge = false
        // TODO: grails.serverURL = "http://www.changeme.com"
    }
}

// log4j configuration
log4j = {
			appenders {
				file name:'file', file:'D:/logs/nba_audit.log'
			}
			root {
				debug()
			}
		}
	
//grails.plugin.springsecurity.useHttpSessionEventPublisher = true
//grails.plugin.springsecurity.logout.handlerNames = ['customSessionLogoutHandler','securityContextLogoutHandler']

grails.plugin.springsecurity.logout.postOnly = false 
grails.plugin.springsecurity.ui.register.postRegisterUrl = '/login/auth'
grails.plugin.springsecurity.successHandler.alwaysUseDefault = true
grails.plugin.springsecurity.successHandler.defaultTargetUrl = '/loggedInAs/inbox'
grails.plugin.springsecurity.ui.register.postResetUrl = '/login/auth'
grails.plugin.springsecurity.password.algorithm = "SHA-512"
// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'org.nba.user.NbaUser'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'org.nba.user.NbaUserNbaRole'
grails.plugin.springsecurity.authority.className = 'org.nba.user.NbaRole'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	'/':                              ['permitAll'],
	'/index':                         ['permitAll'],
	'/index.gsp':                     ['permitAll'],
	'/assets/**':                     ['permitAll'],
	'/**/js/**':                      ['permitAll'],
	'/**/css/**':                     ['permitAll'],
	'/**/images/**':                  ['permitAll'],
	'/simpleCaptcha/**':              ['permitAll'],
	'/login/**':                      ['permitAll'],
	'/manageContent/**':              ['permitAll'],
	'/plugins/**':                    ['permitAll'],
	'/**/favicon.ico':                ['permitAll']
]
}
