#include <bits/stdc++.h>
#define ll long long
#define double
#define rep(i, a, b) for(ll i = a; i <= b; i++)
#define rrep(i, a, b) for(ll i = a; i >= b; i--)

using namespace std;

ll n;
string s;
ll L = 0, R = 0, U = 0, D = 0;

ll qmi(ll a, ll b)
{
    ll ret = 1;
    while(b)
    {
        if(b & 1)
            ret = ret * a;
        b /= 2;
        a = a * a;
    }
    return ret;
}

void Jian()
{
  int n;
  cin >> n;
  string str;
  cin >> str;
  int numl = 0;
  int numr  = 0;
  int numu = 0;
  int numd = 0;
  int idx = 0;
  while(str[idx] != 'R' && idx < n) idx++;
  for(int i = idx; i < n; i++)
  {
    if(str[i] == 'R') numr++;
    if(str[i] == 'L' && str[i-1] == 'R') numr --;
  }
  idx = 0;
  while(str[idx] != 'D' && idx < n) idx++;
  for(int i = idx; i < n; i++)
  {
    if(str[i] == 'D') numd++;
    if(str[i] == 'U' && str[i-1] == 'D') numd --;
  }
  idx = 0;
  while(str[idx] != 'L' && idx < n) idx++;
  for(int i = idx; i < n; i++)
  {
    if(str[i] == 'L') numl++;
    if(str[i] == 'R' && str[i-1] == 'L') numl --;
  }
  idx = 0;
  while(str[idx] != 'U' && idx < n) idx++;
  for(int i = idx; i < n; i++)
  {
    if(str[i] == 'U') numu++;
    if(str[i] == 'D' && str[i-1] == 'U') numu --;
  }
  set<pair<int,int> > s;
  for(int i = 0; i <= numr; i++)
   for(int j = 0; j <= numu; j++)
   {
      s.insert(make_pair(i,j));
   }
   for(int i = 0; i <= numr; i++)
   for(int j = 0; j <= numd; j++)
   {
      s.insert(make_pair(i,-j));
   }
   for(int i = 0; i <= numl; i++)
   for(int j = 0; j <= numu; j++)
   {
      s.insert(make_pair(-i,j));
   }
   for(int i = 0; i <= numl; i++)
   for(int j = 0; j <= numd; j++)
   {
      s.insert(make_pair(-i,-j));
   }
   cout << s.size() << "\n"; 
   for(auto i : s)
   {
    cout << i.first << " " << i.second << "\n";
   }
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int _ = 1;
    //cin >> _;
    while(_--)
        Jian();
    return 0;
}