package logic;

public class Serie {
    private String title;
    private String language;
    private String genre;
    private String recommendation;

    public Serie(String title, String language, String genre, String recommendation) {
        this.title = title;
        this.language = language;
        this.genre = genre;
        this.recommendation = recommendation;
    }

    public String getLanguage() {
        return language;
    }

    public String getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }

    public String getRecommendation() {
        return recommendation;
    }
}

