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

unordered_map<int, int> mp;

TreeNode* dfs(vector<int>& preorder, vector<int>& inorder,int l1, int r1, int l2, int r2) {
    if (l1 == r1) return nullptr;
    int n = mp[preorder[l1]] - l2;
    return new TreeNode(preorder[l1], dfs(preorder, inorder, l1 + 1, l1 + n + 1, l2, l2 + n), dfs(preorder, inorder, l1 + 1 + n, r1, l2 + n + 1, r2));
}

TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
    for (int i = 0; i < inorder.size(); i++) {
        mp[inorder[i]] = i;
    }
    int n = preorder.size();
    return dfs(preorder, inorder, 0, n, 0, n);
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