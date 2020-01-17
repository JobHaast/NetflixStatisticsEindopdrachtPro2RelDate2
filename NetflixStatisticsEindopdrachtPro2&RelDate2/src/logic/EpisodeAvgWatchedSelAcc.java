package logic;


public class EpisodeAvgWatchedSelAcc {
        private int episodeNumber;
        private int seasonNumber;
        private String nameEpisode;
        private int avgWatchedPercentage;

        public EpisodeAvgWatchedSelAcc(int episodeNumber, int seasonNumber, String nameEpisode, int avgWatchedPercentage){
            this.episodeNumber = episodeNumber;
            this.seasonNumber = seasonNumber;
            this.nameEpisode = nameEpisode;
            this.avgWatchedPercentage = avgWatchedPercentage;
        }

        public int getEpisodeNumber() {
            return episodeNumber;
        }

        public int getSeasonNumber() {
            return seasonNumber;
        }

        public String getNameEpisode() {
            return nameEpisode;
        }

        public int getAvgWatchedPercentage() {
            return avgWatchedPercentage;
        }

        public void setEpisodeNumber(int episodeNumber) {
            this.episodeNumber = episodeNumber;
        }

        public void setNameEpisode(String nameEpisode) {
            this.nameEpisode = nameEpisode;
        }

        public void setSeasonNumber(int seasonNumber) {
            this.seasonNumber = seasonNumber;
        }

        public void setAvgWatchedPercentage(int avgWatchedPercentage) {
            this.avgWatchedPercentage = avgWatchedPercentage;
        }


}
