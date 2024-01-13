package cz.vsb.ekf.hro0080.NeuronNetwork;

public class NeuralNetConstants {
	
	private NeuralNetConstants() {
		
	}
	
	public static final float LEARNING_RATE = 0.3f;
	public static final float MOMENTUM = 0.6f;   // pomáha vyhnúť sa lokálnym minimám 
	public static final int ITERATIONS = 10000;  
}
