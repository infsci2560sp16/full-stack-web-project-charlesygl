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
    var itemID = $(this).find('itemID').text();
    var itemName = $(this).find('itemName').text();
    var itemPrice = $(this).find('itemPrice').text();
    var itemBrand = $(this).find('itemBrand').text();
    var itemCategory = $(this).find('itemCategory').text();
    var itemDescription = $(this).find('itemDescription').text();
    var itemColor = $(this).find('itemColor').text();
    var itemRating = $(this).find('itemRating').text();
    var itemStock = $(this).find('itemStock').text();
    var itemGender = $(this).find('itemGender').text();
    var itemSize = $(this).find('itemSize').text();
    $('<tr></tr>').html('<td>'+itemID+'</td><td>'+itemName+'</td><td>'+itemPrice+'</td><td>'+itemBrand+'</td><td>'+itemCategory+'</td><td>'+itemDescription+'</td><td>'+itemColor+'</td><td>'+itemRating+'</td><td>'+itemStock+'</td><td>'+itemGender+'</td><td>'+itemSize+'</td>').appendTo('#productxml');
   });
}
