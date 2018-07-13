// No.56 Merge Intervals
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        ArrayList<Interval> ans = new ArrayList<Interval>();
        int size = intervals.size();
        if(size < 1)return ans;
        if(size == 1)return intervals;
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        
        for(int i = 0; i < size-1; i ++){
            Interval cur = intervals.get(i);
            Interval next = intervals.get(i+1);
            if(cur.end < next.start){
                ans.add(cur);
            }else{
                next.start = Math.min(cur.start, next.start);
                next.end = Math.max(cur.end, next.end);
            }
        }
        ans.add(intervals.get(size - 1));
        return ans;
    }
}
