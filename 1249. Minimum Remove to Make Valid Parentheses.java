class Solution {
    public String minRemoveToMakeValid(String s) {
        int len = s.length();
        int open = 0;
        int close = 0;
        StringBuilder result = new StringBuilder();
        boolean[] remove = new boolean[len];

        //Check for invalid opening parentheses
        for(int i = 0; i < len; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                open++;
            }
            else if(ch == ')'){
                if(open > 0){
                    open--;
                }
                else {
                    remove[i] = true;
                }
            }
        }

        //Check for invalid closing parentheses
        for(int i = len - 1; i >=0 ; i--){
            char ch = s.charAt(i);
            if(ch == ')'){
                close++;
            }
            else if(ch == '('){
                if(close > 0){
                    close--;
                }
                else {
                    remove[i] = true;
                }
            }
        }

        for(int i = 0; i < len; i++){
            if(!remove[i]) result.append(s.charAt(i));
        }

        return result.toString();
    }
}