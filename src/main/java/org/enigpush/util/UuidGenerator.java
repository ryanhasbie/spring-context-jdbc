package org.enigpush.util;

import java.util.UUID;

public class UuidGenerator implements IRandomStringGenerator{
    @Override
    public String random() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
