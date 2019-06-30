import java.util.*;
public class ValueHolder {

    protected SortedMap<String, Double> map = new TreeMap<String, Double>();

    public SortedMap<String, Double> getMap() {
        return map;
    }

    public void editValue(String str,Double value) {
        map.put(str,value);
    }

}
