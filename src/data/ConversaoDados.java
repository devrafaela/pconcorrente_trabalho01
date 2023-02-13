package data;

/* ***************************************************************
* Autor............: Rafaela Pereira Santos
* Matricula........: 202110838
* Inicio...........: 06/02/2023
* Ultima alteracao.: 12/02/2023
* Nome.............: ConversaoDados
* Funcao...........: Contem os metodos de conversao das medidas
de comprimento 
*************************************************************** */
public abstract class ConversaoDados {

  // -- METODOS DE CONVERSAO DO QUILOMETRO  -- //
  /* ***************************************************************
  * Metodo: converteKMparaM
  * Funcao: converte quilometro para metro
  * Parametros: valorKMparaM eh o valor recebido em quilometro
  * Retorno: retorna o valor em metro
  *************************************************************** */
  public static double converteKMparaM(double valorKMparaM){
    return valorKMparaM * 1000;
  }

  /* ***************************************************************
  * Metodo: converteKMparaCM
  * Funcao: converte quilometro para centimetro
  * Parametros: valorKMparaCM eh o valor recebido em quilometro
  * Retorno: retorna o valor em centimetro
  *************************************************************** */
  public static double converteKMparaCM(double valorKMparaCM) {  
    return valorKMparaCM * 100000;
  }

  /* ***************************************************************
  * Metodo: converteKMparaMM
  * Funcao: converte quilometro para milimetro
  * Parametros: valorKMparaMM eh o valor recebido em quilometro
  * Retorno: retorna o valor em milimetro
  *************************************************************** */
  public static double converteKMparaMM(double valorKMparaMM) { 
    return valorKMparaMM * 1000000;
  }


  // ----------------------------------------------------------------------------------------------------------------- //


  // -- METODOS DE CONVERSAO DO METRO  -- //
  /* ***************************************************************
  * Metodo: converteMparaKM
  * Funcao: converte metro para quilometro
  * Parametros: valorMparaKM eh o valor recebido em metro
  * Retorno: retorna o valor em quilometro
  *************************************************************** */
  public static double converteMparaKM(double valorMparaKM) { 
    return valorMparaKM / 1000;
  }

  /* ***************************************************************
  * Metodo: converteMparaCM
  * Funcao: converte metro para centimetro
  * Parametros: valorMparaCM eh o valor recebido em metro
  * Retorno: retorna o valor em centimetro
  *************************************************************** */
  public static double converteMparaCM(double valorMparaCM) { 
    return valorMparaCM * 100;
  }

  /* ***************************************************************
  * Metodo: converteMparaMM
  * Funcao: converte metro para milimetro
  * Parametros: valorMparaMM eh o valor recebido em metro
  * Retorno: retorna o valor em milimetro
  *************************************************************** */
  public static double converteMparaMM(double valorMparaMM) {
    return valorMparaMM * 1000;
  }


  // ----------------------------------------------------------------------------------------------------------------- //


  // -- METODOS DE CONVERSAO DO CENTIMETRO  -- //
  /* ***************************************************************
  * Metodo: converteCMparaKM
  * Funcao: converte centimetro para quilometro
  * Parametros: valorCMparaKM eh o valor recebido em centimetro
  * Retorno: retorna o valor em quilometro
  *************************************************************** */
  public static double converteCMparaKM(double valorCMparaKM) {  
    return valorCMparaKM / 100000;
  }

  /* ***************************************************************
  * Metodo: converteCMparaM
  * Funcao: converte centimetro para metro
  * Parametros: valorCMparaM eh o valor recebido em centimetro
  * Retorno: retorna o valor em metro
  *************************************************************** */
  public static double converteCMparaM(double valorCMparaM) {  
    return valorCMparaM / 100;
  }

  /* ***************************************************************
  * Metodo:converteCMparaMM
  * Funcao: converte centimetro para milimetro
  * Parametros: valorCMparaMM eh o valor recebido em centimetro
  * Retorno: retorna o valor em milimetro
  *************************************************************** */
  public static double converteCMparaMM(double valorCMparaMM) {  
    return valorCMparaMM * 10;
  }


  // ----------------------------------------------------------------------------------------------------------------- //


  // -- METODOS DE CONVERSAO DO MILIMETRO  -- //
  /* ***************************************************************
  * Metodo: converteMMparaKM
  * Funcao: converte milimetro para quilometro
  * Parametros: valorMMparaKM eh o valor recebido em milimetro
  * Retorno: retorna o valor em quilometro
  *************************************************************** */
  public static double converteMMparaKM(double valorMMparaKM) {
    return valorMMparaKM / 1000000;
  }

  /* ***************************************************************
  * Metodo: converteMMparaM
  * Funcao: converte milimetro para metro
  * Parametros: valorMMparaM eh o valor recebido em milimetro
  * Retorno: retorna o valor em metro
  *************************************************************** */
  public static double converteMMparaM(double valorMMparaM) { 
    return valorMMparaM / 1000;
  }

  /* ***************************************************************
  * Metodo: converteMMparaCM
  * Funcao: converte milimetro para centimetro
  * Parametros: valorMMparaCM eh o valor recebido em milimetro
  * Retorno: retorna o valor em centimetro
  *************************************************************** */
  public static double converteMMparaCM(double valorMMparaCM) { 
    return valorMMparaCM / 10;
  }
    

}
