import java.util.NoSuchElementException;

public class Lista<T> {
    private Nodo<T> head;

    public Nodo<T> getHead() {
        return this.head;
    }

    public void setHead(Nodo<T> head) {
        this.head = head;
    }

    public Lista() {
        this.head = null;
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    public void aggiungiTesta(T valore) {
        Nodo<T> nuovoNodo = new Nodo<>(valore);
        nuovoNodo.setNext(head);
        head = nuovoNodo;
    }

    public void aggiungiCoda(T valore) {
        Nodo<T> nuovoNodo = new Nodo<>(valore);
        if (isEmpty()) {
            head = nuovoNodo;
            return;
        }
        Nodo<T> corrente = head;
        while (corrente.getNext() != null) {
            corrente = corrente.getNext();
        }
        corrente.setNext(nuovoNodo);
    }

    public void aggiungiPosizione(T valore, int posizione){
        if (posizione == 0) {
            aggiungiCoda(valore);
            return;
        }

        if (posizione < 0) {
            throw new IndexOutOfBoundsException("Posizione sotto zero");
        }

        Nodo<T> corrente = head;
        int contPos = 0;
        while (corrente.getNext() != null && contPos < posizione - 1) {
            corrente = corrente.getNext();
            ++contPos;
        }

        if (contPos < posizione) {
            throw new IndexOutOfBoundsException("Posizione non valida");
        }
        Nodo<T> nuovoNodo = new Nodo<>(valore);
        nuovoNodo.setNext(corrente.getNext());
        corrente.setNext(nuovoNodo);

    }

    public T leggiTesta() {
        if (head == null) {
            throw new NoSuchElementException("Lista vuota");
        }
        return head.getValore();
    }

}