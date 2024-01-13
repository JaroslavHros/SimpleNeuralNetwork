package cz.vsb.ekf.hro0080.NeuronNetwork;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Neuron {

	private ArrayList<Double> input;
	private ArrayList<Double> weight;
	private Double output = 0.00;
	private Double bias;
	private ActivationFunction activationFunction; 
	
	public ArrayList<Double> getInput() {
		return input;
	}

	public ArrayList<Double> getWeight() {
		return weight;
	}

	public Double getBias() {
		return bias;
	}

	public void setInput(ArrayList<Double> input) {
		this.input = input;
	}

	public void setWeight(ArrayList<Double> weight) {
		this.weight = weight;
	}

	public void setBias(Double bias) {
		this.bias = bias;
	}

	public Neuron(ArrayList<Double> input, ArrayList<Double> weight, Double bias) {
		super();
		this.input = input;
		this.weight = weight;
		this.bias = bias;
	}


	
	public Double calcute() {
		if(getInput().size() != getWeight().size()) {
			 throw new RuntimeException("Input and weight lists should have the same size.");
		}
		final double weightedSum = IntStream.range(0, getInput().size())
                .mapToDouble(i -> getInput().get(i) * getWeight().get(i))
                .sum();

        output = activationFunction.output(weightedSum + bias);
        return output;
	}
	}

