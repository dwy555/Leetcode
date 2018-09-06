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
        List<Interval> ans = new ArrayList<Interval>();
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        });
        if(intervals.size() == 0)return ans;
        int start = intervals.get(0).start, end = intervals.get(0).end;
        for(int i = 1; i < intervals.size(); i++){
            Interval curr = intervals.get(i);
            if(end < curr.start){
                ans.add(new Interval(start, end));
                start = curr.start;
                end = curr.end;
            }else{
                start = Math.min(start, curr.start);
                end = Math.max(end, curr.end);
            }
        }
        ans.add(new Interval(start, end));
        return ans;
    }
}
