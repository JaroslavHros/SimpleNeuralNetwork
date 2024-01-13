package cz.vsb.ekf.hro0080.NeuronNetwork;

public class TanhFunction implements ActivationFunction {

	@Override
	public Double output(Double input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double derivate(Double input) {
		return (1.0) - Math.pow(output(input), 2.0);
		
	}

}
