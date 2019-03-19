var Diary = function () {
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

            var form1 = $('#diary-form');
            var error1 = $('.alert-danger', form1);

            form1.validate({
                errorElement: 'span', //default input error message container
                errorClass: 'help-block', // default input error message class
                focusInvalid: false, // do not focus the last invalid input
                ignore: "",
                rules: {
                    diarydate: {
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
                    getDiary();
                }
            });

            var table = $('#lista_registros').dataTable({
                "oLanguage": {
                    "sUrl": parametros.dataTablesLang
                }
            });

            function getDiary() {
                bloquearUI("");
                $.getJSON(parametros.diaryUrl, {
                    ajax: 'true',
                    fecha: $("#diarydate").val()
                }, function (dataToLoad) {
                    table.fnClearTable();
                    var len = Object.keys(dataToLoad).length;
                    for (var i = 0; i < len; i++) {
                        table.fnAddData(
                            [dataToLoad[i].codigo, dataToLoad[i].fechaIngreso, dataToLoad[i].formulario,dataToLoad[i].fechaProgramacionCita, dataToLoad[i].evento, dataToLoad[i].fechaProgramada,dataToLoad[i].fechaCita,dataToLoad[i].horaCita]);
                    }
                    desbloquearUI()
                }).fail(function(jqXHR) {
                    desbloquearUI();
                });
            }
        }
    };

}();