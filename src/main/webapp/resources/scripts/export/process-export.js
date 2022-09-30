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
                }else if (form == 'ZpoV2CuestDemo'){
                    urlForm = parametros.getZpoV2CuestDemo;
                }else if (form == 'ZpoV2CuestDemoUpd'){
                    urlForm = parametros.getZpoV2CuestDemoUpd;
                }else if (form == 'ZpoV2StudyExit'){
                    urlForm = parametros.getZpoV2StudyExit;
                }else if (form == 'ZpoV2CuestSocio'){
                    urlForm = parametros.getZpoV2CuestSocio;
                }else if (form == 'ZpoV2CuestSaludInfantil'){
                    urlForm = parametros.getZpoV2CuestSaludInfantil;
                }else if (form == 'ZpoV2CuestSaludInfantilUpd'){
                    urlForm = parametros.getZpoV2CuestSaludInfantilUpd;
                }else if (form == 'ZpoV2ExamFisInf'){
                    urlForm = parametros.getZpoV2ExamFisInf;
                }else if (form == 'ZpoV2CuestSaludMaterna'){
                    urlForm = parametros.getZpoV2CuestSaludMaterna;
                }else if (form == 'ZpoV2CuestSaludMaternaUpd'){
                    urlForm = parametros.getZpoV2CuestSaludMaternaUpd;
                }else if (form == 'ZpoV2IndCuidadoFamilia'){
                    urlForm = parametros.getZpoV2IndCuidadoFamilia;
                }else if (form == 'ZpoBiospColl'){
                    urlForm = parametros.getZpoBiospColl;
                }else if (form == 'ZpoV2Mullen'){
                    urlForm = parametros.getZpoV2Mullen;
                }else if (form == 'ZpoV2EvalVisual'){
                    urlForm = parametros.getZpoV2EvalVisual;
                }else if (form == 'ZpoV2EvalAuditiva'){
                    urlForm = parametros.getZpoV2EvalAuditiva;
                }else if (form == 'ZpoV2EvalPsico'){
                    urlForm = parametros.getZpoV2EvalPsico;
                }else if (form == 'ZpoV2EdadesEtapas42'){
                        urlForm = parametros.getZpoV2EdadesEtapas42;
                }else if (form == 'ZpoV2EdadesEtapas54'){
                        urlForm = parametros.getZpoV2EdadesEtapas54;
                }else if (form == 'ZpoV2EdadesEtapas66'){
                    urlForm = parametros.getZpoV2EdadesEtapas66;
                }else if (form == 'ZpoV2BiosColl'){
                        urlForm = parametros.getZpoV2BiosColl;
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