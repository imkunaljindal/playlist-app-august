import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {

    private String artist;
    private String name;
    private List<Song> songs;

    public Album() {
    }

    public Album(String artist, String name) {
        this.artist = artist;
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    // functionalities in the album
    public boolean findSong(String title){
        for(Song song: songs){
            if(song.getTitle().equals(title)){
                return true;
            }
        }
        return false;
    }

    // add song
    public String addSongToAlbum(String title, double duration){

        if(!findSong(title)){
            //add
            Song song = new Song(title, duration);
            this.songs.add(song);
            return "Song has been added to the Album";
        }
        return "Song already exists";
    }

    // add to playList from album
    public String addToPlaylistFromAlbum(String title, LinkedList<Song> playList){

            for(Song song: songs) {
                if (song.getTitle().equals(title)) {
                    playList.add(song);
                    return "Song has been added to your playlist";
                }
            }

        return "Song doesn't exist in album";
    }

    /**
     * polymorphism: method overloarding
     * @param songNo
     * @param playList
     * @return
     */
    public String addToPlaylistFromAlbum(int songNo, LinkedList<Song> playList){
        int index = songNo - 1;
        if(index>=0 && index<songs.size()){
            playList.add(songs.get(index));
            return "Song has been added successfully";
        }

        return "Incorrect song number!!";
    }
}
