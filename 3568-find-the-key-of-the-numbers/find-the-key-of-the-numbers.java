class Solution {
    public int generateKey(int num1, int num2, int num3) {
        String a = String.format("%04d", num1);
        String b = String.format("%04d", num2);
        String c = String.format("%04d", num3);

        StringBuilder key = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            char min = (char) Math.min(a.charAt(i),
                        Math.min(b.charAt(i), c.charAt(i)));
            key.append(min);
        }

        return Integer.parseInt(key.toString());
    }
}