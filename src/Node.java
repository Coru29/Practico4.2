public class Node<K, T> {
    K key;
    T data;
    Node<K, T> leftChild;
    Node<K, T> rightChild;

    Node(K key, T data) {
        this.key = key;
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }
}
