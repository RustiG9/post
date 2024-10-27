package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Letter {
    private final StringProperty fromName;
    private final StringProperty toName;
    private final StringProperty fromAddress;
    private final StringProperty toAddress;

    private final IntegerProperty indexFrom;
    private final IntegerProperty indexTo;


    public Letter(String fromName, String toName, String fromAddres, String toAddress, int indexFrom, int indexTo) {
        this.fromName = new SimpleStringProperty(fromName);
        this.toName = new SimpleStringProperty(toName);

        this.toAddress = new SimpleStringProperty(toAddress);
        this.fromAddress = new SimpleStringProperty(fromAddres);
        this.indexFrom = new SimpleIntegerProperty(indexFrom);
        this.indexTo = new SimpleIntegerProperty(indexTo);
    }


    public String getFromName() {
        return fromName.get();
    }

    public StringProperty fromNameProperty() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName.set(fromName);
    }

    public String getToName() {
        return toName.get();
    }

    public StringProperty toNameProperty() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName.set(toName);
    }

    public String getFromAddress() {
        return fromAddress.get();
    }

    public StringProperty fromAddressProperty() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress.set(fromAddress);
    }

    public String getToAddress() {
        return toAddress.get();
    }

    public StringProperty toAddressProperty() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress.set(toAddress);
    }


    public int getIndexFrom() {
        return indexFrom.get();
    }

    public IntegerProperty indexFromProperty() {
        return indexFrom;
    }

    public void setIndexFrom(int indexFrom) {
        this.indexFrom.set(indexFrom);
    }

    public int getIndexTo() {
        return indexTo.get();
    }

    public IntegerProperty indexToProperty() {
        return indexTo;
    }

    public void setIndexTo(int indexTo) {
        this.indexTo.set(indexTo);
    }

    public String getFrom() {
        return "От кого";
    }

    public String getTo() {
        return "Кому";
    }

    public String getFromWhere() {
        return "Откуда";
    }

    public String getToWhere() {
        return "Куда";
    }

    @Override
    public String toString() {
        return "От кого - " + fromName.get() + "\n" +
                "Откуда - " + fromAddress.get() + "\n" +
                "Индекс отправителя - " + indexFrom.get() + "\n" +
                "Кому - " + toName.get() + "\n" +
                "Куда - " + toAddress.get() + "\n" +
                "Индекс получател - " + indexTo.get();
    }

}
