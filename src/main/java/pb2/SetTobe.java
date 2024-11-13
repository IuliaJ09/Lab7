package pb2;
enum TipTobe {
    ELECTRONICE,
    ACUSTICE
}
 class SetTobe extends InstrumentMuzical {
     private TipTobe tip_tobe;
     private int nr_tobe;
     private int nr_cinele;

     public SetTobe(String producator, double pret, TipTobe tip_tobe, int nr_tobe, int nr_cinele) {
         super(producator, pret);
         this.tip_tobe = tip_tobe;
         this.nr_tobe = nr_tobe;
         this.nr_cinele = nr_cinele;
     }

     public TipTobe getTipTobe() {
         return tip_tobe;
     }

     public int getNrTobe() {
         return nr_tobe;
     }

     public int getNrCinele() {
         return nr_cinele;
     }

     @Override
     public void canta(){
         System.out.println("Producator " + getProducator() + " ,pret: " + getPret() +"'Tipt tobe"+ tip_tobe+",numar tobe: "+nr_tobe+",numar cinele: "+nr_cinele);
     }

}
