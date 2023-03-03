package scaler.mentor;

import common.TreeNode;

public class ClosestMatch {
    public static int matchClosest(TreeNode node, int target, int closest) {
        if (node == null) {
            return closest;
        }
        
        closest = Math.min(Math.abs(node.value - closest), Math.abs(node.value - target));
        
        if (closest == target) {
            return target;
        }
        if (target < node.value) 
            return matchClosest(node.left, target, closest);
        
        if (target > node.value) 
            return matchClosest(node.right, target, closest);
    
        
        return closest;
        
    }
}
