import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String target = normalize(m);

        String answer = "(None)";
        int bestDuration = -1; 

        for (String info : musicinfos) {
            String[] parts = info.split(",");
            String start = parts[0];
            String end   = parts[1];
            String title = parts[2];
            String code  = normalize(parts[3]);

            int duration = getPlayTime(start, end);

            String played = buildPlayed(code, duration);
            if (played.contains(target)) {
                if (duration > bestDuration) {
                    bestDuration = duration;
                    answer = title;
                }
            }
        }
        return answer;
    }

    private int getPlayTime(String start, String end) {
        int sh = Integer.parseInt(start.substring(0, 2));
        int sm = Integer.parseInt(start.substring(3, 5));
        int eh = Integer.parseInt(end.substring(0, 2));
        int em = Integer.parseInt(end.substring(3, 5));
        return (eh * 60 + em) - (sh * 60 + sm);
    }

     private String normalize(String s) {
        return s.replace("C#", "c")
                .replace("D#", "d")
                .replace("E#", "e")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a")
                .replace("B#", "b");
    }

    private String buildPlayed(String code, int duration) {
        if (code.length() >= duration) {
            return code.substring(0, duration);
        }
        StringBuilder sb = new StringBuilder(duration);
        for (int i = 0; i < duration; i++) {
            sb.append(code.charAt(i % code.length()));
        }
        return sb.toString();
    }
}
