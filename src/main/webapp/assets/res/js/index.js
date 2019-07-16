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
        format: 'dd/mm/yyyy'
    });
    $("#date").datepicker({
        format: 'dd/mm/yyyy'
    });
    $(".currency").maskMoney({allowNegative: true, thousands:'.', decimal:',', affixesStay: false});
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
    VEHICLES_CLIENT = 'veiculos/cliente';
    FORM_CLIENT = 'clientes/novo';
    CLIENTS = 'clientes';
    FORM_EMPLOYEE = 'funcionarios/novo';
    EMPLOYEERS = 'funcionarios';


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
        } else if (pagina.includes(VEHICLES_CLIENT)){
            $(".vehicle-client-list").addClass("active");
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

    if (pagina.includes(EMPLOYEERS)) {
        if (pagina.includes(FORM_EMPLOYEE)) {
            $(".employee-register").addClass("active");
        } else {
            $(".employee-list").addClass("active");
        }
        $(".employee").addClass("active");
    }

}