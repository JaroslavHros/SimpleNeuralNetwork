package cz.vsb.ekf.hro0080.NeuronNetwork;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataReader {
	public static float[] readY()  throws Exception{
		
		  
		  //  Float[] output = null;
			String comma = ";";
			String csv = "C:\\\\Users\\\\Jaroslav Hroš\\\\Desktop\\\\MyWorkSpace\\\\DataGeneratorCsv\\\\hodnoty.csv" ;
	       List<List<String>> records = new ArrayList<>();
	        BufferedReader br = null;
	        try {
	       
	            br = new BufferedReader(new FileReader(csv));
	            String line;
	            while ((line = br.readLine()) != null) {
	                String[] values = line.split(comma);
	                records.add(Arrays.asList(values));
	                
	            }
	            float [] floatValues = new float[records.size()];

	            for (int i = 0; i < records.size(); i++) {
	                floatValues[i] = Float.parseFloat(records.get(i).toString().replaceAll("[\\(\\)\\[\\]\\{\\}]",""));
	            }
				/*
				 * System.out.println(floatValues.length); System.out.println(floatValues[0]);
				 * System.out.println(floatValues[1]); System.out.println(floatValues[34]);
				 * Object[] t ; t= records.toArray(); System.out.println(t.length);
				 */
	            
	            return floatValues;
	        }finally {
				 br.close();
			}
	    
		}
		public static float[]  readX()  throws Exception{
			
			  
		   // Float[] output = null;
			String comma = ";";
			String csv = "C:\\\\Users\\\\Jaroslav Hroš\\\\Desktop\\\\MyWorkSpace\\\\DataGeneratorCsv\\\\hodnotyX.csv" ;
	       List<List<String>> records = new ArrayList<>();
	        BufferedReader br = null;
	        try {
	       
	            br = new BufferedReader(new FileReader(csv));
	            String line;
	            while ((line = br.readLine()) != null) {
	                String[] values = line.split(comma);
	                records.add(Arrays.asList(values));
	                
	            }
	            float [] floatValues = new float[records.size()];

	            for (int i = 0; i < records.size(); i++) {
	                floatValues[i] = Float.parseFloat(records.get(i).toString().replaceAll("[\\(\\)\\[\\]\\{\\}]",""));
	                
	            }
				/*
				 * System.out.println(floatValues.length); System.out.println(floatValues[0]);
				 * System.out.println(floatValues[1]); System.out.println(floatValues[34]);
				 * Object[] t ; t= records.toArray(); System.out.println(t.length);
				 */
	            
	            return floatValues;
	        }finally {
				 br.close();
			}
	    
		}

}
