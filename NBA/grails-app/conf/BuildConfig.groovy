grails.servlet.version = "3.0" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.plugins.dir = "plugins"
grails.project.work.dir = "target/work"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
grails.server.port.http = 8091
grails.enable.native2ascii = false

grails.project.war.file = "NBA.war"

grails.project.fork = [
	// configure settings for compilation JVM, note that if you alter the Groovy version forked compilation is required
	//  compile: [maxMemory: 256, minMemory: 64, debug: false, maxPerm: 256, daemon:true],

	// configure settings for the test-app JVM, uses the daemon by default
	test: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon:true],
	// configure settings for the run-app JVM
	run: [maxMemory: 2048, minMemory: 1024, debug: false, maxPerm: 1024, forkReserve:false],
	//run: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
	// configure settings for the run-war JVM
	war: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
	// configure settings for the Console UI JVM
	//console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
	console: [maxMemory: 2048, minMemory: 1024, debug: false, maxPerm: 1024]
]

grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {
	// inherit Grails' default dependencies
	inherits("global") {
		// specify dependency exclusions here; for example, uncomment this to disable ehcache:
		// excludes 'ehcache'
	//	excludes 'grails-plugin-log4j', 'log4j'
	}
	log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
	checksums true // Whether to verify checksums on resolve
	legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

	repositories {
		inherits true // Whether to inherit repository definitions from plugins

		grailsPlugins()
		grailsHome()
		mavenLocal()
		grailsCentral()
		mavenCentral()
		
		mavenRepo "http://repo.grails.org/grails/core"
		mavenRepo "http://repo.grails.org/grails/plugins"
		mavenRepo "http://repo1.maven.org/maven2"
		// uncomment these (or add new ones) to enable remote dependency resolution from public Maven repositories
		//mavenRepo "http://repository.codehaus.org"
		//mavenRepo "http://download.java.net/maven/2/"
		//mavenRepo "http://repository.jboss.com/maven2/"
	   //mavenRepo 'http://repo.spring.io/milestone'
	}

	dependencies {
		
		// specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes e.g.
		// runtime 'mysql:mysql-connector-java:5.1.29'
		// runtime 'org.postgresql:postgresql:9.3-1101-jdbc41'
		
//		compile 'org.apache.logging.log4j:log4j-core:2.16.0'
//		compile group: 'org.apache.logging.log4j', name: 'log4j-core', version: '2.16.0'

		test "org.grails:grails-datastore-test-support:1.0.2-grails-2.4"
		//runtime 'org.springframework:spring-test:4.0.6.RELEASE'
		runtime 'org.springframework:spring-test:3.1.0.RELEASE'
		//compile "com.lowagie:itext:2.0.8"
//		runtime ('org.xhtmlrenderer:core-renderer:R8')
		compile('org.xhtmlrenderer:flying-saucer-core:9.0.4')
		compile('org.xhtmlrenderer:flying-saucer-pdf:9.0.4')

	             }

	plugins {
		// plugins for the build system only
		build ":tomcat:7.0.55"
		
//		compile "org.grails.plugins:rendering:1.0.0"
		
		//1- for cdac and cbd api integration
		compile ":rest-client-builder:2.0.0"
		
		// plugins for the compile step
		compile ":scaffolding:2.1.2"
		compile ':cache:1.1.8'
		compile ":asset-pipeline:1.9.9"
		compile ":spring-security-core:2.0-RC4"
		compile ":spring-security-ui:1.0-RC2"
		compile "org.grails.plugins:filter:0.2"
		compile "org.grails.plugins:xss-sanitizer:0.4.0"
		compile "org.grails.plugins:cache:1.1.8"
		compile "org.grails.plugins:xframeoptions:1.0"
		compile ":modalbox:0.4"
		compile "org.grails.plugins:rendering:1.0.0"
		//compile ":recaptcha:1.5.0"
		compile ":simple-captcha:1.0.0"
		//compile "org.grails.plugins:rest-client-builder:2.0.0"
		// plugins needed at runtime but not for compilation
		runtime ":hibernate4:4.3.6.1" // or ":hibernate:3.6.10.18"
		runtime ":database-migration:1.4.0"
		runtime ":jquery:1.11.1"
		runtime ":xss-sanitizer:0.2"

//	    compile ":spring-security-rest:1.5.4"
		

		
		// Uncomment these to enable additional asset-pipeline capabilities
		//compile ":sass-asset-pipeline:1.9.0"
		//compile ":less-asset-pipeline:1.10.0"
		//compile ":coffee-asset-pipeline:1.8.0"
		//compile ":handlebars-asset-pipeline:1.3.0.3"
	}
}

//grails.war.resources = { stagingDir ->
//	delete(file:"${stagingDir}/WEB-INF/lib/log4j-1.2.17.jar")
//  }
