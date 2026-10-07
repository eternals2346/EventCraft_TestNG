# EventCraft TestNG Automation & CI Pipeline

[![EventCraft TestNG CI Pipeline](https://github.com/user_demo/EventCraft_TestNG_Demo/actions/workflows/maven.yml/badge.svg)](https://github.com/user_demo/EventCraft_TestNG_Demo/actions)
![Java](https://img.shields.io/badge/Java-17%20LTS-orange.svg)
![TestNG](https://img.shields.io/badge/TestNG-7.8.0-blue.svg)
![Coverage](https://img.shields.io/badge/Tests-20%2F20%20Passed-brightgreen.svg)
![Build](https://img.shields.io/badge/Build-Maven%203.9-success.svg)

> **SWT301 - Lab 2 Exercise 3 | FPT University**  
> Dự án kiểm thử tự động áp dụng TestNG Framework và triển khai CI Pipeline (GitHub Actions) cho hệ thống **EventCraft** (SWP391).

---

## 📌 Các Thành Phần Đã Triển Khai
1. **3 Hàm Nghiệp Vụ Trọng Yếu (`EventCraftService.java`)**:
   - `authenticate(String username, String password)`: Xác thực tài khoản quản trị và khách hàng.
   - `isValidEmail(String email)`: Kiểm tra định dạng email theo RFC standard.
   - `isValidPhoneNumber(String phone)`: Kiểm tra số điện thoại liên lạc Việt Nam (10 chữ số, đầu số hợp lệ).
2. **20 Unit Test Cases Chuẩn Báo Cáo FPT Report 5**:
   - Phân loại rõ ràng: 7 Normal, 11 Abnormal, 2 Boundary.
   - Áp dụng Data-Driven Testing với `@DataProvider`.
   - Tách thành 3 Test Classes độc lập (`AuthenticationTest`, `EmailValidationTest`, `PhoneValidationTest`).
3. **Continuous Integration (CI) với GitHub Actions**:
   - File cấu hình: `.github/workflows/maven.yml`
   - Tự động kích hoạt khi có sự kiện `push` hoặc `pull_request` trên các nhánh `main`, `master`, `dev`.
   - Chạy trên môi trường ảo Ubuntu với JDK 17 (Temurin) và tự động xuất artifact kết quả kiểm thử.

---

## 🚀 Hướng Dẫn Chạy Kiểm Thử Local
```bash
# Sử dụng Maven Wrapper có sẵn trong dự án:
.\mvnw.cmd clean test

# Hoặc sử dụng Maven cài đặt trên máy:
mvn clean test
```
Toàn bộ 20 test cases sẽ chạy song song đa luồng thông qua file `testng.xml`.
Báo cáo kết quả chi tiết xem tại `target/surefire-reports/index.html`.
