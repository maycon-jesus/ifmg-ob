type valueT = String
type itemT = {
    right?: itemT,
    left?: itemT,
    value: valueT
}

let list:itemT|null = null

class NodeC {
    constructor(public left: NodeC|null,public right: NodeC|null, public value: string) {
    }
}

class DoubleLinkedList {
    size: number = 0
    firstNode: null|NodeC = null

    isEmpty(){
        return !this.firstNode
    }

    push(val:string){
        if(this.isEmpty()){
            this.firstNode = new NodeC(null,null, val)
        }else{
            const firstNode = this.firstNode as NodeC
            const newNode = new NodeC(null,firstNode, val)
            this.firstNode=newNode
        }
    }
}

const lista = new DoubleLinkedList()
lista.push('1')
lista.push('2')
lista.push('3')
lista.push('4')
lista.push('5')
lista.push('6')
lista.push('7')

let actual = lista.firstNode
if(actual){
    while(actual){
        console.log(actual.value)
        actual=actual.right
    }
}