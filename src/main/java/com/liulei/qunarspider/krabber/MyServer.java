package com.liulei.qunarspider.krabber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

class MyServer{

	private Socket Server = null;
	private ServerSocket serverSocket = null;
	private BufferedReader in = null;
	private PrintWriter out = null;
	//private Vector<String> vStr = new Vector<String>();
	
	public MyServer(int port){
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Connect(){
		if(Server!=null || in!=null || out!=null){
			return;
		}
		try {
			System.out.println("accepting a client on port : "+serverSocket.getLocalPort());
			Server = serverSocket.accept();
			in = new BufferedReader(new InputStreamReader(Server
					.getInputStream()));
			out = new PrintWriter(Server.getOutputStream(), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String RecvString(String endStr){
		String recvStr = new String();
		String tmp;

		if(out==null||in==null||Server==null){
			recvStr = "quit";
		}else
			try {
				while((tmp = in.readLine())!=null && tmp.compareTo(endStr)!=0){
					recvStr += tmp;
				}
				out.print("received");
				out.flush();
			} catch (SocketException e){
				//e.printStackTrace();
				recvStr = "quit";
				this.Close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return recvStr;
	}
	
	protected void Close(){
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
		if(null!=Server){
			try {
				Server.close();
				Server = null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}