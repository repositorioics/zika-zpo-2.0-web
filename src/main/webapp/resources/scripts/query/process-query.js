var Query = function () {

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
                    query: {
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
                    getResultQuery();
                }
            });

            function getResultQuery() {
                var iframe = document.createElement('iframe');
                iframe.id = "IFRAMEID";
                iframe.style.display = 'none';
                document.body.appendChild(iframe);
                iframe.src = parametros.queryUrl+"?query="+$("#query").val();
                iframe.addEventListener("load", function () {
                    console.log("FILE LOAD DONE.. Download should start now");
                });
            }
        }
    };

}();