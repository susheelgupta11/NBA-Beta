<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="layout" content="projectPreview" />
<title> Acknowledgement</title>
<script type="text/javascript">

$(function(){
	window.print();
});
</script>

<style>
	@media print{
		@page {size: portrait}
		
		 .margintop {margin-top: 20mm;}
		 .margintop5 {margin-top: 5mm;}
		 .margintoppurpose{margin-top: 10mm;}
		 .margindeclaration{margin-top: 15mm;}
		 
		 div{font-size:18px; font-family: "Times New Roman", Times, serif;}
		
		}
	
</style>
</head>
<body>

<div class="">
		<div class="row">
			<div class="col-sm-8 col-sm-offset-2 ">
				<g:if test="${appForm?.isDeclarationDigitallySigned == 'true' }">
					<div class="main-registeration col-sm-12 form-group content" style="width:90%; margin-left:5%; border: 1px solid; padding: 0.01em 15px; ">

						<div class="col-sm-7  text-center" style="margin-left: 42%">
							<img src="${resource(dir: 'images', file: 'amblam.png')}"
								alt="logo" class="img-responsive" />



						</div>
						<div class="col-sm-12 text-center form-group">
							<b>Government of India</b> <br /> National Biodiversity
							Authority
						</div>
						<div class="col-sm-12 form-group text-center">
							<h4>
								<b>Acknowledgement</b>
							</h4>

						</div>
						<div class="col-sm-12 form-group ">
							<span>This is to acknowledge the receipt of Application
								Form as detailed below:</span>
						</div>
						<g:if test="${formType == 'FormC' }">
							
							<div class="col-sm-12 form-group less-padding">

								<label style="width:33.33%">Reference Number:</label> <span
									class="col-sm-8"> <g:if
										test="${appForm?.appNumber }">
										
											${appForm?.appNumber }

									</g:if>


								</span>
							</div>
							<div class="col-sm-12 form-group less-padding">

								<label style="width:33.33%">Name of the Applicant(s):</label> <span
									class="col-sm-8"> <g:if
										test="${appForm?.depostionOfMicroOrganism?.size() == 0 }">
										<g:each in="${appForm?.depostionOfMicroOrganism }"
											var="deposition">
											${deposition?.nameOfDepositor}

										</g:each>
									</g:if>


								</span>
							</div>
							<div class="col-sm-12 form-group less-padding">

								<label style="width:33.33%">Address:</label> <span
									class="col-sm-8"> <g:if
										test="${appForm?.depostionOfMicroOrganism?.size() == 0 }">
										<g:each in="${appForm?.depostionOfMicroOrganism }"
											var="deposition">
											${deposition?.nameOfDepositor}

										</g:each>
									</g:if>


								</span>
							</div>
						</g:if>
						<g:else>
							<div class="col-sm-12 form-group less-padding">

								<label style="width:33.33%">Name of the Applicant(s):</label> <span
									class="col-sm-8"> <g:if
										test="${appForm?.companyProfiles?.size() == 0 }">
										<g:each in="${appForm?.individualProfiles }" var="individual">
											${individual?.title}
											${individual?.firstName}
											${individual?.middleName}
											${individual?.lastName} 
										</g:each>
									</g:if> <g:else>
										<g:each in="${appForm?.companyProfiles }" var="company">
											${company?.entityName} 
										</g:each>
									</g:else>
								</span>
							</div>
						</g:else>


						<div class="col-sm-12 form-group less-padding">
							<label style="width:33.33%">Address :</label> <span class="col-sm-8">
								<g:if test="${appForm?.companyProfiles?.size() == 0 }">
									<g:each status="i" in="${appForm?.individualProfiles }"
										var="individual">
										<g:if test="${appForm?.individualProfiles?.size() - i == 1 }">
											${individual?.address1 }
											${individual?.address2 }
											${individual?.address3 }
										</g:if>
										<g:else>
											${individual?.address1 }
											${individual?.address2 }
											${individual?.address3 },
										</g:else>
									</g:each>
								</g:if> <g:else>
									<g:each status="i" in="${appForm?.companyProfiles }"
										var="company">
										<g:if test="${appForm?.companyProfiles?.size() - i == 1 }">
											${company?.address1 }
											${company?.address2 }
											${company?.address3 }
										</g:if>
										<g:else>
											${company?.address1 }
											${company?.address2 }
											${company?.address3 },
										</g:else>
									</g:each>
								</g:else>

							</span>

						</div>

						<g:if test="${formType == 'Form1' }">
							<div class="col-sm-12 form-group less-padding">
								<label style="width:33.33%">Form applied :</label> <span
									class="col-sm-8">Form I </span>
							</div>
						</g:if>
						<g:elseif test="${formType == 'Form2' }">
							<div class="col-sm-12 form-group less-padding">
								<label style="width:33.33%">Form applied :</label> <span
									class="col-sm-8">Form II </span>
							</div>
						</g:elseif>
						<g:elseif test="${formType == 'Form3' }">
							<div class="col-sm-12 form-group less-padding">
								<label style="width:33.33%">Form applied :</label> <span
									class="col-sm-8">Form III </span>
							</div>
						</g:elseif>
						<g:elseif test="${formType == 'Form4' }">
							<div class="col-sm-12 form-group less-padding">
								<label style="width:33.33%">Form applied :</label> <span
									class="col-sm-8">Form IV </span>
							</div>
						</g:elseif>

						<div class="col-sm-12 form-group less-padding">
							<label style="width:33.33%">Purpose :</label>
							<g:if test="${formType == 'Form1' }">
								<span class="col-sm-8">Access to biological resources and
									associated traditional knowledge.</span>
							</g:if>
							<g:elseif test="${formType == 'Form2' }">
								<span class="col-sm-8">Transferring the results of
									research to foreign nationals, companies, NRIs for commercial
									purposes.</span>
							</g:elseif>
							<g:elseif test="${formType == 'Form3' }">
								<span class="col-sm-8">Applying for Intellectual Property
									Right.</span>
							</g:elseif>
							<g:elseif test="${formType == 'Form4' }">
								<span class="col-sm-8">Third party transfer of the
									accessed biological resources and associated traditional
									knowledge.</span>
							</g:elseif>
						</div>

						<div class="col-sm-12 form-group less-padding">
							<label style="width:33.33%">Application Reference Number :</label> <span
								class="col-sm-8">
								${appForm?.appNumber }
							</span>
						</div>

                       <div class="col-sm-12 form-group text-center">
							<span><b><u>Declaration by the Applicant</u></b></span><br /> <span>
							I<b><g:if
										test="${appForm?.depostionOfMicroOrganism?.size() == 0 }">
										<g:each in="${appForm?.depostionOfMicroOrganism }"
											var="deposition">
											${deposition?.nameOfDepositor}

										</g:each>
									</g:if>
									 <g:if test="${appForm?.companyProfiles?.size() == 0 }">
										<g:set value="Individual" var="type"></g:set>
										<g:each in="${appForm?.individualProfiles }" var="individual">
											${individual?.title}
											${individual?.firstName}
											${individual?.middleName}
											${individual?.lastName}, 
										</g:each>
									</g:if> 
									<g:else>
									<g:set value="Company" var="type"></g:set>
										<g:each in="${appForm?.companyProfiles }" var="company">
											${company?.entityName}, 
										</g:each>
									</g:else></b>hereby declare that the information provided in the
							 Application Form is true and correct and I / we shall be responsible for any incorrect or wrong information. 
							
							</span>
