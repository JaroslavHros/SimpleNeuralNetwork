package cz.vsb.ekf.hro0080.NeuronNetwork;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;



public class Application {
	
	public static void main(String[] args) {
		BufferedWriter br ;
		try {
		//	PrintStream myconsole = new PrintStream(new File ("C:\\Users\\Jaroslav Hroš\\Desktop\\java.txt"));
			// br = new BufferedWriter(new FileWriter("myoutJavaMSE.csv"));
			//  StringBuilder sb = new StringBuilder(); final String LINE_SEPARATOR = "\n";
		     //System.setOut(myconsole);

		/*
		 * float[] trainingData = DataReader.readX();
		 *  float[] trainingResults =
		 * DataReader.readY();
		 */
		
		//	float[]  trainingData  = DataReader.readX();
		//	float[]  trainingResults  = DataReader.readY();

		
		/*
		 * float [][] trainingData = new float[][] { new float[] {0,0}, new float[]
		 * {0,1}, new float[] {1,0}, new float[] {1,1}, };
		 * 
		 * float[][] trainingResults = new float[][] { new float[] {0}, new float[] {0},
		 * new float[] {0}, new float[] {1} };
		 */

			 
		
		float [][] trainingData = new float[][] { 
		
				/*
				 * new float[] {-0.8f}, new float[] {-0.7f}, new float[] {-0.6f}, new float[]
				 * {-0.5f}, new float[] {-0.4f}, new float[] {-0.3f}, new float[] {-0.2f}, new
				 * float[] {-0.1f},
				 */ 
			  new float[] {0.0f},
			  new float[] {0.1f},
			  new float[] {0.2f},
			  new float[] {0.3f}, 
			  new float[] {0.4f},
			  new float[] {0.5f},
			  new float[] {0.6f}, 
			  new float[] {0.7f},
			  new float[] {0.8f},
			  
		  };
		  //data zadané ručne -- doriešit read from csv / prehodenie 1D array na 2D alebo vyriešiť skriptom  ? :O
		  float[][] trainingResults = new float[][]  { 
					/*
					 * new float[] {-0.888f}, new float[] {-0.759f}, new float[] {-0.637f}, new
					 * float[] {-0.521f}, new float[] {-0.411f}, new float[] {-0.305f}, new float[]
					 * {-0.201f}, new float[] {-0.100f},
					 */
			  new float[] {0.0f},
			  new float[] {0.100f}, 
			  new float[] {0.201f},
			  new float[] {0.305f},
			  new float[] {0.411f},
			  new float[] {0.521f}, 
			  new float[] {0.637f},
			  new float[] {0.759f},
			  new float[] {0.888f},
			
		  };
		  
			
			 
			 
	float sum = 0;
	double mse; 
	double pom ;
	float[] p  =  new float[trainingResults.length] ; 
		BackPropagationNeuralNetwork backpropNeuralnetwork = new BackPropagationNeuralNetwork(2, 10, 1);  // vytovorenie siete
		 for ( int iteration = 0 ; iteration < NeuralNetConstants.ITERATIONS ; iteration ++) { 
			// myconsole.print("Počet epoch: " + (iteration +1) + "\n");// trenovanie 
			 System.out.println("Počet epoch: " + (iteration +1) + "\n");
			 for (int i = 0; i < trainingResults.length; i++) {
				float  error[] = backpropNeuralnetwork.train(trainingData[i], trainingResults[i], NeuralNetConstants.LEARNING_RATE, NeuralNetConstants.MOMENTUM);
				
				System.out.println(error[0]);
				  sum += error[0];
					//System.out.println("suma chýb v epoche " + sum );

		
				 
				
				//System.out.println("Chyba v danej epoche : " + error[0]);	
				
				  // System.out.printf(  "%.2f", error[0] ,  "\n" );
					 
				 }
			  // sb.append("Počet epoch" + (iteration +1));
			  // sb.append(LINE_SEPARATOR);
				
				//  sb.append(Math.pow((sum/9), 2)); sb.append(LINE_SEPARATOR);
				//  br.write(sb.toString()); br.flush();
				 
			  System.out.println( Math.pow((sum/9), 2) + " MSE v aktualnej epoche");
			  sum = 0;
			// myconsole.println("/n");
			 System.out.println();
			 for (int i = 0; i < trainingResults.length; i++) {
				 float[] t =  trainingData[i];
				// myconsole.println("Hodnota premnennej x: " + t[0] + " Funkcia v bode x: " + Math.sinh((double) t[0]) );
	              //  myconsole.println( "Vysledok z neuronky: " + backpropNeuralnetwork.run(t)[0]);
				System.out.println("Hodnota premnennej x: " + t[0] + " Funkcia v bode x: " + Math.sinh((double) t[0]) );
               System.out.println( "Vysledok z neuronky: " + backpropNeuralnetwork.run(t)[0]);
              
				//System.out.printf("%.1f, %.1f --> %.3f\n", t[0], t[1], backpropNeuralnetwork.run(t)[0]);				 
				  p[i] = backpropNeuralnetwork.run(t)[0];
				 
				  
			}
			 
		 }
		 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
		  
		
		}
		

		  

	}
	public static double findSumWithoutUsingStream(float[] error) {
	    double sum = 0;
	    for (float value : error) {
	        sum += value;
	    }
	    return sum;
	}

}

