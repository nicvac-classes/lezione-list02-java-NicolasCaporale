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
        while (corrente != null && contPos < posizione - 1) {
            corrente = corrente.getNext();
            ++contPos;
        }

        if (corrente == null) {
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

    public T leggiCoda() {
        if(head == null) {
            throw new NoSuchElementException("Lista vuota");   
        }

        Nodo<T> curr = head;

        while (curr.getNext() != null)
        {
            curr.setNext(curr.getNext());
        }

        return curr.getValore();
    }
    public T leggiPosizione(int pos) {
        if (head == null) {
            throw new NoSuchElementException("lista piena");
        }
        Nodo<T> curr = head;
        while (corrente != null && contPos < posizione){
            curr = head.next
        }
        return curr.getDato();
    }

    public T leggiInPosizione(int posizione) {
        if (posizione < 0) {
            throw new IndexOutOfBoundsException("Posizione negativa");
        }
        
        Nodo<T> corrente = head;
        int i = 0;
        
        while (corrente != null && i < posizione) {
            corrente = corrente.getNext();
            i++;
        }
        
        if (corrente == null) {
            throw new IndexOutOfBoundsException("Posizione oltre la fine della lista");
        }
        
        return corrente.getValore();
    }

    public int size()
    {
        int cont = 0;
        Nodo<T> curr = head;

        while(curr != null)
        {
            ++cont;
            curr = curr.getNext();
        }

        return cont;
    }

    public int indexOf(int pos)
    {
        if(pos < 0)
        {
            throw new IndexOutOfBoundsException("posizione negativa");
        }
        Nodo<T> curr = head;
        int cont = 0;
        while(curr != null && cont < pos)
        {
            ++cont;
            curr = curr.getNext();
        }
        
        if(curr == null)
        {
            throw new IndexOutOfBoundsException("Posizione non valida");
        }
        return cont;
    }


    public boolean contiene(int elemento)
    {
        Nodo<T> curr = head;
        while(curr != null)
        {
            if(curr.getValore().equals(elemento))
            {
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }
}