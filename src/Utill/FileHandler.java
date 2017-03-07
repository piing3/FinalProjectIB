
/** required package */
package Utill;

/** required imports */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

/**
 * FileHandler.java - description...
 * @author Mr. Wachs
 * @param <T>
 * @since 14-Dec-2015
 * @version 1.0
 * @instructor Mr. Wachs
 */
public class FileHandler<T>
{
    
    /**
     * saves the passed string to the passed filename
     * @param text the text to save
     * @param filename the filename to save it to
     */
    public void save(String text, String filename) {
        try {
            FileWriter  stream = new FileWriter(filename);
            PrintWriter file   = new PrintWriter(stream);
            file.println(text);
            file.close();
        } catch (NullPointerException error) {
            System.out.println("Null error" + error.toString());
        } catch (IOException error) {
            System.out.println("I/O error" + error.toString());
        }
    }

    /**
     * 
     * @param text
     * @param file 
     */
    public void save(String text, File file) {
        try {
            save(text,file.getAbsolutePath());
        } catch (NullPointerException error) {
            System.out.println("Null error" + error.toString());
        }
    }
    
    /**
     * 
     * @param text
     * @param file 
     */
    public void append(String text, File file) {
        try {
            append(text,file.getAbsolutePath());
        } catch (NullPointerException error) {
            System.out.println("Null error" + error.toString());
        }
    }
    
    /**
     * 
     * @param line
     * @param filename 
     */
    public void append(String line, String filename) {
        try {
            FileWriter  stream = new FileWriter(filename,true);
            PrintWriter file   = new PrintWriter(stream);
            file.println(line);
            file.close();
        } catch (NullPointerException error) {
            System.out.println("Null error" + error.toString());
        } catch (IOException error) {
            System.out.println("I/O error" + error.toString());
        }
    }
    
    /**
     * 
     * @param data
     * @param filename 
     */
    public void save(String[] data, String filename) {
        try {
            FileWriter  stream = new FileWriter(filename);
            PrintWriter file   = new PrintWriter(stream);
            for (int i = 0; i < data.length; i++) {
                file.println(data[i]);
            }            
            file.close();
        } catch (NullPointerException error) {
            System.out.println("Null error" + error.toString());
        } catch (IOException error) {
            System.out.println("I/O error" + error.toString());
        } catch(ArrayIndexOutOfBoundsException error) {
            System.out.println("Array out of bound" + error.toString());
        } catch(ArrayStoreException error) {
            System.out.println("Array storage" + error.toString());
        }
    }
    
    /**
     * 
     * @param data
     * @param file 
     */
    public void save(String[] data, File file) {
        try {
            save(data, file.getAbsolutePath());
        } catch (NullPointerException error) {
            System.out.println("Null error" + error.toString());
        }
    }
        
    /**
     * 
     * @param data
     * @param filename 
     */
    public void saveObject(T data, String filename) {
        try {
            FileOutputStream   stream = new FileOutputStream(filename);
            ObjectOutputStream file   = new ObjectOutputStream(stream);
            file.writeObject(data);
            file.close();
        } catch(NullPointerException error) {
            System.out.println("Null error" + error.toString());
        } catch (IOException error) {
            System.out.println("I/O error" + error.toString());
        }
    }
    
    /**
     * 
     * @param data
     * @param file 
     */
    public void saveObject(T data, File file) {
        try {
            saveObject(data,file.getAbsolutePath());
        } catch(NullPointerException error) {
            System.out.println("Null error" + error.toString());
        }
    }
    
    
    
    /**
     * opens the passed filename and returns the contents as a 
     * single string
     * @param filename the full name of the file to open
     * @return a string of the contents of the file
     */
    public String open(String filename) {
        try {
            FileReader     stream = new FileReader(filename);
            BufferedReader file   = new BufferedReader(stream);
            String line = file.readLine();
            file.close();
            return line;
        } catch (NullPointerException error) {
            System.out.println("Null error" + error.toString());
        } catch (IOException error) {
            System.out.println("I/O error" + error.toString());
        }
        return null;
    }
        
    /**
     * 
     * @param filename
     * @return 
     */
    public String openAll(String filename) {
        try {
            FileReader     stream = new FileReader(filename);
            BufferedReader file   = new BufferedReader(stream);
            String line = file.readLine();
            String text = "";
            while (line != null) {
                text += line + "\n";
                line = file.readLine();
            }            
            file.close();
            return text;
        } catch (NullPointerException error) {
            System.out.println("Null error" + error.toString());
        } catch (IOException error) {
            System.out.println("I/O error" + error.toString());
        }
        return null;
    }
         
    /**
     * 
     * @param file
     * @return 
     */
    public String open(File file) {
        try {
            return open(file.getAbsolutePath());
        } catch (NullPointerException error) {
            System.out.println("Null error" + error.toString());
        }
        return null;
    }
        
    /**
     * 
     * @param file
     * @return 
     */
    public String openAll(File file) {
        try {
            return openAll(file.getAbsolutePath());
        } catch (NullPointerException error) {
            System.out.println("Null error" + error.toString());
        }
        return null;
    }
        
    /**
     * 
     * @param filename
     * @return 
     */
    public String[] openArray(String filename) {
        try {                    
            FileReader     stream = new FileReader(filename);
            BufferedReader file   = new BufferedReader(stream);
            String line = file.readLine();
            int count = 0;
            while (line != null) {
                count++;
                line = file.readLine();
            }            
            file.close();            
            String[] array = new String[count];
            stream = new FileReader(filename);
            file   = new BufferedReader(stream);
            for (int i = 0; i < count; i++) {
                array[i] = file.readLine();
            }            
            file.close();            
            return array;
        } catch (NullPointerException error) {
            System.out.println("Null error" + error.toString());
        } catch (IOException error) {
            System.out.println("I/O error" + error.toString());
        } catch(ArrayIndexOutOfBoundsException error) {
            System.out.println("Array out of bound" + error.toString());
        } catch(ArrayStoreException error) {
            System.out.println("Array storage" + error.toString());
        }
        return null;
    }
    
    /**
     * 
     * @param file
     * @return 
     */
    public String[] openArray(File file) {
        try {
            return openArray(file.getAbsolutePath());
        } catch (NullPointerException error) {
            System.out.println("Null error" + error.toString());
        }
        return null;
    }
    
    /**
     * 
     * @param filename
     * @return 
     */
    public T openObject(String filename) {
        try {
            FileInputStream   stream = new FileInputStream(filename);
            ObjectInputStream file   = new ObjectInputStream(stream);
            T object = (T)file.readObject();
            file.close();
            return object;
        } catch(NullPointerException error) {
            System.out.println("Null error" + error.toString());
        } catch (IOException error) {
            System.out.println("I/O error" + error.toString());
        } catch (ClassNotFoundException error) {
            System.out.println("Class not found error" + error.toString());
        }
        return null;
    }
    
    /**
     * 
     * @param file
     * @return 
     */
    public T openObject(File file) {
        try {
            return openObject(file.getAbsolutePath());
        } catch(NullPointerException error) {
            System.out.println("Null error" + error.toString());
        }
        return null;
    }
    
}
