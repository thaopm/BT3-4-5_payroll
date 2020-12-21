Source code Khóa Clean Code bài tập buổi 3, 4, 5: Phần mềm tính lương Payroll

Cấu trúc thư mục src\main:

│\
├───java\
│&nbsp;&nbsp;├───com\
│&nbsp;&nbsp;│&nbsp;&nbsp;└───pmt\
│&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp; └───payroll\
│&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  │&nbsp;&nbsp;PayrollAppApplication.java\
│&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  │\
│&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  ├───controller\
│&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  │&nbsp;&nbsp;&nbsp;&nbsp; ErrorController.java&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   Controller xử lý hiển thị trang lỗi\
│&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  │&nbsp;&nbsp;&nbsp;&nbsp; PayrollController.java&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Controller xử lý hiển thị danh sách nhân viên\
│&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  │\
│&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  ├───model\
│&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  │&nbsp;&nbsp;&nbsp;&nbsp; Employee.java&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Class định nghĩa đối tượng nhân viên\
│&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  │\
│&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  ├───repository\
│&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  │&nbsp;&nbsp;&nbsp;&nbsp; EmployeeRepository.java&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Repository làm việc với data source (đọc, ghi,...)\
│&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  │\
│&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  ├───service\
│&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  │&nbsp;&nbsp;&nbsp;&nbsp; EmployeeService.java&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   Service làm nhiệm vụ xử lý logic (tính toán, format,...)\
│&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  │\
│&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  └───util\
│&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; DateUtil.java&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;DateUtil dùng để định nghĩa các đối tượng dùng chung cho xử lý ngày tháng
│&nbsp;&nbsp;\
│&nbsp;&nbsp;│\
│&nbsp;&nbsp;└───META-INF\
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  MANIFEST.MF\
│\
└───resources\
&nbsp;&nbsp; │&nbsp;&nbsp;application.properties\
&nbsp;&nbsp; │\
&nbsp;&nbsp; ├───data\
&nbsp;&nbsp; │&nbsp;&nbsp;&nbsp;&nbsp; employee.csv\
&nbsp;&nbsp; │\
&nbsp;&nbsp; └───templates\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;employees.html\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;error.html

            
**Tiến độ:**\
Đã xong phiên bản 1.0:\
&nbsp;&nbsp;&nbsp;&nbsp;1. Đọc danh sách nhân viên từ file CSV\
&nbsp;&nbsp;&nbsp;&nbsp;2. In ra màn hình: tuổi, số năm và tháng làm việc\
&nbsp;&nbsp;&nbsp;&nbsp;3. Tạo công thức tính lương và tính lương tới thời điểm hiện tại
