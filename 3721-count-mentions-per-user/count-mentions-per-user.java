import java.util.*;
import java.util.regex.*;

class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        Collections.sort(events, (a, b) -> {
            int compareSecond = Integer.parseInt(a.get(1)) - Integer.parseInt(b.get(1));
            if (compareSecond == 0) {
                return a.get(0).equals("OFFLINE") ? -1 : 1;
            }
            return compareSecond;
        });

        Set<Integer> onlineUsers = new HashSet<>();
        for (int i = 0; i < numberOfUsers; i++) {
            onlineUsers.add(i);
        }

        int[] ans = new int[numberOfUsers];
        Map<Integer, Integer> offlineMap = new HashMap<>();

        for (List<String> event : events) {
            String type = event.get(0);

            if (type.equals("MESSAGE")) {
                int timestamp = Integer.parseInt(event.get(1));
                processOffline(offlineMap, onlineUsers, timestamp);
                String mentions = event.get(2);
                if (mentions.equals("ALL")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        ans[i]++;
                    }
                } else if (mentions.equals("HERE")) {
                    for (int i : onlineUsers) {
                        ans[i]++;
                    }
                } else {
                    List<Integer> digits = new ArrayList<>();
                    Pattern pattern = Pattern.compile("\\d+");
                    Matcher matcher = pattern.matcher(mentions);

                    while (matcher.find()) {
                        digits.add(Integer.parseInt(matcher.group()));
                    }
                    for (int i : digits) {
                        ans[i]++;
                    }
                }
            } else {
                int timestamp = Integer.parseInt(event.get(1));
                int id = Integer.parseInt(event.get(2));
                offlineMap.put(id, timestamp);
                onlineUsers.remove(id);
            }
        }

        return ans;
    }

    private void processOffline(Map<Integer, Integer> offlineMap, Set<Integer> onlineUsers, int timestamp) {
        List<Integer> idsToRemove = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : offlineMap.entrySet()) {
            int id = entry.getKey();
            int time = entry.getValue();
            if (time + 60 <= timestamp) {
                idsToRemove.add(id);
            }
        }

        for (int id : idsToRemove) {
            offlineMap.remove(id);
            onlineUsers.add(id);
        }
    }
}