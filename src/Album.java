import java.util.ArrayList;
import java.util.*;

public class Album {

    private String artist;
    private String name;
    private List<Song> songs;

     //Album creation
    public Album(String artist,String name)
    {
        this.artist=artist;
        this.name=name;
        this.songs=new ArrayList<>();
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

    // find song present in Album
    boolean findSong(String title)
    {
        for(Song song:songs)
        {
            if(song.getTitle().equals(title))
            {
                return true;
            }
        }
        return false;
    }

    // add song to Album
    public String addSongToAlbum(String title,double duration)

    {
        if(!findSong(title))
        {
            Song song=new Song(title,duration);
            this.songs.add(song);
            return "Song has been added to Album";
        }
        return "Song Already exists";
    }
    //add song from Album
    public String addToPlaylistFromAlbum(String title,LinkedList<Song> playList)
    {
        for(Song song:songs)
        {
            if(song.getTitle().equals(title))
            {
                playList.add(song);
                return "Song has been added to your playlist";
            }
        }
        return "Song doesn't exits in album";
    }

    /**
     * polymorphism --methood overloading
     * @param songNo
     * @param playList
     * @return
     */

    public String addToPlaylistFromAlbum(int songNo,LinkedList<Song> playList)
    {
        int idx=songNo-1;
        if(idx>=0&&idx<songs.size())
        {
            playList.add(songs.get(idx));
            return "Song has been added to playlist";

        }
        return "Incorrect song number!!";
    }
}
