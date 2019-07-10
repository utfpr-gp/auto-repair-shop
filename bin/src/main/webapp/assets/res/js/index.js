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


function getCurrentYear(){
    return new Date().getFullYear();
}

function efeitoMenu() {
    CAD_VEHICLE = 'veiculos/novo';
    LIS_VEHICLE = 'veiculos';

    pagina = window.location.href;
    if (pagina.includes(LIS_VEHICLE)) {
        if (pagina.includes(CAD_VEHICLE)) {
            $(".vehicle-register").addClass("active");
        } else if (pagina.includes(LIS_VEHICLE)) {
            $(".vehicle-list").addClass("active");
        } else {
            $(".vehicle-client-list").addClass("active");
        }
        $(".vehicle").addClass("active");
    }

}