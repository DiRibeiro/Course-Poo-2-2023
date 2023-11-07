package fix3;

public class Titles {
    int ISBN;
    String title;
    int edition;
    String copyright;

    public Titles(int ISBN, String title, int edition, String copyright) {
        this.ISBN = ISBN;
        this.title = title;
        this.edition = edition;
        this.copyright = copyright;
    }

    public Titles(String title, int edition, String copyright) {
        this.title = title;
        this.edition = edition;
        this.copyright = copyright;
    }

    public int getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public int getEditionNumber() {
        return edition;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEditionNumber(int editionNumber) {
        this.edition = editionNumber;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }
}