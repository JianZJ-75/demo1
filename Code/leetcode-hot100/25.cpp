#include <bits/stdc++.h>

using namespace std;


struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(NULL) {}
    ListNode(int x) : val(x), next(NULL) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

ListNode* reverseKGroup(ListNode* head, int k) {
    ListNode tmp = ListNode{0, head};
    ListNode *pre = &tmp;
    ListNode *l = head;
    ListNode *r = head;
    int cnt = 0;
    while (r) {
        cnt++;
        r = r->next;
        if (cnt == k) {
            cnt = 0;
            ListNode *h = NULL;
            for (int i = 1; i <= k; i++) {
                ListNode *t = l->next;
                l->next = h;
                h = l;
                l = t;
            }
            ListNode *p = pre->next;
            p->next = l;
            pre->next = h;
            pre = p;
        }
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