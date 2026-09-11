class Solution {

    private int c2(int n){
        return n * (n-1) / 2;
    }
    public int totalNumbers(int[] digits) {
        int n = digits.length;
        // if the number is even -> the last digits must be event 
        // i can complicate the sol , but the constrains is okay to do a brute force
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n;++i){
            for (int j = 0; j < n; ++j){
                for (int k = 0; k < n; ++k){
                    if (i == j || i == k || j == k) continue;
                    int a = digits[i];
                    int b = digits[j];
                    int c = digits[k];
                    int number = a * 100 + b * 10 + c;
                    if (number >= 100 && number % 2 == 0) set.add(number);

                   
                }
            }
        }

        return set.size();
        
    }
}