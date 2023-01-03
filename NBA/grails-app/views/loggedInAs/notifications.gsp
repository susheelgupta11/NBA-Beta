<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='loggedInUser' />

<title>NBA</title>
<script type="text/javascript">
	$(document).ready(function() {
		$('[data-toggle="tooltip"]').tooltip();
	});
</script>
</head>
<body>
	<div class="container">
		<div class="row ">
			<div class="col-sm-8 col-sm-offset-2 text-center form_heading">
				<h3>Notifications</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-8 col-sm-offset-2 middle_box textalign">
				<h4 class="text-danger">Act/ Rules/ Regulations / Guidelines/
					Orders issued by the Competent Authorities</h4>
				<g:each in="${listOfNotifications?.sort{it?.id}}" var="notification">
					<g:if test="${notification?.docName == 'Notification 1.'}">
						<span class="col-sm-12 form-group"><span class="leftflot">1.</span><span
							class="col-sm-11 notificationwidth"><g:link
									controller="loggedInAs" action="showDc"
									id="${notification?.id}"
									params='[filename: "notification1", dataName: "notification1"]'
									target="_blank">
									<b> Biological Diversity Act 2002 &amp; Biological
										Diversity Rules 2004.</b>
								</g:link></span></span>
					</g:if>
					<g:if test="${notification?.docName == 'Notification 2.'}">
						<span class="col-sm-12 form-group"><span class="leftflot">2.</span>
							<span class="col-sm-11 notificationwidth"><g:link
									controller="loggedInAs" action="showDc"
									id="${notification?.id}"
									params='[filename: "notification2", dataName: "notification2"]'
									target="_blank">
									<b> Section 3-7, 18-47, 49-53, 55-58, 60 and 61 of the Act
										come in to force.</b>
								</g:link></span></span>
					</g:if>
					<g:if test="${notification?.docName == 'Notification 3.'}">
						<span class="col-sm-12 form-group"><span class="leftflot">3.
						</span> <span class="col-sm-11 notificationwidth"><g:link
									controller="loggedInAs" action="showDc"
									id="${notification?.id}"
									params='[filename: "notification3", dataName: "notification3"]'
									target="_blank">
									<b> Guidelines on access to biological resources and
										associated knowledge and benefits sharing regulations, 2014.</b>
								</g:link></span></span>
					</g:if>
					<g:if test="${notification?.docName == 'Notification 4.'}">
						<span class="col-sm-12 form-group"><span class="leftflot">4.
						</span><span class="col-sm-11 notificationwidth"><g:link
									controller="loggedInAs" action="showDc"
									id="${notification?.id}"
									params='[filename: "notification4", dataName: "notification4"]'
									target="_blank">
									<b>Guidelines for upfront payment for access to biological
										resources for research or bio-survey and bio-utilization for
										commercial utilization</b>
								</g:link></span></span>
					</g:if>
					<g:if
						test="${notification?.docName == 'Notification 5.(i)'}">
						<span class="col-sm-12 form-group"><span class="leftflot">5.
						</span><span class="col-sm-11 notificationwidth"> Designation of
								repositories under the Biological Diversity Act, 2002 from time
								to time: <g:if test="${notification5i}">
									<g:link controller="loggedInAs" action="showDc"
										id="${notification5i?.id}"
										params='[filename: "notification5i", dataName: "notification5i"]'
										target="_blank">
										<b>28 August, 2008 /</b>
									</g:link>
								</g:if> <g:if test="${notification5ii}">
									<g:link controller="loggedInAs" action="showDc"
										id="${notification5ii?.id}"
										params='[filename: "notification5ii", dataName: "notification5ii"]'
										target="_blank">
										<b> 12 September, 2012 /</b>
									</g:link>
								</g:if> <g:if test="${notification5iii}">
									<g:link controller="loggedInAs" action="showDc"
										id="${notification5iii?.id}"
										params='[filename: "notification5iii", dataName: "notification5iii"]'
										target="_blank">
										<b> 8 July 2013</b>
									</g:link>
								</g:if>
						</span></span>
					</g:if>
					<g:if test="${notification?.docName == 'Notification 6.'}">
						<span class="col-sm-12 form-group"><span class="leftflot">6.</span>
							<span class="col-sm-11 notificationwidth"><g:link
									controller="loggedInAs" action="showDc"
									id="${notification?.id}"
									params='[filename: "notification6", dataName: "notification6"]'
									target="_blank">
									<b> Guidelines for designated repository and applicant with
										regard to deposition of voucher specimen</b>
								</g:link></span></span>
					</g:if>
					<g:if test="${notification?.docName == 'Notification 7.'}">
						<span class="col-sm-12 form-group"><span class="leftflot">7.
						</span> <span class="col-sm-11 notificationwidth"><g:link
									controller="loggedInAs" action="showDc"
									id="${notification?.id}"
									params='[filename: "notification7", dataName: "notification7"]'
									target="_blank">
									<b> Guidelines for international collaborative research
										projects.</b>
								</g:link></span></span>
					</g:if>
					<g:if test="${notification?.docName == 'Notification 8.'}">
						<span class="col-sm-12 form-group"><span class="leftflot">8.</span>
							<span class="col-sm-11 notificationwidth"><g:link
									controller="loggedInAs" action="showDc"
									id="${notification?.id}"
									params='[filename: "notification8", dataName: "notification8"]'
									target="_blank">
									<b> Exemption of crops listed in the Annex I of the
										International Treaty on Plant Genetic Resources for Food and
										Agriculture (ITPGRFA) from seeking approval of NBA under
										Section 3 and 4 of the Biological Diversity Act, 2002</b>
								</g:link></span></span>
					</g:if>
					<g:if
						test="${notification?.docName == 'Notification 9.(a- Bihar)'}">
						<span class="col-sm-12 form-group"> <span class="leftflot">9.</span>
							<span class="col-sm-11 notificationwidth"> Species of
								plants and animals which are on the verge of extinction in the
								State / UT (Province) of: <g:if test="${notificationBihar}"><g:link controller="loggedInAs"
									action="showDc" id="${notificationBihar?.id}"
									params='[filename: "notificationBihar", dataName: "notificationBihar"]'
									target="_blank">
									<b>Bihar</b>
								</g:link></g:if>,<g:if test="${notificationGoa}"><g:link controller="loggedInAs" action="showDc"
									id="${notificationGoa?.id}"
									params='[filename: "notificationGoa", dataName: "notificationGoa",csrfPreventionSalt:"${csrfPreventionSalt}"]'
									target="_blank">
									<b> Goa</b>
								</g:link></g:if>, <g:if test="${notificationHimachal}"><g:link controller="loggedInAs" action="showDc"
									id="${notificationHimachal?.id}"
									params='[filename: "notificationHimachal", dataName: "notificationHimachal",csrfPreventionSalt:"${csrfPreventionSalt}"]'
									target="_blank">
									<b>Himachal Pradesh</b>
								</g:link></g:if>,<g:if test="${notificationKarnataka}"><g:link controller="loggedInAs" action="showDc"
									id="${notificationKarnataka?.id}"
									params='[filename: "notificationKarnataka", dataName: "notificationKarnataka",csrfPreventionSalt:"${csrfPreventionSalt}"]'
									target="_blank">
									<b> Karnataka</b>
								</g:link></g:if>,<g:if test="${notificationKerala}"><g:link controller="loggedInAs" action="showDc"
									id="${notificationKerala?.id}"
									params='[filename: "notificationKerala", dataName: "notificationKerala",csrfPreventionSalt:"${csrfPreventionSalt}"]'
									target="_blank">
									<b> Kerala</b>
								</g:link></g:if>, <g:if test="${notificationMadhya}"><g:link controller="loggedInAs" action="showDc"
									id="${notificationMadhya?.id}"
									params='[filename: "notificationMadhya", dataName: "notificationMadhya",csrfPreventionSalt:"${csrfPreventionSalt}"]'
									target="_blank">
									<b>Madhya Pradesh</b>
								</g:link></g:if>,<g:if test="${notificationManipur}"><g:link controller="loggedInAs" action="showDc"
									id="${notificationManipur?.id}"
									params='[filename: "notificationManipur", dataName: "notificationManipur",csrfPreventionSalt:"${csrfPreventionSalt}"]'
									target="_blank">
									<b> Manipur</b>
								</g:link></g:if>,<g:if test="${notificationMeghalaya}"><g:link controller="loggedInAs" action="showDc"
									id="${notificationMeghalaya?.id}"
									params='[filename: "notificationMeghalaya", dataName: "notificationMeghalaya",csrfPreventionSalt:"${csrfPreventionSalt}"]'
									target="_blank">
									<b> Meghalaya</b>
								</g:link></g:if>,<g:if test="${notificationMizoram}"><g:link controller="loggedInAs" action="showDc"
									id="${notificationMizoram?.id}"
									params='[filename: "notificationMizoram", dataName: "notificationMizoram",csrfPreventionSalt:"${csrfPreventionSalt}"]'
									target="_blank">
									<b> Mizoram</b>
								</g:link></g:if>,<g:if test="${notificationOrissa}"><g:link controller="loggedInAs" action="showDc"
									id="${notificationOrissa?.id}"
									params='[filename: "notificationOrissa", dataName: "notificationOrissa",csrfPreventionSalt:"${csrfPreventionSalt}"]'
									target="_blank">
									<b> Orissa</b>
								</g:link></g:if>, <g:if test="${notificationPunjab}"><g:link controller="loggedInAs" action="showDc"
									id="${notificationPunjab?.id}"
									params='[filename: "notificationPunjab", dataName: "notificationPunjab",csrfPreventionSalt:"${csrfPreventionSalt}"]'
									target="_blank">
									<b>Punjab</b>
								</g:link></g:if>,<g:if test="${notificationTamil}"> <g:link controller="loggedInAs" action="showDc"
									id="${notificationTamil?.id}"
									params='[filename: "notificationTamil", dataName: "notificationTamil",csrfPreventionSalt:"${csrfPreventionSalt}"]'
									target="_blank">
									<b>Tamil Nadu</b>
								</g:link></g:if>,<g:if test="${notificationTripura}"><g:link controller="loggedInAs" action="showDc"
									id="${notificationTripura?.id}"
									params='[filename: "notificationTripura", dataName: "notificationTripura",csrfPreventionSalt:"${csrfPreventionSalt}"]'
									target="_blank">
									<b> Tripura</b>
								</g:link></g:if>,<g:if test="${notificationUttar}"><g:link controller="loggedInAs" action="showDc"
									id="${notificationUttar?.id}"
									params='[filename: "notificationUttar", dataName: "notificationUttar",csrfPreventionSalt:"${csrfPreventionSalt}"]'
									target="_blank">
									<b> Uttar Pradesh</b>
								</g:link></g:if>,<g:if test="${notificationUttarakhand}"><g:link controller="loggedInAs" action="showDc"
									id="${notificationUttarakhand?.id}"
									params='[filename: "notificationUttarakhand", dataName: "notificationUttarakhand",csrfPreventionSalt:"${csrfPreventionSalt}"]'
									target="_blank">
									<b> Uttarakhand</b>
								</g:link></g:if>,<g:if test="${notificationWest}"><g:link controller="loggedInAs" action="showDc"
									id="${notificationWest?.id}"
									params='[filename: "notificationWest", dataName: "notificationWest",csrfPreventionSalt:"${csrfPreventionSalt}"]'
									target="_blank">
									<b> West Bengal</b>
								</g:link></g:if>, <g:if test="${notificationBihar}"><g:link controller="loggedInAs" action="showDc"
									id="${notification?.id}"
									params='[filename: "notificationBihar", dataName: "notificationBihar",csrfPreventionSalt:"${csrfPreventionSalt}"]'
									target="_blank">
									<b>Andaman & Nicobar</b>
								</g:link></g:if>, <g:if test="${notificationBihar}"><g:link controller="loggedInAs" action="showDc"
									id="${notification?.id}"
									params='[filename: "notificationBihar", dataName: "notificationBihar",csrfPreventionSalt:"${csrfPreventionSalt}"]'
									target="_blank">
									<b>Diu & Daman</b>
								</g:link></g:if>
						</span>
						</span>
					</g:if>
					<g:if test="${notification?.docName == 'Notification 10.'}">
						<span class="col-sm-12 form-group"><span class="leftflot">10.</span><span
								class="col-sm-11 notificationwidth"><g:link controller="loggedInAs" action="showDc"
							id="${notification?.id}"
							params='[filename: "notification10", dataName: "notification10",csrfPreventionSalt:"${csrfPreventionSalt}"]'
							target="_blank">
							<b>Procedure for closing
									of applications</b>
						</g:link></span></span>
					</g:if>
				</g:each>
				<br />

			</div>

		</div>
	</div>
</body>
</html>