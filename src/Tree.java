import LinkedList.LL;

public class Tree<K extends Comparable<K>, T> implements MyTree<K, T> {
    private Node<K, T> root;

    @Override
    public T find(K key) {
        return find(root, key);
    }


    private T find(Node<K, T> node, K key) {



        //si el root es null devuelvo nulo
        if (node == null) return null;

        //para ver donde ando
//        System.out.println(node.key);

        // si la key del nodo en el q estoy es la q quiero, devuelvo la data
        if(node.key.equals(key)) return node.data;

        // sino hago lo mismo en el hijo izq
        T left = find(node.leftChild, key);

        //mientras q tenga hijos hago lo mismo
        if(left != null) return left;

        //si no tiene mas hijos, la funcion se termina en el stack y voy a la derecha
        return find(node.rightChild, key);

    }

    @Override
    public void insert(K key, T data, K parentKey) {
        if (root == null){
            if (parentKey != null){
                System.out.println("no tenes root :/, el primero q insertes tiene q ser pk null");
            }
            root = new Node<>(key, data); // creas el root
        }else{
            //aca tengo el nodo padre de los hijos q voy a insertar
            Node<K, T> nodoPadre = findNode(root,parentKey);

            if (nodoPadre.leftChild == null){
                nodoPadre.leftChild = new Node<>(key, data); // si no tiene hijo izq, lo inserto ahi
            } else if (nodoPadre.rightChild == null) {
                nodoPadre.rightChild = new Node<>(key,data); // si no tiene hijo der, lo inserto aho
            }else System.out.println("el nodo ya tiene dos hijos");


        }

    }

    //hay q implementar una funcion q devuelva el nodo en vez de data, igual al find
    private Node<K, T> findNode(Node<K, T>node, K key){
        if (node == null) return null;

        if (node.key.equals(key)) return node; // devuelve el nodo

        Node<K, T> left = findNode(node.leftChild, key);

        if (left != null) return left;

        return findNode(node.rightChild,key);
    }

    @Override
    public void delete(K key) {
        //si el arbol esta vacio
        if (root == null) System.out.println("el arbol esta vacio");

        //si quiero borrar todo el arbol
        if(root.key.equals(key)) root = null;
        else delete(root,key);

    }

    private void delete(Node<K, T> node, K key){
        //si el hijo izq del nodo en el q estoy es el q quiero, lo hago null
        if (node.leftChild != null && node.leftChild.key.equals(key)) node.leftChild = null;

        //lo mismo para el derecho
        else if (node.rightChild != null && node.rightChild.key.equals(key)) node.rightChild = null;

        //si no es ninguno de esos, aplico recursion
        else{
            delete(node.leftChild,key);
            delete(node.rightChild,key);
        }

    }

    @Override
    public int size() {
        return size(root);
    }


    private int size(Node<K, T> node){
        if (node == null) return 0;

        //sumo uno cada vez q pase por un nodo y aplico recursion
        return 1 + size(node.leftChild) + size(node.rightChild);
    }


    @Override
    public int countLeaf() {
        return countLeaf(root);
    }

    private int countLeaf(Node<K, T>node){
        if (node == null) return 0;

        //si los hijos del nodo en el q estoy son nulos, sumo uno
        if (node.leftChild == null && node.rightChild == null) return 1;


        return countLeaf(node.leftChild) + countLeaf(node.rightChild);
    }

    @Override
    public int countCompleteElements() {
        return countCompleteElements(root);
    }

    private int countCompleteElements(Node<K, T>node){
        if (node == null) return 0;

        if(node.leftChild == null || node.rightChild == null) return 0 ;

        return 1 + countCompleteElements(node.leftChild) + countCompleteElements(node.rightChild);
    }

    // -----  -----  -----  preOrder  -----  -----  -----  -----
    @Override
    public LL<K> preOrder() {
        return preOrder(root);
    }
    LL<K> arbolPreOrder = new LL<>();

    private LL<K> preOrder(Node<K,T> node){
        if (node==null) return null;

        arbolPreOrder.add(node.key);

        preOrder(node.leftChild);
        preOrder(node.rightChild);
        return arbolPreOrder;
    }

    // -----  -----  -----  inOrder  -----  -----  -----  -----

    @Override
    public LL<K> inOrder() {
        return inOrder(root);
    }
    LL<K> arbolInOrder = new LL<>();

    private LL<K> inOrder(Node<K,T> node){
        if (node==null) return null;


        preOrder(node.leftChild);

        arbolInOrder.add(node.key);

        preOrder(node.rightChild);
        return arbolInOrder;
    }

    // -----  -----  -----  postOrder  -----  -----  -----  -----


    @Override
    public LL<K> postOrder() {
        return postOrder(root);
    }

    LL<K> arbolPostOrder = new LL<>();

    private LL<K> postOrder(Node<K,T> node){
        if (node==null) return null;

        preOrder(node.leftChild);
        preOrder(node.rightChild);

        arbolPostOrder.add(node.key);

        return arbolPostOrder;
    }
}
