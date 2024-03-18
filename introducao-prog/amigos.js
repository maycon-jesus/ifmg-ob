'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', function(inputStdin) {
    inputString += inputStdin.replaceAll('\r', ''); // Remove all \r
});

process.stdin.on('end', function() {
    inputString = inputString.split('\n');

    main();
});

function readLine() {
    return inputString[currentLine++];
}

function amigos([qtdPredios], prediosAndares) {
    let maiorCaminho = 0

    for(let numeroPredioA =1; numeroPredioA<=qtdPredios; numeroPredioA++){
        const predioA = prediosAndares[numeroPredioA-1]

        for(let numeroPredioB =1; numeroPredioB<=qtdPredios; numeroPredioB++){
            const predioB = prediosAndares[numeroPredioB-1]
    
            const distanciasTerreo = Math.abs(numeroPredioA-numeroPredioB)
            const distancia = predioA+predioB+distanciasTerreo

            if(distancia>maiorCaminho) {
                maiorCaminho=distancia
            }
        }
    }

    console.log(maiorCaminho)
}

function main() {

    const qtdPredios = readLine().replace(/\s+$/g, '').split(' ').map(arrTemp => parseInt(arrTemp, 10));
    const prediosAndares = readLine().replace(/\s+$/g, '').split(' ').map(arrTemp => parseInt(arrTemp, 10));
    
    amigos(qtdPredios, prediosAndares)
    
}