package com.swp391.eventcraft.service;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Kiểm thử chức năng 3: Kiểm tra định dạng số điện thoại Việt Nam (isValidPhoneNumber)
 * Áp dụng kỹ thuật: Data-Driven Testing (DDT) với @DataProvider của TestNG
 */
public class PhoneValidationTest {

    private EventCraftService service;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        service = new EventCraftService();
    }

    @DataProvider(name = "phoneDataProvider")
    public Object[][] providePhoneData() {
        return new Object[][]{
                {"0901234567",  true},  // UTCID01: Đầu số Mobi 090 hợp lệ (Normal)
                {"0987654321",  true},  // UTCID02: Đầu số Viettel 098 hợp lệ (Normal)
                {"0888123456",  true},  // UTCID03: Đầu số Vina 088 hợp lệ (Normal)
                {"090123456",   false}, // UTCID04: Thiếu số - 9 chữ số (Boundary)
                {"09012345678", false}, // UTCID05: Thừa số - 11 chữ số (Boundary)
                {"1901234567",  false}, // UTCID06: Không bắt đầu bằng 0 (Abnormal)
                {"090123abcd",  false}, // UTCID07: Chứa ký tự chữ (Abnormal)
                {null,          false}  // UTCID08: Giá trị null (Abnormal)
        };
    }

    @Test(dataProvider = "phoneDataProvider", groups = {"validation", "regression"},
          description = "Kiểm thử hàm isValidPhoneNumber với 8 bộ dữ liệu DDT")
    public void testIsValidPhoneNumber(String phone, boolean expected) {
        boolean actual = service.isValidPhoneNumber(phone);
        Assert.assertEquals(actual, expected, "Lỗi kiểm tra số điện thoại: " + phone);
    }
}
