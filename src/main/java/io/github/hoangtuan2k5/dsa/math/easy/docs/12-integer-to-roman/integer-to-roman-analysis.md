# Integer to Roman (Số Nguyên sang Số La Mã)

## Mô tả bài toán

Cho một số nguyên, hãy chuyển đổi nó thành số La Mã tương ứng.

Số La Mã được biểu diễn bởi bảy ký hiệu khác nhau:

| Ký hiệu | Giá trị |
|---------|---------|
| I       | 1       |
| V       | 5       |
| X       | 10      |
| L       | 50      |
| C       | 100     |
| D       | 500     |
| M       | 1000    |

Số La Mã thông thường được viết từ lớn nhất đến nhỏ nhất từ trái sang phải. Tuy nhiên, có một số trường hợp đặc biệt:
- IV biểu thị cho 4 (5 - 1)
- IX biểu thị cho 9 (10 - 1)
- XL biểu thị cho 40 (50 - 10)
- XC biểu thị cho 90 (100 - 10)
- CD biểu thị cho 400 (500 - 100)
- CM biểu thị cho 900 (1000 - 100)

## Ví dụ

**Ví dụ 1:**
```
Input: num = 3
Output: "III"
```

**Ví dụ 2:**
```
Input: num = 58
Output: "LVIII"
Giải thích: L = 50, V = 5, III = 3
```

**Ví dụ 3:**
```
Input: num = 1994
Output: "MCMXCIV"
Giải thích: M = 1000, CM = 900, XC = 90, IV = 4
```

## Ràng buộc

- 1 ≤ num ≤ 3999

## Phân tích bài toán

### Quy tắc biểu diễn số La Mã

Số La Mã tuân theo các quy tắc chuyển đổi cụ thể:
1. Nếu giá trị không bắt đầu bằng 4 hoặc 9, sử dụng ký hiệu lớn nhất có thể và trừ giá trị của nó
2. Nếu giá trị bắt đầu bằng 4 hoặc 9, sử dụng ký hiệu trừ (ví dụ: IV cho 4, IX cho 9)
3. Chỉ những hình thức trừ này là hợp lệ: IV (4), IX (9), XL (40), XC (90), CD (400), CM (900)
4. Lũy thừa của 10 (I, X, C, M) có thể được lặp lại tối đa 3 lần
5. Các ký hiệu V, L và D không thể được lặp lại

### Chiến lược giải quyết

Để chuyển đổi một số nguyên sang số La Mã, chúng ta có thể sử dụng phương pháp "tham lam" (greedy approach):

1. Lập danh sách các cặp giá trị và ký hiệu tương ứng, sắp xếp theo thứ tự giảm dần
2. Lặp qua danh sách và kiểm tra liên tục:
   - Nếu số hiện tại lớn hơn hoặc bằng giá trị của ký hiệu đang xét, thêm ký hiệu vào kết quả
   - Trừ giá trị tương ứng khỏi số hiện tại
   - Tiếp tục kiểm tra ký hiệu hiện tại cho đến khi số nhỏ hơn giá trị của ký hiệu
3. Chuyển sang ký hiệu tiếp theo và lặp lại quy trình trên
4. Kết thúc khi số ban đầu giảm về 0

## Giải pháp

### Cách tiếp cận #1: Sử dụng phương pháp giảm dần với vòng lặp while

Phương pháp này sử dụng một loạt các vòng lặp while để kiểm tra liên tục mỗi giá trị La Mã (từ lớn nhất đến nhỏ nhất). Mỗi lần tìm thấy một giá trị phù hợp, chúng ta thêm ký hiệu tương ứng vào kết quả và trừ giá trị đó từ số đầu vào.

```java
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
    
    // ...và tương tự cho các giá trị khác...
    
    return result.toString();
}
```

Đây là cách tiếp cận đơn giản và dễ hiểu, nhưng có nhiều mã lặp lại.

### Cách tiếp cận #2: Sử dụng mảng và vòng lặp

Để cải thiện cách tiếp cận #1, chúng ta có thể sử dụng hai mảng để lưu trữ các giá trị và ký hiệu La Mã tương ứng, sau đó dùng một vòng lặp duy nhất để xử lý.

