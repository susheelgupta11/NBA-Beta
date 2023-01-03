<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>TR5</title>
   <style type="text/css">
   
   

.clearfix:after {
  content: "";
  display: table;
  clear: both;
}

a {
  color: #0087C3;
  text-decoration: none;
}

body {
  position: relative;
  width: 21cm;  
  height: 18cm; 
  margin: 0 auto; 
  color: #555555;
  background: #FFFFFF; 
  font-family: Arial, sans-serif; 
  font-size: 14px; 
  font-family: SourceSansPro;
}

header {
  padding: 10px 0;
  margin-bottom: 20px;
  border-bottom: 1px solid #AAAAAA;
}



#company {
  float: right;
  text-align: right;
}


#details {
  margin-bottom: 50px;
  border: 1px dotted;
  padding: 1.5em;
}

#client {
  padding-left: 6px;
  border-left: 6px solid #0087C3;
  float: left;
}

#client .to {
  color: #777777;
}

h2.name {
  font-size: 1.4em;
  font-weight: normal;
  margin: 0;
}

#invoice {
  float: right;
  text-align: right;
}

#invoice h1 {
  color: #0087C3;
  font-size: 2.4em;
  line-height: 1em;
  font-weight: normal;
  margin: 0  0 10px 0;
}

#invoice .date {
  font-size: 1.1em;
  color: #777777;
}

table {
  width:100%;
  padding: 20px;
  font-size: 1em;
  
  }
table, th, td {
  text-align: center;
  border-collapse: collapse;
}
th, td {
  padding: 12px;
  text-align: left;
}
#t01 tr:nth-child(even) {
  background-color: #eee;
}
#t01 tr:nth-child(odd) {
 background-color: #fff;
}
#t01 th {
  background-color: black;
  color: white;
}

#thanks{
  font-size: 2em;
  margin-bottom: 0px;
}

#notices{
  padding-left: 6px;
  border-left: 6px solid #0087C3;  
}

#notices .notice {
  font-size: 1.2em;
}

footer {
  color: #777777;
  width: 100%;
  height: 30px;
  position: absolute;
  bottom: 0;
  border-top: 1px solid #AAAAAA;
  padding: 8px 0;
  text-align: center;
 
}
   </style>
  </head>
  <body>
    <header class="clearfix">
      <div id="logo">
      <a href="https://absefiling.nic.in/NBA/login/auth" target="_blank">
                             <img src="https://absefiling.nic.in/NBA/assets/letter-head.jpg" width="800"  alt="NBA" border="0" style="display: block;" /></a>
               
      </div>
    </header>
    <main>

      <div id="details" class="clearfix">
   <table>
      <tr>
        <td><b>Send To :</b> ${tr5ReceiptInstance?.emailId}</td>
        <td><b>cc :</b> ${tr5ReceiptInstance?.ccEmailId}</td>
        <td><b>Subject :</b> ${tr5ReceiptInstance?.subject}</td>
      </tr>
      <tr>
        <td>G.A.R. 6 [ See Rule 22(j)] T.R.5[ See Rule 83]</td>
        <td style="font-size: 2em;"><b>E-RECEIPT</b></td>
        <td >Computer Generated</td>
      </tr>
       <tr>
        <td>e-Receipt No : ${tr5ReceiptInstance?.receiptNo}</td>
        <td colspan="2">Date : <g:formatDate format="dd/MM/yyyy" date="${tr5ReceiptInstance?.createdDate}" /></td>
      </tr>
      <tr>
        <td colspan="2">Received from : ${tr5ReceiptInstance?.applicantName}</td>
        <td >Application Number : ${tr5ReceiptInstance?.appNumber}</td>
     </tr>
     <tr>
        <td >With Letter No : ${tr5ReceiptInstance?.letterNo}</td>
        <td colspan="2">Date :${tr5ReceiptInstance?.dated}</td>
     </tr>
     <tr>
        <td >The Sum of the Rupees :INR  ${tr5ReceiptInstance?.sumOfRupees}</td>
        <td colspan="2"> In Word :${tr5ReceiptInstance?.moneyInWords}</td>
     </tr>
     <tr>
        <td colspan="3">Amount received as :${tr5ReceiptInstance?.paymentFor}</td>
     </tr>
      <tr>
        <td>Payment Type :${tr5ReceiptInstance?.paymentType}</td>
				
        <td colspan="2">In payment of : ${tr5ReceiptInstance?.paymentOf}</td>
     </tr>
    </table>
  


    </div>
    <div id="notices">
        <div>NOTICE:</div>
        <div class="notice">A finance charge of 1.5% will be made on unpaid balances after 30 days.</div>
      </div>
    </main>
    <footer>
      Invoice was created on a computer and is valid without the signature and seal.
    </footer>
  </body>
</html>