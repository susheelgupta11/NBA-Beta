<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<%--<zing:include />--%>

<script src= "https://cdn.zingchart.com/zingchart.min.js"></script>
    <script> zingchart.MODULESDIR = "https://cdn.zingchart.com/modules/";
    ZC.LICENSE =["569d52cefae586f634c54f86dc99e6a9","ee6b7db5b51705a13dc2339db3edaf6d"];   
 </script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name='layout' content='nbaDashboardLayout' />
<title>NBA</title>

</head>
<body>
 <div id='myChart' style="margin-left: 300px;" ></div>
<%--<zing:chart type="area" width="700" height="350" --%>
<%--    container="acceptToConvertChart" data="${data}" xLabels="${labels}" effect="4" />--%>

    <script type="text/javascript">
    zingchart.THEME = "classic";
    var myConfig = {
      "type": "bar",
      "background-color": "#fff",
      "stacked": false,
      "title": {
        "text": "Crystal Report For the NBA Application",
        "background-color": "#fff",
        "font-color": "#05636c",
        "adjust-layout": true
      },
      "tooltip": {
        "visible": false
      },
      "plot": {
        "aspect": "stepped",
        "line-width": "1px",
        "marker": {
          "visible": false
        },
        "hover-state": {
          "visible": false
        },
        "shadow": false
      },
      "plotarea": {
        "margin": "dynamic"
      },
      "scale-x": {
        "values": [
          "Total", "In Process", "Approved", "Reject"
        ],
        "line-color": "#000",
        "line-width": "1px",
        "guide": {
          "visible": false
        },
        "tick": {
          "line-color": "#000",
          "line-width": "1px"
        },
        "label": {
          "text": "Application Type",
          "font-size": "14px",
          "font-family": "helvetica",
          "font-weight": "normal",
          "offset-y": "5%",
          "font-color": "#05636c"
        },
        "item": {
          "font-color": "#05636c",
          "font-weight": "normal",
          "font-family": "helvetica",
          "font-size": "12px",
          "offset-y": "3%"
        }
      },
      "scale-y": {
        "values": "0:10000:50",
        "line-color": "#000",
        "line-width": "1px",
        "tick": {
          "line-color": "#000",
          "line-width": "1px"
        },
        "label": {
          "text": "Application",
          "font-size": "14px",
          "font-family": "helvetica",
          "font-weight": "normal",
          "font-color": "#05636c"
        },
        "item": {
          "font-color": "#05636c",
          "font-weight": "normal",
          "font-family": "helvetica",
          "font-size": "12px",
          "offset-x": "-5%"
        },
        "guide": {
          "visible": false
        }
      },
      "crosshair-x": {
        "line-color": "#ffffff",
        "marker": {
          "visible": false
        },
        "plot-label": {
          "text": "<strong>%v</strong> %t",
          "shadow": 0,
          "font-size": "12px",
          "font-color": "#05636c",
          "font-family": "helvetica",
          "border-width": "1px",
          "border-color": "#05636c",
          "background-color": "#ffffff",
          "text-align": "center"
        },
        "scale-label": {
          "font-size": "12px",
          "font-color": "#000000",
          "font-family": "helvetica",
          "background-color": "#ffffff",
          "offset-y": "3%"
        }
      },
      "series": [{
        "values": ${labels}
      }]
    };

    zingchart.render({
      id: 'myChart',
      data: myConfig,
      height: 500,
      width: 700
    });

    </script>
</body>
</html>