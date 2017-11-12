package phrase;

public class Mot implements Syntagme  {

		protected String mot;
		public Mot(String mot) {
			this.mot = mot;
		}
		
		public int hashCode() {
			return this.mot.hashCode();
		}
		
		public boolean equals(Object o) {
			if (o instanceof Mot) {
				return this.mot.equals(((Mot) o).mot);
			} 
			else {
				return false;
			}
		}
		
		public String toString() {
			return this.mot;
		}

		public void affiche() {
			System.out.print(this);
		}
}
