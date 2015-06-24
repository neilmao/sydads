package com.sydads.data.model;

/**
 * Created with IntelliJ IDEA.
 * User: neilmao
 * Date: 12/05/15
 */
public enum UserStatus {

    WaitingVerify,
    Verified,
    Blocked,
    Deleted;

    public static boolean isActive(UserStatus status) {
         switch (status) {
             case WaitingVerify:
             case Verified:
                 return true;
             case Blocked:
             case Deleted:
             default:
                 return false;
         }
    }
}
