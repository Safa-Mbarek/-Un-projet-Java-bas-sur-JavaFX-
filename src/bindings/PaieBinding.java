package bindings;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import accesBD.SConnection;
import accesBD.SeanceDAO;
import entites.Seance;
import entites.TypeSeance;

public class PaieBinding {
	 private String codeM;
	    private int nbre;
	    private double sommeDue;
	    private String details;
		public String getCodeM() {
			return codeM;
		}
		public void setCodeM(String codeM) {
			this.codeM = codeM;
		}
		public int getNbre() {
			return nbre;
		}
		public void setNbre(int nbre) {
			this.nbre = nbre;
		}
		public double getSommeDue() {
			return sommeDue;
		}
		public void setSommeDue(double sommeDue) {
			this.sommeDue = sommeDue;
		}
		public String getDetails() {
			return details;
		}
		public void setDetails(String details) {
			this.details = details;
		}
		
		public String serialiser(List<Seance> liste) {
		    StringBuilder sb = new StringBuilder();
		    SeanceDAO seanceDAO = new SeanceDAO();
		    for (Seance seance : liste) {
		        double tarif = seanceDAO.getTarifByType(seance.getTypeSeance()); // Obtenez le tarif de la séance
		        sb.append("1 séance(s) de ").append(seance.getTypeSeance()).append(" à ").append(tarif).append(" TND la séance.\n");
		    }
		    return sb.toString();
		}
		
		public void chercher() {
		    if (codeM == null || codeM.isEmpty()) {
		        System.out.println("Code membre non spécifié.");
		        return;
		    }

		    seancesNonPayees = new ArrayList<>();

		    try (Connection connection = SConnection.getConnection();
		         PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM seance WHERE codeMembre = ? AND payee = 0")) {
		        preparedStatement.setString(1, codeM);
		        ResultSet resultSet = preparedStatement.executeQuery();
		        while (resultSet.next()) {
		            Seance seance = new Seance();
		            seance.setCodeMembre(resultSet.getString("codeMembre"));
		            seance.setPayee(resultSet.getBoolean("payee"));
		            seance.setTypeSeance(resultSet.getString("typeSeance"));
		            seancesNonPayees.add(seance);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}





}
