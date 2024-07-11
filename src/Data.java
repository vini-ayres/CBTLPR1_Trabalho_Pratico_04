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
        if (dia >= 1 && dia <= 31 && mes >= 1 && mes <= 12 && ano > 0) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            throw new IllegalArgumentException("Data inválida");
        }
    }

    public void entraDia(int dia) {
        if (dia >= 1 && dia <= 31) {
            this.dia = dia;
        } else {
            throw new IllegalArgumentException("Dia inválido");
        }
    }

    public void entraMes(int mes) {
        if (mes >= 1 && mes <= 12) {
            this.mes = mes;
        } else {
            throw new IllegalArgumentException("Mês inválido");
        }
    }

    public void entraAno(int ano) {
        if (ano > 0) {
            this.ano = ano;
        } else {
            throw new IllegalArgumentException("Ano inválido");
        }
    }

    public void entraDia() {
        while (true) {
            try {
                System.out.print("Digite um valor para o dia: ");
                int dia = sc.nextInt();
                if (dia >= 1 && dia <= 31) {
                    this.dia = dia;
                    break;
                } else {
                    System.out.println("Erro. Valor inválido para o dia.");
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
                if (mes >= 1 && mes <= 12) {
                    this.mes = mes;
                    break;
                } else {
                    System.out.println("Erro. Valor inválido para o mês.");
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
                if (ano > 0) {
                    this.ano = ano;
                    break;
                } else {
                    System.out.println("Erro. Valor inválido para o ano.");
                }
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
        return String.format("%02d/%02d/%d", this.dia, this.mes, this.ano);
    }

    public String mostra2() {
        String[] meses = {
            "janeiro", "fevereiro", "março", "abril", 
            "maio", "junho", "julho", "agosto",
            "setembro", "outubro", "novembro", "dezembro"
        };
        return String.format("%02d/%s/%d", this.dia, meses[this.mes - 1], this.ano);
    }

    public boolean bissexto() {
        return (this.ano % 4 == 0 && this.ano % 100 != 0) || (this.ano % 400 == 0);
    }

    public int diasTranscorridos() {
        int[] diasPorMesComum = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int[] diasPorMesBissexto = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        int totalDias = 0;

        for (int i = 0; i < this.mes - 1; i++) {
            totalDias += bissexto() ? diasPorMesBissexto[i] : diasPorMesComum[i];
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