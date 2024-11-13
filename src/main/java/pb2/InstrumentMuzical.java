package pb2;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
abstract class InstrumentMuzical {
    private String producator;
    private double pret;

    public InstrumentMuzical(String producator, double pret) {
        this.producator = producator;
        this.pret = pret;
    }

    public String getProducator() {
        return producator;
    }

    public double getPret() {
        return pret;
    }
    public abstract void canta();
}
