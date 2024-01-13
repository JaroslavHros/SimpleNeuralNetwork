package cz.vsb.ekf.hro0080.NeuronNetwork;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class BackPropagationNeuralNetwork  {
	
	private Layer[] layers;

	public BackPropagationNeuralNetwork(int inputSize, int hiddenSize, int outputSize) {
		
		layers = new Layer[2];
		layers[0] = new Layer(inputSize, hiddenSize);
		layers[1] = new Layer(hiddenSize, outputSize);
	}
   public Layer getLayer (int index) {
	   return layers[index];
   }
   
  
   public float[] run(float[] input) {
	 float[] activations = input;
	   for(int i= 0; i < layers.length; i++) 
		   activations = layers[i].run(activations);
		   
		   return activations;
		   
	   
   }
   // output myslený ako target output, alpha = LR, metóda na algoritmus BP 
   // prehodit spať void-- ak nebude fungovat
   public  float[] train(float[] input, float[] output, float alpha, float mu) throws IOException{
	 
	   float[] pom ; 
	  // float[] pom1 ;
	   
	   float [] calculatedOutput = run(input);
	   float [] error = new float[calculatedOutput.length];
	   double mse ;
	   float sum =0;
	   for(int i = 0; i<error.length; i++)
		   error[i] = output[i] - calculatedOutput [i];
	   
	   pom=  Arrays.copyOf(error,error.length);
	   //back propagation 
	   for (int i = layers.length-1; i >= 0; i--) {
		   error= layers[i].train(error, alpha, mu);
	   }
	   
	    
	   return pom;
	   //amaterizmus :D
//	   for(int j=0; j<error.length; j++){
//		   sum = (int) (sum + error[j]);
//		   mse = Math.sqrt((double) sum/ (double)calculatedOutput.length);
//	      }
		   
   		}
	public static double findSumWithoutUsingStream(float[] error) {
	    double sum = 0;
	    for (float value : error) {
	        sum += value;
	    }
	    return sum;
	}
  
}
