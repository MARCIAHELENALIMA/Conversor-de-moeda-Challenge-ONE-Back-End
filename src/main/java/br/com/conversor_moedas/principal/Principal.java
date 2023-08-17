package br.com.conversor_moedas.principal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * Classe principal que inicia o aplicativo Conversor de Moedas.
 */
public class Principal extends Application {

	/**
	 * Método principal que inicia o aplicativo.
	 *
	 * @param args Os argumentos da linha de comando (não são usados aqui).
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Método start é chamado quando o aplicativo é iniciado.
	 *
	 * @param primaryStage O palco principal (janela) do aplicativo.
	 * @throws Exception Se ocorrer algum erro ao carregar o FXML.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		// Define o título da janela do aplicativo.
		primaryStage.setTitle("Conversor de Moedas da Márcia");

		// Carrega o arquivo FXML que define a interface do usuário.
		Parent root = FXMLLoader
				.load(Objects.requireNonNull(getClass().getResource("/br/com/conversor_moedas/principal.fxml")));

		// Cria uma cena com o conteúdo carregado do FXML.
		Scene scene = new Scene(root, 720, 720);

		// Define a cena na janela principal.
		primaryStage.setScene(scene);

		// Define a largura e a altura da janela.
		primaryStage.setWidth(720);
		primaryStage.setHeight(720);

		// Exibe a janela do aplicativo.
		primaryStage.show();
	}
}
