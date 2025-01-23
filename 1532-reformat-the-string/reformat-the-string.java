class Solution {
    public String reformat(String s) {
        Stack<Character> nums = new Stack<>();
		Stack<Character> letters = new Stack<>();
		for(int i = 0; i < s.length(); i++)
		{
			if(s.charAt(i) >= '0' && s.charAt(i) <= '9')
			{
				nums.push(s.charAt(i));
			}
			else
			{
				letters.push(s.charAt(i));
			}
		}
		if(Math.abs(nums.size() - letters.size()) >= 2)
		{
			return "";
		}
		StringBuffer sb = new StringBuffer();
		if(nums.size() > letters.size())
		{
			int n = nums.size();
			for(int i = 0; i < n; i++)
			{
				if(!nums.isEmpty())
				{
					sb.append(nums.peek());
					nums.pop();
				}
				if(!letters.isEmpty())
				{
					sb.append(letters.peek());
					letters.pop();
				}
			}
		}
		else
		{
			int n = letters.size();
			for(int i = 0; i < n; i++)
			{
				if(!letters.isEmpty())
				{
					sb.append(letters.peek());
					letters.pop();
				}
				if(!nums.isEmpty())
				{
					sb.append(nums.peek());
					nums.pop();
				}
			}
		}
        return sb.toString();
    }
}