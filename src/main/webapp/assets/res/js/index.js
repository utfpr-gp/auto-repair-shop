$(document).ready(function () {
    M.AutoInit();
    $('.input-field').mouseover(function (e) {
        $(this).find('i').addClass('active');
    });
    $('.input-field').mouseout(function (e) {
        $(this).find('i').removeClass('active');
    });
    $('.modal').modal({
        onOpenEnd: function (modal, trigger) {
            var url = $(trigger).data('url');
            var name = $(trigger).data('name');

            modal = $(modal);
            var form = modal.find('form');
            form.attr('action', url);

            modal.find('#strong-name').text(name);
        }
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
    FORM_CLIENT = 'clientes/novo';
    CLIENTS = 'clientes';


    pagina = window.location.href;

    if (pagina.includes(AUTO_REPAIR_SHOPS)) {
        if (pagina.includes(FORM_AUTO_REPAIR_SHOP)) {
            $(".auto-repair-shop-register").addClass("active");
        } else {
            $(".auto-repair-shop-list").addClass("active");
        }
        $(".auto-repair-shop").addClass("active");
    }

    if (pagina.includes(MAINTENANCES)) {
        if (pagina.includes(FORM_MAINTENANCE)) {
            $(".maintenance-register").addClass("active");
        } else {
            $(".maintenance-history").addClass("active");
        }
        $(".maintenance").addClass("active");
    }

    if (pagina.includes(VEHICLES)) {
        if (pagina.includes(FORM_VEHICLE)) {
            $(".vehicle-register").addClass("active");
        } else {
            $(".vehicle-list").addClass("active");
        }
        $(".vehicle").addClass("active");
    }

    if (pagina.includes(CLIENTS)) {
        if (pagina.includes(FORM_CLIENT)) {
            $(".client-register").addClass("active");
        } else {
            $(".client-list").addClass("active");
        }
        $(".client").addClass("active");
    }

}