$(document).ready(function () {
    M.AutoInit();
    $('.input-field').mouseover(function (e) {
        $(this).find('i').addClass('active');
    });
    $('.input-field').mouseout(function (e) {
        $(this).find('i').removeClass('active');
    });
    $('#year').html(getCurrentYear());
});


function getCurrentYear(){
    return new Date().getFullYear();    
}




