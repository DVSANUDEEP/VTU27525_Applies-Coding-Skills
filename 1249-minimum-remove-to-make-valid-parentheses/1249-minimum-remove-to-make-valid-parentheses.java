class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack <Integer> st =new Stack <>();
        boolean[] rem =new boolean [s.length()];
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='(')
           st.push(i);
            else if (s.charAt(i)==')'){
                if (st.isEmpty())
                rem [i]=true;
                else
                st.pop();
            }
        }
        while (!st.isEmpty())
        rem [st.pop()] = true;
        StringBuilder ans = new StringBuilder();
        for (int i=0;i<s.length();i++)
        {
            if (!rem[i])
            ans.append(s.charAt(i));
        }
        return ans.toString ();
    }
}