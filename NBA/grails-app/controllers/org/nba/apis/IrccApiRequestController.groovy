package org.nba.apis

import grails.plugins.rest.client.RestBuilder

class IrccApiRequestController {
	def grailsApplication
  
	
	def index() {}
	
	
	def requestFor(){
		
//		RestBuilder rest = new RestBuilder() //we can replace new RestBuild by  rest only
		
		println "base====="+grailsApplication.config.baseUrl.toString()
		
		def getId = params.id
		def getIrccData = ApplicationForm1.get(Long.parseLong(getId))
		def title = getIrccData.appNumber
		def appN = getIrccData.applicationNo
		
		def contactDetails = "A-24 r.k puram govind puram Ghaziabad U.P 201013 Mobile number =9958501925"
		
		
		
		
		
//		def req = new RestBuilder().get("https://api.cbddev.xyz/api/v2013/countries/IN" ){accept "application/json"}
//
//		println req.json
		

//		def req = new RestBuilder().get("https://api-direct.cbd.int/api/v2013/countries/IN" ){accept "application/json"}
//
//		println req.json
				
		
		
		def req3 = new RestBuilder().post("https://api-direct.cbd.int/api/v2013/authentication/token" ){
			accept "application/json"
			json {
				email = "support@nbaindia.in"
				password = "Nba@4new2003"
			}
		}
		println req3.json
		
	//replace abs-trg with dynamic variable
		
		def req4 = new RestBuilder().get("https://api-direct.cbd.int/api/v2013/index/select?fl=identifier_s&q=government_s:in AND schema_s:authority AND realm_ss:abs-trg" )
		
		println req4.json
		
		
		def individual = getIrccData?.individualProfiles
		if(getIrccData.individualProfiles){
			def individualContacts = IndividualProfile.findAllByApplicationForm1(getIrccData)
			def individualContact =  individualContacts[0]
			println "contact details"+individualContact
			def contactJson = '{"header":{"identifier": "NBA_2018TEST_' + individualContact?.id+'","schema": "contact","languages": ["en"]},"government": { "identifier": "in" },"type":"person","firstName":'+individualContact?.firstName+',"lastName":'+individualContact?.lastName+',"emails":["'+individualContact?.email+'"]}';
			def contactPush =  new RestBuilder().post("https://api-direct.cbd.int/api/v2013/documents?schema=contact" ){
			  contentType "application/json"
			  accept "application/json"
			  header  'realm' , 'ABS-TRG'
			  header 'authorization', "Token "+req3.json.authenticationToken
				 
				json {
					header = {
							identifier = "NBA_2018TEST_" + individualContact?.id
							schema= "contact"
							languages= ["en"]
					}
					government= { identifier= "in" }
					type="person"
					firstName=individualContact?.firstName
					lastName=individualContact?.lastName
					emails=[individualContact?.email]
					
				}
			}
			
			println contactPush
			
			
			def permitPush =  new RestBuilder().put("https://api-direct.cbd.int/api/v2013/documents/NBA_2018TEST_" + getId.toString() + "/versions/draft?schema=absPermit" ){
			  contentType "application/json"
			  accept "application/json"
			  header  'realm' , 'ABS-TRG'
			  header 'authorization', "Token "+req3.json.authenticationToken
				 
				json {
					header = {
							identifier = "NBA_2018TEST_" + getId.toString()
							schema= "absPermit"
							languages= ["en"]
					}
					government= { identifier= "in" }
					title = { en : title }
					picGranted = true
					matEstablished = true
					providersConfidential = false
					providers   = [{identifier=req4.json.response.docs[0].identifier_s}]
					absCNA = {identifier=req4.json.response.docs[0].identifier_s}
				}
			}
			
			println permitPush
			
		}
		
//		def req3 = new RestBuilder().post("https://api.cbddev.xyz/api/v2013/authentication/token" ){
//			accept "application/json"
//			json {
//				email = "support@nbaindia.in"
//				password = "Nba@4new2003"
//			}
//		}
//
//		println req3.json
//
		
		
//		req = new RestBuilder().post(grailsApplication.config.baseUrl.toString()+"/api/v2013/authentication/token" ){
//
//
//			contentType "application/json"
//			accept "application/json"
//			json {
//				email = "support@nbaindia.in"
//				password = "Nba@4new2003"
//			}
//			}
	}

	
}