<hr>
						</div>
						<div class="col-sm-12 form-grou ">
							This form has been electronically <b style="color:red;"> submitted and</b> verified by <b>
<g:if
										test="${appForm?.depostionOfMicroOrganism?.size() == 0 }">
										<g:each in="${appForm?.depostionOfMicroOrganism }"
											var="deposition">
											${deposition?.nameOfDepositor}

										</g:each>
									</g:if>
									 <g:if
										test="${appForm?.companyProfiles?.size() == 0 }">
									
										<g:each in="${appForm?.individualProfiles }" var="individual">
											${individual?.title}
											${individual?.firstName}
											${individual?.middleName}
											${individual?.lastName}, 
										</g:each>
									</g:if> <g:else>
								
										<g:each in="${appForm?.companyProfiles }" var="company">
											${company?.entityName}, 
										</g:each>
					</g:else></b><b style="color:red;">capacity of ${type }</b> having email id<b> ${email}</b> on<b> ${new Date().format('dd/MM/yyyy HH:mm:ss')}</b> from ip address <b>${ipAddress}</b>  generated through ABS Efiling portal.
						</div>
					</div>
				</g:if>
						
		


				<g:else>
					<div class="main-registeration col-sm-12 form-group contentclass" style="width:90%; margin-left:5%; border: 1px solid; padding: 0.01em 15px; ">
						<div class="col-sm-7  text-center" style="margin-left: 42%">
							<img src="${resource(dir: 'images', file: 'amblam.png')}"
								alt="logo" class="img-responsive" />



						</div>
						<div class="col-sm-12 text-center form-group">
							<b>Government of India</b> <br /> National Biodiversity
							Authority
						</div>
						
						<g:if test="${formType == 'FormC' }">
							<div class="col-sm-12 form-group text-center">
								<h4>
									<b>e-Acknowledgement</b>
								</h4>
	
							</div>
							<div class="col-sm-12 form-group ">
								<span>This is to acknowledge the receipt of intimation in Form-C as detailed below:</span>
							</div>
						</g:if>
						<g:else>
							<div class="col-sm-12 form-group text-center">
							<h3>
								<b>Acknowledgement</b>
							</h3>

						</div>
						<div class="col-sm-12 form-group ">
							<span>This is to acknowledge the receipt of Application
								Form as detailed below:</span>
						</div>
						</g:else>
						<g:if test="${formType == 'FormC' }">
							<div class="col-sm-12 form-group less-padding">
								<div style="width:33.33%; float: left; text-align: left;"><b>Application Reference Number :</b></div> 
								<div style="width:66.66%; float: left; text-align: left;"> ${appForm?.appNumber }</div>
							</div><br/>
							<div class="col-sm-12 form-group less-padding margintop5">

								<div style="width:33.33%; float: left; text-align: left;"><b>Name of the Applicant(s):</b></div> 
								<div style="width:66.66%; float: left; text-align: left;"> 
								<g:each in="${appForm?.depostionOfMicroOrganism }" var="deposition">
										${deposition?.nameOfDepositor}

									</g:each>
								</div>
							</div><br/>
							<div class="col-sm-12 form-group less-padding margintop5">
								<div style="width:33.33%; float: left; text-align: left;"><b>Address :</b></div> 
								<div style="width:66.66%; float: left; text-align: left;"> 
									<g:each in="${appForm?.depostionOfMicroOrganism }"
										var="deposition">
										${deposition?.address1}
										${deposition?.address2}
										${deposition?.address3}
										
										</g:each>
								</div>

							</div><br/>
							<div class="col-sm-12 form-group less-padding margintop5">

								<div style="width:33.33%; float: left; text-align: left;"><b>Purpose :</b></div>
								<div style="width:66.66%; float: left; text-align: left;"> 
									 Prior intimation for deposition of micro-organism by Indian scientist/ researchers in non-Indian 
									 repository (outside India) for claim of novel species.	
