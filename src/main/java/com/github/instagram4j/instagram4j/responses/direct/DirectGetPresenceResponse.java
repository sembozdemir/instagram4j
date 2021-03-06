package com.github.instagram4j.instagram4j.responses.direct;

import java.util.Map;

import com.github.instagram4j.instagram4j.responses.IGResponse;

import lombok.Data;

@Data
public class DirectGetPresenceResponse extends IGResponse {
    private Map<Long, UserPresence> user_presence;
    
    @Data
    public static class UserPresence {
        private boolean is_active;
        private long last_activity_at_ms;
    }
}
