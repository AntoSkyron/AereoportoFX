

import java.util.LinkedList;


public class Buffer {

	private LinkedList<Aereo> coda;
	int capacita;

	public Buffer(int capacita)
	{
		coda = new LinkedList<>();
		this.capacita=capacita;
	}

	public synchronized boolean isEmpty()
	{
		return coda.isEmpty();
	}


	public synchronized boolean isFull(){
		return coda.size() >= capacita;
	}


	public synchronized void aggiungi(Aereo a)
	{
		while(isFull()){
			try{
			wait();
			}
			catch(InterruptedException ex){
				System.err.println("Interrupted Exception");
			}
		}

		coda.add(a);
		notifyAll();
	}

	public synchronized Aereo AtterraDecolla(){

		while(isEmpty()){
			try{
				wait();
			}catch (InterruptedException ex){
				System.err.println("Interrupted Exception");
			}
		}

		notifyAll();
		return coda.removeFirst();
	}

}
