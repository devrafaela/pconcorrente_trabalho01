
import controller.ControllerTela;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/* ***************************************************************
* Autor............: Rafaela Pereira Santos
* Matricula........: 202110838
* Inicio...........: 06/02/2023
* Ultima alteracao.: 12/02/2023
* Nome.............: Principal
* Funcao...........: Inicializa o Programa
*************************************************************** */
public class Principal extends Application {

  public static Parent root;
  public static Stage palco = new Stage();
  public static String telaAnterior = "";
  public static String telaMenuAnterior = "";

  @Override
  public void start(Stage palco) throws Exception {
    new ControllerTela();
    root = FXMLLoader.load(getClass().getResource("/view/TelaConversorMedidas.fxml"));
    Scene scene = new Scene(root);
    Principal.palco.setTitle("Conversor de Medidas de Comprimento");
    Principal.palco.getIcons().add(new Image("/view/images/fita-metrica.png"));
    Principal.palco.setScene(scene);
    Principal.palco.setResizable(false);
    Principal.palco.sizeToScene();
    Principal.palco.centerOnScreen();
    Principal.palco.show();
	}

  public static void main(String[] args) {
  launch(args);
  }

}