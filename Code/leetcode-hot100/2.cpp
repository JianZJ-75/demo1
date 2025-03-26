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

void qs(int l, int r, int *a) {
    srand(time(0));
    if (l >= r)
        return;
    swap(a[l], a[l + rand() % (r - l + 1)]);
    int x = a[l], i = l, j = r;
    while (i < j) {
        while (i < j && a[j] > x)
            j--;
        if (i < j)
            a[l++] = a[j];
        while (i < j && a[j] < x)
            i++;
        if (i < j)
            a[j--] = a[i];
    }
    a[i] = x;
    qs(l, i - 1, a);
    qs(i + 1, r, a);
}

void ms(int l, int r, int *a) {
    if (l >= r)
        return;
    int m = (l + r) / 2;
    ms(l, m, a);
    ms(m + 1, r, a);
    int p1 = l, p2 = m + 1, idx = 0;
    int c[r - l + 1];
    while (p1 <= m && p2 <= r) {
        if (a[p1] < a[p2])
            c[idx++] = a[p1++];
        else
            c[idx++] = a[p2++];
    }
    while (p1 <= m)
        c[idx++] = a[p1++];
    while (p2 <= r)
        c[idx++] = a[p2++];
    for (int i = 0; i < r - l + 1; i++) {
        a[l + i] = c[i];
    }
}

void down(int l, int r, int *a) {
    int fa = l;
    int s = 2 * fa + 1;
    while (s <= r) {
        if (s + 1 <= r && a[s + 1] > a[s])
            s++;
        if (a[fa] >= a[s])
            return;
        else {
            swap(a[fa], a[s]);  
            fa = s;
            s = 2 * fa + 1;
        }
    }
}

void hs(int l, int r, int *a) {
    int n = r - l + 1;
    for (int i = n / 2 - 1; i >= 0; i--)
        down(i, n - 1, a);
    for (int i = n - 1; i >= 0; i--) {
        swap(a[0], a[i]);
        down(0, i - 1, a);
    }
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