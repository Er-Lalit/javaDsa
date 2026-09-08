class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();

        int i = s.length() - 1;

        while (i >= 0) {

            // Skip spaces
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            if (i < 0) {
                break;
            }

            // Find the beginning of the word
            int j = i;

            while (j >= 0 && s.charAt(j) != ' ') {
                j--;
            }

            // Add the word
            sb.append(s.substring(j + 1, i + 1));

            // Add one space between words
            sb.append(" ");

            // Move to the previous word
            i = j;
        }

        // Remove the last extra space
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }
}