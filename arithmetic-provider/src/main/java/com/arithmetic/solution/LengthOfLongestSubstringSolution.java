package com.arithmetic.solution;import java.util.HashMap;import java.util.HashSet;import java.util.Map;import java.util.Set;/** * @author Zhang Yu * @date 2021/7/27 11:34 下午 */public class LengthOfLongestSubstringSolution {    /**     * 最长子串     *     * @param s     * @return     */    public int lengthOfLongestSubstring(String s) {        Set<Character> occ = new HashSet<>();        int length = s.length();        if (length == 0) {            return 0;        }        if (length == 1) {            return 1;        }        //最长子串数量        int ans = 0;        for (int i = 0; i < length; i++) {            occ.add(s.charAt(i));            for (int j = i + 1; j < length; j++) {                if (occ.contains(s.charAt(j))) {                    if (ans < occ.size()) {                        ans = occ.size();                    }                    occ.clear();                    continue;                } else {                    occ.add(s.charAt(j));                    if (ans < occ.size()) {                        ans = occ.size();                    }                }            }            occ.clear();            if (ans > (length - i)) {                return ans;            }        }        return ans;    }    public int lengthOfLongestSubstring2(String s) {        int length = s.length();        int ans = 0;        Map<Character, Integer> map = new HashMap<>();        for (int end = 0, start = 0; end < length; end++) {            char charAt = s.charAt(end);            if (map.containsKey(charAt)){                start = Math.max(map.get(charAt), start);            }            ans = Math.max(ans, end - start + 1);            map.put(s.charAt(end), end + 1);        }        return ans;    }    public static void main(String[] args) {        LengthOfLongestSubstringSolution solution = new LengthOfLongestSubstringSolution();        int size = solution.lengthOfLongestSubstring("jbpnbwwd");        int jbpnbwwd = solution.lengthOfLongestSubstring2("jbpnbwwd");        System.out.println(size);    }}