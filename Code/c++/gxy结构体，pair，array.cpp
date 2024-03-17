/* Rainbow_gxy */
#include<bits/stdc++.h>
#define IOS ios::sync_with_stdio(false) , cin.tie(0) ; 
#define ll long long
#define inf 4e18
using namespace std ;
const int mod = 1e9 + 7 ; 

struct P{
 int val ; 
 int l ; 
};

bool cmp( P x , P y ){
 if( x.val != y.val )
  return x.val < y.val ;
 else
  return x.l < y.l ; 
}

void Rainbow( ){
 vector<pair<int,int>> a ; 
 vector<array<int,2>> b ;
 int n ; cin >> n ; 
 vector<P> c; 
 for( int i = 1 ; i <= n ; i++ ){
  int x ; cin >> x ; 
  a.push_back( { x , i } ) ; 
  b.push_back( { x , i } ) ;
  P now ; now.val = x ; now.l = i ;
  c.push_back( now ) ; 
 } 
 sort( a.begin( ) , a.end( ) ) ; 
 sort( b.begin( ) , b.end( ) , greater<array<int,2>>()) ;
 sort( c.begin( ) , c.end( ) , cmp ) ; 
}

int main( ){
    IOS ; 
    int _ = 1 ; 
// cin >> _ ; 
 while( _-- )
  Rainbow( ) ; 
    return 0 ; 
}