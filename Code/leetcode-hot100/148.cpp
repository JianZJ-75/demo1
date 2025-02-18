#include <bits/stdc++.h>

using namespace std;


struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(NULL) {}
    ListNode(int x) : val(x), next(NULL) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};



ListNode* sortList(ListNode* head) {
    if (!head || !head->next)
        return head;
    ListNode *l = head, *r = head, *pre = l;
    while (r && r->next) {
        pre = l;
        l = l->next;
        r = r->next->next;
    }
    pre->next = NULL;
    head = sortList(head);
    l = sortList(l);
    ListNode tmp = ListNode();
    ListNode *cur = &tmp;
    while (head && l) {
        if (head->val <= l->val) {
            cur->next = head;
            head = head->next;
        } else {
            cur->next = l;
            l = l->next;
        }
        cur = cur->next;
    }
    cur->next = head ? head : l;
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