package newThread.thread;

import java.io.IOException;

import Packet_Sniffer.Packet_Sniffer;

//sets up a thread 
public class Packet_Sniffer_Thread implements Runnable {
	// new instance of packet_sniffer
	Packet_Sniffer ps = new Packet_Sniffer();
	Thread thr;

	// //Constructor
	Packet_Sniffer_Thread() {
		thr = new Thread(this, "Sniffer");
		thr.start();
	}

	// new instance of Packet sniffer which calls the run method
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Packet_Sniffer_Thread();
	}

	@Override
	public void run() {
		try {
			ps.Sniff_Packets();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
