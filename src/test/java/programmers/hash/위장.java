package programmers.hash;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class 위장 {
  @Test
  public void test(){
    String[][] clothes = new String[][]{
        {"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}
    };
    List<Clothes> clothesList = new ArrayList<>(30);
    for (int i = 0; i <clothes.length ; i++) {
      clothesList.add(new Clothes(clothes[i][0],clothes[i][1]));
    }

    Map<String, Long> counting = clothesList.stream().collect(
        Collectors.groupingBy(Clothes::getParts, Collectors.counting()));

    int allCnt = 0;
    long multiplyCnt = 0;
    int getKey = 0;
    for (String key : counting.keySet()){
      getKey = Math.toIntExact(counting.get(key));
      allCnt+= getKey;
      allCnt+= multiplyCnt * getKey;
      multiplyCnt = getKey;
    }

    log.debug("x {}", allCnt);

  }

  public class Clothes {
    String clothe;
    String parts;

    public Clothes(String clothe, String parts) {
      this.clothe = clothe;
      this.parts = parts;
    }

    public String getClothe() {
      return clothe;
    }

    public void setClothe(String clothe) {
      this.clothe = clothe;
    }

    public String getParts() {
      return parts;
    }

    public void setParts(String parts) {
      this.parts = parts;
    }
  }
}
