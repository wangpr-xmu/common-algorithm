package org.worker.hnalgorithm.stack.validparentheses;

import java.util.Stack;

/**
 * 有效的括号
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if(null == s || s.length() == 0) {
            return true;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c : chars) {
            if(c  == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue ;
            }
            if(!stack.isEmpty() &&
                    ((c == ')' && stack.peek() == '(') || (c == '}' && stack.peek() == '{') || (c == ']' && stack.peek() == '['))){
                stack.pop();
            }else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
