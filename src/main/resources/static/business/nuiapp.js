//Include this line in index.html body
//<script src="nuiapp.js" type="application/javascript"></script>

function postNUIMessage(data) {
    NUIMiniProgram.postMessage(data);
}

window.logger = (flutter_value) => {
   console.log({ js_context: this, flutter_value });
}