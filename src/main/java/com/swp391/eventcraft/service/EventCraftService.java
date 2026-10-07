package com.swp391.eventcraft.service;

import java.util.regex.Pattern;

/**
 * Service chứa 3 hàm nghiệp vụ cốt lõi để kiểm thử tự động với TestNG:
 * 1. authenticate(username, password) : Xác thực đăng nhập
 * 2. isValidEmail(email)              : Kiểm tra định dạng email
 * 3. isValidPhoneNumber(phone)        : Kiểm tra định dạng số điện thoại Việt Nam
 */
public class EventCraftService {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    // Số điện thoại Việt Nam: Bắt đầu bằng 0, theo sau là 9 chữ số (tổng 10 số)
    private static final String PHONE_REGEX = "^0[35789]\\d{8}$";
    private static final Pattern PHONE_PATTERN = Pattern.compile(PHONE_REGEX);

    // =========================================================================
    // HÀM 1: XÁC THỰC ĐĂNG NHẬP (AUTHENTICATION)
    // =========================================================================
    /**
     * Xác thực thông tin đăng nhập của người dùng.
     * @param username Tên đăng nhập
     * @param password Mật khẩu
     * @return true nếu đúng tài khoản hợp lệ, ngược lại false
     */
    public boolean authenticate(String username, String password) {
        if (username == null || username.trim().isEmpty()) {
            return false;
        }
        if (password == null || password.trim().isEmpty()) {
            return false;
        }
        // Giả lập tài khoản quản trị viên và người dùng chuẩn trong hệ thống
        return ("admin".equals(username) && "Admin@123".equals(password))
            || ("user_demo".equals(username) && "EventCraft@2026".equals(password));
    }

    // =========================================================================
    // HÀM 2: KIỂM TRA ĐỊNH DẠNG EMAIL
    // =========================================================================
    /**
     * Kiểm tra email có hợp lệ hay không.
     * @param email Địa chỉ email
     * @return true nếu hợp lệ, ngược lại false
     */
    public boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email.trim()).matches();
    }

    // =========================================================================
    // HÀM 3: KIỂM TRA SỐ ĐIỆN THOẠI VIỆT NAM
    // =========================================================================
    /**
     * Kiểm tra số điện thoại (10 chữ số, bắt đầu bằng 03, 05, 07, 08, 09).
     * @param phone Số điện thoại cần kiểm tra
     * @return true nếu đúng 10 số hợp lệ, ngược lại false
     */
    public boolean isValidPhoneNumber(String phone) {
        if (phone == null || phone.trim().isEmpty()) {
            return false;
        }
        return PHONE_PATTERN.matcher(phone.trim()).matches();
    }
}
