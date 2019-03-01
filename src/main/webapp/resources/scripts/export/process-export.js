var Export = function () {
    var bloquearUI = function (mensaje) {
        var loc = window.location;
        var pathName = loc.pathname.substring(0, loc.pathname.indexOf('/', 1) + 1);
        var mess = '<img src=' + pathName + 'resources/img/ajax-loading.gif>' + mensaje;
        $.blockUI({ message: mess,
            css: {
                border: 'none',
                padding: '15px',
                backgroundColor: '#000',
                '-webkit-border-radius': '10px',
                '-moz-border-radius': '10px',
                opacity: .5,
                color: '#fff'
            },
            baseZ: 1051 // para que se muestre bien en los modales
        });
    };

    var desbloquearUI = function () {
        setTimeout($.unblockUI, 500);
    };
   return {
        //main function to initiate the module
        init: function (parametros) {

            var form1 = $('#download-form');
            var error1 = $('.alert-danger', form1);

            form1.validate({
                errorElement: 'span', //default input error message container
                errorClass: 'help-block', // default input error message class
                focusInvalid: false, // do not focus the last invalid input
                ignore: "",
                rules: {
                    codigoInicio: {required: function () {
                        return $('#codigoFin').val().length > 0;
                    }},
                    codigoFin: {required: function () {
                        return $('#codigoInicio').val().length > 0;
                    }},
                    zpform: {
                        required: true
                    },
                    zpEvent: {
                        required: true
                    }
                },
                invalidHandler: function (event, validator) { //display error alert on form submit
                    error1.show();
                    App.scrollTo(error1, -200);
                },

                highlight: function (element) { // hightlight error inputs
                    $(element)
                        .closest('.form-group').addClass('has-error'); // set error class to the control group
                },

                unhighlight: function (element) { // revert the change done by hightlight
                    $(element)
                        .closest('.form-group').removeClass('has-error'); // set error class to the control group
                },

                success: function (label) {
                    label
                        .closest('.form-group').removeClass('has-error'); // set success class to the control group
                },

                submitHandler: function (form) {
                    error1.hide();
                    getForm();
                }
            });

            function getForm() {
                bloquearUI("");
                var form = $('#zpform').find('option:selected').val();
                var urlForm = "";
                if (form == 'Zp00'){
                    urlForm = parametros.getZp00;
                }else if (form == 'Zp01AD'){
                    urlForm = parametros.getZp01AD;
                }else if (form == 'Zp01E'){
                    urlForm = parametros.getZp01E;
                }else if (form == 'Zp01FK'){
                    urlForm = parametros.getZp01FK;
                }else if (form == 'Zp02'){
                    urlForm = parametros.getZp02;
                }else if (form == 'Zp03'){
                    urlForm = parametros.getZp03;
                }else if (form == 'Zp04AD'){
                    urlForm = parametros.getZp04AD;
                }else if (form == 'Zp04E'){
                    urlForm = parametros.getZp04E;
                }else if (form == 'Zp04FH'){
                    urlForm = parametros.getZp04FH;
                }else if (form == 'Zp05'){
                    urlForm = parametros.getZp05;
                }else if (form == 'Zp06'){
                    urlForm = parametros.getZp06;
                }else if (form == 'Zp08'){
                    urlForm = parametros.getZp08;
                }else if (form == 'Zp07'){
                    urlForm = parametros.getZp07;
                }else if (form == 'Zp02d'){
                    urlForm = parametros.getZp02d;
                }else{
                    urlForm = parametros.getAll;
                }
                var iframe = document.createElement('iframe');
                iframe.id = "IFRAMEID";
                iframe.style.display = 'none';
                document.body.appendChild(iframe);
                iframe.src = urlForm+"?codigoInicio="+$("#codigoInicio").val()+"&codigoFin="+$("#codigoFin").val()+"&event="+$('#zpEvent').find('option:selected').val();
                iframe.addEventListener("load", function () {
                    console.log("FILE LOAD DONE.. Download should start now");

                });
                desbloquearUI();
            }
        }
    };

}();