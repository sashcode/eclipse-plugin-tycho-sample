package sample.handlers;

public class Numero {

    private int no;

    private Numero(int no) {
        this.no = no;
    }

    public static Numero createNumero(int no) {
        return new Numero(no);
    }

    public Numero add(Numero x) {
        return new Numero(no + x.no);
    }

    public int toInt() {
        return no;
    }

    @Override
    public String toString() {
        return Integer.toString(no);
    }
}
