#include <bits/stdc++.h>

#define PII pair<int ,int> 
using namespace std;

const int N = 2e5 + 10;
int a[N], b[N], p[N], c[N], ans[N];
int n, m;
struct cmp {
    bool operator() (int a, int b) const {
        return p[a] < p[b];
    }
};
set<int,cmp> s[4];
bool st[N];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> n ;
    for(int i = 0; i < n; i ++ ) {
        cin >> p[i];
    }
    for(int i = 0; i < n; i ++ ) {
        cin >> a[i];
        s[a[i]].insert(i);
    }
    for(int i = 0; i < n; i ++ ) {
        cin >> b[i];
        s[b[i]].insert(i);
    }

    cin >> m;
    for(int i = 0; i < m; i ++ ) cin >> c[i];
    for(int i = 0; i < m; i ++ ) {
        int x = c[i];
        bool flag = false;    
        while(1) {
            if(s[x].empty()) break;
            int res = *s[x].begin(); s[x].erase(res);
            if(st[res]) continue;
            else {
                st[res] = true;
                cout << p[res] << ' ';
                flag = true;
                break;
            }
        }
        if(!flag) cout << "-1 ";
    }
    return 0;
}

