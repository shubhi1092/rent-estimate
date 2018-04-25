
$('form[name="signupform"]').submit(function(event){

    var obj = new Object();
    obj.firstName = $('input[name="firstName"]').val();
    obj.lastName = $('input[name="lastName"]').val();
    obj.emailAddress = $('input[name="emailAddress"]').val();
    obj.phoneNumber = $('input[name="phoneNumber"]').val();


    $.ajax({
        type: 'POST',
        url: '/user/',
        dataType: 'json',
        data: JSON.stringify(obj),
        contentType : 'application/json',
        success: function(data, status, response) {

            console.log(response);
        },
        error: function(){
            console.log("Error Occured");
        }
    });

    event.preventDefault();
})