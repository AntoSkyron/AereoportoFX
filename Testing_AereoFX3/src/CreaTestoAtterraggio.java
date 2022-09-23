import java.io.*;

public class CreaTestoAtterraggio {

	static String NOME_FILE = "Lista Aerei Atterrati.txt";
	private String ID,Provenienza;

	BufferedReader inputTastiera;
	PrintWriter printer;
	BufferedWriter input;
	FileWriter fileWriter;


	public CreaTestoAtterraggio(String ID,String Provenienza) {
		try {
			this.ID=ID;
			this.Provenienza=Provenienza;

			inputTastiera = new BufferedReader(new InputStreamReader( System.in ) );

			apri();

			DatiAereoAtterraggio dl;

			dl = acquisisci();
			scrivi(dl);

			chiudi();

		}
		catch( FileNotFoundException fe )
		{
			System.err.println(
				"Nella directory corrente esiste gia' il file "
				+ NOME_FILE +
				" ma non puo' essere aperto in scrittura "+
				"(forse e' una directory?)");
			fe.printStackTrace();
		}
		catch( IOException ex )
		{
			System.err.println(
				"Si e'verificato un generico errore di I/O ");
			ex.printStackTrace();
		}
	}


	void apri() throws FileNotFoundException, IOException {
		fileWriter = new FileWriter( NOME_FILE,true );
		input = new BufferedWriter(fileWriter);
		printer = new PrintWriter(input);

	}


	void chiudi() throws IOException {
		printer.flush();
		printer.close();

	}


	DatiAereoAtterraggio acquisisci() throws IOException {
		DatiAereoAtterraggio dl = new DatiAereoAtterraggio();

		dl.setID(ID);
		dl.setProvenienza(Provenienza);

		return dl;
	}


	void scrivi( DatiAereoAtterraggio dl ) throws IOException {
		String record = dl.toRecord();
		printer.println( record );
	}







}
