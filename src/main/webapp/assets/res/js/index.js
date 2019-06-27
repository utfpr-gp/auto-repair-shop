$(document).ready(function () {
    M.AutoInit();
    $('.input-field').mouseover(function (e) {
        $(this).find('i').addClass('active');
    });
    $('.input-field').mouseout(function (e) {
        $(this).find('i').removeClass('active');
    });

    $("#birthDate").datepicker({
        format: 'dd/mm/yyyy',
        changeMonth: true,
        changeYear: true
    });
});


