/** Author

 *  Mihil Chathuranga Samarawickrama Ranatunga
 *
 *  Index Number = 100444N
 *
 *  CSE '10
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IndexReader {                                                      // index searching application

    /**
     * 
     */
    public static void main(String[] args) throws IOException {                 // main method
        // TODO code application logic here

        String[] command;                                                       // additional array for splitting words from a read line
        int page;                                                               // variable for storing page number

        IndexReader in = new IndexReader();                                     // instantiate classes
        // Hashtable pages = new Hashtable(1009);                                  // Hashtable for storing page numbers for a given keyword   
        // Hashtable keywords = new Hashtable(201);                                // Hashtable for storing keywords for a given page number

        BufferedReader br = in.reader();                                        // initializing buffered reader to read contents from the file

        String line = br.readLine();                                            // read first line

        if (line != null && line.equalsIgnoreCase("Keyword List Start")) {      // check for keyword list start

            while (line != null) {

                line = br.readLine();

                if (line.equalsIgnoreCase("Keyword List End")) {                // stop execution if leyword list ended
                    break;
                }
                command = line.split("\\s+");                                   // split the line to word tokens
		
		int i=0;
		while(command[i]==null){
		System.out.println(command[i]);

		i++;
		}
                String word = command[0];                                       // keyword
                page = Character.getNumericValue(command[1].charAt(0));         // corresponding page number for the keyword

                // pages.insert(word, page);                                       // add values to Hashtables
                // keywords.insert(page, word);
            }
        } else {
            System.out.println("Keyword List Start Not Found");                 // if keyword list was not found 
        }

        // line = br.readLine();

        // if (line != null && line.equalsIgnoreCase("Queries Start")) {           // cheking for querie list start

        //     while (line != null) {

        //         line = br.readLine();

        //         if (line.equalsIgnoreCase("Queries End")) {                     // stop execution if query list ended
        //             break;
        //         }
        //         command = line.split(" ");                                      // split the read line

        //         if (command[0].equalsIgnoreCase("First")) {                     // showing first page number for given keyword

        //             pages.findPage(command[1]);
        //         } else if (command[0].equalsIgnoreCase("List")) {               // showing sorted list of page numbers for given keyword

        //             pages.findPageList(command[1]);
        //         } else if (command[0].equalsIgnoreCase("Keywords")) {           // showing sorted list of keywords in a given page number 

        //             page = Character.getNumericValue(command[1].charAt(0));
        //             keywords.findKeywordList(page);
        //         } else {                                                        // if query list wasn't found
        //             System.out.println("Querie Start Not Found");
        //         }
        //     }
        // }
    }

    public BufferedReader reader() {                                            // read input file 

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("Text.in"));

        } catch (FileNotFoundException ex) {

            System.err.println(ex.getMessage());
            Logger.getLogger(IndexReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return br;
    }
}
