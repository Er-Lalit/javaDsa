class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int balance = 0; // track open '(' minus close ')'

        for (char c : s.toCharArray()) {
            if (c == '(') {
                // If balance > 0, this '(' is NOT outermost
                if (balance > 0) {
                    result.append(c);
                }
                balance++;
            } else {
                balance--;
                // If balance > 0 after decrement, this ')' is NOT outermost
                if (balance > 0) {
                    result.append(c);
                }
            }
        }
        return result.toString();
    }
}
