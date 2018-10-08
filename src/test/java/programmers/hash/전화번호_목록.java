package programmers.hash;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class 전화번호_목록 {
  //100% 완
  @Test
  public void TEST() {
    String[] phoneBook = {"123", "123456", "789"};
    Arrays.sort(phoneBook);
    log.debug("list : {}", hasNum(phoneBook));
  }

  public Boolean hasNum(String[] phoneBook){
    String number = phoneBook[0];
    for (int i = 1; i < phoneBook.length; i++) {
      if(phoneBook[i].matches(number+".*")){
        return false;
      }
    }
    return true;
  }
}

