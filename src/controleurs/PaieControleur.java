package controleurs;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.List;

import accesBD.SeanceDAO;
import entites.Seance;

public class PaieControleur {
    @FXML
    private TextField txtCode;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtSomme;
    @FXML
    private TextField txtDetails;
    @FXML
    private Button btnCalculer;

    @FXML
    public void initialize() {
        // Disable editing for result fields
        txtNombre.setEditable(false);
        txtSomme.setEditable(false);
        txtDetails.setEditable(false);
    }

    @FXML
    String codeMembre = txtCode.getText();
    
    
    if (codeMembre == null || codeMembre.isEmpty()) {
        System.out.println("Veuillez saisir un code de membre.");
        return;
    }
    
    paieBinding.setCodeM(codeMembre);
    
    paieBinding.chercher();
    
    lblNbre.setText(String.valueOf(paieBinding.getNbre()));
    lblSommeDue.setText(String.valueOf(paieBinding.getSommeDue()));
    lblDetails.setText(paieBinding.getDetails());
}
   

}
