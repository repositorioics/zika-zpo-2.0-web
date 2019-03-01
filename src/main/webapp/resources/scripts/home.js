var Index = function () {


    return {

        //main function
        init: function () {
        	
        },
        
        initCharts: function (parametrosChart) {
        	var pageContent = $('.page-content');
        	App.blockUI(pageContent, false);
            if (!jQuery.plot) {
                return;
            }
            if ($('#site_statistics').size() != 0) {

                $('#site_statistics_loading').hide();
                $('#site_statistics_content').show();

    			plot = $.plot("#site_statistics", [{
                    data: parametrosChart.totales,
                    label: parametrosChart.total+'-('+parametrosChart.sumTotal+')'
                }, {
    				data : parametrosChart.cs1,
    				label : 'CSSFV-('+parametrosChart.sumCs1+')'
    			}, {
                    data: parametrosChart.cs2,
                    label: 'CSFB-('+parametrosChart.sumCs2+')'
                }, {
                    data: parametrosChart.cs3,
                    label: 'CSVL-('+parametrosChart.sumCs3+')'
                }, {
                    data: parametrosChart.cs4,
                    label: 'CSEL-('+parametrosChart.sumCs4+')'
                }], {
    				series : {
    					lines : {
    						show : true,
    						fill : true,
    						fillColor: {
                                colors: [{
                                        opacity: 0.05
                                    }, {
                                        opacity: 0.01
                                    }
                                ]
                            }
    					},
    					points: {
                            show: true
                        },
                        shadowSize: 2
    				},
    				grid : {
    					hoverable: true,
                        clickable: true,
                        tickColor: "#eee",
                        borderWidth: 0
    				},
    				xaxis : {
    					mode : "categories",
    					ticks: 11,
                        tickDecimals: 0
    				},
    				yaxis: {
                        ticks: 11,
                        tickDecimals: 0
                    },
    				colors: ["#d12610", "#37b7f3", "#52e136","#e1ad36"]
    			});
    	
    			$('<div id="tooltip" class="chart-tooltip"><\/div>').css({
                    position: 'absolute',
                    display: 'none',
                    border: '0px solid #ccc',
                    padding: '2px 6px',
                    'background-color': '#fff',
                }).appendTo("body").fadeIn(200);
    	
    			$("#site_statistics").bind("plothover",
    					function(event, pos, item) {
    	
    						/*if ($("#enableTooltip:checked").length > 0) {*/
    						if (item) {
    							var x = item.datapoint[0], y = item.datapoint[1];
    							$("#tooltip").html(
    									'<div class="date">'+parametrosChart.fechas[x]+'</div>'+
    									'<div class="label label-warning">'+y+'</div>')
    									.css({
    								top : item.pageY + 5,
    								left : item.pageX + 5
    							}).fadeIn(200);
    						} else {
    							$("#tooltip").hide();
    						}
    						/*}*/
    					});
    		
    		}
            App.unblockUI(pageContent);
    	},
        
        initDashboardDaterange: function (parametrosDateRange) {
        	var table1 = $('#tamizajes_dia').dataTable( {
                "oLanguage": {
        			"sUrl": parametrosDateRange.lenguaje
                },
                "aoColumns" : [null,{sClass: "aw-right" },{sClass: "aw-right" },{sClass: "aw-right" }],bFilter: false, bInfo: true, bPaginate: true,
                "aLengthMenu": [[5, 10, 15, 20, -1],[5, 10, 15, 20, "Todos"]], iDisplayLength: 5});
        	
        	var tt = new $.fn.dataTable.TableTools( table1, {
            	"sSwfPath": parametrosDateRange.dataTablesTTSWF,
            	"aButtons": [
            	                {
            	                    "sExtends":    "collection",
            	                    "sButtonText": parametrosDateRange.exportar,
            	                    "aButtons": [
            	                                 {
            	                                     "sExtends": "csv",
            	                                     "oSelectorOpts": { filter: 'applied', order: 'current' },
            	                                     "mColumns": [ 0, 1, 2, 3]
            	                                 },
            	                                 {
            	                                     "sExtends": "pdf",
            	                                     "oSelectorOpts": { filter: 'applied', order: 'current' },
            	                                     "mColumns": [ 0, 1, 2, 3],
            	                                     "sPdfOrientation": "landscape",
            	                                 }
            	                                 ]
            	                }
            	            ]
            } );
        	
        	$( tt.fnContainer() ).insertBefore('div.table-toolbar1');
        	jQuery('#tamizajes_dia_wrapper .dataTables_length select').addClass("form-control input-small"); // modify table per page dropdown
        	
            $('#dashboard-report-range').daterangepicker({
                opens: (App.isRTL() ? 'right' : 'left'),
                startDate: moment().subtract('days', 29),
                endDate: moment(),
                minDate: '01/11/2016',
                maxDate: moment(),
                dateLimit: {
                    days: 365
                },
                showDropdowns: true,
                showWeekNumbers: false,
                timePicker: false,
                timePickerIncrement: 1,
                timePicker12Hour: true,
                buttonClasses: ['btn'],
                applyClass: 'btn-success',
                cancelClass: 'btn-default',
                format: 'DD/MM/YYYY',
                separator: ' - ',
                locale: {
                    applyLabel: parametrosDateRange.applyLabel,
                    fromLabel: parametrosDateRange.fromLabel,
                    toLabel: parametrosDateRange.toLabel,
                    customRangeLabel: parametrosDateRange.customRangeLabel,
                    daysOfWeek: [parametrosDateRange.Su, parametrosDateRange.Mo, parametrosDateRange.Tu, parametrosDateRange.We, parametrosDateRange.Th, parametrosDateRange.Fr, parametrosDateRange.Sa],
                    monthNames: [parametrosDateRange.january, parametrosDateRange.february, parametrosDateRange.march, parametrosDateRange.april, parametrosDateRange.may,
                                 parametrosDateRange.june, parametrosDateRange.july, parametrosDateRange.august, parametrosDateRange.september, parametrosDateRange.october, parametrosDateRange.november, parametrosDateRange.december],
                    firstDay: 1
                }
            },
            function (start, end) {
                console.log("Callback has been called!"+start+end);
                $('#dashboard-report-range span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
                getTable(start.format("YYYY-MM-DD"), end.format("YYYY-MM-DD"));
                
            }
            );
            
            $('#dashboard-report-range span').html(moment().subtract('days', 29).format('MMMM D, YYYY') + ' - ' + moment().format('MMMM D, YYYY'));
            $('#dashboard-report-range').show();
            
            function getTable(start, end) {
            	var pageContent = $('.page-content');
            	App.blockUI(pageContent, false);
        		$.getJSON(parametrosDateRange.dashUrl, {
        			start : start,
        			end : end,
    				ajax : 'true'
    			},function(data) {
    				table1.fnClearTable();
    				var totales = []; var cs1 = [];var cs2 = [];var fechas = [];var sumTotal = 0;var sumCs1 = 0;var sumCs2 = 0;
    				for (var row in data.lista1) {
        				var d = new Date(data.lista1[row][0]);
    					table1.fnAddData(
    							[d.yyyymmdd(), data.lista1[row][1], data.lista1[row][2], data.lista1[row][3]]);
    					fechas.push([d.yyyymmdd()]);
    					totales.push([d.yyyymmdd(), data.lista1[row][1]]);
    					sumTotal = sumTotal + parseInt(data.lista1[row][1]);
    					cs1.push([d.yyyymmdd(), data.lista1[row][2]]);
    					sumCs1 = sumCs1 + parseInt(data.lista1[row][2]);
    					cs2.push([d.yyyymmdd(), data.lista1[row][3]]);
    					sumCs2 = sumCs2 + parseInt(data.lista1[row][3]);
        			}
    				nParametrosChart = {fechas: fechas,totales: totales, cs1: cs1, cs2: cs2,
    						 sumTotal: sumTotal, sumCs1: sumCs1, sumCs2: sumCs2, total: parametrosDateRange.total};
        			Index.initCharts(nParametrosChart);
    				App.unblockUI(pageContent);
    				
        		}).fail(function() {
				    alert( "error" );
				    App.unblockUI(pageContent);
				});
        	} 
            
            
            Date.prototype.yyyymmdd = function() {         
		        
		        var yyyy = this.getFullYear().toString();                                    
		        var mm = (this.getMonth()+1).toString(); // getMonth() is zero-based         
		        var dd  = this.getDate().toString();             
		                            
		        return yyyy + '-' + (mm[1]?mm:"0"+mm[0]) + '-' + (dd[1]?dd:"0"+dd[0]);
		    }; 
        }
    };

}();