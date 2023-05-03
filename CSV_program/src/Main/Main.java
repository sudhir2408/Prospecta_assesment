package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

	
	public static void main(String[] args) {
		
        // Input and output CSV file paths
		
        String inputCsvFile = "input.csv";
        String outputCsvFile = "output.csv";
        
        // Map to store cell values
        Map<String, Double> cellValues = new HashMap<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(inputCsvFile))) {
            String line;
            
            while ((line = br.readLine()) != null) {
            	
                String[] parts = line.split(",");
                String cellName = parts[0].trim();
                String cellValueStr = parts[1].trim();
                Double cellValue = null;
                
                if (cellValueStr.startsWith("=")) {
                	
                    // Cell value is a formula, calculate it
                    String formula = cellValueStr.substring(1);
                    
                    String[] formulaParts = formula.split("\\+");
                    Double result = 0.0;
                    
                    for (String formulaPart : formulaParts) {
                        String operand = formulaPart.trim();
                        if (operand.matches("[A-Z][0-9]")) {

                            // Operand is a cell reference, look up its value
                            operand = operand.trim();
                            if (!cellValues.containsKey(operand)) {
                                throw new RuntimeException("Not found cell: " + operand);
                            }
                            
                            result += cellValues.get(operand);
                        } else {
                        	


                            // Operand is a literal value
                            result += Double.parseDouble(operand);
                        }
                    }
                    
                    cellValue = result;
                    
                } else {

                    // Cell value is a literal value
                    cellValue = Double.parseDouble(cellValueStr);
                }
                cellValues.put(cellName, cellValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        
        try (FileWriter writer = new FileWriter(outputCsvFile)) {
            for (String cellName : cellValues.keySet()) {
                Double cellValue = cellValues.get(cellName);
                writer.write(cellName + "," + cellValue + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("Output is " + outputCsvFile);
    }

}

/*This program reads the input CSV file line by line, 
 * splits each line into two parts (cell name and cell value), 
 *  stores the cell values in a map. If the cell value is a formula, 
 *  it calculates the result by parsing the formula looking up the values of any referenced cells. 
*/

