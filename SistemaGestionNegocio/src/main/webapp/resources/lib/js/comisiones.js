window.onload = function () {
    // obtenemos el id distribuidor
    let idDistribuidor = $('#idDistribuidor').val();

    let data = {
        idDistribuidor: idDistribuidor
    };

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: 'POST',
        url: 'obtenerComisiones',
        data: JSON.stringify(data)
    }).done(function (response) {
        let listaVentas = response.listaVentas;
        let labels = [];
        let data = [];
        let backgroundColor = [];
        let borderColor = [];
        
        listaVentas.forEach(function (historico) {
            labels.push(historico.nombreDistribuidor);
            data.push(historico.ventasSoles);
            backgroundColor.push('rgba(255, 99, 132, 0.2)');
            borderColor.push('rgba(255,99,132,1)');
        });

        let canvas = $('#cuadroComisiones');
        let cuadroComisiones = new Chart(canvas, {
            type: 'bar',
            data: {
                labels: labels,
                datasets: [{
                    label: 'Ventas en Soles',
                    data: data,
                    backgroundColor: backgroundColor,
                    borderColor: borderColor,
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
                }
            }
        });
    });
}