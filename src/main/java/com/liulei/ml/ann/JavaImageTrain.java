//package com.liulei.ml.ann;
//
///*
//    MLP neural network in Java
//    by Phil Brierley
//    www.philbrierley.com
//
//    This code may be freely used and modified at will
//
//    Tanh hidden neurons
//    Linear output neuron
//
//    To include an input bias create an
//    extra input in the training data
//    and set to 1
//
//    Routines included:
//
//    calcNet()
//    WeightChangesHO()
//    WeightChangesIH()
//    initWeights()
//    initData()
//    tanh(double x)
//    displayResults()
//    calcOverallError()
//
//    compiled and tested on
//    Symantec Cafe Lite
//*/
//
//import net.semanticmetadata.lire.imageanalysis.CEDD;
//import net.semanticmetadata.lire.imageanalysis.ColorLayout;
//import net.semanticmetadata.lire.imageanalysis.FuzzyColorHistogram;
//
//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.lang.Math;
//import java.util.HashMap;
//import java.util.Map;
//
//public class JavaImageTrain
//{
//
//    //user defineable variables
//    public static int numEpochs = 5000; //number of training cycles
//    public static int numInputs  = 488; //number of inputs - this includes the input bias
//    public static int numHidden  = 4; //number of hidden units
//    public static int numPatterns = 2000; //number of training patterns
//    public static int testPatterns = 2613; //number of test patterns
//    public static double LR_IH = 0.3; //learning rate
//    public static double LR_HO = 0.07; //learning rate
//
//    //process variables
//    public static int patNum;
//    public static int rightNumber;
//    public static double errThisPat;
//    public static double outPred;
//    public static double RMSerror;
//    public static Map<Integer, String> ouputMap = new HashMap<Integer, String>();
//
//    //training data
//    public static double[][] trainInputs  = new double[numPatterns][numInputs];
//    public static double[] trainOutput = new double[numPatterns];
//
//    //test data
//    public static double[][] testInputs  = new double[testPatterns][numInputs];
//    public static double[] testOutput = new double[testPatterns];
//
//    //the outputs of the hidden neurons
//    public static double[] hiddenVal  = new double[numHidden];
//
//    //the weights
//    public static double[][] weightsIH = new double[numInputs][numHidden];
//    public static double[] weightsHO = new double[numHidden];
//
//    public static StringBuffer sb = new StringBuffer();
//
//
////==============================================================
////********** THIS IS THE MAIN PROGRAM **************************
////==============================================================
//
//    public static void main(String[] args) throws IOException {
//
//        //initiate the weights
//        initWeights();
//
//        //load in the data
////        initData();
//
//        LireImageFeaturesExtract lireImageFeaturesExtract = new LireImageFeaturesExtract();
//        lireImageFeaturesExtract.initImageData(trainInputs,trainOutput,new CEDD());
//
//        //train the network
//        for(int j = 0;j <= numEpochs;j++)
//        {
//
//            for(int i = 0;i<numPatterns;i++)
//            {
//
//                //select a pattern at random
//                patNum = (int)((Math.random()*numPatterns)-0.001);
//
//                //calculate the current network output
//                //and error for this pattern
//                calcNet();
//
//                //change network weights
//                WeightChangesHO();
//                WeightChangesIH();
//            }
//
//            //display the overall network error
//            //after each epoch
//            calcOverallError();
//            System.out.println("epoch = " + j + "  RMS Error = " + RMSerror);
//
//        }
//
//        //training has finished
//        //display the results
//        displayResults();
//
//        lireImageFeaturesExtract.initImageInputData(testInputs,ouputMap,new CEDD());
//        displayTestResults();
//
//        String checkFilePath = "F:\\check.result.list";
//        BufferedWriter writer = new BufferedWriter(new FileWriter(checkFilePath));
//        writer.write(sb.toString());
//        writer.flush();
//        writer.close();
//
//
//    }
//
////============================================================
////********** END OF THE MAIN PROGRAM **************************
////=============================================================
//
//
//
//
//
//
//    //************************************
//    public static void calcNet()
//    {
//        //calculate the outputs of the hidden neurons
//        //the hidden neurons are tanh
//        for(int i = 0;i<numHidden;i++)
//        {
//            hiddenVal[i] = 0.0;
//
//            for(int j = 0;j<numInputs;j++)
//                hiddenVal[i] = hiddenVal[i] + (trainInputs[patNum][j] * weightsIH[j][i]);
//
//            hiddenVal[i] = tanh(hiddenVal[i]);
//        }
//
//        //calculate the output of the network
//        //the output neuron is linear
//        outPred = 0.0;
//
//        for(int i = 0;i<numHidden;i++)
//            outPred = outPred + hiddenVal[i] * weightsHO[i];
//
//        //calculate the error
//        errThisPat = outPred - trainOutput[patNum];
//    }
//
//    //************************************
//    public static void calcTestNet()
//    {
//        //calculate the outputs of the hidden neurons
//        //the hidden neurons are tanh
//        for(int i = 0;i<numHidden;i++)
//        {
//            hiddenVal[i] = 0.0;
//            for(int j = 0;j < numInputs;j++)
//                hiddenVal[i] = hiddenVal[i] + (testInputs[patNum][j] * weightsIH[j][i]);
//
//            hiddenVal[i] = tanh(hiddenVal[i]);
//        }
//
//        //calculate the output of the network
//        //the output neuron is linear
//        outPred = 0.0;
//
//        for(int i = 0;i<numHidden;i++)
//            outPred = outPred + hiddenVal[i] * weightsHO[i];
//
//
//    }
//
//
//    //************************************
//    public static void WeightChangesHO()
//    //adjust the weights hidden-output
//    {
//        for(int k = 0;k<numHidden;k++)
//        {
//            double weightChange = LR_HO * errThisPat * hiddenVal[k];
//            weightsHO[k] = weightsHO[k] - weightChange;
//
//            //regularisation on the output weights
//            if (weightsHO[k] < -5)
//                weightsHO[k] = -5;
//            else if (weightsHO[k] > 5)
//                weightsHO[k] = 5;
//        }
//    }
//
//
//    //************************************
//    public static void WeightChangesIH()
//    //adjust the weights input-hidden
//    {
//        for(int i = 0;i<numHidden;i++)
//        {
//            for(int k = 0;k<numInputs;k++)
//            {
//                double x = 1 - (hiddenVal[i] * hiddenVal[i]);
//                x = x * weightsHO[i] * errThisPat * LR_IH;
//                x = x * trainInputs[patNum][k];
//                double weightChange = x;
//                weightsIH[k][i] = weightsIH[k][i] - weightChange;
//            }
//        }
//    }
//
//
//    //************************************
//    public static void initWeights()
//    {
//
//        for(int j = 0;j<numHidden;j++)
//        {
//            weightsHO[j] = (Math.random() - 0.5)/2;
//            for(int i = 0;i<numInputs;i++)
//                weightsIH[i][j] = (Math.random() - 0.5)/5;
//        }
//
//    }
//
//
//    //************************************
//    public static void initData()
//    {
//
//        System.out.println("initialising data");
//
//        // the data here is the XOR data
//        // it has been rescaled to the range
//        // [-1][1]
//        // an extra input valued 1 is also added
//        // to act as the bias
//
//        trainInputs[0][0]  = 1;
//        trainInputs[0][1]  = -1;
//        trainInputs[0][2]  = 1;//bias
//        trainOutput[0] = 1;
//
//        trainInputs[1][0]  = -1;
//        trainInputs[1][1]  = 1;
//        trainInputs[1][2]  = 1;//bias
//        trainOutput[1] = 1;
//
//        trainInputs[2][0]  = 1;
//        trainInputs[2][1]  = 1;
//        trainInputs[2][2]  = 1;//bias
//        trainOutput[2] = -1;
//
//        trainInputs[3][0]  = -1;
//        trainInputs[3][1]  = -1;
//        trainInputs[3][2]  = 1;//bias
//        trainOutput[3] = -1;
//
//    }
//
//
//    //************************************
//    public static double tanh(double x)
//    {
//        if (x > 20)
//            return 1;
//        else if (x < -20)
//            return -1;
//        else
//        {
//            double a = Math.exp(x);
//            double b = Math.exp(-x);
//            return (a-b)/(a+b);
//        }
//    }
//
//
//    //************************************
//    public static void displayResults()
//    {
//        rightNumber = 0;
//        for(int i = 0;i<numPatterns;i++)
//        {
//            patNum = i;
//            calcNet();
//            System.out.println("pat = " + (patNum+1) + " actual = " + trainOutput[patNum] + " neural model = " + outPred);
//            if(Math.rint(trainOutput[patNum]*10) == Math.rint(outPred*10)){
//                rightNumber++;
//            }
//        }
//
//        System.out.println("The right percent is " + (double)rightNumber/numPatterns*100);
//    }
//
//    //************************************
//    public static void displayTestResults()
//    {
//        for(int i = 0;i<testPatterns;i++)
//        {
//            patNum = i;
//            calcTestNet();
//            System.out.println("pat = " + (patNum) + " neural model = " + outPred);
//            sb.append(ouputMap.get(i)).append("\t").append((int)Math.abs(Math.rint(outPred*10))).append("\n");
//        }
//
//      //  System.out.println("The right percent is " + (double)rightNumber/numPatterns*100);
//    }
//
//    public static void calcOverallError()
//    {
//        RMSerror = 0.0;
//        for(int i = 0;i<numPatterns;i++)
//        {
//            patNum = i;
//            calcNet();
//            RMSerror = RMSerror + (errThisPat * errThisPat);
//        }
//        RMSerror = RMSerror/numPatterns;
//        RMSerror = Math.sqrt(RMSerror);
//    }
//
//}
