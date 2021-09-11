package br.inatel.cdg.algebra.funcoes;

public class Ponto {

    //criando as variaveis para um ponto
    private double x, y;

    //construtor para atribuir valores aos pontos
    public Ponto (double x, double y){
        this.x = x;
        this.y = y;
    }

    //get para recuperar o valor da variavel X
    public double getX() {
        return x;
    }
    
    //get para recuperar o valor da variavel Y
    public double getY() {
        return y;
    }
}
