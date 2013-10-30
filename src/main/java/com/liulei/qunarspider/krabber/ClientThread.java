package com.liulei.qunarspider.krabber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.Vector;


public class ClientThread extends Thread {
	Socket socket;
	BufferedReader in;
	PrintWriter out;
	Vector<String> vStr = new Vector<String>();

	public ClientThread(String serverAddr, int serverPort) {
		try {
			socket = new Socket(serverAddr, serverPort);
			in = new BufferedReader(new InputStreamReader(socket
					.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);

		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void run(){
		//ClientThread client = new ClientThread("127.0.0.1",8890);
		System.out.println("Vector<String> str size:" + vStr.size());
		for (int i = 0; i < vStr.size(); ++i) {
			this.SendString(vStr.get(i));
		}
		this.Close();
	}
	
	public void AddString(String str){
		vStr.add(str);
	}
	
	public void AddAllStrings(Vector<String> allStr){
		this.vStr.addAll(allStr);
	}
	
	protected void SendString(String str) {

		String tmp;
		try {
			out.print(str);
			out.flush();

			tmp = in.readLine();
			if (null != tmp) {
				if (tmp.compareTo("received")==0) {
					System.out.println("Send to server successfully");
				} else {
					System.out
							.println("Unexcepted string received from server: "
									+ tmp);
				}
			}
		} catch (SocketException e){
			//e.printStackTrace();
			this.Close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void Close(){
		SendString("shutdown");
		if(null!=out){
			out.close();
			out = null;
		}
		if(null!=in){
			try {
				in.close();
				in = null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(null!=socket){
			try {
				socket.close();
				socket = null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
