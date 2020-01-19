package logic;

public class Film {
    private String title;
    private int length;
    private String language;
    private String genre;
    private String ageGroup;

    public Film(String title, int length, String language, String genre, String ageGroup) {
        this.title = title;
        this.length = length;
        this.language = language;
        this.genre = genre;
        this.ageGroup = ageGroup;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public String getGenre() {
        return genre;
    }

    public String getLanguage() {
        return language;
    }
}
