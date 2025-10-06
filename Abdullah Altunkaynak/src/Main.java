import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, MalformedURLException {

        String imageSource = "Images\\1.png";
        String imageSource2 = "Images\\2.png";
        String imageSource3 = "Images\\4.png";

        ImageData data = ImageDataFactory.create(imageSource);
        ImageData data2 = ImageDataFactory.create(imageSource2);
        ImageData data3 = ImageDataFactory.create(imageSource3);

        Image image1 = new Image(data);
        Image image2 = new Image(data2);
        Image image3 = new Image(data3);

        String path = "C:/Users/Abdullah Altunkaynak/Desktop/İntelijproje.pdf";
        String paragraph = "Adı: Abdullah Altunkaynak\n" +
                "E-posta: 1230505028@ogr.klu.edu.tr\n" +
                "\n"+
                "Adres: Adana/Çukurova\n" +
                "\n" +
                "Tel no:05447249542\n"+
                "\n"+
                "Is Deneyimi\n" +
                "\n"+
                "1.\n"+
                "\n"+
                "Şirket: Atabey Yazilim\n" +
                "Görev:Web devoloper\n" +
                "Süre:2yil\n" +
                "\n" +
                "\n" +
                "2.\n" +
                "Şirket: Microsoft\n" +
                "Görev:Back-end devoloper\n" +
                "Süre:5yil\n" +
                "\n" +
                "\n"+
                "3.\n" +
                "Şirket: Tesla\n" +
                "Görev:Yapay zeka mühendisi\n" +
                "Süre:2aydır devam etmekte\n" +
                "\n" ;

        Paragraph p = new Paragraph(paragraph);
        PdfWriter pdfWriter = new PdfWriter(path);

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        image1.setWidth(350);
        image1.setHeight(350);
        image2.setWidth(350);
        image2.setHeight(350);
        image3.setWidth(350);
        image3.setHeight(350);

        Document document = new Document(pdfDocument);
        document.add(p);
        document.add(image1);
        document.add(image2);
        document.add(image3);

        document.close();

        System.out.println("Pdf Created");
    }
}