function getData() {
    $.ajax({
    	url: 'https://lit-cove-9272.herokuapp.com/api/productjson',
        type: 'GET',
    	dataType: 'json'
    });
}


function getDataXML() {
    alert("Hello1");
    $.ajax({
        url: 'https://lit-cove-9272.herokuapp.com/api/productinfo',
    	type: 'GET',
    	dataType: 'XML',
        success : handleDataXML
    });
}

function handleDataXML(data) {
    alert("Hello2");
    $(data).find('itemDetails').each(function(){
    var itemID = $(this).find('itemid').text();
    var itemName = $(this).find('itemname').text();
    var itemPrice = $(this).find('itemprice').text();
    var itemBrand = $(this).find('itembrand').text();
    var itemCategory = $(this).find('itemcategory').text();
    var itemDescription = $(this).find('itemdescription').text();
    var itemColor = $(this).find('itemcolor').text();
    var itemRating = $(this).find('itemrating').text();
    var itemStock = $(this).find('itemstock').text();
    var itemGender = $(this).find('itemgender').text();
    var itemSize = $(this).find('itemsize').text();
    $('<tr></tr>').html('<td>'+itemID+'</td><td>'+itemName+'</td><td>'+itemPrice+'</td><td>'+itemBrand+'</td><td>'+itemCategory+'</td><td>'+itemDescription+'</td><td>'+itemColor+'</td><td>'+itemRating+'</td><td>'+itemStock+'</td><td>'+itemGender+'</td><td>'+itemSize+'</td>').appendTo('#productxml');
   });
}
