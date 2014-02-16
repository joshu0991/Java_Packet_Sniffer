import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Packet_Sniffer.Packet_Sniffer;
public class Packet_Sniffer_GUI {
	
	Packet_Sniffer sniffer = new Packet_Sniffer();

	public JFrame frame_creater(){
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(700, 700);
		frame.setLocation(400, 200);
		frame.setLayout(new GridLayout(1, 2));
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		return frame;
	}
	
	public JTextField make_text_box(){
		JTextField f = new JTextField();
		return f;
	}
	
	
	public void add_stuff(){
		JFrame a;
		JTextField field;
		a  = frame_creater();
		field = make_text_box();
		a.add(field);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame main_f;
		Packet_Sniffer_GUI g = new Packet_Sniffer_GUI();
		g.add_stuff();
	}

}
