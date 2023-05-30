import LinkedList.LL;

public interface MyTree<K extends Comparable<K>, T> {

    T find(K key);

    void insert(K key, T data, K parentKey);

    void delete(K key);
    int size();

    int countLeaf();

    int countCompleteElements();
    LL<K > preOrder();

    LL<K > inOrder();
    LL<K > postOrder();

}