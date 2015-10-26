/**
 * 	Copyright 2015 Derek Keogh
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ie.decoder.xsd;

public class Main {

    public static void main(String[] args) {
        
        Unmarshall unmar = new Unmarshall();
        Grid grid = null;
        try {
        	//Load the xml file using Jaxb
            grid = unmar.UnmarshallTheDocument();
            
            int lineCount = 0;
            for (int i = 1; i < grid.getCell().size() + 1; i++) {
            	System.out.print(grid.cell.get(i-1).getValue() + " ");
            	if(i % 3 == 0) {
            		System.out.print(" ");
            	}
            	if(i % 9 == 0) {
            		System.out.println();
            		lineCount++;
                	if(lineCount % 3 == 0) {
                		System.out.println();
                	}
            	}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
