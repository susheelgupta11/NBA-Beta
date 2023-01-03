package org.nba.application

import org.codehaus.groovy.grails.web.json.JSONObject
import org.nba.application.AgentProfile.TitleName;
import org.nba.application.FormB.EntityType;
import org.nba.application.IndianResearcher.GenderType;
import org.nba.common.Country;
import org.nba.resource.*;

import grails.converters.JSON
import grails.plugins.rest.client.RestBuilder
import grails.transaction.Transactional

@Transactional
class ApiForCDACITMSToolsService {


	def  village,town,district,state,scientificName,traditionalUse,quantity,timespanFrom, timespanTo,agttitle,
	agtprofile,agtfirstName,agtmiddleName,agtlastName,agtnationality,agtaddress1,agtaddress2,agtaddress3,
	agtcity,agtpincode,agtmobile,agtphone,agtemail,is_risky,profileAs,nature,purposeOfAccess,natureOfTraditionalKnowledge,
	identifiedIndividual,contactPersons,mobileOfContactPerson,

	title,firstName,middleName,lastName,address1,address2,address3,nationality,city,pincode,mobile,phone,email,entityName,
	businessNature,website,

	// form2
	detailsOfResearchConducted,institutionWhereRandDActiviitiesCarriedOut,detailsOfIndividualOrOrganisation,


	//form 4

	accessContractEntered,accessContractEnteredDate,nameThirdPart,addressThird,purposeOfTheIntendedThirdPartyTransfer,
	//		def resp = new RestBuilder().post(api/llll/ssss/los, applicationDetails)


	// form B
	indianResearcherName,permanentAddress




	def restPushDataToCDACITMSToolsForm1(ApplicationForm1 app){


		HashMap jsonMap = new HashMap()
	 
		if(app?.individualProfiles){

			jsonMap.application = [id:app?.appNumber,is_individual_or_entity:'individual',is_risky: app?.isRisky,
				is_traditional_knowledge_applicable:app?.isTraditionalKnowledgeApplicable]

			jsonMap.details_of_individual_or_organisation = app?.individualProfiles.collect {indi ->
				return [title:indi?.title?.toString(),first_name: indi?.firstName, middle_name: indi?.middleName,last_name:indi?.lastName,
					address1 :indi?.address1,address2 :indi?.address2,address3 :indi?.address3, nationality : indi?.nationality,
					city :indi?.city,pincode: indi?.pincode,mobile : indi?.mobile,phone : indi?.phone,email : indi?.email]
			}
		}else if(app?.companyProfiles){

			jsonMap.application = [id:app?.appNumber,	is_individual_or_entity: 'company',is_risky : app?.isRisky,
				is_traditional_knowledge_applicable:app?.isTraditionalKnowledgeApplicable]

			jsonMap.details_of_individual_or_organisation =	app?.companyProfiles.collect {it->

				return[entityName:it?.entityName,nationality :it?.nationality, address1 :it?.address1,
					address2 :it?.address2,address3 : it?.address3, city : it?.city,pincode :it?.pincode,mobile : it?.mobile,
					phone :it?.phone,email:it?.email,website:it?.website]

			}
		}


		//				if(app?.agentProfile){
		//
		//				jsonMap.agent = app.agentProfile.collect{ agt->
		//
		//					return[agttitle: agt?.title?.value,agtprofile: agt?.profile,agtfirstName: agt?.firstName,agtmiddleName: agt?.middleName,
		//					agtlastName: agt?.lastName,agtnationality: agt?.nationality,agtaddress1: agt?.address1,agtaddress2: agt?.address2,
		//					agtaddress3: agt?.address3,agtcity: agt?.city,agtpincode: agt?.pincode,agtmobile: agt?.mobile,agtphone: agt?.phone,
		//					agtemail: agt?.email]
		//
		//				}
		//
		//				}
		if(app?.contactPersons){
			jsonMap.contact_Person = 	app?.contactPersons.collect{ctp ->
				return[name_of_contact_person: ctp?.nameOfContactPerson,
					address_of_contact_person:ctp?.addressOfContactPerson,email_of_contact_person:ctp?.emailOfContactPerson]
			}
		}

		if(app?.locations){
			jsonMap.community_knowledge =	app?.locations.collect {loca ->

				return	[community_knowledge:loca?.communityKnowledge,consent_obtained:loca?.consentObtained,
					district:loca?.district,town:loca?.town,village:loca?.village]
			}
		}



		if(app?.biologicalResources){
			jsonMap.bioResource	 =	app?.biologicalResources.collect{bio->

				return[common_name : bio?.commonName,scientific_name : bio?.scientificName,nature:bio?.nature,traditional_use : bio?.traditionalUse,
					quantity :bio?.quantity,qty_unit:bio?.qtyUnit,from_time :bio?.fromTime,to_time :bio?.toTime]

			}
		}
		println "%%%%"+jsonMap

		return jsonMap;

	}

