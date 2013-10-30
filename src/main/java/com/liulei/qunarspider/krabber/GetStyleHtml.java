package com.liulei.qunarspider.krabber;

import java.io.IOException;
import java.util.ConcurrentModificationException;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GetStyleHtml {
	// ʹ��˫�˿�ͨ��
	private int sendPort; // java�˵�Client Socket�ķ��Ͷ˿ڣ�c++�˵�Server Socket�Ľ��ն˿�
	private int recvPort; // java�˵�Server Socket�Ľ��ն˿ڣ�c++�˵�Client Socket�ķ��Ͷ˿�
	// private String html = new String();
	private String URL = new String();
	private static Vector<Integer> portVector = new Vector<Integer>();
	protected Lock lock = new ReentrantLock();
	private Vector<String> vCommand = new Vector<String>();

	public GetStyleHtml(String str) {
		URL = str;
	}

	public void AddScripts(String[] scripts) {
		for (int i = 0; i < scripts.length; ++i) {
			vCommand.add(scripts[i]);
		}
	}

	protected void getPort() {
		lock.lock();
		try {
			for (int i = 0; i < 2; ++i) {
				int port;
				do {
					Random random = new Random(System.currentTimeMillis());
					port = random.nextInt(60000) + 1024;
				} while (GetStyleHtml.portVector.contains(port));
				GetStyleHtml.portVector.addElement(port);
				if (0 == i) {
					sendPort = port;
				} else if (1 == i) {
					recvPort = port;
				}
			}
		} catch (ConcurrentModificationException cme) {
			System.out.println(cme);
		} catch (IllegalArgumentException iae) {
			System.out.println(iae);
		} finally {
			lock.unlock();
		}
	}

	protected void removePort(int port) {
		try {
			GetStyleHtml.portVector.remove(port);
		} catch (ConcurrentModificationException cme) {
			System.out.println(cme);
		}
	}

	public Vector<String> get() {
		Vector<String> sources = new Vector<String>();

		this.getPort();

		Runtime rt = Runtime.getRuntime();
		String[] cmd = new String[6];
		String delay = new String("2");
		String timeOut = new String("60");
		// c++������������ʽΪ��GetStyleHtml.exe -URL -RecvPort -SendPort [-Delay]
		// [-TimeOut]
		// ������ֱ�Ϊ�������� -URL -���ն˿� -���Ͷ˿� [-��ʱ��ȡʱ�䣬��Ϊ��λ��Ĭ��Ϊ5��] [-�����ȡ��ʱʱ�䣬��Ϊ��λ��Ĭ��Ϊ20��]��
		// ���к����������ѡ�����ǳ�ʱʱ����������ʱ��ȡʱ�䣬�����һֱ���ֳ�ʱ��
		cmd[0] = "GetStyleHtml_0.3.exe";
		cmd[1] = URL;
		cmd[2] = Integer.toString(sendPort);
		cmd[3] = Integer.toString(recvPort);
		cmd[4] = delay;
		cmd[5] = timeOut;
		try {
			rt.exec(cmd);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return sources;
		}


		String str = null;
		MyServer server = new MyServer(recvPort);
		// ��c++����δ�˳�ǰ��ѭ������
		int count = 0;
		do {
			server.Connect();
			str = server.RecvString("end");
			++count;
			if(str.compareTo("")==0){
				break;
			}else if (str.compareTo("initialized ok") == 0) {
				ClientThread client = new ClientThread("127.0.0.1", sendPort);
				client.AddAllStrings(vCommand);
				client.start();
			} else if (str.compareTo("quit") == 0) {
				break;
			} else {
				System.out.println("Got it");
				sources.add(str);
			}
		} while (str.compareTo("quit") != 0);
		ClientThread client = new ClientThread("127.0.0.1", sendPort);
		client.AddString("all received");
		client.start();
		server.Close();
		System.out.println("client quit...");

		GetStyleHtml.portVector.removeElement(recvPort);
		GetStyleHtml.portVector.removeElement(sendPort);
		return sources;
	}
}
