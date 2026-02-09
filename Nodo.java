public class Nodo<T> {

    private T valore;
    private Nodo<T> next;

    public T getValore() {
        return this.valore;
    }

    public void setValore(T valore) {
        this.valore = valore;
    }

    public Nodo<T> getNext() {
        return this.next;
    }

    public void setNext(Nodo<T> next) {
        this.next = next;
    }

    public Nodo(T valore) {
        this.valore = valore;
        this.next = null;
    }
    
}