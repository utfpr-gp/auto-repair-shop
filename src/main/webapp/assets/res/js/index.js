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
    
});


function getCurrentYear(){
    return new Date().getFullYear();
}

function efeitoMenu() {
    CAD_VEHICLE = 'veiculos/novo';
    LIS_VEHICLE = 'veiculos';
    LIS_MY_VEHICLE = 'veiculos/meus';

    pagina = window.location.href;
    if (pagina.includes(LIS_VEHICLE)) {
        if (pagina.includes(CAD_VEHICLE)) {
            $(".vehicle-register").addClass("active");
        } else if (pagina.includes(LIS_MY_VEHICLE)) {
            $(".vehicle-client-list").addClass("active");
        } else {
            $(".vehicle-list").addClass("active");
        }
        $(".vehicle").addClass("active");
    }

}