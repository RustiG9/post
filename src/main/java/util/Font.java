package util;

enum Font {
    //private final static Map<String,File> nameFount = new HashMap<String ,File>();


    ARIAL("./src/main/resources/util/Fonts/arial.ttf"),
    ARIALI("./src/main/resources/util/Fonts/ariali.ttf"),
    ARIALB("./src/main/resources/util/Fonts/arialbd.ttf"),
    ARIALBI("./src/main/resources/util/Fonts/arialbi.ttf"),

    CALIBRI("./src/main/resources/util/Fonts/calibri.ttf"),
    CALIBRII("./src/main/resources/util/Fonts/calibrii.ttf"),
    CALIBRIB("./src/main/resources/util/Fonts/calibrib.ttf"),
    CALIBRIBI("./src/main/resources/util/Fonts/calibriz.ttf"),

    GEORGIA("./src/main/resources/util/Fonts/georgia.ttf"),
    GEORGIAI("./src/main/resources/util/Fonts/georgiai.ttf"),
    GEORGIAB("./src/main/resources/util/Fonts/georgiab.ttf"),
    GEORGIABI("./src/main/resources/util/Fonts/georgiaz.ttf"),

    TIMESNEWROMAN("./src/main/resources/util/Fonts/times.ttf"),
    TIMESNEWROMANI("./src/main/resources/util/Fonts/timesi.ttf"),
    TIMESNEWROMANB("./src/main/resources/util/Fonts/timesbd.ttf"),
    TIMESNEWROMANBI("./src/main/resources/util/Fonts/timesbi.ttf"),

    COMIC("./src/main/resources/util/Funfount/comicbd.ttf");








    private String path;
    Font (String path){
        this.path= path;
    }

    public String getPath() {
        return path;
    }
}
