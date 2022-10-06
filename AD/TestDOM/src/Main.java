import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("empleados.dat");
        RandomAccessFile fichero = new RandomAccessFile(file, "rw");

        // Identificador, entero de 4 bytes
        //• Apellido, cadena de 10 caracteres, 20 bytes (2 por cada, al ser caracteres UNICODE)
        //• Departamento, entero de 4 bytes
        //• Salario, doble de 8 bytes

        ArrayList<Empleado> empleados = new ArrayList<>();
        Empleado empAct;
        char[] apellido = new char[10];
        long longitud = fichero.length();
        fichero.seek(0);
        while (fichero.getFilePointer() < longitud) {

            int id = fichero.readInt();
            for (int x = 0; x < 10; x++) {
                apellido[x] = fichero.readChar();
            }
            String s = new String(apellido);
            String ape = s.trim();

            int dep = fichero.readInt();

            double salario = fichero.readDouble();
            empAct = new Empleado(id, ape, dep, salario);
            empleados.add(empAct);

        }

        fichero.close();


        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder builder = factory.newDocumentBuilder();

            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "Empleados", null);
            document.setXmlVersion("1.0");


            /**
             *
             * Recorrer el fichero .dat para sacar los datos
             *
             *
             */
            for (int x = 0; x < empleados.size(); x++) {

                empAct = empleados.get(x);

                Element raiz = document.createElement("empleado");
                document.getDocumentElement().appendChild(raiz);
                //Añadir los hijos
                crearElemento("id", Integer.toString(empAct.getId()) , raiz, document);
                crearElemento("apellido",empAct.getApellido() , raiz, document);
                crearElemento("departamento",Integer.toString(empAct.getDep()) , raiz, document);
                crearElemento("salario",Double.toString(empAct.getSalario()) , raiz, document);

                Source source = new DOMSource(document);

                Result result = new StreamResult(new java.io.File("Empleados.xml"));

                Transformer transformer = TransformerFactory.newInstance().newTransformer();

                transformer.transform(source,result);

                Result console = new StreamResult(System.out);
                transformer.transform(source,console);
            }
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }

    }

    static void crearElemento(String datoEmple, String valor, Element raiz, Document document) {
        Element elem = document.createElement(datoEmple);
        Text text = document.createTextNode(valor);
        raiz.appendChild(elem);
        elem.appendChild(text);
    }


}