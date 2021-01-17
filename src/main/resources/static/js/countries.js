var buttonLoad;
var dropdownCountry;
var buttonAdd;
var fieldCountryName;


$(document).ready(function(){
	buttonLoad = $("#buttonLoadCountries");
	dropdownCountry= $("#dropDownCountries");
	fieldCountryName= $("#fieldCountryName");
	buttonAdd = $("#buttonAdd");
	buttonLoad.click(function(){
		//alert('Loading countries....');//for test java script working
		loadCountries();
	});
	buttonAdd.click(function(){
		addCountry();
	});
});

function loadCountries(){
	
	url ="countries/list";
	$.get(url, function(responseJson){
		dropdownCountry.empty();
		
		$.each(responseJson, function(index, country){
			// alert(country.name);// SHOW COUNTRIES TEST
			$("<option>").val(country.id).text(country.name).appendTo(dropdownCountry);
		});
		
		alert(responseJson);
	}).done(function(){
		
	}).fail(function(){
		
	});
}
function addCountry(){
	url= "countries/save";
	countryName= fieldCountryName.val();
	jsonData ={name: countryName};
	
	
	
	
	
}
