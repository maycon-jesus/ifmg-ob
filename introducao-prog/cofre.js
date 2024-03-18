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

function figurinhas(qtdPosicoes, qtdMovimentos, caracteresBarra, movimentosControle) {
    let posicaoControle = 0
    const numerosApareceram = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

    for (const novaPosicaoControle of movimentosControle) {
        const movimentoSeletorDireita = posicaoControle < novaPosicaoControle

        // Ajuste na posição do seletor quando é para ir para a esquerda para não duplicar numero em que o seletor ja estava
        if(!movimentoSeletorDireita) posicaoControle--

        const startEndMovimento = [posicaoControle, novaPosicaoControle+(movimentoSeletorDireita? 0:-1)]
        startEndMovimento.sort((a,b)=>a-b) // ordem crescente
        
        const numerosPassadosPeloSeletor = caracteresBarra.slice(startEndMovimento[0], startEndMovimento[1])
        
        for(const numero of numerosPassadosPeloSeletor){
            numerosApareceram[numero]++
        }

        posicaoControle=novaPosicaoControle
    }

    console.log(numerosApareceram.join(' '))
}

function main() {

    const [qtdPosicoes, qtdMovimentos] = readLine().replace(/\s+$/g, '').split(' ').map(arrTemp => parseInt(arrTemp, 10));
    const caracteresBarra = readLine().replace(/\s+$/g, '').split(' ').map(arrTemp => parseInt(arrTemp, 10));
    const movimentosControle = readLine().replace(/\s+$/g, '').split(' ').map(arrTemp => parseInt(arrTemp, 10));

    figurinhas(qtdPosicoes, qtdMovimentos, caracteresBarra, movimentosControle)

}