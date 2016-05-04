/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallertriqui.principal;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import tallertriqui.modelo.Celda;
import tallertriqui.modelo.TableroTriqui;

/**
 *
 * @author ener2
 */
public class TallerTriqui extends Application{

    private Button btn11;
    private Button btn12;
    private Button btn13;
    private Button btn21;
    private Button btn22;
    private Button btn23;
    private Button btn31;
    private Button btn32;
    private Button btn33;
    private Label mensaje;
    private TableroTriqui tablero;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TallerTriqui triqui = new TallerTriqui();
        launch(args);
    }

    public void nuevoJuego() {
        btn11.setText("  ");
        btn11.setDisable(false);
        btn11.setEffect(null);
        btn12.setText("  ");
        btn12.setDisable(false);
        btn12.setEffect(null);
        btn13.setText("  ");
        btn13.setDisable(false);
        btn13.setEffect(null);
        btn21.setText("  ");
        btn21.setDisable(false);
        btn21.setEffect(null);
        btn22.setText("  ");
        btn22.setDisable(false);
        btn22.setEffect(null);
        btn23.setText("  ");
        btn23.setDisable(false);
        btn23.setEffect(null);
        btn31.setText("  ");
        btn31.setDisable(false);
        btn31.setEffect(null);
        btn32.setText("  ");
        btn32.setDisable(false);
        btn32.setEffect(null);
        btn33.setText("  ");
        btn33.setDisable(false);
        btn33.setEffect(null);
        mensaje.setText("");
        tablero = new TableroTriqui(9);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        tablero = new TableroTriqui(9);
        
        MenuBar menuBar = new MenuBar();
        Menu menuArchivo = new Menu("Menu");
        
        // Nuevo Juego
        MenuItem nuevoJuego = new MenuItem("Nuevo Juego");
        nuevoJuego.setOnAction((ActionEvent) -> {
            System.out.println("Iniciando Nuevo Juego...");
            nuevoJuego();
        });
        
        // Listar celdas libres
        MenuItem listar = new MenuItem("Listar Celdas Libres");
        listar.setOnAction((ActionEvent) -> {
            listaCeldasLibres();
        });
        
        // Salir
        MenuItem salir = new MenuItem("Salir");
        salir.setOnAction((ActionEvent) -> {
            System.out.println("Chaooo...");
            primaryStage.close();
        });
        
        menuArchivo.getItems().add(nuevoJuego);
        menuArchivo.getItems().add(listar);
        menuArchivo.getItems().add(salir);
        
        menuBar.getMenus().add(menuArchivo);
        
        mensaje = new Label();
        
        GridPane panel = new GridPane();
        panel.setPadding(new Insets(10, 10, 10, 10));
        panel.setMinSize(800, 300);
        panel.setVgap(5);
        panel.setHgap(5);

        btn11 = new Button("  ");
        btn11.setOnAction((ActionEvent)->{
            Celda celda = new Celda(' ', 1, 1);
            
            celdaLlena(celda, btn11);
            
            validarGanador();
            
        });
        
        btn12 = new Button("  ");
        btn12.setOnAction((ActionEvent)->{
            Celda celda = new Celda(' ', 1, 2);
            
            celdaLlena(celda, btn12);
            
            validarGanador();
        });
        
        btn13 = new Button("  ");
        btn13.setOnAction((ActionEvent)->{
            Celda celda = new Celda(' ', 1, 3);
            
            celdaLlena(celda, btn13);
            
            validarGanador();
        });
        
        btn21 = new Button("  ");
        btn21.setOnAction((ActionEvent)->{
            Celda celda = new Celda(' ', 2, 1);
            
            celdaLlena(celda, btn21);
            
            validarGanador();
        });
        
        btn22 = new Button("  ");
        btn22.setOnAction((ActionEvent)->{
            Celda celda = new Celda(' ', 2, 2);
            
            celdaLlena(celda, btn22);
            
            validarGanador();
        });
        
        btn23 = new Button("  ");
        btn23.setOnAction((ActionEvent)->{
            Celda celda = new Celda(' ', 2, 3);
            
            celdaLlena(celda, btn23);
            
            validarGanador();
        });
        
        btn31 = new Button("  ");
        btn31.setOnAction((ActionEvent)->{
            Celda celda = new Celda(' ', 3, 1);
            
            celdaLlena(celda, btn31);
            
            validarGanador();
        });
        
        btn32 = new Button("  ");
        btn32.setOnAction((ActionEvent)->{
            Celda celda = new Celda(' ', 3, 2);
            
            celdaLlena(celda, btn32);
            
            validarGanador();
        });
        
        btn33 = new Button("  ");
        btn33.setOnAction((ActionEvent ActionEvent) -> {
            Celda celda = new Celda(' ', 3, 3);
            
            celdaLlena(celda, btn33);
            
            validarGanador();
        });
        
        panel.add(menuBar, 0, 0);
        panel.add(mensaje, 0, 1);
        panel.add(btn11, 1, 1);
        panel.add(btn12, 2, 1);
        panel.add(btn13, 3, 1);
        panel.add(btn21, 1, 2);
        panel.add(btn22, 2, 2);
        panel.add(btn23, 3, 2);
        panel.add(btn31, 1, 3);
        panel.add(btn32, 2, 3);
        panel.add(btn33, 3, 3);
        
        Scene escena = new Scene(panel, 200, 170);
        
        primaryStage.setScene(escena);
        primaryStage.show();
    }

    private boolean validarGanador() {
        char ganador = tablero.validarGanador();
        
        if (ganador == 'X') {
            mensaje.setText("Gano X!!");
            bloquearBotones();
            return true;
        } else if (ganador == 'O') {
            mensaje.setText("Gano O!!");
            bloquearBotones();
            return true;
        }
        
        if (tablero.getCeldas().size() == 9 && ganador == '-') {
            mensaje.setText("Empate");
            return false;
        }
        
        mensaje.setText("Turno: " + (tablero.isTurno() ? "X" : "O"));
        return false;
    }

    private void bloquearBotones() {
        btn11.setDisable(true);
        btn12.setDisable(true);
        btn13.setDisable(true);
        btn21.setDisable(true);
        btn22.setDisable(true);
        btn23.setDisable(true);
        btn31.setDisable(true);
        btn32.setDisable(true);
        btn33.setDisable(true);
    }

    private void listaCeldasLibres() {
        List<Button> botones = new ArrayList<>();
        btn11.setUserData("(1,1)");
        botones.add(btn11);
        btn12.setUserData("(1,2)");
        botones.add(btn12);
        btn13.setUserData("(1,3)");
        botones.add(btn13);
        btn21.setUserData("(2,1)");
        botones.add(btn21);
        btn22.setUserData("(2,2)");
        botones.add(btn22);
        btn23.setUserData("(2,3)");
        botones.add(btn23);
        btn31.setUserData("(3,1)");
        botones.add(btn31);
        btn32.setUserData("(3,2)");
        botones.add(btn32);
        btn33.setUserData("(3,3)");
        botones.add(btn33);
        tablero.listarCeldasLibres(botones);
    }

    private void celdaLlena(Celda celda, Button boton) {
        
        boolean turno = tablero.jugarCelda(celda);
            
        boton.setText(celda.getValor()+"");
            
        tablero.getCeldas().add(celda);
            
        tablero.setTurno(!turno);
        boton.setDisable(true);
        boton.setEffect(null);
    }
    
}
