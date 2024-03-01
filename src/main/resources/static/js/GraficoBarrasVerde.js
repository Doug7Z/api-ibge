function criarGraficoBarrasVerde(dados, idCanvas, label) {
    // Extrair os anos e os valores dos dados
    var anos = dados.map(function(dado) {
        return dado.ano;
    });

    var valores = dados.map(function(dado) {
        return dado.valor;
    });

    var ctx = document.getElementById(idCanvas).getContext('2d');
    var graficoBarras = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: anos,
            datasets: [{
                label: label,
                data: valores,
                backgroundColor: 'rgba(75, 192, 192, 0.5)', 
                borderColor: 'rgba(75, 192, 192, 1)', 
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
}