<!DOCTYPE html>
<html>
	<head>
		

<title>NBA</title>
	</head>
	<body>



<table class="table table-bordered" style="background:#d3d3d3;">
            <thead>
            <tr>
            <th>File details</th>
            </tr>
            </thead>
          </table>
          <table class="col-sm-12"  style="margin-bottom: 20px;">
            <tbody>
              <tr class="">
                <td class=""><span><b>Classified</b></span>
                 ${manualDataDetails?.classified}</td>
                <td><span ><b>Language</b></span>
                  ${manualDataDetails?.language}</td>
              </tr>
              <tr>
                <td><span ><b>Type</b></span>
                ${manualDataDetails?.letterDate}</td>
                <td><span><b>Letter Date*</b></span>
                  ${manualDataDetails?.letterDate}</td>
              </tr>
              <tr class="">
                <td style=""><span ><b>Mobile No.</b></span>
                  ${manualDataDetails?.mobileNumber}</td>
                <td><span ><b>File No.</b></span>
                 ${manualDataDetails?.fileNumber}</td>
              </tr>
              <tr>
                <td><span ><b>Delivery Mode</b></span>
                 ${manualDataDetails?.deliveryMode}</td>
                <td><span ><b>Letter Ref. No.</b></span>
                  ${manualDataDetails?.letterReferenceNumber}</td>
              </tr>
            </tbody>
          </table>
         
          <table class="table table-bordered" style="background:#d3d3d3; border-top: solid gray;">
            <thead>
            <tr>
            <th>Contact details</th>
            </tr>
                </thead>
          
          </table>
          <table class="col-sm-12" style="margin-bottom: 20px;">
            <tbody>
              <tr>
                <td><span ><b>Name</b></span>
                  ${manualDataDetails?.name}</td>
                <td><span ><b>Designation</b></span>
                  ${manualDataDetails?.designation}</td>
              </tr>
              <tr>
                <td><span ><b>Address 1</b></span>
                  ${manualDataDetails?.address1}</td>
                <td style=""><span ><b>Address 2</b></span>
                 ${manualDataDetails?.address2}</td>
              </tr>
              <tr>
                <td><span ><b>Country</b></span>
                 ${manualDataDetails?.country}</td>
                <td><span ><b>State</b></span>
                 ${manualDataDetails?.state}</td>
              </tr>
              <tr>
                <td><span ><b>City</b></span>
                  ${manualDataDetails?.city}</td>
                <td><span ><b>Pin</b></span>
                  ${manualDataDetails?.pin}</td>
              </tr>
             
            </tbody>
          </table>
          
          </body>
          </html>