<%--									 ${appForm?.depositionPerpose }--%>
								</div>
							</div><br/>
							<div class="col-sm-12 form-group less-padding margintoppurpose">

								<div style="width:33.33%; float: left; text-align: left;"><b>Name of Foreign Repository:</b></div>
									 <div style="width:66.66%; float: left; text-align: left;"> 
									 		${foreignRepo?.repostoryName }
									  </div>
							</div><br/>
							<div class="col-sm-12 form-group less-padding margintop5">

								<div style="width:33.33%; float: left; text-align: left;"><b>Country of Foreign Repository:</b></div>
									 <div style="width:66.66%; float: left; text-align: left;"> 
									 		${foreignRepo?.country?.country }
									  </div>
							</div><br/>
						</g:if>
						<g:else>
							<div class="col-sm-12 form-group less-padding " >

								<div style="width:33.33%; float: left; text-align: left;"><b>Name of the Applicant(s):</b> </div> 
								<div style="width:66.66%; float: left; text-align: left;"> 
									<g:if test="${appForm?.companyProfiles?.size() == 0 }">
										<g:each in="${appForm?.individualProfiles }" var="individual">
											${individual?.title}
											${individual?.firstName}
											${individual?.middleName}
											${individual?.lastName}, 
										</g:each>
									</g:if>
									<g:else>
										<g:each in="${appForm?.companyProfiles }" var="company">
											${company?.entityName}, 
										</g:each>
									</g:else>
									
									
									<g:if test="${listOfIndianResearcher }">
										<g:each in="${listOfIndianResearcher }" var="indianResearcher">
											${indianResearcher?.title}
											${indianResearcher?.firstName}
											${indianResearcher?.middleName}
											${indianResearcher?.lastName}, 
										</g:each>
									</g:if>
									<g:elseif test="${listOfIndianGovtInst }">
										<g:each in="${listOfIndianGovtInst }" var="govtInst">
											${govtInst?.govtInstName},
										</g:each>
									</g:elseif>
								</div>
							</div><br/>
							<div class="col-sm-12 form-group less-padding" style="margin-top:25px">
								<div style="width:33.33%; float: left; text-align: left;"><b>Address :</b></div> 
								<div style="width:66.66%; float: left; text-align: left;">
									<g:if test="${appForm?.companyProfiles?.size() == 0 }">
										<g:each status="i" in="${individualProfileList }"
											var="individual">
											<g:if test="${appForm?.individualProfiles?.size() - i == 1 }">
												${individual?.address1 }
												${individual?.address2 }
												${individual?.address3 }
											</g:if>
											<g:else>
												${individual?.address1 }
												${individual?.address2 }
												${individual?.address3 },
										</g:else>
										</g:each>
									</g:if>
									 <g:else>
										<g:each status="i" in="${companyProfileList }" var="company">
											<g:if test="${appForm?.companyProfiles?.size() - i == 1 }">
												${company?.address1 }
												${company?.address2 }
												${company?.address3 }
											</g:if>
											<g:else>
												${company?.address1 }
												${company?.address2 }
												${company?.address3 },
										</g:else>
										</g:each>
									</g:else>
									
									
									<g:if test="${listOfIndianResearcher }">
										<g:each in="${listOfIndianResearcher }" var="researcher">
											${researcher?.address1}, ${researcher?.address2} ${researcher?.address3} ${researcher?.city}
											PIN:${researcher?.pincode}, ${researcher?.province} ${researcher?.country?.country}
										</g:each>
									</g:if>
									<g:elseif test="${listOfIndianGovtInst }">
										<g:each in="${listOfIndianGovtInst }" var="govtinst">
											${govtinst?.address1}, ${govtinst?.address2} ${govtinst?.address3} ${govtinst?.city}
											PIN:${govtinst?.pincode}, ${govtinst?.province} ${govtinst?.country?.country}
										</g:each>
									</g:elseif>
								</div>

							</div>
							<g:if test="${params.formType == 'Form1' }">
								<div class="col-sm-12 form-group less-padding" style="margin-top: 30px">
									<div style="width:33.33%; float: left; text-align: left;"><b>Form applied :</b></div> 
									<div style="width:66.66%; float: left; text-align: left;">Form I </div>
								</div>
							</g:if>
							<g:elseif test="${params.formType == 'Form2' }" >
								<div class="col-sm-12 form-group less-padding" style="margin-top: 30px">
									<div style="width:33.33%; float: left; text-align: left;"><b>Form applied :</b></div>  
									<div style="width:66.66%; float: left; text-align: left;">Form II </div>
								</div>
							</g:elseif>
							<g:elseif test="${params.formType == 'Form3' }" >
								<div class="col-sm-12 form-group less-padding" style="margin-top: 30px">
									<div style="width:33.33%; float: left; text-align: left;"><b>Form applied :</b></div>  
									<div style="width:66.66%; float: left; text-align: left;">Form III </div>
								</div>
							</g:elseif>
							<g:elseif test="${params.formType == 'Form4' }" >
								<div class="col-sm-12 form-group less-padding" style="margin-top: 30px">
									<div style="width:33.33%; float: left; text-align: left;"><b>Form applied :</b></div>  
									 <div style="width:66.66%; float: left; text-align: left;">Form IV </div>
								</div>
							</g:elseif>
							<g:elseif test="${params.formType == 'FormB' }" >
								<div class="col-sm-12 margintop">
									<div style="width:33.33%; float: left; text-align: left;"><b>Form applied :</b></div>   
									 <div style="width:66.66%; float: left; text-align: left;">Form B </div>
								</div>
							</g:elseif>


							<div class="col-sm-12 form-group less-padding margintoppurpose" >

								<div style="width:33.33%; float: left; text-align: left;"><b>Purpose :</b></div>
								<g:if test="${formType == 'Form1' }">
									<div style="width:66.66%; float: left; text-align: left;">Application form for access to
										biological resources and associated traditional knowledge.</div>
								</g:if>
								<g:elseif test="${formType == 'Form2' }">
									<div style="width:66.66%; float: left; text-align: left;">Application form for transferring
										the results of research to foreign nationals, companies, NRIs
										for commercial purposes.</div>
								</g:elseif>
								<g:elseif test="${formType == 'Form3' }">
									<div style="width:66.66%; float: left; text-align: left;">Application form for applying for
										Intellectual Property Right.</div>
								</g:elseif>
								<g:elseif test="${formType == 'Form4' }">
									<div style="width:66.66%; float: left; text-align: left;">Application form for third party
										transfer of the accessed biological resources and associated
										traditional knowledge.</div>
								</g:elseif>
								<g:elseif test="${formType == 'FormB' }">
									<div style="width:66.66%; float: left; text-align: left;">Conducting of non-commercial research or 
									research for emergency purposes outside India by Indian researcher's 
									Government institutions.</div>
								</g:elseif>
							</div>
						

						<div class="col-sm-12 form-group less-padding margintop">
							<div style="width:33.33%; float: left; text-align: left;"><b>Application Reference Number :</b></div> 
							<div style="width:66.66%; float: left; text-align: left;"> ${appForm?.appNumber }</div>
						</div>
						
						<div class="col-sm-12 text-center margintop" >
							<h3>
								<b>Declaration by the Applicant</b>
							</h3>

						</div>
						</g:else>

						<g:if test="${formType != 'FormC' }">
							<div class="col-sm-12 form-group less-padding margintop5">
						  	<span>I/We
						  			<g:if test="${listOfIndianResearcher }">
											<g:each in="${listOfIndianResearcher }" var="researcher">
												<b>
													${researcher?.title}
													${researcher?.firstName}
													${researcher?.middleName}
													${researcher?.lastName}, 
												</b>
		
											</g:each>
									</g:if>
									<g:elseif test="${listOfIndianGovtInst }">
										<g:each in="${listOfIndianGovtInst }" var="govtinst">
												<b>
													${govtinst?.govtInstName},
												</b>
		
											</g:each>
									</g:elseif>
									<g:if test="${appForm?.companyProfiles?.size() == 0 }">
										<g:each in="${individualProfileList }" var="individual">
											<b> ${individual?.title} ${individual?.firstName} ${individual?.middleName}
												${individual?.lastName},
											</b>
										</g:each>
									</g:if> 
									<g:else>
										<g:each in="${companyProfileList }" var="company">
											<b> ${company?.entityName},
											</b>
										</g:each>
										
									</g:else> 
									hereby declare that the information provided in the Application
									Form is true and correct and I / we shall be responsible for any
									incorrect or wrong information
								</span><br />
								<br />
								<br />
							</div>
						</g:if>
						
						<g:if test="${formType == 'FormC'}">
						
							<div class="pull-right paddingright margintop">
								<b>For National Biodiversity Authority</b>
							</div><br />
							<div class="col-sm-12 form-group less-padding margintop" >
								<span>
									<b>Note:</b> Form-C is merely an intimation and approval /permission of the NBA is not required. It is to state that any non-Indian 
									person/ entity accessing the deposited Indian biological resource from the foreign repository should obtain the prior approval 
									of NBA as per Section 3 of the Biological Diversity Act, 2002.
								</span>
								
								
								<br />
								<br />
							</div>
						</g:if>


						<g:if test="${formType != 'FormC' }">
							<div class="col-sm-12 form-group text-left">
								<span class="pull-left"><b>Date:</b> <%= new Date().format( 'dd-MM-yyyy' ) %>
								</span> <span></span> <span class="pull-right"><b>Signature
										of Applicant</b></span><br /> <span></span>
							</div>
							<div class="col-sm-12 form-group less-padding">
								<b>Note:</b> One Copy of the acknowledgement duly signed by the
								application may be sent to the Secretary National Biodiversity
								Authority, TICEL Bio-park, CSIR Road, Taramani, Chennai 600113,
								India
	
							</div>
						</g:if>



						<div class="col-sm-12 form-grou ">
							<i>Please quote the above reference number in all your
								communication with the National Biodiversity Authority.</i>
						</div>

					</div>
				</g:else>
	
			</div>
		</div>
	</div>
</body>
</html>