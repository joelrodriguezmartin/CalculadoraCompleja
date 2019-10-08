package dad.javafx.calculadoracompleja;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class CalculadoraCompleja extends Application {
	//view
	private TextField real1Text;
	private TextField real2Text;
	private TextField imaginario1Text;
	private TextField imaginario2Text;
	private TextField resultadorealText;
	private TextField resultadoimaginarioText;
	private ComboBox<String> operadorCombo;
	private Separator separador = new Separator();
	private Label labelsuma1 = new Label("+");
	private Label labelsuma2 = new Label("+");
	private Label labelsuma3 = new Label("+");
	private Label labeli1 = new Label("i");
	private Label labeli2 = new Label("i");
	private Label labeli3 = new Label("i");
	
	//model
	private Complejo operando1 = new Complejo();
	private Complejo operando2 = new Complejo();
	private Complejo resultado = new Complejo();
	private StringProperty operacion = new SimpleStringProperty();
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		//primer set de cosas
		real1Text = new TextField();
		real1Text.setPrefColumnCount(4);
		
		imaginario1Text = new TextField();
		imaginario1Text.setPrefColumnCount(4);
		
		HBox operacion1Box = new HBox(5, real1Text, labelsuma1, imaginario1Text, labeli1);
		
		//segundo set de cosas 
		real2Text = new TextField();
		real2Text.setPrefColumnCount(4);	
		
		imaginario2Text = new TextField();
		imaginario2Text.setPrefColumnCount(4);
		
		HBox operacion2Box = new HBox(5, real2Text, labelsuma2, imaginario2Text, labeli2);
		
		//tercer set de cosas
		resultadorealText = new TextField();
		resultadorealText.setPrefColumnCount(4);
		resultadorealText.setEditable(false);
		
		resultadoimaginarioText = new TextField();
		resultadoimaginarioText.setPrefColumnCount(4);
		resultadoimaginarioText.setEditable(false);
		
		HBox resultadoBox = new HBox(5, resultadorealText, labelsuma3, resultadoimaginarioText, labeli3);
		
		//empezamos a meter cosas en cosas 
		
		operadorCombo = new ComboBox<String>();
		operadorCombo.getItems().addAll("+", "-", "*", "/");
		VBox operadorBox = new VBox(5, operadorCombo);
		operadorBox.setAlignment(Pos.CENTER);
		
		VBox operacionesBox = new VBox(5, operacion1Box, operacion2Box, separador, resultadoBox);
		operacionesBox.setAlignment(Pos.CENTER_LEFT);
		
		HBox root = new HBox(5, operadorBox, operacionesBox);
		root.setAlignment(Pos.CENTER);
		
		//escena
		Scene scene = new Scene(root, 320, 200);
		
		primaryStage.setTitle("Calculadora compleja");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//bindeos
		real1Text.textProperty().bindBidirectional(operando1.realProperty(), new NumberStringConverter());
		real2Text.textProperty().bindBidirectional(operando2.realProperty(), new NumberStringConverter());
		imaginario1Text.textProperty().bindBidirectional(operando1.imaginarioProperty(), new NumberStringConverter());
		imaginario2Text.textProperty().bindBidirectional(operando2.imaginarioProperty(), new NumberStringConverter());
		resultadorealText.textProperty().bindBidirectional(resultado.realProperty(), new NumberStringConverter());
		resultadoimaginarioText.textProperty().bindBidirectional(resultado.imaginarioProperty(), new NumberStringConverter());
		operacion.bind(operadorCombo.getSelectionModel().selectedItemProperty());
		
		operacion.addListener((o, ov, nv) -> onOperacionChanged(nv));
		
		operadorCombo.getSelectionModel().selectFirst();
	}

	private void onOperacionChanged(String nv) {
		switch (nv) {
		case("+"): 
			resultado.realProperty().bind(operando1.realProperty().add(operando2.realProperty()));
			resultado.imaginarioProperty().bind(operando1.imaginarioProperty().add(operando2.imaginarioProperty()));
			break;
		case("-"): 
			resultado.realProperty().bind(operando1.realProperty().subtract(operando2.realProperty()));
			resultado.imaginarioProperty().bind(operando1.imaginarioProperty().subtract(operando2.imaginarioProperty()));
			break;
		case("*"): 
			resultado.realProperty().bind(CalcBindings.multireal(operando1.realProperty(), operando1.imaginarioProperty(), 
					operando2.realProperty(), operando2.imaginarioProperty()));
			resultado.imaginarioProperty().bind(CalcBindings.multiimagin(operando1.realProperty(), operando1.imaginarioProperty(),
					operando2.realProperty(), operando2.imaginarioProperty()));
			break;
		case("/"): 
			resultado.realProperty().bind(CalcBindings.divreal(operando1.realProperty(), operando1.imaginarioProperty(), 
					operando2.realProperty(), operando2.imaginarioProperty()));
			resultado.imaginarioProperty().bind(CalcBindings.divimagin(operando1.realProperty(), operando1.imaginarioProperty(),
					operando2.realProperty(), operando2.imaginarioProperty()));
		}
	}
	public static void main(String[] args) {
		launch(args);
		
	}

}
