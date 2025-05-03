package io.github.hoangtuan2k5.dsa.array.easy.src;

/**
 * Tổng Hai Số (Two Sum)
 * <p>
 * Cho một mảng các số nguyên nums và một số nguyên target, phương thức này trả về chỉ số
 * của hai số trong mảng có tổng bằng target.
 * </p>
 * 
 * <p>
 * <b>Ví dụ:</b>
 * <table summary="Examples of Two Sum">
 *   <tr><th>Đầu vào</th><th>Kết quả</th></tr>
 *   <tr><td>nums = [2,7,11,15], target = 9</td><td>[0,1]</td></tr>
 *   <tr><td>nums = [3,2,4], target = 6</td><td>[1,2]</td></tr>
 *   <tr><td>nums = [3,3], target = 6</td><td>[0,1]</td></tr>
 * </table>
 * </p>
 * 
 * <p>
 * Ràng buộc của bài toán:
 * <ul>
 * <li>Mỗi đầu vào chỉ có đúng một lời giải</li>
 * <li>Không được sử dụng cùng một phần tử hai lần</li>
 * <li>Mảng có ít nhất 2 phần tử và nhiều nhất là 10^4 phần tử</li>
 * <li>Các phần tử trong mảng có thể trong khoảng từ -10^9 đến 10^9</li>
 * <li>Target có thể trong khoảng từ -10^9 đến 10^9</li>
 * </ul>
 * </p>
 * 
 * <p>
 * <b>Cách tiếp cận:</b> Sử dụng vòng lặp lồng nhau (nested loop) để kiểm tra từng cặp phần tử.
 * Giải thuật sẽ kiểm tra tất cả các cặp phần tử có thể và trả về chỉ số của cặp đầu tiên có tổng bằng target.
 * </p>
 * 
 * <hr>
 * 
 * @param nums   Mảng các số nguyên
 * @param target Tổng cần tìm
 * @return Một mảng gồm hai số nguyên biểu thị chỉ số của hai số có tổng bằng target
 * @author hoangtuan2k5
 * @see <a href="https://leetcode.com/problems/two-sum">LeetCode Problem 1: Two Sum</a>
 * <div id="complexity"></div>
 * <p>
 * Độ phức tạp thời gian: O(n^2) với n là độ dài của mảng
 * </p>
 * <p>
 * Độ phức tạp không gian: O(1) vì chỉ sử dụng không gian bổ sung cố định
 * </p>
 */

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for(int i=1;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(nums[j]+nums[j-i]==target){
                    return new int[]{j-i,j};}
            }
        }
        return new int[]{};
    }
}