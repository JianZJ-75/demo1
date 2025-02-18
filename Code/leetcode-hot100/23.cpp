#include <bits/stdc++.h>

using namespace std;


struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(NULL) {}
    ListNode(int x) : val(x), next(NULL) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

ListNode* mergeKLists(vector<ListNode*>& lists) {
    auto cmp = [](const ListNode* a, const ListNode* b) {
        return a->val > b->val;
    };
    priority_queue<ListNode*, vector<ListNode*>, decltype(cmp)> p(cmp);
    for (auto i : lists) {
        if (i)
            p.push(i);
    }
    ListNode tmp = ListNode();
    ListNode *cur = &tmp;
    while (!p.empty()) {
        ListNode *t = p.top();
        p.pop();
        cur->next = t;
        t = t->next;
        if (t)
            p.push(t);
        cur = cur->next;
    }
    return tmp.next;
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