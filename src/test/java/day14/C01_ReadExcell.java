package day14;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcell {
    @Test
    public void readExcelTest1() throws IOException {
        /*
Ara-->dosyaYolu
Windows Gezgini ile ac-->FileInputStream
Excel i ac-->Workbook
Sayfa1 e git-->Sheet
Satiri bul-->Row
         */
        //- Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);// Olusturmus oldugumuz dosyayi sistemde isleme alir.
        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //- WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);// Workbook objesi ile isleme fis ile akisa aldigimiz dosyamila bir excel dosyasi creat ettik.
        //- Sheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet = workbook.getSheet("Sayfa1");// Excel dosyamizda calismak istedigimiz sayfayi bu sekilde seceriz.
        //- Row objesi olusturun sheet.getRow(index)
        Row row = sheet.getRow(3);//sayfa bir deki 3. satiri bu sekilde seceriz
        //- Cell objesi olusturun row.getCell(index)
        Cell cell = row.getCell(3);//Satir secimi yapildiktan sonra hucre secimi bu sekilde yapilir.
        System.out.println(cell);
        //- 3. index'deki satirin 3. index'indeki datanin Cezayir oldugunu test edin
        String expectedData = "Cezayir";
        String actualData = cell.toString();
        Assert.assertEquals(expectedData,actualData);
        Assert.assertEquals(expectedData,cell.getStringCellValue());


    }
}