	// ************************** for form 2 details

	def restPushDataToCDACITMSToolsForm234(ApplicationForm1 app){


		HashMap jsonMap = new HashMap()

		if(app?.individualProfiles){

			jsonMap.application = [id:app?.appNumber,is_individual_or_entity:'individual',is_risky: app?.isRisky,
				is_traditional_knowledge_applicable:app?.isTraditionalKnowledgeApplicable]

			jsonMap.details_of_individual_or_organisation = app?.individualProfiles.collect {indi ->
				return [title:indi?.title?.toString(),first_name: indi?.firstName, middle_name: indi?.middleName,last_name:indi?.lastName,
					address1 :indi?.address1,address2 :indi?.address2,address3 :indi?.address3, nationality : indi?.nationality,
					city :indi?.city,pincode: indi?.pincode,mobile : indi?.mobile,phone : indi?.phone,email : indi?.email]
			}
		}else if(app?.companyProfiles){

			jsonMap.application = [id:app?.appNumber,	is_individual_or_entity: 'company',is_risky : app?.isRisky,
				is_traditional_knowledge_applicable:app?.isTraditionalKnowledgeApplicable]

			jsonMap.details_of_individual_or_organisation =	app?.companyProfiles.collect {it->

				return[entity_name:it?.entityName,nationality :it?.nationality, address1 :it?.address1,
					address2 :it?.address2,address3 : it?.address3, city : it?.city,pincode :it?.pincode,mobile : it?.mobile,
					phone :it?.phone,email:it?.email,website:it?.website]

			}
		}


		//				if(app?.agentProfile){
		//
		//				jsonMap.agent = app.agentProfile.collect{ agt->
		//
		//					return[agttitle: agt?.title?.value,agtprofile: agt?.profile,agtfirstName: agt?.firstName,agtmiddleName: agt?.middleName,
		//					agtlastName: agt?.lastName,agtnationality: agt?.nationality,agtaddress1: agt?.address1,agtaddress2: agt?.address2,
		//					agtaddress3: agt?.address3,agtcity: agt?.city,agtpincode: agt?.pincode,agtmobile: agt?.mobile,agtphone: agt?.phone,
		//					agtemail: agt?.email]
		//
		//				}
		//
		//				}
		if(app?.contactPersons){
			jsonMap.contact_Person = 	app?.contactPersons.collect{ctp ->
				return[name_of_contact_person: ctp?.nameOfContactPerson,
					address_of_contact_person:ctp?.addressOfContactPerson,email_of_contact_person:ctp?.emailOfContactPerson]
			}
		}

		if(app?.biologicalResources){
			jsonMap.bioResource	 =	app?.biologicalResources.collect{bio->

				return[common_name : bio?.commonName,scientific_name : bio?.scientificName,nature:bio?.nature,traditional_use : bio?.traditionalUse,
					quantity :bio?.quantity,qty_unit:bio?.qtyUnit,from_time :bio?.fromTime,to_time :bio?.toTime]


			}
		}
		println "%%%%"+jsonMap

		return jsonMap

	}


