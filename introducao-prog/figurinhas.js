'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', function (inputStdin) {
    inputString += inputStdin.replaceAll('\r', ''); // Remove all \r
});

process.stdin.on('end', function () {
    inputString = inputString.split('\n');

    main();
});

function readLine() {
    return inputString[currentLine++];
}

function figurinhas(qtdFigTotal, qtdFigCarimbado, qtdFigComprado, listaFigCarimbado, listaFigComprado) {
    // Remove duplicidade das figurinhas compradas
    const setFigComprado = new Set(listaFigComprado)
    let figCarimbadaRestantes = 0

    for (const numFigCarimbada of listaFigCarimbado) {
        const jaPossuiFigCarimbadaa = setFigComprado.has(numFigCarimbada)
        if (!jaPossuiFigCarimbadaa) figCarimbadaRestantes++
    }

    console.log(figCarimbadaRestantes)
}

function main() {

    const [qtdFigTotal, qtdFigCarimbado, qtdFigComprado] = readLine().replace(/\s+$/g, '').split(' ').map(arrTemp => parseInt(arrTemp, 10));
    const listaFigCarimbado = readLine().replace(/\s+$/g, '').split(' ').map(arrTemp => parseInt(arrTemp, 10));
    const listaFigComprado = readLine().replace(/\s+$/g, '').split(' ').map(arrTemp => parseInt(arrTemp, 10));

    figurinhas(qtdFigTotal, qtdFigCarimbado, qtdFigComprado, listaFigCarimbado, listaFigComprado)

}