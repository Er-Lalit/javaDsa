
class Solution {
    static List<String> ans;

    public static boolean ischeck(StringBuilder sb) {
        int count = 0;

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }

            if (count < 0) {
                return false;
            }
        }

        return count == 0;
    }

    public static void solve(StringBuilder sb, int i, int n) {
        if (i == 2 * n) {
            if (ischeck(sb)) {
                ans.add(sb.toString());
            }
            return;
        }

        sb.append('(');
        solve(sb, i + 1, n);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(')');
        solve(sb, i + 1, n);
        sb.deleteCharAt(sb.length() - 1);
    }

    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        solve(new StringBuilder(), 0, n);
        return ans;
    }
}