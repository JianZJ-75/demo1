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

vector<vector<int>> levelOrder(TreeNode* root) {
    if (root == NULL) return {};
    queue<TreeNode*> q;
    vector<vector<int>> ans;
    q.push(root);
    while (!q.empty()) {
        int n = q.size();
        vector<int> tmp;
        while (n--) {
            auto x = q.front();
            tmp.push_back(x->val);
            q.pop();
            if (x->left) q.push(x->left);
            if (x->right) q.push(x->right);
        }
        ans.push_back(tmp);
    }
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