public class Day2{

    // 1720. Decode XORed Array

    public int[] decode(int[] encoded, int first) {
        
        // XOR ^
        // x^y = ((~x)&y) | (x&(~y));
        
        //  arr[i+1] = encoded[i] XOR arr[i].

        int[] ans = new int[encoded.length+1];
        ans[0] = first;
        for(int i=0;i<encoded.length;i++){
            ans[i+1] = encoded[i] ^ ans[i];
        }

        return ans;
    }

    // 1389. Create Target Array in the Given Order

    public int[] createTargetArray(int[] nums, int[] index) {
        int[] tar = new int[nums.length];
        
        for(int i=0;i<nums.length;i++){
            int idx = index[i];
            int val = nums[i];
            
            int prev = tar[idx];
            tar[idx] = val;
            for(int j=idx+1;j<tar.length;j++){
                int temp = tar[j];
                tar[j] = prev;
                prev = temp;
            }
        }
        
        return tar;
    }

    // 1221. Split a String in Balanced Strings

    public int balancedStringSplit(String s) {
        int count = 0;
        
        int balance = 0;
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            
            if(c=='L') balance--;
            else balance++;
            
            if(balance==0) count++;
            
        }
        
        return count;
    }

    // 1486. XOR Operation in an Array

    public int xorOperation(int n, int start) {
        int[] nums = new int[n];
        
        for(int i=0;i<n;i++){
            nums[i] = start + 2*i;
        }
        
        int ans = 0;
        
        for(int i=0;i<n;i++){
            ans = ans ^ nums[i];
        }
        
        return ans;
    }

    // 938. Range Sum of BST
    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
            TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
         }

    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null) return 0;
        
        int ans = 0;
        if(root.val >= low && root.val <=high) ans+= root.val;
        
        ans += rangeSumBST(root.left,low,high);
        ans += rangeSumBST(root.right,low,high);
        
        return ans;
    }


    // 1662. Check If Two String Arrays are Equivalent

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {   
        String first = "";
        
        for(int i=0;i<word1.length;i++){
            first+= word1[i];
        }
        
        String second = "";
        for(int i=0;i<word2.length;i++){
            second+=word2[i];
        }

        return first.equals(second);
    }

    // 1684. Count the Number of Consistent Strings

    public int countConsistentStrings(String allowed, String[] words) {
        
        int count = 0;
        
        for(int i=0;i<words.length;i++){
            boolean flag2 = true;
            for(int j=0;j<words[i].length();j++){
                boolean flag = false;
                char c1 = words[i].charAt(j);
                for(int k=0;k<allowed.length();k++){
                    char c2 = allowed.charAt(k);
                    if(c1==c2){
                        flag = true;
                        break;
                    }
                }
                
                if(!flag) flag2 = false;
            }
            
            if(flag2) count ++;
        }
        
        return count;
    }

}