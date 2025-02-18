#include <bits/stdc++.h>

using namespace std;


struct Node {
    int val;
    Node* next;
    Node* random;
    Node(int val) : val(val), next(NULL), random(NULL) {}
};

Node* copyRandomList(Node* head) {
    unordered_map<Node*, Node*> mp;
    Node ans = Node{0};
    Node *cur = &ans;
    for (Node *i = head; i; i = i->next) {
        Node *j = new Node(i->val);
        cur->next = j;
        cur = cur->next;
        mp[i] = j;
    }
    cur = ans.next;
    for (Node *i = head; i; i = i->next) {
        cur->random = mp[i->random];
        cur = cur->next;
    }
    return ans.next;
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