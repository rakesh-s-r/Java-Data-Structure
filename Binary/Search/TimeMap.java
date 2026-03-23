package Binary.Search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

class TimeMapKey {
    int time;
    String name;

    TimeMapKey(int time, String name) {
        this.time = time;
        this.name = name;
    }
}

public class TimeMap {
    HashMap<String, ArrayList<TimeMapKey>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new TimeMapKey(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        ArrayList<TimeMapKey> list = map.get(key);
        Optional<TimeMapKey> obj = evaluate(list, timestamp);
        if (obj.isEmpty()) {
            return "";
        }
        return obj.get().name;
    }

    public Optional<TimeMapKey> evaluate(ArrayList<TimeMapKey> list, int timestamp) {
        int left = 0, right = list.size() - 1;
        TimeMapKey res = null;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid).time == timestamp) {
                return Optional.ofNullable(list.get(mid));
            } else if (timestamp < list.get(mid).time) {
                right = mid - 1;
            } else {
                res = list.get(mid);
                left = mid + 1;
            }
        }
        return Optional.ofNullable(res);
    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);
        System.out.println(timeMap.get("foo", 1));
        System.out.println(timeMap.get("foo", 3));
    }
}
