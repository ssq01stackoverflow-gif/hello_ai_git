public class LongestStringFinder {
    public static Result findLongestString(String[] strings) {
        if (strings == null || strings.length == 0) {
            throw new IllegalArgumentException("strings must not be null or empty");
        }

        int longestIndex = 0;
        int longestLength = lengthOf(strings[0]);

        for (int i = 1; i < strings.length; i++) {
            int currentLength = lengthOf(strings[i]);
            if (currentLength > longestLength) {
                longestIndex = i;
                longestLength = currentLength;
            }
        }

        return new Result(strings[longestIndex], longestIndex);
    }

    private static int lengthOf(String value) {
        return value == null ? 0 : value.length();
    }

    public static class Result {
        private final String value;
        private final int index;

        public Result(String value, int index) {
            this.value = value;
            this.index = index;
        }

        public String getValue() {
            return value;
        }

        public int getIndex() {
            return index;
        }

        @Override
        public String toString() {
            return "Result{value='" + value + "', index=" + index + "}";
        }
    }

    public static void main(String[] args) {
        String[] values = {"Java", "Codex", "hello world", "AI"};
        Result result = findLongestString(values);
        System.out.println(result);
    }
}
