package com.swp391.eventcraft.service;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Kiểm thử chức năng 2: Kiểm tra định dạng Email (isValidEmail)
 * Áp dụng kỹ thuật: Data-Driven Testing (DDT) với @DataProvider của TestNG
 */
public class EmailValidationTest {

    private EventCraftService service;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        service = new EventCraftService();
    }

    @DataProvider(name = "emailDataProvider")
    public Object[][] provideEmailData() {
        return new Object[][]{
                {"student@fpt.edu.vn",   true},  // UTCID01: Email sinh viên chuẩn FPT (Normal)
                {"admin@eventcraft.com", true},  // UTCID02: Email công ty chuẩn (Normal)
                {"user.gmail.com",       false}, // UTCID03: Thiếu ký tự @ (Abnormal)
                {"user@",                false}, // UTCID04: Thiếu domain sau @ (Abnormal)
                {"",                     false}, // UTCID05: Chuỗi rỗng (Abnormal)
                {null,                   false}  // UTCID06: Giá trị null (Abnormal)
        };
    }

    @Test(dataProvider = "emailDataProvider", groups = {"validation", "smoke"},
          description = "Kiểm thử hàm isValidEmail với 6 bộ dữ liệu DDT")
    public void testIsValidEmail(String email, boolean expected) {
        boolean actual = service.isValidEmail(email);
        Assert.assertEquals(actual, expected, "Lỗi kiểm tra email: " + email);
    }
}
