// Helper class to store value and timestamp
class Pair {
    String value;
    Integer timeStamp;

    public Pair(String value, Integer timeStamp) {
        this.value = value;
        this.timeStamp = timeStamp;
    }
}

class TimeMap {
    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair pair = new Pair(value, timestamp);
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(pair); // Adds to the existing arrayList if present or creates new arraylist and adds the values of the Pair.
    }
    
    public String get(String key, int timestamp) {
        List<Pair> values = map.getOrDefault(key, new ArrayList<>());
        int left = 0;
        int right = values.size() - 1;
        String result = "";

        // Performing Binary Search to find the largest timeStamp_prev value.
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (values.get(mid).timeStamp <= timestamp) {
                result = values.get(mid).value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */