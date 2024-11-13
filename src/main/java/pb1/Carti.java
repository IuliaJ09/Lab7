package pb1;

public record Carti(String titlul, String autorul, int anul) {
    public Carti(String titlul, String autorul, int anul) {
        this.titlul = titlul;
        this.autorul = autorul;
        this.anul = anul;
    }

    public String getTitlul() {
        return this.titlul;
    }

    public String getAutorul() {
        return this.autorul;
    }

    public int getAnul() {
        return this.anul;
    }
}
