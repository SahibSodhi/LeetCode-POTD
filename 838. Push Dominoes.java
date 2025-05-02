class Solution {
    public String pushDominoes(String dominoes) {
        Domino newDomino = new Domino();
        int last_L = -1, last_R = -1;
        int n = dominoes.length();
        StringBuilder sb = new StringBuilder(dominoes);

        for (int pos = 0; pos < n; pos++) {
            if (sb.charAt(pos) == 'L') {
                if (last_R > last_L) {
                    newDomino.doubleDominoPush(last_R, pos, sb);
                }
                else if ((last_L > last_R) || last_L == -1) {
                    newDomino.leftDominoPush(last_L + 1, pos, sb);
                }
                last_L = pos;
            }
            else if (sb.charAt(pos) == 'R') {
                if (last_R > last_L) {
                    newDomino.rightDominoPush(last_R, pos, sb);
                }
                last_R = pos;
            }
        }
        
        // Final case: (R)RR...R(end)
        if (last_R > last_L) {
            newDomino.rightDominoPush(last_R, n - 1, sb);
        }

        return sb.toString();
    }

    class Domino {
    public void doubleDominoPush(int last_R, int pos, StringBuilder dominoes) {
        while (last_R < pos) {
            dominoes.setCharAt(last_R++, 'R');
            dominoes.setCharAt(pos--, 'L');
        }
    }
    
    public void leftDominoPush(int start, int end, StringBuilder dominoes) {
        while (start <= end) {
            dominoes.setCharAt(start++, 'L');
        }
    }
    
    public void rightDominoPush(int last_R, int pos, StringBuilder dominoes) {
        while (last_R <= pos) {
            dominoes.setCharAt(last_R++, 'R');
        }
    }
}
}