```java
public String intToRoman(int num) {
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    
    StringBuilder result = new StringBuilder();
    
    for (int i = 0; i < values.length; i++) {
        while (num >= values[i]) {
            result.append(symbols[i]);
            num -= values[i];
        }
    }
    
    return result.toString();
}
```

Cách tiếp cận này có cùng độ phức tạp thời gian nhưng mã nguồn ngắn gọn và dễ bảo trì hơn.

### Cách tiếp cận #3: Sử dụng kỹ thuật bảng tra cứu trực tiếp

Nếu chúng ta biết rằng số đầu vào giới hạn trong khoảng từ 1 đến 3999, chúng ta có thể sử dụng một bảng tra cứu trực tiếp cho mỗi chữ số (đơn vị, chục, trăm, nghìn) của số.

```java
public String intToRoman(int num) {
    String[] thousands = {"", "M", "MM", "MMM"};
    String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    
    return thousands[num / 1000] + 
           hundreds[(num % 1000) / 100] + 
           tens[(num % 100) / 10] + 
           ones[num % 10];
}
```

Cách tiếp cận này có độ phức tạp thời gian là O(1) vì không phụ thuộc vào kích thước của đầu vào, và đặc biệt hiệu quả cho các số lớn.

## So sánh các cách tiếp cận

| Cách tiếp cận | Độ phức tạp thời gian | Độ phức tạp không gian | Ưu điểm | Nhược điểm |
|---------------|----------------------|------------------------|---------|-----------|
| #1: Vòng lặp while | O(1) | O(1) | Đơn giản, dễ hiểu | Mã lặp lại, dài dòng |
| #2: Mảng và vòng lặp | O(1) | O(1) | Ngắn gọn, dễ bảo trì | Phải khởi tạo mảng |
| #3: Bảng tra cứu | O(1) | O(1) | Nhanh nhất cho khoảng 1-3999 | Chỉ hoạt động với khoảng số giới hạn |

## Cài đặt chi tiết

Trong bài toán này, chúng ta đã triển khai cách tiếp cận #1 sử dụng các vòng lặp while. Thuật toán hoạt động bằng cách kiểm tra và xử lý lần lượt từng giá trị số La Mã có thể từ lớn nhất đến nhỏ nhất.

### Ví dụ thực thi thuật toán

Để hiểu rõ hơn cách thuật toán hoạt động, hãy xem cách nó chuyển đổi số 1994 thành số La Mã:

1. Bắt đầu: num = 1994, result = ""
2. 1994 >= 1000: result = "M", num = 994
3. 994 >= 900: result = "MCM", num = 94
4. 94 >= 90: result = "MCMXC", num = 4
5. 4 >= 4: result = "MCMXCIV", num = 0
6. Kết quả cuối cùng: "MCMXCIV"

## Độ phức tạp

- **Độ phức tạp thời gian**: O(1)
  - Mặc dù có nhiều vòng lặp, nhưng số lượng lặp tối đa cho mỗi giá trị bị giới hạn bởi số đầu vào (<=3999)
  - Trong trường hợp tệ nhất, thuật toán phải thực hiện khoảng 15 lần lặp với số 3999

- **Độ phức tạp không gian**: O(1)
  - Chúng ta chỉ sử dụng một StringBuilder để lưu trữ kết quả, kích thước của nó bị giới hạn bởi độ dài tối đa của số La Mã (khoảng 15 ký tự trong trường hợp tệ nhất)

## Kết luận

Bài toán chuyển đổi số nguyên thành số La Mã là một bài toán kinh điển và có nhiều ứng dụng thực tế. Mặc dù cách tiếp cận #1 không phải là giải pháp ngắn gọn nhất, nhưng nó dễ hiểu và hiệu quả cho khoảng số giới hạn (1-3999).

Việc sử dụng phương pháp tham lam, kiểm tra các giá trị từ lớn nhất đến nhỏ nhất, là một chiến lược hiệu quả để giải quyết bài toán này. Các cách tiếp cận khác có thể được xem xét nếu cần tối ưu hóa về mặt mã nguồn hoặc hiệu suất.

