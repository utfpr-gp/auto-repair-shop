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
    FORM_VEHICLE = 'veiculos/novo';
    VEHICLES = 'veiculos';

    pagina = window.location.href;
    if (pagina.includes(VEHICLES)) {
        if (pagina.includes(FORM_VEHICLE)) {
            $(".vehicle-register").addClass("active");
        } else if (pagina.includes(VEHICLES)) {
            $(".vehicle-list").addClass("active");
        } else {
            $(".vehicle-client-list").addClass("active");
        }
        $(".vehicle").addClass("active");
    }

}