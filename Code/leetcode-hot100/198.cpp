#include <bits/stdc++.h>

using namespace std;

int rob(vector<int>& nums) {
    int n = nums.size();
    int f[n + 1];
    f[0] = 0;
    f[1] = nums[0];
    for (int i = 1; i < n; i++) {
        f[i + 1] = max(f[i], f[i - 1] + nums[i]);
    }
    return f[n];
}

void solve() {
    
}

signed main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int _ = 1;
    // cin >> _;
    while (_--) {
        solve();
    }
    return 0;
}