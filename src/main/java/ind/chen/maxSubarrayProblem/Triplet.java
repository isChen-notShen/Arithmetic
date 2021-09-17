package ind.chen.maxSubarrayProblem;

/**
 * 该类是一个三元组。分别存储最大子数组的边界与和
 */
class Triplet {
    int maxLeft;
    int maxRight;
    int sum;

    Triplet(int maxLeft, int maxRight, int sum) {
        this.maxLeft = maxLeft;
        this.maxRight = maxRight;
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Triplet{" +
                "maxLeft=" + maxLeft +
                ", maxRight=" + maxRight +
                ", sum=" + sum +
                '}';
    }
}