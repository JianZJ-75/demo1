#include <bits/stdc++.h>

using namespace std;


struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(NULL) {}
    ListNode(int x) : val(x), next(NULL) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

bool hasCycle(ListNode *head) {
    ListNode *a = head;
    ListNode *b = head;
    while (b && b->next) {
        a = a->next;
        b = b->next->next;
        if (a == b) {
            while (head != a) {
                a = a->next;
                head = head->next;
            }
            return a;
        }
    }
    return NULL;
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