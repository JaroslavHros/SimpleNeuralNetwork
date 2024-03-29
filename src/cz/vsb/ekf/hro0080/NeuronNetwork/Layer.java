package cz.vsb.ekf.hro0080.NeuronNetwork;

import java.util.Arrays;
import java.util.Random;
public class Layer {
	private float[] input; 
	private float[] output;
	private float[] weights;
	private float[] dweights; 
	private Random random;

	
	public float[] run (float [] inputArray ) {

		System.arraycopy(inputArray, 0, input, 0, inputArray.length); //copy array aby sme zabranili zmene trenovacích dát
		input[input.length -1] = 1;  // bias 1 !
		int offset = 0 ;
		
		for(int i = 0; i< output.length; i++) {
			for(int j = 0; j<input.length; j++) {
				output[i] += weights[offset+j]* input[j];
			}
			output[i] = ActivationFunction.sigmoid(output[i]);
			offset += input.length;
		}
		 return Arrays.copyOf(output, output.length);
		}
			
	
	// backpropagation
	public float[] train (float[] error, float learningRate, float momentum) {
		int offset = 0;
		float[] nextError= new float[input.length];
		
		for (int i = 0; i < output.length;i++) {
			float delta = error[i] * ActivationFunction.derivate(output[i]);
			
			for (int j = 0; j< input.length;j++) {
				int weightIndex = offset + j; 
				
				nextError[j] = nextError[j] + weights[weightIndex] * delta ;
				float dw = input[j] * delta * learningRate; 
				weights[weightIndex] += dweights[weightIndex] * momentum + dw;
				dweights[weightIndex] = dw ;
				
			}
			 offset += input.length;
			}
			return nextError;
		}
	
	
	
	public Layer (int inputSize, int outputSize) {
	
		this.output = new float[outputSize];
		this.input = new float[inputSize +1];
		this.weights = new float[(inputSize+1) * outputSize];
		this.dweights = new float[weights.length];
		this.random = new Random();
		
		initWeights();
		
	
	}
 // inicializacia vah pomocoun nahodneho čisla
	private void initWeights() {
		for(int i = 0 ; i <weights.length; i++ )
			weights[i] = (random.nextFloat()- 0.5f) * 4f;  // [-2,2)
		
	}
	public float[] getInput() {
		return input;
	}
	public float[] getOutput() {
		return output;
	}
	public float[] getWeights() {
		return weights;
	}
	public float[] getDweights() {
		return dweights;
	}
	public void setInput(float[] input) {
		this.input = input;
	}
	public void setOutput(float[] output) {
		this.output = output;
	}
	public void setWeights(float[] weights) {
		this.weights = weights;
	}
	public void setDweights(float[] dweights) {
		this.dweights = dweights;
	}

}
