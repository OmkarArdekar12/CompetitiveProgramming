//Boyer-Moore Voting Algorithm - To find the majority element
//Majority Element is a element that appears more than n/2 times in the array of length n
 class BoyerMooreVotingAlgorithm {
    public static int getMajorityElement(int[] arr) {
        int n = arr.length;

        int res = 0;
        int count = 0;
        for(int i=0; i<n; ++i) {
            if(count == 0) {
                res = arr[i];
            }
            count += res == arr[i] ? 1 : -1;
        }

        return res;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 1, 2, 1}; //majority element = 1
        System.out.println(getMajorityElement(arr));
    }
}