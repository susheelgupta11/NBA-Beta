var Scriptaculous={Version:"1.8.1",require:function(e){document.write('<script type="text/javascript" src="'+e+'"></script>')},REQUIRED_PROTOTYPE:"1.6.0",load:function(){function e(e){var t=e.split(".");return parseInt(t[0])*1e5+parseInt(t[1])*1e3+parseInt(t[2])}if(typeof Prototype=="undefined"||typeof Element=="undefined"||typeof Element.Methods=="undefined"||e(Prototype.Version)<e(Scriptaculous.REQUIRED_PROTOTYPE))throw"script.aculo.us requires the Prototype JavaScript framework >= "+Scriptaculous.REQUIRED_PROTOTYPE;$A(document.getElementsByTagName("script")).findAll(function(e){return e.src&&e.src.match(/scriptaculous\.js(\?.*)?$/)}).each(function(e){var t=e.src.replace(/scriptaculous\.js(\?.*)?$/,"");var n=e.src.match(/\?.*load=([a-z,]*)/);(n?n[1]:"builder,effects,dragdrop,controls,slider,sound").split(",").each(function(e){Scriptaculous.require(t+e+".js")})})}};Scriptaculous.load()