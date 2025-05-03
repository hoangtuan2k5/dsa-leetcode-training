package io.github.hoangtuan2k5.dsa.math.easy.src;

/**
 * Số Nguyên sang Số La Mã (Integer to Roman)
 * <p>
 * Cho một số nguyên, phương thức này chuyển đổi nó sang số La Mã.
 * </p>
 * 
 * <p>
 * Số La Mã được biểu diễn bởi bảy ký hiệu khác nhau:
 * <table summary="Roman Numerals and their values">
 *   <tr><th>Ký hiệu</th><th>Giá trị</th></tr>
 *   <tr><td>I</td><td>1</td></tr>
 *   <tr><td>V</td><td>5</td></tr>
 *   <tr><td>X</td><td>10</td></tr>
 *   <tr><td>L</td><td>50</td></tr>
 *   <tr><td>C</td><td>100</td></tr>
 *   <tr><td>D</td><td>500</td></tr>
 *   <tr><td>M</td><td>1000</td></tr>
 * </table>
 * </p>
 * 
 * <p>
 * <b>Ví dụ:</b>
 * <table summary="Examples of Integer to Roman conversion">
 *   <tr><th>Đầu vào</th><th>Kết quả</th></tr>
 *   <tr><td>num = 3</td><td>"III"</td></tr>
 *   <tr><td>num = 58</td><td>"LVIII"</td></tr>
 *   <tr><td>num = 1994</td><td>"MCMXCIV"</td></tr>
 * </table>
 * </p>
 * 
 * <p>
 * Số La Mã tuân theo các quy tắc chuyển đổi cụ thể:
 * <ul>
 * <li>Nếu giá trị không bắt đầu bằng 4 hoặc 9, sử dụng ký hiệu lớn nhất có thể và trừ giá trị của nó</li>
 * <li>Nếu giá trị bắt đầu bằng 4 hoặc 9, sử dụng ký hiệu trừ (ví dụ: IV cho 4, IX cho 9)</li>
 * <li>Chỉ những hình thức trừ này là hợp lệ: IV (4), IX (9), XL (40), XC (90), CD (400), CM (900)</li>
 * <li>Lũy thừa của 10 (I, X, C, M) có thể được lặp lại tối đa 3 lần</li>
 * <li>Các ký hiệu V, L và D không thể được lặp lại</li>
 * </ul>
 * </p>
 * 
 * <p>
 * Ràng buộc bài toán:
 * <ul>
 * <li>Số nguyên đầu vào nằm trong khoảng từ 1 đến 3999, bao gồm cả hai số</li>
 * </ul>
 * </p>
 * 
 * <p>
 * <b>Cách tiếp cận:</b> Sử dụng phương pháp giảm dần (greedy approach), bắt đầu từ các ký hiệu La Mã lớn nhất
 * và tiếp tục trừ giá trị từ số đầu vào cho đến khi số đó bằng 0.
 * </p>
 * 
 * <p>
 * <b>Giải thích thuật toán:</b> Thuật toán kiểm tra lần lượt các giá trị Roman từ lớn đến nhỏ (1000, 900, 500, 400...)
 * và thêm ký hiệu tương ứng vào kết quả, đồng thời trừ giá trị đó từ số đầu vào. Quá trình này được lặp lại cho 
 * đến khi số đầu vào giảm về 0.
 * </p>
 * 
 * <p>
 * <b>Ví dụ thực thi thuật toán:</b> Chuyển đổi số 1994 thành số La Mã:
 * <ol>
 * <li>Bắt đầu: num = 1994, result = ""</li>
 * <li>1994 >= 1000: result = "M", num = 994</li>
 * <li>994 >= 900: result = "MCM", num = 94</li>
 * <li>94 >= 90: result = "MCMXC", num = 4</li>
 * <li>4 >= 4: result = "MCMXCIV", num = 0</li>
 * <li>Kết quả cuối cùng: "MCMXCIV"</li>
 * </ol>
 * </p>
 *
 * <hr>
 * 
 * @author hoangtuan2k5
 * @see <a href="https://leetcode.com/problems/integer-to-roman/">LeetCode Problem 12: Integer to Roman</a>
 * @see <a href="#complexity">Độ phức tạp</a>
 * <div id="complexity"></div>
 * <p>
 * Độ phức tạp thời gian: O(1) vì có một tập hữu hạn các chữ số La Mã và số đầu vào bị giới hạn đến 3999
 * </p>
 * <p>
 * Độ phức tạp không gian: O(1) vì kích thước đầu ra bị giới hạn
 * </p>
 */
public class IntegerToRoman {
    /**
     * Chuyển đổi một số nguyên thành biểu diễn số La Mã.
     *
     * @param num Số nguyên cần chuyển đổi sang số La Mã (giả định trong khoảng 1-3999)
     * @return Biểu diễn số La Mã của số nguyên đầu vào
     */
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        
        while (num >= 1000) {
            result.append("M");
            num -= 1000;
        }
        
        while (num >= 900) {
            result.append("CM");
            num -= 900;
        }
        
        while (num >= 500) {
            result.append("D");
            num -= 500;
        }
        
        while (num >= 400) {
            result.append("CD");
            num -= 400;
        }
        
        while (num >= 100) {
            result.append("C");
            num -= 100;
        }
        
        while (num >= 90) {
            result.append("XC");
            num -= 90;
        }
        
        while (num >= 50) {
            result.append("L");
            num -= 50;
        }
        
        while (num >= 40) {
            result.append("XL");
            num -= 40;
        }
        
        while (num >= 10) {
            result.append("X");
            num -= 10;
        }
        
        while (num >= 9) {
            result.append("IX");
            num -= 9;
        }
        
        while (num >= 5) {
            result.append("V");
            num -= 5;
        }
        
        while (num >= 4) {
            result.append("IV");
            num -= 4;
        }
        
        while (num >= 1) {
            result.append("I");
            num -= 1;
        }
        
        return result.toString();
    }
}