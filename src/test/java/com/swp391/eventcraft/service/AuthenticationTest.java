package com.swp391.eventcraft.service;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Kiểm thử chức năng 1: Xác thực đăng nhập (authenticate)
 * Áp dụng kỹ thuật: Data-Driven Testing (DDT) với @DataProvider của TestNG
 */
public class AuthenticationTest {

    private EventCraftService service;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        service = new EventCraftService();
    }

    @DataProvider(name = "authDataProvider")
    public Object[][] provideAuthData() {
        return new Object[][]{
                // Username, Password, Kết quả mong đợi (Expected)
                {"admin",     "Admin@123",       true},  // UTCID01: Admin đúng -> true (Normal)
                {"user_demo", "EventCraft@2026", true},  // UTCID02: User đúng -> true (Normal)
                {"admin",     "SaiMatKhau",      false}, // UTCID03: Sai pass -> false (Abnormal)
                {"",          "Admin@123",       false}, // UTCID04: Username rỗng -> false (Abnormal)
                {"admin",     null,              false}, // UTCID05: Password null -> false (Abnormal)
                {null,        "Admin@123",       false}  // UTCID06: Username null -> false (Abnormal)
        };
    }

    @Test(dataProvider = "authDataProvider", groups = {"auth", "smoke"},
          description = "Kiểm thử hàm authenticate với 6 bộ dữ liệu DDT")
    public void testAuthenticate(String username, String password, boolean expected) {
        boolean actual = service.authenticate(username, password);
        Assert.assertEquals(actual, expected,
                String.format("Lỗi xác thực tại user='%s', pass='%s'", username, password));
    }
}
