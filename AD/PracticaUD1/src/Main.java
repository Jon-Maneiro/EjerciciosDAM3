import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        try{
            //Creamos una variable para llevar los ID al momento
            //Inicializada a 0 porque la primera linea no la queremos
            int contid = 0;

            FileInputStream file = new FileInputStream(new File("Bestiario.xlsx"));
            //Creamos la instancia del workbook que tiene la referencia al excel
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            //Obtenemos la Hoja deseada del excel
            XSSFSheet sheet = workbook.getSheetAt(0);

            //Iteramos sobre las filas una a una
            Iterator<Row> rowIterator = sheet.iterator();
            while(rowIterator.hasNext()){
                Row row = rowIterator.next();
                //Por cada fila iteramos sobre las columnas
                Iterator<Cell> cellIterator = row.cellIterator();
                if(contid > 0) {
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        //Comprobamos el tipo de la celda para leer
                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_NUMERIC:
                                System.out.print(cell.getNumericCellValue() + " ");
                                break;
                            case Cell.CELL_TYPE_STRING:
                                System.out.print(cell.getStringCellValue() + " ");
                                break;
                        }
                    }
                }
                System.out.println("");
                contid++;
            }
            file.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}