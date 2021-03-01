import java.util.*;
public class Day3 {
    
    // 1656. Design an Ordered Stream

    class OrderedStream {
    
        String[] stream;
        int ptr;
        
        public OrderedStream(int n) {
            this.ptr = 1;
            this.stream = new String[n+1];
            // System.out.println(stream[1]);
        }
        
        public List<String> insert(int idKey, String value) {
            List<String> ans = new ArrayList<>();
            
            stream[idKey] = value;
            
            if(ptr==idKey){
                while(ptr<stream.length && stream[ptr]!=null){
                    ans.add(stream[ptr]);
                    ptr++;
                }
                
            }
            return ans;
        }
    }


    // 1290. Convert Binary Number in a Linked List to Integer

    public int getDecimalValue(ListNode head) {
        // 1 0 1
        
        int i = 0;
        int ans = 0;
        
        ArrayList<Integer> digits = new ArrayList<>();
        while(head!=null){
            digits.add(head.val);
            head = head.next;
        }
        
        for(int k=digits.size()-1;k>=0;k--){
            int a = digits.get(k);
            ans += a*((int)Math.pow(2,i));
            i++;
        }
        
        return ans;
    }


    // 1688. Count of Matches in Tournament

    public int numberOfMatches(int n) {
        int count=0;
        while(n>1){
            if(n%2==0){
                count+=n/2;
                n = n/2;
                
            }
            else{
                count+= (n-1)/2;
                n = ((n-1)/2)+1;
            }
        }
        
        return count;
    }


    // 1588. Sum of All Odd Length Subarrays

    public int sumOddLengthSubarrays(int[] arr) {
        
        int n = arr.length;
        int ans =0;
        for(int i=0;i<n;i++){
        ArrayList<Integer> smallAns = new ArrayList<>();
        for(int j=i;j<n;j++){
            
            
            smallAns.add(arr[j]);
            
            if(smallAns.size()%2==1){
                for(int a:smallAns) ans+= a;
            }
        }   
        
        }
        
        return ans;
    }


    // 1773. Count Items Matching a Rule

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int rk = 0;
        if(ruleKey.equals("type")){
            rk = 0;
        }
        else if(ruleKey.equals("color")){
            rk = 1;
        }
        else{
            rk = 2;
        }
        
        
        int count = 0;
        for(List<String> item:items){
            if(item.get(rk).equals(ruleValue)) count++;
        }
        
        return count;
        
    }

}
