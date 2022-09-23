import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class CreaTestoInDecollo {

	static String NOME_FILE = "decolli_incorso.txt";
	private String ID,Destinazione;

	BufferedReader inputTastiera;
	PrintWriter printer;
	BufferedWriter input;
	FileWriter fileWriter;


	public CreaTestoInDecollo(String ID,String Destinazione) {
		try {
			this.ID=ID;
			this.Destinazione=Destinazione;

			inputTastiera = new BufferedReader(new InputStreamReader( System.in ) );

			apri();

			DatiAereoInDecollo dl;

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


	DatiAereoInDecollo acquisisci() throws IOException {
		DatiAereoInDecollo dl = new DatiAereoInDecollo();

		dl.setID(ID);
		dl.setdestinazione(Destinazione);

		return dl;
	}


	void scrivi( DatiAereoInDecollo dl ) throws IOException {
		String record = dl.toRecord();
		printer.println( record );
	}







}
