

public class Aereo {

	private String destinazione;
	private String provenienza;
	private String id;

	public Aereo(String destinazione, String id){
		this.destinazione=destinazione;
		this.id=id;
	}


	public Aereo(String id)
	{
		this.id=id;
	}


	public Aereo(String provenienza,String id, int s)
	{
		this.provenienza=provenienza;
		this.id=id;
	}


	public String getDestinazione() {
		return destinazione;
	}


	public void setDestinazione(String destinazione) {
		this.destinazione = destinazione;
	}


	public String getProvenienza() {
		return provenienza;
	}


	public void setProvenienza(String provenienza) {
		this.provenienza = provenienza;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
}
