import java.util.Date;
import java.text.DateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Data {
    private int dia; 
    private int mes; 
    private int ano;
    public static Scanner sc = new Scanner(System.in);

    public Data() {
        entraDia();
        entraMes();
        entraAno();
    }

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public void entraDia(int dia) {
        if (this.mes % 2 == 1 || this.mes >= 8 && this.mes % 2 == 0) {
            if (this.dia == 31) {
                this.dia = 1;
                if (this.mes == 12) {
                    this.mes = 1;
                    this.ano++;
                } else {
                    this.mes++;
                }
            } else {
                this.dia += dia;
            }
        } else {
            if (this.dia == 30) {
                this.dia = 1;
                if (this.mes == 12) {
                    this.mes = 1;
                    this.ano++;
                } else {
                    this.mes++;
                }
            } else {
                this.dia = dia;
            }
        }
    }

    public void entraMes(int mes) {
        if (this.mes == 12) {
            this.mes = 1;
            this.ano++;
        } else {
            this.mes = mes;
        }
    }

    public void entraAno(int ano) {
        this.ano = ano;
    }

    public void entraDia() {
        while (true) {
            try {
                System.out.print("Digite um valor para o dia: ");
                int dia = sc.nextInt();
                if (dia < 1 || dia > 31) {
                    System.out.println("Erro. Valor inválido. Digite um valor entre 1 e 31.");
                } else {
                    entraDia(dia);
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro. Valor inválido. Digite um número inteiro.");
                sc.next();
            }
        }
    }

    public void entraMes() {
        while (true) {
            try {
                System.out.print("Digite um valor para o mês: ");
                int mes = sc.nextInt();
                if (mes < 1 || mes > 12) {
                    System.out.println("Erro. Valor inválido. Digite um valor entre 1 e 12.");
                } else {
                    entraMes(mes);
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro. Valor inválido. Digite um número inteiro.");
                sc.next();
            }
        }
    }

    public void entraAno() {
        while (true) {
            try {
                System.out.print("Digite um valor para o ano: ");
                int ano = sc.nextInt();
                entraAno(ano);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Erro. Valor inválido. Digite um número inteiro.");
                sc.next();
            }
        }
    }

    public int retDia() {
        return this.dia;
    }

    public int retMes() {
        return this.mes;
    }

    public int retAno() {
        return this.ano;
    }

    public String mostra1() {
        String str = "";
        if (this.dia < 10) {
            str += "0" + this.dia + "/";
            if (this.mes < 10) {
                str += "0" + this.mes + "/" + this.ano;
            } else {
                str += this.mes + "/" + this.ano;
            }
        } else {
            str += this.dia + "/";
            if (this.mes < 10) {
                str += "0" + this.mes + "/" + this.ano;
            } else {
                str += this.mes + "/" + this.ano;
            }
        }
        return str;
    }

    public String mostra2() {
        String[] meses = {
            "janeiro", "fevereiro", "marco", "abril", 
            "maio", "junho", "julho", "agosto",
            "setembro", "outubro", "novembro", "dezembro"
        };
        String str = "";
        if (this.dia < 10) {
            str += "0" + this.dia + "/" + meses[this.mes - 1] + "/" + this.ano;
        } else {
            str += this.dia + "/" + meses[this.mes - 1] + "/" + this.ano;
        }
        return str;
    }

    public boolean bissexto() {
        return (this.ano % 4 == 0 && this.ano % 100 != 0) || (this.ano % 400 == 0);
    }

    public int diasTranscorridos() {
        int[] diasPorMesComum = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int[] diasPorMesBissexto = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        int totalDias = 0;

        for (int i = 0; i < this.mes - 1; i++) {
            if (bissexto()) {
                totalDias += diasPorMesBissexto[i];
            } else {
                totalDias += diasPorMesComum[i];
            }
        }

        totalDias += this.dia;
        return totalDias;
    }

    public void apresentaDataAtual() {
        Date dataAtual = new Date();
        DateFormat formatoCompleto = DateFormat.getDateInstance(DateFormat.FULL);
        String dataFormatada = formatoCompleto.format(dataAtual);
        System.out.println("Data atual: " + dataFormatada);
    }
}