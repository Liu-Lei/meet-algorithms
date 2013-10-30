package com.liulei.qunarspider.krabber;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class TestClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetStyleHtml gsh = new GetStyleHtml("www.cnbeta.com");
		String[] scripts = {
				"javascript:process('GET','pagedata0.php?pageID=2','active')",
				"javascript:process('GET','pagedata0.php?pageID=3','active')",
				"javascript:process('GET','pagedata0.php?pageID=4','active')"
				};
		gsh.AddScripts(scripts);

		Vector<String> sources = gsh.get();
		// System.out.println(str);
		String fileName = new String();
		try {
			for (int i = 0; i < sources.size(); ++i) {
				fileName = "Eureka_" + i + ".html";
				File f = new File("d:\\", fileName);
				FileOutputStream fos = new FileOutputStream(f);
				OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-16");
				osw.write(sources.get(i));
				osw.flush();
				System.out.println("Complete output html code to " + fileName);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
