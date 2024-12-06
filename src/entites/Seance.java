package entites;

public class Seance {
	  private String codeMembre;
	    private boolean payee;
	    private String typeSeance;
	    
		public Seance(String codeMembre, boolean payee, String typeSeance) {
			super();
			this.codeMembre = codeMembre;
			this.payee = payee;
			this.typeSeance = typeSeance;
		}
		public String getCodeMembre() {
			return codeMembre;
		}
		public void setCodeMembre(String codeMembre) {
			this.codeMembre = codeMembre;
		}
		public boolean isPayee() {
			return payee;
		}
		public void setPayee(boolean payee) {
			this.payee = payee;
		}
		public String getTypeSeance() {
			return typeSeance;
		}
		public void setTypeSeance(String typeSeance) {
			this.typeSeance = typeSeance;
		}


}
