
public abstract class SegitigaAbstrak {
    private int sisi1, sisi2, sisi3;
    public SegitigaAbstrak(){}
    public SegitigaAbstrak(int sisi1, int sisi2, int sisi3){
        this.sisi1 = sisi1;
        this.sisi2 = sisi2;
        this.sisi3 = sisi3;
    }
    public int getSisi1() { return sisi1; }
    public int getSisi2() { return sisi2; }
    public int getSisi3() { return sisi3; }
    public void setSisi1(int sisi1){ this.sisi1 = sisi1; }
    public void setSisi2(int sisi2){ this.sisi2 = sisi2; }
    public void setSisi3(int sisi3){ this.sisi3 = sisi3; }
    abstract boolean isSegitigaSamaSisi();
    abstract boolean isSegitiaSamaKaki();
    abstract boolean isSegitiaSikuSiku();
    public String getJenisSegigita(){
        if (isSegitiaSamaKaki()){
            return "Segitiga adalah Segitiga Sama Kaki";
        } else if (isSegitigaSamaSisi()){
            return "Segitiga adalah Segitiga Sama Sisi";
        } else if (isSegitiaSikuSiku()){
            return "Segitiga adalah Segitiga Siku-siku";
        } else {
            return "Segitiga adalah Segitiga sembarang";
        }
    }

}
