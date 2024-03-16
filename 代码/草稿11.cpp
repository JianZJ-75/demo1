#include <bits/stdc++.h>
#define ll long long
#define dd double

using namespace std;

struct Node
{
    int value;
    Node *next, *prev;
} a[2002], *head, *tail;

void fz(int l, int r)
{
    if (l > r)
        swap(l, r);
    Node *h = head, *t = head;
    for (int i = 1; i < l; i++)
        h = h->next;
    for (int i = 1; i < r; i++)
        t = t->next;
    Node *x = h, *y = h->next, *z;
    cout << x->value << " " << y->value << "\n";
    h->next = t->next;
    t->prev = h->prev;
    while (y != h->next)
    {
        cout << x->value << " " << y->value << "\n";
        z = y->next;
        cout << z->value << "\n";
        // cout << y->next->value << endl;
        y->next = x;
        x->prev = y;
        x = y;
        y = z;
        cout << "dao\n";
        cout << x->value << "\n";
    }
    cout << "mowei" << tail->value << endl;
}

void Jian()
{
    head = NULL;
    tail = NULL;
    int n, m;
    cin >> n >> m;
    for (int i = 1; i <= n; i++)
    {
        a[i].value = i;
        if (head == NULL)
            head = &a[i], tail = head;
        else
        {
            Node *p = tail;
            tail->next = &a[i], tail = tail->next;
            tail->prev = p;
        }
    }
    while (m--)
    {
        int l, r;
        cin >> l >> r;
        if (l == r)
            continue;
        cout << "l=" << l << "r=" << r << "\n";
        fz(l, r);
        cout << "l=" << l << "r=" << r << "\n";
    }
    for (Node *p = head; p != tail->next; p = p->next)
        cout << p->value << " ";
}

int main()
{
    // ios::sync_with_stdio(false);
    // cin.tie(0);
    // cout.tie(0);
    int t = 1;
    // cin>>t;
    while (t--)
        Jian();
    return 0;
}