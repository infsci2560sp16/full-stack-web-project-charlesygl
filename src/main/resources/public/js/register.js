$.ajaxSetup({
   contentType: "application/json; charset=utf-8",
   dataType: "json"
});
$(document).ready(function(){
    $('#register_button').click(function(){
        
        // Get data from form 
        var firstNameValue = document.getElementById('register_first_name').value;
        var lastNameValue = document.getElementById('register_last_name').value;
        var emailAddressValue = document.getElementById('register_email_address').value;
        var passwordValue = document.getElementById('register_password').value;
        var userNameValue = document.getElementById('register_user_name').value;
        var zipCodeValue = document.getElementById('register_zip_code').value;
        
        // Convert form data to JSON
        var object = $('#c_form').serializeJSON();
        var sendObject = JSON.stringify(object);
        
        // Get JSON
        console.log(sendObject);
        
        $.ajax({
            url: 'https://lit-cove-9272.herokuapp.com/api/adduser',
            type: "POST",
            datatype: "json",
            data: send,
            error: function(xhr, error) {
                alert('Error! Status = ' + xhr.status + ' Message = ' + error);
            },
            success: function(data){
                alert("User added successfully.");
                window.location.href = '/index.html';
            }
        }); //end of ajax
    }); // end of click function
}); // end of ready 

