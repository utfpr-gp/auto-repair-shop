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
    FORM_AUTO_REPAIR_SHOP = 'oficinas/novo';
    AUTO_REPAIR_SHOPS = 'oficinas';
    FORM_MAINTENANCE = 'atendimentos/novo';
    MAINTENANCES = 'atendimentos';
    FORM_VEHICLE = 'veiculos/novo';
    VEHICLES = 'veiculos';


    pagina = window.location.href;

    if (pagina.includes(AUTO_REPAIR_SHOPS)) {
        if (pagina.includes(FORM_AUTO_REPAIR_SHOP)) {
            $(".auto-repair-shop-register").addClass("active");
        } else if (pagina.includes(AUTO_REPAIR_SHOPS)) {
            $(".auto-repair-shop-list").addClass("active");
        }
        $(".vehicle").addClass("active");
    }

    if (pagina.includes(MAINTENANCES)) {
        if (pagina.includes(FORM_MAINTENANCE)) {
            $(".maintenance-register").addClass("active");
        } else if (pagina.includes(MAINTENANCES)) {
            $(".maintenance-history").addClass("active");
        }
        $(".vehicle").addClass("active");
    }

    if (pagina.includes(VEHICLES)) {
        if (pagina.includes(FORM_VEHICLE)) {
            $(".vehicle-register").addClass("active");
        } else if (pagina.includes(VEHICLES)) {
            $(".vehicle-list").addClass("active");
        }
        $(".vehicle").addClass("active");
    }

}