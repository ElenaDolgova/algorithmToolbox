package LeetCode.medium.atoi;

/**
 * https://leetcode.com/submissions/detail/509279976/
 */
class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        boolean isNegative = false;
        if (s.length() > 0) {
            if (s.charAt(0) == '-') {
                isNegative = true;
                s = s.substring(1);
            } else if (s.charAt(0) == '+') {
                s = s.substring(1);
            }

            if (s.length() == 0 || !isDigit(s.charAt(0))) {
                return 0;
            }
            StringBuilder newString = new StringBuilder();
            for (int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                if (isDigit(c) && newString.length() < 11) {
                    if (c == '0') {
                        if (newString.length() > 0) {
                            newString.append(c);
                        }
                    } else {
                        newString.append(c);
                    }
                } else if (!isDigit(c)) {
                    break;
                }
            }
            if (newString.length() == 0) {
                return 0;
            }
            long l = Long.parseLong(newString.toString());
            l = isNegative ? l * -1 : l;
            if (l > Integer.MAX_VALUE || l < Integer.MIN_VALUE) {
                if (isNegative) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            } else {
                return (int) l;
            }

        } else {
            return 0;
        }
    }

    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}