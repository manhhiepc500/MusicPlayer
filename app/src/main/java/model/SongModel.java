package model;

/**
 * Created by hiepn on 8/22/2017.
 */

public class SongModel {
    public int image;
    public String name;
    public String path;
    public String album;
    public String artist;
    public int duration;

    public SongModel() {
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public SongModel(int image, String name, String path, String album, String artist, int duration) {
        this.image = image;
        this.name = name;
        this.path = path;
        this.album = album;
        this.artist = artist;
        this.duration = duration;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public String getAlbum() {
        return album;
    }

    public String getArtist() {
        return artist;
    }

    public int getDuration() {
        return duration;
    }
}