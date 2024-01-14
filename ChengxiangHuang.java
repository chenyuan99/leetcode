import java.util.*;

//You are provided with last week’s amazon music streaming data and you want to calculate what the top 10 streamed songs of that week were
//Input data: csv file with each line customerId, songId, timeOfStream
//[["1", "2", "3:30"], []]
//Output data: List of the top 10 songIds
//
//
//
//
//

public class ChengxiangHuang {
  public static String[] topSongs(String[][] data) {
    HashMap<String, Integer> map = new HashMap<>();
    PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((s1, s2) -> s1.getValue() - s2.getValue());
    for (String[] temp : data) {
      if (map.get(temp[1]) == null) {
        map.put(temp[1], 1);
      } else {
        map.put(temp[1], map.get(temp[1]) + 1);
      }
    }

    for (Map.Entry<String, Integer> set : map.entrySet()) {
      pq.add(set);
    }
    String[] res = new String[10];
    int i = 0;
    while (i < 10) {
      res[i] = pq.poll().getKey();
      i++;
    }
    return res;
  }

  public static void main(String[] args) {

    //

  }

  // My manager is usually busy, so it’s sometimes difficult to schedule some time
  // with him.
  // Given a sorted list of meeting start and end times (in minutes), determine if
  // I can schedule a 90 minute meeting with him during the workday (9am | 540min
  // - 5pm | 1,020 min)

  // Meetings can start every 15 minute interval

  // Example
  // busy = [[540, 600], [660, 860], [900,945]]
  // returns: false

  // busy = [[660, 720], [780,860], [920,980]]
  // returns: true
  // Early in the day you can schedule a 90 minute meeting: 540 - 630.

  public static boolean canMeeting(int[][] busy) {
    //define a legal meeting startTime x 540
    //define a legal meeting endTime
    int start = 540;
    int end = busy[0][0];
    if(end - start >= 15+90)return true;
    for (int i = 0; i < busy.length-1; i++) {
      start = busy[i][1];
      end = busy[i+1][0];
      if (end  - start >= 15+90+15)
        return true;
    }

    if (1020 - busy[busy.length-1][1] >=  90 + 15) return true;

    return false;

  }
}
