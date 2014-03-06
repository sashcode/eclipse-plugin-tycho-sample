package samplegroovy

class Numero {

    private int no;

    private Numero(int no) {
        this.no = no;
    }

    static Numero createNumero(int no) {
        return new Numero(no);
    }

    Numero add(Numero x) {
        return new Numero(no + x.no);
    }

    int toInt() {
        return no;
    }

    @Override
    String toString() {
        return Integer.toString(no);
    }
}
