#include <bits/stdc++.h>

using namespace std;


struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(NULL) {}
    ListNode(int x) : val(x), next(NULL) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
    ListNode *ans = new ListNode();
    ListNode *cur = ans;
    int tmp = 0;
    while (true) {
        cur->next = new ListNode(tmp);
        cur = cur->next;
        if (l1) {
            cur->val += l1->val;
            l1 = l1->next;
        }
        if (l2) {
            cur->val += l2->val;
            l2 = l2->next;
        }
        tmp = cur->val / 10;
        cur->val %= 10;
        if (!tmp && !l1 && !l2)
            break;
    }
    return ans->next;
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