# Two Sum - Phân tích Bài toán

## Mô tả Bài toán

Cho một mảng các số nguyên `nums` và một số nguyên `target`, trả về các chỉ số của hai số sao cho chúng cộng lại bằng `target`.

### Ràng buộc:
- Mỗi đầu vào có đúng một giải pháp
- Không thể sử dụng cùng một phần tử hai lần
- Mảng có ít nhất 2 phần tử và nhiều nhất 10^4 phần tử
- Các phần tử của mảng có thể từ -10^9 đến 10^9
- Target có thể từ -10^9 đến 10^9

## Cách triển khai hiện tại

Cách triển khai hiện tại sử dụng phương pháp vòng lặp lồng nhau:

```java
public int[] twoSum(int[] nums, int target) {
    for(int i=1; i<nums.length; i++) {
        for(int j=i; j<nums.length; j++) {
            if(nums[j]+nums[j-i]==target) {
                return new int[]{j-i,j};
            }
        }
    }
    return new int[]{};
}
```

### Phân tích phương pháp:

Cách triển khai này sử dụng một cấu trúc vòng lặp lồng nhau không điển hình với logic sau:
1. Vòng lặp ngoài sử dụng biến `i` để kiểm soát khoảng cách giữa các phần tử
2. Vòng lặp trong sử dụng biến `j` để lặp qua mảng
3. Mỗi lần lặp, nó kiểm tra xem `nums[j]` và `nums[j-i]` có tổng bằng target không
4. Nếu tìm thấy một cặp phù hợp, nó sẽ trả về các chỉ số `[j-i, j]`

## Phân tích Độ phức tạp

- **Độ phức tạp thời gian**: O(n²) trong trường hợp xấu nhất, với n là độ dài của mảng
  - Vòng lặp ngoài chạy n-1 lần
  - Vòng lặp trong chạy xấp xỉ n lần cho mỗi i
  - Điều này dẫn đến khoảng n² phép so sánh trong trường hợp xấu nhất

- **Độ phức tạp không gian**: O(1) - không gian bổ sung không đổi bất kể kích thước đầu vào
  - Chỉ có một số lượng biến cố định được sử dụng bất kể kích thước đầu vào
  - Mảng trả về có kích thước 2 được xem là không gian không đổi

## Cơ hội Tối ưu hóa

### 1. Giải pháp sử dụng Hash Map (Tối ưu)

Một phương pháp hiệu quả hơn sẽ sử dụng hash map để đạt được độ phức tạp thời gian O(n):

```java
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> numToIndex = new HashMap<>();
    
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (numToIndex.containsKey(complement)) {
            return new int[] {numToIndex.get(complement), i};
        }
        numToIndex.put(nums[i], i);
    }
    
    return new int[]{}; // Không tìm thấy giải pháp
}
```

**Lợi ích:**
- **Độ phức tạp thời gian**: O(n) - một lần duyệt qua mảng
- **Độ phức tạp không gian**: O(n) - để lưu trữ các phần tử trong hash map

### 2. Phương pháp Hai con trỏ (Cho Mảng đã sắp xếp)

Nếu mảng đã được sắp xếp (hoặc có thể sắp xếp mà không ảnh hưởng đến yêu cầu của bài toán):

```java
public int[] twoSum(int[] nums, int target) {
    // Lưu ý: Phương pháp này chỉ hoạt động nếu chúng ta có thể theo dõi chỉ số ban đầu
    int[][] numWithIndex = new int[nums.length][2];
    for (int i = 0; i < nums.length; i++) {
        numWithIndex[i][0] = nums[i];
        numWithIndex[i][1] = i;
    }
    
    Arrays.sort(numWithIndex, (a, b) -> Integer.compare(a[0], b[0]));
    
    int left = 0, right = nums.length - 1;
    while (left < right) {
        int sum = numWithIndex[left][0] + numWithIndex[right][0];
        if (sum == target) {
            return new int[] {numWithIndex[left][1], numWithIndex[right][1]};
        } else if (sum < target) {
            left++;
        } else {
            right--;
        }
    }
    
    return new int[]{};
}
```

## Các hiểu biết về thuật toán

Phương pháp hiện tại có những đặc điểm thú vị:
- Nó kiểm tra các cặp có khoảng cách tăng dần
- Nó đảm bảo tìm được giải pháp nếu một giải pháp tồn tại (theo ràng buộc bài toán)
- Cách triển khai này ngắn gọn nhưng không hiệu quả tối ưu

## Khuyến nghị

1. Đối với sử dụng trong môi trường sản xuất, triển khai giải pháp hash map để có độ phức tạp thời gian tối ưu
2. Nếu có ràng buộc nghiêm ngặt về bộ nhớ, hãy xem xét giải pháp O(n²) hiện tại hoặc phương pháp hai con trỏ
3. Giải pháp hash map là phương pháp tiêu chuẩn trong ngành cho bài toán này

## Các trường hợp biên cần xem xét

- Mảng chỉ có hai phần tử
- Số âm trong mảng
- Giá trị số nguyên lớn (gần -10^9 hoặc 10^9)
- Giá trị target bằng gấp đôi một giá trị trong mảng