$( document ).ready(function teste() {

       // Definições de Máscaras
       $(".mascara-cpf").mask("999.999.999-99");


       $('.mascara-telefone').focusout(function(){
        var phone, element;
        element = $(this);
        element.unmask();
        phone = element.val().replace(/\D/g, '');
        if(phone.length > 10) {
            element.mask("(99)99999-999?9");
        } else {
            element.mask("(99)9999-9999?9");
        }
    });
    }