#include <bits/stdc++.h>

using namespace std;

class Node {
public:
    int key;
    int value;
    Node* pre;
    Node* next;
    Node(int k = 0, int v = 0) : key(k), value(v) {}
};

class LRUCache {
private:
    int capacity;
    unordered_map<int, Node*> mp;
    Node* dummy;
    
    void push(Node *x) {
        x->pre = dummy;
        x->next = dummy->next;
        dummy->next->pre = x;
        dummy->next = x;
    }

    void remove(Node *x) {
        x->pre->next = x->next;
        x->next->pre = x->pre;
    }

    Node* getNode(int key) {
        auto it = mp.find(key);
        if (it == mp.end()) {
            return NULL;
        }
        Node *t = it->second;
        remove(t);
        push(t);
        return t;
    }

public:
    LRUCache(int capacity) : capacity(capacity), dummy(new Node()) {
        dummy->next = dummy;
        dummy->pre = dummy;
        mp.clear();
    }
    
    int get(int key) {
        Node *t = getNode(key);
        return t ? t->value : -1;
    }
    
    void put(int key, int value) {
        Node *t = getNode(key);
        if (t) {
            t->value = value;
            return;
        }
        Node *cur = new Node(key, value);
        push(cur);
        mp[key] = cur;
        if (mp.size() > capacity) {
            Node *tt = dummy->pre;
            mp.erase(tt->key);
            remove(tt);
            delete tt;
        }
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */

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