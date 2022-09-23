import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import java.io.File;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class AirportController implements Initializable{


	Buffer coda_atterra;
	Buffer coda_decolla;
	Thread t1,t2,t3,t4;

	@FXML
	private ImageView AereoCheAtterra;

	@FXML
	private Text AereoCheStaDecollando;

	@FXML
	private Text AereoCheStaAtterrando;

	@FXML
	private Text Provenienza;

	@FXML
	private Text Destinazione;


	@FXML
	private ImageView AereoCheDecolla;


    @FXML // fx:id="atterra_id"
    private TextField atterra_id; // Value injected by FXMLLoader

    @FXML // fx:id="decollo_id"
    private TextField decollo_id; // Value injected by FXMLLoader

    @FXML // fx:id="quantita_attesa_aerei"
    private Text quantita_attesa_aerei; // Value injected by FXMLLoader

    @FXML // fx:id="quantita_decollati_aerei"
    private Text quantita_decollati_aerei; // Value injected by FXMLLoader

    @FXML // fx:id="quantita_atterrati_aereo"
    private Text quantita_atterrati_aereo; // Value injected by FXMLLoader

    @FXML // fx:id="decollo_botton"
    private Rectangle decollo_botton; // Value injected by FXMLLoader

    @FXML // fx:id="atterraggio_botton"
    private Rectangle atterraggio_botton; // Value injected by FXMLLoader

    @FXML // fx:id="inserisci_atterra_scritta"
    private Text inserisci_atterra_scritta; // Value injected by FXMLLoader

    @FXML // fx:id="inserisci_decollo_scritta"
    private Text inserisci_decollo_scritta; // Value injected by FXMLLoader


    @Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		coda_atterra = new Buffer(5);
		coda_decolla = new Buffer(5);
		t1 = new Thread(new Consumatore(coda_atterra,AereoCheAtterra,AereoCheStaAtterrando,Provenienza));
		t2 = new Thread(new Consumatore2(coda_decolla,AereoCheDecolla,AereoCheStaDecollando,Destinazione));
		t1.start();
		t2.start();
	}



    public void InvioID_Atterra()
    {
    	String id = atterra_id.getText();

    	if(id.equals("")){
		Alert alert = new Alert(AlertType.INFORMATION, "Uno o più campi mancanti. Errore", ButtonType.OK);
		alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
		alert.setTitle("Aeroporto");
		alert.show();
		}
    	else
    	{
    		coda_atterra.aggiungi(new Aereo(id));
    		atterra_id.setText("");
    	}
    }


    public void InvioID_Decolla()
    {
    	String id = decollo_id.getText();

    	if(id.equals("")){
		Alert alert = new Alert(AlertType.INFORMATION, "Uno o più campi mancanti. Errore", ButtonType.OK);
		alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
		alert.setTitle("Aeroporto");
		alert.show();
		}
    	else
    	{
    		coda_decolla.aggiungi(new Aereo(id));
    		decollo_id.setText("");

    	}
    }


}





class Consumatore implements Runnable
{
	Buffer coda;
	Random random;
	ImageView AereoCheAtterra;
	Text AereoCheStaAtterrando;
	Text Provenienza;

	String[] Citylist = { "Hong Kong", "Nairobi", "Tokyo" , "Berlino" , "Lisbona", "Rio" , "Helsinki"
			, "Bogotà" , "Oslo" , "Denver" , "Mosca", "Stoccolma" , "Palermo" , "Marsiglia", "Roma" , "Bari" ,
			"Napoli" , "New York" , "Monaco di Baviera" , "Firenze" , "Torino" , "Parigi" , "Madrid" , "Barcellona" ,
			"Genova", "Milano" , "Reggio Calabria" , "Cagliari" , "Ancona" , "San Francisco" , "Bruxelles", "Varsavia" ,
			"Budapest" , "Praga" , "Londra" , "Manchester" , "Liverpool" , "Valencia" , "Stanford" , "Pyeongyang" ,
			"Buenos Aires" , "Sydney" , "Miami" , "Los Angeles" , "Washington" , "Abu Dhabi", "Dubai" , "Nuova Delhi",
			"Pechino" , "Bologna" , "Brindisi" , "Cracovia" , "Vienna" , "Amsterdam" };


