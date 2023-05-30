package LinkedList;

public class LL<T extends  Comparable<T>> implements Lista<T>{

    NodeLinkedList<T> head;


    @Override
    public void add(T value) {

        NodeLinkedList<T> nuevoNodo = new NodeLinkedList<>();
        nuevoNodo.value = value;

        //si la lista esta vacia
        nuevoNodo.next = null;
        if(head == null){
            head = nuevoNodo;
        }
        //si la lista no esta vacia
        else{
            //mientras que no este parado en el ultimo sigo avanzando
            NodeLinkedList<T> tempNodeLinkedList = head;
            while (tempNodeLinkedList.next != null){
                tempNodeLinkedList = tempNodeLinkedList.next;
            }
            //una vez ya estoy en el ulimo, en el next pongo el q quiero poner
            tempNodeLinkedList.next = nuevoNodo;
        }

    }

    @Override
    public void remove(int position) {
        NodeLinkedList<T> tempNodeLinkedList = head;

        //recorro la lista y me paro en el anterior al que quiero eliminar
        for(int i = 0; i < position-1; i++){
            tempNodeLinkedList = tempNodeLinkedList.next;
        }
        //el puntero del anterior pasa a apunutar al proximo del q quiero elinimar, entonces lo pasa de largo
        tempNodeLinkedList.next = tempNodeLinkedList.next.next;

    }

    @Override
    public void get(int position) {
        NodeLinkedList<T> tempNodeLinkedList = head;

        //recorro la lista y me paro en el anterior al que quiero eliminar
        for(int i = 0; i != position; i++){
            tempNodeLinkedList = tempNodeLinkedList.next;
        }
        System.out.println("en el indice " +position+ " esta el valor " + tempNodeLinkedList.value);
    }

    @Override
    public void find(T value){
        NodeLinkedList<T> tempNodeLinkedList = head;

        if (tempNodeLinkedList.value == value) System.out.println("el valor "+value +" es el head!");

        else{
            int i = 0;
            boolean esta = false;
            while (tempNodeLinkedList.next != null){

                if (tempNodeLinkedList.value == value){
                    System.out.println("el valor " +value+ " esta en la posicion " + i);
                    esta = true;
                    break;
                }else{
                    tempNodeLinkedList = tempNodeLinkedList.next;
                    i++;
                }
            }
            if (!esta) System.out.println("el valor " + value+ " no esta! :(");


        }

    }

    @Override
    public void addFirst(T value) {
        NodeLinkedList<T> nuevoNodo = new NodeLinkedList<>();
        nuevoNodo.value = value;

        nuevoNodo.next = head;
        head = nuevoNodo;
    }

    @Override
    public void addAt(T value, int position) {
        NodeLinkedList<T> nuevoNodo = new NodeLinkedList<>();
        nuevoNodo.value = value;
        nuevoNodo.next = null;

        NodeLinkedList<T> tempNodeLinkedList = head;

        //en caso de q la poscicion sea 0
        if(position == 0){
            addFirst(value);

        }else{
            for(int i = 0; i < position-1; i++){
                tempNodeLinkedList = tempNodeLinkedList.next;
            }
            nuevoNodo.next = tempNodeLinkedList.next;
            tempNodeLinkedList.next = nuevoNodo;
        }

    }

    @Override
    public void addInOrder(T value) {
//        Node<T> tempNode = head;
//
//        Node<T> nuevoNodo = new Node<>();
//        nuevoNodo.value = value;
//
//        if (tempNode.value < nuevoNodo.value){
//            nuevoNodo.next = tempNode.next;
//            tempNode.next = nuevoNodo;
//        }
//        else{
//            while (tempNode.next != null){
//                if(tempNode.next.value < nuevoNodo.value){
//                    tempNode = tempNode.next;
//                }
//                tempNode = tempNode.next; // no se si este va, me marie, creo q no
//                nuevoNodo.next = tempNode.next;
//                tempNode.next = nuevoNodo;
//            }
//        }
    }

    @Override
    public void imprimir() {

        NodeLinkedList<T> temporaryNodeLinkedList = head;

        while (temporaryNodeLinkedList.next != null){
            System.out.print(temporaryNodeLinkedList.value + " --> ");
            temporaryNodeLinkedList = temporaryNodeLinkedList.next;
        }
        System.out.println(temporaryNodeLinkedList.value);
    }

    // -----  ------  -----  ------  -----  ------  -----  ------  -----  ------  -----  ------
    //aca arranca el main
    public static void main(String[] args) {
        LL<Integer> listita = new LL<>();



        //pruebo lo de añadir
        listita.add(1);
        listita.add(2);
        listita.add(3);
        listita.add(4);

        listita.imprimir();

        //pruebo el remove
        listita.remove(1);

        //pruebo el get
        listita.get(2);

        //pruebo el addFirst
        listita.addFirst(7);
        System.out.println();

        //pruebo el addAt
        listita.addAt(0, 0);
        System.out.println();
        listita.imprimir();
        //pruebo el esta
        listita.find(0);
        listita.find(7);
        listita.find(4);
        listita.find(45);


        // -----  ------  -----  ------  -----  ------  -----  ------  -----  ------  -----  ------
        // voy a intentar lo de insertar ordenadamente


    }
}





