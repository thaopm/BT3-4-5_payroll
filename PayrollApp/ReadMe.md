Source code Khóa Clean Code bài tập buổi 3, 4, 5: Phần mềm tính lương Payroll

Cấu trúc thư mục src\main:

+---java
|   +---com
|   |   \---pmt
|   |       \---payroll
|   |           |   PayrollAppApplication.java
|   |           |   
|   |           +---controller
|   |           |       ErrorController.java            Controller xử lý hiển thị trang lỗi
|   |           |       PayrollController.java          Controller xử lý hiển thị danh sách employee
|   |           |       
|   |           +---model
|   |           |       Employee.java                   Class định nghĩa đối tượng Employee
|   |           |       
|   |           +---repository
|   |           |       EmployeeRepository.java         Repository làm nhiệm vụ xử lý data (đọc, ghi,...)
|   |           |       
|   |           +---service
|   |           |       EmployeeService.java            Service làm nhiệm vụ xử lý logic (tính toán, format,...)
|   |           |       
|   |           \---util
|   |                   DateUtil.java                   DateUtil dùng để định nghĩa các đối tượng dùng chung cho xử lý ngày tháng
|   |                   
|   \---META-INF
|           MANIFEST.MF
|           
\---resources
    |   application.properties
    |   
    +---data
    |       employee.csv
    |       
    \---templates
            employees.html
            error.html
            
Tiến độ:
    Đã xong phiên bản 1.0:
        1. Đọc danh sách nhân viên từ file CSV
        2. In ra màn hình: tuổi, số năm và tháng làm việc
        3. Tạo công thức tính lương và tính lương tới thời điểm hiện tại
