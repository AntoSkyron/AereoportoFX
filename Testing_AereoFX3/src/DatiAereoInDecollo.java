import java.util.StringTokenizer;


public class DatiAereoInDecollo{

	private String ID,destinazione;

	public DatiAereoInDecollo(){}

	public DatiAereoInDecollo(String linea){
		StringTokenizer st = new StringTokenizer( linea , ";");

		if(st.hasMoreTokens() )
		{
			ID = st.nextToken();
		}if(st.hasMoreTokens())
		{
			destinazione = st.nextToken();
		}
	}


	String toRecord(){
		return ID + ";" + destinazione;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getdestinazione() {
		return destinazione;
	}

	public void setdestinazione(String destinazione) {
		this.destinazione = destinazione;
	}











}
