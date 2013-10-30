package com.liulei.ml.ann;

import org.w3c.dom.*;

import java.io.*;
import java.net.URL;
import java.util.*;
import javax.imageio.*;
import javax.imageio.stream.*;
import javax.imageio.metadata.*;

/**
 * Created with IntelliJ IDEA.
 * User: leo
 * Date: 6/8/13
 * Time: 3:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReadImageData {
    public static void main(String[] args) {
        String  classPath = Thread.currentThread().getContextClassLoader().getResource(".").getPath();
        String projectPath = classPath.substring(0,classPath.indexOf("target"));
        String trainImageFilePath = projectPath+"src/resource/trainimage";
        System.out.println(trainImageFilePath);
        File file = new File(trainImageFilePath);
        File[] imageFiles = file.listFiles();
        System.out.println(imageFiles[0].getAbsoluteFile());
        readAndDisplayMetadata(imageFiles[0].getAbsolutePath());
        System.out.println(imageFiles[2].getAbsoluteFile());
        readAndDisplayMetadata(imageFiles[2].getAbsolutePath());

        readAndDisplayMetadata("/home/leo/test.png");
    }

    static void readAndDisplayMetadata(String fileName) {
        try {

            File file = new File(fileName);
            ImageInputStream iis = ImageIO.createImageInputStream(file);
            Iterator<ImageReader> readers = ImageIO.getImageReaders(iis);

            if (readers.hasNext()) {

                // pick the first available ImageReader
                ImageReader reader = readers.next();

                // attach source to the reader
                reader.setInput(iis, true);

                // read metadata of first image
                IIOMetadata metadata = reader.getImageMetadata(0);

                String[] names = metadata.getMetadataFormatNames();
                int length = names.length;
                for (int i = 0; i < length; i++) {
                    System.out.println("Format name: " + names[i]);
                    displayMetadata(metadata.getAsTree(names[i]));
                }
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    static void displayMetadata(Node root) {
        displayMetadata(root, 0);
    }

    static void indent(int level) {
        for (int i = 0; i < level; i++)
            System.out.print("    ");
    }

    static void displayMetadata(Node node, int level) {
        // print open tag of element
        indent(level);
        System.out.print("<" + node.getNodeName());
        NamedNodeMap map = node.getAttributes();
        if (map != null) {

            // print attribute values
            int length = map.getLength();
            for (int i = 0; i < length; i++) {
                Node attr = map.item(i);
                System.out.print(" " + attr.getNodeName() +
                        "=\"" + attr.getNodeValue() + "\"");
            }
        }

        Node child = node.getFirstChild();
        if (child == null) {
            // no children, so close element and return
            System.out.println("/>");
            return;
        }

        // children, so close current tag
        System.out.println(">");
        while (child != null) {
            // print children recursively
            displayMetadata(child, level + 1);
            child = child.getNextSibling();
        }

        // print close tag of element
        indent(level);
        System.out.println("</" + node.getNodeName() + ">");
    }
}
