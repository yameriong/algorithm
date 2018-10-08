package programmers.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class 베스트앨범 {

  @Test
  public void Test(){
    String[] genres = {"classic", "pop", "classic", "classic", "pop"};
    int[] plays = {500, 600, 150, 800, 2500};
    //getAlbumList(genres,plays);
    List<Integer> list = new ArrayList<>();
    Map<String,List<Integer>> map = new HashMap<>();
    for(Album album : getAlbumList(genres,plays)){
      log.debug("test {}", album.toString());
      if(!map.containsValue(map.get(album.getGenre()))){
        map.put(album.getGenre(),Arrays.asList(album.getGenreIndex(),album.getPlayIndex()));
      }

    }

    for(String an : map.keySet()){
      list.addAll(map.get(an));
    }


    log.debug("test {}", list.stream().mapToInt(i->i).toArray());
  }

  public List<Album> getAlbumList(String[] genres, int[] plays){
    List<Album> list = new ArrayList<>();
    List<Album> returnList = new ArrayList<>();
    Set<String> zipGenres = new HashSet<>();

    for (int i = 0; i <genres.length ; i++) {
      list.add(new Album(genres[i],plays[i],i));
      zipGenres.add(genres[i]);
    }

    for(String name : zipGenres){
      int index = 0;
      for(Album album : list.stream().filter(zip -> name.equals(zip.getGenre())).collect(Collectors.toList())){
        album.setPlayIndex(index);
          returnList.add(album);
        index++;
      }
    }

    returnList.sort(Comparator.comparing(Album::getPlay).reversed());


    return returnList;
  }

  @Data
  public class Album {
    String genre;
    int play;
    int genreIndex;
    int playIndex;

    /*public String getGenre() {
      return genre;
    }

    public void setGenre(String genre) {
      this.genre = genre;
    }

    public int getPlay() {
      return play;
    }

    public void setPlay(int play) {
      this.play = play;
    }

    public int getGenreIndex() {
      return genreIndex;
    }

    public void setGenreIndex(int genreIndex) {
      this.genreIndex = genreIndex;
    }

    public int getPlayIndex() {
      return playIndex;
    }

    public void setPlayIndex(int playIndex) {
      this.playIndex = playIndex;
    }*/

    public Album(String genre, int play, int genreIndex) {
      this.genre = genre;
      this.play = play;
      this.genreIndex = genreIndex;
    }
  }
}
