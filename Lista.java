
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
        return head == null;
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
        Nodo<T> curr = head;
        while (curr.getNext() != null) {
            curr = curr.getNext();
        }
        curr.setNext(nuovoNodo);
    }

    public void aggiungipos(T valore, int pos) {
        if (pos == 0) {
            aggiungiCoda(valore);
            return;
        }

        if (pos < 0) {
            throw new IndexOutOfBoundsException("pos sotto zero");
        }

        Nodo<T> curr = head;
        int contPos = 0;
        while (curr != null && contPos < pos - 1) {
            curr = curr.getNext();
            ++contPos;
        }

        if (curr == null) {
            throw new IndexOutOfBoundsException("pos non valida");
        }
        Nodo<T> nuovoNodo = new Nodo<>(valore);
        nuovoNodo.setNext(curr.getNext());
        curr.setNext(nuovoNodo);

    }

    public T leggiTesta() {
        if (head == null) {
            throw new NoSuchElementException("Lista vuota");
        }
        return head.getValore();
    }

    public T leggiCoda() {
        if (head == null) {
            throw new NoSuchElementException("Lista vuota");
        }

        Nodo<T> curr = head;

        while (curr.getNext() != null) {
            curr.setNext(curr.getNext());
        }

        return curr.getValore();
    }

    public T leggiInpos(int pos) {
        if (pos < 0) {
            throw new IndexOutOfBoundsException("pos negativa");
        }

        Nodo<T> curr = head;
        int i = 0;

        while (curr != null && i < pos) {
            curr = curr.getNext();
            i++;
        }

        if (curr == null) {
            throw new IndexOutOfBoundsException("pos oltre la fine della lista");
        }

        return curr.getValore();
    }

    public int size() {
        int cont = 0;
        Nodo<T> curr = head;

        while (curr != null) {
            ++cont;
            curr = curr.getNext();
        }

        return cont;
    }

    public int indexOf(int pos) {
        if (pos < 0) {
            throw new IndexOutOfBoundsException("pos negativa");
        }
        Nodo<T> curr = head;
        int cont = 0;
        while (curr != null && cont < pos) {
            ++cont;
            curr = curr.getNext();
        }

        if (curr == null) {
            throw new IndexOutOfBoundsException("pos non valida");
        }
        return cont;
    }

    public boolean contiene(int elemento) {
        Nodo<T> curr = head;
        while (curr != null) {
            if (curr.getValore().equals(elemento)) {
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }

    public boolean cancella(T dato) {
        if (head == null) {
            return false;
        }

        if (head.getValore().equals(dato)) {
            head = head.getNext();
            return true;
        }

        Nodo<T> precedente = head;
        Nodo<T> curr = head.getNext();

        while (curr != null) {
            if (curr.getValore().equals(dato)) {
                precedente.setNext(curr.getNext());
                return true;
            }
            precedente = curr;
            curr = curr.getNext();
        }

        return false;
    }

    public T cancellaInpos(int pos) {
        if (pos < 0 || head == null) {
            throw new IndexOutOfBoundsException("pos non valida");
        }

        if (pos == 0) {
            T dato = head.getValore();
            head = head.getNext();
            return dato;
        }

        Nodo<T> precedente = head;
        int i = 0;

        while (precedente.getNext() != null && i < pos - 1) {
            precedente = precedente.getNext();
            i++;
        }

        if (precedente.getNext() == null) {
            throw new IndexOutOfBoundsException("pos oltre la fine della lista");
        }

        T dato = precedente.getNext().getValore();
        precedente.setNext(precedente.getNext().getNext());
        return dato;
    }
}
