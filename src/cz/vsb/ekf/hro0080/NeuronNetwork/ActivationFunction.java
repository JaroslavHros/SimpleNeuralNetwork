package cz.vsb.ekf.hro0080.NeuronNetwork;

public class ActivationFunction {
	
	public static float sigmoid(float x) {
		  return  (float) (1 / (1 + Math.exp(-x)));

	}

	public  static float derivate(float x) {
		return x * (1- x);
	}

	public static float linear(float x) {
		 
		return x;
		
	}
	public static float linearD(float x) {
		 
		return 1;
		
	}

	    public static float tanH(float x) {
	        return (float)  Math.tanh(x);
	    }

	    public static float tanhDerivate(float x) {
	        double tanh2 = Math.pow(Math.tanh(x), 2);
	        return (float)( 1.0f - tanh2);
	    }

}
