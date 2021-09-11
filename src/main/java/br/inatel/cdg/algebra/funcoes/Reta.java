package br.inatel.cdg.algebra.funcoes;

public class Reta {

    //pontos de uma reta
    private Ponto p1, p2;

    //construtor para atribuir valores aos pontos da reta
    public Reta(Ponto p1, Ponto p2){
        this.p1 = p1;
        this.p2 = p2;
    }
    
    //função para calcular o coeficiente angular
    public double calcCoefAngular(){
        double resultado = 0.0;

        resultado = (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());

        return resultado;
    }

    //função para calcular o coeficiente linear
    public double calcCoefLinear(){
        double resultado = 0.0;

        resultado = p1.getY() - calcCoefAngular() * p1.getX();

        return resultado;
    }



}
