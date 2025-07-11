package com.sun.mianshi.constant;

public interface RedisConstant {
    /*
    * 用户签到记录额Redis key前缀
    * */
    String USER_SIGN_IN_REDIS_KEY_PREFIX = "user:signins";
    /**
     * 获取用户签到记录的 Redis Key
     * @param year 年份
     * @param userId 用户 id
     * @return 拼接好的 Redis Key
     */
    static String getUserSignInRedisKey(int year, long userId) {
        return String.format("%s:%s:%s", USER_SIGN_IN_REDIS_KEY_PREFIX, year, userId);
    }

}
