package controller;

import java.net.URL;
import java.util.ResourceBundle;

import data.ConversaoDados;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/* ***************************************************************
* Autor............: Rafaela Pereira Santos
* Matricula........: 202110838
* Inicio...........: 09/02/2023
* Ultima alteracao.: 12/02/2023
* Nome.............: ControllerTela
* Funcao...........: Controla as alteracoes que acontecera na tela
*************************************************************** */
public class ControllerTela implements Initializable {

  @FXML
  private TextField valorParaConverter;   // -- TextField para receber valor para converter -- // 
  
  @FXML
  private Label valorConvertido;   // -- Label que ira retornar o valor convertido -- //

  @FXML 
  private ChoiceBox <String> choiceBoxEntrada;   // -- ChoiceBox para selecionar a primeira unidade de medida de comprimento -- //

  @FXML
  private ChoiceBox <String> choiceBoxSaida;   // -- ChoiceBox para selecionar a segunda unidade de medida de comprimento -- //

  @FXML
  // -- Vetor tipo String inicializado com os nomes das medidas de comprimento que serao armazenados em: choicheBoxEntrada  -- //
  private String listaDeMedidaEntrada [] = {"Quilometro(s)", "Metro(s)", "Centimetros(s)", "Milimetro(s)"}; 
  
  @FXML
  // -- Vetor tipo String inicializado com os nomes das medidas de comprimento que serao armazenados em: choicheBoxSaida  -- //
  private String listaDeMedidaSaida [] = {"Quilometro(s)", "Metro(s)", "Centimetro(s)", "Milimetro(s)"};

  @FXML
  private Label alerta;   // -- Label usada para mostrar mensagem de alerta para o usuario -- //

