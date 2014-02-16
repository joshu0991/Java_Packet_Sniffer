package Packet_Sniffer;

import jpcap.*;
import jpcap.packet.Packet;
import java.io.*;
import java.util.*;

public class Packet_Sniffer implements PacketReceiver {

	// sets up array of devices
	static NetworkInterface[] dev = JpcapCaptor.getDeviceList();
	static JpcapCaptor captor;

	// gets all network interfaces
	public void get_interfaces() {
		for (int i = 0; i < dev.length; i++) {

			// names and descriotions
			System.out.println(i + ":" + dev[i].name + "(" + dev[i].description
					+ ")");

			// datalink and decsiptions
			System.out.println("datalink: " + dev[i].datalink_name + "("
					+ dev[i].datalink_description + ")");

			// MAC Address
			System.out.println("Mac Address: ");
			for (byte b : dev[i].mac_address)
				System.out.print(Integer.toHexString(b & 0xff) + ":");
			System.out.println();

			// IP Address and Subnet mask
			for (NetworkInterfaceAddress a : dev[i].addresses)
				System.out.println(" address:" + a.address + " " + a.subnet
						+ " " + a.broadcast);

		}

	}

	// all pieces of program to sniff packets and get network interfaces
	public void Sniff_Packets() throws IOException {
		Scanner scan = new Scanner(System.in);
		get_interfaces();
		int input_interface;
		System.out
				.println("Which interface would you like to capture pacets from? ");
		input_interface = scan.nextInt();

		try {
			captor = JpcapCaptor.openDevice(dev[input_interface], 65535, true,
					20);
			System.out.println("Working");
		} catch (IOException e) {
			e.printStackTrace();
		}

		captor.setFilter("tcp and ip", true);

		captor.loopPacket(-1, new Packet_Sniffer());
		scan.close();
	}

	// prints packet
	public void receivePacket(Packet packet) {
		try {
			JpcapWriter writer = JpcapWriter.openDumpFile(captor, "out.txt");
			writer.writePacket(packet);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(packet);
	}

	// packet sniffer is in packet_Sniffer_Thread
	public static void main(String[] args) throws IOException {

	}

}
