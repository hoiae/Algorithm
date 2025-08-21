import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> nameByUid = new HashMap<>();
        List<String[]> logs = new ArrayList<>();

        for (String rec : record) {
            String[] parts = rec.split(" ");
            String action = parts[0];
            String uid = parts[1];

            if ("Enter".equals(action)) {
                String nickname = parts[2];
                nameByUid.put(uid, nickname);
                logs.add(new String[]{uid, "Enter"});
            } else if ("Leave".equals(action)) {
                logs.add(new String[]{uid, "Leave"});
            } else {
                String nickname = parts[2];
                nameByUid.put(uid, nickname);
            }
        }

        String[] answer = new String[logs.size()];
        int i = 0;
        for (String[] log : logs) {
            String uid = log[0];
            String action = log[1];
            String nickname = nameByUid.get(uid);

            if ("Enter".equals(action)) {
                answer[i++] = nickname + "님이 들어왔습니다.";
            } else { // Leave
                answer[i++] = nickname + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}
