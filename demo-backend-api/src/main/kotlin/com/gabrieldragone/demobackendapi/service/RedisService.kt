package com.gabrieldragone.demobackendapi.service

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit

@Service
class RedisService(private val redisTemplate: RedisTemplate<String, String>) {

    fun tryLock(key: String, timeoutMinutes: Long): Boolean {
        val lockKey = "RESERVATION-$key"
        val isLocked = redisTemplate.opsForValue().setIfAbsent(lockKey, "locked")
        if (isLocked != null && isLocked) {
            redisTemplate.expire(lockKey, timeoutMinutes, TimeUnit.MINUTES)
        }
        return isLocked != null && isLocked
    }

    fun releaseLock(key: String) {
        val lockKey = "RESERVATION-$key"
        redisTemplate.delete(lockKey)
    }

}