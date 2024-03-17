#include <bits/stdc++.h>
#define ll long long
#define dd double
#define endl '\n'
#define rep(i, a, b) for (ll i = a; i <= b; i++)
#define rrep(i, a, b) for (ll i = a; i >= b; i--)
const int M = 1e9 + 7;

using namespace std;

struct Node
{
    int value;
    Node *l, *r, *fa;
};
const int N = 2e5 + 10;
Node *q[N];
void bfs(Node *root)
{
    int front = 1, last = 1;
    q[1] = root;
    while (front <= last)
    {
        Node *p = q[front];
        cout << p->value << endl;
        front++;
        if (p->l)
            q[++last] = p->l;
        if (p->r)
            q[++last] = p->r;
    }
}

void Jian()
{
}

int main()
{
    srand(time(0));
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int _ = 1;
    cin >> _;
    while (_--)
        Jian();
    return 0;
}