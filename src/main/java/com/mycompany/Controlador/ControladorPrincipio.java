package com.mycompany.Controlador;

import com.mycompany.mavenproject1.Main;
import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControladorPrincipio {

    public void Cambiar_Pantalla(ActionEvent action) throws IOException {
        String id_boton = "";
        id_boton = ((Button) action.getSource()).getId();
        Main main = new Main();
        main.Cambiar_Pantalla(id_boton);
    }
}
