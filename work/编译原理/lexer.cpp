#include <iostream>
#include <fstream>
#include <string>
#include <cctype>
#include <vector>
#include <unordered_set>

using namespace std;

enum TokenType {
    KEYWORD = 1,
    IDENTIFIER,
    CONSTANT,
    OPERATOR,
    DELIMITER
};

struct Token {
    int type;
    string value;
};

unordered_set<string> keywords = {"main", "int", "if", "then", "while", "do"};
unordered_set<string> operators = {"+", "-", "*", "/", "=", "==", "!=", "<", ">", "<=", ">="};
unordered_set<char> delimiters = {';', ',', '(', ')', '{', '}'};

// 检查是否为运算符起始字符
bool isOperatorStart(char ch) {
    return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '=' || ch == '!' || ch == '<' || ch == '>';
}

vector<Token> tokenize(const string& line, int lineNum) {
    vector<Token> tokens;
    int i = 0;
    while (i < line.length()) {
        if (isspace(line[i])) {
            i++;
            continue;
        }

        // 标识符或关键字
        if (isalpha(line[i]) || line[i] == '_') {
            string word;
            while (i < line.length() && (isalnum(line[i]) || line[i] == '_')) {
                word += line[i++];
            }
            if (keywords.count(word))
                tokens.push_back({KEYWORD, word});
            else
                tokens.push_back({IDENTIFIER, word});
        }
        // 常量（整数）
        else if (isdigit(line[i])) {
            string number;
            while (i < line.length() && isdigit(line[i])) {
                number += line[i++];
            }
            tokens.push_back({CONSTANT, number});
        }
        // 运算符
        else if (isOperatorStart(line[i])) {
            string op(1, line[i++]);
            if (i < line.length() && (line[i] == '=')) {
                op += line[i++];
            }
            if (operators.count(op)) {
                tokens.push_back({OPERATOR, op});
            } else {
                cout << "Error，出错的位置：第" << lineNum << "行，第" << i << "列，非法运算符：" << op << endl;
            }
        }
        // 界符
        else if (delimiters.count(line[i])) {
            tokens.push_back({DELIMITER, string(1, line[i++])});
        }
        // 错误字符
        else {
            cout << "Error，出错的位置：第" << lineNum << "行，第" << i+1 << "列，非法字符：" << line[i] << endl;
            i++;
        }
    }
    return tokens;
}

int main() {
    string line;
    vector<Token> allTokens;
    int lineNum = 1;

    ofstream fout("output.txt");

    cout << "请输入源程序代码（输入#结束）：" << endl;
    while (getline(cin, line)) {
        if (line == "#") break;
        vector<Token> tokens = tokenize(line, lineNum++);
        for (auto& token : tokens) {
            allTokens.push_back(token);
            fout << "(" << token.type << ",\"" << token.value << "\")" << endl;
            cout << "(" << token.type << ",\"" << token.value << "\")" << endl;
        }
    }

    fout.close();
    cout << "\n分析结果已输出至 output.txt 文件。" << endl;
    return 0;
}