  /**
   * Controla os eventos do botaoConverter na interface 
   * @param e  
   */
  @FXML
  public void botaoConverter(ActionEvent e) {  // -- Inicializa a conversao de acordo os criterios abaixo: -- //
    
    double resultado = 0;  // -- Variavel do tipo double inicializada com 0  -- //

    switch (choiceBoxEntrada.getSelectionModel().getSelectedIndex()){  
    /**
     * O Switch recebera por parametro:
     * - choiceBoxEntrada: que aparecera os seguintes nomes "Quilometro(s)", "Metro(s)", "Centimetros(s)", "Milimetro(s)";
     * - .getSelectionModel(): define que apenas uma unica escolha pode ser feita no choiceBoxEntrada;
     * - .getSelectedIndex(): retorna o valor inteiro indicando o indice atualmente selecionado na choiceBoxEntrada, sendo:
     * -                      0 - "Quilometro(s)", 1 - "Metro(s)", 2 - "Centimetro(s)" e 3 "Milimetro(s)"
     */


    case 0: // -- Caso seja selecionado "Quilometro(s)" (indice igual a 0) no choiceBoxEntrada, sera feito:  --  //
    
    // -- O if ira verificar caso seja escolhido o mesmo tipo de conversao para os dois ChoiceBox's, sera retornado uma mensagem de alerta  -- //  
    if (choiceBoxEntrada.getSelectionModel().getSelectedIndex() == choiceBoxSaida.getSelectionModel().getSelectedIndex()){  
      // -- Ex. de Erro:  Quilometro -> Quilometro NAO eh permitido -- //
      alerta.setText("SELECIONE OPCOES DIFERENTES DE CONVERSAO");  // -- Mensagem de alerta -- //
      valorParaConverter.setText("");  //  -- TextField ficara vazio para nova tentativa de conversao possivel -- //
      valorConvertido.setText("");  //  -- Label ficara vazia para nova tentativa de conversao possivel -- //
      return;
    }

    if (choiceBoxSaida.getSelectionModel().getSelectedIndex() == 1){  
      // -- Caso seja escolhido "Metro(s)" (indice igual a 1) no choiceBoxSaida, sera feito a conversao de Km para m -- //
      alerta.setText("");  // -- alerta recebe uma String vazia para a mensagem sumir da tela -- //

      /** 
       * Eh realizado a conversao de Km para m, com o valor armazenado na TextField valorParaConverter, onde o mesmo eh convertido de
       * uma String para um double, que sera passado por parametro para o metodo de conversao escolhido na classe ConversaoDados, e
       * apos a conversao ter sido feita, o valorParaConverter eh armazenado na variavel resultado do tipo double.
       * Por fim, o valorConvertido recebe a variavel resultado, com o valor final;
       */
      resultado = ConversaoDados.converteKMparaM(Double.parseDouble(valorParaConverter.getText()));  
      // -- Dica para converter um double para uma String de forma rapida: basta concatenar com uma String vazia -- //
      valorConvertido.setText(resultado+""); // -- Eh mostrado no Label valorConvetido o resultado da conversao  -- //

    } else if (choiceBoxSaida.getSelectionModel().getSelectedIndex() == 2){
    // -- Caso seja escolhido "Centimetro(s)" (indice igual a 2) no choiceBoxSaida, sera feito a conversao de Km para cm -- //
      alerta.setText("");  // -- alerta recebe uma String vazia para a mensagem sumir da tela -- //
      /** 
       * O valor armazenado na TextField valorParaConverter, onde o mesmo eh convertido de
       * uma String para um double, sera passado por parametro para o metodo de conversao escolhido na classe ConversaoDados, e
       * apos a conversao ter sido feita, o valorParaConverter eh armazenado na variavel resultado do tipo double.
       * Por fim, o valorConvertido recebe a variavel resultado, com o valor final;
       */
      resultado = ConversaoDados.converteKMparaCM(Double.parseDouble(valorParaConverter.getText()));
      // -- resultado sendo concatenada com uma String vazia para realizar a conversao de Double para String -- //
      valorConvertido.setText(resultado+""); // -- Eh mostrado no Label valorConvetido o resultado da conversao  -- //
      
    } else {  // -- Se nao for escolhido nem Metro e nem Centimetro, o valor da TextField sera convertido para Milimetro -- //
      alerta.setText("");  // -- Mensagem de alerta 'some' da Tela -- //
      // -- resultado recebe o valor da TextField ja convertido atraves do metodo encontrado em ConversaoDados -- //
      resultado = ConversaoDados.converteKMparaMM(Double.parseDouble(valorParaConverter.getText()));
      valorConvertido.setText(resultado+"");   // -- O resultado eh mostrado na Label para o usuario ver -- //
    }
    break;


    case 1: // -- Caso seja selecionado "Metro(s)" (indice igual a 1) no choiceBoxEntrada, sera feito:  --  //

    // -- Se for escolhido o mesmo tipo de conversao, sera mostrado uma mensagem de alerta -- //
    if (choiceBoxEntrada.getSelectionModel().getSelectedIndex() == choiceBoxSaida.getSelectionModel().getSelectedIndex()){
      // -- Ex. de Erro:  Metro -> Metro NAO eh permitido -- //
      alerta.setText("SELECIONE OPCOES DIFERENTES DE CONVERSAO");
      valorParaConverter.setText("");   // -- TextField ficara vazia para nova tentativa -- //
      valorConvertido.setText("");      // -- Label ficara vazia para nova tentativa -- //
      return;
    }

    if(choiceBoxSaida.getSelectionModel().getSelectedIndex() == 0){
      // -- Caso seja escolhido "Quilometro(s)" (indice igual a 0) no choiceBoxSaida, sera feito a conversao de m para Km -- //
      alerta.setText("");  // -- alerta some da tela --- //
      // -- resultado ira receber o valor da TextField ja convertido atraves do metodo converteMparaKM encontrado em ConversaoDados  -- //
      resultado = ConversaoDados.converteMparaKM(Double.parseDouble(valorParaConverter.getText()));
      valorConvertido.setText(resultado+""); // -- O resultado eh mostrado na Label para o usuario ver -- //

    } else if (choiceBoxSaida.getSelectionModel().getSelectedIndex() == 2) {
      // -- Caso seja escolhido "Centimetro(s)" (indice igual a 2) no choiceBoxSaida, sera feito a conversao de m para cm -- //
      alerta.setText("");  // -- alerta some da tela --- //
      // -- resultado ira receber o valor da TextField ja convertido atraves do metodo converteMparaCM encontrado em ConversaoDados  -- //
      resultado = ConversaoDados.converteMparaCM(Double.parseDouble(valorParaConverter.getText()));
      valorConvertido.setText(resultado+""); // -- O resultado eh mostrado na Label para o usuario ver -- //

    } else {  // -- Se nao for escolhido nem Quilometro e nem Centimetro, o valor da TextField sera convertido para Milimetro -- //  
      alerta.setText("");  // -- alerta some da tela --- //
      // -- resultado ira receber o valor da TextField ja convertido atraves do metodo converteMparaMM encontrado em ConversaoDados  -- //
      resultado = ConversaoDados.converteMparaMM(Double.parseDouble(valorParaConverter.getText()));
      valorConvertido.setText(resultado+""); // -- O resultado eh mostrado na Label para o usuario ver -- //
    }
    break;


    case 2:  // -- Caso seja selecionado "Centimetro(s)" (indice igual a 2) no choiceBoxEntrada, será feito:  --  //

    // -- Se for escolhido o mesmo tipo de conversao, sera mostrado uma mensagem de alerta -- //
    if (choiceBoxEntrada.getSelectionModel().getSelectedIndex() == choiceBoxSaida.getSelectionModel().getSelectedIndex()){
      // -- Ex. de Erro:  Centimetro -> Centimetro NAO eh permitido -- //
      alerta.setText("SELECIONE OPCOES DIFERENTES DE CONVERSAO");
      valorParaConverter.setText("");   // -- TextField ficara vazia para nova tentativa -- //
      valorConvertido.setText("");      // -- Label ficara vazia para nova tentativa -- //
      return;
    }

    if(choiceBoxSaida.getSelectionModel().getSelectedIndex() == 0){
      // -- Caso seja escolhido "Quilometro(s)" (indice igual a 0) no choiceBoxSaida, sera feito a conversao de cm para Km -- //
      alerta.setText("");  // -- alerta some da tela --- //
      // -- resultado ira receber o valor da TextField ja convertido atraves do metodo converteCMparaKM encontrado em ConversaoDados  -- //
      resultado = ConversaoDados.converteCMparaKM(Double.parseDouble(valorParaConverter.getText()));
      valorConvertido.setText(resultado+"");  // -- O resultado eh mostrado na Label para o usuario ver -- //

    } else if (choiceBoxSaida.getSelectionModel().getSelectedIndex() == 1) {
      // -- Caso seja escolhido "Metro(s)" (indice igual a 1) no choiceBoxSaida, sera feito a conversao de cm para m -- //
      alerta.setText("");  // -- alerta some da tela --- //
      // -- resultado ira receber o valor da TextField ja convertido atraves do metodo converteCMparaM encontrado em ConversaoDados  -- //
      resultado = ConversaoDados.converteCMparaM(Double.parseDouble(valorParaConverter.getText()));
      valorConvertido.setText(resultado+"");  // -- O resultado eh mostrado na Label para o usuario ver -- //

    } else {  // -- Se nao for escolhido nem Quilometro e nem Metro, o valor da TextField sera convertido para Milimetro -- //  
      alerta.setText("");  // -- alerta some da tela --- //
      // -- resultado ira receber o valor da TextField ja convertido atraves do metodo converteCMparaMM encontrado em ConversaoDados  -- //
      resultado = ConversaoDados.converteCMparaMM(Double.parseDouble(valorParaConverter.getText()));
      valorConvertido.setText(resultado+"");  // -- O resultado eh mostrado na Label para o usuario ver -- //
    }
    break;


    case 3:  // -- Caso seja selecionado "Milimetro(s)" (indice igual a 3 no choiceBoxEntrada, sera feito:  --  //

    // -- Se for escolhido o mesmo tipo de conversao, sera mostrado uma mensagem de alerta -- //
    if (choiceBoxEntrada.getSelectionModel().getSelectedIndex() == choiceBoxSaida.getSelectionModel().getSelectedIndex()){
      // -- Ex. de Erro:  Milimetro -> Milimetro NAO eh permitido -- //
      alerta.setText("SELECIONE OPCOES DIFERENTES DE CONVERSAO");
      valorParaConverter.setText("");   // -- TextField ficara vazia para nova tentativa -- //
      valorConvertido.setText("");      // -- Label ficara vazia para nova tentativa -- //
      return;
    }

    if(choiceBoxSaida.getSelectionModel().getSelectedIndex() == 0){
      // -- Caso seja escolhido "Quilometro(s)" (indice igual a 0) no choiceBoxSaida, sera feito a conversao de cm para Km -- //
      alerta.setText("");  // -- alerta some da tela --- //
      // -- resultado ira receber o valor da TextField ja convertido atraves do metodo converteMMparaKM encontrado em ConversaoDados  -- //
      resultado = ConversaoDados.converteMMparaKM(Double.parseDouble(valorParaConverter.getText()));
      valorConvertido.setText(resultado+"");  // -- O resultado eh mostrado na Label para o usuario ver -- //

    } else if (choiceBoxSaida.getSelectionModel().getSelectedIndex() == 1) {
      // -- Caso seja escolhido "Metro(s)" (indice igual a 1) no choiceBoxSaida, sera feito a conversao de mm para m -- //
      alerta.setText("");  // -- alerta some da tela --- //
      // -- resultado ira receber o valor da TextField ja convertido atraves do metodo converteMMparaM encontrado em ConversaoDados  -- //
      resultado = ConversaoDados.converteMMparaM(Double.parseDouble(valorParaConverter.getText()));
      valorConvertido.setText(resultado+"");  // -- O resultado eh mostrado na Label para o usuario ver -- //

    } else {  // -- Se nao for escolhido nem Quilometro e nem Metro, o valor da TextField sera convertido para Centimetro -- //  
      alerta.setText("");  // -- alerta some da tela --- //
      // -- resultado ira receber o valor da TextField ja convertido atraves do metodo converteCMparaMM encontrado em ConversaoDados  -- //
      resultado = ConversaoDados.converteMMparaCM(Double.parseDouble(valorParaConverter.getText()));
      valorConvertido.setText(resultado+"");  // -- O resultado eh mostrado na Label para o usuario ver -- //
    }   
    break;

    }
  }

  /**
   * Define as acoes que serao executadas quando a classe for iniciada
   * @param url
   * @param rb
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
  //  try {
    // Eh armazenado no choicheBoxEntrada o vetor listaDeMedidaEntrada que contem os nomes "Quilometro(s)", "Metro(s)", "Centimetro(s)", "Milimetro(s)"
    choiceBoxEntrada.getItems().addAll(listaDeMedidaEntrada);
    // Eh armazenado no choicheBoxSaida o vetor listaDeMedidaSaida que contem os nomes "Quilometro(s)", "Metro(s)", "Centimetro(s)", "Milimetro(s)"
    choiceBoxSaida.getItems().addAll(listaDeMedidaSaida);
  }

}
