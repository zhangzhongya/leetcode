package problems;
import java.util.List;
import java.util.ArrayList;
/*题目描述
 * 给定一个整数 n, 返回从 1 到 n 的字典顺序。
*例如，
*给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
*请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
 */

//解题思路：trie树，也就是使用字典树的思想来，对每个小于等于n的树进行字典树的前序遍历
public class q386_字典序排数 {
	public List<Integer> list = new ArrayList();
    public List<Integer> lexicalOrder(int n) {
        for(int i=1;i<10&&i<=n;i++)
            lexical(i, n);
        return list;
    }
    
    public void lexical(int num, int n){
        list.add(num);
        num *= 10;
        for(int i=0;i<=9;i++){
            if(num<=n){
                lexical(num, n);
                num++;
            }else{
                break;
            }  
        }
        return ;
    }
}
