#include <bits/stdc++.h>

using namespace std;

vector<vector<int>> ans;
int n;

void dfs(vector<int> &path, vector<int> &ok, vector<int> &nums, int i) {
    if (i == n) {
        ans.push_back(path);
        return;
    }
    for (int j = 0; j < n; j++) {
        if (!ok[j]) {
            path[i] = nums[j];
            ok[j] = 1;
            dfs(path, ok, nums, i + 1);
            ok[j] = 0;
        }
    }
}

vector<vector<int>> permute(vector<int>& nums) {
    n = nums.size();
    vector<int> path(n), ok(n);
    dfs(path, ok, nums, 0);
    return ans;
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