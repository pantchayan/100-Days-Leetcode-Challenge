import java.util.*;

public class Day1 {
    // DAY 1 QUES
    // 1480. Running Sum of 1d Array
    public int[] runningSum(int[] nums) {
        int[] ans = new int[nums.length];

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            ans[i] = sum;
        }

        return ans;

    }

    // 1108. Defanging an IP Address
    public String defangIPaddr(String address) {
        String ans = "";

        for (int i = 0; i < address.length(); i++) {
            int c = address.charAt(i);
            if (c == 46) {
                ans += "[.]";
            } else {
                ans += address.charAt(i);
            }
        }

        return ans;
    }

    // 1431. Kids With the Greatest Number of Candies
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = -1;

        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }

        List<Boolean> ans = new ArrayList<>();

        for (int i = 0; i < candies.length; i++) {
            if (candies[i] >= max) {
                ans.add(true);
            } else if (candies[i] + extraCandies >= max) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }

        return ans;
    }

    // 1470. Shuffle the Array
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];

        int k = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            ans[i] = nums[k];
            k++;
        }

        for (int i = 1; i < nums.length; i += 2) {
            ans[i] = nums[k];
            k++;
        }

        return ans;
    }

    // 1672. Richest Customer Wealth
    public int maximumWealth(int[][] accounts) {

        int maxSum = -1;

        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[0].length; j++) {
                sum += accounts[i][j];
            }
            if (sum > maxSum)
                maxSum = sum;
        }

        return maxSum;
    }

    // 1512. Number of Good Pairs
    public int numIdenticalPairs(int[] nums) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j])
                    count++;
            }
        }

        return count;
    }

    // 771. Jewels and Stones
    public int numJewelsInStones(String jewels, String stones) {

        int count = 0;

        for (int i = 0; i < stones.length(); i++) {
            int c = stones.charAt(i);
            for (int j = 0; j < jewels.length(); j++) {
                int c2 = jewels.charAt(j);
                if (c == c2) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }

    // 1603. Design Parking System

    class ParkingSystem {
        int big = 0;
        int medium = 0;
        int small = 0;

        public ParkingSystem(int big, int medium, int small) {
            this.big = big;
            this.small = small;
            this.medium = medium;
        }

        public boolean addCar(int carType) {
            boolean ans = false;
            if (carType == 1) {
                if (this.big > 0) {
                    ans = true;
                    this.big--;
                }
            } else if (carType == 2) {
                if (this.medium > 0) {
                    ans = true;
                    this.medium--;
                }
            } else {
                if (this.small > 0) {
                    ans = true;
                    this.small--;
                }
            }

            return ans;
        }
    }

    // 1365. How Many Numbers Are Smaller Than the Current Number
    public int[] smallerNumbersThanCurrent(int[] nums) {

        int[] count = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    count[i]++;
                }
            }
        }

        return count;
    }

    // 1342. Number of Steps to Reduce a Number to Zero
    public int numberOfSteps(int num) {
        // // divide by 2
        // n = n >> 1;

        int steps = 0;
        while (num > 0) {

            if (isEven(num)) {
                num = num >> 1;
            } else {
                num--;
            }

            steps++;
        }

        return steps;

    }

    public boolean isEven(int n) {

        // n^1 is n+1, then even, else odd
        if ((n ^ 1) == n + 1)
            return true;
        else
            return false;
    }

    // 1528. Shuffle String

    public String restoreString(String s, int[] indices) {
        char[] charArr = new char[indices.length];

        int i = 0;
        for (int idx : indices) {
            charArr[idx] = s.charAt(i);
            i++;
        }

        String ans = "";
        for (char c : charArr) {
            ans += c;
        }

        return ans;

    }

    // 1281. Subtract the Product and Sum of Digits of an Integer

    public int subtractProductAndSum(int n) {
        int N = n;

        int prod = 1;
        int sum = 0;
        while (N >= 1) {
            int digit = N % 10;
            N = N / 10;

            prod *= digit;
            sum += digit;
        }

        return prod - sum;
    }

    // 1313. Decompress Run-Length Encoded List

    public int[] decompressRLElist(int[] nums) {
        ArrayList<Integer> ansAL = new ArrayList<>();

        for (int i = 0; i < nums.length; i += 2) {
            int freq = nums[i];
            int val = nums[i + 1];
            while (freq-- > 0) {
                ansAL.add(val);
            }
        }

        int[] ans = new int[ansAL.size()];

        int i = 0;
        for (int a : ansAL) {
            ans[i] = a;
            i++;
        }

        return ans;

    }

    // 1678. Goal Parser Interpretation
    public String interpret(String command) {
        String ans = "";

        for (int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);
            if (c == '(') {
                if (command.charAt(i + 1) == 'a') {
                    ans += "al";
                    i += 3;
                } else {
                    ans += "o";
                    i += 1;
                }
            } else {
                ans += "G";
            }
        }
        return ans;
    }

}