	public Consumatore(Buffer coda,ImageView AereoCheAtterra,Text AereoCheStaAtterrando,Text Provenienza)
	{
		this.coda=coda;
		this.AereoCheAtterra=AereoCheAtterra;
		this.AereoCheStaAtterrando=AereoCheStaAtterrando;
		this.Provenienza=Provenienza;
		random = new Random();

	}

	@Override
	public void run() {
		while(true){
			Aereo a = coda.AtterraDecolla();
			try
			{
				String bip2 = "atterra.mp3";
				Media hit2 = new Media(new File(bip2).toURI().toString());
				MediaPlayer mediaPlayer2 = new MediaPlayer(hit2);


				String bip = "rumore.mp3";
				Media hit = new Media(new File(bip).toURI().toString());
				MediaPlayer mediaPlayer = new MediaPlayer(hit);

				int idx = new Random().nextInt(Citylist.length);
				String citta = (Citylist[idx]);


				AereoCheStaAtterrando.setText("Aereo " + a.getId() + "  Atterraggio");
				Provenienza.setText("PROV. :  " + citta);

				@SuppressWarnings("unused")
				CreaTestoAtterraggio f = new CreaTestoAtterraggio(a.getId(),citta);
				@SuppressWarnings("unused")
				CreaTestoInAtterraggio l = new CreaTestoInAtterraggio(a.getId(),citta);

				AereoCheAtterra.setVisible(true);
				mediaPlayer2.play();
				AereoCheAtterra.setLayoutX(1290);
				AereoCheAtterra.setLayoutY(27);
				Thread.sleep(1000);
				AereoCheAtterra.setLayoutX(1217);
				AereoCheAtterra.setLayoutY(62);
				Thread.sleep(1000);
				AereoCheAtterra.setLayoutX(1138);
				AereoCheAtterra.setLayoutY(96);
				Thread.sleep(1000);
				AereoCheAtterra.setLayoutX(1138);
				AereoCheAtterra.setLayoutY(96);
				mediaPlayer.play();
				Thread.sleep(1000);
				mediaPlayer.stop();
				AereoCheAtterra.setLayoutX(1058);
				AereoCheAtterra.setLayoutY(138);
				Thread.sleep(1000);
				AereoCheAtterra.setLayoutX(974);
				AereoCheAtterra.setLayoutY(166);
				Thread.sleep(500);
				AereoCheAtterra.setLayoutX(898);
				AereoCheAtterra.setLayoutY(201);
				Thread.sleep(1000);
				AereoCheAtterra.setLayoutX(824);
				AereoCheAtterra.setLayoutY(229);
				Thread.sleep(1000);
				AereoCheAtterra.setLayoutX(758);
				AereoCheAtterra.setLayoutY(252);
				Thread.sleep(1000);
				AereoCheAtterra.setLayoutX(700);
				AereoCheAtterra.setLayoutY(274);
				Thread.sleep(1000);
				AereoCheAtterra.setLayoutX(638);
				AereoCheAtterra.setLayoutY(297);
				Thread.sleep(1000);
				AereoCheAtterra.setLayoutX(593);
				AereoCheAtterra.setLayoutY(311);
				Thread.sleep(500);
				AereoCheAtterra.setLayoutX(1290);
				AereoCheAtterra.setLayoutY(27);


			}catch (InterruptedException ex)
			{
				System.err.print("Interrupted Exception");
			}

			AereoCheAtterra.setVisible(false);
			AereoCheStaAtterrando.setText("");
			Provenienza.setText("");
		}
	}
}




class Consumatore2 implements Runnable
{
	Buffer coda;
	Random random;
	ImageView AereoCheDecolla;
	Text AereoCheStaDecollando;
	Text Destinazione;



	String[] Citylist = { "Hong Kong", "Nairobi", "Tokyo" , "Berlino" , "Lisbona", "Rio" , "Helsinki"
			, "Bogotà" , "Oslo" , "Denver" , "Mosca", "Stoccolma" , "Palermo" , "Marsiglia", "Roma" , "Bari" ,
			"Napoli" , "New York" , "Monaco di Baviera" , "Firenze" , "Torino" , "Parigi" , "Madrid" , "Barcellona" ,
			"Genova", "Milano" , "Reggio Calabria" , "Cagliari" , "Ancona" , "San Francisco" , "Bruxelles", "Varsavia" ,
			"Budapest" , "Praga" , "Londra" , "Manchester" , "Liverpool" , "Valencia" , "Stanford" , "Pyeongyang" ,
			"Buenos Aires" , "Sydney" , "Miami" , "Los Angeles" , "Washington" , "Abu Dhabi","Dubai" , "Nuova Delhi",
			"Pechino" , "Bologna" , "Brindisi" , "Cracovia" , "Vienna" , "Amsterdam" };


