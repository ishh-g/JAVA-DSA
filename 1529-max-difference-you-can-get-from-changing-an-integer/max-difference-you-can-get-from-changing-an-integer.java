class Solution {
    public int maxDiff(int num) {
        String s = String.valueOf(num);
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;

        for (char x = '0'; x <= '9'; x++) {
            for (char y = '0'; y <= '9'; y++) {
                if (x == y) continue; 

                String replaced = replaceDigits(s, x, y);

                if (replaced.charAt(0) == '0') continue;

                int val = Integer.parseInt(replaced);
                maxVal = Math.max(maxVal, val);
                minVal = Math.min(minVal, val);
            }
        }

        return maxVal - minVal;
    }

    private String replaceDigits(String s, char x, char y) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == x) {
                sb.append(y);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}