	// ************************** for form 3 details


//	def restPushDataToCDACITMSToolsForm3(ApplicationForm1 app){
//		HashMap jsonMap = new HashMap()
//
//		if(app?.individualProfiles){
//
//			jsonMap.applicationDetails = [institutionWhereRandDActiviitiesCarriedOut :app?.detailsOfInstitute,IPR:app?.titleOfIPR, profileAs :'individual',
//				natureOfTraditionalKnowledge :app?.traditionalKnowledgeDesc]
//
//
//			jsonMap.individualdetails = app?.individualProfiles.collect {	indi->
//
//				return [title:indi?.title.toString(),firstName: indi?.firstName, middleName: indi?.middleName,lastName:indi?.lastName,
//					address1 :indi?.address1,address2 :indi?.address2,address3 :indi?.address3, nationality : indi?.nationality,
//					city :indi?.city,pincode: indi?.pincode,mobile : indi?.mobile,phone : indi?.phone,email : indi?.email,
//					professionalProfile:indi?.profile]
//			}
//
//		}else if(app?.companyProfiles){
//
//			jsonMap.applicationDetails = [institutionWhereRandDActiviitiesCarriedOut :app?.detailsOfInstitute,
//				profileAs :'company',natureOfTraditionalKnowledge: app?.traditionalKnowledgeDesc]
//
//			jsonMap.companyDetails = 	app?.companyProfiles.collect {it->
//
//				return [entityName:it?.entityName,entityType:it?.entityType,nationality :it?.nationality, address1 :it?.address1,
//					address2 :it?.address2,address3 : it?.address3, city : it?.city,pincode :it?.pincode,mobile : it?.mobile,
//					phone :it?.phone,email:it?.email,website:it?.website,businessNature :it?.businessNature]
//
//			}
//		}
//
//		if(app?.locations){
//			jsonMap.individualHoldingTheTraditionalKnowledge = 	app?.locations.collect {loca ->
//
//				return [identifiedIndividual:loca?.communityKnowledge,consentObtained:loca?.consentObtained,
//					village:loca?.village,town:loca?.town,district:loca?.district,state:loca?.state]
//			}
//		}
//
//
//		if(app?.biologicalResources){
//			jsonMap.biologicalResource = app?.biologicalResources.collect{bio->
//
//
//				return [used:bio?.accessIntention,nature:bio?.nature,commonName:bio?.commonName,scientificName:bio?.scientificName,
//					biologicalResource:bio?.biologicalResource,]
//
//
//
//				if(bio?.locations){
//					bio?.locations.collect {loc->
//						def geographicalLocationOfCollection = [village:loc?.village,town:loc?.town,district :loc?.district,state:loc?.state]
//
//
//					}
//				}
//			}
//		}
//		println "%%%%"+jsonMap
//
//		return [form3Details:jsonMap]
//
//	}
//
//	//************************for form 4 details
//
//	def restPushDataToCDACITMSToolsForm4(ApplicationForm1 app){
//
//		HashMap jsonMap = new HashMap()
//
//		if(app?.individualProfiles){
//
//			jsonMap.applicationDetails = [profileAs: 'individual',purposeOfTheIntendedThirdPartyTransfer: app?.thirdPartyTransferPurpose,
//				natureOfTraditionalKnowledge : app?.traditionalKnowledgeDesc,accessContractEntered: app?.applicationNo,accessContractEnteredDate:app?.dateOfApproval]
//
//
//			jsonMap.individualdetails = app?.individualProfiles.collect {indi->
//
//				return [title:indi?.title,firstName: indi?.firstName, middleName: indi?.middleName,lastName:indi?.lastName,
//					address1 :indi?.address1,address2 :indi?.address2,address3 :indi?.address3, nationality : indi?.nationality,
//					city :indi?.city,pincode: indi?.pincode,mobile : indi?.mobile,phone : indi?.phone,email : indi?.email,
//					professionalProfile:indi?.profile]
//			}
//		}else if(app?.companyProfiles){
//
//			jsonMap.applicationDetails =	[profileAs : 'company',purposeOfTheIntendedThirdPartyTransfer	: app?.thirdPartyTransferPurpose,
//				natureOfTraditionalKnowledge :app?.traditionalKnowledgeDesc,accessContractEntered : app?.applicationNo,accessContractEnteredDate: app?.dateOfApproval]
//
//			jsonMap.companyDetails = 	app?.companyProfiles.collect {it->
//
//				return [entityName:it?.entityName,entityType:it?.entityType,nationality :it?.nationality, address1 :it?.address1,
//					address2 :it?.address2,address3 : it?.address3, city : it?.city,pincode :it?.pincode,mobile : it?.mobile,
//					phone :it?.phone,email:it?.email,website:it?.website,businessNature :it?.businessNature]
//
//			}
//		}
//		if(app?.biologicalResources){
//
//
//			jsonMap.biologicalResource =app?.biologicalResources.collect{bio->
//
//
//				return [used:bio?.accessIntention,nature:bio?.nature,commonName:bio?.commonName,scientificName:bio?.scientificName,
//					biologicalResource:bio?.biologicalResource,]
//			}
//		}
//
//
//		if(app?.thirdParty){
//			jsonMap.thirdPartyTransfer = app?.thirdParty.collect {third->
//				return [ name:third?.name, addressForComm:third?.addressForComm,state:third?.state,pincode:third?.pincode,
//					country:third?.country,phone:third?.phone, fax:third?.fax, website:third?.website,email:third?.email]
//			}
//		}
//		println "%%%%"+jsonMap
//		return jsonMap
//	}
//
//
//




