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

int dfs(TreeNode* root, int &ans) {
    if (root == nullptr)
        return 0;
    int l = dfs(root->left, ans);
    int r = dfs(root->right, ans);
    ans = max(ans, l + r + root->val);
    return max(0, max(l, r) + root->val);
}

int maxPathSum(TreeNode* root) {
    int ans = -0x3f3f3f3f;
    dfs(root, ans);
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