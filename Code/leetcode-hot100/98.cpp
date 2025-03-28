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

void dfs(TreeNode *root, vector<int> &ans) {
    if (root->left) dfs(root->left, ans);
    ans.push_back(root->val);
    if (root->right) dfs(root->right, ans);
}

bool isValidBST(TreeNode* root) {
    vector<int> ans;
    dfs(root, ans);
    for (int i = 1; i < ans.size(); i++) {
        if (ans[i] <= ans[i - 1])
            return false;
    }
    return true;
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