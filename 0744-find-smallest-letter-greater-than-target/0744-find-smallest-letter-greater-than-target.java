class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        //Basic BinarySearch approach (2 Pointer)
        int n = letters.length;

        int lp = 0, rp = n - 1, ans = n;

        while(lp <= rp){
            int mid = (rp + lp) / 2;

            if(target < letters[mid]) {
                ans = mid;
                rp = mid - 1;
            }else{
                lp = mid + 1;
            }
        }

        return letters[ans%n];
    }
}