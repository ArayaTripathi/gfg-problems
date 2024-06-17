// User function Template for Java
class Solution {

    // Function to check if point q lies on segment pr
    public boolean func(int[] p, int[] q, int[] r) {
        if (q[0] <= Math.max(p[0], r[0]) && q[0] >= Math.min(p[0], r[0]) &&
            q[1] <= Math.max(p[1], r[1]) && q[1] >= Math.min(p[1], r[1])) {
            return true;
        }
        return false;
    }
    public int direction(int[] p, int[] q, int[] r) {
        long val = 1L * (q[1] - p[1]) * (r[0] - q[0]) - 1L * (q[0] - p[0]) * (r[1] - q[1]);

        if (val == 0) {
            return 0;
        }
        return (val > 0) ? 1 : -1;
    }
    public String doIntersect(int[] p1, int[] q1, int[] p2, int[] q2) {
        int o1 = direction(p1, q1, p2);
        int o2 = direction(p1, q1, q2);
        int o3 = direction(p2, q2, p1);
        int o4 = direction(p2, q2, q1);

        // General case
        if (o1 != o2 && o3 != o4) {
            return "true";
        }

        // Special cases
        // p1, q1 and p2 are collinear and p2 lies on segment p1q1
        if (o1 == 0 && func(p1, p2, q1)) {
            return "true";
        }

        // p1, q1 and q2 are collinear and q2 lies on segment p1q1
        if (o2 == 0 && func(p1, q2, q1)) {
            return "true";
        }

        // p2, q2 and p1 are collinear and p1 lies on segment p2q2
        if (o3 == 0 && func(p2, p1, q2)) {
            return "true";
        }

        // p2, q2 and q1 are collinear and q1 lies on segment p2q2
        if (o4 == 0 && func(p2, q1, q2)) {
            return "true";
        }

        // Doesn't fall in any of the above cases
        return "false";
    }
}
