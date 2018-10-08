package programmers.hash;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class 완주하지_못한_선수 {
  @Test
  public void TEST() {
    String[] participant = {"mislav", "stanko", "mislav", "ana"};
    String[] completion = {"stanko", "ana", "mislav"};
    List<String> participantList = arraytoList(participant);
    List<String> completionList = arraytoList(completion);
    participantList.sort(String.CASE_INSENSITIVE_ORDER);
    completionList.sort(String.CASE_INSENSITIVE_ORDER);

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < completionList.size(); i++) {
      for (int j = 0; j < participantList.size(); j++) {
        log.debug("list.get(i) : {} list2.get(i) : {}", participantList.get(j),completionList.get(i));
        if (completionList.get(i).equals(participantList.get(j))){
          participantList.remove(j);
          break;
        }

      }
    }

    for(String name : participantList){
      sb.append(name);
    }

    String returnName = sb.toString();
    log.debug("list : {}", returnName);
  }

  public List<String> arraytoList(String[] array){
    return Arrays.stream(array).collect(Collectors.toList());
  }
}