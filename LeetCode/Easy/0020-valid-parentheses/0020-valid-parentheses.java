class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for(char chr : s.toCharArray()) {
            if(stack.isEmpty()) {
                if(chr == '(' || chr=='[' || chr=='{') {
                    stack.push(chr);
                } else {
                    return false;
                }
            } else {
                char tmp = stack.peek();
                if(tmp == '(' && chr == ')') {
                    stack.pop();
                } else if(tmp == '[' && chr == ']') {
                    stack.pop();
                } else if(tmp == '{' && chr == '}') {
                    stack.pop();
                } else {
                    stack.push(chr);
                }
            }
        }

        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}