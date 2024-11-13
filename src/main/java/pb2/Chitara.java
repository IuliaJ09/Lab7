package pb2;
enum TipChitara {
    ELECTRICA,
    ACUSTICA,
    CLASICA
}
 class Chitara extends InstrumentMuzical {
     private TipChitara tip_chitara;
     private int nr_corzi;

     public Chitara(String producator, double pret, TipChitara tip_chitara, int nr_corzi) {
         super(producator, pret);
         this.tip_chitara = tip_chitara;
         this.nr_corzi = nr_corzi;
     }
     public TipChitara getTipChitara() {
         return tip_chitara;
     }

     public int getNrCorzi() {
         return nr_corzi;
     }

     @Override
     public void canta() {
         System.out.println("Producator " + getProducator() + " ,pret: " + getPret() + " , nr.corzi: "+ nr_corzi+ ",tipul: " + tip_chitara);
     }
}
