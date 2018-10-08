package programmers.hash;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class 수박 {
  @Test
  public void Test(){
    int cnt = 9;
    //log.debug("msg {}", msg(cnt));
  }

  public String msg (int cnt){
    StringBuilder sb = new StringBuilder();
    if(cnt%2 >0){
      for (int i = 0; i < cnt/2; i++) {
        sb.append("programmers.hash.수박");
      }
      sb.append("수");
      return sb.toString();

    }
    for (int i = 0; i < cnt/2; i++) {
      sb.append("programmers.hash.수박");
    }
    return sb.toString();
  }
}
