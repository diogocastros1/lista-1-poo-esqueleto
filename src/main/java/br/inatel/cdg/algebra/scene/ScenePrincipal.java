package br.inatel.cdg.algebra.scene;

import br.inatel.cdg.algebra.funcoes.Ponto;
import br.inatel.cdg.algebra.funcoes.Reta;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ScenePrincipal {

    private Button btnCalcCoefLinear, btnCalcCoefAngular; //Button representa botoes
    private Label labelP1X, labelP1Y, labelP2X, labelP2Y; //Label representam rótulos
    private TextField textFieldP1X, textFieldP1Y, textFieldP2X, textFieldP2Y, textFieldCoefAng, textFieldCoefLin; //TextField Representam áreas de texto
    
    public void criaScenePrincipal(Stage stage){

        //Criando os labels para os pontos e os campos de texto para os dados
        labelP1X = new Label("Ponto P1.X"); 
        textFieldP1X = new TextField(); 

        labelP1Y = new Label("Ponto P1.Y"); 
        textFieldP1Y = new TextField(); 

        labelP2X = new Label("Ponto P2.X"); 
        textFieldP2X = new TextField(); 

        labelP2Y = new Label("Ponto P2.Y"); 
        textFieldP2Y = new TextField(); 
        
        //agrupando os objetos que queremos na horizontal
        HBox grHorP1X = new HBox(labelP1X, textFieldP1X); 
        HBox grHorP1Y = new HBox(labelP1Y, textFieldP1Y); 
        HBox grHorP2X = new HBox(labelP2X, textFieldP2X); 
        HBox grHorP2Y = new HBox(labelP2Y, textFieldP2Y); 

        //campos para exibir o resultado dos calculos
        textFieldCoefAng = new TextField();
        textFieldCoefAng.setEditable(false);
        textFieldCoefAng.setText("Coef Angular: ");

        textFieldCoefLin = new TextField();
        textFieldCoefLin.setEditable(false);
        textFieldCoefLin.setText("Coef Linear: ");

        //agrupando as respostas horizontalmente
        HBox grHorResp = new HBox(textFieldCoefAng, textFieldCoefLin);

        //criando o botão para calcular o coeficiente angular
        btnCalcCoefAngular = new Button("Calcula Coeficiente Angular");
        //setando a ação do botão
        btnCalcCoefAngular.setOnAction(evento -> {
            //criando uma reta
            Reta reta = construirReta();
            
            //setando o valor do coef angular
            textFieldCoefAng.setText("Coef Angular: " + reta.calcCoefAngular());
        });

        //criando o botão para calcular o coeficiente linear
        btnCalcCoefLinear = new Button("Calcula Coeficiente Linear");
        //setando a ação do botão
        btnCalcCoefLinear.setOnAction(evento -> {
            //criando uma reta
            Reta reta = construirReta();
            
            //setando o valor do coef angular
            textFieldCoefLin.setText("Coef Linear: " + reta.calcCoefLinear());
        });

        HBox grHorBotoes = new HBox(btnCalcCoefAngular, btnCalcCoefLinear);

        //VBox é usada para agrupar elementos verticalmente
        //No construtor passamos todos os elementos que serão agrupados, que podem ser outros grupos
        VBox layoutFinal = new VBox(grHorP1X, grHorP1Y, grHorP2X, grHorP2Y, grHorResp, grHorBotoes);//Aqui vamos agrupar verticalmente o grupo (Label + Texto) o Botao e A area que aparecer o texto digitado
        //Criamos a Scene
        Scene scene = new Scene(layoutFinal, 300 , 200);


        stage.setTitle("Software Para Calculos de Álgebra Linear");
        stage.setScene(scene);
        stage.show();
    }

    //função para criar uma reta
    private Reta construirReta(){
        //acessando os pontos digitados nos campos de texto e passando-os para double
        Ponto p1 = new Ponto(Double.parseDouble(textFieldP1X.getText()), Double.parseDouble(textFieldP1Y.getText()));
        Ponto p2 = new Ponto(Double.parseDouble(textFieldP2X.getText()), Double.parseDouble(textFieldP2Y.getText()));
    
        Reta reta = new Reta(p1, p2);

        return reta;
    }

      
}