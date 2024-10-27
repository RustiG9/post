package util;

import model.Coordinat;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.util.Matrix;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PdfCreater {



    private PDDocument document;
    private PDPage page;
    private PDType0Font font;
    private PDPageContentStream contentStream;

    private String text;
    private int xCoordinat;

    private int fontSize;
    private final float halfFontSizeX = 0.244f;

    private float lineUnder = 1; // отступ линии от текста   --- вынести в настройки

    public void setLineUnder(float lineUnder) {   //// выше
        this.lineUnder = lineUnder;
    }

    private float correctIntervalText = 3;//интервал между строк ----- вынести в настройки

    public float getCorrectIntervalText() {
        return correctIntervalText;
    }

    public void setCorrectIntervalText(float correctIntervalText) {
        this.correctIntervalText = correctIntervalText;
    }

    private float xBefor;

    public float getXBefor() {
        return xCoordinat;
    }

    private float yBefor;

    public float getYBefor() {
        try {
            yBefor = fontSize * font.getStringWidth(text + " ") / 1000;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return yBefor;
    }

    private int yFinal;
    public int getyFinal() {
        return yFinal;
    }

    private int xFinal;
    public int getxFinal() {
        return xFinal;
    }

    private Font fontt;




    public void writingMultilineText(String text, int textSize, int fontSize, Coordinat coordinat, boolean underlining) throws IOException {


        this.fontSize = fontSize;
        this.text = text;

        xCoordinat = coordinat.getX();
        ///////////////////////////////////////////////////
        String[] words = text.split(" ");
        List<String> linesWords = new ArrayList<String>();
        String newText = "";


        float fontTextSize = fontSize * 17857f /32 * textSize / 1000;

        for (String word : words) {
            if (!newText.isEmpty()) {
                newText += " ";
            }

            float lenghtLineWords = (fontSize * font.getStringWidth(newText + word) / 1000);

            if (lenghtLineWords > fontTextSize) {
                if (!newText.isEmpty()) {
                }
                linesWords.add(newText);
                newText = word;
            } else {
                newText += word;
            }
        }

        linesWords.add(newText);


        for (String line : linesWords) {
            contentStream.beginText();
            contentStream.setFont(font, fontSize);
            contentStream.setTextMatrix(Matrix.getRotateInstance(Math.toRadians(90), xCoordinat, coordinat.getY()));

            // contentStream.setLeading(650.4f); //fontSize + correctIntervalText+
            contentStream.showText(line);
            contentStream.endText();

            if (underlining) {
                contentStream.setLineWidth(0.5f); // вынест в настройки
                contentStream.moveTo(xCoordinat - halfFontSizeX * fontSize + fontSize / 2 + lineUnder, coordinat.getY());
                contentStream.lineTo(xCoordinat - halfFontSizeX * fontSize + fontSize / 2 + lineUnder, coordinat.getY() + (int)fontTextSize);
                contentStream.stroke();

            }
            xFinal=(int)(xCoordinat - halfFontSizeX * fontSize + fontSize / 2 + lineUnder);
            yFinal = coordinat.getY() + (int)fontTextSize;
            xCoordinat += fontSize + correctIntervalText;
        }


    }

    public void linening(int x, int y, int fx, int fy) {
        try {
            contentStream.setLineWidth(0.5f);
            contentStream.moveTo(x,y);
            contentStream.lineTo(fx,fy);
            contentStream.stroke();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void creatPDF() {

        document = new PDDocument();
        page = new PDPage(); //создание стрницы
        page.setRotation(90);
        page.setMediaBox(PDRectangle.A4); // вынести в настройки

        try {
            fontt = Font.GEORGIABI;
            font = PDType0Font.load(document, new File(fontt.getPath())); //определяем шрифт  ---- вынести в настройки

            //font = PDType0Font.load(document, new File(this.getClass().getResource("time-roman-italic.ttf").getPath())); //определяем шрифт  ---- вынести в настройки
            //System.out.println(Font.ARIAL.getPath());
            document.addPage(page); //добавляем страницу в документ
            contentStream = new PDPageContentStream(document, page); //контент для страницы
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closePDF() {
        try {
            contentStream.close();

            System.out.println(fontt);
            document.save("fileformat"+fontt+".pdf"); //сохранение ПДФ
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int textSizeFont (String text) {
        return (int) (fontSize * 17857f /32 * text.length() / 1000);
    }


}