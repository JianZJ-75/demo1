#include <bits/stdc++.h>

using namespace std;


struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(NULL) {}
    ListNode(int x) : val(x), next(NULL) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

ListNode* swapPairs(ListNode* head) {
    ListNode tmp = ListNode{0, head};
    ListNode *n1 = &tmp, *n2 = head;
    while (n2 && n2->next) {
        ListNode *n3 = n2->next;
        ListNode *n4 = n3->next;

        n1->next = n3;
        n3->next = n2;
        n2->next = n4;

        n1 = n2;
        n2 = n4;
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