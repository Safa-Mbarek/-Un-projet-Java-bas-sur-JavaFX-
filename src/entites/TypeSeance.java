package entites;

public class TypeSeance {
	   private String type;
	    private double tarif;
	    
		public TypeSeance(String type, double tarif) {
			super();
			this.type = type;
			this.tarif = tarif;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public double getTarif() {
			return tarif;
		}
		public void setTarif(double tarif) {
			this.tarif = tarif;
		}
	    
}
