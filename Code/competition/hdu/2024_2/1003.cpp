#include <bits/stdc++.h>
#define ll long long
#define dd double
#define endl '\n'
#define pii pair<ll, ll>
#define x first
#define y second
#define rep(i, a, b) for (ll i = a; i <= b; i++)
#define rrep(i, a, b) for (ll i = a; i >= b; i--)
#define INF 0x3f3f3f3f
#define LINF 0x3f3f3f3f3f3f3f3f
const ll M = 1e9 + 7;

using namespace std;

string Init[9] = {
    "***111******",
    "***111******",
    "***111******",
    "222333444555",
    "222333444555",
    "222333444555",
    "***666******",
    "***666******",
    "***666******"};

char init[9][12];

struct P {
    char t[9][12];
};
vector<P> fa;

string a[9];

map<pair<int, int>, pair<pair<int, int>, pair<int, int>>> mp;

void copy1(char tt[9][12], char b[9][12]) {
    rep(i, 0, 8) {
        rep(j, 0, 11) {
            tt[i][j] = b[i][j];
        }
    }
}

void in() {
    // 1
    mp[{0, 3}] = {{3, 0}, {3, 11}};
    mp[{3, 0}] = {{0, 3}, {3, 11}};
    mp[{3, 11}] = {{3, 0}, {0, 3}};
    // 2
    mp[{0, 5}] = {{3, 8}, {3, 9}};
    mp[{3, 8}] = {{0, 5}, {3, 9}};
    mp[{3, 9}] = {{3, 8}, {0, 5}};
    // 3
    mp[{2, 3}] = {{3, 3}, {3, 2}};
    mp[{3, 3}] = {{2, 3}, {3, 2}};
    mp[{3, 2}] = {{3, 3}, {2, 3}};
    // 4
    mp[{2, 5}] = {{3, 5}, {3, 6}};
    mp[{3, 5}] = {{2, 5}, {3, 6}};
    mp[{3, 6}] = {{3, 5}, {2, 5}};
    // 5
    mp[{5, 3}] = {{5, 2}, {6, 3}};
    mp[{5, 2}] = {{5, 3}, {6, 3}};
    mp[{6, 3}] = {{5, 2}, {5, 3}};
    // 6
    mp[{5, 5}] = {{5, 6}, {6, 5}};
    mp[{5, 6}] = {{5, 5}, {6, 5}};
    mp[{6, 5}] = {{5, 6}, {5, 5}};
    // 7
    mp[{8, 3}] = {{5, 0}, {5, 11}};
    mp[{5, 0}] = {{8, 3}, {5, 11}};
    mp[{5, 11}] = {{5, 0}, {8, 3}};
    // 8
    mp[{8, 5}] = {{5, 8}, {5, 9}};
    mp[{5, 8}] = {{8, 5}, {5, 9}};
    mp[{5, 9}] = {{5, 8}, {8, 5}};
}

void f1(int op) {
    if (op) {
        char t1 = init[3][9];
        char t2 = init[3][10];
        char t3 = init[3][11];
        rrep(i, 11, 3)
            init[3][i] = init[3][i - 3];
        init[3][0] = t1;
        init[3][1] = t2;
        init[3][2] = t3;
    } else {
        char t1 = init[3][0];
        char t2 = init[3][1];
        char t3 = init[3][2];
        rep(i, 0, 8)
            init[3][i] = init[3][i + 3];
        init[3][9] = t1;
        init[3][10] = t2;
        init[3][11] = t3;
    }
}

void f2(int op) {
    if (op) {
        char t1 = init[5][9];
        char t2 = init[5][10];
        char t3 = init[5][11];
        rrep(i, 11, 3)
            init[5][i] = init[5][i - 3];
        init[5][0] = t1;
        init[5][1] = t2;
        init[5][2] = t3;
    } else {
        char t1 = init[5][0];
        char t2 = init[5][1];
        char t3 = init[5][2];
        rep(i, 0, 8)
            init[5][i] = init[5][i + 3];
        init[5][9] = t1;
        init[5][10] = t2;
        init[5][11] = t3;
    }
}

void f3(int op) {
    if (op) {
        // 5
        char t1 = init[3][11];
        char t2 = init[4][11];
        char t3 = init[5][11];
        // 5->6
        init[3][11] = init[6][3];
        init[4][11] = init[7][3];
        init[5][11] = init[8][3];
        // 3->1 6->3
        rrep(i, 8, 3)
            init[i][3] = init[i - 3][3];
        // 1->5
        init[0][3] = t1;
        init[1][3] = t2;
        init[2][3] = t3;
    } else {
        // 5
        char t1 = init[3][11];
        char t2 = init[4][11];
        char t3 = init[5][11];
        // 5->1
        init[3][11] = init[0][3];
        init[4][11] = init[1][3];
        init[5][11] = init[2][3];
        // 3->6 1->3
        rep(i, 0, 5)
            init[i][3] = init[i + 3][3];
        // 6->5
        init[6][3] = t1;
        init[7][3] = t2;
        init[8][3] = t3;
    }
}

void f4(int op) {
    if (op) {
        // 5
        char t1 = init[3][9];
        char t2 = init[4][9];
        char t3 = init[5][9];
        // 5->6
        init[3][9] = init[6][5];
        init[4][9] = init[7][5];
        init[5][9] = init[8][5];
        // 3->1 6->3
        rrep(i, 8, 3)
            init[i][5] = init[i - 3][5];
        // 1->5
        init[0][5] = t1;
        init[1][5] = t2;
        init[2][5] = t3;
    } else {
        // 5
        char t1 = init[3][9];
        char t2 = init[4][9];
        char t3 = init[5][9];
        // 5->1
        init[3][9] = init[0][5];
        init[4][9] = init[1][5];
        init[5][9] = init[2][5];
        // 3->6 1->3
        rep(i, 0, 5)
            init[i][5] = init[i + 3][5];
        // 6->5
        init[6][5] = t1;
        init[7][5] = t2;
        init[8][5] = t3;
    }
}

