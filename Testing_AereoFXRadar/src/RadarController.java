import java.io.File;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;

public class RadarController implements Initializable{

    @FXML
    private Text ID1;

    @FXML
    private ImageView AtterraImmagine;

    @FXML
    private ImageView DecolloImmagine;

    @FXML
    private Text id_destinazione;

    @FXML
    private Text id_provenienza;

    @FXML
    private Text ID2;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}


	public void Refresh(){


		Scanner x;
		File file1 = new File("C:/Users/Il Maresciallo/Desktop/Testing_AereoFX3/atterraggi_incorso.txt");
		String ID=null,Provenienza = null;

		try{

		x = new Scanner(file1);
		x.useDelimiter("[;\n]");

		ID = x.next();
		Provenienza = x.next();

		x.close();
		file1.delete();
		}
		catch(Exception e )	{
			Alert alert = new Alert(AlertType.ERROR, "ERRORE", ButtonType.OK);
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			alert.setTitle("Radar");
			alert.show();
		}

		Thread t1 = new Thread(new Consumatore(ID1,id_provenienza,AtterraImmagine,ID,Provenienza));
		t1.start();

	}

	class Consumatore2 implements Runnable{

		//Fase 1
		int[] CoordinateX = new int[]{41,74,124,171,207};
		int[] CoordinateY = new int[]{166,203,215,199,164};
		//Fase 2
		int[] CoordinateX_1= new int[]{55,86,123,164,191};
		int[] CoordinateY_1= new int[]{154,185,194,186,159};
		//Fase 3
		int[] CoordinateX_2= new int[]{75,91,126,154,174};
		int[] CoordinateY_2= new int[]{147,169,178,171,149};

		int[] CoordinateX_3= new int[]{91,104,124,145,159};
		int[] CoordinateY_3= new int[]{139,154,156,155,138};
		//Fase 4
		int[] CoordinateX_4= new int[]{107,111,125,135,144};
		int[] CoordinateY_4= new int[]{132,139,142,137,132};
		//Fase 5
		int[] CoordinateX_5= new int[]{123,126,126,126,126};
		int[] CoordinateY_5= new int[]{119,120,120,120,120};

		Text ID2;
		Text id_destinazione;
		ImageView DecolloImmagine;
		String ID;
		String Destinazione;

		public Consumatore2(Text ID2,Text id_destinazione,ImageView DecolloImmagine,String ID,String Destinazione)
		{
			this.ID2=ID2;
			this.id_destinazione=id_destinazione;
			this.DecolloImmagine=DecolloImmagine;
			this.ID=ID;
			this.Destinazione=Destinazione;
		}


		@Override
		public void run() {
			try
			{
				int idx = new Random().nextInt(CoordinateX.length);

				ID2.setText("  " + ID);
				id_destinazione.setText("  " + Destinazione);
				DecolloImmagine.setVisible(true);
				DecolloImmagine.setLayoutX(CoordinateX_5[idx]);
				DecolloImmagine.setLayoutY(CoordinateY_5[idx]);
				Thread.sleep(1500);
				DecolloImmagine.setVisible(false);
				Thread.sleep(200);
				DecolloImmagine.setLayoutX(CoordinateX_4[idx]);
				DecolloImmagine.setLayoutY(CoordinateY_4[idx]);
				Thread.sleep(1500);
				DecolloImmagine.setVisible(false);
				Thread.sleep(200);
				DecolloImmagine.setVisible(true);
				DecolloImmagine.setLayoutX(CoordinateX_3[idx]);
				DecolloImmagine.setLayoutY(CoordinateY_3[idx]);
				Thread.sleep(1500);
				DecolloImmagine.setVisible(false);
				Thread.sleep(200);
				DecolloImmagine.setVisible(true);
				DecolloImmagine.setLayoutX(CoordinateX_2[idx]);
				DecolloImmagine.setLayoutY(CoordinateY_2[idx]);
				Thread.sleep(1500);
				DecolloImmagine.setVisible(false);
				Thread.sleep(200);
				DecolloImmagine.setVisible(true);
				DecolloImmagine.setLayoutX(CoordinateX_1[idx]);
				DecolloImmagine.setLayoutY(CoordinateY_1[idx]);
				Thread.sleep(1500);
				DecolloImmagine.setVisible(false);
				Thread.sleep(200);
				DecolloImmagine.setVisible(true);
				DecolloImmagine.setLayoutX(CoordinateX[idx]);
				DecolloImmagine.setLayoutY(CoordinateY[idx]);
				Thread.sleep(1500);
			}catch(InterruptedException FileNotFoundException )
			{
				System.err.print("Interrupted Exception");

			}
			DecolloImmagine.setVisible(false);
			ID2.setText("");
			id_destinazione.setText("");
		}


	}



	class Consumatore implements Runnable{

		// Prima Fase
		int[] CoordinateX = new int[]{35,48,79,126,174,209,219};
		int[] CoordinateY = new int[]{121,75,45,33,45,80,123};
		//Seconda Fase
		int[] CoordinateX_1 = new int[]{50,59,91,128,167,196,205};
		int[] CoordinateY_1 = new int[]{121,86,57,47,59,83,122};
		//Terza Fase
		int[] CoordinateX_2 = new int[]{69,77,98,127,156,177,185};
		int[] CoordinateY_2 = new int[]{123,96,76,69,78,96,123};
		//Quarta Fase
		int[] CoordinateX_3 = new int[]{89,92,106,127,147,160,167};
		int[] CoordinateY_3 = new int[]{123,103,89,87,90,104,123};
		//Quinta Fase
		int[] CoordinateX_4 = new int[]{108,110,118,126,135,143,146};
		int[] CoordinateY_4 = new int[]{123,112,107,102,105,112,123};
		//Fase Finale
		int[] CoordinateX_5 = new int[]{125,125,125,125,125,125,123};
		int[] CoordinateY_5 = new int[]{123,123,123,123,123,123,123};

		Text ID1;
		Text id_provenienza;
		ImageView AtterraImmagine;
		String ID;
		String Provenienza;


		public Consumatore(Text ID1,Text id_provenienza,ImageView AtterraImmagine,String ID, String Provenienza)
		{
			this.ID1 = ID1;
			this.id_provenienza=id_provenienza;
			this.AtterraImmagine=AtterraImmagine;
			this.ID=ID;
			this.Provenienza=Provenienza;
		}



		@Override
		public void run() {
			// TODO Auto-generated method stub
		try
		{
			int idx = new Random().nextInt(CoordinateX.length);

			ID2.setText("  " + ID);
			id_provenienza.setText("  " + Provenienza);
			AtterraImmagine.setVisible(true);
			AtterraImmagine.setLayoutX(CoordinateX[idx]);
			AtterraImmagine.setLayoutY(CoordinateY[idx]);
			Thread.sleep(1000);
			AtterraImmagine.setVisible(false);
			Thread.sleep(200);
			AtterraImmagine.setLayoutX(CoordinateX_1[idx]);
			AtterraImmagine.setLayoutY(CoordinateY_1[idx]);
			Thread.sleep(1000);
			AtterraImmagine.setVisible(false);
			Thread.sleep(200);
			AtterraImmagine.setVisible(true);
			AtterraImmagine.setLayoutX(CoordinateX_2[idx]);
			AtterraImmagine.setLayoutY(CoordinateY_2[idx]);
			Thread.sleep(1000);
			AtterraImmagine.setVisible(false);
			Thread.sleep(200);
			AtterraImmagine.setVisible(true);
			AtterraImmagine.setLayoutX(CoordinateX_3[idx]);
			AtterraImmagine.setLayoutY(CoordinateY_3[idx]);
			Thread.sleep(1000);
			AtterraImmagine.setVisible(false);
			Thread.sleep(200);
			AtterraImmagine.setVisible(true);
			AtterraImmagine.setLayoutX(CoordinateX_4[idx]);
			AtterraImmagine.setLayoutY(CoordinateY_4[idx]);
			Thread.sleep(1000);
			AtterraImmagine.setVisible(false);
			Thread.sleep(200);
			AtterraImmagine.setVisible(true);
			AtterraImmagine.setLayoutX(CoordinateX_5[idx]);
			AtterraImmagine.setLayoutY(CoordinateY_5[idx]);
			Thread.sleep(1000);
		}catch(InterruptedException FileNotFoundException )
		{
			System.err.print("Interrupted Exception");

		}
		AtterraImmagine.setVisible(false);
		ID2.setText("");
		id_provenienza.setText("");

	}




	}


	public void Refresh2(){

		Scanner y;
		String nomefile2 = "C:/Users/Il Maresciallo/Desktop/Testing_AereoFX3/decolli_incorso.txt";
		File file2 = new File(nomefile2);
		String ID_ = null,Destinazione_ = null;

		try{

		y = new Scanner(file2);
		y.useDelimiter("[;\n]");

		ID_ = y.next();
		Destinazione_ = y.next();

		y.close();
		file2.delete();
		}catch(Exception e )	{
			Alert alert = new Alert(AlertType.ERROR, "Errore!\n1.Forse hai sbagliato la directory dei file\n2.I file contenenti gli atterraggi e/o i decolli sono vuoti", ButtonType.OK);
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			alert.setTitle("Radar");
			alert.show();
		}

		Thread t2 = new Thread(new Consumatore2(ID1,id_destinazione,DecolloImmagine,ID_,Destinazione_));
		t2.start();

	}








}
