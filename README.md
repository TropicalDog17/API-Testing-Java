# test-automation
A desperate attempt to do the OOP assignment alone.
# Mô tả
*Cách chạy chương trình(IntelliJ)*: Build project(Ctrl+F9), Chạy project(Shift+F10)
- Đầu tiên, user lựa chọn link base URL cho API(default là https://auctions-app-2.herokuapp.com/api/)
- Sau đó, với base URL tương ứng, user sẽ chọn ra endpoint URL cần thực hiện kiểm thử
- Với mỗi endpoint URL cần kiểm thử, user sẽ có các lựa chọn: Chạy toàn bộ các test case. hoặc là chọn 1 trong các test case của test suite để chạy
- Kết quả trả về sẽ là test thành công hoặc thất bại
# Technology
Jva: JDK 17, Junit 5.8.1, JUnit Jupiter 5.8.1, Unirest 3.11.9, Unirest Object Mapper Gson 3.13.10
**IDE**: IntelliJ IDEA 2021.3.3
# Folder structure
## src/main/java 
Contain all java source code, divided to 2 modules
### src/main/java/test-data
Test to be run by main method
### src/main/java/utils
Some utilities class for ease of development
- **Constant.java**
Chứa các biến hằng để sử dụng trong các file khác
- **Response.java**
Chứa các class mô phỏng kiểu dữ liệu trả về của API. 
Dùng GSON Object Mapper chuyển đổi các file JSON thành các object có cấu trức dữ liệu được định nghĩa ở class Response
![image](https://user-images.githubusercontent.com/79791913/173883554-07724269-2bf3-433b-859e-1130eb8c3a1d.png)
*Biểu đồ lớp UML*

### src/main/java/Main.java
Contains main method
