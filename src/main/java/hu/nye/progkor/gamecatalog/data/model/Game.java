package hu.nye.progkor.gamecatalog.data.model;

import java.util.Objects;

/**
 * Game.
 */
public class Game {
    private Long Id;
    private String name;
    public int release_year;
    private String publisher;
    private String studio;
    private Genre genre;
    private int game_time;
    private int storage_space;

    public Game(Long id, String name, int release_year, String publisher, String studio, Genre genre, int game_time, int storage_space) {
        Id = id;
        this.name = name;
        this.release_year = release_year;
        this.publisher = publisher;
        this.studio = studio;
        this.genre = genre;
        this.game_time = game_time;
        this.storage_space = storage_space;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getGame_time() {
        return game_time;
    }

    public void setGame_time(int game_time) {
        this.game_time = game_time;
    }

    public int getStorage_space() {
        return storage_space;
    }

    public void setStorage_space(int storage_space) {
        this.storage_space = storage_space;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        if (release_year != game.release_year) return false;
        if (game_time != game.game_time) return false;
        if (storage_space != game.storage_space) return false;
        if (!Objects.equals(Id, game.Id)) return false;
        if (!Objects.equals(name, game.name)) return false;
        if (!Objects.equals(publisher, game.publisher)) return false;
        if (!Objects.equals(studio, game.studio)) return false;
        return genre == game.genre;
    }

    @Override
    public int hashCode() {
        int result = Id != null ? Id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + release_year;
        result = 31 * result + (publisher != null ? publisher.hashCode() : 0);
        result = 31 * result + (studio != null ? studio.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + game_time;
        result = 31 * result + storage_space;
        return result;
    }

    @Override
    public String toString() {
        return "Game{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", release_year=" + release_year +
                ", publisher='" + publisher + '\'' +
                ", studio='" + studio + '\'' +
                ", genre=" + genre +
                ", game_time=" + game_time +
                ", storage_space=" + storage_space +
                '}';
    }
}
