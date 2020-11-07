package pers.captain.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> res;
    List<Integer> temp;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        temp = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates,target,0,0);
        return res;
    }
    public void dfs(int[] candidates,int target,int curSum,int cur_index){
        if(curSum == target){
            res.add(new ArrayList<>(temp));
            return;
        }else if(curSum>target){
            return;
        }
        for(int i = cur_index;i<candidates.length;i++){
            if(i > cur_index && candidates[i] == candidates[i-1]){
                continue;
            }
            temp.add(candidates[i]);
            dfs(candidates,target,curSum+candidates[i],i+1);
            temp.remove(temp.size()-1);
        }
    }
}