	public Consumatore2(Buffer coda,ImageView AereoCheDecolla,Text AereoCheStaDecollando,Text Destinazione)
	{
		this.coda=coda;
		random = new Random();
		this.AereoCheDecolla=AereoCheDecolla;
		this.AereoCheStaDecollando=AereoCheStaDecollando;
		this.Destinazione=Destinazione;
	}

	@Override
	public void run() {
		while(true){
			Aereo a = coda.AtterraDecolla();
			 // QUI DEVE INIZIARE LA ANIMAZIONE
			try
			{
				String bip2 = "decolla.mp3";
				Media hit2 = new Media(new File(bip2).toURI().toString());
				MediaPlayer mediaPlayer2 = new MediaPlayer(hit2);
				String bip = "rumore.mp3";
				Media hit = new Media(new File(bip).toURI().toString());
				MediaPlayer mediaPlayer = new MediaPlayer(hit);

			AereoCheStaDecollando.setText("Aereo " + a.getId() + "  Decollo");

			int idx = new Random().nextInt(Citylist.length);
			String citta = (Citylist[idx]);
			@SuppressWarnings("unused")
			CreaTestoDecollo l = new CreaTestoDecollo(a.getId(),citta);
			@SuppressWarnings("unused")
			CreaTestoInDecollo d = new CreaTestoInDecollo(a.getId(),citta);
			Destinazione.setText("DEST. :   " + citta);
			AereoCheDecolla.setVisible(true);

			mediaPlayer2.play();
			AereoCheDecolla.setLayoutX(626);
			AereoCheDecolla.setLayoutY(444);
			mediaPlayer.play();
			Thread.sleep(1000);
			AereoCheDecolla.setLayoutX(648);
			AereoCheDecolla.setLayoutY(466);
			Thread.sleep(555);
			AereoCheDecolla.setLayoutX(693);
			AereoCheDecolla.setLayoutY(452);
			Thread.sleep(555);
			AereoCheDecolla.setLayoutX(738);
			AereoCheDecolla.setLayoutY(438);
			Thread.sleep(555);
			AereoCheDecolla.setLayoutX(783);
			AereoCheDecolla.setLayoutY(424);
			Thread.sleep(555);
			AereoCheDecolla.setLayoutX(828);
			AereoCheDecolla.setLayoutY(407);
			Thread.sleep(555);
			AereoCheDecolla.setLayoutX(873);
			AereoCheDecolla.setLayoutY(393);
			Thread.sleep(555);
			AereoCheDecolla.setLayoutX(918);
			AereoCheDecolla.setLayoutY(379);
			Thread.sleep(555);
			AereoCheDecolla.setLayoutX(963);
			AereoCheDecolla.setLayoutY(365);
			Thread.sleep(555);
			AereoCheDecolla.setLayoutX(1008);
			AereoCheDecolla.setLayoutY(351);
			Thread.sleep(555);
			AereoCheDecolla.setLayoutX(1053);
			AereoCheDecolla.setLayoutY(341);
			Thread.sleep(555);
			AereoCheDecolla.setLayoutX(1098);
			AereoCheDecolla.setLayoutY(327);
			Thread.sleep(555);
			AereoCheDecolla.setLayoutX(1132);
			AereoCheDecolla.setLayoutY(301);
			Thread.sleep(555);
			AereoCheDecolla.setLayoutX(1162);
			AereoCheDecolla.setLayoutY(273);
			Thread.sleep(555);
			Thread.sleep(555);
			AereoCheDecolla.setLayoutX(1207);
			AereoCheDecolla.setLayoutY(245);
			Thread.sleep(555);
			AereoCheDecolla.setLayoutX(1252);
			AereoCheDecolla.setLayoutY(217);
			Thread.sleep(555);
			AereoCheDecolla.setLayoutX(1297);
			AereoCheDecolla.setLayoutY(195);
			Thread.sleep(555);
			mediaPlayer2.stop();

			}catch (InterruptedException ex)
			{
				System.err.print("Interrupted Exception");
			}
			AereoCheDecolla.setVisible(false);
			AereoCheStaDecollando.setText("");
			Destinazione.setText("");
			}
	}
}

