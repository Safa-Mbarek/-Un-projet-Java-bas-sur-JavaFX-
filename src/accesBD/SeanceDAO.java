package accesBD;

import entites.Seance;
import entites.TypeSeance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeanceDAO {
    public List<Seance> chercherNonPayees(String codeMembre) {
       
        List<Seance> seances = new ArrayList<>();
    
        try (Connection connection = SConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM seance WHERE codeMembre = ? AND payee = 0")) {
            preparedStatement.setString(1, codeMembre);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Seance seance = new Seance(codeMembre, false, codeMembre);
                seance.setCodeMembre(resultSet.getString("codeMembre"));
                seance.setPayee(resultSet.getBoolean("payee"));
                seance.setTypeSeance(resultSet.getString("typeSeance"));
                seances.add(seance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seances;
    }
    public double getTarifByType(String typeSeance) {
        double tarif = 0;
        try (Connection connection = SConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT tarif FROM type WHERE type = ?")) {
            preparedStatement.setString(1, typeSeance);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                tarif = resultSet.getDouble("tarif");
            }
        } catch (SQLException e) {
            e.printStackTrace();
           
        }
        return tarif;
    }
 

   
}