	def restPushDataToCDACITMSToolsFormB(ApplicationForm1 app){

		HashMap jsonMap = new HashMap()

		jsonMap.application = [id:app?.appNumber,is_risky : app?.isRisky,
			is_traditional_knowledge_applicable:app?.isTraditionalKnowledgeApplicable]

		if(app?.indianResearcher){



			jsonMap.indian_researcher = app?.indianResearcher.collect {inr ->

				return[ title:inr?.title.toString(),first_name:inr?.firstName, middle_name:inr?.middleName,last_name:inr?.lastName,
					address1:inr?.address1,address2:inr?.address2,address3:inr?.address3,city:inr?.city,
					province:inr?.province,pincode:inr?.pincode,country:inr?.country,mobile:inr?.mobile, phone:inr?.phone, email:inr?.email]


			}
		}
		if(app?.indianGovtInst){


			jsonMap.indian_govt_inst = app?.indianGovtInst.collect {indiGo->

				return [govtInstName:indiGo?.govtInstName,address1:indiGo?.address1,address2:indiGo?.address2,address3:indiGo?.address3,city:indiGo?.city,
					province:indiGo?.province,pincode:indiGo?.pincode,country:indiGo?.country,mobile:indiGo?.mobile, phone:indiGo?.phone,
					email:indiGo?.email]

			}
		}

		if(app?.formBItems){

			def instituteDetailsForB = app?.formBItems.collect { item->

				if(item.type == FormB.EntityType.Institute){
					return[name:item?.name,title_1:item?.supervisorDesignation,title_2:item?.headOfInstName,
						title_3:item?.headOfInstDesignation,address1_2:item?.address1,address2_2:item?.address2,address3_2:item?.address3]
				}

				if(item.type == FormB.EntityType.Supervisor){
					return[name:item?.name,title_1:item?.supervisorDesignation,title_2:item?.headOfInstName,
						title_3:item?.headOfInstDesignation,address1_3:item?.address1,address2_3:item?.address2,address3_3:item?.address3]

				}
				if(item.type == FormB.EntityType.Guiding_Institute){
					return [name:item?.name,title_1:item?.supervisorDesignation,title_2:item?.headOfInstName,
						title_3:item?.headOfInstDesignation,address1_4:item?.address1,address2_4:item?.address2,address3_4:item?.address3]

				}
				if(item.type == FormB.EntityType.Guiding_Supervisor){
					return [name:item?.name,title_1:item?.supervisorDesignation,title_2:item?.headOfInstName,
						title_3:item?.headOfInstDesignation,address5_1:item?.address1,address5_2:item?.address2,address5_3:item?.address3]

				}
				if(item.type == FormB.EntityType.Funding_Agency){
					return [name:item?.name,title_1:item?.supervisorDesignation,title_2:item?.headOfInstName,
						title_3:item?.headOfInstDesignation,address5_1:item?.address1,address5_2:item?.address2,address5_3:item?.address3]
				}
			}
		}

		if(app?.contactPersons){
			jsonMap.contact_Person = 	app?.contactPersons.collect{ctp ->
				return[name_of_contact_person: ctp?.nameOfContactPerson,
					address_of_contact_person:ctp?.addressOfContactPerson,email_of_contact_person:ctp?.emailOfContactPerson]
			}
		}

		if(app?.biologicalResources){
			jsonMap.bioResource	 =	app?.biologicalResources.collect{bio->

				return[common_name : bio?.commonName,scientific_name : bio?.scientificName,nature:bio?.nature,traditional_use : bio?.traditionalUse,
					quantity :bio?.quantity,qty_unit:bio?.qtyUnit,from_time :bio?.fromTime,to_time :bio?.toTime]

			}
		}
		println "%%%%"+jsonMap
		return jsonMap
	}

	def restPushDataToCDACITMSToolsFormC(ApplicationForm1 app){

		HashMap jsonMap = new HashMap();
		jsonMap.application = [id:app?.appNumber,is_risky : app?.isRisky,
			is_traditional_knowledge_applicable:app?.isTraditionalKnowledgeApplicable]
		if(app?.depostionOfMicroOrganism){

			jsonMap.depostionOfmicro = app?.depostionOfMicroOrganism.collect {mi ->

				return [ name_of_depositor:mi?.nameOfDepositor,address1_6:mi?.address1,address2_6:mi?.address2,address3_6:mi?.address3,
					mobile:mi?.mobile,email_2:mi?.email]
			}
		}

		if(app?.contactPersons){
			jsonMap.contact_Person = 	app?.contactPersons.collect{ctp ->
				return[name_of_contact_person: ctp?.nameOfContactPerson,
					address_of_contact_person:ctp?.addressOfContactPerson,email_of_contact_person:ctp?.emailOfContactPerson]
			}
		}

		if(app?.biologicalResources){
			jsonMap.bioResource	 =	app?.biologicalResources.collect{bio->

				return[common_name : bio?.commonName,scientific_name : bio?.scientificName,nature:bio?.nature,traditional_use : bio?.traditionalUse,
					quantity :bio?.quantity,qty_unit:bio?.qtyUnit,from_time :bio?.fromTime,to_time :bio?.toTime]

			}
		}
		println "%%%%"+jsonMap
		return jsonMap
	}
}
