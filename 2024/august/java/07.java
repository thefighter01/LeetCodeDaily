class Solution {
    private static final String[] k0 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
    private static final String[] k1 = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
    private static final String[] k2 = { "", "" ,  "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
    private static final String [] q = { " Billion" ,  " Million" ,  " Thousand" };
    private String convert(int cur){
        if (cur == 0) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(cur);
        StringBuilder ans = new StringBuilder("");
        while(sb.length() < 3){
           sb.insert(0 , "0");
        }
        if (sb.charAt(0) != '0'){
              ans.append(" ");
            ans.append(k0[sb.charAt(0)-'0']);
            ans.append(" Hundred");
        }
        if (sb.charAt(1) != '0'){
           int temp = Integer.valueOf(sb.substring(1));
             ans.append(" ");
            if (temp < 20){
                ans.append(k1[temp%10]);
                return ans.toString();
            }else {
                ans.append(k2[temp/10]);
            }
        }
        if (sb.charAt(2) != '0'){
              ans.append(" ");
        ans.append(k0[sb.charAt(2)-'0']);
        }
        return ans.toString();
    }

    

    private String solve(StringBuilder sb , boolean leading , int idx , int number){
       // System.out.println(leading + "  " + idx + "  "+ number);
        if (idx == 10){
            return  convert(number);
        }

        if (!leading){
         //   System.out.println(sb.charAt(idx) + "  " + idx);
            if (sb.charAt(idx) != '0'){

            return solve(sb , true, idx+1 , (sb.charAt(idx)-'0'));
            }
            return solve(sb , false , idx+1 , 0);
        }else{
         
            if (idx == 1){
                if (number > 0) 
                return  convert(number) + q[0]+ solve(sb , true , idx+1 , (sb.charAt(idx)-'0'));
                return solve(sb , true , idx+1 , (sb.charAt(idx)-'0'));
            }else if(idx == 4){
                  if (number > 0) 
                 return convert(number) + q[1]+ solve(sb , true , idx+1 , (sb.charAt(idx)-'0'));
                  return solve(sb , true , idx+1 , (sb.charAt(idx)-'0'));
            }else if (idx == 7){
                  if (number > 0) 
                return  convert(number)  + q[2]+ solve(sb , true , idx+1 , (sb.charAt(idx)-'0'));
                 return solve(sb , true , idx+1 , (sb.charAt(idx)-'0'));
            }
            else {
                
                number = number * 10 + (sb.charAt(idx)-'0');
                return solve(sb , true , idx+1 , number);
            }
        }
     
    }
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        var sb = new StringBuilder();
        sb.append(num);
        while(sb.length() < 10){
           sb.insert(0 , "0");
        }
        System.out.println(sb.toString());
       return solve(sb , false , 0 , 0).trim(); // string , leading , idx , number

    }
}
