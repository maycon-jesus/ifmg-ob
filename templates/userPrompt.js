function readLine(){
    return new Promise((resolve)=>{
        process.stdin.once('data',(data)=>{
            resolve(data.toString())
        })
    })
}

async function promptUser(question){
    process.stdout.write(question)
    const leitura = await readLine()
    return leitura
}

async function main(){
    
}

main()
.catch(console.error)
.finally(()=> process.exit(0))