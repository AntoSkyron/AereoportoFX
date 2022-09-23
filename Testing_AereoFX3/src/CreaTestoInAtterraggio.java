import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class CreaTestoInAtterraggio {

	static String NOME_FILE = "atterraggi_incorso.txt";
	private String ID,Provenienza;

	BufferedReader inputTastiera;
	PrintWriter printer;
	BufferedWriter input;
	FileWriter fileWriter;


	public CreaTestoInAtterraggio(String ID,String Provenienza) {
		try {
			this.ID=ID;
			this.Provenienza=Provenienza;

			inputTastiera = new BufferedReader(new InputStreamReader( System.in ) );

			apri();

			DatiAereoInAtterraggio dl;

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


	DatiAereoInAtterraggio acquisisci() throws IOException {
		DatiAereoInAtterraggio dl = new DatiAereoInAtterraggio();

		dl.setID(ID);
		dl.setProvenienza(Provenienza);

		return dl;
	}


	void scrivi( DatiAereoInAtterraggio dl ) throws IOException {
		String record = dl.toRecord();
		printer.println( record );
	}







}