void f5(int op) {
    if (op) {
        // 1
        char t1 = init[2][3];
        char t2 = init[2][4];
        char t3 = init[2][5];
        // 1->4
        init[2][3] = init[3][6];
        init[2][4] = init[4][6];
        init[2][5] = init[5][6];
        // 4->6
        init[3][6] = init[6][5];
        init[4][6] = init[6][4];
        init[5][6] = init[6][3];
        // 6->2
        init[6][5] = init[5][2];
        init[6][4] = init[4][2];
        init[6][3] = init[3][2];
        // 2->1
        init[5][2] = t1;
        init[4][2] = t2;
        init[3][2] = t3;
    } else {
        // 1
        char t1 = init[2][3];
        char t2 = init[2][4];
        char t3 = init[2][5];
        // 1->2
        init[2][3] = init[5][2];
        init[2][4] = init[4][2];
        init[2][5] = init[3][2];
        // 2->6
        init[5][2] = init[6][5];
        init[4][2] = init[6][4];
        init[3][2] = init[6][3];
        // 6->4
        init[6][5] = init[3][6];
        init[6][4] = init[4][6];
        init[6][3] = init[5][6];
        // 4->1
        init[3][6] = t1;
        init[4][6] = t2;
        init[5][6] = t3;
    }
}

void f6(int op) {
    if (op) {
        // 1
        char t1 = init[0][3];
        char t2 = init[0][4];
        char t3 = init[0][5];
        // 1->4
        init[0][3] = init[3][8];
        init[0][4] = init[4][8];
        init[0][5] = init[5][8];
        // 4->6
        init[3][8] = init[8][5];
        init[4][8] = init[8][4];
        init[5][8] = init[8][3];
        // 6->2
        init[8][5] = init[5][0];
        init[8][4] = init[4][0];
        init[8][3] = init[3][0];
        // 2->1
        init[5][0] = t1;
        init[4][0] = t2;
        init[3][0] = t3;
    } else {
        // 1
        char t1 = init[0][3];
        char t2 = init[0][4];
        char t3 = init[0][5];
        // 1->2
        init[0][3] = init[5][0];
        init[0][4] = init[4][0];
        init[0][5] = init[3][0];
        // 2->6
        init[5][0] = init[8][5];
        init[4][0] = init[8][4];
        init[3][0] = init[8][3];
        // 6->4
        init[8][5] = init[3][8];
        init[8][4] = init[4][8];
        init[8][3] = init[5][8];
        // 4->1
        init[3][8] = t1;
        init[4][8] = t2;
        init[5][8] = t3;
    }
}

void push(char init[9][12]) {
    P tmp;
    copy1(tmp.t, init);
    fa.push_back(tmp);
}

void dfs(int now) {
    if (now > 3)
        return;
    // 1
    f1(1);
    push(init);
    dfs(now + 1);
    f1(0);
    f1(0);
    push(init);
    dfs(now + 1);
    f1(1);
    // 2
    f2(1);
    push(init);
    dfs(now + 1);
    f2(0);
    f2(0);
    push(init);
    dfs(now + 1);
    f2(1);
    // 3
    f3(1);
    push(init);
    dfs(now + 1);
    f3(0);
    f3(0);
    push(init);
    dfs(now + 1);
    f3(1);
    // 4
    f4(1);
    push(init);
    dfs(now + 1);
    f4(0);
    f4(0);
    push(init);
    dfs(now + 1);
    f4(1);
    // 5
    f5(1);
    push(init);
    dfs(now + 1);
    f5(0);
    f5(0);
    push(init);
    dfs(now + 1);
    f5(1);
    // 6
    f6(1);
    push(init);
    dfs(now + 1);
    f6(0);
    f6(0);
    push(init);
    dfs(now + 1);
    f6(1);
}

void print(char init[9][12]) {
    rep(i, 0, 8) {
        rep(j, 0, 11) {
            cout << init[i][j];
        }
        cout << endl;
    }
    cout << "-----------------\n";
}

vector<char> c(int i, int j) {
    vector<char> res;
    auto p = mp[{i, j}];
    res.push_back(a[i][j]);
    res.push_back(a[p.x.x][p.x.y]);
    res.push_back(a[p.y.x][p.y.y]);
    return res;
}

void Jian()
{
    rep(i, 0, 8) {
        cin >> a[i];
    }
    bool ok = 0;
    vector<char> ans;
    // bool fl = 0;
    for (auto ttt : fa) {
        vector<pair<int, int>> tmp;
        auto k = ttt.t;
        rep(i, 0, 8) {
            rep(j, 0, 11) {
                if (k[i][j] != a[i][j]) {
                    tmp.push_back({i, j});
                }
            }
        }
        if (tmp.size() == 0) {
            cout << "No problem\n";
            return;
        }
        if (tmp.size() == 2) {
            // fl = 1;
            ans = c(tmp[0].x, tmp[0].y);
        }
    }
    // if (fl == 0) while (1);
    sort(ans.begin(), ans.end());
    cout << ans[0] << " " << ans[1] << " " << ans[2] << endl;
}

signed main()
{
    srand(time(0));
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    in();
    rep(i, 0, 8) {
        rep(j, 0, 11) {
            init[i][j] = Init[i][j];
        }
    }
    push(init);
    // test(1);
    dfs(1);
    // cout << fa.size() << endl;
    int _ = 1;
    cin >> _;
    while (_--)
        Jian();
    return 0;
}