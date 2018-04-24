$('form[name="signupform"]').submit(function(){

    var obj = $('form[name="signupform"]').serializeJSON();

    $.ajax({
        type: 'POST',
        url: '/user/',
        dataType: 'json',
        data: JSON.stringify(obj),
        contentType : 'application/json',
        success: function(data) {
            alert(data)
        }
    });