//package com.liulei.ml.ann;
//
//import net.semanticmetadata.lire.imageanalysis.CEDD;
//import net.semanticmetadata.lire.imageanalysis.ColorLayout;
//import net.semanticmetadata.lire.imageanalysis.LireFeature;
//import net.semanticmetadata.lire.utils.FileUtils;
//
//import javax.imageio.ImageIO;
//import java.awt.image.BufferedImage;
//import java.io.*;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//
///**
// * Created with IntelliJ IDEA.
// * User: Leo
// * Date: 6/8/13
// * Time: 9:44 PM
// * To change this template use File | Settings | File Templates.
// */
//public class LireImageFeaturesExtract {
//    private static String filePath = "F:\\340803244_3_MLKD-Final-Project-Release\\MLKD-Final-Project-Release\\ic-data\\train";
//    private static String checkFilePath = "F:\\check";
//
//    private static String trainLabelsFile=filePath+"\\train.label";
//    private static Map<Integer,Integer> labelMap = new HashMap<Integer, Integer>();
//
//    public LireImageFeaturesExtract(){
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(trainLabelsFile));
//            String labelLine = null;
//            while ((labelLine = reader.readLine()) != null){
//                String[] labelArray = labelLine.split(" ");
//                labelMap.put(Integer.valueOf(labelArray[0]),Integer.valueOf(labelArray[1]));
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println(e.getMessage());
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public void initImageInputData(double[][] trainInputs, Map<Integer, String> ouputMap,  LireFeature lireFeature){
//        ArrayList<String> images = null;
//        try {
//            images = FileUtils.getAllImages(new File(checkFilePath), true);
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//
//        for (int i = 0; i < trainInputs.length; i++ ) {
//            String imageFilePath = images.get(i);
//            String imageName = imageFilePath.substring(imageFilePath.indexOf("check")+6,imageFilePath.indexOf(".jpg"));
//            System.out.println("Deal with " + imageFilePath);
//            ouputMap.put(i,imageName);
//            try {
//                BufferedImage img = ImageIO.read(new FileInputStream(imageFilePath));
//                lireFeature.extract(img);
//                byte[] bytes = lireFeature.getByteArrayRepresentation();
//                for(int j = 0; j < bytes.length; j++){
//                    trainInputs[i][j] = (double)bytes[j]/100;
//                }
//            } catch (Exception e) {
//                System.err.println("Error reading image or indexing it.");
//                e.printStackTrace();
//            }
//        }
//    }
//
//
//    public void initImageData(double[][] trainInputs, double[] trainOutput, LireFeature lireFeature){
//        ArrayList<String> images = null;
//        try {
//            images = FileUtils.getAllImages(new File(filePath), true);
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//
//        for (int i = 0; i < trainInputs.length; i++ ) {
//            String imageFilePath = images.get(i);
//            String imageName = imageFilePath.substring(imageFilePath.indexOf("train")+6,imageFilePath.indexOf(".jpg"));
//            System.out.println("Deal with " + imageFilePath);
//            Integer output = labelMap.get(Integer.valueOf(imageName));
//            trainOutput[i] = (double)output/10;
//            try {
//                BufferedImage img = ImageIO.read(new FileInputStream(imageFilePath));
//                lireFeature.extract(img);
//                byte[] bytes = lireFeature.getByteArrayRepresentation();
//                for(int j = 0; j < bytes.length; j++){
//                    trainInputs[i][j] = bytes[j];
//                }
//            } catch (Exception e) {
//                System.err.println("Error reading image or indexing it.");
//                e.printStackTrace();
//            }
//        }
//
//        for(int i = 0; i < 100; i++){
//
//            for(int j = 0; j < 488; j++){
//                System.out.print(trainInputs[i][j]+"\t");
//            }
//            System.out.println();
//        }
//    }
//
//    //test method
//    public static void main(String[] args) throws IOException {
//
//        LireImageFeaturesExtract lireImageFeaturesExtract = new LireImageFeaturesExtract();
//        lireImageFeaturesExtract.initImageData(new double[100][488],new double[100],new CEDD());
//        System.out.println("test");
//    }
//}
