
function windowload(){
if(null != sessionStorage.getItem('locationInfo')){
		
		var resultDiv = document.getElementById('locationLatlng'); 
	     	resultDiv.innerHTML = sessionStorage.getItem('locationInfo');
		}
	
}
window.onload = windowload;