public class TestaData {
    public static void main(String[] args) {
        Data d1 = new Data(10, 7, 2024);
          
        System.out.println("Data: " + d1.mostra1());
        System.out.println("Data por extenso: " + d1.mostra2());

        System.out.println("Dias transcorridos no ano até a data: " + d1.diasTranscorridos());

        if (d1.bissexto()) {
            System.out.println("O ano " + d1.retAno() + " é bissexto.");
        } else {
            System.out.println("O ano " + d1.retAno() + " não é bissexto.");
        }

        d1.apresentaDataAtual();

        Data d2 = new Data();

        System.out.println("Data: " + d2.mostra1());
        System.out.println("Data por extenso: " + d2.mostra2());

        d2.entraDia();
        System.out.println(d2.retDia());

        d2.entraDia(10);
        System.out.println(d2.retDia());
        
        d2.entraMes();
        System.out.println(d2.retMes());

        d2.entraMes(7);
        System.out.println(d2.retMes());
        
        d2.entraAno();
        System.out.println(d2.retAno());

        d2.entraAno(2024);
        System.out.println(d2.retAno());
    }
}