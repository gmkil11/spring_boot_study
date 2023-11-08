package org.korit.schedules;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j // log 매서드 사용 가능 -> log.info log.error log.warn
@Service
public class PostStat {

//    @Scheduled(cron="0 0 1 * * *") // 새벽 한 시 마다 실행된다.
//    @Scheduled(fixedDelay = 5, timeUnit = TimeUnit.SECONDS) // 5초 고정 간격 마다
//    @Scheduled(initialDelay = 5, timeUnit = TimeUnit.SECONDS) // 작업 시작 전 5초 대기
    public void process() {
        log.info("게시글 통계 작업 수행...");
    }
}