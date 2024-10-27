package model;

import util.PdfCreater;

import java.io.IOException;

public class PdfLetter {
    private int textSize = 50; // вынести в настройки
    private int fontSize = 12; // вынести в настройки
    private float correctIndexSize = 100; //ширина поля индекса ------  вынести данную в настройки


    private Letter letter;

    private PdfCreater pdfCreater = new PdfCreater();

    private Setting setting = new Setting();// вынесьт в настройки

    public Setting getSetting() {
        return setting;
    }
    private Coordinat fromCoordinat = new Coordinat(setting.getStartX(), setting.getStartY());
    private Coordinat toCoordinat = new Coordinat(setting.getStartToX(), setting.getStartToY());

    public PdfLetter(Letter letter) {
        this.letter = letter;
    }

    public PdfCreater getPdfCreater() {
        return pdfCreater;
    }

    public void creat() throws IOException {
        pdfCreater.creatPDF();

        String indexFrom = String.valueOf(letter.getIndexFrom());
        String indexTo = String.valueOf(letter.getIndexTo());

        try {
            pdfCreater.writingMultilineText(letter.getFrom(), textSize, fontSize, fromCoordinat, false);
            fromCoordinat.setY(fromCoordinat.getY() + (int) pdfCreater.getYBefor());

            pdfCreater.writingMultilineText(letter.getFromName(), textSize, fontSize, fromCoordinat, true);
            fromCoordinat.setX((int) pdfCreater.getXBefor());
            fromCoordinat.setY(setting.getStartY());

            pdfCreater.writingMultilineText(letter.getFromWhere() + " ", textSize, fontSize, fromCoordinat, false);
            fromCoordinat.setY(fromCoordinat.getY() + (int) pdfCreater.getYBefor());

            pdfCreater.writingMultilineText(letter.getFromAddress(), textSize, fontSize, fromCoordinat, true);
            fromCoordinat.setX(pdfCreater.getxFinal());
            int x = fromCoordinat.getX();
            fromCoordinat.setY(pdfCreater.getyFinal() - pdfCreater.textSizeFont(String.valueOf(letter.getIndexFrom()))- (int)correctIndexSize/2);

            //////// индекс отправителя
            pdfCreater.writingMultilineText("индекс отправителя", 30,fontSize/2,new Coordinat(fromCoordinat.getX()+fontSize/2,fromCoordinat.getY()-(int)pdfCreater.textSizeFont("индекс отправителя")/20),false);
            fromCoordinat.setX((int)(pdfCreater.getxFinal()+fontSize/1.2));

            pdfCreater.writingMultilineText(String.valueOf(letter.getIndexFrom()), indexFrom.length(), fontSize,fromCoordinat ,false);// написть для индека отправителя

            pdfCreater.linening(pdfCreater.getxFinal(),
                    fromCoordinat.getY()- (int)correctIndexSize/2,
                    pdfCreater.getxFinal(),
                    fromCoordinat.getY()+ pdfCreater.textSizeFont(String.valueOf(letter.getIndexFrom()))+(int)correctIndexSize/2); //нижняя черта

            pdfCreater.linening(x,
                    fromCoordinat.getY()- (int)correctIndexSize/2,
                    pdfCreater.getxFinal(),
                    fromCoordinat.getY()- (int) correctIndexSize/2); // левая вертикаль

            pdfCreater.linening(x,
                    fromCoordinat.getY()+ pdfCreater.textSizeFont(String.valueOf(letter.getIndexFrom()))+(int)correctIndexSize/2,
                    pdfCreater.getxFinal(),
                    fromCoordinat.getY()+ pdfCreater.textSizeFont(String.valueOf(letter.getIndexFrom()))+(int)correctIndexSize/2); // правая вертикаль

            //////// индекс получателя
            pdfCreater.writingMultilineText(letter.getTo(), textSize, fontSize, toCoordinat, false);
            toCoordinat.setY(toCoordinat.getY() + (int) pdfCreater.getYBefor());

            pdfCreater.writingMultilineText(letter.getToName(), textSize, fontSize, toCoordinat, true);
            toCoordinat.setX((int) pdfCreater.getXBefor());
            toCoordinat.setY(setting.getStartToY());

            pdfCreater.writingMultilineText(letter.getToWhere() + " ", textSize, fontSize, toCoordinat, false);
            toCoordinat.setY(toCoordinat.getY() + (int) pdfCreater.getYBefor());

            pdfCreater.writingMultilineText(letter.getToAddress(), textSize, fontSize, toCoordinat, true);
            toCoordinat.setX(pdfCreater.getxFinal());
            x=toCoordinat.getX();
            toCoordinat.setY(pdfCreater.getyFinal() - pdfCreater.textSizeFont(String.valueOf(letter.getIndexTo()))- (int)correctIndexSize/2);

            pdfCreater.writingMultilineText("индекс получателя", 18,fontSize/2,new Coordinat(toCoordinat.getX()+fontSize/2,toCoordinat.getY()-(int)pdfCreater.textSizeFont("индекс получателя")/20),false);
            toCoordinat.setX((int)pdfCreater.getXBefor()+(int)pdfCreater.getCorrectIntervalText());
            pdfCreater.writingMultilineText(String.valueOf(letter.getIndexTo()), indexTo.length(), fontSize,toCoordinat ,false);// написть для индека ПОЛУЧАТЕЛЯ
            pdfCreater.linening(pdfCreater.getxFinal(),toCoordinat.getY()- (int)correctIndexSize/2,pdfCreater.getxFinal(),toCoordinat.getY()+ pdfCreater.textSizeFont(String.valueOf(letter.getIndexTo()))+(int)correctIndexSize/2); // нижняя черта
            pdfCreater.linening(x,toCoordinat.getY()- (int)correctIndexSize/2,pdfCreater.getxFinal(),toCoordinat.getY()- (int) correctIndexSize/2); // левая вертикаль
            pdfCreater.linening(x,toCoordinat.getY()+ pdfCreater.textSizeFont(String.valueOf(letter.getIndexTo()))+(int)correctIndexSize/2,pdfCreater.getxFinal(),toCoordinat.getY()+ pdfCreater.textSizeFont(String.valueOf(letter.getIndexTo()))+(int)correctIndexSize/2); // правая вертикаль

        } catch (IOException e) {
            e.printStackTrace();
        }

        pdfCreater.closePDF();


    }
}
