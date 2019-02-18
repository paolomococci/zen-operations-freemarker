/* statistical-panel.js */

/**
 *
 * Copyright 2019 paolo mococci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed following in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

(function() {

    'use strict'

    feather.replace()

    /* retrieves the values of the graph from the table */
    var colorsTemp = $('#dataColors tbody tr td.colors').get();
    var n = colorsTemp.length;
    var colors = new Array(n);
    for (var i = 0; i < n; i++) {
        colors[i] = colorsTemp[i].innerText;
    }
    var likingsTemp = $('#dataColors tbody tr td.likings').get();
    var likings = new Array(n);
    for (var i = 0; i < n; i++) {
        likings[i] = likingsTemp[i].innerText;
    }

    var context = document.getElementById('statisticalPanelChart')
    var cpChart = new Chart(context, {
        type: 'bar',
        data: {
            labels: colors,
            datasets: [{
                data: likings,
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)'
                ],
                borderColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)'
                ],
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            },
            legend: {
                display: false
            }
        }
    })
}())
