#include <bits/stdc++.h>

using namespace std;


struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(NULL) {}
    ListNode(int x) : val(x), next(NULL) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

ListNode* removeNthFromEnd(ListNode* head, int n) {
    ListNode tmp = ListNode{0, head};
    ListNode *l = &tmp, *r = &tmp;
    while (n--) {
        r = r->next;
    }
    while (r->next) {
        l = l->next;
        r = r->next;
    }
    l->next = l->next->next;
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