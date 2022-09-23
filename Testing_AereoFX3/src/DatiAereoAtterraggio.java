import java.util.*;


public class DatiAereoAtterraggio {

	private String ID,provenienza;

	public DatiAereoAtterraggio(){}

	public DatiAereoAtterraggio(String linea){
		StringTokenizer st = new StringTokenizer( linea , ";");

		if(st.hasMoreTokens() )
		{
			ID = st.nextToken();
		}if(st.hasMoreTokens())
		{
			provenienza = st.nextToken();
		}
	}


	String toRecord(){
		return ID + ";" + provenienza;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getProvenienza() {
		return provenienza;
	}

	public void setProvenienza(String provenienza) {
		this.provenienza = provenienza;
	}











}
