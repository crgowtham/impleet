/*
Given a non-negative integer x, compute and return the square root of x.

Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

 

Example 1:

Input: x = 4
Output: 2
*/

public int sqrt(int x) {
    long ans = 0;
    long bit = 1l << 16;
    while(bit > 0) {
        ans |= bit;
        if (ans * ans > x) {
            ans ^= bit;
        }
        bit >>= 1;
    }
    return (int)ans;
}

public int sqrt(int x) {
    if (x == 0)
        return 0;
    int left = 1, right = Integer.MAX_VALUE;
    while (true) {
        int mid = left + (right - left)/2;
        if (mid > x/mid) {
            right = mid - 1;
        } else {
            if (mid + 1 > x/(mid + 1))
                return mid;
            left = mid + 1;
        }
    }
}
