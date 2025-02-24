#include <bits/stdc++.h>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

unordered_map<long long, int> mp;

void dfs(TreeNode* root, long long now, int targetSum, int &ans) {
    if (!root)
        return;
    now += root->val;
    ans += mp.contains(now - targetSum) ? mp[now - targetSum] : 0;
    mp[now]++;
    dfs(root->left, now, targetSum, ans);
    dfs(root->right, now, targetSum, ans);
    mp[now]--;
}

int pathSum(TreeNode* root, int targetSum) {
    int ans = 0;
    mp[0]++;
    dfs(root, 0, targetSum, ans);
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