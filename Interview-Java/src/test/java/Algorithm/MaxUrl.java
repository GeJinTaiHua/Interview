package Algorithm;

import org.junit.Test;

import java.util.*;

/*
 * @desc 100万个URL如何找到出现频率最高的前100个
 * 将url和个数保存到HashMap中，按照个数排序
 * @author wjl
 * @date 2018/8/29 0029
 */
public class MaxUrl {
    private List<String> urlList = new ArrayList<>();

    @Test
    public void test() {
        HashMap<String, Integer> urlMap = new HashMap<>();
        init();
        for (String url : urlList) {
            if (urlMap.get(url) == null) {
                urlMap.put(url, 1);
            } else {
                urlMap.put(url, urlMap.get(url) + 1);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(urlMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue() - o1.getValue());
            }
        });

        for (int i = 0; i < list.size(); i++) {
            //  String id = list.get(i).toString();
            String key = list.get(i).getKey();
            Integer value = list.get(i).getValue();
            System.out.println("url：" + key + "；出现次数：" + value);
        }
    }

    private void init() {
        urlList.add("http://www.5.com");
        urlList.add("http://www.5.com");
        urlList.add("http://www.5.com");
        urlList.add("http://www.2.com");
        urlList.add("http://www.4.com");
        urlList.add("http://www.2.com");
        urlList.add("http://www.1.com");
        urlList.add("http://www.4.com");
        urlList.add("http://www.3.com");
        urlList.add("http://www.4.com");
        urlList.add("http://www.3.com");
        urlList.add("http://www.5.com");
        urlList.add("http://www.5.com");
        urlList.add("http://www.3.com");
        urlList.add("http://www.4.com");
    }
}
