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

bool t(TreeNode *l, TreeNode *r) {
    if (!l && !r) return true;
    if (!l || !r || l->val != r->val) return false;
    return t(l->left, r->right) & t(l->right, r->left);
}

bool isSymmetric(TreeNode* root) {
    TreeNode *l = root;
    TreeNode *r = root;
    return t(l, r);
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