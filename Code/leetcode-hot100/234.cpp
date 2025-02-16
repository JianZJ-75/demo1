#include <bits/stdc++.h>

using namespace std;


struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(NULL) {}
    ListNode(int x) : val(x), next(NULL) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

ListNode *c(ListNode *head) {
    ListNode *a = head;
    ListNode *b = head;
    while (b && b->next) {
        a = a->next;
        b = b->next->next;
    }
    return a;
}

ListNode* reverseList(ListNode* head) {
    ListNode *ans = NULL;
    while (head) {
        ListNode *tmp = head->next;
        head->next = ans;
        ans = head;
        head = tmp;
    }
    return ans;
}

bool isPalindrome(ListNode* head) {
    ListNode *mid = c(head);
    ListNode *t = reverseList(mid);
    while (t) {
        if (t->val != head->val)
            return false;
        t = t->next;
        head = head->next;    
    }
    return true;
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