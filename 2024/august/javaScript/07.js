/**
 * @param {number} num
 * @return {string}
 */
var numberToWords = function(num) {
    const k0 = [ "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" ];
    const k1 = ["Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" ];
    const k2 = ["", "" ,  "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" ];
    const  q = [" Billion" ,  " Million" ,  " Thousand" ];
    function convert(cur){
        if (cur == 0) return "";
        let sb = "";
        sb+=`${cur}`;
        let ans = "";
        while(sb.length < 3){
           sb = "0" + sb;
        }
        if (sb[0] != '0'){
              ans+= " ";
            ans+=k0[Number(sb[0])];
            ans+=" Hundred";
        }
        if (sb[1] != '0'){
            let temp = Number(sb.substring(1));
             ans+= " ";
            if (temp < 20){
                ans+=k1[temp%10];
                return ans;
            }else {
                ans+=k2[Math.floor(temp/10)];
            }
        }
        if (sb[2] != '0'){
              ans+=" ";
        ans+=k0[Number(sb[2])];
        }
        return ans;
    }

    

    function solve( sb ,  leading ,  idx , number){ 
        if (idx == 10){
            return  convert(number);
        }

        if (!leading){

            if (sb[idx] != '0'){
            return solve(sb , true, idx+1 , Number(sb[idx]));
            }
            return solve(sb , false , idx+1 , 0);
        }else{
         
            if (idx == 1){
                if (number > 0) 
                return  convert(number) + q[0]+ solve(sb , true , idx+1 , Number(sb[idx]));
                return solve(sb , true , idx+1 , Number(sb[idx]));
            }else if(idx == 4){
                  if (number > 0) 
                 return convert(number) + q[1]+ solve(sb , true , idx+1 , Number(sb[idx]));
                  return solve(sb , true , idx+1 , Number(sb[idx]));
            }else if (idx == 7){
                  if (number > 0) 
                return  convert(number)  + q[2]+ solve(sb , true , idx+1 , Number(sb[idx]));
                 return solve(sb , true , idx+1 , Number(sb[idx]));
            }
            else {
                
                number = number * 10 + Number(sb[idx]);
                return solve(sb , true , idx+1 , number);
            }
        }
     
    }
        if (num == 0) return "Zero";
        let sb =`${num}`
        while(sb.length < 10){
           sb = "0"+sb;
        }
       return solve(sb , false , 0 , 0).trim(); // string , leading , idx , number
};
